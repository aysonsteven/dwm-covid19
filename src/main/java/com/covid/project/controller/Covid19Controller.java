package com.covid.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.covid.project.dto.CaseObservationResponseDto;
import com.covid.project.model.CovidEntity;
import com.covid.project.service.CovidService;
import com.covid.project.util.CSVUtil;

@RestController
@RequestMapping
public class Covid19Controller {
	@Autowired
	private CSVUtil csvUtil;
	
	@Autowired
	private CovidService covidService;

	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Hello Spring";
	}
	
	@PostMapping("/upload")
	public List<CovidEntity> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
		return csvUtil.parseCSV(file.getInputStream());
	}
	
	@PostMapping("/intialize")
	public void initialize(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
		covidService.initiateData(csvUtil.parseCSV(file.getInputStream()));
	}
	
	@GetMapping("/top/confirmed")
	public CaseObservationResponseDto getCovidObservation(@RequestParam("observation_date") String date, @RequestParam("max_results") String ctr){
		return covidService.getCovidObservation(date, ctr);
	}
}
