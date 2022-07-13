package com.policy.microservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policy")
@Getter
@Setter
@NoArgsConstructor
public class Policy{
	
	@Id
	@Column(name="PID")
	@NotNull(message="policyId should not be null")
	private String policyId;
	
	
	@Column(name="Policy_Type")
	@NotNull(message="policyType should not be null")
	private String policyType;
	
	
	@Column(name="Cap_Amount")
	@NotNull(message="suInsured should not be null")
	private double sumInsured;
	
	
	@Column(name="Premium")
	@NotNull(message="premium should not be null")
	private double premium;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="provider_policy", joinColumns= @JoinColumn(name="policyId"),
								  inverseJoinColumns= @JoinColumn(name="hospitalId"))
	private Set<Hospital> hospitals = new HashSet<>();
	
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="policy_benefits", joinColumns= @JoinColumn(name="policyId"),
					  inverseJoinColumns= @JoinColumn(name="benefitID"))
	private Set<Benefits> benefits = new HashSet<>();
	
	public Policy(String policyId, String policyType, double sumInsured, double premium) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.sumInsured = sumInsured;
		this.premium = premium;
	}
}