package hello;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.Transformers;

public class DAO {

	private SessionFactory sessionFactory;
	private static final int LIMIT=500; 
	
	public DAO(){
	 	Configuration configuration = new Configuration().configure();
    	ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
    	registry.applySettings(configuration.getProperties());
    	ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public List<?> getList(Class<?> model, String fields,Integer top,Integer limit){
		List<?> list;
	 	Session session = sessionFactory.openSession();
	 	
	 	Criteria criteria = session.createCriteria(model)
				.setFirstResult(top==null?0:top)
				.setMaxResults(limit==null?LIMIT:limit);
	 		 	
	 	if(fields!=null){
	 		ProjectionList prjection = Projections.projectionList();
	 		ClassMetadata classMetadata = sessionFactory.getClassMetadata(model);
	 		String[] propertyNames = classMetadata.getPropertyNames();
	 		List<String> tableList = Arrays.asList(propertyNames);
	 		
	 		for(String field:fields.split(",")){ 	 
	 			if(tableList.contains(field)){
	 				Projection projection=Projections.property(field);
	 				prjection.add(Projections.alias(projection, field));
	 			}
	 		}	
	 		
	 		criteria.setProjection(prjection)
	 			.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);	 		
	 	}
	 			
		list=criteria.list();
		session.close();
		return list;
	}
	
	public Object getObject(Class<?> model,String code){
		Object object;
	 	Session session = sessionFactory.openSession();
	 	object = session.get(model, code);	 
		session.close();
		return object;
	}
}
