/**
 * output package name
 */
package com.kingdee.eas.zjlw.personmess.client;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Parent;

import com.ibm.db2.jcc.a.f;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CountryInfo;

import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.common.EASBizException;

import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.mayrStatEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntry;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;

/**
 * output class name
 */
public class WorkVisaEditUI extends AbstractWorkVisaEditUI {
	private static final Logger logger = CoreUIObject.getLogger(WorkVisaEditUI.class);
	public static Map cityCodes = new HashMap();// 省份代码
	public static Map cityCodesFrance = new HashMap();// 省份代码法文

	/**
	 * output class constructor
	 */
	public WorkVisaEditUI() throws Exception {
		super();
	}

	/**
	 * output loadFields method
	 */
	public void loadFields() {
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	public void onLoad() throws Exception {
		super.onLoad();
		setButtonStatus();
		// 省份代码集合
		cityCodes.put("11", "北京");
		cityCodes.put("12", "天津");
		cityCodes.put("13", "河北");
		cityCodes.put("14", "山西");
		cityCodes.put("15", "内蒙古");
		cityCodes.put("21", "辽宁");
		cityCodes.put("22", "吉林");
		cityCodes.put("23", "黑龙江");
		cityCodes.put("31", "上海");
		cityCodes.put("32", "江苏");
		cityCodes.put("33", "浙江");
		cityCodes.put("34", "安徽");
		cityCodes.put("35", "福建");
		cityCodes.put("36", "江西");
		cityCodes.put("37", "山东");
		cityCodes.put("41", "河南");
		cityCodes.put("42", "湖北");
		cityCodes.put("43", "湖南");
		cityCodes.put("44", "广东");
		cityCodes.put("45", "广西");
		cityCodes.put("46", "海南");
		cityCodes.put("50", "重庆");
		cityCodes.put("51", "四川");
		cityCodes.put("52", "贵州");
		cityCodes.put("53", "云南");
		cityCodes.put("54", "西藏");
		cityCodes.put("61", "陕西");
		cityCodes.put("62", "甘肃");
		cityCodes.put("63", "青海");
		cityCodes.put("64", "宁夏");
		cityCodes.put("65", "新疆");
		cityCodes.put("71", "台湾");
		cityCodes.put("81", "香港");
		cityCodes.put("82", "澳门");
		cityCodes.put("91", "国外");
		// 省份代码法文集合
		cityCodesFrance.put("11", "BEIJING ");
		cityCodesFrance.put("12", "TIANJING");
		cityCodesFrance.put("13", "HEBEI");
		cityCodesFrance.put("14", "SHANXI");
		cityCodesFrance.put("15", "NEIMONGOL");
		cityCodesFrance.put("21", "LIAONING");
		cityCodesFrance.put("22", "JILIN");
		cityCodesFrance.put("23", "HEILONGJIANG");
		cityCodesFrance.put("31", "SHANGHAI");
		cityCodesFrance.put("32", "JIANGSU");
		cityCodesFrance.put("33", "ZHEJIANG");
		cityCodesFrance.put("34", "ANHUI");
		cityCodesFrance.put("35", "FUJIAN");
		cityCodesFrance.put("36", "JIANGXI");
		cityCodesFrance.put("37", "SHANDONG");
		cityCodesFrance.put("41", "HENAN");
		cityCodesFrance.put("42", "HUBEI");
		cityCodesFrance.put("43", "HUNAN");
		cityCodesFrance.put("44", "GUANGDONG");
		cityCodesFrance.put("45", "GUANGXI");
		cityCodesFrance.put("46", "HAINAN");
		cityCodesFrance.put("50", "CHONGQING");
		cityCodesFrance.put("51", "SICHUAN");
		cityCodesFrance.put("52", "GUIZHOU");
		cityCodesFrance.put("53", "YUNNAN");
		cityCodesFrance.put("54", "TIBET");
		cityCodesFrance.put("61", "SHAANXI");
		cityCodesFrance.put("62", "GANSU");
		cityCodesFrance.put("63", "QINGHAI");
		cityCodesFrance.put("64", "NINGXIA");
		cityCodesFrance.put("65", "XINJIANG");
		cityCodesFrance.put("71", "TAIWAN");
		cityCodesFrance.put("81", "HONGKONG");
		cityCodesFrance.put("82", "MACAO");
		cityCodesFrance.put("91", "ABROAD");
		kdtEntrys.getColumn("workSuffer").getStyleAttributes().setLocked(true);// 工作经验
		if (getOprtState().equals("EDIT")) {
			checkNameCity();
		}
		// 表体指标项目、工作项目数据过滤
		KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
		settNumPromptBox.setEditable(true);
		settNumPromptBox.setDisplayFormat("$name$");
		settNumPromptBox.setEditFormat("$number$");
		settNumPromptBox.setCommitFormat("$number$");
		settNumPromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("number", "H%", CompareType.NOTLIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("number", "fb001", CompareType.NOTEQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number", "CSCEC", CompareType.NOTEQUALS));
		evi.setFilter(filterInfo);
		settNumPromptBox.setEntityViewInfo(evi);
		kdtEntrys.getColumn("permitProgram").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
		kdtEntrys.getColumn("workProgram").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
		// 合作单位
		KDBizPromptBox cooperationBox = new KDBizPromptBox();
		cooperationBox.setEditable(true);
		cooperationBox.setDisplayFormat("$name$");
		cooperationBox.setEditFormat("$number$");
		cooperationBox.setCommitFormat("$number$");
		cooperationBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
		evi = new EntityViewInfo();
		filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("number", "H%", CompareType.LIKE));
		// filterInfo.getFilterItems().add(new
		// FilterItemInfo("number","CSCEC",CompareType.NOTEQUALS));
		evi.setFilter(filterInfo);
		cooperationBox.setEntityViewInfo(evi);
		kdtEntrys.getColumn("cooperation").setEditor(new KDTDefaultCellEditor(cooperationBox));
		// 表头指标项目赋值表体指标项目 ywj 2016-10-2\
		// 分录指标项目是否有值
		if (this.kdtEntrys.getRowCount3() > 0) {
			IRow row0 = this.kdtEntrys.getRow(0);
			if (!(row0.getCell("permitProgram") != null && row0.getCell("permitProgram").getValue() != null)) {
				// 获取表头指标项目的值
				AdminOrgUnitInfo proCom = (AdminOrgUnitInfo) prmtproCom.getValue();
				AdminOrgUnitInfo proComInfo = new AdminOrgUnitInfo();
				if (proCom != null) {
					proComInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
				}
				// 循环分录
				int count = this.kdtEntrys.getRowCount3();
				for (int i = 0; i < count; i++) {
					IRow row = this.kdtEntrys.getRow(i);
					row.getCell("permitProgram").setValue(proComInfo);// 单行赋值
				}
			}

			billSate.setEditable(true);
			this.contbillSate.setEnabled(true);
		}
		// String number = "";
		// number = txtNumber.getText();
		// //循环分录
		// int count = this.kdtEntrys.getRowCount3();
		// for (int i = 0; i < count; i++) {
		// IRow row = this.kdtEntrys.getRow(i);
		// row.getCell("etyNumber").setValue(number);
		// }
	};

	/**
	 * 表头反签批次号值改变事件
	 * 
	 * @author yingwj
	 * @date 2016-10-9 自动赋值表体反签批次号
	 */
	protected void txtNumber_propertyChange(PropertyChangeEvent e) throws Exception {
		String number = txtNumber.getText().toString();
		// 循环分录
		int count = this.kdtEntrys.getRowCount3();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			row.getCell("etyNumber").setValue(number);
		}
		super.txtNumber_propertyChange(e);
	}

	protected void checkNameCity() throws ParseException {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Date newDate = new Date();
			ProvinceInfo passportCity = (ProvinceInfo) row.getCell("passportCity").getValue();
			if (passportCity != null) {
				row.getCell("passportCityF").setValue(passportCity.getDescription());
			}
			if (row.getCell("idNum").getValue() != null) {
				String idNum = row.getCell("idNum").getValue().toString();
				String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";// 十八位身份证格式
				boolean tf = idNum.matches(regex);
				if (tf) {
					if (row.getCell("birthdate").getValue() == null) {
						// 身份证号获取出生日期、性别、省份
						String yy1 = idNum.substring(6, 10);// 出生的年份
						String mm1 = idNum.substring(10, 12);// 出生的月份
						String dd1 = idNum.substring(12, 14);// 出生的日期
						String sex = idNum.substring(16, 17);// 性别
						String birthday = yy1.concat("-").concat(mm1).concat("-").concat(dd1);
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(birthday);
						row.getCell("birthdate").setValue(date);
						if (date != null) {
							long time = ((newDate.getTime() - date.getTime()) / 86400000 / 360) - 18;
							row.getCell("workSuffer").setValue(time);
						}
						if (Integer.parseInt(sex) % 2 == 0) {
							row.getCell("sex").setValue(Genders.Female);
						} else {
							row.getCell("sex").setValue(Genders.Male);
						}
						row.getCell("birthPlaceCn").setValue(cityCodes.get(idNum.substring(0, 2)));// 出生地中文
						row.getCell("birthPlaceFr").setValue(cityCodesFrance.get(idNum.substring(0, 2)));// 出生地法文
					}
				}
			}
			if (row.getCell("idNum").getValue() == null) {
				Date birthday = (Date) row.getCell("birthdate").getValue();
				if (birthday != null) {
					long time = ((newDate.getTime() - birthday.getTime()) / 86400000 / 360) - 18;
					row.getCell("workSuffer").setValue(time);
				}
			}
			// 婚姻状态
			if (row.getCell("MaritalStatus").getValue() != null && row.getCell("MaritalStatus").getValue().equals(mayrStatEnum.married)) {
				row.getCell("coupleName").getStyleAttributes().setLocked(false);// 配偶姓名
				row.getCell("coupleNameAlphabet").getStyleAttributes().setLocked(false);// 配偶姓名拼音
				row.getCell("coupleBirthDate").getStyleAttributes().setLocked(false);// 配偶出生日期
				row.getCell("coupleBirthPlace").getStyleAttributes().setLocked(false);// 配偶出生地
				row.getCell("coupleWorkPlace").getStyleAttributes().setLocked(false);// 配偶工作单位
				row.getCell("coupleNational").getStyleAttributes().setLocked(false);// 配偶国籍
				row.getCell("couplePermitPro").getStyleAttributes().setLocked(false);// 配偶劳动证证件工种
				// （
				// 即返签指标工种
				// ）
				row.getCell("couplePermitNO").getStyleAttributes().setLocked(false);// 配偶劳动证编号
			} else {
				row.getCell("coupleName").getStyleAttributes().setLocked(true);// 配偶姓名
				row.getCell("coupleNameAlphabet").getStyleAttributes().setLocked(true);// 配偶姓名拼音
				row.getCell("coupleBirthDate").getStyleAttributes().setLocked(true);// 配偶出生日期
				row.getCell("coupleBirthPlace").getStyleAttributes().setLocked(true);// 配偶出生地
				row.getCell("coupleWorkPlace").getStyleAttributes().setLocked(true);// 配偶工作单位
				row.getCell("coupleNational").getStyleAttributes().setLocked(true);// 配偶国籍
				row.getCell("couplePermitPro").getStyleAttributes().setLocked(true);// 配偶劳动证证件工种
				// （
				// 即返签指标工种
				// ）
				row.getCell("couplePermitNO").getStyleAttributes().setLocked(true);// 配偶劳动证编号
				row.getCell("coupleName").setValue(null);
				row.getCell("coupleNameAlphabet").setValue(null);
				row.getCell("coupleBirthDate").setValue(null);
				row.getCell("coupleBirthPlace").setValue(null);
				row.getCell("coupleWorkPlace").setValue(null);
				row.getCell("coupleNational").setValue(null);
				row.getCell("couplePermitPro").setValue(null);
				row.getCell("couplePermitNO").setValue(null);
			}
		}
	}

	protected void setButtonStatus() {
		WorkVisaInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
			bill = (WorkVisaInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate()) || BillStateEnum.CHECKING.equals(bill.getBillSate())) {// (
					// BillStateEnum
					// .
					// SIGNE
					// .
					// equals
					// (
					// bill
					// .
					// getBillSate
					// (
					// )
					// )
					// )
					this.actionUnAudit.setEnabled(true);
					this.actionAudit.setVisible(false);
					this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionUnAudit.setVisible(false);
					this.actionUnAudit.setEnabled(false);
					this.actionAudit.setVisible(true);
					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (WorkVisaInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}
			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}
		if (this.editData != null) {
			bill = (WorkVisaInfo) this.editData;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		nowDate = sdf.parse(sdf.format(nowDate));
		if ("idNum".equals(key)) {
			if (row.getCell("idNum").getValue() != null) {
				String idNum = row.getCell("idNum").getValue().toString();
				String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";// 十八位身份证格式
				boolean tf = idNum.matches(regex);
				if (!tf) {
					MsgBox.showInfo("身份证格式错误，请重新输入！");
					row.getCell("idNum").setValue(null);
					this.abort();
				}
				// 不允许重复填写
				int rowCount = kdtEntrys.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					IRow row1 = kdtEntrys.getRow(i);
					if (i != rowIndex) {
						if (row1.getCell("idNum").getValue() != null) {
							String idNum2 = row1.getCell("idNum").getValue().toString();
							if (row.getCell("idNum").getValue() != null) {
								String idNum1 = row.getCell("idNum").getValue().toString();
								if (idNum2.equals(idNum1)) {
									MsgBox.showInfo("已存在此身份证号数据，请重新输入！");
									row.getCell("idNum").setValue(null);
									this.abort();
								}
							}
						}
					}
				}
				// 身份证号获取出生日期、性别、省份
				String yy1 = idNum.substring(6, 10);// 出生的年份
				String mm1 = idNum.substring(10, 12);// 出生的月份
				String dd1 = idNum.substring(12, 14);// 出生的日期
				String sex = idNum.substring(16, 17);// 性别
				String birthday = yy1.concat("-").concat(mm1).concat("-").concat(dd1);
				Date date = sdf.parse(birthday);
				row.getCell("birthdate").setValue(date);
				long time = ((nowDate.getTime() - date.getTime()) / 86400000 / 360) - 18;
				row.getCell("workSuffer").setValue(time);
				if (Integer.parseInt(sex) % 2 == 0) {
					row.getCell("sex").setValue(Genders.Female);
				} else {
					row.getCell("sex").setValue(Genders.Male);
				}
				row.getCell("birthPlaceCn").setValue(cityCodes.get(idNum.substring(0, 2)));// 出生地中文
				row.getCell("birthPlaceFr").setValue(cityCodesFrance.get(idNum.substring(0, 2)));// 出生地法文
			} else {
				row.getCell("birthdate").setValue(null);
				row.getCell("birthPlaceCn").setValue(null);
				row.getCell("birthPlaceFr").setValue(null);
			}
		}
		// 不能选择同一护照号
		if ("passportNo".equals(key)) {
			int rowCount = kdtEntrys.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				IRow row1 = kdtEntrys.getRow(i);
				if (i != rowIndex) {
					if (row1.getCell("passportNo").getValue() != null) {
						String passportNo = row1.getCell("passportNo").getValue().toString();
						if (row.getCell("passportNo").getValue() != null) {
							String passportNo1 = row.getCell("passportNo").getValue().toString();
							if (passportNo.equals(passportNo1)) {
								MsgBox.showInfo("已存在此护照号数据，请重新输入！");
								row.getCell("passportNo").setValue(null);
								this.abort();
							}
						}
					}
				}
			}
		}
		if ("birthdate".equals(key)) {
			if (row.getCell("birthdate").getValue() != null) {
				Date birthdate = (Date) row.getCell("birthdate").getValue();
				birthdate = sdf.parse(sdf.format(birthdate));
				long time = ((nowDate.getTime() - birthdate.getTime()) / 86400000 / 360) - 18;
				row.getCell("workSuffer").setValue(time);
			} else {
				row.getCell("workSuffer").setValue(null);
			}
		}
		if ("MaritalStatus".equals(key)) {
			if (row.getCell("MaritalStatus").getValue() != null && row.getCell("MaritalStatus").getValue().equals(mayrStatEnum.married)) {
				row.getCell("coupleName").getStyleAttributes().setLocked(false);// 配偶姓名
				row.getCell("coupleNameAlphabet").getStyleAttributes().setLocked(false);// 配偶姓名拼音
				row.getCell("coupleBirthDate").getStyleAttributes().setLocked(false);// 配偶出生日期
				row.getCell("coupleBirthPlace").getStyleAttributes().setLocked(false);// 配偶出生地
				row.getCell("coupleWorkPlace").getStyleAttributes().setLocked(false);// 配偶工作单位
				row.getCell("coupleNational").getStyleAttributes().setLocked(false);// 配偶国籍
				row.getCell("couplePermitPro").getStyleAttributes().setLocked(false);// 配偶劳动证证件工种
				// （
				// 即返签指标工种
				// ）
				row.getCell("couplePermitNO").getStyleAttributes().setLocked(false);// 配偶劳动证编号
			} else {
				row.getCell("coupleName").getStyleAttributes().setLocked(true);// 配偶姓名
				row.getCell("coupleNameAlphabet").getStyleAttributes().setLocked(true);// 配偶姓名拼音
				row.getCell("coupleBirthDate").getStyleAttributes().setLocked(true);// 配偶出生日期
				row.getCell("coupleBirthPlace").getStyleAttributes().setLocked(true);// 配偶出生地
				row.getCell("coupleWorkPlace").getStyleAttributes().setLocked(true);// 配偶工作单位
				row.getCell("coupleNational").getStyleAttributes().setLocked(true);// 配偶国籍
				row.getCell("couplePermitPro").getStyleAttributes().setLocked(true);// 配偶劳动证证件工种
				// （
				// 即返签指标工种
				// ）
				row.getCell("couplePermitNO").getStyleAttributes().setLocked(true);// 配偶劳动证编号

				row.getCell("coupleName").setValue(null);
				row.getCell("coupleNameAlphabet").setValue(null);
				row.getCell("coupleBirthDate").setValue(null);
				row.getCell("coupleBirthPlace").setValue(null);
				row.getCell("coupleWorkPlace").setValue(null);
				row.getCell("coupleNational").setValue(null);
				row.getCell("couplePermitPro").setValue(null);
				row.getCell("couplePermitNO").setValue(null);
			}
		}

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
		// 只有暂存状态可以保存
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			WorkVisaInfo fiInfo = WorkVisaFactory.getRemoteInstance().getWorkVisaInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复保存！");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		// 循环分录
		int count = this.kdtEntrys.getRowCount3();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			row.getCell("personID").setValue((row.getCell("id").getValue()).toString() + "kingdee");// 单行赋值
		}
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */

	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	// 提交校验
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		actionSave_actionPerformed(e);
		// 只有暂存或者已提交状态可以提交
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			WorkVisaInfo fiInfo = WorkVisaFactory.getRemoteInstance().getWorkVisaInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复提交！");
				abort();
			}
		}
		// 提交前校验是否存在审核通过状态的批次号 ywj 2017-11-14 BEGIN
		checkAuditedNum();
		// 提交前校验是否存在审核通过状态的批次号 ywj 2017-11-14 END
		checkEmpty();// 不为空校验
		checkIdNumAndPassp();// 提交同一单据重复校验
		checkProject();// 指标项目到期日期校验
		super.doBeforeSubmit(e);

		// checkIdNum();// 身份证格式校验
		// CheckSubmit();// 考试成绩.出国培训提交校验
		// checkDate();// 时间校验
		// checkPersion();//提交重复校验
		// CheckBlackList();// 不合格人员校
		// checkPersionHistory();// 人员历史信息校验
		// CheckPmtProfC();//指标工种校验暂时去掉
	}

	/**
	 * 【校验是否存在审核通过状态的批次号】校验已有处于审核通过状态的单据有相同的批次号，不分组织。
	 * 
	 * @author ywj
	 * @throws BOSException
	 * @date 2017-11-14
	 */
	private void checkAuditedNum() throws BOSException {
		String newNumber = this.txtNumber.getText();// 本单据准备新增的批次号
		String id = this.editData.getId().toString();// 本单据id
		// 查询所有的审核通过状态的workVisa的批次号
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("billSate", BillStateEnum.CHECKED));
		filter.getFilterItems().add(new FilterItemInfo("billSate", BillStateEnum.CHECKING));
		filter.getFilterItems().add(new FilterItemInfo("billSate", BillStateEnum.SUBMIT));
		filter.getFilterItems().add(new FilterItemInfo("number", newNumber));
		filter.getFilterItems().add(new FilterItemInfo("id", id, CompareType.NOTEQUALS));
		filter.setMaskString("(#0 OR #1 OR #2) AND #3 AND #4");
		sic.add("id");
		sic.add("name");
		sic.add("number");
		view.setSelector(sic);
		view.setFilter(filter);
		WorkVisaCollection col = WorkVisaFactory.getRemoteInstance().getWorkVisaCollection(view);
		if (col != null && col.size() > 0) {
			MsgBox.showInfo(newNumber + "批次号已存在，不允许重复提交！");
			abort();
		}
	}

	// 提交同一单据重复校验
	public void checkIdNumAndPassp() {
		int rowCount = kdtEntrys.getRowCount();
		Set set = new HashSet();
		Set pass = new HashSet();

		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			String idNum = (String) row.getCell("idNum").getValue();
			String passportNo = (String) row.getCell("passportNo").getValue();
			// String name=(String) row.getCell("name").getValue();
			if (idNum != null) {
				// 校验是否存在集合中,如果存在，删除集合中的这条数据，返回true
				if (set.remove(idNum)) {
					MsgBox.showInfo("身份证号【" + idNum + "】已存在此身份证号数据，请重新输入！");
					abort();
				}
			}
			if (passportNo != null) {
				// 校验是否存在集合中,如果存在，删除集合中的这条数据，返回true
				if (pass.remove(passportNo)) {
					MsgBox.showInfo("护照号【" + passportNo + "】已存在此护照号数据，请重新输入！");
					abort();
				}
			}
			set.add(idNum);
			pass.add(passportNo);
		}
	}

	// 不为空校验 2017-2-10 zxh 表头指标项目为空则无法提交单据。
	protected void checkEmpty() throws BOSException, ParseException, EASBizException {
		int rowCount = kdtEntrys.getRowCount();
		WorkVisaInfo wkInfo = (WorkVisaInfo) this.editData;
		if (wkInfo != null) {
			if (wkInfo.getProCom() == null) {
				MsgBox.showInfo("表头指标项目为空，不允许提交，请重新输入！");
				abort();
			}
		}

		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			if (row.getCell("name").getValue() == null || "".equals(row.getCell("name").getValue())) {
				MsgBox.showInfo("中文姓名为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("sex").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】性别为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("birthdate").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】出生日期为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("birthPlaceFr").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】出生地拼音 为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("national").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】国籍为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("passportNo").getValue() == null || "".equals(row.getCell("passportNo").getValue())) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照号码为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("passportIssueDate").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照签发日期为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("passportExpireDate").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照到期日期为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("passportAgence").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照发放机构为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("passportCity").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照签发地(中文)为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("acProf").getValue() == null || "".equals(row.getCell("acProf").getValue())) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】实际专业或工种为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("permitProgram").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】指标项目为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("workProgram").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】工作项目为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("cooperation").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】合作单位为空，无法提交，请重新填入！");
				this.abort();
			} else {
				AdminOrgUnitInfo ccop = (AdminOrgUnitInfo) row.getCell("cooperation").getValue();
				AdminOrgUnitInfo coopInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ccop.getId()));
				String numFir = coopInfo.getNumber().substring(0, 1);
				if (!"H".equals(numFir)) {
					MsgBox.showInfo("合作单位填写错误，请重新填写！");
					abort();
				}
			}
			if (row.getCell("MaritalStatus").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】婚姻状态为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("MaritalStatus").getValue().equals(mayrStatEnum.married)) {
				if (row.getCell("coupleName").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶姓名为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("coupleNameAlphabet").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶姓名拼音为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("coupleNational").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶国籍为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("coupleBirthDate").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶出生日期为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("coupleBirthPlace").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶出生地为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("coupleWorkPlace").getValue() == null) {
					MsgBox.showInfo("【" + row.getCell("name").getValue() + "】的配偶的工作单位为空，无法提交，请重新填入！");
					this.abort();
				}
			}
			if (row.getCell("contactway").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】国内联系方式为空，无法提交，请重新填入！");
				this.abort();
			}
			if (row.getCell("residence").getValue() == null) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】国内联系详细地址为空，无法提交，请重新填入！");
				this.abort();
			}
			checkIdNum(row);// 身份证格式校验
			CheckSubmit(row);// 考试成绩.出国培训提交校验
			checkDate(row);// 时间校验
			checkPersion(row);// 提交重复校验
			CheckBlackList(row);// 不合格人员校
			checkPersionHistory(row);// 人员历史信息校验

			// checkProject(row);//指标项目到期日期校验
		}
	}

	// 身份证号校验
	protected void checkIdNum(IRow row) {
		// int rowCount=kdtEntrys.getRowCount();
		// for(int i=0;i<rowCount;i++){
		// IRow row=kdtEntrys.getRow(i);
		String name = (String) row.getCell("name").getValue();
		String idNum = (String) row.getCell("idNum").getValue();
		String passportNo = (String) row.getCell("passportNo").getValue();
		CountryInfo coInfo = (CountryInfo) row.getCell("national").getValue();
		String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";// 十八位身份证格式
		if (coInfo == null) {
			MsgBox.showInfo("【" + name + "】的国籍为空，请重新填入！");
			this.abort();
		} else {
			if ("C01".equals(coInfo.getNumber())) {
				// String regex=
				// "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$"
				// ;//十五位身份证格式
				if (idNum == null || "".equals(idNum)) {
					MsgBox.showInfo("【" + name + "】的国籍是【" + coInfo.getName() + "】请填入身份证号码！");
					this.abort();
				}
				if (passportNo == null || "".equals(passportNo)) {
					MsgBox.showInfo("【" + name + "】的护照号为空，请重新填入！");
					this.abort();
				}
				boolean tf = idNum.matches(regex);
				if (!tf) {
					MsgBox.showInfo("【" + name + "】的身份证格式错误，请重新填入！");
					this.abort();
				}
			} else {
				if (passportNo == null || "".equals(passportNo)) {
					MsgBox.showInfo("【" + name + "】的护照号为空，请重新填入！");
					this.abort();
				}
				if (idNum != null) {
					MsgBox.showInfo("【" + name + "】的国籍是" + coInfo.getName() + "无身份证号，请重新填入！");
					this.abort();
				}
			}
		}
	}

	// 考试成绩.出国培训提交校验
	public void CheckSubmit(IRow row) {
		// int rowCount = kdtEntrys.getRowCount();
		// for (int i = 0; i < rowCount; i++) {
		// IRow row = kdtEntrys.getRow(i);
		Boolean trainAbroad = (Boolean) row.getCell("TrainAbroad").getValue();
		// String name = (String) row.getCell("name").getValue();
		BigDecimal sax = (BigDecimal) row.getCell("score").getValue();
		BigDecimal min = new BigDecimal("60");
		BigDecimal max = new BigDecimal("100");
		if (sax == null) {
			MsgBox.showInfo(row.getCell("name").getValue() + "考试成绩为空，无法提交 ");
			this.abort();
		} else if (sax != null && sax.compareTo(min) == -1) {
			MsgBox.showInfo(row.getCell("name").getValue() + "考试成绩小于60分，无法提交 ");
			this.abort();
		} else if (sax != null && sax.compareTo(max) == 1) {
			MsgBox.showInfo(row.getCell("name").getValue() + "考试成绩无效，无法提交 ");
			this.abort();
		} else if (!trainAbroad) {
			MsgBox.showInfo(row.getCell("name").getValue() + "没有出国前培训，无法提交 ");
			this.abort();
			SysUtil.abort();
		}
		// BigDecimal sax = (BigDecimal)row.getCell("score").getValue();
		// BigDecimal six = new BigDecimal ("60");
		// if(sax.compareTo(six)==-1){
		//
		// }
	}

	// 时间校验
	protected void checkDate(IRow row) throws ParseException {
		// int rowCount = kdtEntrys.getRowCount();
		long time = 0;
		long time1 = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		date = sdf.parse(sdf.format(date));
		// for (int i = 0; i < rowCount; i++) {
		// IRow row = kdtEntrys.getRow(i);
		Date passportIssueDate = (Date) row.getCell("passportIssueDate").getValue();// 护照签发日期
		Date passportExpireDate = (Date) row.getCell("passportExpireDate").getValue();// 护照失效日期
		if (passportIssueDate != null && passportExpireDate != null) {
			passportIssueDate = sdf.parse(sdf.format(passportIssueDate));
			passportExpireDate = sdf.parse(sdf.format(passportExpireDate));
			time = (passportExpireDate.getTime() - passportIssueDate.getTime()) / 86400000;
			time1 = (passportExpireDate.getTime() - date.getTime()) / 86400000;
			if (time < 0) {
				MsgBox.showInfo("【" + row.getCell("name").getValue() + "】护照失效日期小于护照签发日期，请重新填写日期！");
				this.abort();
			}
			// if (time1 < 270) { ywj
			// MsgBox.showInfo("【" + row.getCell("name").getValue()+
			// "】护照有效期不足9个月，不允许信息录入！");
			// this.abort();
			// }
		}
	}

	// 指标项目到期日期校验
	public void checkProject() throws BOSException, ParseException {
		int rowCount = kdtEntrys.getRowCount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		date = sdf.parse(sdf.format(date));
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			if (row.getCell("permitProgram").getValue() != null) {
				// ProjectOrgInfo pjInfo= (ProjectOrgInfo)
				// row.getCell("permitProgram").getValue();
				AdminOrgUnitInfo adminInfo = (AdminOrgUnitInfo) row.getCell("permitProgram").getValue();
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("proCom.id", adminInfo.getId()));
				view.setFilter(filter);
				ProjectOrgInfo pjInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
				if (pjInfo != null) {
					if (pjInfo.getPermitEndDate() != null) {
						Date permitEndDate = pjInfo.getPermitEndDate();
						permitEndDate = sdf.parse(sdf.format(permitEndDate));
						long time = (permitEndDate.getTime() - date.getTime()) / 86400000;
						// if(time<0){ ywj
						// MsgBox.showInfo("姓名【"+row.getCell("name").getValue()+
						// "】的指标项目【"+row.getCell("permitProgram").getValue()+
						// "】的证件办理截止日期已过期，无法选择该指标项目！");
						// this.abort();
						// }
					}
				} else {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的指标项目【" + row.getCell("permitProgram").getValue() + "】未维护基本信息，无法选择该指标项目！");
					this.abort();
				}
			}
		}
	}

	// 提交校验本单据中是否存在相同人员且单据状态不为审核通过的数据
	public void checkPersion(IRow row) throws BOSException {
		// Set set = new HashSet();
		// Set passportNo = new HashSet();
		// Set personName = new HashSet();
		// int rowCount = this.kdtEntrys.getRowCount();
		// for(int i=0;i<rowCount;i++){
		// IRow row=kdtEntrys.getRow(i);
		//set.add(row.getCell("idNum").getValue()==null?"":row.getCell("idNum").
		// getValue());
		// passportNo.add(row.getCell("passportNo").getValue());
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		FilterInfo filterID = new FilterInfo();
		CountryInfo coInfo = (CountryInfo) row.getCell("national").getValue();
		if ("C01".equals(coInfo.getNumber())) {
			filter.getFilterItems().add(new FilterItemInfo("idNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(), CompareType.EQUALS));
			filter.setMaskString("#0 or #1");
		} else {
			filter.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(), CompareType.EQUALS));
		}
		filterID.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED, CompareType.NOTEQUALS));
		if (this.editData != null && this.editData.getId() != null) {
			filterID.getFilterItems().add(new FilterItemInfo("parent.id", this.editData.getId().toString(), CompareType.NOTEQUALS));
		}
		filter.mergeFilter(filterID, "and");
		view.setFilter(filter);
		WorkVisaEntryCollection col = WorkVisaEntryFactory.getRemoteInstance().getWorkVisaEntryCollection(view);
		if (col != null && col.size() > 0) {
			// MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() +
			// "】的身份证号或护照号信息存在未审核的单据，不能重复录入 ！");
			if (MsgBox.showConfirm2(this, "所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息存在未审核的单据，是否确定提交？") != 0)
				return;
			// this.abort();
		}
	}

	// 不合格人员名单校验
	public void CheckBlackList(IRow row) throws BOSException {
		// Set set = new HashSet();
		// Set simpleName = new HashSet();
		// int rowCount = this.kdtEntrys.getRowCount();
		// for (int i = 0; i < rowCount; i++) {
		// IRow row = this.kdtEntrys.getRow(i);
		// CountryInfo coInfo=(CountryInfo) row.getCell("national").getValue();
		// set.add(row.getCell("idNum").getValue());
		// simpleName.add(row.getCell("passportNo").getValue());
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo = (CountryInfo) row.getCell("national").getValue();
		if ("C01".equals(coInfo.getNumber())) {
			filter.getFilterItems().add(new FilterItemInfo("IdNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
			filter.setMaskString("(#0 or #1) and #2");
		} else {
			filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
		}

		// filter.setMaskString("(#0 or #1) and #2");
		view.setFilter(filter);
		BlackListCollection col = BlackListFactory.getRemoteInstance().getBlackListCollection(view);
		if (col != null && col.size() > 0) {
			MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息已在外工不合格人员名单中，不允许提交！ ");
			this.abort();
		}
	}

	// 提交时校验人员历史信息中是否有该人员且状态不为离境，返签停办，签证停办，双认证停办，入境停办。则提示不能重复录入且不允许提交
	public void checkPersionHistory(IRow row) throws BOSException {
		// Set set = new HashSet();
		// Set simpleName = new HashSet();
		// Set personName = new HashSet();
		// int rowCount = this.kdtEntrys.getRowCount();
		// for (int i = 0; i < rowCount; i++) {
		// IRow row = this.kdtEntrys.getRow(i);
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		FilterInfo filterID = new FilterInfo();
		// set.add(row.getCell("idNum").getValue());
		// simpleName.add(row.getCell("passportNo").getValue());
		CountryInfo coInfo = (CountryInfo) row.getCell("national").getValue();
		if ("C01".equals(coInfo.getNumber())) {
			filterID.getFilterItems().add(new FilterItemInfo("IdNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filterID.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(), CompareType.EQUALS));
			filterID.setMaskString("#0 or #1");
		} else {
			filterID.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(), CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.CERTISTOP, CompareType.NOTEQUALS));// 双认证停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.ANTINOT, CompareType.NOTEQUALS));// 反签未办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.ANTIDSTRY, CompareType.NOTEQUALS));// 反签过期或不来
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.ANTISTOP, CompareType.NOTEQUALS));// 反签停办并注销
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.VISADSTRY, CompareType.NOTEQUALS));// 签证过期或不来
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.VISASTOP, CompareType.NOTEQUALS));// 签证停办并注销
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.IMMIGRATIONSTOP, CompareType.NOTEQUALS));// 入境停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.PASSPORTISSUEDSTOP, CompareType.NOTEQUALS));// 护照发放停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.DEPARTURE, CompareType.NOTEQUALS));// 离境
		filter.mergeFilter(filterID, "and");
		view.setFilter(filter);
		PersonHistoryCollection col = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
		if (col != null && col.size() > 0) {

			// MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() +
			// "】的身份证号或护照号信息正在办理业务，不能重复录入 ");
			// this.abort();
			if (MsgBox.showConfirm2(this, "所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息正在办理业务，是否确定提交？	") != 0)
				return;
		}
	}

	// 指标工种校验
	// public void CheckPmtProfC() throws BOSException, EASBizException{
	// Map map=new HashMap();
	// int rowCount = this.kdtEntrys.getRowCount();
	// int count=0;
	// int oldCount =0;
	// int leftAmount = 0;
	// int value = 0;
	// ProjectWorkInfo pw=new ProjectWorkInfo();
	// for(int i=0;i<rowCount;i++){
	// IRow row = this.kdtEntrys.getRow(i);
	// pw = (ProjectWorkInfo) row.getCell("pmtProfC").getValue();
	// if(pw!=null){
	// if(map!=null && map.containsKey(pw.getId().toString())){
	// oldCount = (Integer) map.get(pw.getId().toString());
	// map.remove(pw.getId().toString());
	// map.put(pw.getId().toString(), ++oldCount);
	// }else{
	// count=0;
	// map.put(pw.getId().toString(), ++count);
	// }
	// }
	// }
	// Set set = map.keySet();
	// Iterator<String> it = set.iterator();
	// while (it.hasNext()) {
	// String id = it.next();
	// ProjectWorkInfo pwInfo =
	// ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new
	// ObjectUuidPK(id));
	// value = (Integer) map.get(id);
	// leftAmount = pwInfo.getLeftAmount();
	// if(value>leftAmount){
	// if (MsgBox.showConfirm2(this, "指标工种["+pwInfo.getName()+"]额度不足，您确认要提交吗？")
	// != 0){
	// this.abort();
	// }
	// }
	// }
	// }

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
		checkNameCity();
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
		return com.kingdee.eas.zjlw.personmess.WorkVisaFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.personmess.WorkVisaInfo objectValue = new com.kingdee.eas.zjlw.personmess.WorkVisaInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		this.billSate.setEnabled(false);

		FullOrgUnitInfo fullInfo = (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
		try {
			if (fullInfo == null) {
				MsgBox.showInfo("请选中左树中的项目节点后，再进行新建！");
				abort();
			}
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setProCom(adminInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}

		return objectValue;
	}

}