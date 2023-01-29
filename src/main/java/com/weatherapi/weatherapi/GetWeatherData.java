package com.weatherapi.weatherapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetWeatherData {

	
	
	
	public String getAllData(String url) throws IOException {
		
		StringBuilder content = new StringBuilder();  
		StringBuilder weatherData = new StringBuilder();  
		URL baseUrl = new URL(url);
	// creating a url object  
	      URLConnection urlConnection = baseUrl.openConnection(); // creating a urlconnection object  
	  
	      // wrapping the urlconnection in a bufferedreader  
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
	      String line;  
	      int i=0;
	      
	      while ((line = bufferedReader.readLine()) != null  )  
	      {  
	    	
	        content.append(line);  
	        i++;
	        
	         
	      }  
	      
	     
	      bufferedReader.close();  
	      
	      return content.toString();  
	}
	
	
public String getForecastData(String url) throws IOException {
		
		StringBuilder content = new StringBuilder();  
		StringBuilder weatherData = new StringBuilder();  
		URL baseUrl = new URL(url);
	// creating a url object  
	      URLConnection urlConnection = baseUrl.openConnection(); // creating a urlconnection object  
	  
	      // wrapping the urlconnection in a bufferedreader  
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
	      String line;  
	      int i=0;
	      
	      
	      while ((line = bufferedReader.readLine()).contains("forecast")  )  
	      {  
	    	
	        content.append(line);  
	        i++;
	        
	         
	      }  
	      
	     
	      bufferedReader.close();  
	      
	      return content.toString();  
	}
	
	
}
