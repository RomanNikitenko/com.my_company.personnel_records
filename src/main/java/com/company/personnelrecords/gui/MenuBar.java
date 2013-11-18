package com.company.personnelrecords.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Savepoint;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.company.personnelrecords.company.Company;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.testmode.TestMode;
import com.company.personnelrecords.util.MyUtil;

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
	private static JMenuItem submenuGenerateCompany;
	private static JMenu submenuGenerateEmpl;
	private static JRadioButtonMenuItem radioMenuGenerEmplFixSal;
	private static JRadioButtonMenuItem radioMenuGenerEmplHourlyWages;
	private static ButtonGroup rbGroup;
	private static Dimension screenSize;
	
	private static JFrame companyDataFrame;
	private static JTextField txtFieldCompanyName;
	private static JTextField txtFieldCompanyCEO;
	private static JTextField txtFieldCompanyCurrentAccount;
	private static JTextField txtFieldCompanyEDRPOU;
	private static JTextArea txtAreaCompanyRegisteredOffice;

	public MenuBar(){
		
		//создаем панель меню - JMenuBar
	   setPersRecMenuBar(new JMenuBar());
	 
	   //получаем размер экрана
	   screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//*******Company*******//
	   
	   //создаем подменю Company
	   menuCompany = new JMenu("<HTML><CENTER>Company</CENTER</HTML>");
	   menuCompany.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //добав. пункт "Company Data"
	   submenuCompanyData = new JMenuItem("Company Data");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());
	   
	   //добав. пункт меню - "Open List 'All Employee'"   
	   submenuCompanyData = new JMenuItem("Open List 'All Employee'");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //добав. пункт меню - "List of Departments"   
	   submenuCompanyData = new JMenuItem("List of Departments");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //добав. пункт меню - "List of Departments"   
	   submenuCompanyData = new JMenuItem("List of Posts");
	   submenuCompanyData.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
	   menuCompany.add(submenuCompanyData);
	   submenuCompanyData.addActionListener(new CompanyDataListener());

	   //добав. разделитель меню
	   menuCompany.add(new JSeparator());
	   
	   //добав. меню выход
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
	   //подменю добав к основному меню
	   getPersRecMenuBar().add(menuCompany);
	   
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

	   //подменю добав к основному меню
	   getPersRecMenuBar().add(menuEmployeeFixSal);
	   
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
	   getPersRecMenuBar().add(menuEmployeeHourlyWages);

//*******Test Mode*******//
		 
	   //создаем подменю Test Mode
	   menuTestMode = new JMenu("Test Mode");
//	   menuTestMode.setPreferredSize(new Dimension(80, 40));
	   menuTestMode.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //добав. пункт "Generate Company"
	   submenuGenerateCompany = new JMenuItem ("Generate Company");
	   submenuGenerateCompany.addActionListener(new TestModeListener());
	   menuTestMode.add(submenuGenerateCompany);
	   
	   
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
	   
	   //добав радио батоны в Ѕаттон√рупп
	   rbGroup = new ButtonGroup();
	   rbGroup.add(radioMenuGenerEmplFixSal);
	   rbGroup.add(radioMenuGenerEmplHourlyWages);
	   
	   menuTestMode.add(submenuGenerateEmpl);
	   
	   //подменю добав к основному меню
	   getPersRecMenuBar().add(menuTestMode);
	   
	}//конструктор
	

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
	public static JMenuItem getSubmenuGenerateCompany() {
		return submenuGenerateCompany;
	}

	public static void setSubmenuGenerateCompany(JMenuItem submenuGenerateCompany) {
		MenuBar.submenuGenerateCompany = submenuGenerateCompany;
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
	public static JFrame getCompanyDataFrame() {
		return companyDataFrame;
	}


	public static void setCompanyDataFrame(JFrame companyDataFrame) {
		MenuBar.companyDataFrame = companyDataFrame;
	}
	public static JTextField getTxtFieldCompanyName() {
		return txtFieldCompanyName;
	}


	public static void setTxtFieldCompanyName(JTextField txtFieldCompanyName) {
		MenuBar.txtFieldCompanyName = txtFieldCompanyName;
	}


	public static JTextField getTxtFieldCompanyCEO() {
		return txtFieldCompanyCEO;
	}


	public static void setTxtFieldCompanyCEO(JTextField txtFieldCompanyCEO) {
		MenuBar.txtFieldCompanyCEO = txtFieldCompanyCEO;
	}


	public static JTextField getTxtFieldCompanyCurrentAccount() {
		return txtFieldCompanyCurrentAccount;
	}


	public static void setTxtFieldCompanyCurrentAccount(
			JTextField txtFieldCompanyCurrentAccount) {
		MenuBar.txtFieldCompanyCurrentAccount = txtFieldCompanyCurrentAccount;
	}


	public static JTextField getTxtFieldCompanyEDRPOU() {
		return txtFieldCompanyEDRPOU;
	}


	public static void setTxtFieldCompanyEDRPOU(JTextField txtFieldCompanyEDRPOU) {
		MenuBar.txtFieldCompanyEDRPOU = txtFieldCompanyEDRPOU;
	}


	public static JTextArea getTxtAreaCompanyRegisteredOffice() {
		return txtAreaCompanyRegisteredOffice;
	}


	public static void setTxtAreaCompanyRegisteredOffice(
			JTextArea txtAreaCompanyRegisteredOffice) {
		MenuBar.txtAreaCompanyRegisteredOffice = txtAreaCompanyRegisteredOffice;
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
				("“екстовые файлы *.ehw *.efs *.txt *.in *.doc"  , "ehw", "efs", "txt", "in", "doc");
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

			// создаем объект сотрудникa
			Company.getInstance().setArrListObjEmplFixSal(EmployeeFixedSalary.createNewObjEmplFixSal());

			// создаем модель
			EmplFixSalTableModel emplFixSalTableModel = new EmplFixSalTableModel(
					Company.getInstance().getArrListObjEmplFixSal());

			// вызываем метод отображени€ таблицы
			getMainFrame().displayTable(emplFixSalTableModel);
		}// if
		else if (mark.equals("HourlyWages")) {

			// создаем объект сотрудникa
			Company.getInstance().setArrListObjEmplHourlyWages(EmployeeHourlyWages.createNewObjEmplHourlyWages());

			// создаем модель
			EmplHourlyWagesTableModel emplHourlyWagesTableModel = new EmplHourlyWagesTableModel(
					Company.getInstance().getArrListObjEmplHourlyWages());

			// вызываем метод отображени€ таблицы
			getMainFrame().displayTable(emplHourlyWagesTableModel);
		}//else if
	}//createNewTable()

	//*******************************************************************************
	public static void createTableFromDataFile (String pathFileIn) throws Exception {
		
		if (pathFileIn.indexOf(".efs") != (-1)) {
			
			//создаем объекты сотрудников
			Company.getInstance().setArrListObjEmplFixSal(EmployeeFixedSalary.
					createArrayListObjEmplFixSalFromFile(pathFileIn));
		
			//создаем модель
			EmplFixSalTableModel emplFixSalTableModel = 
					new EmplFixSalTableModel (Company.getInstance().getArrListObjEmplFixSal());

			//вызываем метод отображени€ таблицы
			getMainFrame().displayTable(emplFixSalTableModel);
		}//if
		else if (pathFileIn.indexOf(".ehw") != (-1)) {
			
			//создаем объекты сотрудников
			Company.getInstance().setArrListObjEmplHourlyWages(EmployeeHourlyWages.
					createArrayListObjEmplHourlyWagesFromFile(pathFileIn));
		
			//создаем модель
			EmplHourlyWagesTableModel emplHourlyWagesTableModel =
					new EmplHourlyWagesTableModel(Company.getInstance().getArrListObjEmplHourlyWages());

			//вызываем метод отображени€ таблицы
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
//*******************************************************************************
	public static void showCompanyDataFrame () {

		companyDataFrame = new JFrame("Company Data");
		companyDataFrame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;//выравнивание компонента внутри отведенного дл€ него пространства
		constraints.fill   = GridBagConstraints.NONE; //раст€гивание компонента - NONE  - не мен€ет свой размер
		constraints.insets = new Insets(15, 10, 10, 10);//отступ сверху, слева, снизу, справа
		
		constraints.gridx = 0;//номер столбца, куда будет помещен компонент 
		constraints.gridy = 0;//номер строки, куда будет помещен компонент
		JLabel labelCompanyName = new JLabel("<html><b>Company Name: </b></html>");
		companyDataFrame.getContentPane().add(labelCompanyName, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		txtFieldCompanyName = new JTextField();
		txtFieldCompanyName.setPreferredSize(new Dimension(230, 25));
		txtFieldCompanyName.setText(Company.getInstance().getCompanyName());
		companyDataFrame.getContentPane().add(txtFieldCompanyName, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1; 
		JLabel labelCompanyCEO = new JLabel("<html><b>Company CEO: </b></html>");
		companyDataFrame.getContentPane().add(labelCompanyCEO, constraints);

		constraints.gridx = 1; 
		constraints.gridy = 1; 
		txtFieldCompanyCEO = new JTextField();
		txtFieldCompanyCEO.setPreferredSize(new Dimension(230, 25));
		txtFieldCompanyCEO.setText(Company.getInstance().getCompanyCEO());
		companyDataFrame.getContentPane().add(txtFieldCompanyCEO, constraints);

		constraints.gridx = 0; 
		constraints.gridy = 2; 
		JLabel labelCompanyCurrentAccount = new JLabel("<html><b>Company Current Account: </b></html>");
		companyDataFrame.getContentPane().add(labelCompanyCurrentAccount, constraints);

		constraints.gridx = 1; 
		constraints.gridy = 2; 
		txtFieldCompanyCurrentAccount = new JTextField();
		txtFieldCompanyCurrentAccount.setPreferredSize(new Dimension(230, 25));
		txtFieldCompanyCurrentAccount.setText("" + Company.getInstance().getCompanyCurrentAccount());
		companyDataFrame.getContentPane().add(txtFieldCompanyCurrentAccount, constraints);

		constraints.gridx = 0; 
		constraints.gridy = 3; 
		JLabel labelCompanyEDRPOU = new JLabel("<html><b>Company EDRPOU: </b></html>");
		companyDataFrame.getContentPane().add(labelCompanyEDRPOU, constraints);

		constraints.gridx = 1; 
		constraints.gridy = 3; 
		txtFieldCompanyEDRPOU = new JTextField();
		txtFieldCompanyEDRPOU.setPreferredSize(new Dimension(230, 25));
		txtFieldCompanyEDRPOU.setText("" + Company.getInstance().getCompanyEDRPOU());
		companyDataFrame.getContentPane().add(txtFieldCompanyEDRPOU, constraints);

		constraints.gridx = 0; 
		constraints.gridy = 4; 
		JLabel labelCompanyRegisteredOffice = new JLabel("<html><b>Company Registered Office: </b></html>");
		companyDataFrame.getContentPane().add(labelCompanyRegisteredOffice, constraints);

		constraints.gridx = 1; 
		constraints.gridy = 4; 
		txtAreaCompanyRegisteredOffice = new JTextArea();
		txtAreaCompanyRegisteredOffice.setPreferredSize(new Dimension(230, 50));
		txtAreaCompanyRegisteredOffice.setFont(new Font (Font.SERIF, Font.ROMAN_BASELINE, 12));
		txtAreaCompanyRegisteredOffice.setText(Company.getInstance().getCompanyRegisteredOffice());
		txtAreaCompanyRegisteredOffice.setLineWrap(true);
		txtAreaCompanyRegisteredOffice.setWrapStyleWord(true);
		companyDataFrame.getContentPane().add(txtAreaCompanyRegisteredOffice, constraints);
		
		constraints.gridx = 0; 
		constraints.gridy = 5; 
		constraints.anchor = GridBagConstraints.CENTER;
		JButton butCompanyDataSave = new JButton("<html><b>Save </b></html>");
		butCompanyDataSave.setPreferredSize(new Dimension(100, 35));
		butCompanyDataSave.addActionListener(new CompanyDataListener());
		companyDataFrame.getContentPane().add(butCompanyDataSave, constraints);

		constraints.gridx = 1; 
		constraints.gridy = 5; 
		constraints.anchor = GridBagConstraints.CENTER;
		JButton butCompanyDataCancel = new JButton("<html><b>Cancel </b></html>");
		butCompanyDataCancel.setPreferredSize(new Dimension(100, 35));
		butCompanyDataCancel.addActionListener(new CompanyDataListener());
		companyDataFrame.getContentPane().add(butCompanyDataCancel, constraints);

		companyDataFrame.setSize(new Dimension(screenSize.width/3, screenSize.height/2));
		companyDataFrame.setLocation((screenSize.width - companyDataFrame.getWidth()) / 2,
		                (screenSize.height - companyDataFrame.getHeight()) / 3);
		companyDataFrame.setDefaultCloseOperation(companyDataFrame.DISPOSE_ON_CLOSE);
		companyDataFrame.setVisible(true); // отображать окно
	}//showCompanyDataFrame
	//*******************************************************************************
	public static void saveEditedCompanyData () throws IOException {
		
		if (! txtFieldCompanyName.getText().equals(Company.getInstance().getCompanyName())); {
			Company.getInstance().setCompanyName(txtFieldCompanyName.getText());
		}//if
		if (! txtFieldCompanyCEO.getText().equals(Company.getInstance().getCompanyCEO())); {
			Company.getInstance().setCompanyCEO(txtFieldCompanyCEO.getText());
		}//if
		if (! txtFieldCompanyCurrentAccount.getText().equals(Company.getInstance().getCompanyCurrentAccount())); {
			Company.getInstance().setCompanyCurrentAccount(Long.valueOf(txtFieldCompanyCurrentAccount.getText()));
		}//if
		if (! txtFieldCompanyEDRPOU.getText().equals(Company.getInstance().getCompanyEDRPOU())); {
			Company.getInstance().setCompanyEDRPOU(Long.valueOf(txtFieldCompanyEDRPOU.getText()));
		}//if
		if (! txtAreaCompanyRegisteredOffice.getText().equals(Company.getInstance().getCompanyRegisteredOffice())); {
			Company.getInstance().setCompanyRegisteredOffice(txtAreaCompanyRegisteredOffice.getText());
		}//if
		
		String strForFiling = "Company Name: " + Company.getInstance().getCompanyName() +  
								"   companyCEO: " +  Company.getInstance().getCompanyCEO() +
								"   companyCurrentAccount: " +  Company.getInstance().getCompanyCurrentAccount() +  
								"   companyEDRPOU: " + Company.getInstance().getCompanyEDRPOU() +
								"   companyRegisteredOffice: " + Company.getInstance().getCompanyRegisteredOffice();
		MyUtil.replacementStrInFile(strForFiling, "src/main/resources/CompanyData.cdt", "Company Name:");
		
	}//saveEditedCompanyData
}//MenuBar

//*******//class CompanyDataListener//****************************************

class CompanyDataListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (event.getActionCommand()) {
		case "Company Data":
				MenuBar.showCompanyDataFrame();
			break;
			
		case "<html><b>Cancel </b></html>":
			MenuBar.getCompanyDataFrame().dispose();
		break;
		
		case "<html><b>Save </b></html>":
			try {
				MenuBar.saveEditedCompanyData();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MenuBar.getCompanyDataFrame().dispose();
		break;

		case "Open List 'All Employee'":
			break;
			
		case "List of Departments":
			break;

		case "List of Posts":
			break;
		}//switch
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
		
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals(MenuBar.getSubmenuGenerateCompany().getActionCommand())) {
			try {
				TestMode.generationCompanyDataAndFiling("src/main/resources/CompanyData.cdt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplFixSal().getActionCommand())) {
			
			try {
				//получаем из диалогового окна количество генерируемых сотрудников
				int amountEmployee = MenuBar.showInputDialog();
								
				//генерируем random-data по сотрудникам в файл "EmployeesFixedSalary.efs"
				//расширение .efs от EmployeesFixedSalary - это поможет мне распознать файл при считывании
				TestMode.generationEmployeeDataAndFiling(amountEmployee, "src/main/resources/EmployeesFixedSalary.efs");
				
				MenuBar.createTableFromDataFile("src/main/resources/EmployeesFixedSalary.efs");				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		else if (event.getActionCommand().equals(MenuBar.getRadioMenuGenerEmplHourlyWages().getActionCommand())) {
			
			try {
				//получаем из диалогового окна количество генерируемых сотрудников
				int amountEmployee = MenuBar.showInputDialog();
				
				//генерируем random-data по сотрудникам в файл "EmployeesHourlyWages.ehw"
				//расширение .ehw - от EmployeesHourlyWages - это поможет мне распознать файл при считывании
				TestMode.generationEmployeeDataAndFiling(amountEmployee, "src/main/resources/EmployeesHourlyWages.ehw");
				
				MenuBar.createTableFromDataFile("src/main/resources/EmployeesHourlyWages.ehw");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if 
	}//actionPerformed
}//class TestModeListener
