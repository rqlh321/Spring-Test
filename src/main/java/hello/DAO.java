package hello;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import model.Aircraft;
import model.Airport;

public class DAO {

	private SessionFactory sessionFactory;
	
	public DAO(){
	 	Configuration configuration = new Configuration().configure();
    	ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
    	registry.applySettings(configuration.getProperties());
    	ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public List<Aircraft> getAircrafts(){
		List<Aircraft> list;
	 	Session session = sessionFactory.openSession();
		list = session.createCriteria(Aircraft.class).list();
		session.close();
		return list;
	}
	
	public List<Airport> getAirports(){
		List<Airport> list;
	 	Session session = sessionFactory.openSession();
		list = session.createCriteria(Airport.class).list();
		session.close();
		return list;
	}
	
	public Aircraft getAircraft(String code){
		Aircraft aircraft;
	 	Session session = sessionFactory.openSession();
	 	aircraft = (Aircraft) session.get(Aircraft.class, code);
		session.close();
		return aircraft;
	}
}
