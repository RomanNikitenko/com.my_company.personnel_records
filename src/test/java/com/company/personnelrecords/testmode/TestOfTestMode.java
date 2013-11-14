package com.company.personnelrecords.testmode;

import static org.junit.Assert.*;

import java.io.RandomAccessFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.personnelrecords.testmode.TestMode;

public class TestOfTestMode {

	String [] arrEmployeeData;
	RandomAccessFile raf;
	int amountGenerationEmployee = 10;
	
	@Before
	public void setup() throws Exception{
		arrEmployeeData = TestMode.generationEmployeeDataAndFiling(amountGenerationEmployee,
	    		"src/main/resources/EmployeesFixedSalary.efs");
	}//setup

	@After
	public void tearDown () throws Exception{
		if (raf != null) {
		raf.close();
		}
	}//tearDown

	@Test
	public void shouldGenerationEmployeeData() throws Exception {
		assertTrue(arrEmployeeData.length == amountGenerationEmployee);
	}//shouldGenerationEmployeeData()
	
	@Test
	public void shouldRecInFileGenerationEmployeeData() throws Exception {
		raf = new RandomAccessFile("src/main/resources/EmployeesFixedSalary.efs", "r");
		assertTrue(raf.length() > 0);
	}//

}
