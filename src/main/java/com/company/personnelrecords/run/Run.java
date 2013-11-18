package com.company.personnelrecords.run;

import java.util.ArrayList;

import javax.swing.UIManager;

import com.company.personnelrecords.gui.MainFrame;
import com.company.personnelrecords.gui.MenuBar;

public class Run {
	
	public static ArrayList<ArrayList<String>> arrCompanyData;

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new MenuBar();
		new MainFrame();
	}
}
