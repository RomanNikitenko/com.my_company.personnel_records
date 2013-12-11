package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.EmployeeCreator;
import com.company.personnelrecords.exception.StringDigitIncludeException;

public class AddEmplHourlyWagesServlet extends HttpServlet {

	private Company instanceCompany;

	public void init() throws ServletException {
		instanceCompany = Company.getInstance();
	}// init

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		addEmplToArrListObjAllEmployee (request);
		
		request.getRequestDispatcher("/EmplHourlyWagesData").forward(request,
				response);
	}// doPost

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	public void addEmplToArrListObjAllEmployee (HttpServletRequest request){
		String personalNumber = 		request.getParameter("personalNumber");
		String surnameNameMiddlename = 	request
				.getParameter("surnameNameMiddlename");
		String department = 			request.getParameter("department");
		String post = 					request.getParameter("post");
		String averageSalary = 			request.getParameter("averageSalary");
		String hourlyRate = 			request.getParameter("hourlyRate");
		String taxIdentifNum = 			request.getParameter("taxIdentifNum");
		String education = 				request.getParameter("education");
		String passport = 				request.getParameter("passport");
		String residence = 				request.getParameter("residence");

		try {
			new EmployeeCreator().addEmplHourlyWages(Integer.valueOf(personalNumber),
					surnameNameMiddlename, department, post, BigDecimal.valueOf(Long.valueOf(averageSalary)),
					Long.valueOf(taxIdentifNum), education, passport, residence, BigDecimal.valueOf(Long.valueOf(hourlyRate)));
		} catch (NumberFormatException | StringDigitIncludeException e) {
			e.printStackTrace();
		}
	}
}