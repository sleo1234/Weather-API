package com.weatherapi.weatherapi.dto;

public class PeriodDto {

	public String name;
	public int temperatur;
	
	public PeriodDto(String name, int temperatur) {
		super();
		this.name = name;
		this.temperatur = temperatur;
	}
	public PeriodDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTemperatur() {
		return temperatur;
	}
	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}
	
}
