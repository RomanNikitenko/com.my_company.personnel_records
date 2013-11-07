package gui;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	
	private static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
		"Post", "<html><center>Average<br>Salary", "<html><center> Monthly <br>Payment", "<html><center>Tax <br>IdentifNum", "Education", "Passport", "Residance"};

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return GUI_PersonnelRecords.arrListDataEmployees.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
//		switch (col) {
//		case 0: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 1: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 2: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 3: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 4: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 0: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 1: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 2: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 3: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		case 4: return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
//		}
		return GUI_PersonnelRecords.arrListDataEmployees.get(row).get(col);
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	@Override
	public void setValueAt(Object aValue, int row, int column) {}
	
//	@Override
//	public Class getColumnClass(int c) {
//		return (String.class);
//	}
//	

}//class
