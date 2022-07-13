package com.policy.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="member_policy")
public class MemberPolicy {
	
	@Id
	@Column(name="MID")
	@NotNull(message="memberId should not be null")
	private String memberId;
	
	@Column(name="PID")
	@NotNull(message="policyId should not be null")
	private String policyId;
	
	@Column(name="tenure")
	@NotNull(message="tenure should not be null")
	private int tenure;
	
	@Column(name="premium_last_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull(message="premiumDate should not be null")
	private String premiumLastDate;
	
	@Column(name="subscription_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull(message="subscription should not be null")
	private String subscriptionDate;
}
