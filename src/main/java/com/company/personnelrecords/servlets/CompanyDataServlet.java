package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.personnelrecords.company.Company;


public class CompanyDataServlet extends HttpServlet {
	
	private Company instanceCompany;
	
	public void init() throws ServletException { 
		instanceCompany = Company.getInstance();
	}//init 

	 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                          throws ServletException, IOException {
    }//doPost
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                         throws ServletException, IOException {
    	request.setAttribute("companyName", instanceCompany.getCompanyName());
    	request.setAttribute("companyCEO", instanceCompany.getCompanyCEO());
    	request.setAttribute("companyCurAcc", instanceCompany.getCompanyCurrentAccount());
    	request.setAttribute("companyEDRPOU", instanceCompany.getCompanyEDRPOU());
    	request.setAttribute("companyRegOffice", instanceCompany.getCompanyRegisteredOffice());
    	
    	request.getRequestDispatcher("/companyData.jsp").forward(request, response); 
    	request.getSession().setAttribute("calend", Calendar.getInstance());
    }
}