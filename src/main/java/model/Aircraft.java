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
	public static final String[] FIELDS={AIRCRAFT_CODE,MODEL,RANGE};
	@Id
	@Column (name=AIRCRAFT_CODE)
	private String aircraftCode;
	
	@Column (name=MODEL)
	private String model;
	
	@Column (name=RANGE)
	private Integer range;
	
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
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer range) {
		this.range = range;
	}

	
}
