package com.weatherapi.weatherapi;

import java.io.IOException;
import java.net.URL;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.JsonDeserializer.JsonDeserializer;
import com.weatherapi.weatherapi.entities.Root;
import com.weatherapi.weatherapi.filereader.CountyData;

import okhttp3.OkHttpClient;
import okhttp3.Request;
@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) throws IOException, ParseException, NoSuchFieldException, SecurityException {
		SpringApplication.run(WeatherapiApplication.class, args);
		//JsonDeserializer deserializer = new JsonDeserializer("https://api.weather.gov/zones/forecast/NYZ009");
	    //deserializer.getRootObj().getProperties();
		 
		
	}

}
