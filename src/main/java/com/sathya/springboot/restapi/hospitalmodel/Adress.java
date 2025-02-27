package com.sathya.springboot.restapi.hospitalmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adress")
@SequenceGenerator(name = "adress_seq", sequenceName = "adress_seq", allocationSize = 1)
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adress_seq")	
	 private Long id;
	 private String doorno;
	 private String street;
	 private Long pincode; 
	 

	
}
