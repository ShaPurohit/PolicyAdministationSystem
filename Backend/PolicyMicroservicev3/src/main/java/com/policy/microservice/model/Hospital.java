package com.policy.microservice.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="hospital")
public class Hospital {
	
	@Id
	@Column(name="HID")
	@NotNull(message="hospitalId should not be null")
	private String hospitalId;
	
	@Column(name="Name")
	@NotNull(message="name should not be null")
	private String name;
	
	@Column(name="Location")
	@NotNull(message="location should not be null")
	private String location;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="hospitals")
	private Set<Policy> policies = new HashSet<>();

	public Hospital(String hospitalId, String name, String location) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
	}
	
}
