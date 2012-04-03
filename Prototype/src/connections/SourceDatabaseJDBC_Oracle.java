 package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import logger.GLogger;
import model.APP_Error;
import model.Application;
import model.BusinessRule;
import model.BusinessRuleType;
import model.Category;
import model.CustomCode;
import model.DataBase;
import model.Operator;
import model.Table;
import model.TableColumn;
import model.Trigger;
import model.Value;
import model.junc_tb_tg;
import controls.Register;

public class SourceDatabaseJDBC_Oracle implements SourceDAO
{
	 String userid="THO7_2011_2B_TEAM3A", password = "THO7_2011_2B_TEAM3A";
	 String url = "jdbc:oracle:thin:@ondora01.hu.nl:8521:cursus01";
	 Statement stmt;
	 Connection con;
	
	 @Override 
	public  String testConnection(String _username, String _password, String _URL)
	{
		 String s = "";
		 try 
			{
				Class.forName("oracle.jdbc.OracleDriver");
			} 
			catch(java.lang.ClassNotFoundException e) 
			{
				s += e.getMessage();
			}

			try 
			{
				con = DriverManager.getConnection(_URL, _username, _password);
			} 
			catch(SQLException ex)
			{
				s += "\nConnection to database failed";
			}
			
			if(s.equals(""))
			{
				return s = "Connection to database established";
			}
			else
			{
				return s;
			}
	}
	
	public Connection getConnection(String _username, String _password, String _URL)
	{		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
		} 
		catch(java.lang.ClassNotFoundException e) 
		{
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try 
		{
			con = DriverManager.getConnection(url, userid, password);
		} 
		catch(SQLException ex)
		{
			System.err.println("SQLException:  " + ex.getMessage());
		}
		return con;
	}
	
	public void loadObjects() {
		Register reg = Register.getInstance();
		
		ArrayList<Application> app_list = new ArrayList<Application>();
		ArrayList<BusinessRule> br_list = new ArrayList<BusinessRule>();
		ArrayList<BusinessRuleType> brt_list = new ArrayList<BusinessRuleType>();
		ArrayList<Category> cat_list = new ArrayList<Category>();
		ArrayList<CustomCode> cc_list = new ArrayList<CustomCode>();
		ArrayList<DataBase> db_list = new ArrayList<DataBase>();
		ArrayList<APP_Error> err_list = new ArrayList<APP_Error>();
		ArrayList<junc_tb_tg> junc_tb_tg_list = new ArrayList<junc_tb_tg>();
		ArrayList<Operator> ope_list = new ArrayList<Operator>();
		ArrayList<Table> tb_list = new ArrayList<Table>();
		ArrayList<TableColumn> tbc_list = new ArrayList<TableColumn>();
		ArrayList<Trigger> tg_list = new ArrayList<Trigger>();
		ArrayList<Value> val_list = new ArrayList<Value>();
		
		Connection conn = getConnection(userid,password,url);
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = null;
			String sql = "SELECT * FROM %s";
			GLogger.log(Level.INFO, "Started loading data.");
			
			// LOAD APPLICATIONS
			GLogger.log(Level.INFO, "Started loading applications.");
			stm.execute(String.format(sql, "APP_APPLICATION"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Application a = new Application();
				a.setApp_comment(rs.getString("APP_COMMENT"));
				a.setApp_id(rs.getInt("APP_ID"));
				a.setCreationDate(rs.getDate("CREATIONDATE"));
				a.setLastEdited(rs.getDate("LASTEDITED"));
				a.setName(rs.getString("NAME"));
				
				app_list.add(a);
			}
			reg.setApp_list(app_list);
			GLogger.log(Level.INFO, "Done loading " + app_list.size() + " application(s)");

			// LOAD BusinessRule
			GLogger.log(Level.INFO, "Started loading businessrules.");
			stm.execute(String.format(sql, "APP_BUSINESSRULE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				BusinessRule br = new BusinessRule();
				
				br.setApp_fk(rs.getInt("APP_FK"));
				br.setBr_id(rs.getInt("BR_ID"));
				br.setBrt_fk(rs.getInt("BRT_FK"));
				br.setErr_fk(rs.getInt("ERR_FK"));
				br.setName(rs.getString("NAME"));
				br.setTg_fk(rs.getInt("TG_FK"));
				
				br_list.add(br);
			}
			reg.setBr_list(br_list);
			GLogger.log(Level.INFO, "Done loading " + br_list.size() + " businessrule(s)");
			
			// LOAD BusinessRuleType
			GLogger.log(Level.INFO, "Started loading businessrulestypes.");
			stm.execute(String.format(sql, "APP_BUSINESSRULETYPE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				BusinessRuleType brt = new BusinessRuleType();

				brt.setBrt_comment(rs.getString("BRT_COMMENT"));
				brt.setBrt_id(rs.getInt("BRT_ID"));
				brt.setCat_fk(rs.getInt("CAT_FK"));
				brt.setCode(rs.getString("CODE"));
				brt.setErr_fk(rs.getInt("ERR_FK"));
				brt.setName(rs.getString("NAME"));
				
				brt_list.add(brt);
			}
			reg.setBrt_list(brt_list);
			GLogger.log(Level.INFO, "Done loading " + brt_list.size() + " businessruletype(s)");

			// LOAD Category
			GLogger.log(Level.INFO, "Started loading categories.");
			stm.execute(String.format(sql, "APP_CATEGORY"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Category c = new Category();

				c.setCat_id(rs.getInt("CAT_ID"));
				c.setName(rs.getString("NAME"));
				
				cat_list.add(c);
			}
			reg.setCat_list(cat_list);
			GLogger.log(Level.INFO, "Done loading " + cat_list.size() + " category");

			// LOAD CustomCode
			GLogger.log(Level.INFO, "Started loading custom code data.");
			stm.execute(String.format(sql, "APP_CUSTOMCODE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				CustomCode cc = new CustomCode();

				cc.setCc_id(rs.getInt("CC_ID"));
				cc.setCustomcode(rs.getString("CUSTOMCODE"));
				cc.setOp_fk(rs.getInt("OP_FK"));
				
				cc_list.add(cc);
			}
			reg.setCc_list(cc_list);
			GLogger.log(Level.INFO, "Done loading " + cc_list.size() + " custom code data.");

			// LOAD DataBase
			GLogger.log(Level.INFO, "Started loading database info.");
			stm.execute(String.format(sql, "APP_DATABASE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				DataBase db = new DataBase();

				db.setApp_fk(rs.getInt("APP_FK"));
				db.setDb_id(rs.getInt("DB_ID"));
				db.setDbType(rs.getString("DBTYPE"));
				db.setHostname(rs.getString("HOSTNAME"));
				db.setName(rs.getString("NAME"));
				db.setPassword(rs.getString("PASSWORD"));
				db.setPort(rs.getInt("PORT"));
				
				db_list.add(db);
			}
			reg.setDb_list(db_list);
			GLogger.log(Level.INFO, "Done loading " + db_list.size() + " database");

			// LOAD Error
			GLogger.log(Level.INFO, "Started loading error info.");
			stm.execute(String.format(sql, "APP_ERROR"));
			rs = stm.getResultSet();
			while (rs.next()) {
				APP_Error err = new APP_Error();
				
				err.setCode(rs.getInt("CODE"));
				err.setErr_comment(rs.getString("ERR_COMMENT"));
				err.setErr_id(rs.getInt("ERR_ID"));
				err.setName(rs.getString("NAME"));
				
				err_list.add(err);
			}
			reg.setErr_list(err_list);
			GLogger.log(Level.INFO, "Done loading " + err_list.size() + " error messages");

			// LOAD Operator
			GLogger.log(Level.INFO, "Started loading operators.");
			stm.execute(String.format(sql, "APP_OPERATOR"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Operator ope = new Operator();
				
				ope.setBr_fk(rs.getInt("BR_FK"));
				ope.setCv_fk(rs.getInt("CV_FK"));
				ope.setOp_id(rs.getInt("OP_ID"));
				ope.setOperator(rs.getString("OPERATOR"));
				ope.setSamerow(rs.getString("SAMEROW"));
				ope.setTc1_fk(rs.getInt("TC1_FK"));
				ope.setTc2_fk(rs.getInt("TC2_FK"));
				
				ope_list.add(ope);
			}
			reg.setOpe_list(ope_list);
			GLogger.log(Level.INFO, "Done loading " + ope_list.size() + " operator(s)");
				

			// LOAD Table
			GLogger.log(Level.INFO, "Started loading tables.");
			stm.execute(String.format(sql, "APP_TABLE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Table tb = new Table();
				
				tb.setDb_fk(rs.getInt("DB_FK"));
				tb.setName(rs.getString("NAME"));
				tb.setTb_id(rs.getInt("TB_ID"));
				
				tb_list.add(tb);
			}
			reg.setTb_list(tb_list);
			GLogger.log(Level.INFO, "Done loading " + tb_list.size() + " table(s)");

			// LOAD TableColumn
			GLogger.log(Level.INFO, "Started loading tablecolumns.");
			stm.execute(String.format(sql, "APP_TABLECOLUMN"));
			rs = stm.getResultSet();
			while (rs.next()) {
				TableColumn tbc = new TableColumn();
				
				tbc.setName(rs.getString("NAME"));
				tbc.setTb_fk(rs.getInt("TB_FK"));
				tbc.setTbc_id(rs.getInt("TBC_ID"));
				tbc.setType(rs.getString("TYPE"));
				
				tbc_list.add(tbc);
			}
			reg.setTbc_list(tbc_list);
			GLogger.log(Level.INFO, "Done loading " + tbc_list.size() + " tablecolumn(s)");

			// LOAD Trigger
			GLogger.log(Level.INFO, "Started loading trigger.");
			stm.execute(String.format(sql, "APP_TRIGGER"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Trigger tg = new Trigger();
				
				tg.setEvent(rs.getString("EVENT"));
				tg.setTg_id(rs.getInt("TG_ID"));
				
				tg_list.add(tg);
			}
			reg.setTg_list(tg_list);
			GLogger.log(Level.INFO, "Done loading " + tg_list.size() + " trigger(s)");

			// LOAD Value
			GLogger.log(Level.INFO, "Started loading trigger.");
			stm.execute(String.format(sql, "APP_VALUE"));
			rs = stm.getResultSet();
			while (rs.next()) {
				Value val = new Value();
				
				val.setCv_fk(rs.getInt("CV_FK"));
				val.setValue(rs.getString("VALUE"));
				val.setVl_id(rs.getInt("VL_ID"));
				
				val_list.add(val);
			}
			reg.setVal_list(val_list);
			GLogger.log(Level.INFO, "Done loading " + val_list.size() + " trigger(s)");

			// LOAD junc_tb_tg
			GLogger.log(Level.INFO, "Started loading trigger.");
			stm.execute(String.format(sql, "APP_JUNC_TB_TG"));
			rs = stm.getResultSet();
			while (rs.next()) {
				junc_tb_tg jtt = new junc_tb_tg();

				jtt.setTb_fk(rs.getInt("TB_FK"));
				jtt.setTg_fk(rs.getInt("TG_FK"));
				
				junc_tb_tg_list.add(jtt);
			}
			reg.setJunc_tb_tg_list(junc_tb_tg_list);
			GLogger.log(Level.INFO, "Done loading " + junc_tb_tg_list.size() + " trigger(s)");
		} catch (SQLException e) {
			GLogger.log(Level.SEVERE, "ERROR LOADING DATA:");
			GLogger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		GLogger.log(Level.INFO, "Finished loading data.");
		try {
			conn.close();
		} catch (SQLException e) {
			GLogger.log(Level.SEVERE, "Error closing database connection.");
		}
		GLogger.log(Level.INFO, "Closed database connection.");
	}
}