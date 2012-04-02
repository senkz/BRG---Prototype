package test;

import gui.view.BusinessRuleFrame;

import java.io.File;
import javax.management.modelmbean.ModelMBean;

import model.BusinessRule;
import model.Trigger;
import output.Write;
import connections.ModelController;
import connections.SourceDatabaseJDBC_Oracle;

public class Main
{

	public static void main(String[] args) 
	{
		BusinessRuleFrame brf = new BusinessRuleFrame();
		ModelController mc = ModelController.getInstance();
		mc.loadObjects();
		brf.init();	
	}
}
