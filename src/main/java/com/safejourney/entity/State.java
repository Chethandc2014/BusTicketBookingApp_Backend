package com.safejourney.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATE", schema = "TICKET_BOOKING")
public class State {

	@Id
	private Integer stateId;
	private String stateName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private Set<City> cities = new HashSet<>(0);

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
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
