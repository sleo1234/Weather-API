package com.weatherapi.weatherapi.filereader;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.codes.CountyCode;

import in.abilng.ndjson.NdJsonObjectMapper;

public class CountyData {
	
	CountyCode code = new CountyCode();
	ObjectMapper objMapper = new ObjectMapper();
	NdJsonObjectMapper ndJsonObjectMapper = new NdJsonObjectMapper();
	ExcelReader exReader = new ExcelReader();
	List<CountyCode> codes= new ArrayList<>();
	
	public List<CountyCode> setValues () throws IOException {
		 exReader.readXlFile("codes.xlsx");
		 List<String> countyCode = exReader.getCountyCode();
		 List<String> countyName = exReader.getCountyName();
		 
		 for (int i=0; i<countyCode.size(); i++) {
		codes.add( new CountyCode(String.valueOf(i),countyName.get(i),countyCode.get(i)));
		
		 }
		 return codes;
		 }

	
	
	public String convertToJson () throws JsonProcessingException, IOException {
		//objMapper.write
		
		return objMapper.writeValueAsString(setValues());
	}
	
	
	
	
	
	
	
}
