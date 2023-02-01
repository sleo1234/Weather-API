package com.weatherapi.weatherapi.entities;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Properties{
	
	
	    public String urlId;
	
	    public String urlType;
	    public String id;
	    public String type;
	    public String name;
	    public Date effectiveDate;
	    public Date expirationDate;
	    public String state;
	    public ArrayList<String> cwa;
	    public ArrayList<String> forecastOffices;
	    public ArrayList<String> timeZone;
	    public ArrayList<String> observationStations;
	    public String radarStation;
	    
		public Properties() {
			super();
		}
		public Properties(String urlId, String urlType, String id, String type, String name, Date effectiveDate,
				Date expirationDate, String state, ArrayList<String> cwa, ArrayList<String> forecastOffices,
				ArrayList<String> timeZone, ArrayList<String> observationStations, String radarStation) {
			super();
			this.urlId = urlId;
			this.urlType = urlType;
			this.id = id;
			this.type = type;
			this.name = name;
			this.effectiveDate = effectiveDate;
			this.expirationDate = expirationDate;
			this.state = state;
			this.cwa = cwa;
			this.forecastOffices = forecastOffices;
			this.timeZone = timeZone;
			this.observationStations = observationStations;
			this.radarStation = radarStation;
		}
		public String getUrlId() {
			return urlId;
		}
		public void setUrlId(String urlId) {
			this.urlId = urlId;
		}
		public String getUrlType() {
			return urlType;
		}
		public void setUrlType(String urlType) {
			this.urlType = urlType;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		public void setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
		}
		public Date getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public ArrayList<String> getCwa() {
			return cwa;
		}
		public void setCwa(ArrayList<String> cwa) {
			this.cwa = cwa;
		}
		public ArrayList<String> getForecastOffices() {
			return forecastOffices;
		}
		public void setForecastOffices(ArrayList<String> forecastOffices) {
			this.forecastOffices = forecastOffices;
		}
		public ArrayList<String> getTimeZone() {
			return timeZone;
		}
		public void setTimeZone(ArrayList<String> timeZone) {
			this.timeZone = timeZone;
		}
		public ArrayList<String> getObservationStations() {
			return observationStations;
		}
		public void setObservationStations(ArrayList<String> observationStations) {
			this.observationStations = observationStations;
		}
		public String getRadarStation() {
			return radarStation;
		}
		public void setRadarStation(String radarStation) {
			this.radarStation = radarStation;
		}
		@Override
		public String toString() {
			return "Properties [urlId=" + urlId + ", urlType=" + urlType + ", id=" + id + ", type=" + type + ", name="
					+ name + ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + ", state="
					+ state + ", cwa=" + cwa + ", forecastOffices=" + forecastOffices + ", timeZone=" + timeZone
					+ ", observationStations=" + observationStations + ", radarStation=" + radarStation + "]";
		}
	
}
