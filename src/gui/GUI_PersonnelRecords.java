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
import javax.swing.table.AbstractTableModel;


public class GUI_PersonnelRecords extends JFrame {
	
//*****************************
	public static Dimension screenSize;
	public static JTable dataTable;
	public static JScrollPane jscrlp;
	public static JPanel mainPanel;
	public static JPanel panelEmployees;
	public static JPanel panelButEdit;
	public static JButton butAdd;
	public static JButton butDelete;
	public static JPanel panelEmplTable;
	
//*******Конструктор******************************
	public GUI_PersonnelRecords () throws Exception {
		
		new MyMenu();
		//получаем размер экрана
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
//*******//главная панель//*******
        mainPanel = new JPanel(); //создаем главную панель, задаем менеджер размещения
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
		
//*******//Панель Employees//*******
		panelEmployees = new JPanel(new BorderLayout());
		panelEmployees.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployees.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees",
				TitledBorder.CENTER, TitledBorder.TOP));
		
//*******//панель для кнопок EDIT
		panelButEdit = new JPanel(new GridLayout(7, 1, 0, 10));
//		panelButEdit.setLayout(new BoxLayout(panelButEdit, BoxLayout.Y_AXIS));
		panelButEdit.setPreferredSize(new Dimension (100, mainPanel.getHeight()-10));
		panelButEdit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Buttons Edit"));
		panelEmployees.add(panelButEdit, BorderLayout.WEST);
		
//*******//кнопоки EDIT
		butAdd = new JButton("Add");
		panelButEdit.add(butAdd);
		
		butDelete = new JButton("Delete");
		panelButEdit.add(butDelete);
		
//*******//панель для таблицы 
		panelEmplTable = new JPanel(new BorderLayout());
		panelEmplTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));
		
		mainPanel.add(panelEmployees, BorderLayout.CENTER);
			
	}//конструктор
//***********************************************************
	public static void createTable (AbstractTableModel tableModel) {
		
		//*******//создаем таблицу на основе нашей модели,
		//переданной в параметре
		dataTable = new JTable(tableModel);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
//		TableRowSorter<EmplFixSalTableModel> sorter = new TableRowSorter(tableModel);
//		 dataTable.setRowSorter(sorter);
		
		// Задаем размер столбцов
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
		
		
		// Создаем панель прокрутки и включаем в ее состав нашу таблицу
		jscrlp = new JScrollPane(dataTable,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelEmplTable.removeAll();

		//Добавляем на панель jscrlp вместе с таблицей
		panelEmplTable.add(jscrlp);
		if (tableModel instanceof EmplFixSalTableModel) {
			panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees With Fix Salary Data"));
		}
		else panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees With Hourly Wages Data"));
			
		//Добавляем панель с таблицей
		panelEmployees.add(panelEmplTable,BorderLayout.CENTER);
		panelEmplTable.updateUI();
		
	}//createTable ()
//***********************************************************
	public static void main(String[] args) throws Exception {
		new GUI_PersonnelRecords(); 
	}//main
}//class
