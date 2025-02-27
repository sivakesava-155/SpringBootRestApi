package com.sathya.springboot.restapi.hospitalmodel;





import java.util.List;

import jakarta.persistence.CascadeType;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospital")
@SequenceGenerator(name = "hospital_seq", sequenceName = "hospital_seq", allocationSize = 1)

public class HospitalModel {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_seq")
	
	private Long id;
	private String name;
	private double rating;
	private String location;
	private String email;
	@OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "adress_id")
	private Adress adress;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctors_id")
	private List<Doctor> doctors;
	


	
	

}
