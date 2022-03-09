package com.covid.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.covid.project.dto.CaseObservationResponseDto;
import com.covid.project.dto.ConfirmedCaseDto;
import com.covid.project.model.CovidEntity;
import com.covid.project.repository.CovidRepository;
import com.covid.project.service.CovidService;
import com.covid.project.util.ParseUtil;

@Service
public class CovidServiceImpl implements CovidService {

	@Autowired
	private CovidRepository covidRepository;
	
	@Override
	public void initiateData(List<CovidEntity> data) {
		covidRepository.saveAll(data);
	}

	@Override
	public CaseObservationResponseDto getCovidObservation(String dt, String ctr) {
		List<CovidEntity> covidEntity = covidRepository.getCaseObservation(ParseUtil.parseLocalDate(dt, "yyyy-MM-dd"), ctr);
		List<ConfirmedCaseDto> countries = new ArrayList<>();
		if(!covidEntity.isEmpty() ) covidEntity.forEach(covid ->{
			ConfirmedCaseDto confirmedCase = new ConfirmedCaseDto();
			if(!ObjectUtils.isEmpty(covid)) {
				confirmedCase.setCountry(covid.getCountry());
				confirmedCase.setConfirmed(covid.getConfirmed());
				confirmedCase.setRecovered(covid.getRecovered());
				confirmedCase.setDeaths(covid.getDeaths());
				countries.add(confirmedCase);
			}
		});
		CaseObservationResponseDto cs = new CaseObservationResponseDto(ParseUtil.parseLocalDate(dt, "yyyy-MM-dd"));
		cs.setCountries(countries);
		return cs;
	}

}
