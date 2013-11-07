package employee;

import java.math.BigDecimal;
import java.util.ArrayList;

import util.MyUtil;

public abstract class Employee {
	
	protected int 	 personalNumber;			//табельный номер сотрудника
	protected String surnameNameMiddlename,     //фамилия, имя, отчество сотрудника
//					 name,						//имя 
//					 middleName,  				//Отчество
					department,  				// отдел
					post; 						// должность
	protected BigDecimal 
					averageSalary; 				//зарплата
	protected long taxIdentifNum;   			//идентиф номер налогоплатильщика
	protected String education,					//образование 
					 passport,   				//все данные по паспорту
				     
					 residence;					//местожительства - адресс
	
	
	
//**********************************************************************************
	public Employee(int personalNumber, String surnameNameMiddlename,
			String department, String post, BigDecimal averageSalary, long taxIdentifNum,
			String education, String passport, String residence) {
		this.setPersonalNumber(personalNumber);
		this.setSurnameNameMiddlename(surnameNameMiddlename);
		this.setEducation(education);
		this.setPost(post);
		this.setDepartment(department);
		this.setPassport(passport);
		this.setResidence(residence);
		this.setTaxIdentifNum(taxIdentifNum);
		this.setAverageSalary(averageSalary);
	}//конструктор

//*******Блок гетеров/сеттеров

	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getSurnameNameMiddlename() {
		return surnameNameMiddlename;
	}
	public void setSurnameNameMiddlename(String surnameNameMiddlename) {
		this.surnameNameMiddlename = surnameNameMiddlename;
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
	public void setPost(String post) {
		this.post = post;
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
	public void setEducation(String education) {
		this.education = education;
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
	
	//проверки: возраст не отрицателен, фамилия - только буквы и т.д.


}//class
