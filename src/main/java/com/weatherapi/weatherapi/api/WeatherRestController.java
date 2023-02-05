package com.weatherapi.weatherapi.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.JsonDeserializer.JsonDeserializer;

@RestController
public class WeatherRestController {
	
	
	String baseZoneUrl = "https://api.weather.gov/zones/forecast/";
	String baseGridUrl ="https://api.weather.gov/gridpoints/";
	String basepointUrl = "https://api.weather.gov/points/";
	String lat;
	String longitude;
	final ObjectMapper mapper = new ObjectMapper();
	@GetMapping("/{countyCode}")
	public ResponseEntity<Object> geometryApi(@PathVariable("countyCode") String countyCode) throws StreamReadException, DatabindException, IOException {
		
		JsonDeserializer response = new JsonDeserializer(baseZoneUrl+countyCode);
		//lat = response
		List<Float> coordinates = response.
		getRootObj().
		getGeometry()
		.getCoordList();
		lat = coordinates.get(0).toString();
		longitude = coordinates.get(1).toString();
		return new ResponseEntity<>(coordinates,HttpStatus.OK);
	}

	
	@GetMapping("/coordinates/{lat}/{longitude}")
	public ResponseEntity<Object> getGrid (@PathVariable("lat") String lat, @PathVariable("longitude") String longitude) throws IOException{
		URL wurl = new URL(basepointUrl+lat+","+longitude);
		JsonNode json = new ObjectMapper().readTree(wurl);
		
		JsonNode response = json.get("properties").get("forecast");
		System.out.println("00000000000000000000000000000000"+response);
		URL wurl2 = new URL(response.toString().substring(1,response.toString().length()-1));
		
		JsonNode json2 = new ObjectMapper().readTree(wurl2);
		JsonNode response2 = json2.get("properties").get("periods");
		
		
		return new ResponseEntity<>(response2.toPrettyString(),HttpStatus.OK);
	}
	
	
	
	public JsonNode returnUrl () throws IOException {
		URL wurl = new URL(basepointUrl+lat+","+longitude);
		JsonNode json = new ObjectMapper().readTree(wurl);
		JsonNode response = json.get("properties").get("forecast");
		return response;
	}

}
