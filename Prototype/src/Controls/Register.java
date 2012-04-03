package controls;

import java.util.ArrayList;

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
import connections.*;

public class Register 
{
	static SourceDAO sourceConn;
	static TargetDAO targetConn;
	
	private static Register instance;

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
	
	private Register() {}
	
	public static Register getInstance() {
		if(instance == null)
			instance = new Register();
		return instance;
	}

	public static void initializeTarget() 
	{
		targetConn = (TargetDAO) new TargetDatabaseJDBC_Oracle();		
	}
	
	public static void initializeSource() 
	{
		sourceConn = (SourceDAO) new SourceDatabaseJDBC_Oracle();		
	}
	
	public static SourceDAO getSourceConnection() 
	{
		if (sourceConn == null) 
		{
			initializeSource();
			return sourceConn;
		} 
		else 
		{
			return sourceConn;
		}
	}
	
	public static TargetDAO getTargetConnection() 
	{
		if (targetConn == null) 
		{
			initializeTarget();
			return targetConn;
		} 
		else 
		{
			return targetConn;
		}
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

	public void setApp_list(ArrayList<Application> app_list) {
		this.app_list = app_list;
	}

	public void setBr_list(ArrayList<BusinessRule> br_list) {
		this.br_list = br_list;
	}

	public void setBrt_list(ArrayList<BusinessRuleType> brt_list) {
		this.brt_list = brt_list;
	}

	public void setCat_list(ArrayList<Category> cat_list) {
		this.cat_list = cat_list;
	}

	public void setCc_list(ArrayList<CustomCode> cc_list) {
		this.cc_list = cc_list;
	}

	public void setDb_list(ArrayList<DataBase> db_list) {
		this.db_list = db_list;
	}

	public void setErr_list(ArrayList<APP_Error> err_list) {
		this.err_list = err_list;
	}

	public void setJunc_tb_tg_list(ArrayList<junc_tb_tg> junc_tb_tg_list) {
		this.junc_tb_tg_list = junc_tb_tg_list;
	}

	public void setOpe_list(ArrayList<Operator> ope_list) {
		this.ope_list = ope_list;
	}

	public void setTb_list(ArrayList<Table> tb_list) {
		this.tb_list = tb_list;
	}

	public void setTbc_list(ArrayList<TableColumn> tbc_list) {
		this.tbc_list = tbc_list;
	}

	public void setTg_list(ArrayList<Trigger> tg_list) {
		this.tg_list = tg_list;
	}

	public void setVal_list(ArrayList<Value> val_list) {
		this.val_list = val_list;
	}

	public ArrayList<BusinessRuleType> getBrt_list() {
		return brt_list;
	}

	public ArrayList<BusinessRule> getBr_list() {
		return br_list;
	}
}