package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cases {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Case Title must be filled")
	private String caseTitle;

	@NotBlank(message = "Description Title must be filled")
	private String description;


	private String caseStatus;
	

	@NotNull(message = "Attendent is required")
	private Integer attenCourtRoom;

	private String caseType;

	private LocalDate startDate;
	private  LocalTime startTime;
	

	private LocalDate endDate;
	private LocalTime endTime;

	 @OneToOne(mappedBy = "cases")
	private Contract contract;
//
//	@PrePersist
//	void OnCreate() {
//		this.startDate = LocalDate.now();
//		this.startTime=LocalTime.now();
//	}
//
//	@PreUpdate
//	void OnUpdate() {
//		this.endDate = LocalDate.now();
//		this.endTime= LocalTime.now();
//	}

}
