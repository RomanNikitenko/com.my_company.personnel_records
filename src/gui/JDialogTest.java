package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JDialogTest extends JFrame{
   static String[] options = {"Yes","��","������"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JDialogTest frame = new JDialogTest();
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		frame.setLocation(100,100);
		frame.setSize(350, 30);

		frame.setVisible(true);
		
			
				//���� � ����������
		String selStr = (String)JOptionPane.showInputDialog(
				null,
				"���������� \n ��������� \n ������ ����",
				"��� ���������",
				JOptionPane.ERROR_MESSAGE,
				//JOptionPane.YES_NO_CANCEL_OPTION,
				new ImageIcon("c:\\111\\222\\333\\111.jpg"),
				null,  //options,     //null - ��� ����������
				null	//options[1] //null - ��� ����������
				);
		System.out.println("������ ����� � ����������: "+ selStr);
		
	
		
		
//				//�� ��������� ����
//		final  //��� ������������� jd ������ ���������� �������� 
//		JDialog jd = new JDialog(frame,"��� ������"); //��� �������� ����-��������� ������ ��������� ���������
//		jd.setSize(300, 200);
//		jd.setLocationRelativeTo(frame);
//		
		
//		final //��� ������������� ������ ���������� ������
//		JOptionPane op = new JOptionPane("�� ��������� ����",
//				JOptionPane.ERROR_MESSAGE,
//				JOptionPane.YES_NO_CANCEL_OPTION,
//				new ImageIcon("c:\\111\\222\\333\\111.jpg"),
//				options,
//				options[1]
//				);
//		
//		jd.setContentPane(op);
//		jd.setVisible(true);
//		
//			//������������ �������� ���� ����� �������
//		jd.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		jd.addWindowListener(new WindowAdapter() {
//		
//			public void windowClosing(WindowEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("��� ���� �� ��������.");
//			}
//		
//		});
		
			//�������� ������� ������ ������ optionPane-�
//		op.setValue("OldValue ��������� ��� ��������");
//		op.addPropertyChangeListener(new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent e) {
//				
//System.out.println("������� op JOptionPane ChangeListaner,OldValue:  "+
//                   e.getOldValue());
//System.out.println("������� op JOptionPane ChangeListaner,NewValue:  "+
//        e.getNewValue());
//System.out.println("������� op JOptionPane ChangeListaner,getPropertyName:  "+
//        e.getPropertyName());

			// if ()  //������ 1-� ������ � ��������� ������ ������ op
			//else //������ ������ ����� ������ op
				
//				if (jd.isVisible()){
//					//��� �������
//					//� ����� ������� ���� �������
//					
//					//jd.setVisible(false); //�������������, ��� ���� �� �����������
//				}
//				
//			}
//		});
		
		
	}//main	
}//pub class
