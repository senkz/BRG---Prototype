package gui.view.brf;

import generator.Generator;
import generator.lang.plsql.OracleGenerator;

import java.util.ArrayList;

import model.BusinessRule;

public class LanguageList {
	private static ArrayList<Generator> gen_list;
	
	private static void loadLanguages() {
		gen_list = new ArrayList<Generator>();
		
		gen_list.add(new OracleGenerator());
		gen_list.add(new Generator() {

			@Override
			public String generateBR(BusinessRule br) {
				return "The dummy language does not work.";
			}

			@Override
			public String getName() {
				return "Dummy Language";
			}
		});
	}

	public static ArrayList<String> getAllLanguages() {
		if(gen_list == null) loadLanguages();
		
		ArrayList<String> s_list = new ArrayList<String>();
		
		for(Generator g : gen_list) {
			s_list.add(g.getName());
		}
		return s_list;
	}
	
	public static Generator getGenerator(String name){
		if(gen_list == null) loadLanguages();
		for(Generator gen : gen_list) {
			if(gen.getName().equals(name))
				return gen;
		}
		return null;
	}
}