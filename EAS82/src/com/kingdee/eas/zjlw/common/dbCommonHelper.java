package com.kingdee.eas.zjlw.common;

/**
 * @author ywj51
 * �״α�д���ʱ�䣺2017-4-14
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class dbCommonHelper {
	public static final String url = "jdbc:mysql://154.127.96.56/zkteco_database";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "wang_kai";
	public static final String password = "1qaz@wsx";
	public Connection conn = null;
	public PreparedStatement pst = null;
	public String sql = "SELECT pin,ui.`name`,dept.deptName,checktime,checkType,perAr.areaname,sn_name FROM checkinout AS che INNER JOIN userinfo AS ui ON che.pin = ui.badgenumber INNER JOIN userinfo_attarea AS uiAtt ON ui.userid = uiAtt.employee_id INNER JOIN personnel_area AS perAr ON uiAtt.area_id = perAr.id INNER JOIN departments AS dept ON ui.defaultdeptid = dept.DeptID";
	public String pin = "";
	public String name1 = "";
	public String deptName = "";
	public String checktime = "";
	public String checkType = "";
	public String areaname = "";
	public String sn_name = "";
	
	public dbCommonHelper(String sql) {
		try {
			Class.forName(name);// ָ����������
			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
			pst = conn.prepareStatement(sql);// ׼��ִ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �ر�����
	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
