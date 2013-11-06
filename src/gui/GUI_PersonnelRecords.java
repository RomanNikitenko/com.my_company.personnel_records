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
	
//********Блок инициализации*********************
	public static ArrayList<ArrayList<String>> arrListDataEmployees;
	public static String [] columnNames = {"<html><center>Personal<br>Number", "Surname/Name/Middlename", "Department",
									"Post", "<html><center>Average<br>Salary", "<html><center>Tax <br>IdentifNum", "Education", "Passport", "Residance"};
	public JTable dataTable;
	
//*******Конструктор******************************
	public GUI_PersonnelRecords () throws Exception {

		//считываем данные по сотрудникам из файла
		arrListDataEmployees = MyUtil.readDataEmployeeFromFile("TestListEmployee.out");
		
		//создаем таблицу на основе нашей модели
		JTable dataTable = new JTable(new MyTableModel());
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(dataTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //Устаналиваем размеры прокручиваемой области
//        dataTable.setPreferredScrollableViewportSize(new Dimension(250, 100));
        //Задаем размер столбцов
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(55);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        dataTable.getColumnModel().getColumn(7).setPreferredWidth(220);
        dataTable.getColumnModel().getColumn(8).setPreferredWidth(300);
//*******//главная панель//*******
		JPanel mainPanel = new JPanel(); //создаем главную панель, задаем менеджер размещения
		mainPanel.setPreferredSize(new Dimension(900, 410));//устанавливаем размер
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//устанавливаем бордюр
		
		add(mainPanel);//добавляем главную панель к фрейму
		setTitle("PersonnelRecord"); //устанавливаем заголовок окна
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение работы приложения по закрытию главного окна
//		setLocationRelativeTo(null); //расположение окна - левый верхний угол по центру экрана
		setSize(1200, 650); // задаем размеры окна
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); // отображать окно
//		setExtendedState(MAXIMIZED_BOTH);//окно на весь экран
		
//*******//Панель Employee with fixed salary//*******
		JPanel panelEmployeeFixSalary = new JPanel(new BorderLayout());
		panelEmployeeFixSalary.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployeeFixSalary.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employee With Fix Salary"));
		
		//панель для кнопок EDIT
		JPanel panelButEdit = new JPanel();
		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Button Edit"));
		panelEmployeeFixSalary.add(panelButEdit, BorderLayout.WEST);
		
		//панель для таблицы
		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Table Data"));
		
		//Добавляем в на панель прокрути jscrlp вместе с таблицей
		panelTable.add(jscrlp);
		panelEmployeeFixSalary.add(panelTable,BorderLayout.CENTER);

		mainPanel.add(panelEmployeeFixSalary, BorderLayout.CENTER);
		
		
		

			
	}//конструктор
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
