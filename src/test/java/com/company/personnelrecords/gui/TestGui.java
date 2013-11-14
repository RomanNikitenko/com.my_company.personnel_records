package com.company.personnelrecords.gui;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.swing.JTable;


import org.junit.Before;
import org.junit.Test;

import com.company.personnelrecords.employee.EmployeeFixedSalary;
import com.company.personnelrecords.exception.StringDigitIncludeException;


public class TestGui {
	
	EmplFixSalTableModel emplFixSalTableModel;
	JTable dataTable;
	
	@Before
	public void setup() throws Exception{
		new MenuBar();
		new MainFrame();
		emplFixSalTableModel = new EmplFixSalTableModel();
		dataTable = MenuBar.getMainFrame().createTable(emplFixSalTableModel);
	}//setup

	
	@Test
    public void testCreateTableModel() {
		assertNotNull(emplFixSalTableModel);
	}//testCreateTableModel()

	@Test
    public void testCreateTable() {
		assertNotNull(dataTable);
	}//testCreateTable()
	
	@Test
    public void testAddRowToTable () throws StringDigitIncludeException {
		emplFixSalTableModel.getArrListObjEmplFixSal().add( 
				new EmployeeFixedSalary(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
		assertTrue(dataTable.getRowCount() == 1);
	}//testAddRowToTable ()


}
