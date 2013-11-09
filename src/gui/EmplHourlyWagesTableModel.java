package gui;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import employee.EmployeeHourlyWages;

public class EmplHourlyWagesTableModel extends AbstractTableModel{
	
	private static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Hourly <br>Rate", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	
	public static ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages;

//*************************************************************
	public EmplHourlyWagesTableModel() {
	
		arrListObjEmplHourlyWages = new ArrayList<EmployeeHourlyWages>();
		arrListObjEmplHourlyWages.add(new EmployeeHourlyWages(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
	}
//*************************************************************
	
	
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
		case 0: arrListObjEmplHourlyWages.get(row).setPersonalNumber(Integer.valueOf((String) aValue));
			break;
		case 1: arrListObjEmplHourlyWages.get(row).setSurnameNameMiddlename((String) aValue);
			break;
		case 2: arrListObjEmplHourlyWages.get(row).setDepartment((String) aValue);
			break;
		case 3: arrListObjEmplHourlyWages.get(row).setPost((String) aValue);
			break;
		case 4: arrListObjEmplHourlyWages.get(row).setAverageSalary(new BigDecimal (aValue.toString()));
			break;
		case 5: arrListObjEmplHourlyWages.get(row).setHourlyRate(new BigDecimal (aValue.toString()));
			break;
		case 6: arrListObjEmplHourlyWages.get(row).setTaxIdentifNum(Long.valueOf(aValue.toString()));
			break;
		case 7: arrListObjEmplHourlyWages.get(row).setEducation((String) aValue);
			break;
		case 8: arrListObjEmplHourlyWages.get(row).setPassport((String) aValue);
			break;
		case 9: arrListObjEmplHourlyWages.get(row).setResidence((String) aValue);
			break;
		}//switch
	}//setValueAt
}//class
