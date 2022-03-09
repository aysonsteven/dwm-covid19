package com.covid.project.model;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "covid_19_data")
public class CovidEntity {
	
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sno")
	private Long no;
	
	@Column(name = "observation_date")
	private LocalDate observationDate;
	
	@Column(name = "country_region")
	private String country;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column
	private Integer deaths;
	
	@Column
	private Integer recovered;
	
	@Column
	private Integer confirmed;
	
	@Column(name = "province_state")
	private String province;
	
	

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public LocalDate getObservation_date() {
		return observationDate;
	}

	public void setObservation_date(LocalDate observation_date) {
		this.observationDate = observation_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getRecovered() {
		return recovered;
	}

	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}
	
	
}
