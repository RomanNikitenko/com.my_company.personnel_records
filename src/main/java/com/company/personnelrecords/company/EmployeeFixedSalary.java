package com.company.personnelrecords.company;

import java.math.BigDecimal;
import com.company.personnelrecords.exception.StringDigitIncludeException;

public class EmployeeFixedSalary extends Employee{
	
	
	private BigDecimal monthlyPayment; 

	//*********************************************************************************************
	public EmployeeFixedSalary (int personalNumber,
			String surnameNameMiddlename, String department, String post,  
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence,  BigDecimal monthlyPayment) throws StringDigitIncludeException {
		
		super(personalNumber, surnameNameMiddlename, department, post, averageSalary,
				taxIdentifNum, education, passport, residence);
		
		this.setMonthlyPayment(monthlyPayment);
	}
	
//**********************************************************************************************
		
	public BigDecimal getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(BigDecimal monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
//************************************************************************************************
}//class
