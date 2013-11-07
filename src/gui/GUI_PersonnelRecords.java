package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.annotation.XmlType.DEFAULT;

import test.Test;
import util.MyUtil;


public class GUI_PersonnelRecords extends JFrame implements ActionListener {
	
//********Блок инициализации*********************
	public static ArrayList<ArrayList<String>> arrListDataEmployees;
	
	public JTable dataTable;
	
//*******Конструктор******************************
	public GUI_PersonnelRecords () throws Exception {
		
		new MyMenu();
		
		//генерируем random-data по сотрудникам в файл "TestListEmployee.out"
		Test.generationEmployeeDataAndFiling(100, "EmployeeFixedSalary.out");
		
		//считываем данные по сотрудникам из файла
		arrListDataEmployees = MyUtil.readDataEmployeeFromFile("EmployeeFixedSalary.out");
		
		//получаем размер экрана
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
//*******//создаем таблицу на основе нашей модели
		JTable dataTable = new JTable(new MyTableModel());
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(dataTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //Устаналиваем размеры прокручиваемой области
//        dataTable.setPreferredScrollableViewportSize(new Dimension(screenSize.width-50, screenSize.height-50));
        //Задаем размер столбцов
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
        
//*******//главная панель//*******
        
        JPanel mainPanel = new JPanel(); //создаем главную панель, задаем менеджер размещения
		mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height-25));//устанавливаем размер
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//устанавливаем бордюр
		
//*******//настройки окна//*******
		add(mainPanel);//добавляем главную панель к фрейму
		this.setJMenuBar(MyMenu.menuBar);//устанавливаем меню
		setTitle("PersonnelRecord"); //устанавливаем заголовок окна
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение работы приложения по закрытию главного окна
//		setLocationRelativeTo(null); //расположение окна - левый верхний угол по центру экрана
		setSize(new Dimension(screenSize.width, screenSize.height-25));
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); // отображать окно
		setExtendedState(MAXIMIZED_BOTH);//окно на весь экран
		
//*******//Панель Employee with fixed salary//*******
		JPanel panelEmployeeFixSalary = new JPanel(new BorderLayout());
		panelEmployeeFixSalary.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployeeFixSalary.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employee With Fix Salary",
				TitledBorder.CENTER, TitledBorder.TOP));
		
//*******//панель для кнопок EDIT
		JPanel panelButEdit = new JPanel(new GridLayout(7, 1, 0, 10));
//		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Buttons Edit"));
		panelEmployeeFixSalary.add(panelButEdit, BorderLayout.WEST);
		
//*******//кнопоки EDIT
		JButton butAdd = new JButton("Add");
		panelButEdit.add(butAdd);
		
		JButton butDelete = new JButton("Delete");
		panelButEdit.add(butDelete);
		
//*******//панель для таблицы
		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Table Data"));
		
		//Добавляем на панель jscrlp вместе с таблицей
		panelTable.add(jscrlp);
		
		//Вкладываем панели
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
