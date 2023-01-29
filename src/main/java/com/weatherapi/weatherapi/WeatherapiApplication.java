package com.weatherapi.weatherapi;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.filereader.CountyData;
import com.weatherapi.weatherapi.filereader.ExcelReader;
@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherapiApplication.class, args);
		
		CountyData data = new CountyData();
		 
		System.out.println(data.convertToJson());
		//GetWeatherData data = new GetWeatherData();
		//String json = objMapper.writeValueAsString(data);
		
	}

}
