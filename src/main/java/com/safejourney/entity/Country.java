package com.safejourney.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "COUNTRY", schema = "TICKET_BOOKING")
@NamedQueries({ @NamedQuery(name = "getAllCountries", query = "select c from Country c") })
public class Country implements Serializable{

	@Id
	private String countryId;
	private String countryName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	@JsonManagedReference
	@JsonIgnore
	private Set<State> stateList;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
