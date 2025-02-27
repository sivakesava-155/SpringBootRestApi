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
@Table(name = "doctors")
@SequenceGenerator(name = "doctors_seq", sequenceName = "doctors_seq", allocationSize = 1)
public class Doctor {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_seq")
    private Long id;
	private String name;
	private String speciliazation;
	private int age;
	
}
	