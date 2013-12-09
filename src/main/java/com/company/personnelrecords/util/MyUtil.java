package com.company.personnelrecords.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.Employee;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.company.EmployeeHourlyWages;

public class MyUtil {
	
	public static void saveEmployeeDataInFile(String pathFileOut) throws Exception {
		ArrayList<Employee> arrListEmployeeData = Company.getInstance().getArrListObjAllEmployee();
		String [] arrResult = new String[arrListEmployeeData.size()];
		
		if (pathFileOut.indexOf("EmployeesFixedSalary") != (-1)) {
			
			for (int i = 0; i < arrListEmployeeData.size(); i++) {
				arrResult[i] = "Personal Number: " + arrListEmployeeData.get(i).getPersonalNumber() +  
						"   surname/Name/Middlename: " +  arrListEmployeeData.get(i).getSurnameNameMiddlename() +
						 "   department: " +  arrListEmployeeData.get(i).getDepartment() +  
						 "   post: " + arrListEmployeeData.get(i).getPost() +  
						 "   averageSalary: " +  arrListEmployeeData.get(i).getAverageSalary() +
						 "   monthlyPayment: " + ((EmployeeFixedSalary) arrListEmployeeData.get(i)).getMonthlyPayment() + 
						 "   taxIdentifNum: " + arrListEmployeeData.get(i).getTaxIdentifNum() + 
						 "   Education: " + arrListEmployeeData.get(i).getEducation() + 
						 "   Passport: " + arrListEmployeeData.get(i).getPassport() + 
						 "   Residance: " + arrListEmployeeData.get(i).getResidence();
			}//for
		}//
		else if (pathFileOut.indexOf("EmployeesHourlyWages") != (-1)) {
		
			for (int i = 0; i < arrListEmployeeData.size(); i++) {
				arrResult[i] = "Personal Number: " + arrListEmployeeData.get(i).getPersonalNumber() +  
						"   surname/Name/Middlename: " +  arrListEmployeeData.get(i).getSurnameNameMiddlename() +
						 "   department: " +  arrListEmployeeData.get(i).getDepartment() +  
						 "   post: " + arrListEmployeeData.get(i).getPost() +  
						 "   averageSalary: " +  arrListEmployeeData.get(i).getAverageSalary() +
						 "   hourlyRate: " + ((EmployeeHourlyWages) arrListEmployeeData.get(i)).getHourlyRate() + 
						 "   taxIdentifNum: " + arrListEmployeeData.get(i).getTaxIdentifNum() + 
						 "   Education: " + arrListEmployeeData.get(i).getEducation() + 
						 "   Passport: " + arrListEmployeeData.get(i).getPassport() + 
						 "   Residance: " + arrListEmployeeData.get(i).getResidence();
			}//for
		}//
		MyUtil.recMassStr(pathFileOut, arrResult);
	}//saveEmployeeDataInFile

	/**
	 * ����� �������� � ����� ������, ���������� �������� �����, �� ������,
	 * ���������� � ���������.
	 * 
	 * @param strForFiling
	 *            String - ������ ��� ���������� � �����
	 * @param pathFileIn
	 *            String - ���� � �����
	 * @param keyword
	 *            String - �������� ����� ��� ������ ���������������� ������
	 * @return void
	 * @throws IOException
	 */

	// ****************************************************************************
	public static void replacementStrInFile (String strForFiling, String pathFileIn, String keyword) throws IOException {
		
		BufferedReader fBufReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFileIn), "UTF-8"));
		String pathFileOut = pathFileIn + "1";
		BufferedWriter fBufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFileOut), "UTF-8"));
		
		String buf; 
		while ((buf = fBufReader.readLine()) != null) {
			if (buf.indexOf(keyword)!= -1){
				fBufWriter.write(strForFiling);
			}//if
			else fBufWriter.write(buf);
			fBufWriter.newLine();
		}//while
		
		fBufReader.close();
		fBufWriter.close();
		
    Files.move(Paths.get(pathFileOut), Paths.get(pathFileIn), StandardCopyOption.REPLACE_EXISTING);
	}//filingCompanyData

	// ***************************************************************************
	/**
	 * ����� ������ ������ ��� ���� "Company Data" � ������� �
	 * ArrayList<ArrayList<String>>. ������ ������ �������� �� ���������� ����,
	 * ������� ���� ����� ��������� �����
	 * 
	 * @param pathFileIn
	 *            String - ���� � �����
	 * @return ArrayList<ArrayList<String>> - ��������� ������
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<String>> readCompanyDataFromFile(
			String pathFileIn) {
		try {
			ArrayList<ArrayList<String>> arrListCompanyData = new ArrayList<ArrayList<String>>();

			BufferedReader fBufReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(pathFileIn),
							"UTF-8"));
			String buf;

			while ((buf = fBufReader.readLine()) != null) {

				if (buf.indexOf("Company Name:") != -1) {
					ArrayList<String> rowCompanyName = new ArrayList<String>();
					rowCompanyName.add(returnStrBetweenKeyWords(buf,
							"Company Name:", "companyCEO:"));
					rowCompanyName.add(returnStrBetweenKeyWords(buf,
							"companyCEO:", "companyCurrentAccount:"));
					rowCompanyName.add(returnStrBetweenKeyWords(buf,
							"companyCurrentAccount:", "companyEDRPOU:"));
					rowCompanyName.add(returnStrBetweenKeyWords(buf,
							"companyEDRPOU:", "companyRegisteredOffice:"));
					rowCompanyName.add(returnStrAfterKeyWord(buf,
							"companyRegisteredOffice:"));
					arrListCompanyData.add(rowCompanyName);
				}// if
				else if (buf.indexOf("Departments:") != -1) {

					ArrayList<String> rowDepartments = new ArrayList<String>(
							Arrays.asList(returnArrTokenAfterKeyWord(buf,
									"Departments:")));
					arrListCompanyData.add(rowDepartments);
				}// else if
				else if (buf.indexOf("Posts:") != -1) {

					ArrayList<String> rowPosts = new ArrayList<String>(
							Arrays.asList(returnArrTokenAfterKeyWord(buf,
									"Posts:")));
					arrListCompanyData.add(rowPosts);
				}// else if
				else if (buf.indexOf("PostSalaries:") != -1) {

					ArrayList<String> rowPostSalaries = new ArrayList<String>(
							Arrays.asList(returnArrTokenAfterKeyWord(buf,
									"PostSalaries:")));
					arrListCompanyData.add(rowPostSalaries);
				}// else if
			}// while
			fBufReader.close();

			return arrListCompanyData;
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Please restart the application and to get started, select the submenu 'Test Mode -> Generate Company'",
							"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return null;
	}// readCompanyDataFromFile()

	// ***************************************************************************
	/**
	 * ����� ������ ������ �� ����������� �� ����� � ������� �
	 * ArrayList<ArrayList<String>>. ������ ������ �������� �� ���������� ����,
	 * ������� ���� ����� ��������� �����
	 * 
	 * @param pathFileIn
	 *            String - ���� � �����
	 * @return ArrayList<ArrayList<String>> - ��������� ������
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<String>> readDataEmployeeFromFile(
			String pathFileIn) throws Exception {

		ArrayList<ArrayList<String>> arrListDataEmployees = new ArrayList<ArrayList<String>>();

		BufferedReader fBufReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(pathFileIn), "UTF-8"));
		String buf;

		while ((buf = fBufReader.readLine()) != null) {

			ArrayList<String> row = new ArrayList<String>();
			row.add(returnStrBetweenKeyWords(buf, "Personal Number:",
					"surname/Name/Middlename:"));
			row.add(returnStrBetweenKeyWords(buf, "surname/Name/Middlename:",
					"department:"));
			row.add(returnStrBetweenKeyWords(buf, "department:", "post:"));
			row.add(returnStrBetweenKeyWords(buf, "post:", "averageSalary:"));
			row.add(returnStrBetweenKeyWords(buf, "taxIdentifNum:",
					"Education:"));
			row.add(returnStrBetweenKeyWords(buf, "Education:", "Passport:"));
			row.add(returnStrBetweenKeyWords(buf, "Passport:", "Residance:"));
			row.add(returnStrAfterKeyWord(buf, "Residance:"));

			int indexKeyword1 = buf.indexOf("monthlyPayment");
			int indexKeyword2 = buf.indexOf("hourlyRate");

			if (indexKeyword1 != (-1)) {
				row.add(4,
						returnStrBetweenKeyWords(buf, "averageSalary:",
								"monthlyPayment:"));
				row.add(5,
						returnStrBetweenKeyWords(buf, "monthlyPayment:",
								"taxIdentifNum:"));
			}//
			else if (indexKeyword2 != (-1)) {
				row.add(4,
						returnStrBetweenKeyWords(buf, "averageSalary:",
								"hourlyRate:"));
				row.add(5,
						returnStrBetweenKeyWords(buf, "hourlyRate:",
								"taxIdentifNum:"));
			}//
			arrListDataEmployees.add(row);
		}// while
		fBufReader.close();
		return arrListDataEmployees;
	}// readDataEmployeeFromFile()
		// *****************************************************************************************************

	/**
	 * ����� ��������� ���� ����� ��������� �������
	 * 
	 * @param strForAnalysis
	 *            String - ������ ��� �������
	 * @param keyWord1
	 *            String - ������ �������� �����
	 * @param keyWord2
	 *            String - ������ �������� �����
	 * 
	 * @return String - ���������, ������� ��������� ����� �������� ����
	 */
	public static String returnStrBetweenKeyWords(String strForAnalysis,
			String keyWord1, String keyWord2) {

		int indexKeyWord1 = strForAnalysis.indexOf(keyWord1);
		int indexKeyWord2 = strForAnalysis.indexOf(keyWord2);
		String result = strForAnalysis.substring(
				indexKeyWord1 + keyWord1.length(), indexKeyWord2).trim();
		return result;
	}// returnStrBetweenKeyWords
		// *****************************************************************************************************

	/**
	 * ����� ��������� ����, ������� ����� ����� ��������� ����� �� ����� ������
	 * 
	 * @param strForAnalysis
	 *            String - ������ ��� �������
	 * @param keyWord1
	 *            String - ������ �������� �����
	 * @param keyWord2
	 *            String - ������ �������� �����
	 * @return String - ���������, ������� ��������� ����� �������� ����
	 */
	public static String returnStrAfterKeyWord(String strForAnalysis,
			String keyWord) {

		int indexKeyWord = strForAnalysis.indexOf(keyWord);
		String result = strForAnalysis.substring(
				indexKeyWord + keyWord.length()).trim();
		return result;
	}// returnStrAfterKeyWord

	// ******************************************************
	/**
	 * ����� ��������� ���������, ������� ����� ����� ��������� �����, �� ������
	 * � ���������� �� � ���� �������
	 * 
	 * @param strForAnalysis
	 *            String - ������ ��� �������
	 * @param keyWord
	 *            String - �������� �����
	 * @return String[] - ������ �������, ���������� �� ���������, ������� �����
	 *         ����� ��������� �����.
	 */
	public static String[] returnArrTokenAfterKeyWord(String strForAnalysis,
			String keyWord) {

		ArrayList<String> arrListTokens = new ArrayList<String>();
		int indexKeyWord = strForAnalysis.indexOf(keyWord);
		String subStr = strForAnalysis.substring(
				indexKeyWord + keyWord.length()).trim();

		StringTokenizer strToken = new StringTokenizer(subStr, ":,\t\n\r\f");
		while (strToken.hasMoreTokens()) {
			arrListTokens.add(strToken.nextToken().trim());
		}// while

		return arrListTokens.toArray(new String[arrListTokens.size()]);
	}// returnStrAfterKeyWord()

	// *******************************************************
	/**
	 * ����� ��������� �� ���� ������ String [] � ���������� ���������.
	 * ���������� ������ arrResult.length = amountGeneration, ������ ������
	 * �������� = random-������ �������, ����������� � ���������
	 * 
	 * @param arr
	 *            String [] - �������� ������ ��� ��������� random-������
	 * @param amountGeneration
	 *            int - ���������� ����������� ��������� random-����� =
	 *            arrResult.length ������� ����������
	 * @return String [] - ������ ������� ����������
	 */
	public static String[] generationRandomCellsOfArray(String[] arr,
			int amountGeneration) {
		// ���������� ������ random-������� �������, ����������� � ���������
		int[] arrRandomNumCells = createArrRandomNum(amountGeneration, 0,
				arr.length);

		String[] arrResult = new String[amountGeneration];
		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = arr[arrRandomNumCells[i]];
		}// for
		return arrResult;
	}// generationRandomCellsOfArray ()

	// ******************************************************************************************
	/**
	 * ����� ���������� �������� � ��������� ���������� ��������� ����� �
	 * ������� ���������
	 * 
	 * @param quantityNum
	 *            int - ���������� ��������� ��������� �����
	 * @param num1
	 *            long - ������ ������� ���������
	 * @param num2
	 *            long - ������� ������� ���������
	 * @return long [] - ������ ��������� ����� � �������� ���������
	 */
	public static long[] createArrRandomNum(int quantityNum, long num1,
			long num2) {

		Random rndm = new Random();
		long[] arrRandomNum = new long[quantityNum];

		if (num2 > num1) {
			for (int i = 0; i < quantityNum; i++) {
				arrRandomNum[i] = num1 + rndm.nextInt((int) (num2 - num1));
			}// for
		}// if
		else
			System.out
					.println("������ ������������ �������� ��������: ��������2 ������ ���������1");

		return arrRandomNum;
	}// ArrRandomNum
		// ***********************************************************************************************************************************

	/**
	 * ����� ���������� ������ ����� � ����, ���� � �������� ������� � ���������
	 * � ���������, ����������� �� ������ � ����
	 * 
	 * @param pathFileOut
	 *            String - ���� � ����� ��� ������
	 * @param massStrForRec
	 *            String [] - ������ ����� ��� ������
	 * @return boolean - ��� ���� ���� � ����������� �� ���������� ������ �����
	 * @throws Exception
	 */
	public static boolean recMassStr(String pathFileOut, String[] massStrForRec)
			throws Exception {

		BufferedWriter fBufWr = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(pathFileOut), "UTF-8"));

		for (int i = 0; i < massStrForRec.length; i++) {
			fBufWr.write(massStrForRec[i]);
			fBufWr.newLine();
		}// for
		fBufWr.close();
		return checkRecFile(pathFileOut);
	}// recMassStr ()

	// ************************************************************************************
	/**
	 * ����� ��������� ����������� �� ������ � ����
	 * 
	 * @param pathFileOut
	 *            String - ���� � �����
	 * @return boolean - ���, ���� raf.length() > 0, ����� ����
	 * @throws IOException
	 */
	public static boolean checkRecFile(String pathFileOut) throws IOException {

		boolean retVal = false;

		RandomAccessFile raf = new RandomAccessFile(pathFileOut, "r");
		if (raf.length() > 0) {
			retVal = true;
		}// if
		else
			retVal = false;
		raf.close();
		return retVal;
	}// checkRecFile ()

	// ******************************************************************************

	/**
	 * ����� ������� ������� �������� ����� � �����, ���������� � ������
	 * 
	 * @param pathFileIn
	 *            String - ���� � �����
	 * @return int [] - ������ ������� �������� ����� � �����, ���������� �
	 *         ������
	 * @throws Exception
	 */
	public static int[] countStrInFile(String pathFileIn) throws Exception {

		RandomAccessFile raf = new RandomAccessFile(pathFileIn, "r");
		int count = 0; // ���-�� �������� ����� �����

		while (raf.getFilePointer() < raf.length()) {
			if (raf.readLine().trim().length() > 0) {
				count++;
			}// if
		}// while

		int[] massPosNoneEmptyStr = new int[count];
		count = 0;
		raf.seek(0);

		while (raf.getFilePointer() < raf.length()) {

			int posBeginStr = (int) raf.getFilePointer();
			String buf = raf.readLine().trim();

			if (buf.length() > 0) {
				massPosNoneEmptyStr[count] = posBeginStr;
				count++;
			}// if
		}// while
		raf.close();
		return massPosNoneEmptyStr;
	}// countStrInFile

	// ******************************************************************************
	/**
	 * ����� ��������� ���� � ���������� ������ �����
	 * 
	 * @param pathFileIn
	 *            String - ���� � ����� ��� ����������
	 * @return String [] - ������ ��������� �����
	 * @throws Exception
	 */
	public static String[] readFile(String pathFileIn) throws Exception {

		int[] massPosStr = countStrInFile(pathFileIn);// ����� ������ �������
														// �������� ����� �����
		String[] massStr = new String[massPosStr.length];

		BufferedReader fBufReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(pathFileIn),
						"UTF-8"));

		for (int i = 0; i < massStr.length; i++) {
			massStr[i] = fBufReader.readLine().trim();
		}// for

		fBufReader.close();
		return massStr;
	}// readFile

	// ******************************************************
	/**
	 * ����� "���������" ������ ���� ���������� �������� (arr1.length =
	 * arr2.length) ��� ������� � ��. ������������, ��� ���� ������ �����������
	 * ����� ��������
	 * 
	 * @param arr1
	 *            String [] - ������1 ��� ����������
	 * @param numCell1
	 *            int [] - ������ ����� �������1 ��� ����������
	 * @param arr2
	 *            String [] - ������2 ��� ����������
	 * @param numCell2
	 *            int [] - ������ ����� �������2 ��� ����������
	 * @return String [] - ������ "���������" �����
	 */
	public static String[] glueCellsArrays(String[] arr1, int[] numCell1,
			String[] arr2, int[] numCell2) {
		String[] arrRes = new String[numCell1.length];
		for (int i = 0; i < arrRes.length; i++) {
			arrRes[i] = arr1[numCell1[i]] + arr2[numCell2[i]];
		}// for
		return arrRes;
	}// glueCellsArrays ()
		// ******************************************************

	/**
	 * ����� "���������" ������ ���� ���������� �������� (arr1.length =
	 * arr2.length = arr3.length) � ������������ (����������� � ���������)
	 * 
	 * @param arr1
	 *            String [] - ������1 ��� ����������
	 * @param arr2
	 *            String [] - ������2 ��� ����������
	 * @param arr3
	 *            String [] - ������3 ��� ����������
	 * @param delim
	 *            String - �����������
	 * @return String [] - ������ "���������" �����
	 */
	public static String[] glueCellsArrays(String[] arr1, String[] arr2,
			String[] arr3, String delim) {
		String[] arrResult = new String[arr1.length];
		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = arr1[i] + delim + arr2[i] + delim + arr3[i];
		}// for
		return arrResult;
	}// glueCellsArrays ()
		// *********************************************************

	/**
	 * ����� "���������" ������ ���� ���������� �������� (arr1.length =
	 * arr2.length) ��� ���� ��������� ����������� (delim)
	 * 
	 * @param arr1
	 *            String [] - ������1 ��� ����������
	 * @param arr2
	 *            String [] - ������2 ��� ����������
	 * @param delim
	 *            - �����������
	 * @return String [] - ������ "���������" �����
	 */
	public static String[] glueCellsArrays(String[] arr1, String[] arr2,
			String delim) {

		String[] arrRes = new String[arr1.length];

		for (int i = 0; i < arrRes.length; i++) {
			arrRes[i] = arr1[i] + delim + arr2[i];
		}// for

		return arrRes;
	}// glueCellsArrays
		// ******************************************************************************

	/**
	 * ����� ���������� ������ ��������� ����� � �������� ���������
	 * 
	 * @param quantityNum
	 *            int - ���������� ���������
	 * @param num1
	 *            int - ������ ������� ���������
	 * @param num2
	 *            int - ������� ������� ���������
	 * @return int[] - ������ ��������� �����
	 * @throws Exception
	 */

	public static int[] createArrRandomNum(int quantityNum, int num1, int num2) {

		Random rndm = new Random();
		int[] arrRandomNum = new int[quantityNum];

		if (num2 > num1) {
			for (int i = 0; i < quantityNum; i++) {
				arrRandomNum[i] = num1 + rndm.nextInt((int) (num2 - num1));
			}// for
		}// if
		else
			System.out
					.println("������ ������������ �������� ��������: ��������2 ������ ���������1");

		return arrRandomNum;
	}// ArrRandomNum

	// ******************************************************
	/**
	 * ����� ���������� ��������� ����� � �������� ���������
	 * 
	 * @param num1
	 *            long - ������ ������� ���������
	 * @param num2
	 *            long - ������� ������� ���������
	 * @return int[] - ������ ��������� �����
	 * @throws Exception
	 */
	public static long generateRandomNum(long num1, long num2) {

		Random rndm = new Random();
		long random = 0;

		if (num2 > num1) {
			random = num1 + rndm.nextInt((int) (num2 - num1));
		}// if
		else
			System.out
					.println("������ ������������ �������� ��������: ��������2 ������ ���������1");

		return random;
	}// randomNum
		// ******************************************************

	/**
	 * ����� ���������� �������� ����� ������� ��������� (����� ���� - ���
	 * ��������)
	 * 
	 * @param amountGeneration
	 *            int - ���������� ���������
	 * @return String [] - ������ ������� ���������
	 */
	public static String[] generateRandomNumPass(int amountGeneration) {

		Random rndm = new Random();
		String[] arrNumPass = new String[amountGeneration];

		for (int i = 0; i < amountGeneration; i++) {
			arrNumPass[i] = "HC"
					+ (111111 + rndm.nextInt((int) (999999 - 111111)));
		}// for
		return arrNumPass;
	}// generateRandomNumPass
		// ******************************************************

	/**
	 * ����� ���������� �������� ����� ��� ������ ���������
	 * 
	 * @param amountGeneration
	 *            int - ���������� ���������
	 * @return String [] - ������ ��� ������ ���������
	 */
	public static String[] generateRandomDatePassport(int amountGeneration) {

		Random rndm = new Random();
		NumberFormat formatter = NumberFormat.getNumberInstance();

		String[] arrDatePass = new String[amountGeneration];
		for (int i = 0; i < amountGeneration; i++) {

			String year = "" + (1940 + rndm.nextInt((int) (2000 - 1940)));

			formatter.setMinimumIntegerDigits(2);
			String month = formatter.format(1 + rndm.nextInt((int) (12 - 1)));

			String date = formatter.format(1 + rndm.nextInt((int) (31 - 1)));
			arrDatePass[i] = year + "." + month + "." + date;
		}// for
		return arrDatePass;
	}// generateRandomNumPass
		// ******************************************************
}// class