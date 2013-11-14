package com.company.personnelrecords.gui;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.company.personnelrecords.employee.EmployeeFixedSalary;
import com.company.personnelrecords.exception.StringDigitIncludeException;



public class EmplFixSalTableModel extends AbstractTableModel{

	private String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Monthly <br>Payment", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	private ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal = new ArrayList<EmployeeFixedSalary>();

//*******************************************************************	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public ArrayList<EmployeeFixedSalary> getArrListObjEmplFixSal() {
		return arrListObjEmplFixSal;
	}

	public void setArrListObjEmplFixSal(
			ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal) {
		this.arrListObjEmplFixSal = arrListObjEmplFixSal;
	}
//***********************************************************************
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return arrListObjEmplFixSal.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return arrListObjEmplFixSal.get(row).getPersonalNumber();
		case 1: return arrListObjEmplFixSal.get(row).getSurnameNameMiddlename();
		case 2: return arrListObjEmplFixSal.get(row).getDepartment();
		case 3: return arrListObjEmplFixSal.get(row).getPost();
		case 4: return arrListObjEmplFixSal.get(row).getAverageSalary();
		case 5: return arrListObjEmplFixSal.get(row).getMonthlyPayment();
		case 6: return arrListObjEmplFixSal.get(row).getTaxIdentifNum();
		case 7: return arrListObjEmplFixSal.get(row).getEducation();
		case 8: return arrListObjEmplFixSal.get(row).getPassport();
		case 9: return arrListObjEmplFixSal.get(row).getResidence();
		default: return "";
		}//switch
	}//getValueAt
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		
			
		switch (column) {
		case 0:
			try {
				arrListObjEmplFixSal.get(row).setPersonalNumber(
						Integer.valueOf((String) aValue));

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'PersonalNumber' requires an integer value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		break;
		case 1: try {
				arrListObjEmplFixSal.get(row).setSurnameNameMiddlename((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 2: arrListObjEmplFixSal.get(row).setDepartment((String) aValue);
			break;
		case 3: try {
				arrListObjEmplFixSal.get(row).setPost((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 4: 
			try {
				arrListObjEmplFixSal.get(row).setAverageSalary(
						new BigDecimal(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'AverageSalary' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 5: 
			try {
				arrListObjEmplFixSal.get(row).setMonthlyPayment(
						new BigDecimal(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'MonthlyPayment' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 6: 
			try {
				arrListObjEmplFixSal.get(row).setTaxIdentifNum(
						Long.valueOf(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'TaxIdentifNum' requires an long value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 7: try {
				arrListObjEmplFixSal.get(row).setEducation((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 8: arrListObjEmplFixSal.get(row).setPassport((String) aValue);
			break;
		case 9: arrListObjEmplFixSal.get(row).setResidence((String) aValue);
			break;
		}//switch
		
	}//setValueAt
}//class
