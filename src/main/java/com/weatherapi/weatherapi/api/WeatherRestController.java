package com.weatherapi.weatherapi.api;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.weatherapi.weatherapi.JsonDeserializer.JsonDeserializer;

@RestController
public class WeatherRestController {
	
	
	String baseZoneUrl = "https://api.weather.gov/zones/forecast/";
	String baseGridUrl ="https://api.weather.gov/gridpoints";
	String lat;
	String longitude;
	
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

	
	//public ResponseEntity<Object> getGrid (){
		
	//}
	

}
