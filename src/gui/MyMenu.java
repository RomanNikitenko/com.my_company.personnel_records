package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

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

import employee.EmployeeFixedSalary;
import employee.EmployeeHourlyWages;

import test.Test;


public class MyMenu extends JFrame{
	
	public static JMenuBar menuBar;
	public static JMenu menuEmployeeFixSal;
	public static JMenuItem submenuEmplFixSal;
	public static JMenu menuEmployeeHourlyWages;
	public static JMenuItem submenuEmplHourlyWages;
	public static JMenu menuTestMode;
	public static JMenu submenuGenerateEmpl;
	public static JRadioButtonMenuItem radioMenuGenerEmplFixSal;
	public static JRadioButtonMenuItem radioMenuGenerEmplHourlyWages;
	public static ButtonGroup rbGroup;
	
	public MyMenu(){
		
		//создаем панель меню - JMenuBar
	   menuBar = new JMenuBar();
	   
//*******Employee With Fix Salary*******//
	   
	   //создаем подменю Employee With Fix Salary
	   menuEmployeeFixSal = new JMenu("<html><center>Employee With <br> Fix Salary");
	   menuEmployeeFixSal.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeFixSal.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //добав. пункт "New"
	   submenuEmplFixSal = new JMenuItem("New");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener(new EmployeeFixSalListener());
	   
	   //добав. пункт меню - "Open List Employee"   
	   submenuEmplFixSal = new JMenuItem("Open List Employees");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener(new EmployeeFixSalListener());
	   
	   //добав. разделитель меню
	   menuEmployeeFixSal.add(new JSeparator());
	   
	   //добав. меню выход
	   submenuEmplFixSal = new JMenuItem("Exit");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener (new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent event) {
			   System.out.println("Аноним. лисенер: меню Выход.");
			   System.exit(0);
		   }
	   });
	   //подменю добав к основному меню
	   menuBar.add(menuEmployeeFixSal);
	   
//*******Employee with hourly wages*******//
	 
	   //создаем подменю Employee With hourly wages
	   menuEmployeeHourlyWages = new JMenu("<html><center>Employee With <br> Hourly Wages");
	   menuEmployeeHourlyWages.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeHourlyWages.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //добав. пункт "New"
	   submenuEmplHourlyWages = new JMenuItem("New");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //добав. пункт меню - "Open List Employee"   
	   submenuEmplHourlyWages = new JMenuItem("Open List Employees");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //добав. разделитель меню
	   menuEmployeeHourlyWages.add(new JSeparator());
	   
	   //подменю добав к основному меню
	   menuBar.add(menuEmployeeHourlyWages);

//*******Test Mode*******//
		 
	   //создаем подменю Test Mode
	   menuTestMode = new JMenu("Test Mode");
	   menuTestMode.setPreferredSize(new Dimension(80, 40));
	   menuTestMode.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //добав. пункт "Generate Employees"
	   submenuGenerateEmpl = new JMenu("Generate Employees");
	   
	   
	 //добав. радио-меню "Generation Employee with fix salary"
	   radioMenuGenerEmplFixSal = 
			   new JRadioButtonMenuItem("Generation Employee with fix salary");
	   submenuGenerateEmpl.add(radioMenuGenerEmplFixSal);
	   radioMenuGenerEmplFixSal.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	   
	 //добав. радио-меню "Generation Employee with hourly wages"
	   radioMenuGenerEmplHourlyWages = 
			   new JRadioButtonMenuItem("Generation Employee with hourly wages");
	   submenuGenerateEmpl.add(radioMenuGenerEmplHourlyWages);
	   radioMenuGenerEmplHourlyWages.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
	   
	   //добав радио батоны в БаттонГрупп
	   rbGroup = new ButtonGroup();
	   rbGroup.add(radioMenuGenerEmplFixSal);
	   rbGroup.add(radioMenuGenerEmplHourlyWages);
	   
	   menuTestMode.add(submenuGenerateEmpl);
	   
	   //подменю добав к основному меню
	   menuBar.add(menuTestMode);
	   
	}//конструктор
//*******************************************************************************
	public static void openFileEmployeesData (String mark) throws ClassNotFoundException, InstantiationException,
	IllegalAccessException, UnsupportedLookAndFeelException {

		JFileChooser fileOpen = new JFileChooser();
		
		fileOpen.getFileSelectionMode();
		fileOpen.getFileView();
		fileOpen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		fileOpen.setDialogTitle("Open File with Employees Data");
		fileOpen.setDragEnabled(true);
		fileOpen.setDialogType(JFileChooser.OPEN_DIALOG);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter
				("Текстовые файлы *.ehw *.efs *.txt *.in *.doc"  , "ehw", "efs", "txt", "in", "doc");
		fileOpen.addChoosableFileFilter(filter);
		fileOpen.setMultiSelectionEnabled(true);
		
		int res = fileOpen.showDialog(null,null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = fileOpen.getSelectedFile();
			
			//Проверка, 
			if (file.getAbsolutePath().indexOf(".efs") != (-1) &&
					mark.equals("FixSal")) {
				try {
					//создаем объекты сотрудников
					GUI_Frame.tableModel = new EmplFixSalTableModel(); 
					EmplFixSalTableModel.arrListObjEmplFixSal = 
							EmployeeFixedSalary.createArrayListObjEmplFixSalFromFile("EmployeesFixedSalary.efs");
					
					//вызываем метод создания таблицы
					GUI_Frame.createTable();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}// else
			else if (file.getAbsolutePath().indexOf(".ehw") != (-1) &&
					mark.equals("HourlyWages")) {
				try {
					//создаем объекты сотрудников
					EmplHourlyWagesTableModel.arrListObjEmplHourlyWages = 
							EmployeeHourlyWages.createArrayListObjEmplHourlyWagesFromFile("EmployeesHourlyWages.ehw");
					
					//вызываем метод создания таблицы
					GUI_Frame.createTable();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			} 
			else JOptionPane.showMessageDialog(null, "Name of the file is not correctly", "Error", JOptionPane.ERROR_MESSAGE);
		}//if
//		else if (res == JFileChooser.CANCEL_OPTION) {
//				System.out.println("Cancel");
//		}//if
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
				  JOptionPane.showMessageDialog(null, "Field 'amount Employees' requires an integer value", "Error", JOptionPane.ERROR_MESSAGE);
				  return 0;
				}
	}//showInputDialog ()
//*******//MAIN//****************************************************************	
	public static void main(String[] args) {
		new MyMenu();
	}//main
}//JMenuTest

//*******//class EmployeeFixSalListener//****************************************

class EmployeeFixSalListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open List Employees")) {
			try {
				//т.к. метод, который открывает файлы, у меня читает оба формата
				//файлов, то передаем в параметре метку, чтобы сообщить откуда вызван метод
				// и какой тип файлов читать
				MyMenu.openFileEmployeesData("FixSal");
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//if
		else if (event.getActionCommand().equals("New")) {
			
			try {
				GUI_Frame.tableModel = new EmplFixSalTableModel ();
				
				//вызываем метод создания таблицы
				GUI_Frame.createTable();
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
				//т.к. метод, который открывает файлы, у меня читает оба формата
				//файлов, то передаем в параметре метку, чтобы сообщить откуда вызван метод
				// и какой тип файлов читать
				MyMenu.openFileEmployeesData("HourlyWages");
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}//catch
		}//if
	}//actionPerformed
}//class EmployeeHourlyWagesListener

//*******//class TestModeListener//********************************************************************

class TestModeListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//получаем из диалогового окна количество генерируемых сотрудников
		int amountEmployee = MyMenu.showInputDialog();

		if (event.getActionCommand().equals(MyMenu.radioMenuGenerEmplFixSal.getActionCommand())) {
			
			try {
								
				//генерируем random-data по сотрудникам в файл "EmployeesFixedSalary.efs"
				//расширение .efs от EmployeesFixedSalary - это поможет мне распознать файл при считывании
				Test.generationEmployeeDataAndFiling(amountEmployee, "EmployeesFixedSalary.efs");
				
				//создаем модель
				GUI_Frame.tableModel = new EmplFixSalTableModel ();
				
				//создаем объекты сотрудников
				EmplFixSalTableModel.arrListObjEmplFixSal = 
						EmployeeFixedSalary.createArrayListObjEmplFixSalFromFile("EmployeesFixedSalary.efs");
				
				//вызываем метод создания таблицы
				GUI_Frame.createTable();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MyMenu.radioMenuGenerEmplHourlyWages.getActionCommand())) {
			
			try {
				
				//генерируем random-data по сотрудникам в файл "EmployeesHourlyWages.ehw"
				//расширение .ehw - от EmployeesHourlyWages - это поможет мне распознать файл при считывании
				Test.generationEmployeeDataAndFiling(amountEmployee, "EmployeesHourlyWages.ehw");
				
				//создаем модель
				GUI_Frame.tableModel = new EmplHourlyWagesTableModel();
				
				//создаем объекты сотрудников
				EmplHourlyWagesTableModel.arrListObjEmplHourlyWages = 
						EmployeeHourlyWages.createArrayListObjEmplHourlyWagesFromFile("EmployeesHourlyWages.ehw");
				
				//вызываем метод создания таблицы
				GUI_Frame.createTable();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if 
	}//actionPerformed
}//class TestModeListener
