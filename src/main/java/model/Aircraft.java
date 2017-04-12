package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aircrafts")
public class Aircraft implements Serializable {
	public static final String AIRCRAFT_CODE="aircraft_code";
	public static final String MODEL="model";
	public static final String RANGE="range";

	@Id
	@Column (name="aircraft_code")
	private String aircraftCode;
	
	@Column (name="model")
	private String model;
	
	@Column (name="range")
	private int range;
	
	public Aircraft(){}
	
	public Aircraft(String aircraftCode,String model,int range){
		this.aircraftCode=aircraftCode;
		this.model=model;
		this.range=range;
	}
	
	public String getAircraftCode() {
		return aircraftCode;
	}
	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

	
}
