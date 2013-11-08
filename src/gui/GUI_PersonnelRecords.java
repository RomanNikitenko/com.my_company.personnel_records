package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;


public class GUI_PersonnelRecords extends JFrame {
	
//********���� �������������*********************
	public static Dimension screenSize;
	public static JTable dataTable;
	public static JScrollPane jscrlp;
	public static JPanel mainPanel;
	public static JPanel panelEmployeeFixSalary;
	public static JPanel panelButEdit;
	public static JButton butAdd;
	public static JButton butDelete;
	public static JPanel panelTable;
	
	
//*******�����������******************************
	public GUI_PersonnelRecords () throws Exception {
		
		new MyMenu();
		//�������� ������ ������
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
//*******//������� ������//*******
        
        mainPanel = new JPanel(); //������� ������� ������, ������ �������� ����������
		mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height-25));//������������� ������
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//������������� ������
		
//*******//��������� ����//*******
		add(mainPanel);//��������� ������� ������ � ������
		this.setJMenuBar(MyMenu.menuBar);//������������� ����
		setTitle("PersonnelRecord"); //������������� ��������� ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���������� ������ ���������� �� �������� �������� ����
//		setLocationRelativeTo(null); //������������ ���� - ����� ������� ���� �� ������ ������
		setSize(new Dimension(screenSize.width, screenSize.height-25));
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); // ���������� ����
		setExtendedState(MAXIMIZED_BOTH);//���� �� ���� �����
		
//*******//������ Employee with fixed salary//*******
		panelEmployeeFixSalary = new JPanel(new BorderLayout());
		panelEmployeeFixSalary.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployeeFixSalary.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employee With Fix Salary",
				TitledBorder.CENTER, TitledBorder.TOP));
		
//*******//������ ��� ������ EDIT
		panelButEdit = new JPanel(new GridLayout(7, 1, 0, 10));
//		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Buttons Edit"));
		panelEmployeeFixSalary.add(panelButEdit, BorderLayout.WEST);
		
//*******//������� EDIT
		butAdd = new JButton("Add");
		panelButEdit.add(butAdd);
		
		butDelete = new JButton("Delete");
		panelButEdit.add(butDelete);
		
//*******//������ ��� �������
		panelTable = new JPanel(new BorderLayout());
		panelTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Table Data"));
		
		
		
		//���������� ������
		panelEmployeeFixSalary.add(panelTable,BorderLayout.CENTER);
		mainPanel.add(panelEmployeeFixSalary, BorderLayout.CENTER);
		
		
		

			
	}//�����������
//***********************************************************
	public static void createTable () {
		//*******//������� ������� �� ������ ����� ������
		dataTable = new JTable(new EmplFixSalTableModel());
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// ������� ������ ��������� � �������� � �� ������ ���� �������
		jscrlp = new JScrollPane(dataTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// ������������ ������� �������������� �������
		// dataTable.setPreferredScrollableViewportSize(new
		// Dimension(screenSize.width-50, screenSize.height-50));
		// ������ ������ ��������
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(55);
		dataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		dataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		dataTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(5).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(6).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		dataTable.getColumnModel().getColumn(8).setPreferredWidth(220);
		dataTable.getColumnModel().getColumn(9).setPreferredWidth(300);
		
		//��������� �� ������ jscrlp ������ � ��������
		panelTable.add(jscrlp);
		panelTable.updateUI();
	}//createTable ()
//***********************************************************
	public static void main(String[] args) throws Exception {
		new GUI_PersonnelRecords(); 
	}//main
}//class
