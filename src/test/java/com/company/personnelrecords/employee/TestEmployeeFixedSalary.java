package com.company.personnelrecords.employee;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.exception.StringDigitIncludeException;
import com.company.personnelrecords.testmode.TestMode;

public class TestEmployeeFixedSalary {
	
	EmployeeFixedSalary emplFixSal;
	ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal; 
	int amountGenerationEmployee = 10;

	@Before
	public void setup() throws Exception{
	    
		emplFixSal = new EmployeeFixedSalary(1, "Ivanov Ivan",
	    		"Department ¹ 1", "manager", new BigDecimal(10000), 1370993795l,
	    		"higher", "HC 139926", "New-York", new BigDecimal(10000));
	    
	    TestMode.generationEmployeeDataAndFiling(amountGenerationEmployee,
	    		"src/main/resources/EmployeesFixedSalary.efs");

	    arrListObjEmplFixSal = EmployeeFixedSalary.createArrayListObjEmployeeFromFile(
				"src/main/resources/EmployeesFixedSalary.efs");

	}//setup

	
	@Test
    public void testCreateEmpl() {
		assertNotNull(emplFixSal);
	}//testCreateEmpl
		
	@Test
	public void testCreateArrayListObjEmplFixSalFromFile() throws Exception {
		assertNotNull(arrListObjEmplFixSal);
	}//testCreateArrayListObjEmplFixSalFromFile()
	
	@Test
	public void testSizeArrayListAfterCreateObjEmplFixSalFromFile () throws Exception {
		assertTrue(arrListObjEmplFixSal.size() == amountGenerationEmployee);
	}//testSizeArrayListAfterCreateObjEmplFixSalFromFile()
	
	@Test
	public void testShouldCorrectlySetAverageSalary () {
		BigDecimal expected = new BigDecimal(10000);
		BigDecimal actual = emplFixSal.getAverageSalary();
		assertEquals(expected, actual);
	}//testShouldCorrectlySetAverageSalary()
	
	@Test(expected = StringDigitIncludeException.class)
	public void testCallStringDigitIncludeException() throws StringDigitIncludeException {
		emplFixSal.setSurnameNameMiddlename("wewr12");
	}//testCallStringDigitIncludeException()
	
}//class
