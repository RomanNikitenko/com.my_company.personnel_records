package run;

import javax.swing.UIManager;
import gui.GUI_Frame;
import gui.MyMenu;

public class Run {

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new MyMenu();
		new GUI_Frame();
	}
}
