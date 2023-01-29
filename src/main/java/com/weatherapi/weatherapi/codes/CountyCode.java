package com.weatherapi.weatherapi.codes;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="codes")
public class CountyCode {

	
	private String id;
	
	private String county;
	
	public CountyCode() {
		super();
	}
	public CountyCode(String id, String county, String code) {
		super();
		this.id = id;
		this.county = county;
		this.code = code;
	}
	private String code;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
