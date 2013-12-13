package com.company.personnelrecords.gui;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.company.personnelrecords.company.Employee;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.exception.StringDigitIncludeException;



public class AllEmployeeTableModel extends AbstractTableModel{

	private static final String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Monthly <br>Payment", "<html><center> Hourly <br>Rate",
		"<html><center>Tax <br>IdentifNum", "Education", "Passport", "Residance"};
	private ArrayList<Employee> arrListObjAllEmployee;
	
	
//*******************************************************************
	public AllEmployeeTableModel(
			ArrayList<Employee> arrListObjAllEmployee) {
		this.arrListObjAllEmployee = arrListObjAllEmployee;
	}

//***********************************************************************
	public ArrayList<Employee> getArrListObjAllEmployee() {
		return arrListObjAllEmployee;
	}

	public void setArrListObjAllEmployee(
			ArrayList<Employee> arrListObjAllEmployee) {
		this.arrListObjAllEmployee = arrListObjAllEmployee;
	}
//***********************************************************************	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return arrListObjAllEmployee.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return arrListObjAllEmployee.get(row).getPersonalNumber();
		case 1: return arrListObjAllEmployee.get(row).getSurnameNameMiddlename();
		case 2: return arrListObjAllEmployee.get(row).getDepartment();
		case 3: return arrListObjAllEmployee.get(row).getPost();
		case 4: return arrListObjAllEmployee.get(row).getAverageSalary();
		case 5: 
			if (arrListObjAllEmployee.get(row) instanceof EmployeeFixedSalary) {
				return ((EmployeeFixedSalary)arrListObjAllEmployee.get(row)).getMonthlyPayment();	
			}//if
			else return -1;
			
		case 6: 
			if (arrListObjAllEmployee.get(row) instanceof EmployeeHourlyWages) {
				return ((EmployeeHourlyWages)arrListObjAllEmployee.get(row)).getHourlyRate();	
			}//if
			else return -1;
		case 7: return arrListObjAllEmployee.get(row).getTaxIdentifNum();
		case 8: return arrListObjAllEmployee.get(row).getEducation();
		case 9: return arrListObjAllEmployee.get(row).getPassport();
		case 10: return arrListObjAllEmployee.get(row).getResidence();
		default: return null;
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
				arrListObjAllEmployee.get(row).setPersonalNumber(
						Integer.valueOf((String) aValue));

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'PersonalNumber' requires an integer value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		break;
		case 1: try {
				arrListObjAllEmployee.get(row).setSurnameNameMiddlename((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 2: arrListObjAllEmployee.get(row).setDepartment((String) aValue);
			break;
		case 3: try {
				arrListObjAllEmployee.get(row).setPost((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 4: 
			try {
				arrListObjAllEmployee.get(row).setAverageSalary(
						new BigDecimal(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'AverageSalary' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 5: 
			try {
				if (arrListObjAllEmployee.get(row) instanceof EmployeeFixedSalary) {
					((EmployeeFixedSalary)arrListObjAllEmployee.get(row)).setMonthlyPayment(
							new BigDecimal(aValue.toString()));
				}//if
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'MonthlyPayment' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 6: 
			try {
				if (arrListObjAllEmployee.get(row) instanceof EmployeeHourlyWages) {
					((EmployeeHourlyWages)arrListObjAllEmployee.get(row)).setHourlyRate(
							new BigDecimal(aValue.toString()));
				}//if
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'HourlyRate' requires an BigDecimal value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case 7: 
			try {
				arrListObjAllEmployee.get(row).setTaxIdentifNum(
						Long.valueOf(aValue.toString()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Field 'TaxIdentifNum' requires an long value",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 8: try {
				arrListObjAllEmployee.get(row).setEducation((String) aValue);
			} catch (StringDigitIncludeException e) {
				JOptionPane.showMessageDialog(null,
						"Incorrect value!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 9: arrListObjAllEmployee.get(row).setPassport((String) aValue);
			break;
		case 10: arrListObjAllEmployee.get(row).setResidence((String) aValue);
			break;
		}//switch
	}//setValueAt
}//class
