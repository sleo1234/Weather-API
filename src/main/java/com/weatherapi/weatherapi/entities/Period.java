package com.weatherapi.weatherapi.entities;

import java.util.Date;

public class Period{
    public int number;
    public String name;
    public Date startTime;
    public Date endTime;
    public boolean isDaytime;
    public int temperature;
    public String temperatureUnit;
    public Object temperatureTrend;
    public String windSpeed;
    public String windDirection;
    public String icon;
    public String shortForecast;
    public String detailedForecast;
    
    
	public Period() {
		super();
	}
	public Period(int number, String name, Date startTime, Date endTime, boolean isDaytime, int temperature,
			String temperatureUnit, Object temperatureTrend, String windSpeed, String windDirection, String icon,
			String shortForecast, String detailedForecast) {
		super();
		this.number = number;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isDaytime = isDaytime;
		this.temperature = temperature;
		this.temperatureUnit = temperatureUnit;
		this.temperatureTrend = temperatureTrend;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.icon = icon;
		this.shortForecast = shortForecast;
		this.detailedForecast = detailedForecast;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public boolean isDaytime() {
		return isDaytime;
	}
	public void setDaytime(boolean isDaytime) {
		this.isDaytime = isDaytime;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureUnit() {
		return temperatureUnit;
	}
	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
	public Object getTemperatureTrend() {
		return temperatureTrend;
	}
	public void setTemperatureTrend(Object temperatureTrend) {
		this.temperatureTrend = temperatureTrend;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	public String getDetailedForecast() {
		return detailedForecast;
	}
	public void setDetailedForecast(String detailedForecast) {
		this.detailedForecast = detailedForecast;
	}
	@Override
	public String toString() {
		return "Period [number=" + number + ", name=" + name + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", isDaytime=" + isDaytime + ", temperature=" + temperature + ", temperatureUnit=" + temperatureUnit
				+ ", temperatureTrend=" + temperatureTrend + ", windSpeed=" + windSpeed + ", windDirection="
				+ windDirection + ", icon=" + icon + ", shortForecast=" + shortForecast + ", detailedForecast="
				+ detailedForecast + "]";
	}
    
}
