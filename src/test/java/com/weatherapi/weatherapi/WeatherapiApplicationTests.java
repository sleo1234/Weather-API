package com.weatherapi.weatherapi;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weatherapi.weatherapi.codes.CountyCode;
import com.weatherapi.weatherapi.elasticsearch.CountyCodeRepository;
import com.weatherapi.weatherapi.filereader.CountyData;

@SpringBootTest
class WeatherapiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired CountyCodeRepository repo;
	
	@Test
	public void testBulkIndexing() throws IOException {
		CountyData codes = new CountyData();
		
		//List<CountyCode> countyCodes = codes.setValues();
		//repo.saveAll();
	   System.out.println("----------------"+repo.getAllDocuments().get(0).toString());	
	}
}
