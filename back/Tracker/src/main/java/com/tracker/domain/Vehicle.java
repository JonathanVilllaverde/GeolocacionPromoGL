package com.tracker.domain;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;



/**
 * 
 * @author matias.garcia
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({  
    @Type(value = Truck.class, name = "Truck"),  
    @Type(value = Car.class, name= "Car")
    })  
public abstract class Vehicle extends Trackeable {

	private String patente;
	
	public Vehicle(){
		super();
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}


}
