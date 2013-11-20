package com.company.personnelrecords.gui;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTable;


import org.junit.Before;
import org.junit.Test;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.EmployeeCreator;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.exception.StringDigitIncludeException;


public class TestGui {
	
	EmplFixSalTableModel emplFixSalTableModel;
	JTable dataTable;
	
	@Before
	public void setup() throws Exception{
		new MenuBar();
		new MainFrame();
		Company.getInstance().setArrListObjEmplFixSal(new EmployeeCreator().createArrListWithNewEmplFixSal());
		emplFixSalTableModel = new EmplFixSalTableModel(Company.getInstance().getArrListObjEmplFixSal());
		dataTable = MenuBar.getMainFrame().displayTable(emplFixSalTableModel);
	}//setup

	
	@Test
    public void testCreateTableModel() {
		assertNotNull(emplFixSalTableModel);
	}//testCreateTableModel()

	@Test
    public void testMethodDisplayTable() {
		assertNotNull(dataTable);
	}//testCreateTable()
	
	@Test
    public void testAddRowToTable () throws StringDigitIncludeException {
		Company.getInstance().setArrListObjEmplFixSal(new ArrayList<EmployeeFixedSalary>());
		Company.getInstance().getArrListObjEmplFixSal().add( 
				new EmployeeFixedSalary(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		assertTrue(dataTable.getRowCount() == 1);
	}//testAddRowToTable ()


}
