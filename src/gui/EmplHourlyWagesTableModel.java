package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import employee.EmployeeFixedSalary;
import employee.EmployeeHourlyWages;

public class EmplHourlyWagesTableModel extends AbstractTableModel{
	
	public static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Hourly <br>Rate", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	public static ArrayList<EmployeeHourlyWages> arrListObjEmplHourlyWages;
	
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
	public void setValueAt(Object aValue, int row, int column) {}
	
//	@Override
//	public Class getColumnClass(int c) {
//		return (String.class);
//	}
//	

}//class
