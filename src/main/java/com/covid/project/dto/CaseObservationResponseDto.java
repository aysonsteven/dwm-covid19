package com.covid.project.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CaseObservationResponseDto {

	private LocalDate observation;
	
	private List<ConfirmedCaseDto> countries = new ArrayList<ConfirmedCaseDto>();
	
	
	
	public CaseObservationResponseDto(LocalDate dt) {
		observation = dt;

		
	}



	public LocalDate getObservation() {
		return observation;
	}



	public void setObservation(LocalDate observation) {
		this.observation = observation;
	}



	public List<ConfirmedCaseDto> getCountries() {
		return countries;
	}



	public void setCountries(List<ConfirmedCaseDto> countries) {
		this.countries = countries;
	}
	
	
}
