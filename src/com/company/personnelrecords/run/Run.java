package com.company.personnelrecords.run;

import javax.swing.UIManager;

import com.company.personnelrecoreds.gui.MainFrame;
import com.company.personnelrecoreds.gui.MenuBar;


public class Run {

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new MenuBar();
		new MainFrame();
	}
}
