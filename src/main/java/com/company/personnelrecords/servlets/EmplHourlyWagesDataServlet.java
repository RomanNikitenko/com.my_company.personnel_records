package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.Employee;
import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.testmode.TestMode;

public class EmplHourlyWagesDataServlet extends HttpServlet {

	private Company instanceCompany;
	private static final String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Hourly <br>Rate", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};

	public void init() throws ServletException {
		instanceCompany = Company.getInstance();
	}// init
	//****************************************************************************************
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		request.setAttribute("arrObjEmpl", generationEmployee(request
				.getParameter("quanityEmplHourlyWages")));
		request.setAttribute("arrColumnNames", columnNames);
		request.getRequestDispatcher("/emplHourlyWagesData.jsp").forward(
				request, response);
		request.getSession().setAttribute("calend", Calendar.getInstance());

	}// doPost
	//*****************************************************************************************
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	//******************************************************************************************
	public  ArrayList<Employee> generationEmployee (String amountEmployee) {
		
		try {
		int amountEmpl = Integer.valueOf(amountEmployee);
		String pathFileOut = "src/main/resources/EmployeesHourlyWages.ehw";

		TestMode.generationEmployeeDataAndFiling(amountEmpl,pathFileOut);
		
		ArrayList<Employee> arrEmpl = instanceCompany
				.createArrayListObjEmplHourlyWagesFromFile(pathFileOut);
		return arrEmpl;
		} catch (Exception e) {
			return null;
		}
	}//generationEmployee()
}