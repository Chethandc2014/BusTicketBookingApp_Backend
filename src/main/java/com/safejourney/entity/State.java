package com.safejourney.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "STATE", schema = "TICKET_BOOKING")
@NamedQueries({ @NamedQuery(name = "findStateByCountryId", query = "select s from State s where s.country.countryId = :countryId") })
public class State implements Serializable{

	@Id
	private String stateId;
	private String stateName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	@JsonIgnore
	private Set<City> cities = new HashSet<>(0);

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}


	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
