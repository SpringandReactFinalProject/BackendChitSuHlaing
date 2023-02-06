package com.hostmdy.lawfirm.domain;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class InqueryForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Description should not be blank")
	private String description;
	
	@NotBlank(message = "Phone Number should not be blank")
	@Size(min=11)
	private String phoneNo;
	
	private String lawyerName;
	
//	private Long userId;
//	
//	@OneToOne(mappedBy ="inqueryForm",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Appointment appointment;
	
	
	
	
}
