package com.Group2.springbootBankingAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private boolean success;

}
