package com.weatherapi.weatherapi;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	
	public static final String JSON = "{\"properties\": {\r\n" + 
			"        \"@id\": \"https://api.weather.gov/zones/forecast/NYZ001\",\r\n" + 
			"        \"@type\": \"wx:Zone\",\r\n" + 
			"        \"id\": \"NYZ001\",\r\n" + 
			"        \"type\": \"public\",\r\n" + 
			"        \"name\": \"Niagara\",\r\n" + 
			"        \"effectiveDate\": \"2022-09-13T20:00:00+00:00\",\r\n" + 
			"        \"expirationDate\": \"2200-01-01T00:00:00+00:00\",\r\n" + 
			"        \"state\": \"NY\",\r\n" + 
			"        \"cwa\": [\r\n" + 
			"            \"BUF\"\r\n" + 
			"        ],\r\n" + 
			"        \"forecastOffices\": [\r\n" + 
			"            \"https://api.weather.gov/offices/BUF\"\r\n" + 
			"        ],\r\n" + 
			"        \"timeZone\": [\r\n" + 
			"            \"America/New_York\"\r\n" + 
			"        ],\r\n" + 
			"        \"observationStations\": [\r\n" + 
			"            \"https://api.weather.gov/stations/KIAG\",\r\n" + 
			"            \"https://api.weather.gov/stations/CYYZ\",\r\n" + 
			"            \"https://api.weather.gov/stations/KART\",\r\n" + 
			"            \"https://api.weather.gov/stations/KBUF\",\r\n" + 
			"            \"https://api.weather.gov/stations/KDKK\",\r\n" + 
			"            \"https://api.weather.gov/stations/KDSV\",\r\n" + 
			"            \"https://api.weather.gov/stations/KELZ\",\r\n" + 
			"            \"https://api.weather.gov/stations/KGVQ\",\r\n" + 
			"            \"https://api.weather.gov/stations/KJHW\",\r\n" + 
			"            \"https://api.weather.gov/stations/KROC\"\r\n" + 
			"        ],\r\n" + 
			"        \"radarStation\": \"BUF\"\r\n" + 
			"    }\r\n" + 
			"}\r\n}" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"";

	
	 final ObjectMapper mapper = new ObjectMapper();
	 
	 
  public String parseJson (String jsonValue, String property) throws JsonMappingException, JsonProcessingException {
	  Map<String,Object> map = new HashMap<String,Object>();
      map = mapper.readValue(jsonValue, new TypeReference<HashMap<String,Object>>(){});
      String result = map.get(property).toString();
      System.out.println(result);
      return result;
  }




}
