/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;

import com.kingdee.eas.framework.*;
import com.kingdee.eas.mm.project.Peroid;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjWageFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjWageInfo;

import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.baseinfo.WageInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.zjlw.social.CheckCountCollection;
import com.kingdee.eas.zjlw.social.CheckCountEntryCollection;
import com.kingdee.eas.zjlw.social.CheckCountEntryFactory;
import com.kingdee.eas.zjlw.social.CheckCountFactory;
import com.kingdee.eas.zjlw.social.CheckCountInfo;
import com.kingdee.eas.zjlw.social.ForiPersEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonFactory;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class CheckCountEditUI extends AbstractCheckCountEditUI {
	private static final Logger logger = CoreUIObject.getLogger(CheckCountEditUI.class);

	public void onLoad() throws Exception {
		super.onLoad();
		setButtonStatus();

		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if ("L1".equals(strLanguage) || "l1".equals(strLanguage)) {
			setUITitle("");
		} else if ("L2".equals(strLanguage) || "l2".equals(strLanguage)) {
			setUITitle("属地化员工社保考勤表");
		} else {
			// setUITitle("");
		}
		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 end

		// 初始化单据
		if (getOprtState().equals("ADDNEW")) {
			this.pkBizDate.setValue(new Date());
			// initBill();
		}
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			AdminOrgUnitInfo admin = (AdminOrgUnitInfo) this.prmtpermProj.getValue();
			if (admin != null) {
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id", admin.getId().toString()));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
		checkPrice();
		checkColor();
		filterProf();
		this.kdtEntrys.getColumn("seniPay").getStyleAttributes().setNumberFormat("###,###,##0.00");// 工龄工资
		this.kdtEntrys.getColumn("nUrgeWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 月鼓励补贴总额
		this.kdtEntrys.getColumn("oneTimeWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 个人绩效奖金总额
		this.kdtEntrys.getColumn("outWageC").getStyleAttributes().setNumberFormat("###,###,##0.00");// 月出差补贴总额
		this.kdtEntrys.getColumn("faraWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 偏远和艰苦项目补贴
		// zxh 2016-10-11
		this.kdtEntrys.getColumn("totOneWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 一人就业补贴总额
		this.kdtEntrys.getColumn("itmperie").getStyleAttributes().setNumberFormat("###,###,##0.00");// Intempérie
		// (
		// 53
		// km
		// )
		// /
		// J
		this.kdtEntrys.getColumn("itmperieTol").getStyleAttributes().setNumberFormat("###,###,##0.00");// 27.
		// Intempérie
		// (
		// 53
		// km
		// )
		// 总额

		// rui_xu 2016-10-02

		this.kdtEntrys.getColumn("nSeniority").getStyleAttributes().setLocked(true);
		this.kdtEntrys.getColumn("seniPay").getStyleAttributes().setLocked(true);
		// zxh 2016-10-11
		// 修改社保工种列冻结 modified by wangth on 20170628 start
		// this.kdtEntrys.getColumn("secuProf").getStyleAttributes().setLocked(
		// false);
		this.kdtEntrys.getColumn("secuProf").getStyleAttributes().setLocked(true);
		// 修改社保工种列冻结 modified by wangth on 20170628 end
		this.kdtEntrys.getColumn("totOneWage").getStyleAttributes().setLocked(false);
		// this.kdtEntrys.getColumn("itmperie").getStyleAttributes().setLocked(
		// true);
		this.kdtEntrys.getColumn("itmperieTol").getStyleAttributes().setLocked(true);
	}

	// 分录补贴过滤
	private void filterProf() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (this.prmtpermProj.getValue() != null) {
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) this.prmtpermProj.getValue();
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id", admin.getIdentity().toString()));
				filterInfo.getFilterItems().add(new FilterItemInfo("isStop", false));
				// filterInfo.getFilterItems().add(new
				// FilterItemInfo("name","交通补助"));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("traWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 交通补贴
				row.getCell("eWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 工作补贴
				row.getCell("dengWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 现场风险补贴
				row.getCell("vaWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 危害补贴
				row.getCell("thingsWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 婚丧补贴
				row.getCell("oneWorkWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 一人就业补贴
				row.getCell("langWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 语言补贴
				row.getCell("areaWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 区域补贴
				row.getCell("switchWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 轮班补贴
				row.getCell("nWorkWage").setEditor(new KDTDefaultCellEditor(settNumPromptBox));// 夜班补贴过滤
			}
		}
	}

	private void checkPrice() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			BigDecimal nBasePay = (BigDecimal) row.getCell("nBasePay").getValue();
			BigDecimal days = new BigDecimal("22");
			BigDecimal modulus = new BigDecimal("0.75");
			if (nBasePay != null) {
				// row.getCell("itmperie").setValue(nBasePay.multiply(modulus).
				// divide(days, 2));
				// BigDecimal itmperie=(BigDecimal)
				// row.getCell("itmperie").getValue();
			}
		}
	}

	protected void setButtonStatus() {
		CheckCountInfo bill;
		if ("VIEW".equals(getOprtState())) {
			// this.actionAudit.setVisible(true);
			// this.actionUnAudit.setVisible(true);
			// this.actionAudit.setEnabled(true);
			// this.actionUnAudit.setEnabled(true);
			bill = (CheckCountInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (
					// BillStateEnum
					// .
					// SIGNE
					// .
					// equals
					// (
					// bill.
					// getBillSate
					// ()))
					// this.actionUnAudit.setEnabled(true);
					// this.actionAudit.setVisible(false);
					// this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					// this.actionUnAudit.setVisible(false);
					// this.actionUnAudit.setEnabled(false);
					// this.actionAudit.setVisible(true);
					// this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (CheckCountInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(true);
			}
			// this.actionAudit.setVisible(false);
			// this.actionUnAudit.setVisible(false);
			// this.actionAudit.setEnabled(false);
			// this.actionUnAudit.setEnabled(false);
		}
		if (((BillStateEnum.CHECKED.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {// (
			// this
			// .
			// editData
			// !=
			// null
			// )
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}
		if (this.editData != null) {
			bill = (CheckCountInfo) this.editData;
			if (!(BillStateEnum.DRAFT.equals(bill.getBillSate()))) {
				this.actionAuditResult.setEnabled(true);
				this.actionMultiapprove.setEnabled(true);
				this.actionNextPerson.setEnabled(true);
				this.actionWorkflowList.setEnabled(true);
				this.actionAuditResult.setVisible(true);
				this.actionMultiapprove.setVisible(true);
				this.actionNextPerson.setVisible(true);
				this.actionWorkflowList.setVisible(true);
			} else {
				this.actionAuditResult.setEnabled(false);
				this.actionMultiapprove.setEnabled(false);
				this.actionNextPerson.setEnabled(false);
				this.actionWorkflowList.setEnabled(false);

				this.actionAuditResult.setVisible(false);
				this.actionMultiapprove.setVisible(false);
				this.actionNextPerson.setVisible(false);
				this.actionWorkflowList.setVisible(false);
			}
		}
	}

	private void checkColor() throws EASBizException, BOSException {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			// 交通补贴总额 traWage traWageC
			wageNo(row, "traWage");
			// 工作餐补总额 eWage eWageC
			wageNo(row, "eWage");
			// 一人就业补贴总额 oneWorkWage totOneWage
			wageNo(row, "oneWorkWage");
			// 婚丧嫁偶补贴标准 thingsWage thingsWageC
			wageNo(row, "thingsWage");
		}
	}

	private void wageNo(IRow row, String name) throws EASBizException, BOSException {
		ProjWageInfo pjInfo = (ProjWageInfo) row.getCell(name).getValue();
		// ProjWageInfo pjInfo =
		// com.kingdee.eas.zjlw.baseinfo.ProjWageFactory.getRemoteInstance
		// ().getProjWageInfo(new
		// ObjectUuidPK(overWageInfo==null?null:overWageInfo.getId()));
		if (pjInfo != null) {
			BigDecimal money = pjInfo.getMoney();
			if (pjInfo.getType() != null) {
				BOSUuid id = pjInfo.getType().getId();
				WageInfo wgInfo = com.kingdee.eas.zjlw.baseinfo.WageFactory.getRemoteInstance().getWageInfo(new ObjectUuidPK(id));
				BigDecimal type = wgInfo.getMoney();
				String number = pjInfo.getNumber();
				if (type != null) {
					if (money != null && type != null) {
						if (!(money.compareTo(type) == 0)) {
							row.getCell(name).getStyleAttributes().setBackground(Color.red);
						} else {
							row.getCell(name).getStyleAttributes().setBackground(Color.white);
						}
					}
				}
			}
		}
	}

	/**
	 * 年月值改变事件
	 */
	protected void prmtmonthYearr_dataChanged(DataChangeEvent e) throws Exception {
		super.prmtmonthYearr_dataChanged(e);

	}

	/**
	 * 同项目同期间不可重复添加
	 * 
	 * @throws BOSException
	 */

	// 表格编辑事件
	protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
		Object oldValue = e.getOldValue();
		Object newValue = e.getValue();
		if (EcClientHelper.isEqual(oldValue, newValue)) {
			return;
		}
		KDTable tblDetail = (KDTable) e.getSource();
		int colIndex = e.getColIndex();
		int rowIndex = e.getRowIndex();
		tblDetail.putUserProperty("INIT_USERPROPERTIES", Boolean.TRUE);
		Map scaleMap = (Map) tblDetail.getUserProperty("TABLE_SCALE_MAP");
		if (null != scaleMap) {
			Set columnNameSet = scaleMap.keySet();
			String key = tblDetail.getColumnKey(colIndex);
			if ((columnNameSet.contains(key)) && (((oldValue == newValue || 0 == EcClientHelper.compareValue(oldValue, newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
	}

	protected void afterEditStopped(KDTable table, Object oldValue, Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		Date date = new Date();
		/*
		 * 交通补贴总额 traWage traWageC 工作餐补总额 eWage eWageC 现场风险补贴总额 dengWage
		 * totRiskWage 危害补助总额 vaWage vaWageC 一人就业补贴总额 oneWorkWage totOneWage
		 * 轮班补贴总额 switchWage switchWageC 区域补贴总额 areaWage totAreaWage 偏远和艰苦项目总额
		 * faraWage totFaraWage 婚丧嫁偶补贴标准 thingsWage thingsWageC
		 */
		// 出勤天数
		if ("nWorkDay".equals(key)) {
			// 交通补贴总额
			if (row.getCell("traWage").getValue() != null) {
				setWage(row, "traWage", "nWorkDay", "traWageC");
			}

			// 工作餐补总额
			if (row.getCell("eWage").getValue() != null) {
				setWage(row, "eWage", "nWorkDay", "eWageC");
			}
			// 现场风险补贴总额
			// if (row.getCell("dengWage").getValue() != null) {
			// setWage(row, "dengWage", "nWorkDay", "totRiskWage");
			// }
			// 危害补助总额
			if (row.getCell("vaWage").getValue() != null) {
				setWage(row, "vaWage", "nWorkDay", "vaWageC");
			}

			// 一人就业补贴总额
			// if (row.getCell("oneWorkWage").getValue() != null) {
			// setWage(row, "oneWorkWage", "nWorkDay", "totOneWage");
			// }
			// 区域补贴总额
			if (row.getCell("areaWage").getValue() != null) {//=区域补贴标准*基本工资/22*出勤天数；  190905修改
//				setWage(row, "areaWage", "nWorkDay", "totAreaWage");
				ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell("areaWage").getValue();
				ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
				BigDecimal oWage = owInfo.getMoney();
				BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();
				BigDecimal nBasePay = (BigDecimal) row.getCell("nBasePay").getValue();
				if (oWage != null && nWorkDay != null) {
					BigDecimal nBasePayBG = oWage.multiply(nWorkDay).multiply(nBasePay).divide(new BigDecimal("22"));
					row.getCell("totAreaWage").setValue(nBasePayBG);
				}
			}
			// 偏远和艰苦项目总额
			if (row.getCell("faraWage").getValue() != null) {
				setWageBigDecimal(row, "faraWage", "nWorkDay", "totFaraWage");
			}
		}
		// 夜班补贴 nWorkWage 补贴 nWorkTimes 天数 nWorkWageC 总额
		if ("nWorkTimes".equals(key)) {
			if (row.getCell("nWorkWage").getValue() != null) {
				setWageInteger(row, "nWorkWage", "nWorkTimes", "nWorkWageC");
			}
		}
		if ("nWorkWage".equals(key)) {
			// if(row.getCell("nWorkTimes").getValue() != null){
			// setWageInteger(row, "nWorkWage", "nWorkTimes", "nWorkWageC");
			// }
			ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell("nWorkWage").getValue();
			if (overWageInfo != null) {
				ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
				editAll(table, "nWorkWage", owInfo);
			}
		}
		// //交通补贴总额 traWage traWageC
		// wageNo(row,"traWage");
		// //工作餐补总额 eWage eWageC
		// wageNo(row,"eWage");
		// // 一人就业补贴总额 oneWorkWage totOneWage
		// wageNo(row,"oneWorkWage");
		// //婚丧嫁偶补贴标准 thingsWage thingsWageC
		// wageNo(row,"thingsWage");
		// 交通补贴总额
		if ("traWage".equals(key)) {
			ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell("traWage").getValue();
			if (overWageInfo != null) {
				ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
				editAll(table, "traWage", owInfo);
				// if (row.getCell("nWorkDay").getValue() != null) {
				// setWage(row, "traWage", "nWorkDay", "traWageC");
				// checkColor();
				// }
			}
		}

		// 工作餐补总额
		if ("eWage".equals(key)) {
			ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell("eWage").getValue();
			if (overWageInfo != null) {
				ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
				editAll(table, "eWage", owInfo);
				// if (row.getCell("nWorkDay").getValue() != null) {
				// setWage(row, "eWage", "nWorkDay", "eWageC");
				// checkColor();
				// }
			}
		}
		// 现场风险补贴总额
		// if ("dengWage".equals(key)) {
		// if (row.getCell("nWorkDay").getValue() != null) {
		// setWage(row, "dengWage", "nWorkDay", "totRiskWage");
		// }
		// }
		// 危害补助总额
		if ("vaWage".equals(key)) {
			// rui_xu 2016-10-05
			ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell("vaWage").getValue();
			if (overWageInfo != null) {
				ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
				editAll(table, "vaWage", owInfo);
				// if (row.getCell("nWorkDay").getValue() != null) {
				// setWage(row, "vaWage", "nWorkDay", "vaWageC");
				// }
			}
		}

		// 一人就业补贴总额
		// if ("oneWorkWage".equals(key)) {
		// if (row.getCell("nWorkDay").getValue() != null) {
		// setWage(row, "oneWorkWage", "nWorkDay", "totOneWage");
		// checkColor();
		// }
		// }
		// 轮班天数
		if ("switchTimes".equals(key)) {
			if (row.getCell("switchTimes").getValue() != null) {
				setWageInteger(row, "switchWage", "switchTimes", "switchWageC");
			}
		}
		// 轮班补贴总额
		if ("switchWage".equals(key)) {
			if (row.getCell("switchTimes").getValue() != null) {
				setWageInteger(row, "switchWage", "switchTimes", "switchWageC");
			}
		}
		// 区域补贴总额
		if ("areaWage".equals(key)) {
			if (row.getCell("nWorkDay").getValue() != null) {
				setWage(row, "areaWage", "nWorkDay", "totAreaWage");
			}
		}
		// 婚丧嫁偶补贴标准
		if ("thingsWage".equals(key)) {
			if (row.getCell("thingsTimes").getValue() != null) {
				setWageInteger(row, "thingsWage", "thingsTimes", "thingsWageC");
				checkColor();
			}
		}
		// 婚丧嫁偶次数
		if ("thingsTimes".equals(key)) {
			if (row.getCell("thingsWage").getValue() != null) {
				setWageInteger(row, "thingsWage", "thingsTimes", "thingsWageC");
			}
		}
		// 鼓偏远和艰苦项目总额
		if ("faraWage".equals(key)) {
			if (row.getCell("nWorkDay").getValue() != null) {
				setWageBigDecimal(row, "faraWage", "nWorkDay", "totFaraWage");
			}
		}
		// //奖金及一次性补贴
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //偏远和艰苦项目总额
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //丧葬嫁娶次数
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //职责补助
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //额外职责补助
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //轮班补贴
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //轮班次数
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //出差补贴
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //出差次数
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //出差住宿补贴
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
		// //出差住宿次数
		// if ("overWage".equals(key)){
		// if (row.getCell("nWorkDays").getValue() != null) {
		// setWage(row, "eatWage", "nWorkDays", "eatWageC");
		// }
		// }
	}

	/**
	 * 列赋值
	 * 
	 * @author yingwj
	 * @date 2016-9-27
	 * @param table
	 * @param str
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void editAll(KDTable table, String str, ProjWageInfo info) throws EASBizException, BOSException {
		int count = table.getRowCount();
		for (int i = 0; i < count; i++) {
			IRow row = table.getRow(i);
			row.getCell(str).setValue(info);
			if (row.getCell("nWorkDay").getValue() != null) {
				if ("traWage".equals(str)) {
					// //setWage(row, "traWage", "nWorkDay", "traWageC");
					BigDecimal oWage = info.getMoney();
					BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();
					if (oWage != null) {
						BigDecimal nBasePayBG = oWage.multiply(nWorkDay);
						row.getCell("traWageC").setValue(nBasePayBG);
					}
				}
				if ("eWage".equals(str)) {
					// //setWage(row, "eWage", "nWorkDay", "eWageC");
					BigDecimal oWage = info.getMoney();
					BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();
					if (oWage != null) {
						BigDecimal nBasePayBG = oWage.multiply(nWorkDay);
						row.getCell("eWageC").setValue(nBasePayBG);
					}
				}
				// rui_xu 2016-10-06
				if ("vaWage".equals(str)) {
					BigDecimal oWage = info.getMoney();
					BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();
					if (oWage != null) {
						BigDecimal nBasePayBG = oWage.multiply(nWorkDay);
						row.getCell("vaWageC").setValue(nBasePayBG);
					}
				}

				// checkColor();
			}
			if (row.getCell("nWorkTimes").getValue() != null) {
				if ("nWorkWage".equals(str)) {
					BigDecimal oWage = info.getMoney();
					Integer nWorkTime = (Integer) row.getCell("nWorkTimes").getValue();
					BigDecimal nWorkTimes = new BigDecimal(nWorkTime);
					if (oWage != null) {
						BigDecimal nBasePayBG = oWage.multiply(nWorkTimes);
						row.getCell("nWorkWageC").setValue(nBasePayBG);
					}
				}
			}
		}
	}

	/**
	 * 各项补贴总额赋值 f7 BigDecimal
	 */

	private void setWage(IRow row, String name, String times, String count) throws EASBizException, BOSException {
		ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell(name).getValue();
		ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
		BigDecimal oWage = owInfo.getMoney();
		BigDecimal nWorkDay = (BigDecimal) row.getCell(times).getValue();
		if (oWage != null && nWorkDay != null) {
			BigDecimal nBasePayBG = oWage.multiply(nWorkDay);
			row.getCell(count).setValue(nBasePayBG);
		}
	}

	/**
	 * 各项补贴总额赋值 F7 INT
	 */
	private void setWageInteger(IRow row, String name, String times, String count) throws EASBizException, BOSException {
		ProjWageInfo overWageInfo = (ProjWageInfo) row.getCell(name).getValue();
		ProjWageInfo owInfo = ProjWageFactory.getRemoteInstance().getProjWageInfo(new ObjectUuidPK(overWageInfo == null ? null : overWageInfo.getId()));
		BigDecimal oWage = owInfo.getMoney();
		Integer nWorkDa = (Integer) row.getCell(times).getValue();
		String nWorkDay = nWorkDa.toString();
		if (oWage != null && nWorkDay != null) {
			BigDecimal nBasePayBG = oWage.multiply(new BigDecimal(nWorkDay));
			row.getCell(count).setValue(nBasePayBG);
		}
	}

	/**
	 * BigDecimal BigDecimal
	 */
	private void setWageBigDecimal(IRow row, String name, String times, String count) throws EASBizException, BOSException {
		BigDecimal oWage = (BigDecimal) row.getCell(name).getValue();
		BigDecimal nWorkDay = (BigDecimal) row.getCell(times).getValue();
		if (oWage != null && nWorkDay != null) {
			BigDecimal nBasePayBG = oWage.multiply(nWorkDay);
			row.getCell(count).setValue(nBasePayBG);
		}
	}

	private void initBill() throws BOSException, EASBizException {
		InsurePersonEntryCollection insPersEntryCol = getAlg();// 查询参保名单中勾选参保的数据
		getAlgAll();
		// 赋值分录
		for (int i = 0; i < insPersEntryCol.size(); i++) {
			InsurePersonEntryInfo insPersEntryInfo = insPersEntryCol.get(i);
			IRow row = this.kdtEntrys.addRow();
			AdminOrgUnitInfo workPInfo = insPersEntryInfo.getWorkProgram() == null ? null : AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getWorkProgram().getId()));
			AdminOrgUnitInfo cooperation = insPersEntryInfo.getCooperation() == null ? null : AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getCooperation().getId()));
			if (insPersEntryInfo.getSecuProf() != null) {
				ProjSecuProfInfo pspInfo = ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(insPersEntryInfo.getSecuProf().getId()));
				row.getCell("secuProf").setValue(pspInfo);// 社保工种
			}
			row.getCell("projSocialNo").setValue(insPersEntryInfo.getProjSocialNo());
			row.getCell("personID").setValue(insPersEntryInfo.getPersonID());// 人员主键
			row.getCell("foriPersID").setValue(insPersEntryInfo.getForiPersID());// 外会人员编码
			row.getCell("lastName").setValue(insPersEntryInfo.getLastName());// 姓
			row.getCell("firstName").setValue(insPersEntryInfo.getFirstName());// 名
			row.getCell("sex").setValue(insPersEntryInfo.getSex());// 性别
			row.getCell("birthdate").setValue(insPersEntryInfo.getBirthdate());// 出生日期
			row.getCell("birthPlace").setValue(insPersEntryInfo.getBirthPlaceCn());// 出生地
			if (insPersEntryInfo.getCountry() != null) {
				CountryInfo country = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(insPersEntryInfo.getCountry() == null ? null : insPersEntryInfo.getCountry().getId()));
				row.getCell("nation").setValue(country);// 国家
			}
			row.getCell("MariState").setValue(insPersEntryInfo.getMaritalStatus());// 婚姻状况
			row.getCell("secuNum").setValue(insPersEntryInfo.getSecurityNo());// 社保号码
			row.getCell("CCPNo").setValue(insPersEntryInfo.getCCPNo());// CCP账户
			row.getCell("address").setValue(insPersEntryInfo.getAddress());// 家庭住址
			row.getCell("workProgram").setValue(workPInfo);// 工作项目
			row.getCell("cooperation").setValue(cooperation);// 合作单位
			row.getCell("coopCode").setValue(insPersEntryInfo.getCooperationId());// 合作单位代码
			row.getCell("apprTime").setValue(insPersEntryInfo.getApproachTime());// 进场日期
			row.getCell("secuProj").setValue(insPersEntryInfo.getSecuProj());// 社保
			// （
			// 证件
			// ）
			// 项目
			row.getCell("startDate").setValue(insPersEntryInfo.getApproachTime());// 注册日期
			row.getCell("endDate").setValue(insPersEntryInfo.getEndDate());// 离场日期
			row.getCell("nBasePay").setValue(insPersEntryInfo.getNBasePay());// 基本工资
			// rui_xu 2016-9-29
			row.getCell("nSeniority").setValue(insPersEntryInfo.getNSeniority());// 工龄
			row.getCell("seniPay").setValue(insPersEntryInfo.getSeniPay());// 工龄工资
		}
	}

	/**
	 * 查询参保名单中勾选参保的数据
	 * 
	 * @throws BOSException
	 */
	private InsurePersonEntryCollection getAlg() throws BOSException {
		AdminOrgUnitInfo adminInfo = (AdminOrgUnitInfo) this.prmtpermProj.getValue();
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("join", true));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", adminInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("*");
		view.setSelector(sic);
		view.setFilter(filter);
		InsurePersonEntryCollection insPersCol = InsurePersonEntryFactory.getRemoteInstance().getInsurePersonEntryCollection(view);
		if (insPersCol.size() == 0) {
			MsgBox.showInfo("所选项目暂无参保人员，无法建立考勤表！");
			abort();
		}
		return insPersCol;
	}

	private void getAlgAll() throws BOSException {
		AdminOrgUnitInfo adminInfo = (AdminOrgUnitInfo) this.prmtpermProj.getValue();
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", adminInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("entrys.*");
		view.setSelector(sic);
		InsurePersonEntryCollection insPersCol = InsurePersonEntryFactory.getRemoteInstance().getInsurePersonEntryCollection(view);
		if (insPersCol == null && insPersCol.size() == 0) {
			MsgBox.showInfo("所选项目暂无参保人员，无法建立考勤表！");
			abort();
		}
		this.txtshCount.setValue(insPersCol.size());
	}

	/**
	 * output class constructor
	 */
	public CheckCountEditUI() throws Exception {
		super();
	}

	/**
	 * output loadFields method
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void loadFields() {
		super.loadFields();
		// checkColor();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception {
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception {
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception {
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception {
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionOnLoad_actionPerformed
	 */
	public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception {
		super.actionOnLoad_actionPerformed(e);
	}

	/**
	 * output actionSendMessage_actionPerformed
	 */
	public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendMessage_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e) throws Exception {
		super.actionCalculator_actionPerformed(e);
	}

	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception {
		super.actionExport_actionPerformed(e);
	}

	/**
	 * output actionExportSelected_actionPerformed
	 */
	public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception {
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception {
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception {
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSelectedSave_actionPerformed(e);
	}

	/**
	 * output actionKnowStore_actionPerformed
	 */
	public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception {
		super.actionKnowStore_actionPerformed(e);
	}

	/**
	 * output actionAnswer_actionPerformed
	 */
	public void actionAnswer_actionPerformed(ActionEvent e) throws Exception {
		super.actionAnswer_actionPerformed(e);
	}

	/**
	 * output actionRemoteAssist_actionPerformed
	 */
	public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemoteAssist_actionPerformed(e);
	}

	/**
	 * output actionPopupCopy_actionPerformed
	 */
	public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupCopy_actionPerformed(e);
	}

	/**
	 * output actionHTMLForMail_actionPerformed
	 */
	public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception {
		super.actionToolBarCustom_actionPerformed(e);
	}

	/**
	 * output actionCloudFeed_actionPerformed
	 */
	public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudFeed_actionPerformed(e);
	}

	/**
	 * output actionCloudShare_actionPerformed
	 */
	public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionXunTongFeed_actionPerformed(e);
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionSave_actionPerformed(e);
		checkDay();
		filterProf();
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		filterProf();
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		super.doBeforeSave(e);

		// 同项目同期间不可重复添加
		if (this.prmtmonthYearr.getValue() != null && this.prmtpermProj.getValue() != null) {
			checkSame();
		}
		checkIdNumAndPassp();
	}

	protected void checkDay() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("nWorkTimes").getValue() == null) {
				row.getCell("nWorkTimes").setValue(0);
			}
			Integer nWorkTime = (Integer) row.getCell("nWorkTimes").getValue();// nWorkWageC
			BigDecimal nWorkTimes = new BigDecimal(nWorkTime);
			ProjWageInfo nWorkWages = (ProjWageInfo) row.getCell("nWorkWage").getValue();
			if (row.getCell("nWorkWage").getValue() == null) {
				row.getCell("nWorkWage").setValue(BigDecimal.ZERO);
				BigDecimal nWorkWage = (BigDecimal) row.getCell("nWorkWage").getValue();
				row.getCell("nWorkWageC").setValue(nWorkTimes.multiply(nWorkWage));
			} else {
				BigDecimal nWorkWage = nWorkWages.getMoney();
				row.getCell("nWorkWageC").setValue(nWorkTimes.multiply(nWorkWage));
			}

		}
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		// 同项目同期间不可重复添加
		if (this.prmtmonthYearr.getValue() != null && this.prmtpermProj.getValue() != null) {
			checkSame();
		}
		checkEmpty();
		checkIdNumAndPassp();
	}

	public void checkIdNumAndPassp() {
		int rowCount = kdtEntrys.getRowCount();
		Set set = new HashSet();
		Set pass = new HashSet();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			String lastName = (String) row.getCell("lastName").getValue();
			String firstName = (String) row.getCell("firstName").getValue();
			String secuNum = (String) row.getCell("secuNum").getValue();
			String ccpNo = (String) row.getCell("CCPNo").getValue();
			// String name=(String) row.getCell("name").getValue();
			if (secuNum != null) {
				// 校验是否存在集合中,如果存在，删除集合中的这条数据，返回true
				if (set.remove(secuNum)) {
					MsgBox.showInfo(lastName + firstName + "行的社保号【" + secuNum + "】已存在此社保号数据，请重新输入！");
					abort();
				}
			}
			if (ccpNo != null) {
				// 校验是否存在集合中,如果存在，删除集合中的这条数据，返回true
				if (pass.remove(ccpNo)) {
					MsgBox.showInfo(lastName + firstName + "行的CCP账号【" + ccpNo + "】已存在此CCP账号数据，请重新输入！");
					abort();
				}
			}
			set.add(secuNum);
			pass.add(ccpNo);
		}
	}

	private void checkSame() throws BOSException {
		PeriodInfo perInfo = (PeriodInfo) this.prmtmonthYearr.getValue();
		AdminOrgUnitInfo permInfo = (AdminOrgUnitInfo) this.prmtpermProj.getValue();
		if (perInfo != null) {
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("parent.permProj.name", permInfo.getName()));
			filter.getFilterItems().add(new FilterItemInfo("parent.monthYearr.number", perInfo.getNumber()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			CheckCountEntryCollection checkCol = CheckCountEntryFactory.getRemoteInstance().getCheckCountEntryCollection(view);
			if (checkCol.size() > 1) {
				MsgBox.showInfo("该项目所选年月已有考勤数据，不允许重复添加！");
				this.prmtmonthYearr.setValue(null);
				abort();
			}
		}

	}

	private void checkEmpty() {
		Object year = (Object) this.prmtmonthYearr.getValue();
		if (year == null) {
			MsgBox.showInfo("所填单据年月为空，无法提交，请填入年月！");
			this.abort();
		}
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			BigDecimal nWorkDays = (BigDecimal) row.getCell("nWorkDay").getValue();
			BigDecimal day = new BigDecimal(22);
			String lastName = (String) row.getCell("lastName").getValue();
			String firstName = (String) row.getCell("firstName").getValue();
			if (nWorkDays == null) {
				MsgBox.showInfo(lastName + firstName + "的出勤天数为空，无法提交。请重新输入！");
				this.abort();
			} else {
				if (nWorkDays.compareTo(day) > 0) {
					MsgBox.showInfo(lastName + firstName + "的出勤天数大于22天，无法提交。请重新输入！");
					this.abort();
				}
			}
		}

	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionFirst_actionPerformed
	 */
	public void actionFirst_actionPerformed(ActionEvent e) throws Exception {
		super.actionFirst_actionPerformed(e);
	}

	/**
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception {
		super.actionPre_actionPerformed(e);
	}

	/**
	 * output actionNext_actionPerformed
	 */
	public void actionNext_actionPerformed(ActionEvent e) throws Exception {
		super.actionNext_actionPerformed(e);
	}

	/**
	 * output actionLast_actionPerformed
	 */
	public void actionLast_actionPerformed(ActionEvent e) throws Exception {
		super.actionLast_actionPerformed(e);
	}

	/**
	 * output actionPrint_actionPerformed
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output actionAttachment_actionPerformed
	 */
	public void actionAttachment_actionPerformed(ActionEvent e) throws Exception {
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmitOption_actionPerformed(e);
	}

	/**
	 * output actionReset_actionPerformed
	 */
	public void actionReset_actionPerformed(ActionEvent e) throws Exception {
		super.actionReset_actionPerformed(e);
	}

	/**
	 * output actionMsgFormat_actionPerformed
	 */
	public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception {
		super.actionMsgFormat_actionPerformed(e);
	}

	/**
	 * output actionAddLine_actionPerformed
	 */
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddLine_actionPerformed(e);
	}

	/**
	 * output actionCopyLine_actionPerformed
	 */
	public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyLine_actionPerformed(e);
	}

	/**
	 * output actionInsertLine_actionPerformed
	 */
	public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionInsertLine_actionPerformed(e);
	}

	/**
	 * output actionRemoveLine_actionPerformed
	 */
	public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemoveLine_actionPerformed(e);
	}

	/**
	 * output actionCreateFrom_actionPerformed
	 */
	public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception {
		super.actionCreateFrom_actionPerformed(e);
	}

	/**
	 * output actionCopyFrom_actionPerformed
	 */
	public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyFrom_actionPerformed(e);
	}

	/**
	 * output actionAuditResult_actionPerformed
	 */
	public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception {
		super.actionAuditResult_actionPerformed(e);
	}

	/**
	 * output actionTraceUp_actionPerformed
	 */
	public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceUp_actionPerformed(e);
	}

	/**
	 * output actionTraceDown_actionPerformed
	 */
	public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceDown_actionPerformed(e);
	}

	/**
	 * output actionViewSubmitProccess_actionPerformed
	 */
	public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewSubmitProccess_actionPerformed(e);
	}

	/**
	 * output actionViewDoProccess_actionPerformed
	 */
	public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewDoProccess_actionPerformed(e);
	}

	/**
	 * output actionMultiapprove_actionPerformed
	 */
	public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception {
		super.actionMultiapprove_actionPerformed(e);
	}

	/**
	 * output actionNextPerson_actionPerformed
	 */
	public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception {
		super.actionNextPerson_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception {
		super.actionStartWorkFlow_actionPerformed(e);
	}

	/**
	 * output actionVoucher_actionPerformed
	 */
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		super.actionVoucher_actionPerformed(e);
	}

	/**
	 * output actionDelVoucher_actionPerformed
	 */
	public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception {
		super.actionDelVoucher_actionPerformed(e);
	}

	/**
	 * output actionWorkFlowG_actionPerformed
	 */
	public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception {
		super.actionWorkFlowG_actionPerformed(e);
	}

	/**
	 * output actionCreateTo_actionPerformed
	 */
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		super.actionCreateTo_actionPerformed(e);
	}

	/**
	 * output actionSendingMessage_actionPerformed
	 */
	public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendingMessage_actionPerformed(e);
	}

	/**
	 * output actionSignature_actionPerformed
	 */
	public void actionSignature_actionPerformed(ActionEvent e) throws Exception {
		super.actionSignature_actionPerformed(e);
	}

	/**
	 * output actionWorkflowList_actionPerformed
	 */
	public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception {
		super.actionWorkflowList_actionPerformed(e);
	}

	/**
	 * output actionViewSignature_actionPerformed
	 */
	public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewSignature_actionPerformed(e);
	}

	/**
	 * output actionSendMail_actionPerformed
	 */
	public void actionSendMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendMail_actionPerformed(e);
	}

	/**
	 * output actionLocate_actionPerformed
	 */
	public void actionLocate_actionPerformed(ActionEvent e) throws Exception {
		super.actionLocate_actionPerformed(e);
	}

	/**
	 * output actionNumberSign_actionPerformed
	 */
	public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception {
		super.actionNumberSign_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.zjlw.social.CheckCountFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table) {

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.zjlw.social.CheckCountInfo objectValue = new com.kingdee.eas.zjlw.social.CheckCountInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		FullOrgUnitInfo fullInfo = (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
		try {
			if (fullInfo == null) {
				MsgBox.showInfo("请选择需要建立考勤表的项目！");
				abort();
			}
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setPermProj(adminInfo);
			objectValue.setId(BOSUuid.create(objectValue.getBOSType()));
			objectValue = (CheckCountInfo) CheckCountFactory.getRemoteInstance().initBill(objectValue);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return objectValue;
	}

}