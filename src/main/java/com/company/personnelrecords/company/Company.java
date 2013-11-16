package com.company.personnelrecords.company;

import java.util.ArrayList;

public class Company {

	private static final Company INSTANCECOMPANY = new Company("", "", "", 0, 0);
	
	private ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal;
	private ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages;
	
	String 	companyName,
			companyCEO,
			companyRegisteredOffice;
	long 	companyCurrentAccount,
		 	companyEDRPOU;
	
	//*******constructor**************************************
	private Company(String companyName, String companyCEO, 
			String companyRegisteredOffice,
			long companyCurrentAccount, long companyEDRPOU) {
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyRegisteredOffice = companyRegisteredOffice;
		this.companyCurrentAccount = companyCurrentAccount;
		this.companyEDRPOU = companyEDRPOU;
	}//constructor
	//**********************************************************
	
	public static synchronized Company getInstance() {
      return INSTANCECOMPANY;
   	}

	public ArrayList<EmployeeFixedSalary> getArrListObjEmplFixSal() {
		return arrListObjEmplFixSal;
	}

	public void setArrListObjEmplFixSal(
			ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal) {
		this.arrListObjEmplFixSal = arrListObjEmplFixSal;
	}

	public ArrayList<EmployeeHourlyWages> getArrListObjEmplHourlyWages() {
		return arrListObjEmplHourlyWages;
	}

	public void setArrListObjEmplHourlyWages(
			ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages) {
		this.arrListObjEmplHourlyWages = arrListObjEmplHourlyWages;
	}

	//***********************************************************

	
	
	
	
}//class
