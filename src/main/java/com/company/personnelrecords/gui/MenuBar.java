package com.company.personnelrecords.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.testmode.TestMode;

public class MenuBar extends JFrame{
	
	private static JMenuBar persRecMenuBar;
	private static MainFrame mainFrame;
	private static JMenu menuCompany;
	private static JMenuItem submenuCompanyData;
	private static JMenu menuEmployeeFixSal;
	private static JMenuItem submenuEmplFixSal;
	private static JMenu menuEmployeeHourlyWages;
	private static JMenuItem submenuEmplHourlyWages;
	private static JMenu menuTestMode;
	private static JMenu submenuGenerateEmpl;
	private static JRadioButtonMenuItem radioMenuGenerEmplFixSal;
	private static JRadioButtonMenuItem radioMenuGenerEmplHourlyWages;
	private static ButtonGroup rbGroup;
	
	
	public MenuBar(){
		
		//������� ������ ���� - JMenuBar
	   setPersRecMenuBar(new JMenuBar());

//*******Company*******//
	   
	   //������� ������� Company
	   menuCompany = new JMenu("<HTML><CENTER>Company</CENTER</HTML>");
	   menuCompany.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "Company Data"
	   submenuCompanyData = new JMenuItem("Company Data");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());
	   
	   //�����. ����� ���� - "Open List 'All Employee'"   
	   submenuCompanyData = new JMenuItem("Open List 'All Employee'");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //�����. ����� ���� - "List of Departments"   
	   submenuCompanyData = new JMenuItem("List of Departments");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //�����. ����� ���� - "List of Departments"   
	   submenuCompanyData = new JMenuItem("List of Posts");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //�����. ����������� ����
	   menuCompany.add(new JSeparator());
	   
	   //�����. ���� �����
	   submenuCompanyData = new JMenuItem("Exit");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener (new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent event) {
			   System.exit(0);
		   }
	   });
	   //������� ����� � ��������� ����
	   getPersRecMenuBar().add(menuCompany);
	   
//*******Employee With Fix Salary*******//
	   
	   //������� ������� Employee With Fix Salary
	   menuEmployeeFixSal = new JMenu("<html><center>Employee With <br> Fix Salary");
	   menuEmployeeFixSal.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeFixSal.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "New"
	   submenuEmplFixSal = new JMenuItem("New");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener(new EmployeeFixSalListener());
	   
	   //�����. ����� ���� - "Open List Employee"   
	   submenuEmplFixSal = new JMenuItem("Open List Employees");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener(new EmployeeFixSalListener());

	   //������� ����� � ��������� ����
	   getPersRecMenuBar().add(menuEmployeeFixSal);
	   
//*******Employee with hourly wages*******//
	 
	   //������� ������� Employee With hourly wages
	   menuEmployeeHourlyWages = new JMenu("<html><center>Employee With <br> Hourly Wages");
	   menuEmployeeHourlyWages.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeHourlyWages.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "New"
	   submenuEmplHourlyWages = new JMenuItem("New");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //�����. ����� ���� - "Open List Employee"   
	   submenuEmplHourlyWages = new JMenuItem("Open List Employees");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //�����. ����������� ����
	   menuEmployeeHourlyWages.add(new JSeparator());
	   
	   //������� ����� � ��������� ����
	   getPersRecMenuBar().add(menuEmployeeHourlyWages);

//*******Test Mode*******//
		 
	   //������� ������� Test Mode
	   menuTestMode = new JMenu("Test Mode");
//	   menuTestMode.setPreferredSize(new Dimension(80, 40));
	   menuTestMode.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "Generate Employees"
	   submenuGenerateEmpl = new JMenu("Generate Employees");
	   
	   
	 //�����. �����-���� "Generation Employee with fix salary"
	   radioMenuGenerEmplFixSal = 
			   new JRadioButtonMenuItem("Generation Employee with fix salary");
	   submenuGenerateEmpl.add(radioMenuGenerEmplFixSal);
	   radioMenuGenerEmplFixSal.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	   
	 //�����. �����-���� "Generation Employee with hourly wages"
	   radioMenuGenerEmplHourlyWages = 
			   new JRadioButtonMenuItem("Generation Employee with hourly wages");
	   submenuGenerateEmpl.add(radioMenuGenerEmplHourlyWages);
	   radioMenuGenerEmplHourlyWages.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
	   
	   //����� ����� ������ � �����������
	   rbGroup = new ButtonGroup();
	   rbGroup.add(radioMenuGenerEmplFixSal);
	   rbGroup.add(radioMenuGenerEmplHourlyWages);
	   
	   menuTestMode.add(submenuGenerateEmpl);
	   
	   //������� ����� � ��������� ����
	   getPersRecMenuBar().add(menuTestMode);
	   
	}//�����������
	
//*******//get/set//*********************************************************
	public static JMenuBar getPersRecMenuBar() {
		return persRecMenuBar;
	}
	public static void setPersRecMenuBar(JMenuBar persRecMenuBar) {
		MenuBar.persRecMenuBar = persRecMenuBar;
	}
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
	public static void setMainFrame(MainFrame mainFrame) {
		MenuBar.mainFrame = mainFrame;
	}
	public static JRadioButtonMenuItem getRadioMenuGenerEmplFixSal() {
		return radioMenuGenerEmplFixSal;
	}
	public static void setRadioMenuGenerEmplFixSal(
			JRadioButtonMenuItem radioMenuGenerEmplFixSal) {
		MenuBar.radioMenuGenerEmplFixSal = radioMenuGenerEmplFixSal;
	}
	public static JRadioButtonMenuItem getRadioMenuGenerEmplHourlyWages() {
		return radioMenuGenerEmplHourlyWages;
	}
	public static void setRadioMenuGenerEmplHourlyWages(
			JRadioButtonMenuItem radioMenuGenerEmplHourlyWages) {
		MenuBar.radioMenuGenerEmplHourlyWages = radioMenuGenerEmplHourlyWages;
	}
//***********************************************************************************
	public static void openFileEmployeesData () throws Exception {

		JFileChooser fileOpen = new JFileChooser();
		
		fileOpen.getFileSelectionMode();
		fileOpen.getFileView();
		fileOpen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		fileOpen.setDialogTitle("Open File with Employees Data");
		fileOpen.setDragEnabled(true);
		fileOpen.setDialogType(JFileChooser.OPEN_DIALOG);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter
				("��������� ����� *.ehw *.efs *.txt *.in *.doc"  , "ehw", "efs", "txt", "in", "doc");
		fileOpen.addChoosableFileFilter(filter);
		fileOpen.setMultiSelectionEnabled(true);
		
		int res = fileOpen.showDialog(null,null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = fileOpen.getSelectedFile();
			
			if (file.getAbsolutePath().indexOf(".efs") != (-1) ||
				file.getAbsolutePath().indexOf(".ehw") != (-1)) {
				createTableFromDataFile(file.getAbsolutePath());
			}//else 
			else JOptionPane.showMessageDialog(null, "Name of the file is not correctly", "Error", JOptionPane.ERROR_MESSAGE);
		}//if
		else if (res == JFileChooser.CANCEL_OPTION) {
				System.out.println("Cancel");
		}//if
	}//openFile ()
//*******************************************************************************

	public static void createNewTable(String mark)
			throws Exception {

		if (mark.equals("FixSal")) {

			// ������� ������ ���������a
			Company.getInstance().setArrListObjEmplFixSal(EmployeeFixedSalary.createNewObjEmplFixSal());

			// ������� ������
			EmplFixSalTableModel emplFixSalTableModel = new EmplFixSalTableModel(
					Company.getInstance().getArrListObjEmplFixSal());

			// �������� ����� ����������� �������
			getMainFrame().displayTable(emplFixSalTableModel);
		}// if
		else if (mark.equals("HourlyWages")) {

			// ������� ������ ���������a
			Company.getInstance().setArrListObjEmplHourlyWages(EmployeeHourlyWages.createNewObjEmplHourlyWages());

			// ������� ������
			EmplHourlyWagesTableModel emplHourlyWagesTableModel = new EmplHourlyWagesTableModel(
					Company.getInstance().getArrListObjEmplHourlyWages());

			// �������� ����� ����������� �������
			getMainFrame().displayTable(emplHourlyWagesTableModel);
		}//else if
	}//createNewTable()

	//*******************************************************************************
	public static void createTableFromDataFile (String pathFileIn) throws Exception {
		
		if (pathFileIn.indexOf(".efs") != (-1)) {
			
			//������� ������� �����������
			Company.getInstance().setArrListObjEmplFixSal(EmployeeFixedSalary.
					createArrayListObjEmplFixSalFromFile(pathFileIn));
		
			//������� ������
			EmplFixSalTableModel emplFixSalTableModel = 
					new EmplFixSalTableModel (Company.getInstance().getArrListObjEmplFixSal());

			//�������� ����� ����������� �������
			getMainFrame().displayTable(emplFixSalTableModel);
		}//if
		else if (pathFileIn.indexOf(".ehw") != (-1)) {
			
			//������� ������� �����������
			Company.getInstance().setArrListObjEmplHourlyWages(EmployeeHourlyWages.
					createArrayListObjEmplHourlyWagesFromFile(pathFileIn));
		
			//������� ������
			EmplHourlyWagesTableModel emplHourlyWagesTableModel =
					new EmplHourlyWagesTableModel(Company.getInstance().getArrListObjEmplHourlyWages());

			//�������� ����� ����������� �������
			getMainFrame().displayTable(emplHourlyWagesTableModel);
		}//else if
	}//createTableFromDataFile
//*******************************************************************************
	public static int showInputDialog () {
			
		try {
			int numGeneration = Integer.valueOf((String) JOptionPane.showInputDialog(
								null,
								"Enter the number Employee",
								"Number Employee",
								JOptionPane.QUESTION_MESSAGE
								//new ImageIcon(),
								//null,  
								//null	
								));
				return numGeneration;
				} catch (NumberFormatException ex) {
				  JOptionPane.showMessageDialog(null, "Field 'amount Employees' requires an integer value",
						  "Error", JOptionPane.ERROR_MESSAGE);
				  return 0;
				}
	}//showInputDialog ()
}//JMenuTest

//*******//class EmployeeFixSalListener//****************************************

class CompanyDataListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Company Data")) {
		}//if
		else if (event.getActionCommand().equals("Open List 'All Employee'")) {
		}//else if
		else if (event.getActionCommand().equals("List of Departments")) {
		}//else if
		else if (event.getActionCommand().equals("List of Posts")) {
		}//else if

	}//actionPerformed
}//class CompanyDataListener

//*******//class EmployeeFixSalListener//****************************************

class EmployeeFixSalListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open List Employees")) {
			try {
				MenuBar.openFileEmployeesData();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//if
		else if (event.getActionCommand().equals("New")) {
			
			try {
				MenuBar.createNewTable("FixSal");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
	}//actionPerformed
}//class EmployeeFixSalListener

//*******//class EmployeeHourlyWagesListener//***********************************

class EmployeeHourlyWagesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open List Employees")) {
			try {
				MenuBar.openFileEmployeesData();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//if
		else if (event.getActionCommand().equals("New")) {
			
			try {
				MenuBar.createNewTable("HourlyWages");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
	}//actionPerformed
}//class EmployeeHourlyWagesListener

//*******//class TestModeListener//********************************************************************

class TestModeListener implements ActionListener {
		
	
//*********************************************************
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//�������� �� ����������� ���� ���������� ������������ �����������
		int amountEmployee = MenuBar.showInputDialog();

		if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplFixSal().getActionCommand())) {
			
			try {
								
				//���������� random-data �� ����������� � ���� "EmployeesFixedSalary.efs"
				//���������� .efs �� EmployeesFixedSalary - ��� ������� ��� ���������� ���� ��� ����������
				TestMode.generationEmployeeDataAndFiling(amountEmployee, "src/main/resources/EmployeesFixedSalary.efs");
				
				MenuBar.createTableFromDataFile("src/main/resources/EmployeesFixedSalary.efs");				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplHourlyWages().getActionCommand())) {
			
			try {
				
				//���������� random-data �� ����������� � ���� "EmployeesHourlyWages.ehw"
				//���������� .ehw - �� EmployeesHourlyWages - ��� ������� ��� ���������� ���� ��� ����������
				TestMode.generationEmployeeDataAndFiling(amountEmployee, "src/main/resources/EmployeesHourlyWages.ehw");
				
				MenuBar.createTableFromDataFile("src/main/resources/EmployeesHourlyWages.ehw");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if 
	}//actionPerformed
}//class TestModeListener