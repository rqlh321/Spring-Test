package hello;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Aircraft;
import model.Airport;

@RestController
@RequestMapping("/rest")
public class MyRestController {
    private DAO dao=new DAO();
    
    @RequestMapping(path="/aircrafts",method = RequestMethod.GET)
    public List<Aircraft> getAircrafts() {
    	return dao.getAircrafts();       
    }
    @RequestMapping(path="/aircrafts/{code}",method = RequestMethod.GET)
    public Aircraft getAircraft(@PathVariable String code) {
    	return dao.getAircraft(code);       
    }
    @RequestMapping(path="/airports",method = RequestMethod.GET)
    public List<Airport> getAirports() {
    	return dao.getAirports();       
    }
}
