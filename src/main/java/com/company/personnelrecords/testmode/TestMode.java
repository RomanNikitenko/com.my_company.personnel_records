package com.company.personnelrecords.testmode;

import com.company.personnelrecords.util.MyUtil;

public class TestMode {

	private static String [] arrCompanyName = {"IBM-Company", "Google-Company", "Sumsung-Company",
											"Lenovo-Company"};
	private static String [] arrEducation = {"High School", "Higher", " Vocational education"};
	private static String [] arrPost = 	  {"Chief Engineer", "Executive Director", "Accountant", "General Director",
									"Programmer", "Clerk", "Assistant", "Laborer"};
	private static int [] arrPostSalary = {8000, 6000, 4000, 5000, 10000, 4500, 5500, 3000};

	private static String [] arrDepartment = {"Material department", "Payroll department", "Department of programmers",
											"Department of designers", "Department of engineers"};
	private static String [] arrOffPassport = {"Ministry of Internal Affairs, district division of Cherkassy city department",
												"Ministry of Internal Affairs, district division of Kiev city department"};
	private static String [] arrCity = {"Kiev", "Cherkassy", "Kharkiv", "Lviv", "Moscow"};
	private static String [] arrStreet = {"Shevchenko str.", "Gogol str.", "University str.", "Chekhov str."};
	
	
	//**************************************************************
		public static String[] generationCompanyDataAndFiling (String pathFileOut)	throws Exception {
			
			String companyName = (MyUtil.generationRandomCellsOfArray(arrCompanyName, 1))[0];

			String companyCEO = generationRandomSurnameNameMiddlename(1)[0];
			
			String cityCompanyRegisteredOffice = MyUtil.generationRandomCellsOfArray(arrCity, 1)[0];
			
			String streetCompanyRegisteredOffice = MyUtil.generationRandomCellsOfArray(arrStreet, 1)[0];
			
			int zipCompanyRegisteredOffice = MyUtil.createArrRandomNum(1, 10000, 19000)[0];
			
			int numHouseCompanyRegisteredOffice = MyUtil.createArrRandomNum(1, 1, 500)[0];
			
			int numApprtmentCompanyRegisteredOffice = MyUtil.createArrRandomNum(1, 1, 50)[0];
			
			long companyCurrentAccount = MyUtil.createArrRandomNum(1, 1000000000l, 9999999999l)[0];

			long companyEDRPOU = MyUtil.createArrRandomNum(1, 1000000000l, 9999999999l)[0];

			String [] companyData = new String [4];
			companyData [0] = "Company Name: " + companyName +  "   companyCEO: " +  companyCEO +
							 "   companyCurrentAccount: " +  companyCurrentAccount +  "   companyEDRPOU: " + companyEDRPOU +
							 "   companyRegisteredOffice: " + zipCompanyRegisteredOffice + ", " + cityCompanyRegisteredOffice +
							 ", " + streetCompanyRegisteredOffice + " " + numHouseCompanyRegisteredOffice + ", " + numApprtmentCompanyRegisteredOffice;
			
			companyData [1] = "Departments: " + arrDepartment[0] + ", " + arrDepartment[1] + ", " + arrDepartment[2] + ", "
								+ arrDepartment[3] + ", " + arrDepartment[4];
			
			companyData [2] = "Posts: " + arrPost[0] + ", " + arrPost[1] + ", " + arrPost[2] + ", "
					+ arrPost[3] + ", " +  arrPost[4] + ", " + arrPost[5] + ", "
							+ arrPost[6] + ", " + arrPost[7];
			
			companyData [3] = "PostSalaries: " + arrPostSalary[0] + ", " + arrPostSalary[1] + ", " + arrPostSalary[2] + ", "
					+ arrPostSalary[3] + ", " + arrPostSalary[4] + ", " + arrPostSalary[5] + ", "
							+ arrPostSalary[6] + ", " + arrPostSalary[7];

			MyUtil.recMassStr(pathFileOut, companyData);
			
			return companyData;
		}//generationCompanyDataAndFiling
//**************************************************************
	public static String[] generationEmployeeDataAndFiling (int amountEmployee, 
															String pathFileOut)	throws Exception {
		
		String [] arrSurnameNameMiddlename = generationRandomSurnameNameMiddlename(amountEmployee);
		
		String [] arrRandomDataEducation = MyUtil.generationRandomCellsOfArray(arrEducation, amountEmployee);
		
		String [] arrRandomDataPost = MyUtil.generationRandomCellsOfArray(arrPost, amountEmployee);
		
		String [] arrRandomDataDepartment = MyUtil.generationRandomCellsOfArray(arrDepartment, amountEmployee);

		String [] arrRandomDataOffPassport = MyUtil.generationRandomCellsOfArray(arrOffPassport, amountEmployee);

		String [] arrRandomDataCityPassport = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);

		String [] arrRandomDataCityResidence = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);
		
		String [] arrRandomDataStreet = MyUtil.generationRandomCellsOfArray(arrStreet, amountEmployee);
		
		String [] arrRandomDataNumPassport = MyUtil.generateRandomNumPass(amountEmployee);
		
		String [] arrRandomDataDatePassport = MyUtil.generateRandomDatePassport(amountEmployee);
		
		int [] arrRandomDataZip = MyUtil.createArrRandomNum(amountEmployee, 10000, 19000);
		
		int [] arrRandomDataNumHouse = MyUtil.createArrRandomNum(amountEmployee, 1, 500);
		
		int [] arrRandomDataNumApprtment = MyUtil.createArrRandomNum(amountEmployee, 1, 300);
		
		long [] arrRandomDataTaxIdentifNum = MyUtil.createArrRandomNum(amountEmployee, 1000000000l, 9999999999l);

		int [] arrRandomDataAverageSalary = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);

		int [] arrRandomDataPersonalNum = MyUtil.createArrRandomNum(amountEmployee, 1, 10000);
		
		String [] arrEmployeeData = new String [arrSurnameNameMiddlename.length];
		
		if (pathFileOut.indexOf("EmployeesFixedSalary") != (-1)) {
			int [] arrRandomDataMonthlyPayment = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);
			
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   monthlyPayment: " + arrRandomDataMonthlyPayment[i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", issued " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", Apt. " + arrRandomDataNumApprtment[i];
			}//for
		}//
		else if (pathFileOut.indexOf("EmployeesHourlyWages") != (-1)) {
			int [] arrRandomDataHourlyRate = MyUtil.createArrRandomNum(amountEmployee, 13, 63);
		
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   hourlyRate: " + arrRandomDataHourlyRate [i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", issued " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", Apt. " + arrRandomDataNumApprtment[i];
			}//for

		}//
		MyUtil.recMassStr(pathFileOut, arrEmployeeData);
		
		return arrEmployeeData;
	}//generationEmployeeDataAndFiling

//**************************************************************
	public static String [] generationRandomSurnameNameMiddlename (int amountGeneration) throws Exception {
		
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
				arrRootsSurnames = MyUtil.returnArrTokenAfterKeyWord(buf, "RootsOfSurnames:");
			}//if
			else if (indexKeyword2 != -1) {
				arrSurnameCompletions = MyUtil.returnArrTokenAfterKeyWord(buf, "CompletionsOfSurnames:");
			}//if
			else if (indexKeyword3 != -1) {
				arrNames = MyUtil.returnArrTokenAfterKeyWord(buf, "Names:");
			}//if
			else if (indexKeyword4 != -1) {
				arrMiddlenames = MyUtil.returnArrTokenAfterKeyWord(buf, "Middlenames:");
			}//if
		}//for
		
		int [] rootsNum = MyUtil.createArrRandomNum(amountGeneration, 0, arrRootsSurnames.length);
		
		int [] numComplet = MyUtil.createArrRandomNum(amountGeneration, 0, arrSurnameCompletions.length);
		
		String [] arrRandomDataSurnames = MyUtil.glueCellsArrays(arrRootsSurnames, rootsNum, arrSurnameCompletions, numComplet);
		
		String [] arrRandomDataNames = MyUtil.generationRandomCellsOfArray(arrNames, amountGeneration);

		String [] arrRandomDataMiddlenames = MyUtil.generationRandomCellsOfArray(arrMiddlenames, amountGeneration);

		String[] arrResult = MyUtil.glueCellsArrays(arrRandomDataSurnames, arrRandomDataNames, arrRandomDataMiddlenames, " ");

		return arrResult;
	}//generationRandomSurnameNameMiddlename ()
//**************************************************************
	public static void main(String[] args) throws Exception {
//***********************************************************		
	}//main

}//class
