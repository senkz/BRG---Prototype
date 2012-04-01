package gui.controller;

import gui.view.LoginFrame;

public class Main 
{

	public static void main(String[] args)
	{
		System.out.println("Application has started");
		Repository.initialize();
		LoginFrame lg = new LoginFrame();
		lg.setVisible(true);
	}

}
