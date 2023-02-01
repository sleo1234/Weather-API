package com.weatherapi.weatherapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import kotlin.jvm.internal.SerializedIr;

public class Root{
	
	@JsonProperty("@context")
    public Context context;
    public String id;
    public String type;
    public Geometry geometry;
    public Properties properties;
    
	public Root() {
		super();
	}
	public Root(Context context, String id, String type, Geometry geometry, Properties properties) {
		super();
		this.context = context;
		this.id = id;
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
    
    
}
