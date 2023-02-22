package com.weatherapi.weatherapi.elasticsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weatherapi.weatherapi.codes.CountyCode;
import com.weatherapi.weatherapi.filereader.CountyData;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@Repository
public class CountyCodeRepository {
	@Autowired
	private ElasticsearchClient elasticsearchClient;
	
	CountyData codesVal = new CountyData();
	
	public void saveAll() throws IOException {
		
		List<CountyCode> countyCodes = codesVal.setValues();
		BulkRequest.Builder bulk = new BulkRequest.Builder();
		for (CountyCode code : countyCodes) {
			
			bulk.operations(op -> op.index(
					i -> i.index("codes").id(code.getId())
					.document(code)));
		
		}
		BulkResponse result = elasticsearchClient.bulk(bulk.build());
		System.out.println("----------------" + result);
	}
	
	public List<CountyCode> getAllDocuments() throws IOException {
		List<CountyCode> items = new ArrayList<>();

		SearchRequest searchRequest = SearchRequest.of(s -> s.index("codes"));
		SearchResponse searchResponse = elasticsearchClient.search(searchRequest, CountyCode.class);
		List<Hit> hits = searchResponse.hits().hits();

		for (Hit object : hits) {
			items.add((CountyCode) object.source());
		}
		return items;
	}
	
	
	
	
}
