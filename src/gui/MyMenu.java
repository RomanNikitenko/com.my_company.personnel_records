package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;

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
	   submenuEmplFixSal = new JMenuItem("Open List Employee");
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
	   submenuEmplHourlyWages = new JMenuItem("Open List Employee");
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyMenu();
	}//main
}//JMenuTest

class EmployeeFixSalListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("EmployeeFixSalListener нажат пункт:" + event.getActionCommand());
	}//actionPerformed
}//class EmployeeFixSalListener

class EmployeeHourlyWagesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("EmployeeHourlyWagesListener нажат пункт:" + event.getActionCommand());
	}//actionPerformed
}//class EmployeeHourlyWagesListener

class TestModeListener implements ActionListener {
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(MyMenu.radioMenuGenerEmplFixSal.getActionCommand())) {
			
			EmplFixSalTableModel emplFixSalTableModel = new EmplFixSalTableModel();
			try {
				
				//генерируем random-data по сотрудникам в файл "EmployeesFixedSalary.out"
				Test.generationEmployeeDataAndFiling(100, "EmployeesFixedSalary.out");
				
				//создаем объекты сотрудников
				EmplFixSalTableModel.arrListObjEmplFixSal = 
						EmployeeFixedSalary.createArrayListObjEmplFixSalFromFile("EmployeesFixedSalary.out");
				
				//вызываем метод создания таблицы
				GUI_PersonnelRecords.createTable(emplFixSalTableModel);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MyMenu.radioMenuGenerEmplHourlyWages.getActionCommand())) {
			
			EmplHourlyWagesTableModel emplHourlyWagesTableModel = new EmplHourlyWagesTableModel();
			
			try {
				//генерируем random-data по сотрудникам в файл "EmployeesHourlyWages.out"
				Test.generationEmployeeDataAndFiling(100, "EmployeesHourlyWages.out");
				
				//создаем объекты сотрудников
				EmplHourlyWagesTableModel.arrListObjEmplHourlyWages = 
						EmployeeHourlyWages.createArrayListObjEmplHourlyWagesFromFile("EmployeesHourlyWages.out");
				
				//вызываем метод создания таблицы
				GUI_PersonnelRecords.createTable(emplHourlyWagesTableModel);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if 
	}//actionPerformed
}//class TestModeListener
