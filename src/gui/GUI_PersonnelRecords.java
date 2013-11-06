package gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import employee.Employee;


public class GUI_PersonnelRecords extends JFrame implements ActionListener {
	
//********���� �������������*********************
	
//*******�����������******************************
	public GUI_PersonnelRecords () throws Exception {

//*******//������� ������//*******
		JPanel mainPanel = new JPanel(new GridBagLayout()); //������� ������� ������, ������ �������� ����������
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
		panelEmployeeFixSalary.add(panelTable,BorderLayout.CENTER);

		mainPanel.add(panelEmployeeFixSalary, BorderLayout.CENTER);
		
		//�������
		JTable dataTable = new JTable();
		mainPanel.add(dataTable);

			
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
