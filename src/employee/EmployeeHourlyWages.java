package employee;

import java.math.BigDecimal;
import java.util.ArrayList;

import exception.MyException;

import util.MyUtil;

public class EmployeeHourlyWages extends Employee{
	
	private BigDecimal hourlyRate;	//������ � ���
	
	
//*******************************************************************************************
	public EmployeeHourlyWages(int personalNumber,
			String surnameNameMiddlename, String department, String post,  
			BigDecimal averageSalary, long taxIdentifNum, String education,
			String passport, String residence,  BigDecimal hourlyRate) throws MyException {
		
		super(personalNumber, surnameNameMiddlename, department, post, averageSalary,
				taxIdentifNum, education, passport, residence);
		
		this.setHourlyRate(hourlyRate); 
	}//�����������
//*********************************************************************************************

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
//**********************************************************************************************
	/**
	 * ����� �������� ArrayList �������� EmployeeHourlyWages:
	 * <p>* �������� MyUtil.readDataEmployeeFromFile(pathFileIn), ������� ��������� ������ </p>
	 * <p>* �������� �� ����� ����� ArrayList ������ �� �����������</p> 
	 * <p>* ������� ArrayList �������� EmployeeHourlyWages ��� ���� �����������, ������ ��� ������� ���� � �����</p> 
	 * @param pathFileIn String - ���� � ����� � ������� �� �����������
	 * @return ArrayList<EmployeeHourlyWages> - ������� �����������
	 * @throws Exception
	 */
	public static ArrayList<EmployeeHourlyWages> createArrayListObjEmplHourlyWagesFromFile(
			String pathFileIn) throws Exception {

		ArrayList<ArrayList<String>> dataEmplHourlyWages = MyUtil.readDataEmployeeFromFile(pathFileIn);
		ArrayList<EmployeeHourlyWages> arrayListObjEmplHourlyWages = new ArrayList<EmployeeHourlyWages>();
		for (int j = 0; j < dataEmplHourlyWages.size(); j++) {
			int personalNumber = Integer.valueOf(dataEmplHourlyWages.get(j).get(0));
			String surnameNameMiddlename = dataEmplHourlyWages.get(j).get(1);
			String department = dataEmplHourlyWages.get(j).get(2);
			String post = dataEmplHourlyWages.get(j).get(3);
			BigDecimal averageSalary = new BigDecimal(dataEmplHourlyWages.get(j).get(4));
			BigDecimal hourlyRate = new BigDecimal(dataEmplHourlyWages.get(j).get(5));
			long taxIdentifNum = Long.valueOf(dataEmplHourlyWages.get(j).get(6));
			String education = dataEmplHourlyWages.get(j).get(7);
			String passport = dataEmplHourlyWages.get(j).get(8);
			String residence = dataEmplHourlyWages.get(j).get(9);
			

			arrayListObjEmplHourlyWages.add(new EmployeeHourlyWages(personalNumber,
					surnameNameMiddlename, department, post, averageSalary,
					taxIdentifNum, education, passport, residence, hourlyRate));
		}// for
		return arrayListObjEmplHourlyWages;
	}// createArrayListObjEmplFixSalFromFile
		//**************************************************************************************************

	public static void main(String[] args) {
		
		
	}//main

}//class
