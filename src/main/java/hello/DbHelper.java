package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Aircraft;
import model.Airport;

public class DbHelper {
	Connection connection = null;
	
	public DbHelper(){
	      try {
	         Class.forName("org.postgresql.Driver");
	         Properties props = new Properties();	        
	         props.setProperty("user", "postgres");
	         props.setProperty("password", "");
	         
	         String url ="jdbc:postgresql://localhost:5432/demo";
	         connection = DriverManager.getConnection(url,props);
	         connection.setAutoCommit(true);
	         	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}

	public List<Aircraft> getAircrafts(){
		List<Aircraft> aircrafts=new ArrayList<Aircraft>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM AIRCRAFTS;" );		
	         while ( rs.next() ) {
	        	 Aircraft aircraft=new Aircraft(
	        			 rs.getString(Aircraft.AIRCRAFT_CODE),
	        			 rs.getString(Aircraft.MODEL),
	        			 rs.getInt(Aircraft.RANGE));
	        	 aircrafts.add(aircraft);      
	         }
	         rs.close();
	         stmt.close();    
		} catch (SQLException e) {			
			e.printStackTrace();
		}
       return aircrafts;
	}
	
	public Aircraft getAircraft(String code){
		Aircraft aircraft = null;
		try {
			Statement stmt = connection.createStatement();
			String query ="SELECT * FROM AIRCRAFTS WHERE " +Aircraft.AIRCRAFT_CODE+ " = "+ "'"+code+"'";
			ResultSet rs = stmt.executeQuery(query);		
	         if(rs.next()){
	        	 
			aircraft= new Aircraft(
	        			 rs.getString(Aircraft.AIRCRAFT_CODE),
	        			 rs.getString(Aircraft.MODEL),
	        			 rs.getInt(Aircraft.RANGE));
	         }
	         rs.close();
	         stmt.close();    
		} catch (SQLException e) {			
			e.printStackTrace();
		}
       return aircraft;
	}
	
	public List<Airport> getAirports(){
		List<Airport> airports=new ArrayList<Airport>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM AIRPORTS;" );		
	         while ( rs.next() ) {
	        	 Airport airport=new Airport(
	        			 rs.getString(Airport.AIRPORT_CODE),
	        			 rs.getString(Airport.AIRPORT_NAME),
	        			 rs.getString(Airport.CITY),
	        			 rs.getDouble(Airport.LATITUDE),
	        			 rs.getDouble(Airport.LONGITUDE),
	        			 rs.getString(Airport.TIME_ZONE));
	        	 airports.add(airport);      
	         }
	         rs.close();
	         stmt.close();    
		} catch (SQLException e) {			
			e.printStackTrace();
		}
       return airports;
	}
}
