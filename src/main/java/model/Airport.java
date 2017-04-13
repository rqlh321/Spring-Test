package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airports")
public class Airport implements Serializable {
	public static final String AIRPORT_CODE="airport_code";
	public static final String AIRPORT_NAME="airport_name";
	public static final String CITY="city";
	public static final String LATITUDE="latitude";
	public static final String LONGITUDE="longitude";
	public static final String TIME_ZONE="timezone";
	
	@Id
	@Column (name="airport_code")
	private String code;
	
	@Column (name="airport_name")
	private String name;
	
	@Column (name="city")
	private String city;
	
	@Column (name="latitude")
	private Double lat;
	
	@Column (name="longitude")
	private Double lon;
	
	@Column (name="timezone")
	private String timeZone;
	
	public Airport(){}
	
	public Airport(String code,String name,String city,Double lat,Double lon,String timeZone){	
		this.code=code;
		this.name=name;
		this.city=city;
		this.lat=lat;
		this.lon=lon;
		this.timeZone=timeZone;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
