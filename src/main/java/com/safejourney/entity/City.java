package com.safejourney.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
@Table(name = "CITY", schema = "TICKET_BOOKING")
@NamedQueries(
		@NamedQuery(name = "findCityByStateId", query = "select c from City c where c.state.stateId = :stateId")
		)
public class City implements Serializable{

	@Id
	@Column(name = "CITY_ID")
	private String cityId;

	private String cityName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Address> addresses = new HashSet<>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	@JsonIgnore
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
