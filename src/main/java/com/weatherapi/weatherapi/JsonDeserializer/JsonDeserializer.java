package com.weatherapi.weatherapi.JsonDeserializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.entities.Root;

public class JsonDeserializer  {

	URL wurl;
	public JsonDeserializer(String url) throws MalformedURLException {
		super();
		this.url = url;
		wurl = new URL(this.url);
	}



	String url;
	final ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	
	public Root getRootObj () throws StreamReadException, DatabindException, IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Root root = mapper.readValue(wurl, Root.class);
		 root.getGeometry().getCoord();
		
		return root;
	}
	
	
//	
//	public JsonDeserializer() throws MalformedURLException {
//		 wurl = new URL(this.url);
//		
//	}
}
