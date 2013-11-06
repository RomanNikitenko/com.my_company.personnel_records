package test;

import util.MyUtil;

public class Test {

	
	private static String [] arrEducation = {"������", "������������� ������",
									"�������", "������-�����������"};
	private static String [] arrPost = 	  {"�����������", "�������", "�������", "��������",
									"����������� ��������", "����-��������", "��������",
									"������������� ��������"};
	private static String [] arrDepartment = {"����� ������ � ���������", "����������� �����", "���-�����", "������������� �����",
									"����� ������"};
	private static String [] arrOffPassport = {"���������� �� ����", "�������������� �� ����"};
	private static String [] arrCity = {"�. ��������", "�. ����", "�. �������", "�. �����"};
	private static String [] arrStreet = {"��. ��������", "��. ������", "��. �����������", "��. ������"};
	
	
//**************************************************************
	/**�����, ����������   random-������ �� ����������� � ���������� �� � ����.
	 * ��� ��������� ��������� ������ ������������ ��� ���������:
	 * -  ������� ������ Test
	 * -  ����� � �������.
	 * @param amountEmployee int - ���������� ������������ �����������
	 * @param pathFileWithRoots String - ���� � ����� � ������� �������
	 * @param pathFileWithCompletions String - ���� � ����� � ����������� �������
	 * @param pathFileWithNames String - ���� � ����� � �������
	 * @param pathFileWithMiddlenames String - ���� � ����� � ����������
	 * @param pathFileOut String - ���� � �����, � ������� ����� ��������
	 *  ��������������� ������������������ �������, ���� � �������
	 * @return String [] - ������ ��������������� �������, ���� � ������� 
	 * @throws Exception
	 */
	public static String[] generationEmployeeDataAndFiling (int amountEmployee, String pathFileWithRoots,
			String pathFileWithCompletions, String pathFileWithNames, String pathFileWithMiddlenames,
			String pathFileOut)	throws Exception {
		
		//���������� ������������������ �������, ���� � �������
		String [] arrSurnameNameMiddlename = generationRandomSurnameNameMiddlename(amountEmployee, pathFileWithRoots,
											pathFileWithCompletions, pathFileWithNames,pathFileWithMiddlenames);
		
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
		
		/* ���������� ��� ������ � ���� - ��������� ������ � ������ �����,
		 * ��� ���� ����� ���������� ���� ������ �������� �����
		 */
		String [] arrEmployeeData = new String [arrSurnameNameMiddlename.length];
		
		for (int i = 0; i < arrEmployeeData.length; i++) {
			arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
					 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
					 "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] +
					 ", ����� " + arrRandomDataDatePassport[i] + ", " + arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + 
					 arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] + ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", ��. " + 
					 arrRandomDataNumApprtment[i];
		}//for
		
		//���������� �������������� ������ ���������� � ����
		MyUtil.recMassStr(pathFileOut, arrEmployeeData);
		
		return arrEmployeeData;
	}//generationEmployeeDataAndFiling

//**************************************************************
		/**�����, ����������  ��������� ������� ������������������ �������, ���� � �������.
		 * ���������� ��������� ������� ������ �������(������������ ��� ����� ������� ��������()),
		 * ����� ���������� ���������� ��������� ��������() � ������������ � �������.
		 * ����� ����������� �� �����, ������������ ��������� ����� �����.
		 * �������� - ���������� �����.
		 * ������������� ������������ ������������������ �� �����.
		 * @param pathFileWithRoots String - ���� � ����� � ������� �������
		 * @param pathFileWithCompletions String - ���� � ����� � ����������� �������
		 * @param pathFileWithNames String - ���� � ����� � �������
		 * @param pathFileWithMiddlenames String - ���� � ����� � ����������
		 * @return String [] - ������ ��������������� �������, ���� � ������� 
		 * @throws Exception
		 */
	public static String[] generationRandomSurnameNameMiddlename(int amountGeneration, String pathFileWithRoots,
			String pathFileWithCompletions, String pathFileWithNames, String pathFileWithMiddlenames)
			throws Exception {

		// ���������� ������� � ������ ����� (�������� ������ + �������� ���������)
		String[] arrRandomDataSurnames = generationRandomSurnames (amountGeneration, pathFileWithRoots, pathFileWithCompletions);

		// ��������� �� ����� ����� � ������ �����
		String[] arrNames = MyUtil.readFile(pathFileWithNames);
		
		// ��������� �� ����� �������� � ������ �����
		String[] arrMiddlenames = MyUtil.readFile(pathFileWithMiddlenames);

		// ���������� ������ random-data ����
		String [] arrRandomDataNames = MyUtil.generationRandomCellsOfArray(arrNames, amountGeneration);

		// ���������� ������ random-data �������
		String [] arrRandomDataMiddlenames = MyUtil.generationRandomCellsOfArray(arrMiddlenames, amountGeneration);

		//��������� ������ ������� � �������� ���� � �������� ������� � ���� ������
		String[] arrResult = MyUtil.glueCellsArrays(arrRandomDataSurnames, arrRandomDataNames, arrRandomDataMiddlenames, " ");
		
		return arrResult;
	}// generationRandomSurnameNameMiddlename ()

//**************************************************************
	/**�����, ����������  ��������� ������� ������������������ ������� �� ������ � ������� ���������.
	 * ���������� ��������� ������� ������ (������������ ��� ����� ������� ��������()),
	 * ����� ���������� ���������� ��������� ��������() � ������������ � �������.
	 * ������������� ������������ ������� �� �����.
	 * @param pathFileWithRoots String - ���� � ����� � ������� �������
	 * @param pathFileWithCompletions String - ���� � ����� � ����������� �������
	 * @return String [] - ������ ��������������� ������� 
	 * @throws Exception
	 */
	public static String [] generationRandomSurnames (int amountGeneration, String pathFileWithRoots, 
													  String pathFileWithCompletions) throws Exception {
		
		//��������� �� ����� ����� ������� � ������ �����
		String [] arrRootsSurnames = MyUtil.readFile(pathFileWithRoots);
		
		//��������� �� ����� ��������� ������� � ������ �����
		String [] arrNameCompletions = MyUtil.readFile(pathFileWithCompletions);
		
		//���������� ������ ������� ����� �������
		int [] rootsNum = MyUtil.createArrRandomNum(amountGeneration, 0, arrRootsSurnames.length);
		
		//���������� ������ ������� ��������� �������
		int [] numComplet = MyUtil.createArrRandomNum(amountGeneration, 0, arrNameCompletions.length);
		
		//��������� ������ ������� � ���������� � ���������� � ������
		String [] arrSurnames = MyUtil.glueCellsArrays(arrRootsSurnames, rootsNum, arrNameCompletions, numComplet);
		
		return arrSurnames;
	}//generationRandomSurnames ()
//**************************************************************
	public static void main(String[] args) throws Exception {
//***********************************************************		
		generationEmployeeDataAndFiling(50, "C:\\PersonnelRecordsTest\\RootsOfSurnames.in", "C:\\PersonnelRecordsTest\\CompletionsOfnames.in",
				"C:\\PersonnelRecordsTest\\Names.in", "C:\\PersonnelRecordsTest\\Middlename.in", "TestListEmployee.out");
	}//main

}//class
