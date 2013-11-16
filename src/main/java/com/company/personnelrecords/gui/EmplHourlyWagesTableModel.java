package com.company.personnelrecords.gui;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.exception.StringDigitIncludeException;



public class EmplHourlyWagesTableModel extends AbstractTableModel{

	private String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Hourly <br>Rate", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	private  ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages;
	
//*****************************************************************************
	public EmplHourlyWagesTableModel(
			ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages) {
		this.arrListObjEmplHourlyWages = arrListObjEmplHourlyWages;
	}

//*******//get/set//***********************************************************

	public ArrayList<EmployeeHourlyWages> getArrListObjEmplHourlyWages() {
		return arrListObjEmplHourlyWages;
	}

	public void setArrListObjEmplHourlyWages(
			ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages) {
		this.arrListObjEmplHourlyWages = arrListObjEmplHourlyWages;
	}
//****************************************************************************************
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return arrListObjEmplHourlyWages.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return arrListObjEmplHourlyWages.get(row).getPersonalNumber();
		case 1: return arrListObjEmplHourlyWages.get(row).getSurnameNameMiddlename();
		case 2: return arrListObjEmplHourlyWages.get(row).getDepartment();
		case 3: return arrListObjEmplHourlyWages.get(row).getPost();
		case 4: return arrListObjEmplHourlyWages.get(row).getAverageSalary();
		case 5: return arrListObjEmplHourlyWages.get(row).getHourlyRate();
		case 6: return arrListObjEmplHourlyWages.get(row).getTaxIdentifNum();
		case 7: return arrListObjEmplHourlyWages.get(row).getEducation();
		case 8: return arrListObjEmplHourlyWages.get(row).getPassport();
		case 9: return arrListObjEmplHourlyWages.get(row).getResidence();
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
				arrListObjEmplHourlyWages.get(row).setPersonalNumber(
						Integer.valueOf((String) aValue));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'PersonalNumber' requires an integer value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 1: try {
				arrListObjEmplHourlyWages.get(row).setSurnameNameMiddlename((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 2: arrListObjEmplHourlyWages.get(row).setDepartment((String) aValue);
			break;
		case 3: try {
				arrListObjEmplHourlyWages.get(row).setPost((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 4: 
			try {
				arrListObjEmplHourlyWages.get(row).setAverageSalary(
						new BigDecimal(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'AverageSalary' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		case 5: 
			try {
				arrListObjEmplHourlyWages.get(row).setHourlyRate(
						new BigDecimal(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'HourlyRate' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		case 6: 
			try {
				arrListObjEmplHourlyWages.get(row).setTaxIdentifNum(
						Long.valueOf(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'TaxIdentifNum' requires an long value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 7: try {
				arrListObjEmplHourlyWages.get(row).setEducation((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 8: arrListObjEmplHourlyWages.get(row).setPassport((String) aValue);
			break;
		case 9: arrListObjEmplHourlyWages.get(row).setResidence((String) aValue);
			break;
		}//switch
	}//setValueAt
}//class
