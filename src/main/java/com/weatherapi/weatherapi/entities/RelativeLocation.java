package com.weatherapi.weatherapi.entities;

public class RelativeLocation {
	public String type;
    public Geometry geometry;
    public Properties properties;
    
	public RelativeLocation(String type, Geometry geometry, Properties properties) {
		super();
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
	}

	public RelativeLocation() {
		super();
	}
    
    
}
