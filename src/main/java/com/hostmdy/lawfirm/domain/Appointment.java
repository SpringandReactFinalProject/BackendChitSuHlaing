package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Name is not blank")
	@Column(updatable = false, unique = true)
	private String name;
	
	private Double consultantFees;

	
	private Status clientStatus;


	private Status lawyerStatus;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JsonIgnore
////	@JoinColumn(name="inqueryform_id",nullable = false)
//	private InqueryForm inqueryForm;
	
	@PrePersist
	void onCreate() {
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}
	
	
}
