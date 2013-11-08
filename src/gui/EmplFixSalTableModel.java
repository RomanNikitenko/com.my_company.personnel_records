package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import employee.EmployeeFixedSalary;

public class EmplFixSalTableModel extends AbstractTableModel{
	
	public static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Monthly <br>Payment", "<html><center>Tax <br>IdentifNum",
		"Education", "Passport", "Residance"};
	public static ArrayList<EmployeeFixedSalary> arrListObjEmplFixSal;
	
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
	public void setValueAt(Object aValue, int row, int column) {}
	
//	@Override
//	public Class getColumnClass(int c) {
//		return (String.class);
//	}
//	

}//class
