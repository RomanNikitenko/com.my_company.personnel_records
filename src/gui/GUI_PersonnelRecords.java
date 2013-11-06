package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import util.MyUtil;


public class GUI_PersonnelRecords extends JFrame implements ActionListener {
	
//********���� �������������*********************
	public static ArrayList<ArrayList<String>> arrListDataEmployees;
	public static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
									"Post", "<html><center>Average<br>Salary", "<html><center>Tax <br>IdentifNum", "Education", "Passport", "Residance"};
	public JTable dataTable;
	
//*******�����������******************************
	public GUI_PersonnelRecords () throws Exception {

		//��������� ������ �� ����������� �� �����
		arrListDataEmployees = MyUtil.readDataEmployeeFromFile("TestListEmployee.out");
		
		//������� ������� �� ������ ����� ������
		JTable dataTable = new JTable(new MyTableModel());
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//������� ������ ��������� � �������� � �� ������ ���� �������
        JScrollPane jscrlp = new JScrollPane(dataTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //������������ ������� �������������� �������
//        dataTable.setPreferredScrollableViewportSize(new Dimension(250, 100));
        //������ ������ ��������
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(55);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        dataTable.getColumnModel().getColumn(7).setPreferredWidth(220);
        dataTable.getColumnModel().getColumn(8).setPreferredWidth(300);
//*******//������� ������//*******
		JPanel mainPanel = new JPanel(); //������� ������� ������, ������ �������� ����������
		mainPanel.setPreferredSize(new Dimension(900, 410));//������������� ������
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//������������� ������
		
		add(mainPanel);//��������� ������� ������ � ������
		setTitle("PersonnelRecord"); //������������� ��������� ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���������� ������ ���������� �� �������� �������� ����
//		setLocationRelativeTo(null); //������������ ���� - ����� ������� ���� �� ������ ������
		setSize(1200, 650); // ������ ������� ����
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); // ���������� ����
//		setExtendedState(MAXIMIZED_BOTH);//���� �� ���� �����
		
//*******//������ Employee with fixed salary//*******
		JPanel panelEmployeeFixSalary = new JPanel(new BorderLayout());
		panelEmployeeFixSalary.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployeeFixSalary.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employee With Fix Salary"));
		
		//������ ��� ������ EDIT
		JPanel panelButEdit = new JPanel();
		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Button Edit"));
		panelEmployeeFixSalary.add(panelButEdit, BorderLayout.WEST);
		
		//������ ��� �������
		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Table Data"));
		
		//��������� � �� ������ �������� jscrlp ������ � ��������
		panelTable.add(jscrlp);
		panelEmployeeFixSalary.add(panelTable,BorderLayout.CENTER);

		mainPanel.add(panelEmployeeFixSalary, BorderLayout.CENTER);
		
		
		

			
	}//�����������
//************************************************
	public static void main(String[] args) throws Exception {
		new GUI_PersonnelRecords(); 
	}//main
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		try {
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//actionPerformed

}//class
