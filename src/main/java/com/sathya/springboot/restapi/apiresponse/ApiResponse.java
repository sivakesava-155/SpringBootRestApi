package com.sathya.springboot.restapi.apiresponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	private int statuscode;
	private String messege;
	private LocalDateTime timesstamp;
}

	

