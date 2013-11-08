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
   static String[] options = {"Yes","Да","ОТмена"};
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
		
			
				//окно с тектФилдом
		String selStr = (String)JOptionPane.showInputDialog(
				null,
				"Простейшее \n модальное \n Меседж окно",
				"Мой заголовок",
				JOptionPane.ERROR_MESSAGE,
				//JOptionPane.YES_NO_CANCEL_OPTION,
				new ImageIcon("c:\\111\\222\\333\\111.jpg"),
				null,  //options,     //null - для текстфилда
				null	//options[1] //null - для текстфилда
				);
		System.out.println("Набран текст в ТекстФилде: "+ selStr);
		
	
		
		
//				//не модальное окно
//		final  //для использования jd внутри анонимного лисенера 
//		JDialog jd = new JDialog(frame,"Мой Диалог"); //при закрытии окна-владельца диалог закроется автоматом
//		jd.setSize(300, 200);
//		jd.setLocationRelativeTo(frame);
//		
		
//		final //для использования внутри аноноимных классо
//		JOptionPane op = new JOptionPane("Не модальное окно",
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
//			//вылавливание закрытия окна через крестик
//		jd.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		jd.addWindowListener(new WindowAdapter() {
//		
//			public void windowClosing(WindowEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("Был клик по крестику.");
//			}
//		
//		});
		
			//слушание нажатия кнопок внутри optionPane-а
//		op.setValue("OldValue начальное МОЕ значение");
//		op.addPropertyChangeListener(new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent e) {
//				
//System.out.println("Лисенер op JOptionPane ChangeListaner,OldValue:  "+
//                   e.getOldValue());
//System.out.println("Лисенер op JOptionPane ChangeListaner,NewValue:  "+
//        e.getNewValue());
//System.out.println("Лисенер op JOptionPane ChangeListaner,getPropertyName:  "+
//        e.getPropertyName());

			// if ()  //нажата 1-я кнопка с названием кнопок внутри op
			//else //нажата другая копка внутри op
				
//				if (jd.isVisible()){
//					//что сделать
//					//и потом закрыть окно ДИАЛОГА
//					
//					//jd.setVisible(false); //закоментарено, что окно не закрывалось
//				}
//				
//			}
//		});
		
		
	}//main	
}//pub class
