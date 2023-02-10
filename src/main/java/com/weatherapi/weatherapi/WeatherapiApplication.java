package com.weatherapi.weatherapi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) throws IOException, ParseException, NoSuchFieldException, SecurityException {
		SpringApplication.run(WeatherapiApplication.class, args);
		String baseGridUrl ="https://api.weather.gov/points/39.7456,-97.0892";
		final ObjectMapper mapper = new ObjectMapper();
	    
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		URL wurl = new URL(baseGridUrl);
		URLConnection request = wurl.openConnection();
		request.connect();
		JSONParser jp = new JSONParser();
		//Property prop = mapper.readValue(wurl, Property.class);
	
		JsonNode json = new ObjectMapper().readTree(wurl);
		//System.out.println("------------------"+json.get("properties").get("forecast").get("periods"));
		//JsonDeserializer deserializer = new JsonDeserializer(baseGridUrl+"39.7456,-97.0892");
	    //deserializer
		 
		
	}

}
