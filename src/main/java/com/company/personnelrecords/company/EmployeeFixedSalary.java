package com.company.personnelrecords.company;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.util.MyUtil;

public class EmployeeFixedSalary extends Employee{
	
	
	private BigDecimal monthlyPayment; //�������� �����

	//*********************************************************************************************
	public EmployeeFixedSalary (int personalNumber,
			String surnameNameMiddlename, String department, String post,  
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence,  BigDecimal monthlyPayment) throws StringDigitIncludeException {
		
		super(personalNumber, surnameNameMiddlename, department, post, averageSalary,
				taxIdentifNum, education, passport, residence);
		
		this.setMonthlyPayment(monthlyPayment);
	}//�����������
	
//**********************************************************************************************
		
	public BigDecimal getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(BigDecimal monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
//**********************************************************************************************
	public static ArrayList<EmployeeFixedSalary> createNewObjEmplFixSal () throws StringDigitIncludeException {
		
			ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal = new ArrayList<EmployeeFixedSalary>();
			arrListObjEmplFixSal.add(0,
			new EmployeeFixedSalary(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		return arrListObjEmplFixSal;
	}// 
//***********************************************************************************************
		/**
		 * ����� �������� ArrayList �������� EmployeeFixedSalary:
		 * <p>* �������� MyUtil.readDataEmployeeFromFile(pathFileIn), ������� ��������� ������ </p>
		 * <p>* �������� �� ����� ����� ArrayList ������ �� �����������</p> 
		 * <p>* ������� ArrayList �������� EmployeeFixedSalary ��� ���� �����������, ������ ��� ������� ���� � �����</p> 
		 * @param pathFileIn String - ���� � ����� � ������� �� �����������
		 * @return ArrayList<EmployeeFixedSalary> - ������� �����������
		 * @throws Exception
		 */
		public static ArrayList<EmployeeFixedSalary> createArrayListObjEmplFixSalFromFile (String pathFileIn)
				throws Exception {
		
			ArrayList<ArrayList<String>> dataEmplFixSal = MyUtil.readDataEmployeeFromFile(pathFileIn);
			ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal = new ArrayList<EmployeeFixedSalary> ();
			
			for (int j = 0; j < dataEmplFixSal.size(); j++) {
				int personalNumber = Integer.valueOf(dataEmplFixSal.get(j).get(0));
				String surnameNameMiddlename = dataEmplFixSal.get(j).get(1);
				String department = dataEmplFixSal.get(j).get(2);
				String post = dataEmplFixSal.get(j).get(3);
				BigDecimal averageSalary = new BigDecimal(dataEmplFixSal.get(j).get(4));
				BigDecimal monthlyPayment = new BigDecimal(dataEmplFixSal.get(j).get(5));
				long taxIdentifNum = Long.valueOf(dataEmplFixSal.get(j).get(6));
				String education = dataEmplFixSal.get(j).get(7);
				String passport = dataEmplFixSal.get(j).get(8);
				String residence = dataEmplFixSal.get(j).get(9);
				
				arrListObjEmplFixSal.add(new EmployeeFixedSalary(personalNumber, surnameNameMiddlename, department, post,
						averageSalary, taxIdentifNum, education, passport, residence, monthlyPayment));
			}//for
			return arrListObjEmplFixSal;
	}//createArrayListObjEmplFixSalFromFile
//**************************************************************************************************
}//class
