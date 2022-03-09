package com.covid.project.service;

import java.util.List;

import com.covid.project.dto.CaseObservationResponseDto;
import com.covid.project.model.CovidEntity;

public interface CovidService {

	public void initiateData(List<CovidEntity> data);
	
	public CaseObservationResponseDto getCovidObservation(String dt, String ctr);
}
