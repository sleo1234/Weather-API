package com.weatherapi.weatherapi;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weatherapi.weatherapi.codes.CountyCode;
import com.weatherapi.weatherapi.elasticsearch.CountyCodeRepository;
import com.weatherapi.weatherapi.filereader.CountyData;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

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
		repo.saveAll();
	repo.getAllDocuments().forEach(System.out :: println);
	 //System.out.println("----------------"+repo.getAllDocuments().get(50).toString());	
	}
	
	@Test
	
	public void testFindCodeByCunty () throws ElasticsearchException, IOException {
		
		Object obj = repo.findCountyByCode("Alabama");
		System.out.println(repo.findCountyByCode("Alabama"));
	}
	@Test
	public void testSaveAllCodes () throws IOException {
		repo.saveCodes();
	}
}
