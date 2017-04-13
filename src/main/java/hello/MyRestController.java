package hello;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Aircraft;
import model.Airport;

@RestController
@RequestMapping("/rest")
public class MyRestController {
    private DAO dao=new DAO();
    
    @RequestMapping(path="/aircrafts",method = RequestMethod.GET)
    public List<?> getAircrafts(    		
    		@RequestParam(required = false) String fields,
    		@RequestParam(required = false) Integer top,
    		@RequestParam(required = false) Integer limit) {    
    	return dao.getList(Aircraft.class,fields,top,limit);       
    }
        
    @RequestMapping(path="/airports",method = RequestMethod.GET)
    public List<?> getAirports(    		
    		@RequestParam(required = false) String fields,
    		@RequestParam(required = false) Integer top,
    		@RequestParam(required = false) Integer limit) {    
    	return dao.getList(Airport.class,fields,top,limit);       
    }
    
    @RequestMapping(path="/aircrafts/{code}",method = RequestMethod.GET)
    public Object getAircraft(@PathVariable String code) {
    	return dao.getObject(Aircraft.class,code);       
    }
    
    @RequestMapping(path="/airports/{code}",method = RequestMethod.GET)
    public Object getAirport(@PathVariable String code) {
    	return dao.getObject(Airport.class,code);       
    }

}
