package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.IstringHelper;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.Employee;
import com.company.personnelrecords.company.EmployeeCreator;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.testmode.TestMode;
import com.company.personnelrecords.util.MyUtil;

public class EmplFixSalDataServlet extends HttpServlet {

	private Company instanceCompany;
	private static final String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Monthly <br>Payment", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	private ArrayList<Employee> arrObjEmpl;
	
	public void init() throws ServletException {
		instanceCompany = Company.getInstance();
	}// init
	//****************************************************************************************
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			
			switch (request.getParameter("HIDDEN")) {
			case "generateEmplFixSalData":
				generationEmployee(request);
				break;

			case "saveEmplFixSalData": 
				saveEditedEmplFixSalDataFromForm(request, response);
				break;
		
			case "addEmplFixSal": 
				addEmplFixSal(request);
				break;

			case "delEmplFixSal": 
				deleteEmplFixSal(request);
				break;

			}//switch
			
			request.getSession().setAttribute("calend", Calendar.getInstance());
			request.setAttribute("arrColumnNames", columnNames);
			request.setAttribute("arrObjEmpl",
					instanceCompany.getArrListObjAllEmployee());
			request.getRequestDispatcher("/emplFixSalData.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// doPost
	//*****************************************************************************************
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	//******************************************************************************************
	public void generationEmployee (HttpServletRequest request) throws Exception {

		int amountEmpl = Integer.valueOf(request
				.getParameter("quanityEmplFixSal"));

		String pathFileOut = "src/main/resources/EmployeesFixedSalary.efs";

		TestMode.generationEmployeeDataAndFiling(amountEmpl, pathFileOut);

		instanceCompany.createArrayListObjEmplFixSalFromFile(pathFileOut);
		
		arrObjEmpl = instanceCompany.getArrListObjAllEmployee();
	}//generationEmployee()
	//*******************************************************************************************
	public void saveEditedEmplFixSalDataFromForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			for (int i = 0; i < arrObjEmpl.size(); i++) {

			
				arrObjEmpl.get(i).setSurnameNameMiddlename(
						request.getParameter("surnameNameMiddlename"
								+ arrObjEmpl.get(i).getPersonalNumber()));
				arrObjEmpl.get(i).setDepartment(
						request.getParameter("department"
								+ arrObjEmpl.get(i).getPersonalNumber()));
				arrObjEmpl.get(i).setPost(
						request.getParameter("post"
								+ arrObjEmpl.get(i).getPersonalNumber()));
				arrObjEmpl
						.get(i)
						.setAverageSalary(
								BigDecimal.valueOf(Long.valueOf(request
										.getParameter("averageSalary"
												+ arrObjEmpl.get(i)
														.getPersonalNumber()))));
				((EmployeeFixedSalary) arrObjEmpl.get(i))
						.setMonthlyPayment(BigDecimal.valueOf(Long
								.valueOf(request
										.getParameter("monthlyPayment"
												+ arrObjEmpl.get(i)
														.getPersonalNumber()))));
				arrObjEmpl.get(i).setTaxIdentifNum(
						Long.valueOf(request.getParameter("taxIdentifNum"
								+ arrObjEmpl.get(i).getPersonalNumber())));
				arrObjEmpl.get(i).setEducation(
						request.getParameter("education"
								+ arrObjEmpl.get(i).getPersonalNumber()));
				arrObjEmpl.get(i).setPassport(
						request.getParameter("passport"
								+ arrObjEmpl.get(i).getPersonalNumber()));
				arrObjEmpl.get(i).setResidence(
						request.getParameter("residence"
								+ arrObjEmpl.get(i).getPersonalNumber()));
			}//for
			MyUtil.saveEmployeeDataInFile("src/main/resources/EmployeesFixedSalary.efs");
			} catch (StringDigitIncludeException e) {
				request.getRequestDispatcher("/error/errorStringDigitIncludeEception.jsp").forward(request,
						response);
				e.printStackTrace();
			}
	}//saveEditedemplFixSalData
//**************************************************************************************************************
	public void addEmplFixSal(HttpServletRequest request) throws Exception {
		
		String personalNumber = 		request.getParameter("personalNumber");
		String surnameNameMiddlename = 	request
				.getParameter("surnameNameMiddlename");
		String department = 			request.getParameter("department");
		String post = 					request.getParameter("post");
		String averageSalary = 			request.getParameter("averageSalary");
		String monthlyPayment = 		request.getParameter("monthlyPayment");
		String taxIdentifNum = 			request.getParameter("taxIdentifNum");
		String education = 				request.getParameter("education");
		String passport = 				request.getParameter("passport");
		String residence = 				request.getParameter("residence");
		
		try {
			new EmployeeCreator().addEmplFixSal(Integer.valueOf(personalNumber),
					surnameNameMiddlename, department, post, BigDecimal.valueOf(Long.valueOf(averageSalary)),
					Long.valueOf(taxIdentifNum), education, passport, residence, BigDecimal.valueOf(Long.valueOf(monthlyPayment)));
	
		arrObjEmpl = instanceCompany.getArrListObjAllEmployee();
		MyUtil.saveEmployeeDataInFile("src/main/resources/EmployeesFixedSalary.efs");

		} catch (NumberFormatException | StringDigitIncludeException e) {
			e.printStackTrace();
		}
	}//saveEmplFixSalDataAfterAddEmpl
	//*************************************************************************************************************
	public void deleteEmplFixSal(HttpServletRequest request) throws Exception{
		int persNumberEmplForDelete = Integer.valueOf(request
				.getParameter("persNumberEmplForDelete"));
		instanceCompany.deleteEmployeeByPersNumber(persNumberEmplForDelete);
		arrObjEmpl = instanceCompany.getArrListObjAllEmployee();
		MyUtil.saveEmployeeDataInFile("src/main/resources/EmployeesFixedSalary.efs");
	}//updateEmplFixSalDataAfterDeleteEmpl
}