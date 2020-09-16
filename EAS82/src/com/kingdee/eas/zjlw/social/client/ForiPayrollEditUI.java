/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.social.ForiCheckedCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class ForiPayrollEditUI extends AbstractForiPayrollEditUI {
	private static final Logger logger = CoreUIObject.getLogger(ForiPayrollEditUI.class);

	/**
	 * output class constructor
	 */
	public ForiPayrollEditUI() throws Exception {
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
		adjustStyle();
		checkCount();
		checkPrice();
		if (getOprtState().equals("EDIT")) {
			checkSociaLevyBase();
		}
	}

	private void adjustStyle() {
		this.kdtEntrys.getColumn("grossPay").getStyleAttributes().setNumberFormat("###,###,##0.00");// 毛工资
		this.kdtEntrys.getColumn("secuDebit").getStyleAttributes().setNumberFormat("###,###,##0.00");// 社保扣款
		this.kdtEntrys.getColumn("vacaDebit").getStyleAttributes().setNumberFormat("###,###,##0.00");// 休假工资扣款
		this.kdtEntrys.getColumn("totCharge").getStyleAttributes().setNumberFormat("###,###,##0.00");// 扣款总额
		this.kdtEntrys.getColumn("netPay").getStyleAttributes().setNumberFormat("###,###,##0.00");// 净工资
		this.kdtEntrys.getColumn("attMthWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 月出勤工资
		this.kdtEntrys.getColumn("seniWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 工龄工资 工龄补贴
		this.kdtEntrys.getColumn("totNmlBsWg").getStyleAttributes().setNumberFormat("###,###,##0.00");// 平时加班工资总额
		this.kdtEntrys.getColumn("totHldBsWg").getStyleAttributes().setNumberFormat("###,###,##0.00");// 节假日加班工资总额
		this.kdtEntrys.getColumn("traWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 交通补贴总额
		this.kdtEntrys.getColumn("eatWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 工作餐补总额
		this.kdtEntrys.getColumn("urgeWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 月鼓励补贴总额
		this.kdtEntrys.getColumn("oneTimeWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 个人绩效奖金总额
		this.kdtEntrys.getColumn("bTripWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 月出差补贴总额
		this.kdtEntrys.getColumn("riskWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 现场风险补贴总额
		this.kdtEntrys.getColumn("disasWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 危害补贴总额
		this.kdtEntrys.getColumn("langWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 语言补贴
		this.kdtEntrys.getColumn("thingsWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 婚丧嫁娶补贴总额
		this.kdtEntrys.getColumn("oneWorkWage").getStyleAttributes().setNumberFormat("###,###,##0.00");// 一人就业补贴总额
		this.kdtEntrys.getColumn("nmlBsWgPerHour").getStyleAttributes().setNumberFormat("###,###,##0.00");// 平时加班小时工资基数
		this.kdtEntrys.getColumn("hldBsWgPerHour").getStyleAttributes().setNumberFormat("###,###,##0.00");// 节假日加班小时工资基数
		this.kdtEntrys.getColumn("hldBsWgPerHour").getStyleAttributes().setNumberFormat("###,###,##0.00");// 节假日加班小时工资基数
		this.kdtEntrys.getColumn("SociaLevyBase").getStyleAttributes().setNumberFormat("###,###,##0.00");// 社保征收基数
		this.kdtEntrys.getColumn("IRGLBase").getStyleAttributes().setNumberFormat("###,###,##0.00");// IRG征收基数
		this.kdtEntrys.getColumn("IRGDPerson").getStyleAttributes().setNumberFormat("###,###,##0.00");// IRG扣款 个人所得税
		this.kdtEntrys.getColumn("soLevyBaseW").getStyleAttributes().setNumberFormat("###,###,##0.00");// 社保征收基数 外会计算
		this.kdtEntrys.getColumn("IRGLBaseW").getStyleAttributes().setNumberFormat("###,###,##0.00");// IRG征收基数 外会计算
		this.kdtEntrys.getColumn("IRGDeduction").getStyleAttributes().setNumberFormat("###,###,##0.00");// IRG扣款 外会计算
		this.kdtEntrys.getColumn("soLevyBaseW").getStyleAttributes().setHided(true);// 社保征收基数（外会计算） soLevyBaseW
		this.kdtEntrys.getColumn("IRGLBaseW").getStyleAttributes().setHided(true);// IRG征收基数（外会计算） IRGLBaseW
		this.kdtEntrys.getColumn("IRGDeduction").getStyleAttributes().setHided(true);// IRG扣款（外会计算） IRGDeduction
	}

	protected void setButtonStatus() {
		ForiPayrollInfo bill;
		if ("VIEW".equals(getOprtState())) {
			bill = (ForiPayrollInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (ForiPayrollInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(true);
			}
		}
		if (((BillStateEnum.CHECKED.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {// (
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}
		if (this.editData != null) {
			bill = (ForiPayrollInfo) this.editData;
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

	private void checkCount() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			String workDate = "22";
			String baseCount = "173.33";
			String maBase = "2";
			String miBase = "1.5";
			BigDecimal bsCount = new BigDecimal(baseCount);
			BigDecimal wkDate = new BigDecimal(workDate);
			BigDecimal minBase = new BigDecimal(miBase);
			BigDecimal maxBase = new BigDecimal(maBase);
			BigDecimal basePay = (BigDecimal) row.getCell("basePay").getValue();// 基本工资
			BigDecimal normalOver = (BigDecimal) row.getCell("normalOver").getValue();// 平时加班
			BigDecimal festOver = (BigDecimal) row.getCell("festOver").getValue();// 节假日加班
			BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();// 出勤天数
			if (nWorkDay != null) {
				if (basePay != null) {
					if (wkDate != null) {
						row.getCell("attMthWage").setValue(basePay.multiply(nWorkDay).divide(wkDate, 4));// 月出勤工资
					}
					row.getCell("nmlBsWgPerHour").setValue(basePay.multiply(minBase).divide(bsCount, 4));// 平时加班小时工资基数
					row.getCell("hldBsWgPerHour").setValue(basePay.multiply(maxBase).divide(bsCount, 4));// 节假日加班小时工资基数
				}
			}
			BigDecimal nmlBsWgPerHour = (BigDecimal) row.getCell("nmlBsWgPerHour").getValue();// 平时加班小时工资基数
			BigDecimal hldBsWgPerHour = (BigDecimal) row.getCell("hldBsWgPerHour").getValue();// 节假日加班小时工资基数
			if (nmlBsWgPerHour != null && normalOver != null) {
				row.getCell("totNmlBsWg").setValue(nmlBsWgPerHour.multiply(normalOver));// 平时加班工资总额
			}
			if (hldBsWgPerHour != null && festOver != null) {
				row.getCell("totHldBsWg").setValue(hldBsWgPerHour.multiply(festOver));// 节假日加班工资总额
			}
		}
	}

	public void checkSociaLevyBase() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			BigDecimal attMthWage = (BigDecimal) row.getCell("attMthWage").getValue();// 1.
			BigDecimal seniWage = (BigDecimal) row.getCell("seniWage").getValue();// 2.
			BigDecimal totNmlBsWg = (BigDecimal) row.getCell("totNmlBsWg").getValue();// 3.
			BigDecimal totHldBsWg = (BigDecimal) row.getCell("totHldBsWg").getValue();// 4.
			BigDecimal traWage = (BigDecimal) row.getCell("traWage").getValue();// 5.
			BigDecimal eatWage = (BigDecimal) row.getCell("eatWage").getValue();// 6.
			BigDecimal urgeWage = (BigDecimal) row.getCell("urgeWage").getValue();// 7.
			BigDecimal oneTimeWage = (BigDecimal) row.getCell("oneTimeWage").getValue();// 8.
			BigDecimal riskWage = (BigDecimal) row.getCell("riskWage").getValue();// 10.
			BigDecimal disasWage = (BigDecimal) row.getCell("disasWage").getValue();// 11.
			BigDecimal langWage = (BigDecimal) row.getCell("langWage").getValue();// 12.
			BigDecimal switchWage = (BigDecimal) row.getCell("switchWage").getValue();// 15.
			BigDecimal spendWage = (BigDecimal) row.getCell("spendWage").getValue();// 24.
			BigDecimal nWorkWage = (BigDecimal) row.getCell("nWorkWage").getValue();// 26.
			BigDecimal itmperieTol = (BigDecimal) row.getCell("itmperieTol").getValue();// 27.
			row.getCell("SociaLevyBase").setValue((attMthWage == null ? BigDecimal.ZERO : attMthWage).add(seniWage == null ? BigDecimal.ZERO : seniWage).add(totNmlBsWg == null ? BigDecimal.ZERO : totNmlBsWg).add(totHldBsWg == null ? BigDecimal.ZERO : totHldBsWg).add(urgeWage == null ? BigDecimal.ZERO : urgeWage).add(oneTimeWage == null ? BigDecimal.ZERO : oneTimeWage).add(riskWage == null ? BigDecimal.ZERO : riskWage).add(disasWage == null ? BigDecimal.ZERO : disasWage).add(langWage == null ? BigDecimal.ZERO : langWage).add(switchWage == null ? BigDecimal.ZERO : switchWage).add(nWorkWage == null ? BigDecimal.ZERO : nWorkWage).add(itmperieTol == null ? BigDecimal.ZERO : itmperieTol));
			BigDecimal SociaLevyBase = (BigDecimal) row.getCell("SociaLevyBase").getValue();// 社保征收基数
			BigDecimal a = new BigDecimal(0.09);
			BigDecimal b = new BigDecimal(0.00375);
			row.getCell("secuDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(a));
			row.getCell("vacaDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(b));
			BigDecimal secuDebit = (BigDecimal) row.getCell("secuDebit").getValue();// 社保扣款
			BigDecimal vacaDebit = (BigDecimal) row.getCell("vacaDebit").getValue();// 休假工资扣款
			row.getCell("IRGLBase").setValue((attMthWage == null ? BigDecimal.ZERO : attMthWage).add(seniWage == null ? BigDecimal.ZERO : seniWage).add(totNmlBsWg == null ? BigDecimal.ZERO : totNmlBsWg).add(totHldBsWg == null ? BigDecimal.ZERO : totHldBsWg).add(traWage == null ? BigDecimal.ZERO : traWage).add(eatWage == null ? BigDecimal.ZERO : eatWage).add(urgeWage == null ? BigDecimal.ZERO : urgeWage).add(oneTimeWage == null ? BigDecimal.ZERO : oneTimeWage).add(riskWage == null ? BigDecimal.ZERO : riskWage).add(disasWage == null ? BigDecimal.ZERO : disasWage).add(langWage == null ? BigDecimal.ZERO : langWage).add(switchWage == null ? BigDecimal.ZERO : switchWage).add(spendWage == null ? BigDecimal.ZERO : spendWage).add(nWorkWage == null ? BigDecimal.ZERO : nWorkWage).add(itmperieTol == null ? BigDecimal.ZERO : itmperieTol).subtract(SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase.multiply(a)).subtract(SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase.multiply(b)));
			BigDecimal IRGLBaseW = (BigDecimal) row.getCell("IRGLBase").getValue();
			BigDecimal a1 = BigDecimal.ZERO;
			BigDecimal b1 = BigDecimal.ZERO;
			BigDecimal d1 = new BigDecimal("10000");
			BigDecimal d2 = new BigDecimal("30000");
			BigDecimal d3 = new BigDecimal("120000");
			BigDecimal rate1 = new BigDecimal("0.2");
			BigDecimal rate2 = new BigDecimal("0.3");
			BigDecimal rate3 = new BigDecimal("0.35");
			BigDecimal rate4 = new BigDecimal("0.4");
			BigDecimal c1 = new BigDecimal("10000");
			BigDecimal c2 = new BigDecimal("4000");
			BigDecimal c3 = new BigDecimal("31000");
			BigDecimal e1 = new BigDecimal("1000");
			BigDecimal e2 = new BigDecimal("1500");
			if (IRGLBaseW.compareTo(d1) <= 0) {
				row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
			} else if (IRGLBaseW.compareTo(d1) > 0 && IRGLBaseW.compareTo(d2) <= 0) {
				// A=（IRG基数-10000）*0.2
				a1 = (IRGLBaseW.subtract(d1)).multiply(rate1);
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			} else if (IRGLBaseW.compareTo(d2) > 0 && IRGLBaseW.compareTo(d3) <= 0) {
				// A=4000+(IRG基数-30000）*0.3
				a1 = c2.add((IRGLBaseW.subtract(d2)).multiply(rate2));
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			} else {
				// A=31000+(IRG基数-120000）*0.35
				a1 = c3.add((IRGLBaseW.subtract(d3)).multiply(rate3));
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			}
		}
	}

	public void checkPrice() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);

			BigDecimal attMthWage = (BigDecimal) row.getCell("attMthWage").getValue();// 1.
			BigDecimal seniWage = (BigDecimal) row.getCell("seniWage").getValue();// 2.
			BigDecimal totNmlBsWg = (BigDecimal) row.getCell("totNmlBsWg").getValue();// 3.
			BigDecimal totHldBsWg = (BigDecimal) row.getCell("totHldBsWg").getValue();// 4.
			BigDecimal traWage = (BigDecimal) row.getCell("traWage").getValue();// 5.
			BigDecimal eatWage = (BigDecimal) row.getCell("eatWage").getValue();// 6.
			BigDecimal urgeWage = (BigDecimal) row.getCell("urgeWage").getValue();// 7.
			BigDecimal oneTimeWage = (BigDecimal) row.getCell("oneTimeWage").getValue();// 8.
			BigDecimal bTripWage = (BigDecimal) row.getCell("bTripWage").getValue();// 9.
			BigDecimal riskWage = (BigDecimal) row.getCell("riskWage").getValue();// 10.
			BigDecimal disasWage = (BigDecimal) row.getCell("disasWage").getValue();// 11.
			BigDecimal langWage = (BigDecimal) row.getCell("langWage").getValue();// 12.
			BigDecimal thingsWage = (BigDecimal) row.getCell("thingsWage").getValue();// 13.
			BigDecimal oneWorkWage = (BigDecimal) row.getCell("oneWorkWage").getValue();// 14.
			BigDecimal switchWage = (BigDecimal) row.getCell("switchWage").getValue();// 15.
			BigDecimal areaWage = (BigDecimal) row.getCell("areaWage").getValue();// 16.
			BigDecimal faraWage = (BigDecimal) row.getCell("faraWage").getValue();// 17.
			BigDecimal liveWage = (BigDecimal) row.getCell("liveWage").getValue();// 18.
			BigDecimal FamilyWage = (BigDecimal) row.getCell("FamilyWage").getValue();// 19.
			BigDecimal studyWage = (BigDecimal) row.getCell("studyWage").getValue();// 20.
			BigDecimal fireWage = (BigDecimal) row.getCell("fireWage").getValue();// 21.
			BigDecimal retirWage = (BigDecimal) row.getCell("retirWage").getValue();// 22.
			BigDecimal pOverAward = (BigDecimal) row.getCell("pOverAward").getValue();// 23.
			BigDecimal spendWage = (BigDecimal) row.getCell("spendWage").getValue();// 24.
			BigDecimal phoneWageC = (BigDecimal) row.getCell("phoneWageC").getValue();// 25.
			BigDecimal nWorkWage = (BigDecimal) row.getCell("nWorkWage").getValue();// 26.
			BigDecimal itmperieTol = (BigDecimal) row.getCell("itmperieTol").getValue();// 27.
			BigDecimal basePay = (BigDecimal) row.getCell("basePay").getValue();
			BigDecimal nWorkDay = (BigDecimal) row.getCell("nWorkDay").getValue();
			BigDecimal abcdefg = (BigDecimal) row.getCell("abcdefg").getValue();
			BigDecimal days = new BigDecimal("22");
			BigDecimal modulus = new BigDecimal("0.75");
			if (abcdefg != null) {
				row.getCell("itmperieTol").setValue(basePay.multiply(modulus).divide(days, 2).multiply(abcdefg));
			}
			row.getCell("grossPay").setValue((attMthWage == null ? BigDecimal.ZERO : attMthWage).add(seniWage == null ? BigDecimal.ZERO : seniWage).add(totNmlBsWg == null ? BigDecimal.ZERO : totNmlBsWg).add(totHldBsWg == null ? BigDecimal.ZERO : totHldBsWg).add(traWage == null ? BigDecimal.ZERO : traWage).add(eatWage == null ? BigDecimal.ZERO : eatWage).add(urgeWage == null ? BigDecimal.ZERO : urgeWage).add(oneTimeWage == null ? BigDecimal.ZERO : oneTimeWage).add(bTripWage == null ? BigDecimal.ZERO : bTripWage).add(riskWage == null ? BigDecimal.ZERO : riskWage).add(disasWage == null ? BigDecimal.ZERO : disasWage).add(langWage == null ? BigDecimal.ZERO : langWage).add(thingsWage == null ? BigDecimal.ZERO : thingsWage).add(oneWorkWage == null ? BigDecimal.ZERO : oneWorkWage).add(switchWage == null ? BigDecimal.ZERO : switchWage).// zxh
					add(areaWage == null ? BigDecimal.ZERO : areaWage).add(faraWage == null ? BigDecimal.ZERO : faraWage).add(liveWage == null ? BigDecimal.ZERO : liveWage).add(FamilyWage == null ? BigDecimal.ZERO : FamilyWage).add(studyWage == null ? BigDecimal.ZERO : studyWage).add(fireWage == null ? BigDecimal.ZERO : fireWage).add(retirWage == null ? BigDecimal.ZERO : retirWage).add(pOverAward == null ? BigDecimal.ZERO : pOverAward).add(spendWage == null ? BigDecimal.ZERO : spendWage).add(phoneWageC == null ? BigDecimal.ZERO : phoneWageC). // rui_xu
					add(nWorkWage == null ? BigDecimal.ZERO : nWorkWage).add(itmperieTol == null ? BigDecimal.ZERO : itmperieTol));
			row.getCell("SociaLevyBase").setValue((attMthWage == null ? BigDecimal.ZERO : attMthWage).add(seniWage == null ? BigDecimal.ZERO : seniWage).add(totNmlBsWg == null ? BigDecimal.ZERO : totNmlBsWg).add(totHldBsWg == null ? BigDecimal.ZERO : totHldBsWg).add(urgeWage == null ? BigDecimal.ZERO : urgeWage).add(oneTimeWage == null ? BigDecimal.ZERO : oneTimeWage).add(riskWage == null ? BigDecimal.ZERO : riskWage).add(disasWage == null ? BigDecimal.ZERO : disasWage).add(langWage == null ? BigDecimal.ZERO : langWage));
			BigDecimal SociaLevyBase = (BigDecimal) row.getCell("SociaLevyBase").getValue();// 社保征收基数
			BigDecimal a = new BigDecimal(0.09);
			BigDecimal b = new BigDecimal(0.00375);
			// 社保扣款 secuDebit = SociaLevyBase 社保征收基数*9%
			row.getCell("secuDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(a));
			// 休假工资扣款 vacaDebit = SociaLevyBase 社保征收基数*0.375%
			row.getCell("vacaDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(b));
			BigDecimal secuDebit = (BigDecimal) row.getCell("secuDebit").getValue();// 社保扣款
			BigDecimal vacaDebit = (BigDecimal) row.getCell("vacaDebit").getValue();// 休假工资扣款
			BigDecimal IRGDPerson = (BigDecimal) row.getCell("IRGDPerson").getValue();// IRG扣款

			// 外会计算字段，按照系统计算值赋值================ywj 2018-4-15
			row.getCell("soLevyBaseW").setValue(SociaLevyBase);
			row.getCell("IRGLBaseW").setValue((attMthWage == null ? BigDecimal.ZERO : attMthWage).add(seniWage == null ? BigDecimal.ZERO : seniWage).add(totNmlBsWg == null ? BigDecimal.ZERO : totNmlBsWg).add(totHldBsWg == null ? BigDecimal.ZERO : totHldBsWg).add(traWage == null ? BigDecimal.ZERO : traWage).add(eatWage == null ? BigDecimal.ZERO : eatWage).add(urgeWage == null ? BigDecimal.ZERO : urgeWage).add(oneTimeWage == null ? BigDecimal.ZERO : oneTimeWage).add(riskWage == null ? BigDecimal.ZERO : riskWage).add(disasWage == null ? BigDecimal.ZERO : disasWage).add(langWage == null ? BigDecimal.ZERO : langWage).add(switchWage == null ? BigDecimal.ZERO : switchWage).add(spendWage == null ? BigDecimal.ZERO : spendWage).add(nWorkWage == null ? BigDecimal.ZERO : nWorkWage).add(itmperieTol == null ? BigDecimal.ZERO : itmperieTol).subtract(SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase.multiply(a)).subtract(SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase.multiply(b)));
			row.getCell("IRGDeduction").setValue(IRGDPerson == null ? BigDecimal.ZERO : IRGDPerson);
			// 外会计算字段，按照系统计算值赋值================ywj 2018-4-15

			/*
			 * 扣款总额 totCharge = secuDebit 社保扣款+ vacaDebit 休假工资扣款+ IRGDPerson IRG扣款
			 */
			row.getCell("totCharge").setValue((secuDebit == null ? BigDecimal.ZERO : secuDebit).add(vacaDebit == null ? BigDecimal.ZERO : vacaDebit).add(IRGDPerson == null ? BigDecimal.ZERO : IRGDPerson));
			/*
			 * 净工资 netPay = grossPay 毛工资- totCharge 扣款总额
			 */
			BigDecimal grossPay = (BigDecimal) row.getCell("grossPay").getValue();// 毛工资
			BigDecimal totCharge = (BigDecimal) row.getCell("totCharge").getValue();// 扣款总额
			row.getCell("netPay").setValue((grossPay == null ? BigDecimal.ZERO : grossPay).subtract(totCharge == null ? BigDecimal.ZERO : totCharge));
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
		BigDecimal SociaLevyBase = (BigDecimal) row.getCell("SociaLevyBase").getValue();// 社保征收基数
		BigDecimal a = new BigDecimal(0.09);
		BigDecimal b = new BigDecimal(0.00375);
		if ("SociaLevyBase".equals(key)) {
			row.getCell("secuDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(a));
			row.getCell("vacaDebit").setValue((SociaLevyBase == null ? BigDecimal.ZERO : SociaLevyBase).multiply(b));
		}
		if ("IRGLBase".equals(key)) {
			BigDecimal IRGLBaseW = (BigDecimal) row.getCell("IRGLBase").getValue();
			BigDecimal a1 = BigDecimal.ZERO;
			BigDecimal b1 = BigDecimal.ZERO;
			BigDecimal d1 = new BigDecimal("10000");
			BigDecimal d2 = new BigDecimal("30000");
			BigDecimal d3 = new BigDecimal("120000");
			BigDecimal rate1 = new BigDecimal("0.2");
			BigDecimal rate2 = new BigDecimal("0.3");
			BigDecimal rate3 = new BigDecimal("0.35");
			BigDecimal rate4 = new BigDecimal("0.4");
			BigDecimal c1 = new BigDecimal("10000");
			BigDecimal c2 = new BigDecimal("4000");
			BigDecimal c3 = new BigDecimal("31000");
			BigDecimal e1 = new BigDecimal("1000");
			BigDecimal e2 = new BigDecimal("1500");
			if (IRGLBaseW.compareTo(d1) <= 0) {
				row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
			} else if (IRGLBaseW.compareTo(d1) > 0 && IRGLBaseW.compareTo(d2) <= 0) {
				// A=（IRG基数-10000）*0.2
				a1 = (IRGLBaseW.subtract(d1)).multiply(rate1);
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			} else if (IRGLBaseW.compareTo(d2) > 0 && IRGLBaseW.compareTo(d3) <= 0) {
				// A=4000+(IRG基数-30000）*0.3
				a1 = c2.add((IRGLBaseW.subtract(d2)).multiply(rate2));
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			} else {
				// A=31000+(IRG基数-120000）*0.35
				a1 = c3.add((IRGLBaseW.subtract(d3)).multiply(rate3));
				b1 = a1.multiply(rate4);
				if (b1.compareTo(e1) <= 0) {
					b1 = e1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e1) > 0 && b1.compareTo(e2) <= 0) {
					b1 = b1;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
				if (b1.compareTo(e2) > 0) {
					b1 = e2;
					BigDecimal value = a1.subtract(b1);
					if (value.compareTo(BigDecimal.ZERO) <= 0) {
						row.getCell("IRGDPerson").setValue(BigDecimal.ZERO);
					} else {
						row.getCell("IRGDPerson").setValue(a1.subtract(b1));
					}
				}
			}
		}
		// IRG扣款（个人所得税） IRGDPerson
		if ("IRGDPerson".equals(key)) {
			BigDecimal secuDebit = (BigDecimal) row.getCell("secuDebit").getValue();// 社保扣款
			BigDecimal vacaDebit = (BigDecimal) row.getCell("vacaDebit").getValue();// 休假工资扣款
			BigDecimal IRGDPerson = (BigDecimal) row.getCell("IRGDPerson").getValue();// IRG扣款
			BigDecimal grossPay = (BigDecimal) row.getCell("grossPay").getValue();// 毛工资
			BigDecimal totCharge = (BigDecimal) row.getCell("totCharge").getValue();// 扣款总额
			if (IRGDPerson != null) {
				/*
				 * 扣款总额 totCharge = secuDebit 社保扣款+ vacaDebit 休假工资扣款+ IRGDPerson IRG扣款
				 */
				row.getCell("totCharge").setValue((secuDebit == null ? BigDecimal.ZERO : secuDebit).add(vacaDebit == null ? BigDecimal.ZERO : vacaDebit).add(IRGDPerson == null ? BigDecimal.ZERO : IRGDPerson));
				totCharge = (BigDecimal) row.getCell("totCharge").getValue();// 扣款总额
				row.getCell("netPay").setValue((grossPay == null ? BigDecimal.ZERO : grossPay).subtract(totCharge == null ? BigDecimal.ZERO : totCharge));
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
//		int rowCount = this.kdtEntrys.getRowCount();
//		for (int i = 0; i < rowCount; i++) {
//			IRow row = this.kdtEntrys.getRow(i);
//			row.getCell("soLevyBaseW").setValue(row.getCell("SociaLevyBase").getValue());
//			row.getCell("IRGDPerson").setValue(row.getCell("IRGDeduction").getValue());
//			if (row.getCell("IRGLBaseW").getValue() == null)
//				row.getCell("IRGLBaseW").setValue(BigDecimal.ZERO);
//			row.getCell("IRGLBase").setValue(row.getCell("IRGLBaseW").getValue());
//		}
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		super.doBeforeSave(e);
		// 同项目同期间不可重复添加
		// if (this.prmtprojName.getValue()!=null) {
		// checkSame();
		// }
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		// 同项目同期间不可重复添加
		// if (this.prmtprojName.getValue()!=null) {
		// checkSame();
		// }
		// checkSubmit();
	}

	private void checkSame() throws BOSException {
		PeriodInfo perInfo = (PeriodInfo) this.prmtmonthYearr.getValue();
		AdminOrgUnitInfo permInfo = (AdminOrgUnitInfo) this.prmtprojName.getValue();
		if (perInfo == null) {
			MsgBox.showInfo("该项目所选年月为空无法提交，请填入年月！");
			this.abort();
		}
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.projName.name", permInfo.getName()));
		filter.getFilterItems().add(new FilterItemInfo("parent.monthYearr.number", perInfo.getNumber()));
		filter.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		ForiPayrollEntryCollection checkCol = ForiPayrollEntryFactory.getRemoteInstance().getForiPayrollEntryCollection(view);
		if (checkCol.size() > 1) {
			MsgBox.showInfo("该项目所选年月已有考勤数据，不允许重复添加！");
			this.prmtmonthYearr.setValue(null);
			abort();
		}
	}

	/*
	 * 提交校验
	 */
	protected void checkSubmit() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			String lastName = (String) row.getCell("lastName").getValue();// 姓
			String firstName = (String) row.getCell("firstName").getValue();// 名
			BigDecimal soLevyBaseW = (BigDecimal) row.getCell("soLevyBaseW").getValue(); // 社保征收基数
			// （
			// 外会计算
			// ）
			BigDecimal SociaLevyBase = (BigDecimal) row.getCell("SociaLevyBase").getValue();// 社保征收基数
			BigDecimal IRGLBaseW = (BigDecimal) row.getCell("IRGLBaseW").getValue();// IRG征收基数
			// （
			// 外会计算
			// ）
			BigDecimal IRGLBase = (BigDecimal) row.getCell("IRGLBase").getValue();// IRG征收基数
			BigDecimal IRGDeduction = (BigDecimal) row.getCell("IRGDeduction").getValue();// IRG扣款
			// （
			// 外会计算
			// ）
			BigDecimal IRGDPerson = (BigDecimal) row.getCell("IRGDPerson").getValue();// IRG扣款
			// （
			// 个人所得税
			// ）
			if (soLevyBaseW == null) {
				MsgBox.showInfo(lastName + firstName + "的社保征收基数（外会计算）为空，无法提交，请重新填入！");
				this.abort();
			}
			if (IRGLBaseW == null) {
				MsgBox.showInfo(lastName + firstName + "的IRG征收基数（外会计算）为空，无法提交，请重新填入！");
				this.abort();
			}
			if (IRGDeduction == null) {
				MsgBox.showInfo(lastName + firstName + "的IRG扣款（外会计算）为空，无法提交，请重新填入！");
				this.abort();
			}
			// 社保征收基数（外会计算） soLevyBaseW 社保征收基数 SociaLevyBase 如果和系统计算不一致则标红
			if (soLevyBaseW != null && SociaLevyBase != null) {
				if (!(soLevyBaseW.compareTo(SociaLevyBase) == 0)) {
					MsgBox.showInfo(lastName + firstName + "的社保征收基数(外会计算)与社保征收基数计算不一致，无法提交，请重新填入！");
					this.abort();
				}
			}
			// IRG征收基数（外会计算） IRGLBaseW IRG征收基数 IRGLBase 如果和系统计算不一致则标红
			if (IRGLBaseW != null && IRGLBase != null) {
				if (!(IRGLBaseW.compareTo(IRGLBase) == 0)) {
					MsgBox.showInfo(lastName + firstName + "的IRG征收基数(外会计算)与IRG征收基数计算不一致，无法提交，请重新填入！");
					this.abort();
				}
			}
			// IRG扣款（外会计算） IRGDeduction IRG扣款（个人所得税） IRGDPerson 如果和系统计算不一致则标红
			if (IRGDeduction != null && IRGDPerson != null) {
				if (!(IRGDeduction.compareTo(IRGDPerson) == 0)) {
					MsgBox.showInfo(lastName + firstName + "的IRG扣款(外会计算)与IRG扣款(个人所得税)计算不一致，无法提交，请重新填入！");
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
		return com.kingdee.eas.zjlw.social.ForiPayrollFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.social.ForiPayrollInfo objectValue = new com.kingdee.eas.zjlw.social.ForiPayrollInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}