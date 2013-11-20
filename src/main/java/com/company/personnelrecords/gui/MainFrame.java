package com.company.personnelrecords.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import com.company.personnelrecords.company.EmployeeCreator;
import com.company.personnelrecords.company.EmployeeFixedSalary;
import com.company.personnelrecords.company.EmployeeHourlyWages;
import com.company.personnelrecords.exception.StringDigitIncludeException;

public class MainFrame extends JFrame implements ActionListener {
	
//*****************************
	
	private  JTable dataTable;
	private static Dimension screenSize;
	private static JScrollPane jscrlp;
	private static JPanel mainPanel;
	private static JPanel panelEmployees;
	private static JPanel panelButEdit;
	private static JButton butAddEmplFixSal;
	private static JButton butAddEmplHourlyWages;
	private static JButton butClean;
	private static JButton butDelete;
	private static JPanel panelEmplTable;
	
//*******Конструктор******************************
	public MainFrame () throws Exception {
		
		MenuBar.setMainFrame(this);

		//получаем размер экрана
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
//*******//главная панель//*******
        mainPanel = new JPanel(); //создаем главную панель, задаем менеджер размещения
		mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height-25));//устанавливаем размер
		mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());//устанавливаем бордюр
		
//*******//настройки окна//*******
		add(mainPanel);//добавляем главную панель к фрейму
		this.setJMenuBar(MenuBar.getPersRecMenuBar()); //устанавливаем меню
		setTitle("PersonnelRecord"); //устанавливаем заголовок окна
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);//завершение работы приложения по закрытию главного окна
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
		
//*******//кнопоки EDIT
		
		butAddEmplFixSal = new JButton("<html><center> Add Employee <br> Fix Salary");
		butAddEmplFixSal.addActionListener(this);
		
		butAddEmplHourlyWages = new JButton("<html><center> Add Employee <br>Hourly Wages");
		butAddEmplHourlyWages.addActionListener(this);

		butClean = new JButton("<html><center>Clean<br>All");
		butClean.addActionListener(this);

		butDelete = new JButton("<html><center> Delete <br> Employee");
		butDelete.addActionListener(this);
		

//*******//панель для таблицы 
		panelEmplTable = new JPanel(new BorderLayout());
		panelEmplTable.setPreferredSize(new Dimension (mainPanel.getWidth()-panelButEdit.getWidth()-10, mainPanel.getHeight()-10));

		mainPanel.add(panelEmployees, BorderLayout.CENTER);
			
	}//конструктор
//***********************************************************
	public JTable displayTable (final AbstractTableModel tableModel) {
		
		//*******//создаем таблицу на основе нашей модели,
		//переданной в параметре
		dataTable = new JTable(tableModel);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dataTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		dataTable.setCellSelectionEnabled(true);
		
		TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<AbstractTableModel>(tableModel) {
			
			@Override
			public Comparator<?> getComparator(int column) {
			      
			      if (tableModel instanceof AllEmployeeTableModel && column == 0 || column == 4 ||
			    		  column == 5 || column == 6 || column == 7 ) {
			        return new Comparator<String>() {
			          @Override
			          public int compare(String s1,String s2) {
			            return Integer.parseInt(s1) - Integer.parseInt(s2);
			          }
			        };
			     }
			      else if (column == 0 || column == 4 || column == 5 || column == 6 ) {
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
		
		// Задаем размер столбцов
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(55);
		dataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		dataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		dataTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(5).setPreferredWidth(80);
		dataTable.getColumnModel().getColumn(6).setPreferredWidth(80);
		
		if (tableModel instanceof AllEmployeeTableModel) {
			dataTable.getColumnModel().getColumn(7).setPreferredWidth(80);
			dataTable.getColumnModel().getColumn(8).setPreferredWidth(100);
			dataTable.getColumnModel().getColumn(9).setPreferredWidth(220);
			dataTable.getColumnModel().getColumn(10).setPreferredWidth(300);
		}
		else {
			dataTable.getColumnModel().getColumn(7).setPreferredWidth(100);
			dataTable.getColumnModel().getColumn(8).setPreferredWidth(220);
			dataTable.getColumnModel().getColumn(9).setPreferredWidth(300);
		}//else
		// Создаем панель прокрутки и включаем в ее состав нашу таблицу
		jscrlp = new JScrollPane(dataTable,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelEmplTable.removeAll();

		//Добавляем на панель jscrlp вместе с таблицей
		panelEmplTable.add(jscrlp);
		panelButEdit.removeAll();
				
		if (tableModel instanceof EmplFixSalTableModel) {
			panelEmplTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
					"Employees With Fix Salary Data"));
			panelButEdit.add(butAddEmplFixSal, 0);
		}//if
		else if (tableModel instanceof EmplHourlyWagesTableModel) {panelEmplTable.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
				"Employees With Hourly Wages Data"));
		panelButEdit.add(butAddEmplHourlyWages, 0);
		}//else if
		else { panelEmplTable.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
							"All Employees Data"));
				panelButEdit.add(butAddEmplFixSal, 0);
				panelButEdit.add(butAddEmplHourlyWages, 1);
		}//else
		
		//Добавляем панели
		panelButEdit.add(butDelete);
		panelButEdit.add(butClean);
		panelEmployees.add(panelButEdit, BorderLayout.WEST);
		panelEmployees.add(panelEmplTable,BorderLayout.CENTER);
		panelEmplTable.updateUI();
		return dataTable;
	}//displayTable ()
//***********************************************************
	public void addEmplFixSalToTable (AbstractTableModel tableModel) {
		try {
			if (tableModel instanceof EmplFixSalTableModel) {
				((EmplFixSalTableModel) tableModel).getArrListObjEmplFixSal()
						.add(0, new EmployeeCreator().createNewEmplFixSal());
			}// if
			else if (tableModel instanceof AllEmployeeTableModel) {
				((AllEmployeeTableModel) tableModel).getArrListObjAllEmployee()
						.add(0, new EmployeeCreator().createNewEmplFixSal());
			}// else if
		} catch (StringDigitIncludeException e) {

			JOptionPane.showMessageDialog(null,	"Incorrect value!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		tableModel.fireTableRowsInserted(0, 0);
		dataTable.revalidate();
		panelEmplTable.updateUI();
	}//addEmplFixSalToTable (AbstractTableModel tableModel)
//**************************************************************
	public void addEmplHourlyWagesToTable (AbstractTableModel tableModel) {
		try {
			if (tableModel instanceof EmplHourlyWagesTableModel) {
				((EmplHourlyWagesTableModel) tableModel)
						.getArrListObjEmplHourlyWages().add(
								0,
								new EmployeeCreator()
										.createNewEmplHourlyWages());
			}// if
			else if (tableModel instanceof AllEmployeeTableModel) {
				((AllEmployeeTableModel) tableModel).getArrListObjAllEmployee()
						.add(0,
								new EmployeeCreator()
										.createNewEmplHourlyWages());
			}// else if

		} catch (StringDigitIncludeException e) {

			JOptionPane.showMessageDialog(null,	"Incorrect value!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		tableModel.fireTableRowsInserted(0, 0);
		dataTable.revalidate();
		panelEmplTable.updateUI();
	}//addEmplHourlyWagesToTable (AbstractTableModel tableModel)
//**************************************************************
	public void deleteEmployee () {
		try {
			
			if (dataTable.getModel() instanceof EmplFixSalTableModel) {
				((EmplFixSalTableModel )dataTable.getModel()).getArrListObjEmplFixSal().
									remove(dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				((EmplFixSalTableModel )dataTable.getModel()).fireTableRowsDeleted(
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				dataTable.revalidate();
				panelEmplTable.updateUI();
			}//if
			else if (dataTable.getModel() instanceof EmplHourlyWagesTableModel) {
				((EmplHourlyWagesTableModel)dataTable.getModel()).getArrListObjEmplHourlyWages().
									remove(dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				((EmplHourlyWagesTableModel)dataTable.getModel()).fireTableRowsDeleted(
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				dataTable.revalidate();
				panelEmplTable.updateUI();
			}//else if
			else if (dataTable.getModel() instanceof AllEmployeeTableModel) {
				((AllEmployeeTableModel)dataTable.getModel()).getArrListObjAllEmployee().
									remove(dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				((AllEmployeeTableModel)dataTable.getModel()).fireTableRowsDeleted(
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()),
						dataTable.convertRowIndexToModel(dataTable.getSelectedRow()));
				dataTable.revalidate();
				panelEmplTable.updateUI();
			}//else if
		} catch (IndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "Removing the last line does not work properly. Press 'Clean All', please!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}//deleteEmployee
//**************************************************************
	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (event.getActionCommand()) {
		
		case "<html><center>Clean<br>All":
			
			panelEmplTable.removeAll();
			dataTable.removeAll();
			panelEmplTable.updateUI();
			break;
		
		case "<html><center> Add Employee <br> Fix Salary":
			addEmplFixSalToTable((AbstractTableModel) dataTable.getModel());
			break;

		case "<html><center> Add Employee <br>Hourly Wages":
			addEmplHourlyWagesToTable((AbstractTableModel) dataTable.getModel());
			break;

		case "<html><center> Delete <br> Employee":
			if (dataTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null,
						"Select the row you want to delete!", "Attention!",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}//
			deleteEmployee();
			break;
		}//switch
	}//actionPerformed
}//class
