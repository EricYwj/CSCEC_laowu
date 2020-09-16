/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.eas.cp.bc.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.IUserCellDisplayParser;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTEditManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.util.Tools;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.StyleAttributes;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.KDCheckBoxMenuItem;
import com.kingdee.bos.ctrl.swing.KDContainer;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDMenu;
import com.kingdee.bos.ctrl.swing.KDMenuItem;
import com.kingdee.bos.ctrl.swing.KDRadioButtonMenuItem;
import com.kingdee.bos.ctrl.swing.KDScrollPane;
import com.kingdee.bos.ctrl.swing.KDTabbedPane;
import com.kingdee.bos.ctrl.swing.KDTextArea;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.plaf.KingdeePromptBoxUI;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.bos.ui.face.IUIFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.codingrule.RuleStatus;
import com.kingdee.eas.base.param.IParamControl;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.ConvertModeEnum;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.ExchangeAuxInfo;
import com.kingdee.eas.basedata.assistant.ExchangeRateInfo;
import com.kingdee.eas.basedata.assistant.ICurrency;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.cp.bc.AmountControlTypeEnum;
import com.kingdee.eas.cp.bc.BizAccountBillEntryCollection;
import com.kingdee.eas.cp.bc.BizAccountBillEntryInfo;
import com.kingdee.eas.cp.bc.BizAccountBillFactory;
import com.kingdee.eas.cp.bc.BizAccountBillInfo;
import com.kingdee.eas.cp.bc.BizCollBillBaseInfo;
import com.kingdee.eas.cp.bc.BizCollBillTypeEnum;
import com.kingdee.eas.cp.bc.BizCollCoreBillBaseInfo;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.cp.bc.CollectionAccountInfo;
import com.kingdee.eas.cp.bc.CommonUtilFacadeFactory;
import com.kingdee.eas.cp.bc.EntryStateEnum;
import com.kingdee.eas.cp.bc.ExpAccException;
import com.kingdee.eas.cp.bc.ExpenseCommenFacadeFactory;
import com.kingdee.eas.cp.bc.ExpenseReqException;
import com.kingdee.eas.cp.bc.ExpenseTypeInfo;
import com.kingdee.eas.cp.bc.IBizAccountBill;
import com.kingdee.eas.cp.bc.ICommonUtilFacade;
import com.kingdee.eas.cp.bc.IExpenseCommenFacade;
import com.kingdee.eas.cp.bc.MakeControl;
import com.kingdee.eas.cp.bc.OperationTypeInfo;
import com.kingdee.eas.cp.bc.StateEnum;
import com.kingdee.eas.cp.bc.util.MultilingualUtil;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.client.AbstractEditUI.ActionCopy;
import com.kingdee.eas.framework.print.MultiDataSourceProviderProxy;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.KDTableUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.StringUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;

public class BizAccountEditUI extends AbstractBizAccountEditUI {
	private static final Logger logger = CoreUIObject.getLogger(BizAccountEditUI.class);

	private static final BizCollBillTypeEnum[] billTypes = { BizCollBillTypeEnum.DAILY_LOAN, BizCollBillTypeEnum.OTHER_EXPENSE, BizCollBillTypeEnum.EVECTION_LOAN };
	private static final String RESBIZCOLL = "com.kingdee.eas.cp.bc.BizCollResource";
	private static final String RESOURCE = "com.kingdee.eas.cp.bc.ExpenseReqException";
	private static final String EXPENSEACCOUNT_BUDGET = "cp_bc_ExpenseAccount_Budget";
	private String TB_AMOUNT = "amount";

	private String TB_EXPENSETYPE = "expenseType";

	private String TB_PROJECT = "project";

	private String TB_AMOUNTAPPROVED = "approvedAmount";

	private String TB_BUDGETAMOUNT = "budgetAmount";

	private String BILLTYPE = "BizAccountBill";

	private KDBizPromptBox bizPromptExpenseTypeEntry = new KDBizPromptBox();

	private KDBizPromptBox bizPromptOperationTypeEntry = new KDBizPromptBox();

	private Map currencyMap = new HashMap();
	private KDBizPromptBox currencyPrompt = new KDBizPromptBox();
	private KDBizPromptBox payModePrompt = new KDBizPromptBox();

	public BizAccountEditUI() throws Exception {
		this.kdtEntries.addKDTPropertyChangeListener(new KDTPropertyChangeListener() {
			public void propertyChange(KDTPropertyChangeEvent evt) {
				try {
					BizAccountEditUI.this.kdtEntries_propertyChange(evt);
				} catch (Exception e) {
					BizAccountEditUI.logger.error(e.getMessage());
				}
			}
		});
	}

	public void onLoad() throws Exception {
		super.onLoad();

		this.kdtEntries.getColumn("exchangeRate").getStyleAttributes().setNumberFormat(null);
		this.kdtEntries.setUserCellDisplayParser(new IUserCellDisplayParser() {
			public Object parse(int rowIndex, int colIndex, ICell cell, Object value) {
				if ((BizAccountEditUI.this.kdtEntries.getColumn("exchangeRate").getColumnIndex() == colIndex) && (value != null) && (value instanceof BigDecimal)) {
					IRow row = BizAccountEditUI.this.kdtEntries.getRow(rowIndex);
					if (row != null) {
						Object precision = row.getCell("exchangeRatePrecision").getValue();
						if ((precision != null) && (precision instanceof Integer)) {
							String nFormat = BizCollUtil.getFormatString(((Integer) precision).intValue());
							return Tools.format(nFormat, value);
						}
					}
				}
				return value;
			}
		});
		this.kdtCollectionEntries.getColumn("exchangeRate").getStyleAttributes().setNumberFormat(null);
		this.kdtCollectionEntries.setUserCellDisplayParser(new IUserCellDisplayParser() {
			public Object parse(int rowIndex, int colIndex, ICell cell, Object value) {
				if ((BizAccountEditUI.this.kdtCollectionEntries.getColumn("exchangeRate").getColumnIndex() == colIndex) && (value != null) && (value instanceof BigDecimal)) {
					IRow row = BizAccountEditUI.this.kdtCollectionEntries.getRow(rowIndex);
					if ((row != null) && (row.getCell("exchangeRatePrecision").getValue() != null)) {
						Object precision = row.getCell("exchangeRatePrecision").getValue();
						String nFormat = BizCollUtil.getFormatString(((Integer) precision).intValue());
						return Tools.format(nFormat, value);
					}
				}
				return value;
			}
		});
		this.kdtLoanCheckEntries.getColumn("exchangeRate").getStyleAttributes().setNumberFormat(null);
		this.kdtLoanCheckEntries.setUserCellDisplayParser(new IUserCellDisplayParser() {
			public Object parse(int rowIndex, int colIndex, ICell cell, Object value) {
				if ((BizAccountEditUI.this.kdtLoanCheckEntries.getColumn("exchangeRate").getColumnIndex() == colIndex) && (value != null) && (value instanceof BigDecimal)) {
					IRow row = BizAccountEditUI.this.kdtLoanCheckEntries.getRow(rowIndex);
					if ((row != null) && (row.getCell("exchangeRatePrecision").getValue() != null)) {
						Object precision = row.getCell("exchangeRatePrecision").getValue();
						String nFormat = BizCollUtil.getFormatString(((Integer) precision).intValue());
						return Tools.format(nFormat, value);
					}
				}
				return value;
			}
		});
		this.kdtReqCheckEntries.getColumn("exchangeRate").getStyleAttributes().setNumberFormat(null);
		this.kdtReqCheckEntries.setUserCellDisplayParser(new IUserCellDisplayParser() {
			public Object parse(int rowIndex, int colIndex, ICell cell, Object value) {
				if ((BizAccountEditUI.this.kdtReqCheckEntries.getColumn("exchangeRate").getColumnIndex() == colIndex) && (value != null) && (value instanceof BigDecimal)) {
					IRow row = BizAccountEditUI.this.kdtReqCheckEntries.getRow(rowIndex);
					if ((row != null) && (row.getCell("exchangeRatePrecision").getValue() != null)) {
						Object precision = row.getCell("exchangeRatePrecision").getValue();
						String nFormat = BizCollUtil.getFormatString(((Integer) precision).intValue());
						return Tools.format(nFormat, value);
					}
				}
				return value;
			}
		});
		setButtonState();
		this.btnWFViewSubmitProccess.setVisible(false);
		this.menuItemViewSubmitProccess.setVisible(false);
		this.menuItemViewBudget.setIcon(EASResource.getIcon("imgTbtn_linkviewlist"));
		if ((this.isShowBgAudit) && (BizCollUtil.isHasPermission("cp_bc_ExpenseAccount_Budget"))) {
			this.bizPromptCostedDept.addDataChangeListener(new DataChangeListener() {
				public void dataChanged(DataChangeEvent e) {
					try {
						BizAccountEditUI.this.showBgAuditInLabel(e);
					} catch (Exception exc) {
						BizAccountEditUI.this.handUIException(exc);
					}
				}
			});
			this.dateBizReqDate.addDataChangeListener(new DataChangeListener() {
				public void dataChanged(DataChangeEvent e) {
					try {
						BizAccountEditUI.this.showBgAuditInLabel(e);
					} catch (Exception exc) {
						BizAccountEditUI.this.handUIException(exc);
					}
				}
			});
		}
		this.kdtEntries.getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setHided(true);

		purpose_autoFitRowHeight();
		this.promPayName.setHistoryRecordEnabled(false);
		MakeControl.makeCollectionAccountMultiF7(this.promPayName, this);
		this.promPayName.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent eventObj) {
				if (!(eventObj.getNewValue() instanceof Object[]))
					return;
				for (int i = 0; i < ((Object[]) (Object[]) eventObj.getNewValue()).length; ++i) {
					CollectionAccountInfo collection = (CollectionAccountInfo) ((Object[]) (Object[]) eventObj.getNewValue())[i];
					IRow row = null;
					if (BizAccountEditUI.this.checkIsCountLine(BizAccountEditUI.this.kdtCollectionEntries.getRow(BizAccountEditUI.this.kdtCollectionEntries.getRowCount() - 1)))
						row = BizAccountEditUI.this.kdtCollectionEntries.addRow(BizAccountEditUI.this.kdtCollectionEntries.getRowCount() - 1);
					else {
						row = BizAccountEditUI.this.kdtCollectionEntries.addRow();
					}
					row.getCell("payerName").setValue(collection.getPayee());
					row.getCell("payerBank").setValue(collection.getBebankStr());
					row.getCell("accountOpenArea").setValue((collection.getOpenArea() == null) ? null : collection.getOpenArea());
					row.getCell("payerAccount").setValue(collection.getBankAccount());
					row.getCell("payMode").setValue(BizAccountEditUI.this.editData.getPayMode());
					row.getCell("currencyType").setValue(BizAccountEditUI.this.editData.getCurrencyType());
					row.getCell("exchangeRate").setValue(new BigDecimal(1).setScale(4));
					row.getCell("convertMode").setValue(ConvertModeEnum.DIRECTEXCHANGERATE);
					row.getCell("exchangeRatePrecision").setValue(Integer.valueOf(4));
					row.getCell("amountOri").setValue(new BigDecimal(0.0D));
					row.getCell("amount").setValue(new BigDecimal(0.0D));
				}
			}
		});
		this.loadOver = true;

		if (!(this.isShowProject)) {
			this.kdtEntries.getColumn("project").getStyleAttributes().setHided(true);
			this.kdtLoanCheckEntries.getColumn("sourceBillProjectName").getStyleAttributes().setHided(true);
			this.kdtReqCheckEntries.getColumn("sourceBillProjectName").getStyleAttributes().setHided(true);
		}
	}

	private void setButtonState() {
		this.btnViewRcrdsOfLendAndRepay.setIcon(EASResource.getIcon("imgTbtn_requite"));

		this.menuItemViewRcds.setIcon(EASResource.getIcon("imgTbtn_requite"));
		if (("amountApproved".equals(this.oprtState)) && (isFromWorkFlow()))
			this.actionCopy.setEnabled(false);
	}

	private boolean isCreateVoucher() {
		BOSUuid companyId = SysContext.getSysContext().getCurrentFIUnit().getId();

		IParamControl iParam = null;
		try {
			iParam = ParamControlFactory.getRemoteInstance();
		} catch (BOSException e) {
			logger.error(e.getMessage());
		}
		String value = null;
		try {
			value = iParam.getParamValue(new ObjectUuidPK(companyId), "CP008");
		} catch (EASBizException e) {
			logger.error(e.getMessage());
		} catch (BOSException e) {
			logger.error(e.getMessage());
		}

		return ("true".equals(value));
	}

	protected void initUIData() {
		super.initUIData();

		String dataFormat = MultilingualUtil.getDateFormatString();
		getDetailTable().getColumn("happenTime").getStyleAttributes().setNumberFormat("%{yyyy-MM-dd}t");

		this.kdtReqCheckEntries.getColumn("checkAmount").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));
		this.kdtLoanCheckEntries.getColumn("checkAmount").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));

		this.kdtCollectionEntries.getColumn("amountOri").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));
		this.kdtCollectionEntries.getColumn("amount").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));

		MakeControl.makeCurrency(this.currencyPrompt);
		this.kdtCollectionEntries.getColumn("currencyType").setEditor(new KDTDefaultCellEditor(this.currencyPrompt));

		MakeControl.makePayMode(this.payModePrompt);
		this.kdtCollectionEntries.getColumn("payMode").setEditor(new KDTDefaultCellEditor(this.payModePrompt));

		JButton btnAddCollection = this.ctnCollectionEntry.add(this.actionAddCollectionLine);
		JButton btnDelCollection = this.ctnCollectionEntry.add(this.actionDelCollectionLine);

		btnAddCollection.setIcon(EASResource.getIcon("imgTbtn_addline"));
		btnAddCollection.setToolTipText(this.btnAddLine.getToolTipText());
		btnAddCollection.setSize(22, 19);
		btnDelCollection.setIcon(EASResource.getIcon("imgTbtn_deleteline"));
		btnDelCollection.setToolTipText(this.btnRemoveLine.getToolTipText());
		btnDelCollection.setSize(22, 19);

		getDetailTable().getColumn("amountOri").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));
		getDetailTable().getColumn("approvedAmountOri").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));

		getDetailTable().getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

		getDetailTable().getColumn(this.TB_BUDGETAMOUNT).setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor()));

		this.kdtEntries.getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setLocked(true);

		this.kdtEntries.getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setHided(true);

		KDDatePicker dateBox = new KDDatePicker();
		dateBox.setTimeEnabled(false);
		dateBox.setMilliSecondEnable(false);
		dateBox.setDateEnabled(true);
		dateBox.setDatePattern(MultilingualUtil.getDateFormatString());
		getDetailTable().getColumn("happenTime").setEditor(new KDTDefaultCellEditor(dateBox));

		JButton btnCopyRuleNew = this.ctnEntry.add(this.actionCopyLine);
		JButton btnAddRuleNew = this.ctnEntry.add(this.actionAddLine);
		JButton btnDelRuleNew = this.ctnEntry.add(this.actionRemoveLine);

		JButton btnAddReqLine = this.kDReqContainer.add(this.actionAddReqLine);
		JButton btnDelReqLine = this.kDReqContainer.add(this.actionDelReqLine);

		JButton btnAddLoanLine = this.kDLoanContainer.add(this.actionAddLoanLine);
		JButton btnDelLoanLine = this.kDLoanContainer.add(this.actionDelLoanLine);

		btnCopyRuleNew.setIcon(EASResource.getIcon("imgTbtn_copyline"));

		btnCopyRuleNew.setSize(22, 19);
		btnCopyRuleNew.setText(this.menuItemCopyLine.getText());
		btnCopyRuleNew.setToolTipText(this.menuItemCopyLine.getText());

		btnAddRuleNew.setIcon(EASResource.getIcon("imgTbtn_addline"));
		btnAddRuleNew.setToolTipText(this.btnAddLine.getToolTipText());
		btnAddRuleNew.setSize(22, 19);
		btnDelRuleNew.setIcon(EASResource.getIcon("imgTbtn_deleteline"));
		btnDelRuleNew.setToolTipText(this.btnRemoveLine.getToolTipText());
		btnDelRuleNew.setSize(22, 19);

		btnAddReqLine.setIcon(EASResource.getIcon("imgTbtn_addline"));
		btnAddReqLine.setToolTipText(this.btnAddLine.getToolTipText());
		btnAddReqLine.setSize(22, 19);
		btnDelReqLine.setIcon(EASResource.getIcon("imgTbtn_deleteline"));
		btnDelReqLine.setToolTipText(this.btnRemoveLine.getToolTipText());
		btnDelReqLine.setSize(22, 19);

		btnAddLoanLine.setIcon(EASResource.getIcon("imgTbtn_addline"));
		btnAddLoanLine.setToolTipText(this.btnAddLine.getToolTipText());
		btnAddLoanLine.setSize(22, 19);
		btnDelLoanLine.setIcon(EASResource.getIcon("imgTbtn_deleteline"));
		btnDelLoanLine.setToolTipText(this.btnRemoveLine.getToolTipText());
		btnDelLoanLine.setSize(22, 19);

		this.kdtEntries.getColumn("happenTime").getStyleAttributes().setBackground(BizCollUtil.REQUIRE_COLOR);

		this.kdtEntries.getColumn("amount").getStyleAttributes().setBackground(BizCollUtil.REQUIRE_COLOR);

		if ((this.isShowBgAudit) && (BizCollUtil.isHasPermission("cp_bc_ExpenseAccount_Budget"))) {
			this.kdtEntries.getSelectManager().addKDTSelectListener(new KDTSelectListener() {
				public void tableSelectChanged(KDTSelectEvent e) {
					try {
						if (BizAccountEditUI.this.isRowNoEqual(e))
							BizAccountEditUI.this.showBgAuditInLabel(null);
					} catch (Exception exc) {
						BizAccountEditUI.this.handUIException(exc);
					}

				}

			});
		}

		ExpenseTypePromptBox f7 = new ExpenseTypePromptBox();
		this.bizPromptExpenseTypeEntry.setSelector(f7);
		MakeControl.makeAccountF7_mul(this.bizPromptExpenseTypeEntry, this);
		this.bizPromptExpenseTypeEntry.setEditable(true);

		ObjectValueRender avr = new ObjectValueRender();

		avr.setFormat(new BizDataFormat("$typeName$-$number$"));

		this.kdtEntries.getColumn(this.TB_EXPENSETYPE).setRenderer(avr);
		this.kdtEntries.getColumn(this.TB_EXPENSETYPE).setEditor(new KDTDefaultCellEditor(this.bizPromptExpenseTypeEntry));

		MakeControl.makeOperationTypeF7(this.bizPromptOperationTypeEntry, this);
		this.bizPromptOperationTypeEntry.setEditable(true);

		avr = new ObjectValueRender();

		avr.setFormat(new BizDataFormat("$name$-$number$"));

		this.kdtEntries.getColumn("operationType").setRenderer(avr);
		this.kdtEntries.getColumn("operationType").setEditor(new KDTDefaultCellEditor(this.bizPromptOperationTypeEntry));

		MakeControl.makeProject(this.bizPromptProjectEntry, this);
		this.kdtEntries.getColumn(this.TB_PROJECT).setEditor(new KDTDefaultCellEditor(this.bizPromptProjectEntry));
		this.bizPromptProjectEntry.setEditable(true);

		MakeControl.makeCostCentorF7(this.bizPromptCostCenterEntry, this);
		this.bizPromptCostCenterEntry.setEditable(true);

		avr = new ObjectValueRender();

		avr.setFormat(new BizDataFormat("$name$"));

		this.kdtEntries.getColumn("costCenter").setRenderer(avr);
		this.kdtEntries.getColumn("costCenter").setEditor(new KDTDefaultCellEditor(this.bizPromptCostCenterEntry));

		MakeControl.makeCompanyF7(this.bizPromptCompanyEntry, this, this.paramMap, this.OrgRangeSet);

		this.bizPromptCompanyEntry.setDisplayFormat("$number$");

		avr = new ObjectValueRender();

		avr.setFormat(new BizDataFormat("$name$"));

		this.kdtEntries.getColumn("company").setRenderer(avr);
		this.kdtEntries.getColumn("company").setEditor(new KDTDefaultCellEditor(this.bizPromptCompanyEntry));

		this.kdtEntries.getColumn("currencyType").setRenderer(avr);
		this.kdtEntries.getColumn("currencyType").setEditor(new KDTDefaultCellEditor(this.bizCurrencyEntry));

		if ((this.editData.getAmountControlType() != null) && (AmountControlTypeEnum.oneTOmore.equals(this.editData.getAmountControlType()))) {
			this.kdtEntries.getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setHided(true);
		} else if (this.editData.getSourceBillId() == null) {
			this.kdtEntries.getColumn(this.TB_BUDGETAMOUNT).getStyleAttributes().setHided(true);
		}

		if ((this.isReceiveBill) && (this.editData.getState().getValue() >= 60)) {
			this.kdtEntries.getColumn("receiveState").getStyleAttributes().setHided(false);
		} else {
			this.kdtEntries.getColumn("receiveState").getStyleAttributes().setHided(true);
		}

		if ((this.isPayBill) && (this.editData.getState().getValue() >= 60)) {
			this.kdtEntries.getColumn("payState").getStyleAttributes().setHided(false);
		} else {
			this.kdtEntries.getColumn("payState").getStyleAttributes().setHided(true);
		}

		this.kdtEntries.addKDTEditListener(new KDTEditAdapter() {
			public void editStarting(KDTEditEvent e) {
				if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("expenseType")) {
					ExpenseTypePromptBox selector = (ExpenseTypePromptBox) BizAccountEditUI.this.bizPromptExpenseTypeEntry.getSelector();

					int rowIndex = e.getRowIndex();
					int colIndex = BizAccountEditUI.this.kdtEntries.getColumnIndex("company");
					int operationTypeIndex = BizAccountEditUI.this.kdtEntries.getColumnIndex("operationType");

					if (BizAccountEditUI.this.kdtEntries.getCell(rowIndex, operationTypeIndex).getValue() != null) {
						selector.getUiContext().put("operationTypeId", ((OperationTypeInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, operationTypeIndex).getValue()).getId().toString());
					} else {
						selector.getUiContext().put("operationTypeId", null);
					}

					if (BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue() != null) {
						String ln = ((CompanyOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue()).getLongNumber();

						String[] lnSecs = ln.split("!");
						int size = lnSecs.length;
						HashSet lnUps = new HashSet();
						for (int i = 0; i < size; ++i) {
							lnUps.add(lnSecs[i]);
						}
						selector.getUiContext().put("companyId", ((CompanyOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue()).getId().toString());

						selector.getUiContext().put("companyLongNumber", ((CompanyOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue()).getLongNumber());
					} else {
						selector.getUiContext().put("companyId", null);
					}
					if (BizAccountEditUI.this.kdtEntries.getCell(rowIndex, "costCenter").getValue() != null)
						selector.getUiContext().put("costCenterId", ((CostCenterOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, "costCenter").getValue()).getId().toString());
					else {
						selector.getUiContext().put("costCenterId", null);
					}
				}

				if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("operationType")) {
					OperationTypePromptBox selector = (OperationTypePromptBox) BizAccountEditUI.this.bizPromptOperationTypeEntry.getSelector();

					int rowIndex = e.getRowIndex();
					int colIndex = BizAccountEditUI.this.kdtEntries.getColumnIndex("company");

					if (BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue() != null) {
						selector.getUiContext().put("companyId", ((CompanyOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, colIndex).getValue()).getId().toString());
					} else {
						selector.getUiContext().put("companyId", null);
					}
					if (BizAccountEditUI.this.kdtEntries.getCell(rowIndex, "costCenter").getValue() != null)
						selector.getUiContext().put("costCenterId", ((CostCenterOrgUnitInfo) BizAccountEditUI.this.kdtEntries.getCell(rowIndex, "costCenter").getValue()).getId().toString());
					else {
						selector.getUiContext().put("costCenterId", null);
					}
				}

				if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("costCenter")) {
					IRow row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
					CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) (CompanyOrgUnitInfo) row.getCell("company").getValue();

					MakeControl.makeCostCenterF7(BizAccountEditUI.this.bizPromptCostCenterEntry, company, BizAccountEditUI.this.paramMap, BizAccountEditUI.this.OrgRangeSet);

					BizAccountEditUI.this.bizPromptCostCenterEntry.setDisplayFormat("$number$");
				}

				if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex(BizAccountEditUI.this.TB_PROJECT)) {
					IRow row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
					CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) (CompanyOrgUnitInfo) row.getCell("company").getValue();

					if (company != null)
						MakeControl.makeProject(BizAccountEditUI.this.bizPromptProjectEntry, company);
				}
			}

			public void editStopped(KDTEditEvent e) {
				IRow row = null;
				try {
					if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("costCenter")) {
						if ((e.getValue() != null) && (!(e.getValue().equals(e.getOldValue())))) {
							row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
							CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) e.getValue();

							BizAccountEditUI.this.clearEntryExpenseTypeByChangeEntryCoseCenter(costInfo.getId().toString(), row, BizAccountEditUI.this.BILLTYPE);
						}
						boolean isChanged = true;
						isChanged = BizCollUtil.isF7EditedChanged(e);
						if (!(isChanged)) {
							return;
						}

						if ((e.getValue() != null) && ((("ADDNEW".equals(BizAccountEditUI.this.getOprtState())) || ("EDIT".equals(BizAccountEditUI.this.getOprtState()))))) {
							row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
							CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) e.getValue();

							BizCollBillBaseInfo baseInfo = CommonUtilFacadeFactory.getRemoteInstance().forLoanBillCostCenterAction(costInfo);

							row.getCell("company").setValue(baseInfo.getCompany());
						}

					} else if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("expenseType")) {
						boolean isChanged = true;
						isChanged = BizCollUtil.isF7EditedChanged(e);
						if (!(isChanged)) {
							return;
						}
						if ((e.getValue() != null) && ((("ADDNEW".equals(BizAccountEditUI.this.getOprtState())) || ("EDIT".equals(BizAccountEditUI.this.getOprtState()))))) {
							row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
							ExpenseTypeInfo expenseTypeInfo;
							if (e.getValue() instanceof Object[]) {
								Object[] objs = (Object[]) (Object[]) e.getValue();
								ExpenseTypeInfo[] typeInfos = new ExpenseTypeInfo[objs.length];
								for (int i = 0; i < objs.length; ++i) {
									typeInfos[i] = ((ExpenseTypeInfo) objs[i]);
								}
								ExpenseTypeInfo expenseTypeInfo = typeInfos[0];
								BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex()).getCell("expenseType").setValue(expenseTypeInfo);

								BizAccountEditUI.this.addLine(BizAccountEditUI.this.kdtEntries, typeInfos);
							} else {
								ExpenseTypeInfo expenseTypeInfo;
								if (e.getValue() instanceof ExpenseTypeInfo) {
									expenseTypeInfo = (ExpenseTypeInfo) e.getValue();
								} else {
									expenseTypeInfo = null;
								}

							}

							String newOperationTypeId = null;
							String oldOperationTypeId = null;
							boolean isNeedChange = true;
							if (expenseTypeInfo.getOperationType() != null) {
								newOperationTypeId = expenseTypeInfo.getOperationType().getId().toString();
							}

							OperationTypeInfo operationTypeInfo = (OperationTypeInfo) (OperationTypeInfo) row.getCell("operationType").getValue();

							if (operationTypeInfo != null) {
								oldOperationTypeId = operationTypeInfo.getId().toString();
							}

							if ((newOperationTypeId != null) && (oldOperationTypeId != null) && (newOperationTypeId.equals(oldOperationTypeId))) {
								isNeedChange = false;
							}
							if ((isNeedChange) && (expenseTypeInfo != null)) {
								if (expenseTypeInfo.getOperationType() != null) {
									row.getCell("operationType").setValue(expenseTypeInfo.getOperationType());
								} else {
									row.getCell("operationType").setValue(null);
								}
							}

						}

					} else if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("operationType")) {
						boolean isChanged = true;
						isChanged = BizCollUtil.isF7EditedChanged(e);
						if (!(isChanged)) {
							return;
						}
						if ((e.getValue() != null) && ((("ADDNEW".equals(BizAccountEditUI.this.getOprtState())) || ("EDIT".equals(BizAccountEditUI.this.getOprtState()))))) {
							row = BizAccountEditUI.this.kdtEntries.getRow(e.getRowIndex());
							row.getCell("expenseType").setValue(null);
						}
					} else if (e.getColIndex() == BizAccountEditUI.this.kdtEntries.getColumnIndex("purpose")) {
						KDTableHelper.autoFitRowHeight(BizAccountEditUI.this.kdtEntries, e.getRowIndex());
					}
				} catch (BOSException e1) {
					BizAccountEditUI.logger.error(e1.getMessage());
				} catch (EASBizException e2) {
					if (row != null) {
						row.getCell("costCenter").setValue(null);
						row.getCell("company").setValue(null);
					}
					MsgBox.showError(e2.getMessage());
					BizAccountEditUI.logger.error(e2.getMessage());
				}
			}
		});
		this.kdtCollectionEntries.addKDTEditListener(new KDTEditAdapter() {
			public void editStarting(KDTEditEvent e) {
				if (e.getColIndex() == BizAccountEditUI.this.kdtCollectionEntries.getColumnIndex("currencyType")) {
					BizAccountEditUI.this.updateCurrencyMap();
					EntityViewInfo view = new EntityViewInfo();
					FilterInfo filter = new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("id", BizAccountEditUI.this.currencyMap.keySet(), CompareType.INCLUDE));
					view.setFilter(filter);
					BizAccountEditUI.this.currencyPrompt.setEntityViewInfo(view);
				}
			}

			public void editStopped(KDTEditEvent e) {
				boolean isChanged = false;
				isChanged = BizCollUtil.isF7EditedChanged(e);
				if (!(isChanged))
					return;
				IRow row = BizAccountEditUI.this.kdtCollectionEntries.getRow(e.getRowIndex());
				if (e.getColIndex() == BizAccountEditUI.this.kdtCollectionEntries.getColumnIndex("amountOri")) {
					BigDecimal amountOR = new BigDecimal(0);
					if (e.getValue() != null) {
						amountOR = new BigDecimal(e.getValue().toString());
					}
					if (amountOR.compareTo(ExpenseAccountEditUI.ZERO) < 0) {
						amountOR = ExpenseAccountEditUI.ZERO;
						row.getCell("amountOri").setValue(ExpenseAccountEditUI.ZERO);
					}
					BigDecimal exchange = new BigDecimal(0);
					if (row.getCell("exchangeRate").getValue() != null) {
						exchange = new BigDecimal(row.getCell("exchangeRate").getValue().toString());
					}

					ConvertModeEnum convertMode = ConvertModeEnum.DIRECTEXCHANGERATE;
					if (row.getCell("convertMode").getValue() != null) {
						convertMode = (ConvertModeEnum) row.getCell("convertMode").getValue();
					}

					BigDecimal amount = new BigDecimal(0);
					if (convertMode.equals(ConvertModeEnum.DIRECTEXCHANGERATE))
						amount = amountOR.multiply(exchange).setScale(2, 4);
					else {
						amount = amountOR.divide(exchange, 2, 4);
					}
					row.getCell("amount").setValue(amount);
					BizAccountEditUI.this.calculateColumnAmount(BizAccountEditUI.this.kdtCollectionEntries, BizAccountEditUI.this.kdtCollectionEntries.getColumnIndex("amount"));
				} else if (e.getColIndex() == BizAccountEditUI.this.kdtCollectionEntries.getColumnIndex("currencyType")) {
					if (e.getValue() == null) {
						row.getCell("exchangeRate").getFormattedStyleAttributes().setNumberFormat(BizCollUtil.getFormatString(4));
						row.getCell("exchangeRate").setValue(new BigDecimal(1.0D));
						row.getCell("amountOri").setValue(new BigDecimal(0.0D));
						row.getCell("amount").setValue(new BigDecimal(0.0D));
					} else {
						String currencyId = ((CurrencyInfo) e.getValue()).getId().toString();
						Map map = (Map) BizAccountEditUI.this.currencyMap.get(currencyId);
						BigDecimal exchangeRate = new BigDecimal(1.0D);
						if (map.get("exchangeRate") != null) {
							exchangeRate = new BigDecimal(map.get("exchangeRate").toString());
						}
						ConvertModeEnum convertMode = ConvertModeEnum.DIRECTEXCHANGERATE;
						if (map.get("convertMode") != null) {
							convertMode = (ConvertModeEnum) map.get("convertMode");
						}
						BigDecimal exchangeRatePrecision = new BigDecimal(4);
						if (map.get("exchangeRatePrecision") != null) {
							exchangeRatePrecision = new BigDecimal(map.get("exchangeRatePrecision").toString());
						}
						BigDecimal amountOR = new BigDecimal(0);
						if (row.getCell("amountOri").getValue() != null) {
							amountOR = new BigDecimal(row.getCell("amountOri").getValue().toString());
						}
						BigDecimal amount = new BigDecimal(0);
						if (convertMode.equals(ConvertModeEnum.DIRECTEXCHANGERATE))
							amount = amountOR.multiply(exchangeRate).setScale(2, 4);
						else {
							amount = amountOR.divide(exchangeRate, 2, 4);
						}
						row.getCell("exchangeRate").getFormattedStyleAttributes().setNumberFormat(BizCollUtil.getFormatString(Integer.valueOf(exchangeRatePrecision.toString()).intValue()));
						row.getCell("exchangeRate").setValue(exchangeRate);
						row.getCell("convertMode").setValue(convertMode);
						row.getCell("exchangeRatePrecision").setValue(exchangeRatePrecision);
						row.getCell("amount").setValue(amount);
					}
					BizAccountEditUI.this.calculateColumnAmount(BizAccountEditUI.this.kdtCollectionEntries, BizAccountEditUI.this.kdtCollectionEntries.getColumnIndex("amount"));
				}
			}
		});
	}

	private void updateCurrencyMap() {
		Map map = null;
		this.currencyMap.clear();
		int i = 0;
		for (int size = this.kdtEntries.getRowCount(); i < size; ++i) {
			IRow row = this.kdtEntries.getRow(i);
			CurrencyInfo currency = (CurrencyInfo) row.getCell("currencyType").getValue();
			if (currency != null) {
				BigDecimal exchangeRate = new BigDecimal(1.0D);
				if ((row.getCell("exchangeRate") != null) && (row.getCell("exchangeRate").getValue() != null)) {
					exchangeRate = new BigDecimal(row.getCell("exchangeRate").getValue().toString());
				}
				ConvertModeEnum convertMode = ConvertModeEnum.DIRECTEXCHANGERATE;
				if ((row.getCell("convertMode") != null) && (row.getCell("convertMode").getValue() != null)) {
					convertMode = (ConvertModeEnum) row.getCell("convertMode").getValue();
				}
				BigDecimal exchangeRatePrecision = new BigDecimal(4);
				if ((row.getCell("exchangeRatePrecision") != null) && (row.getCell("exchangeRatePrecision").getValue() != null)) {
					exchangeRatePrecision = new BigDecimal(row.getCell("exchangeRatePrecision").getValue().toString());
				}
				map = new HashMap();
				map.put("exchangeRate", exchangeRate);
				map.put("convertMode", convertMode);
				map.put("exchangeRatePrecision", exchangeRatePrecision);
				this.currencyMap.put(currency.getId().toString(), map);
			}
		}
		map = new HashMap();
		map.put("exchangeRate", new BigDecimal(1.0D));
		map.put("convertMode", ConvertModeEnum.DIRECTEXCHANGERATE);
		map.put("exchangeRatePrecision", new BigDecimal(4));
		this.currencyMap.put(this.editData.getCurrencyType().getId().toString(), map);
	}

	public void loadFields() {
		if (this.editData == null) {
			return;
		}

		this.isLoadFieldAction = true;
		super.loadFields();

		int i = 0;
		for (int n = this.kdtEntries.getRowCount(); i < n; ++i) {
			IRow row = this.kdtEntries.getRow(i);
			int precision = 4;
			Object value = row.getCell("exchangeRatePrecision").getValue();
			if ((value != null) && (value instanceof Integer)) {
				precision = ((Integer) value).intValue();
			}
			row.getCell("exchangeRate").setEditor(new KDTDefaultCellEditor(BizCollUtil.getMoneyEditor(precision)));
		}

		this.oldData.setString("number", this.editData.getNumber());
		lockColumByState();
		this.isLoadFieldAction = false;
		setIsMoreSourceBill();
		initDefaultLines(this.kdtCollectionEntries);
		calculateColumnAmount(this.kdtCollectionEntries, this.kdtCollectionEntries.getColumnIndex("amount"));
	}

	public void storeFields() {
		super.storeFields();

		if (this.kdtCollectionEntries.getRowCount() > 0)
			bindTableToData(this.kdtCollectionEntries, this.editData.getCollectionEntries());
	}

	public void bindTableToData(KDTable table, IObjectCollection detailCollection) {
		if (detailCollection == null)
			return;
		detailCollection.clear();

		int i = 0;
		for (int n = table.getRowCount(); i < n; ++i) {
			IRow row = table.getRow(i);
			if (checkIsCountLine(row))
				continue;
			if ((row.getCell(this.TB_AMOUNT) == null) || (row.getCell(this.TB_AMOUNT).getValue() == null))
				continue;
			if (new BigDecimal(row.getCell(this.TB_AMOUNT).getValue().toString()).compareTo(ZERO) <= 0)
				continue;
			IObjectValue obj = (IObjectValue) row.getUserObject();

			if (detailCollection.addObject(obj))
				storeLineFields(table, row, obj);
		}
	}

	protected IObjectValue createNewDetailData(KDTable table) {
		BizAccountBillEntryInfo lineInfo = new BizAccountBillEntryInfo();
		try {
			BizCollBillBaseInfo baseInfo = CommonUtilFacadeFactory.getRemoteInstance().forLoanBillCreateNewData();

			if (!(this.isFromCopyLine)) {
				lineInfo.setCostCenter(baseInfo.getCostedDept());
				lineInfo.setCompany(baseInfo.getCompany());
			}

			CurrencyInfo currencyInfo = new CurrencyInfo();
			try {
				currencyInfo = (CurrencyInfo) this.bizPromptCurrencyType.getData();
				if (currencyInfo == null)
					currencyInfo = (CurrencyInfo) CurrencyFactory.getRemoteInstance().getValue(new ObjectUuidPK(SysContext.getSysContext().getCurrentFIUnit().getBaseCurrency().getId()));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			lineInfo.setCurrencyType(currencyInfo);
			int ratePrecision = 4;
			ExchangeRateInfo exchangeRate = BizCollUtil.getExRateInfo(currencyInfo.getId().toString(), null, SysContext.getSysContext().getCurrentFIUnit(), new Date());
			if (exchangeRate != null) {
				rate = exchangeRate.getConvertRate();
			}
			if ((exchangeRate != null) && (exchangeRate.getExchangeAux() != null) && (exchangeRate.getExchangeAux().getConvertMode() != null)) {
				ratePrecision = exchangeRate.getExchangeAux().getPrecision();
			}

			lineInfo.setExchangeRatePrecision(ratePrecision);

			lineInfo.setExchangeRate(new BigDecimal("1.0000"));
			lineInfo.setPayState(EntryStateEnum.UNDONE);
			lineInfo.setReceiveState(EntryStateEnum.UNDONE);
		} catch (EASBizException e) {
			logger.error(e.getMessage());
		} catch (BOSException e) {
			logger.error(e.getMessage());
		}
		lineInfo.setAmount(new BigDecimal("0.00"));
		if (this.isInitAmountApproved) {
			lineInfo.setAmountApproved(lineInfo.getAmount());
		}
		lineInfo.setBudgetDo(new BigDecimal("0.00"));

		return lineInfo;
	}

	protected void addLine(KDTable table, ExpenseTypeInfo[] expenseTypeInfos) {
		if ((expenseTypeInfos != null) && (expenseTypeInfos.length > 1))
			for (int i = 1; i < expenseTypeInfos.length; ++i) {
				BizAccountBillEntryInfo detailData = (BizAccountBillEntryInfo) createNewDetailData(table);
				detailData.setExpenseType(expenseTypeInfos[i]);
				detailData.setOperationType(expenseTypeInfos[i].getOperationType());
				IRow row = null;

				if (table.getRowCount() > 0)
					row = table.addRow();
				else {
					row = table.addRow();
				}
				loadLineFields(table, row, detailData);
				afterAddLine(table, detailData);
			}
	}

	protected KDTable getDetailTable() {
		return this.kdtEntries;
	}

	protected KDTable getReqCheckTable() {
		return this.kdtReqCheckEntries;
	}

	protected KDTable getLoanCheckTable() {
		return this.kdtLoanCheckEntries;
	}

	private void bindNumber() {
	}

	protected IObjectValue createNewData() {
		BizAccountBillInfo info = new BizAccountBillInfo();
		try {
			info.setName(BizCollBillTypeEnum.BIZ_ACCOUNT.toString());
			buildData(info);

			info.getEntries().add((BizAccountBillEntryInfo) createNewDetailData(getDetailTable()));

			UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();

			info.setCreator(userInfo);

			BizCollUtil.initDefaultCollectionEntry(null, info, userInfo.getPerson().getId().toString());
		} catch (Exception e) {
			handUIException(e);
		}

		return info;
	}

	protected void checkEntry(KDTable table) throws Exception {
		super.checkEntry(table);
		int rows = getDetailTable().getRowCount();
		IRow row = null;

		KDTEditManager kdtManager = getDetailTable().getEditManager();
		for (int i = 0; i < rows; ++i) {
			row = getDetailTable().getRow(i);

			if (objectIsNull(row.getCell("happenTime").getValue())) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("happenTime"));

				throw new ExpAccException(ExpAccException.HAPPENDATA_NOT_NULL);
			}

			ExpenseTypeInfo expenseTypeInfo = (ExpenseTypeInfo) row.getCell(this.TB_EXPENSETYPE).getValue();

			if (expenseTypeInfo == null) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex(this.TB_EXPENSETYPE));

				throw new ExpAccException(ExpAccException.EXPENSE_TYPE_NOT_NULL);
			}

			if (BizCollUtil.objectIsNull(row.getCell("currencyType").getValue())) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("currencyType"));
				throw new ExpAccException(ExpAccException.CUR_NOT_NULL);
			}

			if (BizCollUtil.objectIsNull(row.getCell("exchangeRate").getValue())) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("exchangeRate"));

				throw new ExpAccException(ExpAccException.EXCHANGERATENOTNULL);
			}

			BigDecimal amount = (BigDecimal) row.getCell(this.TB_AMOUNT).getValue();
			String sourceId = this.editData.getSourceBillId();
			if (sourceId != null) {
				if ((amount == null) || (amount.compareTo(new BigDecimal("0.00")) < 0)) {
					kdtManager.editCellAt(i, getDetailTable().getColumnIndex("amount"));

					throw new ExpAccException(ExpAccException.AMOUNTNOTLESSTHENZERO);
				}
			} else if ((amount == null) || (amount.compareTo(new BigDecimal("0.00")) <= 0)) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("amount"));

				throw new ExpenseReqException(ExpenseReqException.NEGTIVE_ENTRY_AMOUNT_ERROR);
			}

			BigDecimal amountApproved = (BigDecimal) row.getCell(this.TB_AMOUNTAPPROVED).getValue();

			if ((amountApproved != null) && (amountApproved.compareTo(new BigDecimal("0.00")) < 0)) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex(this.TB_AMOUNTAPPROVED));

				throw new ExpAccException(ExpAccException.APPROVEDACOUNT_NOTNULL);
			}

			if (("amountApproved".equals(this.oprtState)) && (isFromWorkFlow()) && (((amountApproved == null) || (amountApproved.intValue() < 0)))) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex(this.TB_AMOUNTAPPROVED));

				throw new ExpAccException(ExpAccException.APPROVEDACOUNT_NOTNULL);
			}

			if (!(BizCollUtil.bigDecimalObjectLessThan(row.getCell(this.TB_AMOUNTAPPROVED).getValue(), amount))) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex(this.TB_AMOUNTAPPROVED));

				throw new ExpAccException(ExpAccException.APPROVED_GT_AMOUNT);
			}
			if (row.getCell("costCenter").getValue() == null) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("costCenter"));

				throw new ExpAccException(ExpAccException.ENTRY_COSTCENTER_NOT_NULL);
			}

			if (row.getCell("company").getValue() == null) {
				kdtManager.editCellAt(i, getDetailTable().getColumnIndex("company"));

				throw new ExpAccException(ExpAccException.ENTRY_COMPANY_NOT_NULL);
			}
		}
	}

	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
		int rows = getDetailTable().getRowCount();
		IRow row = null;
		boolean continueSubmit = false;
		for (int i = 0; i < rows; ++i) {
			row = getDetailTable().getRow(i);
			BigDecimal amountApproved = (BigDecimal) row.getCell(this.TB_AMOUNTAPPROVED).getValue();

			if ((!("amountApproved".equals(getOprtState()))) || (!(isFromWorkFlow())) || (amountApproved.compareTo(new BigDecimal("0.00")) != 0))
				continue;
			if ((!(continueSubmit)) && (MsgBox.showConfirm2(EASResource.getString("com.kingdee.eas.cp.bc.BizCollResource", "approvedIsZero")) != 0)) {
				abort();
			} else
				continueSubmit = true;
		}
	}

	protected void checkPassBgAudit() throws EASBizException, BOSException {
		int rows = getDetailTable().getRowCount();
		IRow row = null;
		List entryList = new ArrayList();
		List list = null;
		for (int i = 0; i < rows; ++i) {
			row = getDetailTable().getRow(i);
			if (!(this.isNeedBudget))
				continue;
			ExpenseTypeInfo expenseTypeInfo = (ExpenseTypeInfo) row.getCell(this.TB_EXPENSETYPE).getValue();

			if ((this.editData.getState().getValue() > 25) || (BizCollUtil.objectIsNull(this.dateBizReqDate.getValue())) || (this.bizPromptCostedDept.getData() == null) || (this.bizPromptCompany.getData() == null)) {
				continue;
			}

			BizCollBillBaseInfo baseInfo = (BizCollBillBaseInfo) this.editData.clone();

			baseInfo.setBizReqDate(this.dateBizReqDate.getSqlDate());

			baseInfo.setCostedDept((CostCenterOrgUnitInfo) this.bizPromptCostedDept.getData());

			baseInfo.setCompany((CompanyOrgUnitInfo) this.bizPromptCompany.getData());

			BigDecimal entryAmount = (BigDecimal) row.getCell(this.TB_AMOUNT).getValue();

			BigDecimal entryBugdetAmount = (BigDecimal) row.getCell(this.TB_BUDGETAMOUNT).getValue();

			if (entryBugdetAmount != null) {
				entryAmount = entryAmount.subtract(entryBugdetAmount);
			}

			baseInfo.setAmount(entryAmount);
			list = new ArrayList();
			list.add(baseInfo);
			list.add(expenseTypeInfo);
			entryList.add(list);
		}

		ExpenseTypeInfo expInfo = CommonUtilFacadeFactory.getRemoteInstance().isPassBgAudit(entryList);

		if (expInfo != null) {
			String s = EASResource.getString("com.kingdee.eas.cp.bc.BizCollResource", "NOBUDGETAMOUNT");
			s = expInfo.getTypeName() + s;
			MsgBox.showError(this, s);
			setCursorOfDefault();
			SysUtil.abort();
		}
	}

	public SelectorItemCollection getSelectors() {
		SelectorItemCollection sic = super.getSelectors();
		if (sic == null) {
			sic = new SelectorItemCollection();
		}
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("applier.id"));
		sic.add(new SelectorItemInfo("applier.number"));
		sic.add(new SelectorItemInfo("applier.name"));
		sic.add(new SelectorItemInfo("position.number"));
		sic.add(new SelectorItemInfo("position.name"));
		sic.add(new SelectorItemInfo("tel"));
		sic.add(new SelectorItemInfo("orgUnit.number"));
		sic.add(new SelectorItemInfo("orgUnit.name"));
		sic.add(new SelectorItemInfo("bizReqDate"));
		sic.add(new SelectorItemInfo("cause"));
		sic.add(new SelectorItemInfo("prior"));
		sic.add(new SelectorItemInfo("cu.*"));
		sic.add(new SelectorItemInfo("state"));
		sic.add(new SelectorItemInfo("billDate"));
		sic.add(new SelectorItemInfo("biller.id"));
		sic.add(new SelectorItemInfo("biller.name"));
		sic.add(new SelectorItemInfo("biller.number"));
		sic.add(new SelectorItemInfo("costedDept.number"));
		sic.add(new SelectorItemInfo("costedDept.name"));
		sic.add(new SelectorItemInfo("company.id"));
		sic.add(new SelectorItemInfo("company.number"));
		sic.add(new SelectorItemInfo("company.name"));
		sic.add(new SelectorItemInfo("company.longNumber"));
		sic.add(new SelectorItemInfo("company.baseCurrency"));
		sic.add(new SelectorItemInfo("company.baseExchangeTable"));
		sic.add(new SelectorItemInfo("supportedObj.number"));
		sic.add(new SelectorItemInfo("supportedObj.name"));
		sic.add(new SelectorItemInfo("currencyType.name"));
		sic.add(new SelectorItemInfo("currencyType.number"));
		sic.add(new SelectorItemInfo("expenseType.typeName"));
		sic.add(new SelectorItemInfo("expenseType.number"));
		sic.add(new SelectorItemInfo("amount"));
		sic.add(new SelectorItemInfo("budgetAmount"));
		sic.add(new SelectorItemInfo("budgetBalance"));
		sic.add(new SelectorItemInfo("amountSendedBack"));
		sic.add(new SelectorItemInfo("amountApproved"));
		sic.add(new SelectorItemInfo("amountStriked"));
		sic.add(new SelectorItemInfo("amountEncashed"));
		sic.add(new SelectorItemInfo("amountPaid"));
		sic.add(new SelectorItemInfo("amountNotPaid"));
		sic.add(new SelectorItemInfo("amountRefunded"));
		sic.add(new SelectorItemInfo("sourceBillId"));
		sic.add(new SelectorItemInfo("payMode.number"));
		sic.add(new SelectorItemInfo("payMode.name"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("description"));
		sic.add(new SelectorItemInfo("lastUpdateUser.id"));
		sic.add(new SelectorItemInfo("lastUpdateUser.number"));
		sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		sic.add(new SelectorItemInfo("lastUpdateTime"));

		sic.add(new SelectorItemInfo("auditor.id"));
		sic.add(new SelectorItemInfo("auditor.name"));
		sic.add(new SelectorItemInfo("auditDate"));
		sic.add(new SelectorItemInfo("sourceBillId"));

		sic.add(new SelectorItemInfo("postAddress.id"));
		sic.add(new SelectorItemInfo("postAddress.name"));
		sic.add(new SelectorItemInfo("postAddress.number"));

		sic.add(new SelectorItemInfo("accessoryCount"));

		sic.add(new SelectorItemInfo("entries.*"));
		sic.add(new SelectorItemInfo("entries.operationType.*"));
		sic.add(new SelectorItemInfo("entries.costCenter.*"));
		sic.add(new SelectorItemInfo("entries.expenseType.*"));
		sic.add(new SelectorItemInfo("entries.project.*"));
		sic.add(new SelectorItemInfo("entries.company.*"));
		sic.add(new SelectorItemInfo("entries.currencyType.*"));

		sic.add(new SelectorItemInfo("creator"));
		sic.add(new SelectorItemInfo("applierCompany.id"));
		sic.add(new SelectorItemInfo("applierCompany.number"));
		sic.add(new SelectorItemInfo("applierCompany.name"));
		sic.add(new SelectorItemInfo("amountControlType"));

		sic.add(new SelectorItemInfo("collectionEntries.*"));
		sic.add(new SelectorItemInfo("ReqCheckEntries.*"));
		sic.add(new SelectorItemInfo("LoanCheckEntries.*"));
		sic.add(new SelectorItemInfo("IsRefPaperPark"));
		sic.add(new SelectorItemInfo("imageno"));

		sic.add(new SelectorItemInfo("CollectionAccount.*"));

		sic.add(new SelectorItemInfo("payerBankStr.name"));
		sic.add(new SelectorItemInfo("payerBankStr.number"));

		sic.add(new SelectorItemInfo("payerBank"));

		sic.add(new SelectorItemInfo("openArea.name"));
		sic.add(new SelectorItemInfo("openArea.number"));
		sic.add(new SelectorItemInfo("payerName"));
		sic.add(new SelectorItemInfo("payerAccount"));
		sic.add(new SelectorItemInfo("actionFlag"));

		return sic;
	}

	protected BizCollBillTypeEnum[] getCountBillType() {
		return billTypes;
	}

	protected ICoreBase getBizInterface() throws Exception {
		return BizAccountBillFactory.getRemoteInstance();
	}

	public void setDataObject(IObjectValue dataObject) {
		super.setDataObject(dataObject);
	}

	protected boolean isRowNoEqual(KDTSelectEvent rowE) {
		boolean flag = false;
		Map ctx = getUIContext();
		int col = rowE.getSelectBlock().getEndCol();
		int row = rowE.getSelectBlock().getEndRow();

		if (ctx.get("oldRowId") == null) {
			ctx.put("oldRowId", row + "");
			flag = true;
		} else {
			int oldId = Integer.parseInt(ctx.get("oldRowId") + "");
			ctx.put("oldRowId", row + "");
			if (oldId != row) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean isNeedShowBOTPRule() {
		return true;
	}

	protected void showBgAuditInLabel(DataChangeEvent e) throws Exception {
		if (this.isLoadFieldAction) {
			return;
		}
		storeFields();
		if (this.editData == null)
			return;
		IExpenseCommenFacade iExpenseCommenFacade = ExpenseCommenFacadeFactory.getRemoteInstance();

		int[] rows = KDTableUtil.getSelectedRows(getDetailTable());
		if (!(BizCollUtil.objectIsNull(this.dateBizReqDate.getValue()))) {
			Map map = new HashMap();
			String labelText = null;
			if (rows.length > 0) {
				if (rows[0] < 0) {
					return;
				}
				IRow row = getDetailTable().getRow(rows[0]);
				if (row.getUserObject() != null) {
					map.put("entry", row.getUserObject());
				}
				if (row.getCell("sourceEntryId").getValue() != null) {
					map.put("sourceEntryId", row.getCell("sourceEntryId").getValue().toString());
				}
				labelText = iExpenseCommenFacade.getBudget(this.editData, this.editData.getId(), map);
			}

			if (labelText == null) {
				this.bgScrol.setVisible(false);
				return;
			}
			this.bgScrol.setVisible(true);
			this.bgText.setVisible(true);
			this.bgText.setText(labelText);
			this.bgText.setToolTipText(labelText);
		} else {
			this.bgScrol.setVisible(false);
		}
	}

	protected void setFieldsNull(AbstractObjectValue newData) {
		super.setFieldsNull(newData);
		setParentFieldsNull(newData);
		BizAccountBillInfo data = null;
		BizAccountBillEntryInfo entryInfo = null;
		this.kDReqContainer.setVisible(false);
		if (this.kDTabbedPane.getTabCount() > 3) {
			this.kDTabbedPane.remove(3);
		}

		if ((newData != null) && (newData instanceof BizAccountBillInfo)) {
			data = (BizAccountBillInfo) newData;
			BizAccountBillEntryCollection entries = data.getEntries();
			if (entries == null) {
				return;
			}
			for (int i = 0; i < entries.size(); ++i) {
				entryInfo = entries.get(i);
				entryInfo.setBudgetAmount(null);
				entryInfo.setSourceBillEntryID(null);
				entryInfo.setSourceBillID(null);
				entryInfo.setSourceBillNumber(null);
			}
		}
	}

	public void actionCreateToReceiveBill_actionPerformed(ActionEvent e) throws Exception {
		KDTable table = getDetailTable();
		if (table == null) {
			return;
		}
		int[] rows = KDTableUtil.getSelectedRows(table);
		BizAccountBillEntryInfo detailData = null;
		boolean flag = true;
		for (int i = 0; i < rows.length; ++i) {
			detailData = (BizAccountBillEntryInfo) table.getRow(rows[i]).getUserObject();

			if (!(detailData.getReceiveState().equals(EntryStateEnum.ISRECEIVEBILL)))
				continue;
			flag = false;
			break;
		}

		if (flag)
			super.actionCreateTo_actionPerformed(e);
	}

	public void actionCreateToPayBill_actionPerformed(ActionEvent e) throws Exception {
		KDTable table = getDetailTable();
		if (table == null) {
			return;
		}
		int[] rows = KDTableUtil.getSelectedRows(table);
		BizAccountBillEntryInfo detailData = null;
		boolean flag = true;
		for (int i = 0; i < rows.length; ++i) {
			detailData = (BizAccountBillEntryInfo) table.getRow(rows[i]).getUserObject();

			if (detailData.getPayState().equals(EntryStateEnum.ISDEALBILL)) {
				flag = false;
				break;
			}
		}
		if (flag)
			super.actionCreateTo_actionPerformed(e);
	}

	public void updateReqDateAction_actionPerformed(ActionEvent e) throws Exception {
		super.updateReqDateAction_actionPerformed(e);

		BizAccountBillInfo info = BizAccountBillFactory.getRemoteInstance().getBizAccountBillInfo(new ObjectUuidPK(this.editData.getId().toString()));

		this.dateBizReqDate.setValue(info.getBizReqDate());
	}

	public void actionViewRrcdsOfLendAndRepay_actionPerformed(ActionEvent e) throws Exception {
		Map ctx = perpareForUIContext();
		if (ctx.get("applier") == null) {
			String s = EASResource.getString("com.kingdee.eas.cp.bc.BizCollResource", "apllierCanNotNull");
			MsgBox.showError(this, s);
			SysUtil.abort();
		}
		IUIFactory uiFactory = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory");

		IUIWindow messageDialog = uiFactory.create(RecordsOfLendAndRepayUI.class.getName(), ctx);

		messageDialog.show();
	}

	private Map perpareForUIContext() {
		Map ctx = new HashMap();
		ctx.put("applier", this.bizPromptApplier.getValue());
		Date templeDate = (Date) this.dateBillDate.getValue();
		Timestamp createTime = new Timestamp(templeDate.getTime());
		ctx.put("createTime", createTime);
		ctx.put("Owner", this);
		return ctx;
	}

	protected boolean checkMoveLine() {
		return (getDetailTable().getSelectManager().size() != 0);
	}

	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("isDefault", Boolean.valueOf(true)));

			viewInfo.setFilter(filter);
			request.put("viewInfo", viewInfo);
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
	}

	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
		RequestContext request = super.prepareActionSubmit(itemAction);
		if (request != null) {
			request.setClassName(getUIHandlerClassName());
			List entryList = getPassBgParam();
			request.put("entryList", entryList);
		}
		return request;
	}

	public List getPassBgParam() throws EASBizException, BOSException {
		int rows = getDetailTable().getRowCount();
		IRow row = null;
		List entryList = new ArrayList();
		List list = null;
		for (int i = 0; i < rows; ++i) {
			row = getDetailTable().getRow(i);
			if (!(this.isNeedBudget))
				continue;
			ExpenseTypeInfo expenseTypeInfo = (ExpenseTypeInfo) row.getCell(this.TB_EXPENSETYPE).getValue();

			if ((this.editData.getState().getValue() > 25) || (BizCollUtil.objectIsNull(this.dateBizReqDate.getValue())) || (this.bizPromptCostedDept.getData() == null) || (this.bizPromptCompany.getData() == null)) {
				continue;
			}

			BizCollBillBaseInfo baseInfo = (BizCollBillBaseInfo) this.editData.clone();

			baseInfo.setBizReqDate(this.dateBizReqDate.getSqlDate());

			baseInfo.setCostedDept((CostCenterOrgUnitInfo) this.bizPromptCostedDept.getData());

			baseInfo.setCompany((CompanyOrgUnitInfo) this.bizPromptCompany.getData());

			BigDecimal entryAmount = (BigDecimal) row.getCell(this.TB_AMOUNT).getValue();

			BigDecimal entryBugdetAmount = (BigDecimal) row.getCell(this.TB_BUDGETAMOUNT).getValue();

			if (entryBugdetAmount != null) {
				entryAmount = entryAmount.subtract(entryBugdetAmount);
			}

			baseInfo.setAmount(entryAmount);
			list = new ArrayList();
			list.add(baseInfo);
			list.add(expenseTypeInfo);
			entryList.add(list);
		}

		return entryList;
	}

	public boolean isPrepareActionShowBg() {
		return true;
	}

	public boolean isPrepareActionSubmit() {
		return true;
	}

	public boolean isPrepareActionSave() {
		return true;
	}

	public boolean isPrepareActionViewRrcdsOfLendAndRepay() {
		return true;
	}

	public boolean isPrepareInit() {
		return true;
	}

	public boolean isPrepareActionMultiapprove() {
		return true;
	}

	public boolean isPrepareActionViewDoProccess() {
		return true;
	}

	public boolean isPrepareActionWorkFlowG() {
		return true;
	}

	public boolean isPrepareInitUIData() {
		return super.isPrepareInitUIData();
	}

	public boolean isPrepareActionTraceUp() {
		return true;
	}

	public boolean isPrepareActionTraceDown() {
		return true;
	}

	public boolean isPrepareActionCopy() {
		return super.isPrepareActionCopy();
	}

	protected void setAutoNumberByOrg(String orgType) {
		try {
			String companyID = null;
			if ((!(StringUtils.isEmpty(orgType))) && (!("NONE".equalsIgnoreCase(orgType))) && (SysContext.getSysContext().getCurrentOrgUnit(OrgType.getEnum(orgType)) != null)) {
				companyID = SysContext.getSysContext().getCurrentOrgUnit(OrgType.getEnum(orgType)).getString("id");
			} else if (SysContext.getSysContext().getCurrentOrgUnit() != null) {
				companyID = SysContext.getSysContext().getCurrentOrgUnit().getString("id");
			}

			boolean isCUAttributeExist = false;
			if (this.editData.getCU() != null)
				isCUAttributeExist = true;
			else {
				this.editData.setCU((CtrlUnitInfo) SysContext.getSysContext().getCurrentOrgUnit(OrgType.ControlUnit));
			}

			ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getRemoteInstance();

			if (iCodingRuleManager.isExist(this.editData, companyID)) {
				if ((this.editData.getNumber() == null) && (iCodingRuleManager.isAddView(this.editData, companyID))) {
					this.editData.setNumber(iCodingRuleManager.getNumber(this.editData, companyID));
				}

				this.txtNumber.setEnabled(false);
				RuleStatus rs = iCodingRuleManager.getRuleStatus(this.editData, companyID);

				if ((rs != null) && (rs.isModifiable())) {
					this.txtNumber.setEnabled(true);
				}
			}

			if (!(isCUAttributeExist)) {
				this.editData.setCU(null);
			}
			if ((this.editData.getNumber() != null) && (this.editData.getNumber().trim().length() > 0))
				this.txtNumber.setText(this.editData.getNumber());
		} catch (Exception e) {
			handUIException(e);
			this.oldData = this.editData;
			SysUtil.abort();
		}
	}

	protected void kdtEntries_propertyChange(KDTPropertyChangeEvent e) throws Exception {
		if ((((e.getColIndex() == this.kdtEntries.getColumnIndex(this.TB_EXPENSETYPE)) || (e.getColIndex() == this.kdtEntries.getColumnIndex("costCenter")) || (e.getColIndex() == this.kdtEntries.getColumnIndex(this.TB_PROJECT)))) && (this.isShowBgAudit) && (BizCollUtil.isHasPermission("cp_bc_ExpenseAccount_Budget"))) {
			showBgAuditInLabel(null);
		}

		kdtEntriespropertyChange(e, this.kdtEntries);
	}

	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopy_actionPerformed(e);
		purpose_autoFitRowHeight();
	}

	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionSave_actionPerformed(e);

		purpose_autoFitRowHeight();
	}

	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);

		purpose_autoFitRowHeight();
	}

	public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyLine_actionPerformed(e);
		purpose_autoFitRowHeight();
	}

	public void actionAddReqLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddReqLine_actionPerformed(e);
		SysContext.getSysContext().setProperty("checkSourceIds", null);
		showCheckSourceUI("otherExpense", BizCollBillTypeEnum.BIZ_ACCOUNT, this.kdtReqCheckEntries, null);
		if (SysContext.getSysContext().getProperty("checkSourceIds") != null) {
			List list = (List) SysContext.getSysContext().getProperty("checkSourceIds");
			initCheckEntryLine(list, this.kdtReqCheckEntries, "bizreq");
		}
	}

	public void actionAddLoanLine_actionPerformed(ActionEvent e) throws Exception {
		if ((this.editData.getSourceBillId() != null) && (BizCollUtil.isOtherExpense(this.editData.getSourceBillId())) && (this.kdtReqCheckEntries.getRowCount() <= 0)) {
			throw new ExpAccException(ExpAccException.MUSTSELECTREQCHECK);
		}
		super.actionAddLoanLine_actionPerformed(e);
		SysContext.getSysContext().setProperty("checkSourceIds", null);
		showCheckSourceUI("dailyLoan", BizCollBillTypeEnum.BIZ_ACCOUNT, this.kdtLoanCheckEntries, null);
		if (SysContext.getSysContext().getProperty("checkSourceIds") != null) {
			List list = (List) SysContext.getSysContext().getProperty("checkSourceIds");
			initCheckEntryLine(list, this.kdtLoanCheckEntries, "bizloan");
		}
	}

	public void actionDelReqLine_actionPerformed(ActionEvent e) throws Exception {
		if (this.kdtReqCheckEntries.getRowCount() <= 0) {
			throw new ExpAccException(ExpAccException.BOTPREQCHECKCANNOTNULL);
		}
		actionRemoveCheckLine_actionPerformed(e, this.kdtReqCheckEntries);
	}

	public void actionDelLoanLine_actionPerformed(ActionEvent e) throws Exception {
		actionRemoveCheckLine_actionPerformed(e, this.kdtLoanCheckEntries);
	}

	public void onShow() throws Exception {
		super.onShow();
		purpose_autoFitRowHeight();
		if (getUIContext().get("bcShare") != null) {
			setBcShareButton();
		} else
			setBcButton();
	}

	public void purpose_autoFitRowHeight() {
		this.kdtEntries.getColumn("purpose").getStyleAttributes().setWrapText(true);
		int rowSize = this.kdtEntries.getRowCount();
		for (int i = 0; i < rowSize; ++i)
			KDTableHelper.autoFitRowHeight(this.kdtEntries, i);
	}

	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		methodForPrint(e, false);
	}

	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		methodForPrint(e, true);
	}

	private void methodForPrint(ActionEvent e, boolean noPreview) {
		BOSUuid id = this.editData.getId();
		KDNoteHelper appHlp = new KDNoteHelper();
		if (id != null) {
			BizCollCoreBillEditUI.DataProvider data = new BizCollCoreBillEditUI.DataProvider(this);
			MultiDataSourceProviderProxy multiDataSourceProviderProxy = getMultiQueryDelegate();

			multiDataSourceProviderProxy.put("MainQuery", data);
			if (noPreview) {
				appHlp.print("/FI/CPBC/bizaccount", multiDataSourceProviderProxy, SwingUtilities.getWindowAncestor(this));
			} else {
				appHlp.printPreview("/FI/CPBC/bizaccount", multiDataSourceProviderProxy, SwingUtilities.getWindowAncestor(this));
			}
		} else {
			MsgBox.showInfo(EASResource.getString("com.kingdee.eas.cp.bc.BizCollResource", "needSave"));
		}
	}

	protected String getReportQueryName() {
		return "com.kingdee.eas.cp.bc.app.BizAccountForPrintQuery";
	}

	protected String getR1ReportBillQueryName() {
		return "com.kingdee.eas.cp.bc.app.BizAccountBillForR1PrintQuery";
	}

	protected String getR1ReportEntryQueryName() {
		return "com.kingdee.eas.cp.bc.app.BizAccountBillEntryForPrintQuery";
	}

	protected String getR1ReportCollectionEntryQueryName() {
		return "com.kingdee.eas.cp.bc.app.BizAccountBillAccountEntryForPrintQuery";
	}

	public int getNowState() {
		if (this.editData.getId() != null) {
			try {
				BizAccountBillInfo info = BizAccountBillFactory.getRemoteInstance().getBizAccountBillInfo(new ObjectUuidPK(this.editData.getId().toString()), BizCollUtil.getStateSic());

				return info.getState().getValue();
			} catch (EASBizException e) {
				e.printStackTrace();
				return -1;
			} catch (BOSException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return -1;
	}

	protected void hasMoreSourceBill() {
		boolean hasMoreSourceBill = false;

		if (((!("ADDNEW".equals(getOprtState()))) && (!("EDIT".equals(getOprtState())))) || (this.editData == null) || (this.editData.getSourceBillId() == null))
			return;
		BizAccountBillEntryCollection entrys = this.editData.getEntries();
		if ((this.editData.getSourceBillId() == null) || (entrys == null))
			return;
		String sourceBillId = null;

		int i = 0;
		for (int leng = entrys.size(); i < leng; ++i) {
			BizAccountBillEntryInfo entryInfo = entrys.get(i);
			if ((sourceBillId != null) && (!(sourceBillId.equals(entryInfo.getSourceBillID())))) {
				hasMoreSourceBill = true;
				return;
			}
			sourceBillId = entryInfo.getSourceBillID();
		}
	}

	protected AbstractObjectCollection getEntryCollection(BizCollCoreBillBaseInfo editData) {
		if (editData != null) {
			return ((BizAccountBillInfo) editData).getEntries();
		}
		return null;
	}

	protected void checkBotpForCurrencyType() {
		BigDecimal budgetAmountValue = null;
		int i = 0;
		for (int size = this.kdtEntries.getRowCount(); i < size; ++i) {
			budgetAmountValue = (BigDecimal) this.kdtEntries.getRow(i).getCell("budgetAmount").getValue();
			if ((budgetAmountValue != null) && (budgetAmountValue.compareTo(BizCollUtil.ZERO) > 0))
				this.kdtEntries.getRow(i).getCell("currencyType").getStyleAttributes().setLocked(true);
		}
	}

	protected void initCheckEntryFromBotp() {
		BizAccountBillInfo info = this.editData;
		if (info.getSourceBillId() == null)
			return;
		try {
			String sourcebillid = info.getSourceBillId();
			Map filter = new HashMap();
			filter.put("billid", sourcebillid);
			List list = null;
			if (BizCollUtil.getBOSType(sourcebillid).equals(BizCollUtil.otherExpenseBosType)) {
				list = CommonUtilFacadeFactory.getRemoteInstance().getSourceBills("otherExpense", filter);
				initCheckEntryLine(list, this.kdtReqCheckEntries, "bizreq");
			} else if (BizCollUtil.getBOSType(sourcebillid).equals(BizCollUtil.dailyloanBosType)) {
				list = CommonUtilFacadeFactory.getRemoteInstance().getSourceBills("dailyLoan", filter);
				initCheckEntryLine(list, this.kdtLoanCheckEntries, "bizloan");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}

	protected void initCheckEntryGrid() {
		if ((this.editData.getSourceBillId() != null) && (BizCollUtil.isOtherExpense(this.editData.getSourceBillId()))) {
			this.kDReqContainer.setVisible(true);
			this.kDTabbedPane.setSelectedIndex(3);
		} else if (this.kDTabbedPane.getTabCount() > 3) {
			this.kDTabbedPane.remove(3);
		}
	}

	protected String getPrintImageTemplate() {
		return "/FI/CPBC/bizaccount/image";
	}

	protected String getApplierId() {
		if (this.bizPromptApplier.getValue() != null) {
			return ((PersonInfo) this.bizPromptApplier.getValue()).getId().toString();
		}
		return null;
	}

	public void actionAddCollectionLine_actionPerformed(ActionEvent e) throws Exception {
		this.promPayName.getUI().getButton().doClick();
	}

	public void actionDelCollectionLine_actionPerformed(ActionEvent e) throws Exception {
		removeLine(this.kdtCollectionEntries);
		calculateColumnAmount(this.kdtCollectionEntries, this.kdtCollectionEntries.getColumnIndex("amount"));
	}

	protected void lockSomeUIForWorkFlow() {
		super.lockSomeUIForWorkFlow();
		this.actionAddCollectionLine.setEnabled(false);
		this.actionDelCollectionLine.setEnabled(false);

		this.kdtCollectionEntries.setEditable(true);
		for (int i = 0; i < this.kdtCollectionEntries.getColumnCount(); ++i)
			if ((this.kdtCollectionEntries.getColumn(i).getFieldName() != null) && (((this.kdtCollectionEntries.getColumn(i).getFieldName().indexOf("payMode") >= 0) || (this.kdtCollectionEntries.getColumn(i).getFieldName().indexOf("currencyType") >= 0) || (this.kdtCollectionEntries.getColumn(i).getFieldName().indexOf("amountOri") >= 0)))) {
				this.kdtCollectionEntries.getColumn(i).getStyleAttributes().setLocked(false);
			} else
				this.kdtCollectionEntries.getColumn(i).getStyleAttributes().setLocked(true);
	}

	private void initDefaultLines(KDTable table) {
		if (table == null) {
			return;
		}
		if (!(hasTotalLine(table)))
			addTotalLine(table);
	}

	private boolean hasTotalLine(KDTable table) {
		if (table == null) {
			return false;
		}

		return (getTotalRow(table) != null);
	}

	private IRow getTotalRow(KDTable table) {
		int n = table.getRowCount();
		for (int i = n - 1; i > -1; --i) {
			IRow row = table.getRow(i);
			if (checkIsCountLine(row)) {
				return row;
			}
		}
		return null;
	}

	private void addTotalLine(KDTable table) {
		IRow row = table.addRow();
		row.getCell("payerName").setValue(EASResource.getString("com.kingdee.eas.cp.bc.client.LoanReqResource", "count"));

		row.getCell("flag").setValue("count");
		row.getStyleAttributes().setLocked(true);
		row.getStyleAttributes().setBackground(new Color(249, 247, 242));
	}

	private void calculateColumnAmount(KDTable table, int columnIndex) {
		IRow countRow = getTotalRow(table);
		if (countRow == null) {
			return;
		}

		IRow row = null;
		ICell cell = null;
		BigDecimal columnAmount = new BigDecimal("0.00");
		BigDecimal amount = null;
		int i = 0;
		for (int n = table.getRowCount(); i < n; ++i) {
			row = table.getRow(i);
			if (checkIsCountLine(row)) {
				continue;
			}
			cell = row.getCell(columnIndex);
			Object value = cell.getValue();

			amount = BizCollUtil.toBigDecimal(value);
			if (amount != null) {
				columnAmount = columnAmount.add(amount);
			}
		}

		countRow.getCell(columnIndex).setValue(columnAmount);
	}

	protected String getBudgetPermission() {
		return "cp_bc_ExpenseAccount_Budget";
	}

	protected void setBcButton() {
		this.btnVoucher.setVisible(false);
		this.btnVoucher.setEnabled(false);
		this.btnDelVoucher.setVisible(false);
		this.btnDelVoucher.setEnabled(false);
		this.btnSuspenseAcc.setVisible(false);
		this.btnSuspenseAcc.setEnabled(false);
		this.menuItemDelVoucher.setVisible(false);
		this.MenuItemSuspenseAcc.setVisible(false);
		this.btnCreateTo.setVisible(false);
	}

	protected void setBcShareButton() {
		this.btnAddNew.setVisible(false);
		this.btnAddNew.setEnabled(false);
		this.btnSave.setVisible(false);
		this.btnSave.setEnabled(false);
		this.btnSubmit.setVisible(false);
		this.btnSubmit.setEnabled(false);
		this.btnEdit.setVisible(false);
		this.btnEdit.setEnabled(false);
		this.btnRemove.setVisible(false);
		this.btnRemove.setEnabled(false);
		this.btnCopyFrom.setVisible(false);
		this.btnCopyFrom.setEnabled(false);
		this.btnCopy.setVisible(false);
		this.btnCopy.setEnabled(false);
		this.menuItemAddNew.setVisible(false);
		this.menuItemAddNew.setEnabled(false);
		this.menuItemSave.setVisible(false);
		this.menuItemSave.setEnabled(false);
		this.menuItemSubmit.setVisible(false);
		this.menuItemSubmit.setEnabled(false);
		this.menuSubmitOption.setVisible(false);
		this.menuSubmitOption.setEnabled(false);
		this.rMenuItemSubmit.setVisible(false);
		this.rMenuItemSubmit.setEnabled(false);
		this.rMenuItemSubmitAndAddNew.setVisible(false);
		this.rMenuItemSubmitAndAddNew.setEnabled(false);
		this.rMenuItemSubmitAndPrint.setVisible(false);
		this.rMenuItemSubmitAndPrint.setEnabled(false);
		this.menuItemCopy.setVisible(false);
		this.menuItemCopy.setEnabled(false);
		this.menuItemEdit.setVisible(false);
		this.menuItemEdit.setEnabled(false);
		this.menuItemRemove.setVisible(false);
		this.menuItemRemove.setEnabled(false);
		this.menuItemCreateFrom.setVisible(false);
		this.menuItemCreateFrom.setEnabled(false);
		this.menuItemCopyFrom.setVisible(false);
		this.menuItemCopyFrom.setEnabled(false);
		this.menuItemUdateReqDate.setVisible(false);
		this.menuItemUdateReqDate.setEnabled(false);
		this.menuItemEnterToNextRow.setVisible(false);
		this.menuItemEnterToNextRow.setEnabled(false);
		this.menuTable1.setVisible(false);
		this.menuTable1.setEnabled(false);
	}
}