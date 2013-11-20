package com.company.personnelrecords.company;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.company.personnelrecords.exception.StringDigitIncludeException;

public class EmployeeCreator {
	
	//***********************************************************************************************
		public EmployeeFixedSalary createNewEmplFixSal()
				throws StringDigitIncludeException {

			return new EmployeeFixedSalary(0, "", "", "",
					new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
		}
	// *******************************************************************************************
		public EmployeeHourlyWages createNewEmplHourlyWages()
				throws StringDigitIncludeException {

			return new EmployeeHourlyWages(0, "", "", "",
					new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
		}
	//***********************************************************************************************
	public ArrayList<EmployeeFixedSalary> createArrListWithNewEmplFixSal()
			throws StringDigitIncludeException {

		ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal = new ArrayList<EmployeeFixedSalary>();
		arrListObjEmplFixSal.add(new EmployeeFixedSalary(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));

		return arrListObjEmplFixSal;
	}
	// *******************************************************************************************
	public ArrayList<EmployeeHourlyWages> createArrListWithNewEmplHourlyWages()
			throws StringDigitIncludeException {

		ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages = new ArrayList<EmployeeHourlyWages>();
		arrListObjEmplHourlyWages.add(new EmployeeHourlyWages(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		return arrListObjEmplHourlyWages;
	}

}
