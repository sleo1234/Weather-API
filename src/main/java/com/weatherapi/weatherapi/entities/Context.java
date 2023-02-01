package com.weatherapi.weatherapi.entities;

public class Context {

	String version;

	public Context() {
		super();
	}

	public Context(String version) {
		super();
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
