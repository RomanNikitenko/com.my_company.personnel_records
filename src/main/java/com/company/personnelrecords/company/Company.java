package com.company.personnelrecords.company;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.util.MyUtil;

public class Company {
	
	private ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal;
	private ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages;
	
	private static ArrayList<ArrayList<String>> arrCompanyData = 
			MyUtil.readCompanyDataFromFile("src/main/resources/CompanyData.cdt"); 

	
	private static final Company INSTANCECOMPANY = new Company(arrCompanyData.get(0).get(0), arrCompanyData.get(0).get(1),
			Long.valueOf(arrCompanyData.get(0).get(2)), Long.valueOf(arrCompanyData.get(0).get(3)), arrCompanyData.get(0).get(4));
	
	String 	companyName,
			companyCEO,
			companyRegisteredOffice;
	long 	companyCurrentAccount,
			companyEDRPOU;

	//*******constructor**************************************
	private Company(String companyName, String companyCEO, 
			long companyCurrentAccount, long companyEDRPOU, String companyRegisteredOffice)  {
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

	public static ArrayList<ArrayList<String>> getArrCompanyData() {
		return arrCompanyData;
	}

	public static void setArrCompanyData(ArrayList<ArrayList<String>> arrCompanyData) {
		Company.arrCompanyData = arrCompanyData;
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
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) throws StringDigitIncludeException{
		if (companyCEO.matches("^\\D*$")) {
			this.companyCEO = companyCEO;
		} else {
			throw new StringDigitIncludeException("incorrect value");
		}
	}

	public String getCompanyRegisteredOffice() {
		return companyRegisteredOffice;
	}

	public void setCompanyRegisteredOffice(String companyRegisteredOffice) {
		this.companyRegisteredOffice = companyRegisteredOffice;
	}

	public long getCompanyCurrentAccount() {
		return companyCurrentAccount;
	}

	public void setCompanyCurrentAccount(long companyCurrentAccount) throws NumberFormatException {
		try {
			this.companyCurrentAccount = companyCurrentAccount;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Field 'Company Current Account' requires an long value",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public long getCompanyEDRPOU() {
		return companyEDRPOU;
	}

	public void setCompanyEDRPOU(long companyEDRPOU) throws NumberFormatException{
		try {
			this.companyEDRPOU = companyEDRPOU;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Field 'Company EDRPOU' requires an long value",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	//***********************************************************
}//class
