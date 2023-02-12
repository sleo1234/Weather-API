package com.weatherapi.weatherapi.dto;

import org.springframework.stereotype.Component;

import com.weatherapi.weatherapi.entities.Period;

@Component
public class Mapper {

	
	public PeriodDto toDto(Period period) {
		String name = period.getName();
		int temperature = period.getTemperature();
		return new PeriodDto(name,temperature);
	}
}
