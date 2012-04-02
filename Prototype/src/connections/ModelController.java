package connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import logger.GLogger;
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
import model.APP_Error;
import model.junc_tb_tg;


public class ModelController {
	private static ModelController instance = null;
	
	private ArrayList<Application> app_list = new ArrayList<Application>();
	private ArrayList<BusinessRule> br_list = new ArrayList<BusinessRule>();
	private ArrayList<BusinessRuleType> brt_list = new ArrayList<BusinessRuleType>();
	private ArrayList<Category> cat_list = new ArrayList<Category>();
	private ArrayList<CustomCode> cc_list = new ArrayList<CustomCode>();
	private ArrayList<DataBase> db_list = new ArrayList<DataBase>();
	private ArrayList<APP_Error> err_list = new ArrayList<APP_Error>();
	private ArrayList<junc_tb_tg> junc_tb_tg_list = new ArrayList<junc_tb_tg>();
	private ArrayList<Operator> ope_list = new ArrayList<Operator>();
	private ArrayList<Table> tb_list = new ArrayList<Table>();
	private ArrayList<TableColumn> tbc_list = new ArrayList<TableColumn>();
	private ArrayList<Trigger> tg_list = new ArrayList<Trigger>();
	private ArrayList<Value> val_list = new ArrayList<Value>();
	
	private ModelController() {}
	
	private synchronized static void createInstance() {
		if(instance == null) instance = new ModelController();
	}
	
	public static ModelController getInstance() {
		if(instance == null)
			createInstance();
		
		return instance;
	}
	
	public void loadObjects() {
		DBC dbc = DBC.getInstance();
		Connection conn = dbc.connect();
		
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

	public ArrayList<Application> getApp_list() {
		return app_list;
	}

	public ArrayList<BusinessRule> getBr_list() {
		return br_list;
	}

	public ArrayList<BusinessRuleType> getBrt_list() {
		return brt_list;
	}

	public ArrayList<Category> getCat_list() {
		return cat_list;
	}

	public ArrayList<CustomCode> getCc_list() {
		return cc_list;
	}

	public ArrayList<DataBase> getDb_list() {
		return db_list;
	}

	public ArrayList<APP_Error> getErr_list() {
		return err_list;
	}

	public ArrayList<junc_tb_tg> getJunc_tb_tg_list() {
		return junc_tb_tg_list;
	}

	public ArrayList<Operator> getOpe_list() {
		return ope_list;
	}

	public ArrayList<Table> getTb_list() {
		return tb_list;
	}

	public ArrayList<TableColumn> getTbc_list() {
		return tbc_list;
	}

	public ArrayList<Trigger> getTg_list() {
		return tg_list;
	}

	public ArrayList<Value> getVal_list() {
		return val_list;
	}
	
	public BusinessRule findBusinessRule(String br_name) {
		BusinessRule br = null;
		for(BusinessRule b : br_list) {
			if(b.getName().equals(br_name)) {
				br = b;
				break;
			}
		}
		return br;
	}

	public BusinessRuleType findBusinessRuleType(int brt_id) {
		BusinessRuleType brt = null;
		for(BusinessRuleType b : brt_list) {
			if(b.getBrt_id() == brt_id) {
				brt = b;
				break;
			}
		}
		return brt;
	}


	public Category findCategory(int cat_id) {
		Category cat = null;
		for(Category c : cat_list) {
			if(c.getCat_id() == cat_id) {
				cat = c;
				break;
			}
		}
		return cat;
	}


	/*
	 * Finding an operator by looking for a businessrule id
	 */
	public Operator findOperator(int br_id) {
		Operator ope = null;
		for(Operator o : ope_list) {
			if(o.getBr_fk() == br_id) {
				ope = o;
				break;
			}
		}
		return ope;
	}


	/*
	 * Finding an list of values by looking for the collection value id.
	 */
	public ArrayList<Value> findValues(int cv_fk) {
		ArrayList<Value> v_list = new ArrayList<Value>();
		for(Value v : val_list) {
			if(v.getCv_fk() == cv_fk) {
				v_list.add(v);
			}
		}
		return v_list;
	}
	
	/*
	 * Find the correct custom code.
	 */
	public CustomCode findCustomCode(int op_id) {
		CustomCode cc = null;
		for(CustomCode c : cc_list) {
			if(c.getOp_fk() == op_id) {
				cc = c;
			}
		}
		return cc;
	}

	public TableColumn findTableColumn(int tc_id) {
		TableColumn tc = null;
		for(TableColumn t : tbc_list) {
			if(t.getTbc_id() == tc_id) {
				tc = t;
				break;
			}
		}
		return tc;
	}

	public Trigger findTrigger(int tg_id) {
		Trigger tg = null;
		for(Trigger t : tg_list) {
			if(t.getTg_id() == tg_id) {
				tg = t;
				break;
			}
		}
		return tg;
	}
	
	/**
	 * Find all tables that the trigger should apply too.
	 */
	public ArrayList<Table> findTriggerTable(int tg_id) {
		ArrayList<Table> t_list = new ArrayList<Table>();
		for(junc_tb_tg tt : junc_tb_tg_list) {
			if(tt.getTg_fk() == tg_id) {
				t_list.add(findTable(tt.getTb_fk()));
			}
		}
		return t_list;
	}
	
	public Table findTable(int tb_id) {
		Table tb = null;
		for(Table t : tb_list) {
			if(t.getTb_id() == tb_id) {
				tb = t;
				break;
			}
		}
		return tb;
	}
	
	public APP_Error findAppError(int err_id) {
		APP_Error error = null;
		for(APP_Error e : err_list) {
			if(e.getErr_id() == err_id) {
				error = e;
				break;
			}
		}
		return error;
	}
}