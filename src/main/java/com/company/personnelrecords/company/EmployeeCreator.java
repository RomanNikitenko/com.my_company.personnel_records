package com.company.personnelrecords.company;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.company.personnelrecords.exception.StringDigitIncludeException;

public class EmployeeCreator {
	private Company instanceCompany = Company.getInstance();
	
	//********************************************************************************************
	public EmployeeFixedSalary addEmplFixSal(int personalNumber,
			String surnameNameMiddlename, String department, String post,
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence, BigDecimal monthlyPayment)
			throws StringDigitIncludeException {
		EmployeeFixedSalary emplFixSal = new EmployeeFixedSalary(
				personalNumber, surnameNameMiddlename, department, post,
				averageSalary, taxIdentifNum, education, passport, residence,
				monthlyPayment);
		instanceCompany.getArrListObjAllEmployee().add(0, emplFixSal);
		return emplFixSal;
	}
//****************************************************************************************************
	public EmployeeHourlyWages addEmplHourlyWages(int personalNumber,
			String surnameNameMiddlename, String department, String post,
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence, BigDecimal hourlyRate)
			throws StringDigitIncludeException {
		EmployeeHourlyWages emplHourlyWages = new EmployeeHourlyWages(
				personalNumber, surnameNameMiddlename, department, post,
				averageSalary, taxIdentifNum, education, passport, residence,
				hourlyRate);
		instanceCompany.getArrListObjAllEmployee().add(0, emplHourlyWages);
		return emplHourlyWages;
	}
	//***********************************************************************************************
		public EmployeeFixedSalary createNewEmplFixSal()
			throws StringDigitIncludeException {
		EmployeeFixedSalary emplFixSal = new EmployeeFixedSalary(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
		instanceCompany.getArrListObjAllEmployee().add(0, emplFixSal);

		return emplFixSal;
		}
	// *******************************************************************************************
		public EmployeeHourlyWages createNewEmplHourlyWages()
				throws StringDigitIncludeException {
			EmployeeHourlyWages emplHourlyWages = new EmployeeHourlyWages(0, "", "", "",
					new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
			instanceCompany.getArrListObjAllEmployee().add(0, emplHourlyWages);
			return emplHourlyWages;
		}
	//***********************************************************************************************
	public ArrayList<Employee> createArrListWithNewEmplFixSal()
			throws StringDigitIncludeException {
		
		ArrayList<Employee> arrListObjEmplFixSal = new ArrayList<Employee>();
		arrListObjEmplFixSal.add(new EmployeeFixedSalary(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		instanceCompany.setArrListObjAllEmployee(arrListObjEmplFixSal);

		return arrListObjEmplFixSal;
	}
	// *******************************************************************************************
	public ArrayList<Employee> createArrListWithNewEmplHourlyWages()
			throws StringDigitIncludeException {

		ArrayList<Employee> arrListObjEmplHourlyWages = new ArrayList<Employee>();
		arrListObjEmplHourlyWages.add(new EmployeeHourlyWages(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		instanceCompany.setArrListObjAllEmployee(arrListObjEmplHourlyWages);
		return arrListObjEmplHourlyWages;
	}

}
