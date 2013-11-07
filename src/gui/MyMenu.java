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


public class MyMenu extends JFrame{
	
	public static JMenuBar menuBar;
	
	public MyMenu(){
		
		//������� ������ ���� - JMenuBar
	   menuBar = new JMenuBar();
	   
//*******Employee With Fix Salary*******//
	   
	   //������� ������� Employee With Fix Salary
	   JMenu menuEmployeeFixSal = new JMenu("<html><center>Employee With <br> Fix Salary");
	   menuEmployeeFixSal.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeFixSal.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "New"
	   JMenuItem submenuEmplFixSal = new JMenuItem("New");
	   submenuEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	   menuEmployeeFixSal.add(submenuEmplFixSal);
	   submenuEmplFixSal.addActionListener(new EmployeeFixSalListener());
	   
	   //�����. ����� ���� - "Open List Employee"   
	   submenuEmplFixSal = new JMenuItem("Open List Employee");
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
			   System.out.println("������. �������: ���� �����.");
			   System.exit(0);
		   }
	   });
	   //������� ����� � ��������� ����
	   menuBar.add(menuEmployeeFixSal);
	   
//*******Employee with hourly wages*******//
	 
	   //������� ������� Employee With hourly wages
	   JMenu menuEmployeeHourlyWages = new JMenu("<html><center>Employee With <br> Hourly Wages");
	   menuEmployeeHourlyWages.setPreferredSize(new Dimension(100, 40));
	   menuEmployeeHourlyWages.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "New"
	   JMenuItem submenuEmplHourlyWages = new JMenuItem("New");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //�����. ����� ���� - "Open List Employee"   
	   submenuEmplHourlyWages = new JMenuItem("Open List Employee");
	   submenuEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
	   menuEmployeeHourlyWages.add(submenuEmplHourlyWages);
	   submenuEmplHourlyWages.addActionListener(new EmployeeHourlyWagesListener());
	   
	   //�����. ����������� ����
	   menuEmployeeHourlyWages.add(new JSeparator());
	   
	   //������� ����� � ��������� ����
	   menuBar.add(menuEmployeeHourlyWages);

//*******Test Mode*******//
		 
	   //������� ������� Test Mode
	   JMenu menuTestMode = new JMenu("Test Mode");
	   menuTestMode.setPreferredSize(new Dimension(80, 40));
	   menuTestMode.setBorder(new BevelBorder(BevelBorder.RAISED));
	   
	   //�����. ����� "Generate Employees"
	   JMenu submenuGenerateEmpl = new JMenu("Generate Employees");
	   
	   
	 //�����. �����-���� "Generation Employee with fix salary"
	   JRadioButtonMenuItem radioMenuGenerEmplFixSal = 
			   new JRadioButtonMenuItem("Generation Employee with fix salary");
	   submenuGenerateEmpl.add(radioMenuGenerEmplFixSal);
	   radioMenuGenerEmplFixSal.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplFixSal.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	   
	 //�����. �����-���� "Generation Employee with hourly wages"
	   JRadioButtonMenuItem radioMenuGenerEmplHourlyWages = 
			   new JRadioButtonMenuItem("Generation Employee with hourly wages");
	   submenuGenerateEmpl.add(radioMenuGenerEmplHourlyWages);
	   radioMenuGenerEmplHourlyWages.addActionListener(new TestModeListener ());
	   radioMenuGenerEmplHourlyWages.setAccelerator
	   (KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
	   
	   //����� ����� ������ � �����������
	   ButtonGroup rbGroup = new ButtonGroup();
	   rbGroup.add(radioMenuGenerEmplFixSal);
	   rbGroup.add(radioMenuGenerEmplHourlyWages);
	   
	   menuTestMode.add(submenuGenerateEmpl);
	   
	   //������� ����� � ��������� ����
	   menuBar.add(menuTestMode);
	   
	}//�����������
	
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
		System.out.println("EmployeeFixSalListener ����� �����:" + event.getActionCommand());
	}//actionPerformed
}//class EmployeeFixSalListener

class EmployeeHourlyWagesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("EmployeeHourlyWagesListener ����� �����:" + event.getActionCommand());
	}//actionPerformed

}//class EmployeeHourlyWagesListener

class TestModeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("EmployeeHourlyWagesListener �����:" + event.getActionCommand());
	}//actionPerformed
}//class TestModeListener
