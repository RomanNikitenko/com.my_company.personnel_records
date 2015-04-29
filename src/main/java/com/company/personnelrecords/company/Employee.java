package com.company.personnelrecords.company;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

import com.company.personnelrecords.exception.StringDigitIncludeException;

public class Employee {
	
	protected int 	 personalNumber;
	protected String surnameNameMiddlename,
//					 name,					 
//					 middleName,  			
					department,  			
					post; 					
	protected BigDecimal 
					averageSalary; 			
	protected long taxIdentifNum;   		
	protected String education,				 
					 passport,   			
				     
					 residence;				
	
	
	
	
//*******************************************************************************
	public Employee(int personalNumber, String surnameNameMiddlename,
			String department, String post, BigDecimal averageSalary, long taxIdentifNum,
			String education, String passport, String residence) throws StringDigitIncludeException {
		this.setPersonalNumber(personalNumber);
		this.setSurnameNameMiddlename(surnameNameMiddlename);
		this.setEducation(education);
		this.setPost(post);
		this.setDepartment(department);
		this.setPassport(passport);
		this.setResidence(residence);
		this.setTaxIdentifNum(taxIdentifNum);
		this.setAverageSalary(averageSalary);
	}

	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) throws NumberFormatException{
		try {
			this.personalNumber = personalNumber;
			} catch (NumberFormatException ex) {
				  JOptionPane.showMessageDialog(null, 
						  "Field 'amount Employees' requires an integer value",
						  "Error",
						  JOptionPane.ERROR_MESSAGE);
			}
	}
	public String getSurnameNameMiddlename() {
		return surnameNameMiddlename;
	}
	public void setSurnameNameMiddlename(String surnameNameMiddlename) throws StringDigitIncludeException {
		if (surnameNameMiddlename.matches("^\\D*$")) {
			this.surnameNameMiddlename = surnameNameMiddlename;

		} else {
			throw new StringDigitIncludeException("incorrect value");
		}
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		
		return post;
	}
	public void setPost(String post) throws StringDigitIncludeException {
		if (post.matches("^\\D*$")) {
			this.post = post;

		} else {
			throw new StringDigitIncludeException("incorrect value");
		}
	}
	public BigDecimal getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(BigDecimal averageSalary) {
		this.averageSalary = averageSalary;
	}
	public long getTaxIdentifNum() {
		return taxIdentifNum;
	}
	public void setTaxIdentifNum(long taxIdentifNum) {
		this.taxIdentifNum = taxIdentifNum;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) throws StringDigitIncludeException {
		if (education.matches("^\\D*$")) {
			this.education = education;

		} else {
			throw new StringDigitIncludeException("incorrect value");
		}
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
//********************************************************************
}//class
