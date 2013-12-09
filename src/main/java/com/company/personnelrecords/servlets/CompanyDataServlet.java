package com.company.personnelrecords.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.util.MyUtil;


public class CompanyDataServlet extends HttpServlet {
	
	private Company instanceCompany;
	
	public void init() throws ServletException { 
		instanceCompany = Company.getInstance();
	}//init 

	 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                          throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	if (!(request.getParameter("companyName") == null)) {
    		saveEditedCompanyData(request);
    	}//if
    	request.setAttribute("companyName", instanceCompany.getCompanyName());
    	request.setAttribute("companyCEO", instanceCompany.getCompanyCEO());
    	request.setAttribute("companyCurAcc", instanceCompany.getCompanyCurrentAccount());
    	request.setAttribute("companyEDRPOU", instanceCompany.getCompanyEDRPOU());
    	request.setAttribute("companyRegOffice", instanceCompany.getCompanyRegisteredOffice());
    	
    	request.getRequestDispatcher("/companyData.jsp").forward(request, response); 
    	request.getSession().setAttribute("calend", Calendar.getInstance());

    }//doPost
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                         throws ServletException, IOException {
    }
    public void saveEditedCompanyData(HttpServletRequest request) throws UnsupportedEncodingException {
		
    	instanceCompany.setCompanyName(request.getParameter("companyName"));
    	try {
			instanceCompany.setCompanyCEO(request.getParameter("companyCEO"));
		} catch (StringDigitIncludeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	instanceCompany.setCompanyCurrentAccount(Long.valueOf(request.getParameter("companyCurrAcc")));
    	instanceCompany.setCompanyEDRPOU(Long.valueOf(request.getParameter("companyEDRPOU")));
    	instanceCompany.setCompanyRegisteredOffice(request.getParameter("companyRegOffice"));
    	
		String strForFiling = new String(("Company Name: "
				+ request.getParameter("companyName") + "   companyCEO: "
				+ request.getParameter("companyCEO")
				+ "   companyCurrentAccount: "
				+ request.getParameter("companyCurrAcc") + "   companyEDRPOU: "
				+ request.getParameter("companyEDRPOU")
				+ "   companyRegisteredOffice: "
				+ request.getParameter("companyRegOffice")));
		try {
			MyUtil.replacementStrInFile(strForFiling,
					"src/main/resources/CompanyData.cdt", "Company Name:");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//saveEditedCompanyData()
}