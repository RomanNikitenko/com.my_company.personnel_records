package com.company.personnelrecords.company;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.company.personnelrecords.exception.StringDigitIncludeException;

public class EmployeeCreator {
	
	//***********************************************************************************************
		public EmployeeFixedSalary createNewEmplFixSal()
			throws StringDigitIncludeException {
		EmployeeFixedSalary emplFixSal = new EmployeeFixedSalary(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
		Company.getInstance().getArrListObjAllEmployee().add(0, emplFixSal);

		return emplFixSal;
		}
	// *******************************************************************************************
		public EmployeeHourlyWages createNewEmplHourlyWages()
				throws StringDigitIncludeException {
			EmployeeHourlyWages emplHourlyWages = new EmployeeHourlyWages(0, "", "", "",
					new BigDecimal(0), 0, "", "", "", new BigDecimal(0));
			Company.getInstance().getArrListObjAllEmployee().add(0, emplHourlyWages);
			return emplHourlyWages;
		}
	//***********************************************************************************************
	public ArrayList<Employee> createArrListWithNewEmplFixSal()
			throws StringDigitIncludeException {
		
		ArrayList<Employee> arrListObjEmplFixSal = new ArrayList<Employee>();
		arrListObjEmplFixSal.add(new EmployeeFixedSalary(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		Company.getInstance().setArrListObjAllEmployee(arrListObjEmplFixSal);

		return arrListObjEmplFixSal;
	}
	// *******************************************************************************************
	public ArrayList<Employee> createArrListWithNewEmplHourlyWages()
			throws StringDigitIncludeException {

		ArrayList<Employee> arrListObjEmplHourlyWages = new ArrayList<Employee>();
		arrListObjEmplHourlyWages.add(new EmployeeHourlyWages(0, "", "", "",
				new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		Company.getInstance().setArrListObjAllEmployee(arrListObjEmplHourlyWages);
		return arrListObjEmplHourlyWages;
	}

}
