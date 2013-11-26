package com.company.personnelrecords.company;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.util.MyUtil;

public class Company {

	private ArrayList<Employee> arrListObjAllEmployee;
	
	private static ArrayList<ArrayList<String>> arrCompanyData = 
			MyUtil.readCompanyDataFromFile("src/main/resources/CompanyData.cdt"); 
	
	private static Company INSTANCECOMPANY;
	
	String 	companyName,
			companyCEO,
			companyRegisteredOffice;
	long 	companyCurrentAccount,
			companyEDRPOU;

	//*******constructor**************************************
	private Company(String companyName, String companyCEO, 
			long companyCurrentAccount, long companyEDRPOU, String companyRegisteredOffice){
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyRegisteredOffice = companyRegisteredOffice;
		this.companyCurrentAccount = companyCurrentAccount;
		this.companyEDRPOU = companyEDRPOU;
	}//constructor
	//**********************************************************
	
	public static Company getInstance() {
		if (INSTANCECOMPANY == null) {
			synchronized (Company.class) {
				if (INSTANCECOMPANY == null) {
					INSTANCECOMPANY = new Company(arrCompanyData.get(0).get(0),
							arrCompanyData.get(0).get(1),
							Long.valueOf(arrCompanyData.get(0).get(2)),
							Long.valueOf(arrCompanyData.get(0).get(3)),
							arrCompanyData.get(0).get(4));
				}//if
			}//synchronized			
		}// if
		return INSTANCECOMPANY;
	}//getInstance()

	public static ArrayList<ArrayList<String>> getArrCompanyData() {
		return arrCompanyData;
	}

	public static void setArrCompanyData(ArrayList<ArrayList<String>> arrCompanyData) {
		Company.arrCompanyData = arrCompanyData;
	}

	public ArrayList<Employee> getArrListObjAllEmployee() {
		return arrListObjAllEmployee;
	}

	public void setArrListObjAllEmployee(ArrayList<Employee> arrListObjAllEmployee) {
		this.arrListObjAllEmployee = arrListObjAllEmployee;
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
	/**
	 * Метод создания ArrayList объектов AllEmployee:
	 * <p>* Создает ArrayList объектов EmployeeFixedSalary ДЛЯ ВСЕХ сотрудников, данные про которых есть в файле</p>
	 * <p>* Создает ArrayList объектов EmployeeHourlyWages ДЛЯ ВСЕХ сотрудников, данные про которых есть в файле</p>
	 * <p>* Соединяет полученные объекты в один ArrayList</p> 
	 * @param pathFileInEmplFixSal String - путь к файлу с данными по Сотрудникам EmployeeFixedSalary
	 * @param pathFileInEmplHourlyWages String - путь к файлу с данными по Сотрудникам EmployeeHourlyWages
	 * @return ArrayList<Employee> - объекты Сотрудников
	 * @throws Exception
	 */
	public ArrayList<Employee> createArrayListObjAllEmplFromFile (String pathFileInEmplFixSal, String pathFileInEmplHourlyWages)
			throws Exception {
		ArrayList<Employee> arrListObjEmplFixSal = new ArrayList<Employee>();
		arrListObjEmplFixSal = createArrayListObjEmplFixSalFromFile(pathFileInEmplFixSal);
		arrListObjAllEmployee = createArrayListObjEmplHourlyWagesFromFile(pathFileInEmplHourlyWages);
		arrListObjAllEmployee.addAll(arrListObjEmplFixSal);
		return arrListObjAllEmployee;
	}//createArrayListObjEmplFixSalFromFile
	//***********************************************************************************************
	/**
	 * Метод создания ArrayList объектов EmployeeFixedSalary:
	 * <p> * вызывает MyUtil.readDataEmployeeFromFile(pathFileIn), который считывает
	 * данные </p>
	 * <p>* Получает из этого файла ArrayList данных по сотрудникам * </p>
	 * <p>* Создает ArrayList объектов EmployeeFixedSalary ДЛЯ ВСЕХ сотрудников,
	 * данные про которых есть в файле * </p>
	 * 
	 * @param pathFileIn
	 *            String - путь к файлу с данными по Сотрудникам
	 * @return ArrayList<EmployeeFixedSalary> - объекты Сотрудников
	 * @throws Exception
	 */
	public ArrayList<Employee> createArrayListObjEmplFixSalFromFile(
			String pathFileIn) throws Exception {

		ArrayList<ArrayList<String>> dataEmplFixSal = MyUtil
				.readDataEmployeeFromFile(pathFileIn);
		arrListObjAllEmployee = new ArrayList<Employee>();

		for (int j = 0; j < dataEmplFixSal.size(); j++) {
			int personalNumber = Integer.valueOf(dataEmplFixSal.get(j).get(0));
			String surnameNameMiddlename = dataEmplFixSal.get(j).get(1);
			String department = dataEmplFixSal.get(j).get(2);
			String post = dataEmplFixSal.get(j).get(3);
			BigDecimal averageSalary = new BigDecimal(dataEmplFixSal.get(j)
					.get(4));
			BigDecimal monthlyPayment = new BigDecimal(dataEmplFixSal.get(j)
					.get(5));
			long taxIdentifNum = Long.valueOf(dataEmplFixSal.get(j).get(6));
			String education = dataEmplFixSal.get(j).get(7);
			String passport = dataEmplFixSal.get(j).get(8);
			String residence = dataEmplFixSal.get(j).get(9);

			arrListObjAllEmployee.add(new EmployeeFixedSalary(personalNumber,
					surnameNameMiddlename, department, post, averageSalary,
					taxIdentifNum, education, passport, residence,
					monthlyPayment));
		}// for
		return arrListObjAllEmployee;
	}// createArrayListObjEmplFixSalFromFile
	// **************************************************************************************************
	/**
	 * Метод создания ArrayList объектов EmployeeHourlyWages:
	 * <p>* вызывает MyUtil.readDataEmployeeFromFile(pathFileIn), который считывает данные </p>
	 * <p>* Получает из этого файла ArrayList данных по сотрудникам</p> 
	 * <p>* Создает ArrayList объектов EmployeeHourlyWages ДЛЯ ВСЕХ сотрудников, данные про которых есть в файле</p> 
	 * @param pathFileIn String - путь к файлу с данными по Сотрудникам
	 * @return ArrayList<EmployeeHourlyWages> - объекты Сотрудников
	 * @throws Exception
	 */
	public ArrayList<Employee> createArrayListObjEmplHourlyWagesFromFile(
			String pathFileIn) throws Exception {

		ArrayList<ArrayList<String>> dataEmplHourlyWages = MyUtil
				.readDataEmployeeFromFile(pathFileIn);
		arrListObjAllEmployee = new ArrayList<Employee>();
		
		for (int j = 0; j < dataEmplHourlyWages.size(); j++) {
			int personalNumber = Integer.valueOf(dataEmplHourlyWages.get(j)
					.get(0));
			String surnameNameMiddlename = dataEmplHourlyWages.get(j).get(1);
			String department = dataEmplHourlyWages.get(j).get(2);
			String post = dataEmplHourlyWages.get(j).get(3);
			BigDecimal averageSalary = new BigDecimal(dataEmplHourlyWages
					.get(j).get(4));
			BigDecimal hourlyRate = new BigDecimal(dataEmplHourlyWages.get(j)
					.get(5));
			long taxIdentifNum = Long
					.valueOf(dataEmplHourlyWages.get(j).get(6));
			String education = dataEmplHourlyWages.get(j).get(7);
			String passport = dataEmplHourlyWages.get(j).get(8);
			String residence = dataEmplHourlyWages.get(j).get(9);

			arrListObjAllEmployee.add(new EmployeeHourlyWages(
					personalNumber, surnameNameMiddlename, department, post,
					averageSalary, taxIdentifNum, education, passport,
					residence, hourlyRate));
		}// for
		return arrListObjAllEmployee;
	}// createArrayListObjEmplHourlyWagesFromFile
	//**************************************************************************************************
	public void addEmployee (String mark) {
		try {
			
			EmployeeCreator emplCreator = new EmployeeCreator();
			
			if (mark.equals("FixSal")){
				emplCreator.createNewEmplFixSal();
			}//if
			else if (mark.equals("HourlyWages")){
				emplCreator.createNewEmplHourlyWages();
			}//if
 
		} catch (StringDigitIncludeException e) {

			JOptionPane.showMessageDialog(null,	"Incorrect value!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}//addEmployee()
	//***************************************************************************************************
	public void deleteEmployee (int index) {
		try {
			Company.getInstance().getArrListObjAllEmployee().remove(index);
			
		} catch (IndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "Removing the last line does not work properly. Press 'Clean All', please!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}//deleteEmployee

}//class
