package com.covid.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.covid.project.model.CovidEntity;

@Component
public class CSVUtil {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "SNo", "Country/Region", "Deaths", "Recovered", "ObservationDate" };

	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public List<CovidEntity> parseCSV(InputStream is) throws IOException, ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<CovidEntity> covidData = new ArrayList<CovidEntity>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				CovidEntity covidEntity = new CovidEntity();
				covidEntity.setNo(Long.parseLong(csvRecord.get("SNo")));
				covidEntity.setCountry(csvRecord.get("Country/Region"));
				covidEntity.setDeaths(ParseUtil.parseInt(csvRecord.get("Deaths")));
				covidEntity.setRecovered(ParseUtil.parseInt(csvRecord.get("Recovered")));
				covidEntity.setConfirmed(ParseUtil.parseInt(csvRecord.get("Confirmed")));
				covidEntity.setProvince(csvRecord.get("Province/State"));
				covidEntity.setObservation_date(ParseUtil.parseAndChangeFormatLocalDate(csvRecord.get("ObservationDate"), "MM/dd/yyyy", "yyyy-MM-dd"));
//				System.out.println(ParseUtil.parseLocalDateToString(covidEntity.getObservation_date()));
				covidData.add(covidEntity);
			}
			return covidData;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

	}
}
