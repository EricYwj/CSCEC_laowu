/**
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
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
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonHisCollection;
import com.kingdee.eas.basedata.person.PersonHisFactory;
import com.kingdee.eas.basedata.person.PersonHisInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.CooprationFactory;
import com.kingdee.eas.zjlw.baseinfo.CooprationInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProf;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyFactory;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPersCollection;
import com.kingdee.eas.zjlw.social.ForiPersEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPersFactory;
import com.kingdee.eas.zjlw.social.ForiPersInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class ForiPersEditUI extends AbstractForiPersEditUI {
	private static final Logger logger = CoreUIObject.getLogger(ForiPersEditUI.class);

	public void onLoad() throws Exception {
		super.onLoad();

		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if ("L1".equals(strLanguage) || "l1".equals(strLanguage)) {
			setUITitle("");
		} else if ("L2".equals(strLanguage) || "l2".equals(strLanguage)) {
			setUITitle("外籍员工参保名单");
		} else {
			// setUITitle("");
		}
		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 end

		this.btnRemove.setVisible(false);
		addKdtEntryDetailPanelListener();
		// 新增时，从人员历史中取数据
		if (getOprtState().equals("ADDNEW")) {
			this.pkBizDate.setValue(new Date());
			insertEntry();
			checkProjNo();

		}
		// if (getOprtState().equals("EDIT")) {
		// updateEntry();
		// updateProjSecuNo();
		// getCoopCode();
		// checkProjNo();
		// }
		filterProf();
		this.btnUpdateData.setEnabled(true);
	}

	public void actionUpdateData_actionPerformed(ActionEvent e) throws Exception {
		updateEntry();
		checkProjNo();
	}

	// private void updateProjSecuNo() {
	// int rowCount = this.kdtEntrys.getRowCount();
	// for(int i=0;i<rowCount;i++){
	// IRow row=this.kdtEntrys.getRow(i);
	// AdminOrgUnitInfo secilProgram = (AdminOrgUnitInfo) row.getCell("secilProgram").getValue();
	// }
	// }

	protected void checkProjNo() throws BOSException {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			AdminOrgUnitInfo secilProgram = (AdminOrgUnitInfo) row.getCell("secilProgram").getValue();
			if (secilProgram != null) {
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id", secilProgram.getId().toString()));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
				FilterInfo filter = new FilterInfo();
				EntityViewInfo view = new EntityViewInfo();
				SelectorItemCollection sic = new SelectorItemCollection();
				filter.getFilterItems().add(new FilterItemInfo("proCom.id", secilProgram == null ? null : secilProgram.getId()));
				sic.add("insuranceAcc");
				view.setFilter(filter);
				view.setSelector(sic);
				ProjectOrgInfo projOInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
				if (projOInfo != null) {
					row.getCell("projSocialNo").setValue(projOInfo.getInsuranceAcc());
				}

				// row.getCell("projSocialNo").setValue(null);
			}
			if (secilProgram == null || "".equals(secilProgram)) {
				row.getCell("projSocialNo").setValue(null);
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
		Date date = new Date();
		// 社保项目
		if ("secilProgram".equals(key)) {
			AdminOrgUnitInfo secilProgram = (AdminOrgUnitInfo) row.getCell("secilProgram").getValue();
			if (secilProgram != null) {
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id", secilProgram.getId().toString()));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
				FilterInfo filter = new FilterInfo();
				EntityViewInfo view = new EntityViewInfo();
				SelectorItemCollection sic = new SelectorItemCollection();
				filter.getFilterItems().add(new FilterItemInfo("proCom.id", secilProgram == null ? null : secilProgram.getId()));
				sic.add("insuranceAcc");
				view.setFilter(filter);
				view.setSelector(sic);
				ProjectOrgInfo projOInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
				if (projOInfo != null) {
					row.getCell("projSocialNo").setValue(projOInfo.getInsuranceAcc());
				}

				// row.getCell("projSocialNo").setValue(null);
			}
			if (secilProgram == null || "".equals(secilProgram)) {
				row.getCell("projSocialNo").setValue(null);
			}

		}
		// //社保项目
		// if ("permitOrg".equals(key)){
		// //社保项目默认等于指标项目
		// if (row.getCell("permitOrg").getValue() != null ) {
		// AdminOrgUnitInfo pmtOrg = (AdminOrgUnitInfo)
		// row.getCell("permitOrg").getValue();
		// AdminOrgUnitInfo pmtOrgInfo =
		// AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new
		// ObjectUuidPK(pmtOrg.getId()));
		// row.getCell("secuProj").setValue(pmtOrgInfo);
		// }
		// }
	}

	/**
	 * 添加分录监听事件，实现分录表格默认值
	 */
	private void addKdtEntryDetailPanelListener() {
		IDetailPanelListener listener = new DetailPanelAdapter() {
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				setLineValue(e); // 设置分录表格的默认值
			}
		};
		kdtEntrys_detailPanel.addAddListener(listener);// 模板增加监听
	}

	/**
	 * 实现IDetailPanelListener接口
	 */
	private static class DetailPanelAdapter implements IDetailPanelListener {
		public DetailPanelAdapter() {
		}

		public void beforeEvent(DetailPanelEvent e) throws Exception {
		}

		public void afterEvent(DetailPanelEvent e) throws Exception {
		}
	}

	/**
	 * 新增一行的时候，设置默认值
	 */
	private void setLineValue(DetailPanelEvent e) {
		ForiPersEntryInfo insEntryInfo = (ForiPersEntryInfo) e.getObjectValue(); // 获取分录对象
		insEntryInfo.setJoin(true);// 是否参保
	}

	private void insertEntry() throws BOSException, EASBizException {
		PersonHistoryCollection persHisCol = getPersonCol();
		if (persHisCol != null && persHisCol.size() > 0) {
			for (int i = 0; i < persHisCol.size(); i++) {
				PersonHistoryInfo persHisInfo = persHisCol.get(i);
				init(persHisInfo);
			}
			// 社保（证件）项目 secuProj
			// 指标项目 permProj

		}
	}

	private void init(PersonHistoryInfo localEInfo) throws BOSException, EASBizException {
		// ImmigrationEntryInfo immiEntryInfo = new ImmigrationEntryInfo();
		// PassportapplyEntryInfo ppaEntryInfo = new PassportapplyEntryInfo();
		IRow row = this.kdtEntrys.addRow();
		AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getWorkOrg() == null ? null : localEInfo.getWorkOrg().getId()));
		AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getCooperation() == null ? null : localEInfo.getCooperation().getId()));
		AdminOrgUnitInfo permitOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getPermitOrg() == null ? null : localEInfo.getPermitOrg().getId()));
		if (permitOrg != null) {
			row.getCell("secilProgram").setValue(permitOrg);// 社保项目
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id", permitOrg == null ? null : permitOrg.getId()));
			sic.add("insuranceAcc");
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgInfo projOInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
			if (projOInfo != null) {
				row.getCell("projSocialNo").setValue(projOInfo.getInsuranceAcc());
			}
		}
		// ProjectWorkInfo projInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(localEInfo.getPermitProfession() == null ? null : localEInfo.getPermitProfession().getId()));
		// ProjSecuProfInfo pspInfo = ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(localEInfo.getPermitProfession()==null?null:localEInfo.getPermitProfession().getId()));
		ProjectWorkInfo prof = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(localEInfo.getPermitProfession() == null ? null : localEInfo.getPermitProfession().getId()));
		row.getCell("personID").setValue(localEInfo.getSourceBillId());// 人员主键
		if (localEInfo.getSourceBillId() != null) {
			ImmigrationEntryInfo immiEntryInfo = getFromImmi(localEInfo.getSourceBillId());
			PassportapplyEntryInfo ppaEntryInfo = getPassportapply(localEInfo.getSourceBillId());
			if (ppaEntryInfo != null)
				row.getCell("airportDate").setValue(ppaEntryInfo.getSTime());
		}
		row.getCell("lastName").setValue(localEInfo.getNameCN());// 姓名
		row.getCell("firstNameApl").setValue(localEInfo.getFirstNameAlp());// 姓拼音
		row.getCell("lastNameApl").setValue(localEInfo.getLastNameApl());// 名拼音
		row.getCell("sex").setValue(localEInfo.getSex());// 性别
		row.getCell("IdNum").setValue(localEInfo.getIdNum());// 身份证号
		String idnum = localEInfo.getIdNum();
		row.getCell("birthdate").setValue(localEInfo.getBirthDate());// 出生日期
		row.getCell("birthPlaceCn").setValue(localEInfo.getBirthPlaceFr());// 出生地
		CountryInfo country = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(localEInfo.getNation() == null ? null : localEInfo.getNation().getId()));
		row.getCell("country").setValue(country);// 国籍
		row.getCell("MaritalStatus").setValue(localEInfo.getMerState());// 婚姻状况
		row.getCell("fatherNameAlphabet").setValue(localEInfo.getFatherNameAlphabet());// 父亲姓名拼音
		row.getCell("motherNameAlphabet").setValue(localEInfo.getMotherNameAlphabet());// 母亲姓名拼音
		row.getCell("securityNo").setValue(localEInfo.getSecurityNo());// 社保号码
		row.getCell("prof").setValue(prof);// 指标工种（工种）
		// row.getCell("secuProf").setValue(pspInfo);//社保工种
		// row.getCell("nBasePay").setValue(localEInfo.getNBasePay());//基本工资
		// row.getCell("airportDate").setValue(ppaEntryInfo.getSTime());//机票时间
		// row.getCell("approachTime").setValue(localEInfo);//进场日期
		row.getCell("workProgram").setValue(workOrg);// 工作项目
		row.getCell("cooperation").setValue(cooperation);// 合作单位
		row.getCell("cooperationId").setValue(cooperation.getNumber());// 合作单位代码
		// row.getCell("secuSigner").setValue(localEInfo.getNameCN());外会人员编码
		// row.getCell("endDate").setValue(localEInfo.getNameCN());离场日期
		// row.getCell("IdNum").setValue(localEInfo.getIdNum());//身份证号
		row.getCell("passpNum").setValue(localEInfo.getPassportNo());// 护照号
		// row.getCell("personID").setValue(localEInfo.getId());
	}

	/**
	 * 获取入境中信息
	 * 
	 * @param sourceBillId
	 * @throws BOSException
	 */
	private ImmigrationEntryInfo getFromImmi(String sourceBillId) throws BOSException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("personID", sourceBillId));
		view.setFilter(filter);
		view.setSelector(getImmiSelector());
		ImmigrationEntryCollection immiEntryCol = ImmigrationEntryFactory.getRemoteInstance().getImmigrationEntryCollection(view);
		ImmigrationEntryInfo immiEntryInfo = immiEntryCol.get(0);
		return immiEntryInfo;
	}

	/**
	 * 获取申请护照发放中信息
	 * 
	 * @param sourceBillId
	 * @throws BOSException
	 */
	private PassportapplyEntryInfo getPassportapply(String sourceBillId) throws BOSException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("personID", sourceBillId));
		view.setFilter(filter);
		view.setSelector(getImmiSelector());
		PassportapplyEntryInfo ppaEntryInfo = PassportapplyEntryFactory.getRemoteInstance().getPassportapplyEntryCollection(view).get(0);
		// PassportapplyEntryInfo ppaEntryInfo = passPortEntrytryCol.get(0);
		return ppaEntryInfo;
	}

	/**
	 * 获取人员历史信息
	 * 
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private PersonHistoryCollection getPersonCol() throws BOSException, EASBizException {
		Set stateSet = new HashSet();
		// stateSet.add(perBizStateEnum.IMMIGRATION_VALUE);//入境
		stateSet.add(perBizStateEnum.PASSPORTISSUED_VALUE);// 申请护照
		stateSet.add(perBizStateEnum.WORKPERMIT_VALUE);// 劳动证办理
		stateSet.add(perBizStateEnum.RESIDENCE_VALUE);// 居住证办理
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		AdminOrgUnitInfo fullInfo = (AdminOrgUnitInfo) this.prmtpermitOrg.getValue();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
		AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
		filter.getFilterItems().add(new FilterItemInfo("permitOrg.id", adminInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("visaType", visaTypeEnum.work));
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", stateSet, CompareType.INCLUDE));
		view.setFilter(filter);
		view.setSelector(getHisPersSelector());
		PersonHistoryCollection persHisCol = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
		if (persHisCol.size() == 0 || persHisCol == null) {
			MsgBox.showInfo("所选项目暂无参保人员！");
			abort();
		}
		return persHisCol;

	}

	private SelectorItemCollection getImmiSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		sic.add("sourceBillID");// 合同编号
		sic.add("contSTime");// 合同签订日期
		sic.add("contItime");// 合同到期日期
		return sic;
	}

	/**
	 * 人员历史信息selector
	 * 
	 * @return
	 */
	private SelectorItemCollection getHisPersSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		// sic.add("sourceBillID");//人员ID
		// sic.add("nameCN");//中文姓名
		// sic.add("firstNameApl");
		// sic.add("lastNameApl");
		// sic.add("sex");//性别
		// sic.add("birthDate");//出生日期
		// sic.add("passportNo");//护照号码
		// sic.add("birthPlaceCn");//出生地（中文）
		// sic.add("birthPlaceFr");//出生地（法文）
		// sic.add("fatherName");//父亲姓名
		// sic.add("fatherNameAlphabet");//父亲姓名拼音
		// sic.add("motherName");//母亲姓名
		// sic.add("motherNameAlphabet");//母亲姓名拼音
		// sic.add("contactway");//国内联系方式
		// sic.add("firstNameAlp");//姓拼音
		// sic.add("lastNameApl");//名拼音
		// sic.add("permitProfession");//指标工种
		// sic.add("workOrg");//工种项目
		// sic.add("permitOrg");//指标项目
		// sic.add("securityNo");//社保号码
		// sic.add("cooperation");//合作单位
		return sic;
	}

	/**
	 * 获取合作单位代码
	 * 
	 * @throws BOSException
	 */
	private void getCoopCode() throws BOSException {
		ForiPersInfo insInfo = this.editData;
		ForiPersEntryCollection insEntryCol = insInfo.getEntrys();
		for (int i = 0; i < insEntryCol.size(); i++) {
			ForiPersEntryInfo insEntryInfo = insEntryCol.get(i);
			FilterInfo filter = new FilterInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("proCom", insEntryInfo.getCooperation() == null ? null : insEntryInfo.getCooperation().getId()));
			sic.add("number");
			view.setFilter(filter);
			view.setSelector(sic);
			CooprationInfo coopInfo = CooprationFactory.getRemoteInstance().getCooprationCollection(view).get(0);
			insEntryInfo.setCooperationId(coopInfo == null ? null : coopInfo.getNumber());
		}
	}

	/**
	 * output class constructor
	 */
	public ForiPersEditUI() throws Exception {
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
		filterProf();

	}

	private void filterProf() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("secilProgram").getValue();
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
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		super.doBeforeSave(e);
		checkDate();
		checkEmpty();
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	// 时间校验
	private void checkDate() throws EASBizException, BOSException {
		int count = this.kdtEntrys.getRowCount();
		for (int i = 0; i < count; i++) {
			long time0 = 0;
			IRow row = this.kdtEntrys.getRow(i);
			Date secuRegDate = (Date) row.getCell("secuRegDate").getValue();// 社保注册时间
			Date approachTime = (Date) row.getCell("approachTime").getValue();// 进场时间
			if (secuRegDate != null && approachTime != null) {
				time0 = (secuRegDate.getTime() - approachTime.getTime()) / 86400000;
				// 红色预警：社保注册时间-进场时间>10天
				if (time0 < 0) {
					MsgBox.showInfo("第" + i + "行，数据填写错误，社保注册时间不可早于进场时间！");
					abort();
				}
			}
		}
	}

	// 是否参保为是的时候，不为空校验
	private void checkEmpty() {
		int count = this.kdtEntrys.getRowCount();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			Boolean join = (Boolean) row.getCell("join").getValue();
			ProjSecuProfInfo secuProf = (ProjSecuProfInfo) row.getCell("secuProf").getValue();
			AdminOrgUnitInfo secilProgram = (AdminOrgUnitInfo) row.getCell("secilProgram").getValue();
			Date approachTime = (Date) row.getCell("approachTime").getValue();
			String name = (String) row.getCell("lastName").getValue();
			if (join != null) {
				if (join) {
					if (secuProf == null) {
						MsgBox.showInfo("姓名【" + name + "】的社保工种为空无法保存，请填入！");
						this.abort();
					}
					if (secilProgram == null) {
						MsgBox.showInfo("姓名【" + name + "】的社保项目为空无法保存，请填入！");
						this.abort();
					}
					if (approachTime == null) {
						MsgBox.showInfo("姓名【" + name + "】的进场日期为空无法保存，请填入！");
						this.abort();
					}
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
		updateEntry();
		getCoopCode();
		this.pkBizDate.setValue(new Date());
	}

	/**
	 * 更新表格
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void updateEntry() throws EASBizException, BOSException {
		// 用personID校验是否重复
		AdminOrgUnitInfo prmtInfo = (AdminOrgUnitInfo) this.prmtpermitOrg.getValue();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", prmtInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		Set personID = new HashSet();
		ForiPersEntryCollection foriPersCol = ForiPersEntryFactory.getRemoteInstance().getForiPersEntryCollection(view);
		if (foriPersCol != null && foriPersCol.size() > 0) {
			for (int i = 0; i < foriPersCol.size(); i++) {
				ForiPersEntryInfo fpInfo = foriPersCol.get(i);
				personID.add(fpInfo.getPersonID());
			}
		}
		PersonHistoryCollection persHisCol = getPersonCol();
		if (persHisCol != null && persHisCol.size() > 0) {
			for (int j = 0; j < persHisCol.size(); j++) {
				if(j==142){
					System.out.println("***************");
				}
				PersonHistoryInfo persHisInfo = persHisCol.get(j);
				System.out.println(j);
				if (!personID.contains(persHisInfo.getSourceBillId())) {
					// 向参保人员名单中添加该条数据
					init(persHisInfo);
				}
			}
		}
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
		return com.kingdee.eas.zjlw.social.ForiPersFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.social.ForiPersInfo objectValue = new com.kingdee.eas.zjlw.social.ForiPersInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		FullOrgUnitInfo fullInfo = (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
		try {
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setPermitOrg(adminInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return objectValue;
	}

}