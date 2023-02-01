package com.weatherapi.weatherapi.entities;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Geometry{
    public String type;
    
    public ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates;
    //ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> 
	public Geometry() {
		super();
	}
	public Geometry(String type, ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + coordinates + "]";
	}

    
    
}