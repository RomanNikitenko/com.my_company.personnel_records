package com.company.personnelrecords.testmode;

import com.company.personnelrecords.util.MyUtil;

public class TestMode {

	
	private static String [] arrEducation = {"������-�����������", "������", "������������� ������",
											"�������"};
	private static String [] arrPost = 	  {"�����������", "�������", "�������", "��������",
									"����������� ��������", "����-��������", "��������",
									"������������� ��������"};
	private static String [] arrDepartment = {"����� ������ � ���������", "����������� �����", "���-�����", "������������� �����",
									"����� ������"};
	private static String [] arrOffPassport = {"���������� �� ����", "�������������� �� ����"};
	private static String [] arrCity = {"�. ��������", "�. ����", "�. �������", "�. �����"};
	private static String [] arrStreet = {"��. ��������", "��. ������", "��. �����������", "��. ������"};
	
	
//**************************************************************
	/**�����, ����������   random-������ �� ����� EmployeeFixedSalary � EmployeeHourlyWages 
	 * � ���������� �� � ����.
	 * ��� ��������� ��������� ������ ������������ ��� ���������:
	 * -  ������� ������ Test
	 * -  ���� � �������.
	 * @param amountEmployee int - ���������� ������������ �����������
	 * @param pathFileOut String - ���� � �����, � ������� ����� ����������� ������ ��������������� ������
	 * @return String [] - ������ ��������������� ������ 
	 * @throws Exception
	 */
	public static String[] generationEmployeeDataAndFiling (int amountEmployee, 
															String pathFileOut)	throws Exception {
		
		//���������� ������������������ �������, ���� � �������
		String [] arrSurnameNameMiddlename = generationRandomSurnameNameMiddlename(amountEmployee);
		
		// ���������� ������ random-data Education
		String [] arrRandomDataEducation = MyUtil.generationRandomCellsOfArray(arrEducation, amountEmployee);
		
		// ���������� ������ random-data Post
		String [] arrRandomDataPost = MyUtil.generationRandomCellsOfArray(arrPost, amountEmployee);
		
		// ���������� ������ random-data Department
		String [] arrRandomDataDepartment = MyUtil.generationRandomCellsOfArray(arrDepartment, amountEmployee);

		// ���������� ������ random-data OffPassport
		String [] arrRandomDataOffPassport = MyUtil.generationRandomCellsOfArray(arrOffPassport, amountEmployee);

		// ���������� ������ random-data CityPassport
		String [] arrRandomDataCityPassport = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);

		// ���������� ������ random-data CityResidence
		String [] arrRandomDataCityResidence = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);
		
		// ���������� ������ random-data street
		String [] arrRandomDataStreet = MyUtil.generationRandomCellsOfArray(arrStreet, amountEmployee);
		
		// ���������� ������ random-data numPassport
		String [] arrRandomDataNumPassport = MyUtil.generateRandomNumPass(amountEmployee);
		
		// ���������� ������ random-data ���� ������ ��������
		String [] arrRandomDataDatePassport = MyUtil.generateRandomDatePassport(amountEmployee);
		
		// ���������� ������ random-data ��������� �������
		int [] arrRandomDataZip = MyUtil.createArrRandomNum(amountEmployee, 10000, 19000);
		
		// ���������� ������ random-data ����� ����
		int [] arrRandomDataNumHouse = MyUtil.createArrRandomNum(amountEmployee, 1, 500);
		
		// ���������� ������ random-data ����� ��������
		int [] arrRandomDataNumApprtment = MyUtil.createArrRandomNum(amountEmployee, 1, 300);
		
		// ���������� ������ random-data ���������. �����
		long [] arrRandomDataTaxIdentifNum = MyUtil.createArrRandomNum(amountEmployee, 1000000000l, 9999999999l);

		// ���������� ������ random-data ������� ��������
		int [] arrRandomDataAverageSalary = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);

		// ���������� ������ random-data ��������� ����� ����������
		int [] arrRandomDataPersonalNum = MyUtil.createArrRandomNum(amountEmployee, 1, 10000);
		
		/*� ���� ���������� ������ ������ ����� ������� EmployeeHourlyWages � EmployeeFixedSalary
		*���������� ������ ������ hourlyRate � monthlyPayment. �������������� ������ ����� ������ ������������ ������
		* �� ����� ������� �����������. ��� ����� ������ ��������: 
		* - ���� �������� �����, � ������� ����� ����������� ������ �������� "EmployeesFixedSalary",
		* �� ���������� ���� "monthlyPayment" � ���������� random-data � ����
		* - ���� �������� �����, � ������� ����� ����������� ������ �������� "EmployeesHourlyWages",
		* �� ���������� ���� "hourlyRate" � ���������� random-data � ����
		*/ 
		String [] arrEmployeeData = new String [arrSurnameNameMiddlename.length];
		
		if (pathFileOut.indexOf("EmployeesFixedSalary") != (-1)) {
			int [] arrRandomDataMonthlyPayment = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);
			
			/* ���������� ��� ������ � ���� - ��������� ������ � ������ �����,
			 * ��� ���� ����� ���������� ���� ������ �������� �����
			 */
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   monthlyPayment: " + arrRandomDataMonthlyPayment[i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", ����� " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", ��. " + arrRandomDataNumApprtment[i];
			}//for
		}//
		else if (pathFileOut.indexOf("EmployeesHourlyWages") != (-1)) {
			int [] arrRandomDataHourlyRate = MyUtil.createArrRandomNum(amountEmployee, 13, 63);
		
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   hourlyRate: " + arrRandomDataHourlyRate [i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", ����� " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", ��. " + arrRandomDataNumApprtment[i];
			}//for

		}//
		//���������� �������������� ������ ���������� � ����
		MyUtil.recMassStr(pathFileOut, arrEmployeeData);
		
		return arrEmployeeData;
	}//generationEmployeeDataAndFiling

//**************************************************************
		/**�����: 1. ��������� �� ����� "InputForTest.in" (����� � ����� �������) ����� �������, ��������� �������,
		 * ����� � ��������; 2. ����������  ��������� ������� ������������������ �������, ���� � �������.
		 * ���������� ��������� ������� ������ �������(������������ ��� ����� ������� ��������()),
		 * ����� ���������� ���������� ��������� ��������() � ������������ � �������.
		 * ����� ����������� �� �����, ������������ ��������� ����� �����.
		 * �������� - ���������� �����.
		 * ������������� ������������ ������������������ �� �����.
		 * 
		 * @param amountGeneration int - ���������� ����������� ���������
		 * @return String [] - ������ ��������������� �������, ���� � ������� 
		 * @throws Exception
		 */
	public static String [] generationRandomSurnameNameMiddlename (int amountGeneration) throws Exception {
		
		//��������� ����, ������� �������� ����� �������, ��������� �������, ����� � ��������
		String [] arrStrFromFile = MyUtil.readFile("src/main/resources/InputForTest.in");
		
		String [] arrRootsSurnames = null;
		String [] arrSurnameCompletions = null;
		String [] arrNames = null;
		String [] arrMiddlenames = null;
		
		for (int i = 0; i < arrStrFromFile.length; i++) {
			String buf = arrStrFromFile[i];
			int indexKeyword1 = buf.indexOf("RootsOfSurnames:");
			int indexKeyword2 = buf.indexOf("CompletionsOfSurnames:");
			int indexKeyword3 = buf.indexOf("Names:");
			int indexKeyword4 = buf.indexOf("Middlenames:");
			if (indexKeyword1 != -1) {
				//��������� �� ����� ����� ������� � ������ �����
				arrRootsSurnames = MyUtil.returnArrTokenAfterKeyWord(buf, "RootsOfSurnames:");
			}//if
			else if (indexKeyword2 != -1) {
				//��������� �� ����� ��������� ������� � ������ �����
				arrSurnameCompletions = MyUtil.returnArrTokenAfterKeyWord(buf, "CompletionsOfSurnames:");
			}//if
			else if (indexKeyword3 != -1) {
				//��������� �� ����� ����� � ������ �����
				arrNames = MyUtil.returnArrTokenAfterKeyWord(buf, "Names:");
			}//if
			else if (indexKeyword4 != -1) {
				//��������� �� ����� �������� � ������ �����
				arrMiddlenames = MyUtil.returnArrTokenAfterKeyWord(buf, "Middlenames:");
			}//if
		}//for
		
		//���������� ������ ������� ����� �������
		int [] rootsNum = MyUtil.createArrRandomNum(amountGeneration, 0, arrRootsSurnames.length);
		
		//���������� ������ ������� ��������� �������
		int [] numComplet = MyUtil.createArrRandomNum(amountGeneration, 0, arrSurnameCompletions.length);
		
		//��������� ������ ������� � ���������� � ���������� � ������
		String [] arrRandomDataSurnames = MyUtil.glueCellsArrays(arrRootsSurnames, rootsNum, arrSurnameCompletions, numComplet);
		
		// ���������� ������ random-data ����
		String [] arrRandomDataNames = MyUtil.generationRandomCellsOfArray(arrNames, amountGeneration);

		// ���������� ������ random-data �������
		String [] arrRandomDataMiddlenames = MyUtil.generationRandomCellsOfArray(arrMiddlenames, amountGeneration);

		//��������� ������ ������� � �������� ���� � �������� ������� � ���� ������
		String[] arrResult = MyUtil.glueCellsArrays(arrRandomDataSurnames, arrRandomDataNames, arrRandomDataMiddlenames, " ");

		return arrResult;
	}//generationRandomSurnameNameMiddlename ()
//**************************************************************
	public static void main(String[] args) throws Exception {
//***********************************************************		
	}//main

}//class
