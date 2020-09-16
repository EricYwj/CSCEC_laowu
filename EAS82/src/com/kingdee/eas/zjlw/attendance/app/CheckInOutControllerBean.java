package com.kingdee.eas.zjlw.attendance.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.zjlw.attendance.CheckInOutCollection;
import com.kingdee.eas.zjlw.attendance.CheckInOutFactory;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.zjlw.attendance.CheckInOutInfo;
import com.kingdee.eas.zjlw.common.dbCommonHelper;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckInOutControllerBean extends AbstractCheckInOutControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.zjlw.attendance.app.CheckInOutControllerBean");
	public static String sql = "SELECT pin,ui.`name`,dept.deptName,checktime,checkType,perAr.areaname,sn_name FROM checkinout AS che INNER JOIN userinfo AS ui ON che.pin = ui.badgenumber INNER JOIN userinfo_attarea AS uiAtt ON ui.userid = uiAtt.employee_id INNER JOIN personnel_area AS perAr ON uiAtt.area_id = perAr.id INNER JOIN departments AS dept ON ui.defaultdeptid = dept.DeptID";
	private static String perId = "";
	private static String perName = "";
	private static String perProj = "";
	private static String checkTime = "";
	private static String checkType = "";
	private static String checkAera = "";
	private static String machineId = "";
	
	public String pin = "";
	public String name1 = "";
	public String deptName = "";
	public String checktime = "";
	public String checkType1= "";
	public String areaname = "";
	public String sn_name = "";
	
	// 初始化单据
	public void init(Context ctx) throws BOSException {
		sql = sql + "where TO_DAYS(checktime) <" + "TO_DAYS(NOW())";
		opeanSet(ctx, getResult(sql));
	}

	// 执行sql
	public Set<Map<String, String>> getResult(String sql) {
		dbCommonHelper db1 = new dbCommonHelper(sql);// 创建DBHelper对象
		Set<Map<String, String>> resultSet = new HashSet<Map<String, String>>();
		ResultSet ret;
		try {
			ret = db1.pst.executeQuery(sql);
			// 整理结果集
			resultSet = initresultSet(ret);
			ret.close();
			db1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行语句，得到结果集
		return resultSet;
	}

	//整理结果集
	private Set<Map<String, String>> initresultSet(ResultSet ret) throws SQLException {
		Set<Map<String, String>> resultSet = new HashSet<Map<String, String>>();
		while (ret.next()) {
			pin = ret.getString("pin");
			name1 = ret.getString("name");
			deptName = ret.getString("deptName");
			checktime = ret.getString("checktime");
			checkType = ret.getString("checkType");
			areaname = ret.getString("areaname");
			sn_name = ret.getString("sn_name");
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("pin", pin);
			resultMap.put("name", name1);
			resultMap.put("deptName", deptName);
			resultMap.put("checktime", checktime);
			resultMap.put("checkType", checkType);
			resultMap.put("areaname", areaname);
			resultMap.put("sn_name", sn_name);
			resultSet.add(resultMap);
		}
		return resultSet;
	}
	
	// 拆解set
	private boolean opeanSet(Context ctx, Set<Map<String, String>> resultSet) {
		for (Map<String, String> resultMap : resultSet) {
			initChe(ctx, resultMap);
		}
		return true;
	}

	// 实例化考勤原始记录表
	private void initChe(Context ctx, Map<String, String> resultMap) {
		perId = resultMap.get("pin");
		perName = resultMap.get("name");
		perProj = resultMap.get("deptName");
		checkTime = resultMap.get("checktime");
		checkType = resultMap.get("checkType");
		checkAera = resultMap.get("areaname");
		machineId = resultMap.get("sn_name");
		CheckInOutInfo cheInfo = new CheckInOutInfo();
		cheInfo.setId(BOSUuid.create(cheInfo.getBOSType()));
		cheInfo.setPerId(perId);
		cheInfo.setPerName(perName);
		cheInfo.setPerProj(perProj);
		cheInfo.setCheckTime(checkTime);
		cheInfo.setCheckType(checkType);
		cheInfo.setCheAera(checkAera);
		cheInfo.setMachineId(machineId);
		try {
			CheckInOutFactory.getLocalInstance(ctx).addnew(cheInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}