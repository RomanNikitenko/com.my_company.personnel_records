package com.company.personnelrecoreds.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;

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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import com.company.personnelrecords.employee.EmployeeFixedSalary;
import com.company.personnelrecords.employee.EmployeeHourlyWages;
import com.company.personnelrecords.test.Test;

public class MenuBar extends JFrame{
	
	private static JMenuBar persRecMenuBar;
	private static MainFrame mainFrame;
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
	   
	   //�����. ����������� ����
	   menuEmployeeFixSal.add(new JSeparator());
	   
	   //�����. ���� �����
	   submenuEmplFixSal = new JMenuItem("Exit");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener (new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent event) {
			   System.exit(0);
		   }
	   });
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
	   menuTestMode.setPreferredSize(new Dimension(80, 40));
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
	public static void openFileEmployeesData (AbstractTableModel tableModel) throws ClassNotFoundException, InstantiationException,
	IllegalAccessException, UnsupportedLookAndFeelException {

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
			
			//��������, 
			if (file.getAbsolutePath().indexOf(".efs") != (-1) &&
					tableModel instanceof EmplFixSalTableModel) {
				try {
					//������� ������� �����������
					((EmplFixSalTableModel) tableModel).setArrListObjEmplFixSal( 
							EmployeeFixedSalary.createArrayListObjEmplFixSalFromFile(file.getAbsolutePath()));
					
					//�������� ����� �������� �������
					mainFrame.createTable(tableModel);
					
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}// else
			else if (file.getAbsolutePath().indexOf(".ehw") != (-1) &&
					tableModel instanceof EmplHourlyWagesTableModel) {
				try {
					
					//������� ������� �����������
					((EmplHourlyWagesTableModel) tableModel).setArrListObjEmplHourlyWages( 
							EmployeeHourlyWages.createArrayListObjEmplHourlyWagesFromFile(file.getAbsolutePath()));
					
					//�������� ����� �������� �������
					mainFrame.createTable(tableModel);
					
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			} 
			else JOptionPane.showMessageDialog(null, "Name of the file is not correctly", "Error", JOptionPane.ERROR_MESSAGE);
		}//if
		else if (res == JFileChooser.CANCEL_OPTION) {
				System.out.println("Cancel");
		}//if
	}//openFile ()
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

class EmployeeFixSalListener implements ActionListener {
	
	private EmplFixSalTableModel emplFixSalTableModel;

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open List Employees")) {
			try {

				//������� ������ �������
				emplFixSalTableModel = new EmplFixSalTableModel();
				
				MenuBar.openFileEmployeesData(emplFixSalTableModel);

			} catch (ClassNotFoundException | InstantiationException 
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//if
		else if (event.getActionCommand().equals("New")) {
			
			try {
				//������� ������ �������
				emplFixSalTableModel = new EmplFixSalTableModel ();
				
				//������� ����� ������ ����������
				emplFixSalTableModel.getArrListObjEmplFixSal().add( 
						new EmployeeFixedSalary(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
				
				//�������� ����� �������� �������
				MenuBar.getMainFrame().createTable(emplFixSalTableModel);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
	}//actionPerformed
}//class EmployeeFixSalListener

//*******//class EmployeeHourlyWagesListener//***********************************

class EmployeeHourlyWagesListener implements ActionListener {

	private EmplHourlyWagesTableModel emplHourlyWagesTableModel;

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open List Employees")) {
			try {

				//������� ������ �������
				emplHourlyWagesTableModel = new EmplHourlyWagesTableModel();
				
				MenuBar.openFileEmployeesData(emplHourlyWagesTableModel);

			} catch (ClassNotFoundException | InstantiationException 
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//if
		else if (event.getActionCommand().equals("New")) {
			
			try {
				//������� ������ �������
				emplHourlyWagesTableModel = new EmplHourlyWagesTableModel();
				
				//������� ����� ������ ����������
				emplHourlyWagesTableModel.getArrListObjEmplHourlyWages().add( 
						new EmployeeHourlyWages(0, "", "", "", new BigDecimal(0), 0, "", "", "", new BigDecimal(0)));
				
				//�������� ����� �������� �������
				MenuBar.getMainFrame().createTable(emplHourlyWagesTableModel);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
	}//actionPerformed
}//class EmployeeHourlyWagesListener

//*******//class TestModeListener//********************************************************************

class TestModeListener implements ActionListener {
	private EmplFixSalTableModel emplFixSalTablemodel;
	private EmplHourlyWagesTableModel emplHourlyWagesTablemodel;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//�������� �� ����������� ���� ���������� ������������ �����������
		int amountEmployee = MenuBar.showInputDialog();

		if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplFixSal().getActionCommand())) {
			
			try {
								
				//���������� random-data �� ����������� � ���� "EmployeesFixedSalary.efs"
				//���������� .efs �� EmployeesFixedSalary - ��� ������� ��� ���������� ���� ��� ����������
				Test.generationEmployeeDataAndFiling(amountEmployee, "EmployeesFixedSalary.efs");
				
				//������� ������
				emplFixSalTablemodel = new EmplFixSalTableModel ();
				
				//������� ������� �����������
				emplFixSalTablemodel.setArrListObjEmplFixSal( 
						EmployeeFixedSalary.createArrayListObjEmplFixSalFromFile("EmployeesFixedSalary.efs"));
				
				//�������� ����� �������� �������
				MenuBar.getMainFrame().createTable(emplFixSalTablemodel);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplHourlyWages().getActionCommand())) {
			
			try {
				
				//���������� random-data �� ����������� � ���� "EmployeesHourlyWages.ehw"
				//���������� .ehw - �� EmployeesHourlyWages - ��� ������� ��� ���������� ���� ��� ����������
				Test.generationEmployeeDataAndFiling(amountEmployee, "EmployeesHourlyWages.ehw");
				
				//������� ������
				emplHourlyWagesTablemodel = new EmplHourlyWagesTableModel();
				
				//������� ������� �����������
				emplHourlyWagesTablemodel.setArrListObjEmplHourlyWages(
						EmployeeHourlyWages.createArrayListObjEmplHourlyWagesFromFile("EmployeesHourlyWages.ehw"));
				
				//�������� ����� �������� �������
				MenuBar.getMainFrame().createTable(emplHourlyWagesTablemodel);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if 
	}//actionPerformed
}//class TestModeListener
