package com.weatherapi.weatherapi;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.filereader.CountyData;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) throws IOException, ParseException, NoSuchFieldException, SecurityException {
		SpringApplication.run(WeatherapiApplication.class, args);
		
		CountyData data = new CountyData();
		 JsonParser parser = new JsonParser();

	      JSONParser parser2 = new JSONParser();
		
		//System.out.println(data.convertToJson());
		//GetWeatherData data = new GetWeatherData();
		//String json = objMapper.writeValueAsString(data);
		
		 String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		 final ObjectMapper mapper = new ObjectMapper();
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		  .url("https://api.weather.gov/zones/forecast/NYZ001")
		  .get()
		  
		  .build();
		String response = client.newCall(request).execute().body().string();
		//System.out.println("-------" + response);
		// String result = parser.parseJson(response,"geometry");
		// System.out.println(mapper.writeValueAsString(result) );
		//parser.parseJson(mapper.writeValueAsString(result) , "coordinates");
		Object obj = parser2.parse(response);
		//JSONArray arr = (JSONArray) obj;
	    
		//System.out.println("------============================="+arr.get(0) );
		System.out.println("==========================" + parser.parseJson(obj.toString(),"geometry"));
	}

}
