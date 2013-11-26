package com.company.personnelrecords.company;

import java.math.BigDecimal;

import com.company.personnelrecords.exception.StringDigitIncludeException;

public class EmployeeHourlyWages extends Employee{
	
	private BigDecimal hourlyRate;	//ставка в час
	
	

	//*******************************************************************************************
	public EmployeeHourlyWages(int personalNumber,
			String surnameNameMiddlename, String department, String post,  
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence,  BigDecimal hourlyRate) throws StringDigitIncludeException {
		
		super(personalNumber, surnameNameMiddlename, department, post, averageSalary,
				taxIdentifNum, education, passport, residence);
		
		this.setHourlyRate(hourlyRate); 
	}//конструктор
//*********************************************************************************************
	
	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
//***********************************************************************************************
	
}//class
