package com.weatherapi.weatherapi.elasticsearch;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weatherapi.weatherapi.codes.CountyCode;
import com.weatherapi.weatherapi.filereader.CountyData;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@Repository
public class CountyCodeRepository {
	@Autowired
	private ElasticsearchClient elasticsearchClient;
	
	@Autowired
	private GenericRepository repo;
	
	CountyData codesVal = new CountyData();
	
	public void saveAll() throws IOException {
		
		List<CountyCode> countyCodes = codesVal.setValues();
		System.out.println("[[[[[[[[[[[[[[[[[[[[["+countyCodes);
		BulkRequest.Builder bulk = new BulkRequest.Builder();
		for (CountyCode code : countyCodes) {
			
			bulk.operations(op -> op.index(
					i -> i.index("codes").id(code.getId())
					.document(code)));
			System.out.println("Id "+ code.getId() +" was added");
		
		}
		BulkResponse result = elasticsearchClient.bulk(bulk.build());
		for (int i=0;  i < countyCodes.size(); i++) {
		//System.out.println("----------------" + result.items().toArray()[i].toString());
		}
		//System.out.println(result.items().;
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
	
	public <T> Object getProperty (Class<? extends T> clazz, String name) throws NoSuchFieldException, SecurityException {
		Field field = clazz.getDeclaredField(name);
		return field;
	}
	
    public CountyCode findCountyByCode (String countyName) throws ElasticsearchException, IOException, NoSuchFieldException, SecurityException {
    	//List<Object> ls = repo.getByFieldName("county", "codes", countyName);
    	List<CountyCode> items = new ArrayList<>();
    	
    	SearchResponse<CountyCode> searchResponse = elasticsearchClient.search(
				s -> s.index("codes")
				       .query(q -> 
				        q.match(t -> 
				        t.field("county")
				    		   .query(countyName)
				    		   )
				        ), CountyCode.class);
		List<Hit<CountyCode>> hitsList = searchResponse.hits().hits();
    	for (Hit<CountyCode> hit : hitsList) {
			items.add(hit.source());
		}
    	return items.get(0);
    }
    
    
    
    public static <T> List<T> castTo (Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
	
	public void saveCodes () throws IOException {
		List<CountyCode> countyCodes = codesVal.setValues();
		for (CountyCode code : countyCodes) {
			elasticsearchClient.index(i -> i.
					index("codes").id(code.getId()).document(code));
		}
		
	}
	
	
}
