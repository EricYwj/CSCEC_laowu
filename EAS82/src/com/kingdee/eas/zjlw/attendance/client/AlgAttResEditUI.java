/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.attendance.AlgAttDataEntryCollection;
import com.kingdee.eas.zjlw.attendance.AlgAttDataEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttDataEntryInfo;
import com.kingdee.eas.zjlw.attendance.AlgAttResCollection;
import com.kingdee.eas.zjlw.attendance.AlgAttResEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttResFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttResInfo;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryInfo;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryCollection;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryInfo;
import com.kingdee.eas.zjlw.attendance.app.algResultEnum;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class AlgAttResEditUI extends AbstractAlgAttResEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AlgAttResEditUI.class);
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    
	public void onLoad() throws Exception {
    	super.onLoad();
    	//点击新增
    	if(getOprtState().equals("ADDNEW")){
    		this.pkBizDate.setValue(new Date());
    		//考勤开始时间，考勤结束时间赋默认值
    		Calendar cal = Calendar.getInstance(); 
    		cal.add(Calendar.DATE,-1); 
    		cal.set(Calendar.HOUR, 00);
    		cal.set(Calendar.MINUTE, 00);
    		cal.set(Calendar.SECOND, 00);
    		cal.set(Calendar.MILLISECOND, 000);
    		Date d = cal.getTime();
    		this.pkbeginDate.setValue(d);
    		cal.add(Calendar.DATE,1); 
    		Date n = cal.getTime();
    		this.pkendDate.setValue(n);
//    		//初始化单据
//    		initBill();
    	}
    }
    
    /**
     * 考勤开始时间值改变事件
     */
    protected void pkbeginDate_dataChanged(DataChangeEvent e) throws Exception {
    	super.pkbeginDate_dataChanged(e);
    	//初始化或更新分录
    	if (this.pkbeginDate.getValue() != null && this.pkendDate.getValue() != null) {
    		this.kdtEntrys.removeRows();
    		initBill();
		}
    }
    

	/**
     * 考勤结束时间值改变事件
     */
    protected void pkendDate_dataChanged(DataChangeEvent e) throws Exception {
    	super.pkendDate_dataChanged(e);
    	//初始化或更新分录
    	if (this.pkbeginDate.getValue() != null && this.pkendDate.getValue() != null) {
    		this.kdtEntrys.removeRows();
    		initBill();
		}
    }
    
    /**
     * 初始化单据
     * @throws BOSException 
     * @throws EASBizException 
     * @throws ParseException 
     */
    private void initBill() throws EASBizException, BOSException, ParseException {
		//获取本项目人员，以map的key返回
    	Map<AlgPersEntryInfo, AlgAttDataEntryCollection> map = new HashMap<AlgPersEntryInfo, AlgAttDataEntryCollection>();
    	map = getPersByProCom();
    	//根据人员查询考勤数据
    	map = getAlgAttData(map);
    	//比照考勤数据和考勤规则得出结果，并实例化
    	initByMap(map);
	}
    
    /**
     * 比照考勤数据和考勤规则，计算考勤结果，并初始化单据
     * @param map
     * @throws EASBizException
     * @throws BOSException
     */
    private void initByMap(Map<AlgPersEntryInfo, AlgAttDataEntryCollection> map) throws EASBizException, BOSException {
    	if(map != null){
    		for (Map.Entry<AlgPersEntryInfo, AlgAttDataEntryCollection> entry : map.entrySet()) { 
    			AlgPersEntryInfo aap = entry.getKey();
    			AlgPersEntryInfo aapInfo = AlgPersEntryFactory.getRemoteInstance().getAlgPersEntryInfo(new ObjectUuidPK(aap.getId()));
    			
    			//循环考勤结果集合
    			AlgAttDataEntryCollection aadCol = entry.getValue();
    			if (aadCol.size() > 0) {
    				for (int i = 0; i < aadCol.size(); i++) {
        				IRow row = this.kdtEntrys.addRow();
        				AlgAttDataEntryInfo aad = aadCol.get(i);
            			row.getCell("personId").setValue(aapInfo.getPersonID());//人员主键
            			row.getCell("name").setValue(aapInfo.getName());//姓名
            			AdminOrgUnitInfo coop = aapInfo.getCooperation();
            			AdminOrgUnitInfo coopInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(coop.getId()));
            			row.getCell("cooperation").setValue(coopInfo);//合作单位
            			row.getCell("cooperationId").setValue(aapInfo.getCooperationId());//合作单位代码
            			if (aad == null) {
            				row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        				}else{
        	    			//获取考勤规则
        					AlgAttDataEntryInfo aadInfo = AlgAttDataEntryFactory.getRemoteInstance().getAlgAttDataEntryInfo(new ObjectUuidPK(aad.getId()));
        					row.getCell("attDate").setValue(aadInfo.getAttDate());//考勤时间
        					AlgCheckRulesInfo crInfo = aapInfo.getCheckRuleId();
        	    			AlgCheckRulesInfo acrInfo = AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesInfo(new ObjectUuidPK(crInfo.getId()));
        	    			Date bizDate = aadInfo.getAttDate();
        	    			String dateString = bizDate.toString();
        	    			int index = Integer.parseInt(dateString.substring(8, 10));
        	    			AlgCheckRulesEntryInfo ACREntryInfo = acrInfo.getEntrys().get(index-1);
        	    			//规则
        	    			Time  one = ACREntryInfo.getAmOnDuty();//上午上班时间
        	    			Time  two = ACREntryInfo.getAmOutDuty();//上午下班时间
        	    			Time three = ACREntryInfo.getPmOnDuty();//下午上班时间
        	    			Time four = ACREntryInfo.getPmOutDuty();//下午下班时间
        	    			boolean holiday = ACREntryInfo.isHoliday();//是否节假日
        	    			int aftbef = acrInfo.getAftBefmins();//迟到早退时间
        	    			boolean  off = ACREntryInfo.isOffWork();
        	    			boolean  go = ACREntryInfo.isGoWork();
        	    			//实际数据
        	    			Time amOT = aadInfo.getAmOnDuty();//上午上班时间
        	    			Time amTT = aadInfo.getAmOutDuty();//上午下班时间
        	    			Time pmOT = aadInfo.getPmOnDuty();//下午上班时间
        	    			Time pmTT = aadInfo.getPmOutDuty();//下午下班时间
        	    			Date attDate = aadInfo.getAttDate();//考勤日期
        	    			float l = 24*60*60*1000; //每天的毫秒数 
        	    			float zero = attDate.getTime() - (attDate.getTime()%l);
        	    			float unZero = 24*3600000 + zero;
        	    			//计算考勤结果
        	    			long letMin = 0;
        	    			 if(off && !go){//夜班下班
        	    					if (one != null && two == null && three == null && four == null) {
        	    						if (amOT == null) {
        	    	    					//缺勤
        	    	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        	    	    				} else {
        	    	    					float hour = (amOT.getTime() - zero)/3600000;
        	    	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
        	    	    					if (holiday) {
        	    	    						//正常考勤，节假日加班
        	    	    						row.getCell("hoOverTime").setValue(hour);//节假日加班(小时)
        	    	    					} else {
        	    	    						//考勤规则制定出勤时间
        	    	    						float count0 = one.getTime() - zero;
        	    		    					//计算实际出勤时间
        	    	    						float count1 = amOT.getTime()- zero;
        	    	    						//上午下班
        	    	    						if (amOT.getTime() < (one.getTime() - aftbef*60*1000)) {//早退
        	    	    							letMin = letMin + (one.getTime() - amOT.getTime())/60000;
        	    								} 
        	    	    						if (letMin == 0) {//正常
        	    	    							if ((count1 - count0)/3600000 > 1) {
        	    	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
        	    									}
        	    								}else{//缺勤
        	    									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
        	    								}
        	    	    					}
        	    	    				}
        	    					}else if(one != null && two != null && three != null && four == null){
        	    						if (amOT == null || amTT == null || pmOT == null) {
        	    	    					//缺勤
        	    	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        	    	    				} else {
        	    	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
        	    	    					float count1 = ((amOT.getTime() - zero) + (pmOT.getTime() - amTT.getTime()))/3600000;//实际工作时间
        	    	    					float count0 = ((one.getTime() - zero) + (three.getTime() - two.getTime()))/3600000;//规定工作时间
        	    	    					if (holiday) {
        	    	    						//正常考勤，节假日加班
        	    	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
        	    	    					} else {
        	    	    						//下班
        	    	    						if (amOT.getTime() < (one.getTime() - aftbef*60*1000)) {//早退
        	    	    							letMin = letMin + (one.getTime() - amOT.getTime())/60000;
        	    								} 
        	    	    						//上班
        	    	    						if (amTT.getTime() > (two.getTime() + aftbef*60*1000)) {//迟到
        	    	    							letMin = letMin + (amTT.getTime() - two.getTime())/60000;
        	    								}
        	    	    						//下班
        	    	    						if (pmOT.getTime() < (three.getTime() - aftbef*60*1000)) {//早退
        	    	    							letMin = letMin + (three.getTime() - pmOT.getTime())/60000;
        	    								}
        	    	    						if (letMin == 0) {//正常
        	    	    							if ((count1 - count0)/3600000 > 1) {
        	    	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
        	    									}
        	    								}else{//缺勤
        	    									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
        	    								}
        	    	    					}
        	    	    				}
        	    					}
        	    				}else if(go && !off){//夜班上班
        	    					if (one != null && two == null && three == null && four == null) {
        	    						if (amOT == null) {
        	    	    					//缺勤
        	    	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        	    	    				} else {
        	    	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
        	    	    					//考勤规则制定出勤时间
            	    						float count0 = unZero - one.getTime();
            		    					//计算实际出勤时间
            	    						float count1 = unZero - amOT.getTime();
        	    	    					if (holiday) {
        	    	    						//正常考勤，节假日加班
        	    	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
        	    	    					} else {
        	    	    						if (amOT.getTime() < (one.getTime() - aftbef*60*1000)) {//迟到
        	    	    							letMin = letMin + (one.getTime() - amOT.getTime())/60000;
        	    								} 
        	    	    						if (letMin == 0) {//正常
        	    	    							if ((count1 - count0)/3600000 > 1) {
        	    	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
        	    									}
        	    								}else{//缺勤
        	    									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
        	    								}
        	    	    					}
        	    	    				}
        	    					}else if(one != null && two != null && three != null && four == null){
        	    						if (amOT == null || amTT == null || pmOT == null) {
        	    	    					//缺勤
        	    	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        	    	    				} else {
        	    	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
        	    	    					float count1 = ((amTT.getTime() - amOT.getTime()) + (unZero - pmOT.getTime()))/3600000;//实际工作时间
        	    	    					float count0 = ((two.getTime() - one.getTime()) + (unZero - three.getTime()))/3600000;//规定工作时间
        	    	    					if (holiday) {
        	    	    						//正常考勤，节假日加班
        	    	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
        	    	    					} else {
        	    	    						//上班
        	    	    						if (amOT.getTime() > (one.getTime() + aftbef*60*1000)) {//迟到
        	    	    							letMin = letMin + (amOT.getTime() - one.getTime())/60000;
        	    								} 
        	    	    						//下班
        	    	    						if (amTT.getTime() < (two.getTime() - aftbef*60*1000)) {//早退
        	    	    							letMin = letMin + (two.getTime() - amTT.getTime())/60000;
        	    								}
        	    	    						//上班
        	    	    						if (pmOT.getTime() > (three.getTime() + aftbef*60*1000)) {//迟到
        	    	    							letMin = letMin + (pmOT.getTime() - three.getTime())/60000;
        	    								}
        	    	    						if (letMin == 0) {//正常
        	    	    							if ((count1 - count0)/3600000 > 1) {
        	    	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
        	    									}
        	    								}else{//缺勤
        	    									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
        	    								}
        	    	    					}
        	    	    				}
        	    					}
        	    				}else if(go && off){//夜班下班夜班上班
        	    					if (one != null && two != null && three == null && four == null) {
        	    						if (amOT == null || amTT == null) {
        	    	    					//缺勤
        	    	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
        	    	    				} else {
        	    	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
        	    	    					float count1 = ((amOT.getTime() - zero) + (unZero - amTT.getTime()))/3600000;//实际工作时间
        	    	    					float count0 = ((one.getTime() - zero) + (unZero - two.getTime()))/3600000;//规定工作时间
        	    	    					if (holiday) {
        	    	    						//正常考勤，节假日加班
        	    	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
        	    	    					} else {
        	    	    						//上班
        	    	    						if (amTT.getTime() > (two.getTime() + aftbef*60*1000)) {//迟到
        	    	    							letMin = letMin + (amTT.getTime() - two.getTime())/60000;
        	    								} 
        	    	    						//下班
        	    	    						if (amOT.getTime() < (one.getTime() - aftbef*60*1000)) {//早退
        	    	    							letMin = letMin + (one.getTime() - amOT.getTime())/60000;
        	    								}
        	    	    						if (letMin == 0) {//正常
        	    	    							if ((count1 - count0)/3600000 > 1) {
        	    	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
        	    									}
        	    								}else{//缺勤
        	    									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
        	    								}
        	    	    					}
        	    	    				}
            					}else if(one != null && two != null && three != null && four != null){
            						if (amOT == null || amTT == null || pmOT == null || pmTT == null) {
            	    					//缺勤
            	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
            	    				} else {
            	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
            	    					float count1 = ((amOT.getTime() - zero) + (pmOT.getTime() - amTT.getTime()) + (unZero - pmTT.getTime()))/3600000;//实际工作时间
            	    					float count0 = ((one.getTime() - zero) + (three.getTime() - two.getTime()) + (unZero - two.getTime()))/3600000;//规定工作时间
            	    					if (holiday) {
            	    						//正常考勤，节假日加班
            	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
            	    					} else {
            	    						//上班
            	    						if (amTT.getTime() > (two.getTime() + aftbef*60*1000)) {//迟到
            	    							letMin = letMin + (amTT.getTime() - two.getTime())/60000;
            								}
            	    						//上班
            	    						if (pmTT.getTime() > (four.getTime() + aftbef*60*1000)) {//迟到
            	    							letMin = letMin + (pmTT.getTime() - four.getTime())/60000;
            								}
            	    						//下班
            	    						if (amOT.getTime() < (one.getTime() - aftbef*60*1000)) {//早退
            	    							letMin = letMin + (one.getTime() - amOT.getTime())/60000;
            								}
            	    						//下班
            	    						if (pmOT.getTime() < (three.getTime() - aftbef*60*1000)) {//早退
            	    							letMin = letMin + (three.getTime() - pmOT.getTime())/60000;
            								}
            	    						if (letMin == 0) {//正常
            	    							if ((count1 - count0)/3600000 > 1) {
            	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
            									}
            								}else{//缺勤
            									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
            								}
            	    					}
            	    				}
            					}
            				}else if(!go && !off){//正常
            					if (one != null && two != null && three == null && four == null) {
            						if (amOT == null || amTT == null) {
            	    					//缺勤
            	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
            	    				} else {
            	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
            	    					float count1 = (amTT.getTime() - amOT.getTime())/3600000;//实际工作时间
            	    					float count0 = (two.getTime() - one.getTime())/3600000;//规定工作时间
            	    					if (holiday) {
            	    						//正常考勤，节假日加班
            	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
            	    					} else {
            	    						//上班
            	    						if (amOT.getTime() > (one.getTime() + aftbef*60*1000)) {//迟到
            	    							letMin = letMin + (amOT.getTime() - one.getTime())/60000;
            								} 
            	    						//下班
            	    						if (amTT.getTime() < (two.getTime() - aftbef*60*1000)) {//早退
            	    							letMin = letMin + (two.getTime() - amTT.getTime())/60000;
            								}
            	    						if (letMin == 0) {//正常
            	    							if ((count1 - count0)/3600000 > 1) {
            	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
            									}
            								}else{//缺勤
            									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
            								}
            	    					}
            	    				}
            					}else if(one != null && two != null && three != null && four != null){
            						if (amOT == null || amTT == null || pmOT == null || pmTT == null) {
            	    					//缺勤
            	    					row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
            	    				} else {
            	    					row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
            	    					float count1 = ((amTT.getTime() - amOT.getTime()) + (pmTT.getTime() - pmOT.getTime()))/3600000;//实际工作时间
            	    					float count0 = ((two.getTime() - one.getTime()) + (four.getTime() - three.getTime()))/3600000;//规定工作时间
            	    					if (holiday) {
            	    						//正常考勤，节假日加班
            	    						row.getCell("hoOverTime").setValue(count1);//节假日加班(小时)
            	    					} else {
            	    						//上班
            	    						if (amOT.getTime() > (one.getTime() + aftbef*60*1000)) {//迟到
            	    							letMin = letMin + (amOT.getTime() - one.getTime())/60000;
            								}
            	    						//上班
            	    						if (pmOT.getTime() > (three.getTime() + aftbef*60*1000)) {//迟到
            	    							letMin = letMin + (pmOT.getTime() - three.getTime())/60000;
            								}
            	    						//下班
            	    						if (amTT.getTime() < (two.getTime() - aftbef*60*1000)) {//早退
            	    							letMin = letMin + (two.getTime() - amTT.getTime())/60000;
            								}
            	    						//下班
            	    						if (pmTT.getTime() < (four.getTime() - aftbef*60*1000)) {//早退
            	    							letMin = letMin + (four.getTime() - pmTT.getTime())/60000;
            								}
            	    						if (letMin == 0) {//正常
            	    							if ((count1 - count0)/3600000 > 1) {
            	    								row.getCell("overTime").setValue((count1 - count0)/3600000);//加班时间(小时)
            									}
            								}else{//缺勤
            									row.getCell("noWorkTime").setValue(Integer.parseInt(String.valueOf(letMin)));//迟到早退时间(分钟)
            								}
            	    					}
            	    				}
            					}
            				}
        				}
    				}
				}
    		}
    	}
		
	}

    
	/**
     * 根据人员集合查询考勤数据集合
     * @param map
     * @return
     * @throws BOSException
	 * @throws ParseException 
     */
    private Map<AlgPersEntryInfo, AlgAttDataEntryCollection> getAlgAttData(Map<AlgPersEntryInfo, AlgAttDataEntryCollection> map) throws BOSException, ParseException {
    	if (map != null) {
    		for (Map.Entry<AlgPersEntryInfo, AlgAttDataEntryCollection> entry : map.entrySet()) {  
    			AlgPersEntryInfo aapInfo = entry.getKey();
    			AlgAttDataEntryCollection aadEntryInfo = getAlgAttDataEntryInfoByAAP(aapInfo);
    			map.put(aapInfo, aadEntryInfo);
        	}
		}
		return map;
	}
    
    /**
     * 根据考勤人员获取考勤数据
     * @param aapInfo
     * @return
     * @throws BOSException 
     * @throws ParseException 
     */
	private AlgAttDataEntryCollection getAlgAttDataEntryInfoByAAP(AlgPersEntryInfo aapInfo) throws BOSException, ParseException {
		Date begin = (Date) this.pkbeginDate.getValue();
    	Date end = (Date) this.pkendDate.getValue();
		String personId = aapInfo.getPersonID();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("personId",personId));
		filter.getFilterItems().add(new FilterItemInfo("attDate",end,CompareType.LESS_EQUALS));
    	filter.getFilterItems().add(new FilterItemInfo("attDate",begin,CompareType.GREATER_EQUALS));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("parent.bizDate");
		sic.add("name");
		sic.add("amOnDuty");
		sic.add("amOutDuty");
		sic.add("pmOnDuty");
		sic.add("pmOutDuty");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		AlgAttDataEntryCollection col = AlgAttDataEntryFactory.getRemoteInstance().getAlgAttDataEntryCollection(view);
//		if (col.size() == 0) {
//			MsgBox.showInfo("无" + aapInfo.getName() + "的考勤数据，无法生成考勤结果！");
////			abort();
//		}
		return col;
	}

	/**
     * 获取本项目的人员
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
	private Map<AlgPersEntryInfo, AlgAttDataEntryCollection> getPersByProCom() throws EASBizException, BOSException {
		AdminOrgUnitInfo admin = (AdminOrgUnitInfo) this.prmtproCom.getValue();
		AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(admin.getId()));
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.proCom.id",adminInfo.getId()));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		AlgPersEntryCollection aapCol = AlgPersEntryFactory.getRemoteInstance().getAlgPersEntryCollection(view);
		Map<AlgPersEntryInfo, AlgAttDataEntryCollection> map = new HashMap<AlgPersEntryInfo, AlgAttDataEntryCollection>();
		for (int i = 0; i < aapCol.size(); i++) {
			map.put(aapCol.get(i), null);
		}
		return map;
	}
	
	/**
	 * 提交前校验
	 */
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		//校验是否之前的数据存在重复的时间段或时间点
		String ownStart = format.format((Date)this.pkbeginDate.getValue());
		String ownEnd = format.format((Date)this.pkendDate.getValue()).toString();
		AlgAttResCollection aarCol = getAarCol();
		for (int i = 0; i < aarCol.size(); i++) {
			AlgAttResInfo info = aarCol.get(i);
			getOverlap(ownStart, ownEnd, format.format(info.getBeginDate()), format.format(info.getEndDate()));
		}
	}
	
	/**
	 * 获取考勤结果
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private AlgAttResCollection getAarCol() throws EASBizException, BOSException {
		AdminOrgUnitInfo proCom = (AdminOrgUnitInfo) this.prmtproCom.getValue();
		AdminOrgUnitInfo proComInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("proCom.id",proCom.getId()));
		filter.getFilterItems().add(new FilterItemInfo("billSate",BillStateEnum.CHECKED));
		sic.add("beginDate");
		sic.add("endDate");
		view.setFilter(filter);
		view.setSelector(sic);
		AlgAttResCollection col = AlgAttResFactory.getRemoteInstance().getAlgAttResCollection(view);
		return col;
	}

	/**
	 * 两个时间段是否存在交集
	 * @param startdate1
	 * @param enddate1
	 * @param startdate2
	 * @param enddate2
	 * 
	 */
    private void getOverlap(String ownStart, String ownEnd,String otherStart, String otherEnd) {  
        Date from1 = null;  
        Date to1 = null;  
        Date from2 = null;  
        Date to2 = null;  
        try {  
        	from1 = format.parse(ownStart);  
        	to1 = format.parse(ownEnd);  
        	from2 = format.parse(otherStart);  
        	to2 = format.parse(otherEnd);  
        } catch (ParseException e) {  
        }  
        long f1 = from1.getTime();
        long t1 = to1.getTime();
        long f2 = from2.getTime();
        long t2 = to2.getTime();
        
        if (f2 < f1) {
			if (f1 == t2) {
				MsgBox.showInfo("已有" + ownStart + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (f1 < t2 && t2 < t1) {
				MsgBox.showInfo("已有" + ownStart + "到" + otherEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 <= t2) {
				MsgBox.showInfo("已有" + ownStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			
		}else if(f1 <= f2 && f2 <= t1){
			if (f1 <= f2 && t2 <= t1) {
				MsgBox.showInfo("已有" + otherStart + "到" + otherEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (f1 == f2 && t1 < t2) {
				MsgBox.showInfo("已有" + ownStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 < t2) {
				MsgBox.showInfo("已有" + otherStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 == t2) {
				MsgBox.showInfo("已有" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
		}
    }
	
	
	/**
     * output class constructor
     */
    public AlgAttResEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AlgAttResFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.AlgAttResInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgAttResInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
    	if(fullInfo==null){
    		MsgBox.showInfo("请选择工作项目进行新增！");
    		this.abort();
    	}
        SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
        try {
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setProCom(adminInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
        return objectValue;
    }
    
    /** 
     * 获得指定日期的前一天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
//    public static String getSpecifiedDayBefore(String specifiedDay) {
//        Calendar c = Calendar.getInstance();  
//        Date date = null;  
//        try {  
//            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
//        } catch (ParseException e) {  
//            e.printStackTrace();  
//        }  
//        c.setTime(date);  
//        int day = c.get(Calendar.DATE);  
//        c.set(Calendar.DATE, day - 2);  
//  
//        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
//        return dayBefore;  
//    }  

}