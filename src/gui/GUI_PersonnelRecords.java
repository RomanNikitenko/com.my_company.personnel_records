package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;



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
		
//******* онструктор******************************
	public GUI_PersonnelRecords () throws Exception {
		
		new MyMenu();
		//получаем размер экрана
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
//*******//главна€ панель//*******
        mainPanel = new JPanel(); //создаем главную панель, задаем менеджер размещени€
		mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height-25));//устанавливаем размер
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//устанавливаем бордюр
		
//*******//настройки окна//*******
		add(mainPanel);//добавл€ем главную панель к фрейму
		this.setJMenuBar(MyMenu.menuBar);//устанавливаем меню
		setTitle("PersonnelRecord"); //устанавливаем заголовок окна
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение работы приложени€ по закрытию главного окна
//		setLocationRelativeTo(null); //расположение окна - левый верхний угол по центру экрана
		setSize(new Dimension(screenSize.width, screenSize.height-25));
		setLocation((screenSize.width - getWidth()) / 2,
		                (screenSize.height - getHeight()) / 3);
		setVisible(true); // отображать окно
		setExtendedState(MAXIMIZED_BOTH);//окно на весь экран
		
//*******//ѕанель Employees//*******
		panelEmployees = new JPanel(new BorderLayout());
		panelEmployees.setPreferredSize(new Dimension (mainPanel.getWidth()-10, mainPanel.getHeight()-10));
		panelEmployees.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees",
				TitledBorder.CENTER, TitledBorder.TOP));
		
//*******//панель дл€ кнопок EDIT
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
		
//*******//панель дл€ таблицы 
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
		
		TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<AbstractTableModel>(tableModel) {
			
			@Override
			public Comparator<?> getComparator(int column) {
			      // дл€ нулевой строки
			      if (column == 0 || column == 4 || column == 5 || column == 6 ) {
			        return new Comparator<String>() {
			          @Override
			          public int compare(String s1,String s2) {
			            return Integer.parseInt(s1) - Integer.parseInt(s2);
			          }
			        };
			     }
			      return super.getComparator(column);
			}
		};
		dataTable.setRowSorter(sorter);
		
		// «адаем размер столбцов
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
		
		
		// —оздаем панель прокрутки и включаем в ее состав нашу таблицу
		jscrlp = new JScrollPane(dataTable,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelEmplTable.removeAll();

		//ƒобавл€ем на панель jscrlp вместе с таблицей
		panelEmplTable.add(jscrlp);
		if (tableModel instanceof EmplFixSalTableModel) {
			panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees With Fix Salary Data"));
		}
		else panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Employees With Hourly Wages Data"));
			
		//ƒобавл€ем панель с таблицей
		panelEmployees.add(panelEmplTable,BorderLayout.CENTER);
		panelEmplTable.updateUI();
		
	}//createTable ()
//***********************************************************
	public static void main(String[] args) throws Exception {
		new GUI_PersonnelRecords(); 
	}//main
}//class
