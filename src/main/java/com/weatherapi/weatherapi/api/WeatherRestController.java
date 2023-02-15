package com.weatherapi.weatherapi.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.JsonDeserializer.JsonDeserializer;
import com.weatherapi.weatherapi.dto.Mapper;
import com.weatherapi.weatherapi.dto.PeriodDto;
import com.weatherapi.weatherapi.entities.Period;


@RestController
public class WeatherRestController {
	
	
	String baseZoneUrl = "https://api.weather.gov/zones/forecast/";
	String baseGridUrl ="https://api.weather.gov/gridpoints/";
	String basepointUrl = "https://api.weather.gov/points/";

	final ObjectMapper mapper = new ObjectMapper();
	private Mapper dtoMapper = new Mapper();
	
	public void configureMapper () {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	
	}
	
	@GetMapping("/{countyCode}")
	public ResponseEntity<Object> geometryApi(@PathVariable("countyCode") String countyCode) throws StreamReadException, DatabindException, IOException {
		List<Float> coordinates = getLatLong(countyCode);
		String lat = coordinates.get(0).toString();
		String longitude = coordinates.get(1).toString();
		System.out.println(getPeriods (longitude, lat));
		System.out.println("================"+getLatLong(countyCode)); 
		return new ResponseEntity<>(coordinates,HttpStatus.OK);
	}

	
	public List<Float> getLatLong(String countyCode) 
			throws StreamReadException, DatabindException, IOException{
		
		JsonDeserializer response = new JsonDeserializer(baseZoneUrl+countyCode);
		List<Float> coordinates = response.
				getRootObj().
				getGeometry()
				.getCoordList();
				return coordinates;
	}
	
	@GetMapping("/temperatures/{countyCode}")
	public ResponseEntity<Object> getGrid (@PathVariable("countyCode") String countyCode) throws IOException{
 List<Float> coordinates = getLatLong(countyCode);
		String lat = coordinates.get(0).toString();
		String longitude = coordinates.get(1).toString();
	
	List<Period> pers = getPeriods(longitude, lat);
	System.out.println("*****************"+pers);
  List<PeriodDto> temps =  pers.
    stream().
	    map(dtoMapper :: toDto).
	    collect(Collectors.toList());
	  
		return new ResponseEntity<>(temps,HttpStatus.OK);
	}
	
	
	public List<Period> getPeriods (String longitude, String lat) throws IOException{
		URL wurl = new URL(basepointUrl+longitude+","+lat);
		JsonNode json = new ObjectMapper().readTree(wurl);
		
		 
		configureMapper ();
		JsonNode response = json.get("properties").get("forecast");
		URL wurl2 = new URL(response.toString().substring(1,response.toString().length()-1));
	
		JsonNode json2 = new ObjectMapper().readTree(wurl2);
		JsonNode response2 = json2.get("properties").get("periods");
		
		List<Period> pers = mapper.convertValue(response2, new TypeReference<List<Period>>() {});
	    convTemp(pers);
		System.out.println("--------------------------------"+pers.get(0).getTemperature());

	  
		return pers;
	}
	
	
	

	
	public static <T> List<T> castTo (Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
	
	
	public int convertToCelsius (int f) {
		int c =  (f-32)*(5)/9;
		return c;
	}
	
	
	public void convTemp(List<Period> periods) {
		for (int i=0; i< periods.size(); i++) {
			periods.get(i).setTemperature(convertToCelsius(periods.get(i).getTemperature()));
		}
	}
}
