package com.Group2.springbootBankingAPI.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
      String resourceName;
      String fieldName;
     long fieldValue;

	 String fieldvalue2;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldvalue2) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldvalue2));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue2 = fieldvalue2;
	}

}
