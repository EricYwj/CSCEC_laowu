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
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.zjlw.attendance.CheckInOutFactory;
import com.kingdee.eas.zjlw.attendance.CheckInOutInfo;
import com.kingdee.eas.zjlw.attendance.CheckInOutTableFactory;
import com.kingdee.eas.zjlw.attendance.CheckInOutTableInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.attendance.CheckInOutTableCollection;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryInfo;
import com.kingdee.eas.zjlw.common.dbCommonHelper;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckInOutTableControllerBean extends AbstractCheckInOutTableControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.attendance.app.CheckInOutTableControllerBean");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String sql = "SELECT pin,ui.`name`,dept.deptName,checktime,checkType,perAr.areaname,sn_name FROM checkinout AS che INNER JOIN userinfo AS ui ON che.pin = ui.badgenumber INNER JOIN userinfo_attarea AS uiAtt ON ui.userid = uiAtt.employee_id INNER JOIN personnel_area AS perAr ON uiAtt.area_id = perAr.id INNER JOIN departments AS dept ON ui.defaultdeptid = dept.DeptID WHERE TO_DAYS(checktime) > TO_DAYS('2016-11-15')";
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
	public String init(Context ctx) throws BOSException {
		getResult(ctx,sql);
		return null;
	}

	// 执行sql
	public void getResult(Context ctx, String sql) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://154.127.96.56/zkteco_database";
        String user = "wang_kai";
        String password = "1qaz@wsx";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Set<Map<String, String>> resultSet = new HashSet<Map<String, String>>();
            while(rs.next()){
            	pin = rs.getString("pin");
    			name1 = rs.getString("name");
    			deptName = rs.getString("deptName");
    			checktime = rs.getString("checktime");
    			checkType = rs.getString("checkType");
    			areaname = rs.getString("areaname");
    			sn_name = rs.getString("sn_name");
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
            rs.close();
            con.close();
            opeanSet(ctx, resultSet);
        } catch(ClassNotFoundException e) {   
            e.printStackTrace();   
            } catch(SQLException e) {
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
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
		CheckInOutTableInfo cheInfo = new CheckInOutTableInfo();
		cheInfo.setId(BOSUuid.create(cheInfo.getBOSType()));
		cheInfo.setPerId(perId);
		cheInfo.setPerName(perName);
		cheInfo.setPerProj(perProj);
		cheInfo.setCheckTime(checkTime);
		cheInfo.setCheckType(checkType);
		cheInfo.setCheckAera(checkAera);
		cheInfo.setMachineId(machineId);
		try {
			cheInfo.setChkTime(sdf.parse(checkTime));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			CheckInOutTableFactory.getLocalInstance(ctx).addnew(cheInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}