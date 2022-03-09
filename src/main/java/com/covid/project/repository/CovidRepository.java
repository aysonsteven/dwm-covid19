package com.covid.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.project.model.CovidEntity;

@Repository
public interface CovidRepository extends JpaRepository<CovidEntity, Long> {
	
	@Query(nativeQuery = true, value = "select sum(sno) as sno, observation_date, sum(confirmed) as confirmed"
			+ ", country_region , sum(deaths) as deaths, null  as province_state, sum(recovered) as recovered, last_update from covid_19_data "
			+ " where observation_date = :dt"
			+ " GROUP BY country_region, province_state"
			+ " ORDER BY confirmed DESC LIMIT :ctr")
	public List<CovidEntity> getCaseObservation(@Param("dt") LocalDate date, @Param("ctr") String ctr);
	
	public List<CovidEntity> findAllByObservationDate(LocalDate date);

}
