package com.company.personnelrecords.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.EmployeeCreator;

public class MainFrame extends JFrame implements ActionListener {
	
//*****************************
	
	private  JTable dataTable;
	private static Dimension screenSize;
	private static JScrollPane jscrlp;
	private static JPanel mainPanel;
	private static JPanel panelEmployees;
	private static JPanel panelButEdit;
	private static JButton butAddEmplFixSal;
	private static JButton butAddEmplHourlyWages;
	private static JButton butClean;
	private static JButton butDelete;
	private static JPanel panelEmplTable;
	private EmployeeCreator emplCreator;
	
//*************************************
	public MainFrame () throws Exception {
		
		MenuBar.setMainFrame(this);

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
//*******////*******
        mainPanel = new JPanel(); 
		mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height-25));
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
//*******////*******
		add(mainPanel);
		this.setJMenuBar(MenuBar.getPersRecMenuBar()); 
		setTitle("PersonnelRecord"); 
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
//		setLocationRelativeTo(null); 
		setSize(new Dimension(screenSize.width, screenSize.height-25));
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); 
		setExtendedState(MAXIMIZED_BOTH);
		
//*******//Employees//*******
		panelEmployees = new JPanel(new BorderLayout());
		panelEmployees.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployees.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees",
				TitledBorder.CENTER, TitledBorder.TOP));
		
//*******//
		panelButEdit = new JPanel(new GridLayout(7, 1, 0, 10));
//		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Buttons Edit"));
		
//*******//
		
		butAddEmplFixSal = new JButton("<html><center> Add Employee <br> Fix Salary");
		butAddEmplFixSal.addActionListener(this);
		
		butAddEmplHourlyWages = new JButton("<html><center> Add Employee <br>Hourly Wages");
		butAddEmplHourlyWages.addActionListener(this);

		butClean = new JButton("<html><center>Clean<br>All");
		butClean.addActionListener(this);

		butDelete = new JButton("<html><center> Delete <br> Employee");
		butDelete.addActionListener(this);
		

//*******// 
		panelEmplTable = new JPanel(new BorderLayout());
		panelEmplTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));

		mainPanel.add(panelEmployees, BorderLayout.CENTER);
			
	}
//***********************************************************
	public JTable displayTable (final AbstractTableModel tableModel) {
		
		dataTable = new JTable(tableModel);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dataTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		dataTable.setCellSelectionEnabled(true);
		
		TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<AbstractTableModel>(tableModel) {
			
			@Override
			public Comparator<?> getComparator(int column) {
			      
			      if (tableModel instanceof AllEmployeeTableModel && column == 0 || column == 4 ||
			    		  column == 5 || column == 6 || column == 7 ) {
			        return new Comparator<String>() {
			          @Override
			          public int compare(String s1,String s2) {
			            return Integer.parseInt(s1) - Integer.parseInt(s2);
			          }
			        };
			     }
			      else if (column == 0 || column == 4 || column == 5 || column == 6 ) {
			        return new Comparator<String>() {
			          @Override
			          public int compare(String s1,String s2) {
			            return Integer.parseInt(s1) - Integer.parseInt(s2);
			          }
			        };
			     } 
			      return super.getComparator(column);
			}
		};
		dataTable.setRowSorter(sorter);
		
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(55);
		dataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		dataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		dataTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(5).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(6).setPreferredWidth(80);
		
		if (tableModel instanceof AllEmployeeTableModel) {
			dataTable.getColumnModel().getColumn(7).setPreferredWidth(80);
			dataTable.getColumnModel().getColumn(8).setPreferredWidth(100);
			dataTable.getColumnModel().getColumn(9).setPreferredWidth(220);
			dataTable.getColumnModel().getColumn(10).setPreferredWidth(300);
		}
		else {
			dataTable.getColumnModel().getColumn(7).setPreferredWidth(100);
			dataTable.getColumnModel().getColumn(8).setPreferredWidth(220);
			dataTable.getColumnModel().getColumn(9).setPreferredWidth(300);
		}//else

		jscrlp = new JScrollPane(dataTable,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelEmplTable.removeAll();


		panelEmplTable.add(jscrlp);
		panelButEdit.removeAll();
				
		if (tableModel instanceof EmplFixSalTableModel) {
			panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
					"Employees With Fix Salary Data"));
			panelButEdit.add(butAddEmplFixSal, 0);
		}//if
		else if (tableModel instanceof EmplHourlyWagesTableModel) {panelEmplTable.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
				"Employees With Hourly Wages Data"));
		panelButEdit.add(butAddEmplHourlyWages, 0);
		}//else if
		else { panelEmplTable.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
							"All Employees Data"));
				panelButEdit.add(butAddEmplFixSal, 0);
				panelButEdit.add(butAddEmplHourlyWages, 1);
		}//else
		
		panelButEdit.add(butDelete);
		panelButEdit.add(butClean);
		panelEmployees.add(panelButEdit, BorderLayout.WEST);
		panelEmployees.add(panelEmplTable,BorderLayout.CENTER);
		panelEmplTable.updateUI();
		return dataTable;
	}//displayTable ()
//***********************************************************
	public void updateAfterRowInserted (AbstractTableModel tableModel) {
		tableModel.fireTableRowsInserted(0, 0);
		dataTable.revalidate();
		panelEmplTable.updateUI();
	}//updateAfterRowInserted (AbstractTableModel tableModel)
//**************************************************************
	public void deleteRowFromTable() {

		int index = dataTable.convertRowIndexToModel(dataTable.getSelectedRow());
		Company.getInstance().deleteEmployee(index);
			
		if (dataTable.getModel() instanceof EmplFixSalTableModel) {
			((EmplFixSalTableModel )dataTable.getModel()).fireTableRowsDeleted(
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
		}//if
		else if (dataTable.getModel() instanceof EmplHourlyWagesTableModel) {
			((EmplHourlyWagesTableModel)dataTable.getModel()).fireTableRowsDeleted(
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
		}//else if
		else if (dataTable.getModel() instanceof AllEmployeeTableModel) {
			((AllEmployeeTableModel)dataTable.getModel()).fireTableRowsDeleted(
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
					dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
		}//else if
		dataTable.revalidate();
		panelEmplTable.updateUI();
	}//deleteEmployee
//**************************************************************
	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (event.getActionCommand()) {
		
		case "<html><center>Clean<br>All":
			
			panelEmplTable.removeAll();
			dataTable.removeAll();
			panelEmplTable.updateUI();
			break;
		
		case "<html><center> Add Employee <br> Fix Salary":
			Company.getInstance().addEmployee("FixSal");
			updateAfterRowInserted((AbstractTableModel) dataTable.getModel());
			break;

		case "<html><center> Add Employee <br>Hourly Wages":
			Company.getInstance().addEmployee("HourlyWages");
			updateAfterRowInserted((AbstractTableModel) dataTable.getModel());
			break;

		case "<html><center> Delete <br> Employee":
			if (dataTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null,
						"Select the row you want to delete!", "Attention!",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}//
			deleteRowFromTable();
			break;
		}//switch
	}//actionPerformed
}//class
