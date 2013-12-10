package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.Employee;
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
			
		if (arrObjEmpl == null) {
			generationEmployee(request);
		}
		else {
			saveEditedEmplFixSalData(request, response);
		}
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
	public  ArrayList<Employee> generationEmployee (HttpServletRequest request) throws Exception {
		
		
			int amountEmpl = Integer.valueOf(request
					.getParameter("quanityEmplFixSal"));

			String pathFileOut = "src/main/resources/EmployeesFixedSalary.efs";

			TestMode.generationEmployeeDataAndFiling(amountEmpl, pathFileOut);

			arrObjEmpl = instanceCompany
					.createArrayListObjEmplFixSalFromFile(pathFileOut);

			return arrObjEmpl;
	}//generationEmployee()
	//*******************************************************************************************
	public void saveEditedEmplFixSalData(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
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
}