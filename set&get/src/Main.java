public class Main 
{
	private static String variable = "language";
	private static String type = "Language";
	
	private static String fixedVariable;
	public static void main(String[] args) 
	{
		fixedVariable = variable.substring(0,1).toUpperCase()+variable.substring(1,variable.length());
		System.out.println("public "+type+" get"+fixedVariable+"()");
		System.out.println("{\n\treturn "+variable+";\n}");
		
		System.out.println("");
		
		System.out.println("public void" +" set"+fixedVariable+"("+type+" _"+variable+")");
		System.out.println("{\n	"+variable+" = _"+variable+" ;\n}");
	}
}