/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.Color;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.ItemAction;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDTree;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.permission.OrgRangeType;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.base.permission.util.PermissionRangeHelper;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.HROrgUnitInfo;
import com.kingdee.eas.basedata.org.NewOrgUtils;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgViewType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personmess.WorkVisaFactory;

/**
 * output class name
 */
public class WkPmtTrnListUI extends AbstractWkPmtTrnListUI
{
    private static final Logger logger = CoreUIObject.getLogger(WkPmtTrnListUI.class);
    private TreeNode defaultTreeNode = null;
    /**
     * override
     * 列表界面query的默认过滤条件
     * @author yingwj
     * @Date 2016-9-26
     */
    protected FilterInfo getDefaultFilterForQuery() {
    	UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
    	List userOrgIdList = new ArrayList();
    	Set userOrgIdSet = new HashSet();
    	try {
    		userOrgIdList = PermissionRangeHelper.getUserOrgId(null, getUserPk(), OrgRangeType.ADMIN_ORG_TYPE);//获取当前用户拥有的权限的行政组织的id的集合
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < userOrgIdList.size(); i++) {
			userOrgIdSet.add(userOrgIdList.get(i));
		}
		//创建新的查询条件
    	FilterInfo filter = new FilterInfo();
		if (userOrgIdList.size() != 0) {
			filter.getFilterItems().add(new FilterItemInfo("entrys.pmtProj.id", userOrgIdSet, CompareType.INCLUDE));
	    	filter.getFilterItems().add(new FilterItemInfo("entrys.cooperation.id", userOrgIdSet, CompareType.INCLUDE));
	    	filter.setMaskString("#0 AND #1");
//	    	filter.getFilterItems().add(new FilterItemInfo("creator.id", userInfo.getId()));
//	    	filter.setMaskString("(#0 AND #1) OR #2");
		}
    	return filter;
    }
    
    /**
     * output class constructor
     */
    public WkPmtTrnListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    public void loadFields() {
    	super.loadFields();
    }
    //审核
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	checkBill(new String[] { "30" }, "actionAudit");
    	if (MsgBox.showConfirm2(this, "您确认要审核吗？") != 0)
			return;
    	List pkList = EcClientHelper.getSelectedIdValues(tblMain,getKeyFieldName());
    	for (Iterator iter = pkList.iterator(); iter.hasNext();) {
			String id = (String) iter.next();
			WkPmtTrnFactory.getRemoteInstance().passAudit(new ObjectUuidPK(id), null);
		}
    	EcClientHelper.showOprtOK(this);
    	showOKMsgAndRefresh();
    	
    }
    //反审核
    
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	checkBill(new String[] { "40" }, "actionUnAudit");
    	if (MsgBox.showConfirm2(this, "您确认要反审核吗？") != 0)
			return;
    	List pkList = EcClientHelper.getSelectedIdValues(tblMain,getKeyFieldName());
    	for (Iterator iter = pkList.iterator(); iter.hasNext();) {
			String id = (String) iter.next();
			WkPmtTrnFactory.getRemoteInstance().unpassAudit(new ObjectUuidPK(id), null);
		}
    	EcClientHelper.showOprtOK(this);
    	showOKMsgAndRefresh();
    }
    protected boolean checkBill(String[] states, String scene) throws Exception {
		checkSelected();

		KDTable table = tblMain;

		List idList = EcClientHelper.getSelectedIdValues(table,getKeyFieldName());
		if ((idList == null) || (idList.size() == 0)) {
			return false;
		}
		Set idSet = EcClientHelper.listToSet(idList);

		Set stateSet = EcClientHelper.getSetByArray(states);

		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("id", idSet, CompareType.INCLUDE));
		view.setFilter(filter);

		view.getSelector().addObjectCollection(getCheckBillSelector());

		CoreBaseCollection coll = getBizInterface().getCollection(view);

		for (Iterator iter = coll.iterator(); iter.hasNext();) {
			CoreBillBaseInfo element = (CoreBillBaseInfo) iter.next();
			String state = element.getString("billSate");
			if ((!(stateSet.contains(state))) && (state != null)) {
				String stateAlia = BillStateEnum.getEnum(state).getAlias();
				showCheckMsg(scene, element, stateAlia);
				abort();
			}
			if(BTPManagerFactory.getRemoteInstance().ifHaveDestBills(element.getId().toString())){
				MsgBox.showInfo("该单据已关联生成下游单据，不能反审核！");
				abort();
			}

			//checkRef(scene, element);
		}

		return true;
	}
    protected SelectorItemCollection getCheckBillSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();

		sic.add("id");
		sic.add("number");
		sic.add("billSate");

		return sic;
	}
    protected void showCheckMsg(String scene, CoreBillBaseInfo element,
			String state) throws Exception {
		if (scene.equals("actionRemove"))
			MsgBox.showWarning(this, "单据" + element.getNumber() + "处于" + state
					+ "状态，不能删除");
		else if (scene.equals("actionEdit"))
			MsgBox.showWarning(this, "单据" + element.getNumber() + "处于" + state
					+ "状态，不能修改");
		else if (scene.equals("actionAudit"))
			MsgBox.showWarning(this, "单据" + element.getNumber() + "处于" + state
					+ "状态，不能审核");
		else if (scene.equals("actionUnAudit"))
			MsgBox.showWarning(this, "单据" + element.getNumber() + "处于" + state
					+ "状态，不能反审核");
		else if (scene.equals("actionRevise"))
			MsgBox.showWarning(this, "单据" + element.getNumber() + "处于" + state
					+ "状态，不能签订");
	}
    protected void showOKMsgAndRefresh() throws Exception {
		EcClientHelper.showOprtOK(this);
		refreshList();
    }
    public void onLoad() throws Exception {
    	super.onLoad();
    	int count = tblMain.getColumnCount();
    	for (int i = 0; i < count; i++) {
    		tblMain.getColumn(i).setMergeable(false);
		}
    	btnAudit.setEnabled(true);
    	btnUnAudit.setEnabled(true);
    	btnAudit.setVisible(true);
    	btnUnAudit.setVisible(true);
    	btnAddNew.setVisible(false);
    	btnWorkFlowG.setVisible(false);
    	btnAuditResult.setVisible(false);
    	btnCreateTo.setVisible(false);
    	btnTraceDown.setVisible(false);
    	buildOrgUnit();
    	refreshList();
    	checkColor();
    }
    public void checkColor() throws ParseException{
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		date=sdf.parse(sdf.format(date)); 
    	int rowCount=tblMain.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row =tblMain.getRow(i);
    		Date laborTrnDate =(Date) row.getCell("entrys.laborTrnDate").getValue();//收到劳动证调转表时间
    		Date papSTime=(Date) row.getCell("entrys.papSTime").getValue();//劳动证资料递交时间
    		Date wPmtGTime=(Date) row.getCell("entrys.wPmtGTime").getValue();//劳动证出证日期
    		//收到劳动证调转表时间值为零不预警
    		if(laborTrnDate==null){
    			row.getCell("entrys.papSTime").getStyleAttributes().setBackground(Color.white);
    		}
    		if(laborTrnDate!=null){
    			if(papSTime==null){
	    			long time=(date.getTime()-laborTrnDate.getTime())/86400000;
	    			//本项值为零：1.黄色预警：5天<=today-收到劳动证调转表时间<=8天；
	    			if(time>=5&&time<=8){
	    				row.getCell("entrys.papSTime").getStyleAttributes().setBackground(Color.yellow);
	    			}
	    			//本项值为零:2.红色预警：today-收到劳动证调转表时间>8天。
	    			if(time>8){
	    				row.getCell("entrys.papSTime").getStyleAttributes().setBackground(Color.red);
	    			}
    		     }
    			//本项值不为零时：1.红色预警：劳动证资料递交时间-收到劳动证调转表时间>8天
    			if(papSTime!=null){
    				long time1=(papSTime.getTime()-laborTrnDate.getTime())/86400000;
    				if(time1>8){
    					row.getCell("entrys.papSTime").getStyleAttributes().setBackground(Color.red);
    				}
    			}
    	     }
    		if(wPmtGTime==null){
    			if(papSTime!=null){
    				long time2=(date.getTime()-papSTime.getTime())/86400000;
    				//本项值为零时：	1.黄色预警：45天<=today-劳动证资料递交时间<=60天；
    				if(time2>=45&&time2<=60){
    					row.getCell("entrys.wPmtGTime").getStyleAttributes().setBackground(Color.yellow);
    				}
    				//本项值为零时：2.红色预警：today-劳动证资料递交时间>60天。
    				if(time2>60){
    					row.getCell("entrys.wPmtGTime").getStyleAttributes().setBackground(Color.red);
    				}
    			}
    		}
    		if(wPmtGTime!=null){
    			if(papSTime!=null){
    				long time3=(wPmtGTime.getTime()-papSTime.getTime())/86400000;
    				if(time3>60){
    					row.getCell("entrys.wPmtGTime").getStyleAttributes().setBackground(Color.red);
    				}
    			}
    		}
    	}
    }

    /*added by wangth on 20170711 start */
    public void buildOrgUnit() throws Exception {
		buildCostCenter(getOrgViewType());
	}

	public OrgViewType getOrgViewType() {
		return OrgViewType.ADMIN;
	}
	public void buildCostCenter(OrgViewType type) throws Exception {
		String orgUnitId = getRootOrgUnitId(type);
		String defaultOrgId = orgUnitId;
		Map uiContext = getUIContext();
		Map btpParams = (Map) uiContext.get("BTPEDITPARAMETER");
		if ((btpParams != null) && (btpParams.get("billProjectOrg") != null)) {
			HROrgUnitInfo billProjectOrg = (HROrgUnitInfo) btpParams
					.get("billProjectOrg");
			defaultOrgId = billProjectOrg.getId().toString();
		}

		TreeModel orgTreeModel = NewOrgUtils.getTreeModel(type, "",orgUnitId, null, getActionPK(actionOnLoad));
		treeMain.setModel(orgTreeModel);
		this.treeMain.setShowsRootHandles(true);
		TreeNode orgRoot = (TreeNode) orgTreeModel.getRoot();
		if (orgRoot.getChildCount() > 0) {
			this.defaultTreeNode = searchNodeByOrgId(orgRoot, defaultOrgId, treeMain);
		}
		
	}
	public String getRootOrgUnitId(OrgViewType type) throws Exception {
		String orgUnitid = null;
		if ((OrgViewType.COSTCENTER.equals(type))
				&& (SysContext.getSysContext().getCurrentCostUnit() != null))
			orgUnitid = SysContext.getSysContext().getCurrentCostUnit().getId()
					.toString();
		else if ((OrgViewType.COMPANY.equals(type))
				&& (SysContext.getSysContext().getCurrentFIUnit() != null))
			orgUnitid = SysContext.getSysContext().getCurrentFIUnit().getId()
					.toString();
		else if (OrgViewType.SALE.equals(type))
			if (SysContext.getSysContext().getCurrentSaleUnit() != null) {
				orgUnitid = SysContext.getSysContext().getCurrentSaleUnit()
						.getId().toString();
			} else {
				MsgBox.showWarning(this, "当前组织不是行政组织");
				SysUtil.abort();
			}
		else if (OrgViewType.TRANSPORT.equals(type))
			if (SysContext.getSysContext().getCurrentTransportUnit() != null) {
				orgUnitid = SysContext.getSysContext()
						.getCurrentTransportUnit().getId().toString();
			} else {
				MsgBox.showWarning(this, "当前组织不是项目组织");
				SysUtil.abort();
			}
		else if ((OrgViewType.CTRLUNIT.equals(type))
				&& (SysContext.getSysContext().getCurrentCtrlUnit() != null))
			orgUnitid = SysContext.getSysContext().getCurrentCtrlUnit().getId()
					.toString();
		else {
			orgUnitid = SysContext.getSysContext().getCurrentOrgUnit().getId()
					.toString();
		}

		return orgUnitid;
	}
	protected IMetaDataPK getActionPK(ItemAction action) {
		if (action == null) {
			return null;
		}
		String actoinName = action.getClass().getName();
		if (actoinName.indexOf("$") >= 0) {
			actoinName = actoinName.substring(actoinName.indexOf("$") + 1);
		}

		return new MetaDataPK(actoinName);
	}
	private TreeNode searchNodeByOrgId(TreeNode orgNode, String orgId,
			KDTree orgTree) throws Exception {
		Object obj = ((DefaultKingdeeTreeNode) orgNode).getUserObject();
		String orgRootId = ((OrgStructureInfo) obj).getUnit().getId()
				.toString();
		if (orgRootId.equals(orgId)) {
			return orgNode;
		}

		int count = orgNode.getChildCount();
		DefaultKingdeeTreeNode treeNode = null;
		for (int i = 0; i < count; ++i) {
			treeNode = (DefaultKingdeeTreeNode) orgNode.getChildAt(i);
			Object userObj = treeNode.getUserObject();
			if (userObj instanceof OrgStructureInfo) {
				String orgId2 = ((OrgStructureInfo) userObj).getUnit().getId()
						.toString();

				if (orgId2.equals(orgId))
					return treeNode;
				if (treeNode.getChildCount() > 0) {
					treeNode = (DefaultKingdeeTreeNode) searchNodeByOrgId(
							treeNode, orgId, orgTree);
					if (treeNode != null)
						return treeNode;
				}
			} else {
				return searchNodeByOrgId(treeNode, orgId, orgTree);
			}
		}

		return null;
	}
	/**
	 * 【重写查询执行方法】
	 * 更改排序顺序
	 * @author ywj 2017-11-15
	 */
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK, EntityViewInfo viewInfo) {
		EntityViewInfo view = getQueryEntityViewInfo(viewInfo);
//		SorterItemCollection sic = view.getSorter();
//		SorterItemInfo number = new SorterItemInfo("number");//批次号
//		SorterItemInfo billSate = new SorterItemInfo("billSate");//单据状态
//		SorterItemInfo lastUpdateTime = new SorterItemInfo("lastUpdateTime");//最后更新时间
//		number.setSortType(SortType.ASCEND);
//		billSate.setSortType(SortType.ASCEND);
//		lastUpdateTime.setSortType(SortType.DESCEND);
//		sic.add(lastUpdateTime);
//		sic.add(number);
//		sic.add(billSate);
//		view.setSorter(sic);
		
		return super.getQueryExecutor(queryPK, view);
	}
	protected EntityViewInfo getQueryEntityViewInfo(EntityViewInfo viewInfo) {
		EntityViewInfo view = (EntityViewInfo) viewInfo.clone();
		view.getSorter().add(new SorterItemInfo("number"));

		FilterInfo filter = new FilterInfo();
		view.setFilter(filter);
		try {
			FilterInfo treeFilter = getOrgTreeQuery();

			//FilterInfo permissionFilter = getBizOrgFilter();

			FilterInfo currentFilter = viewInfo.getFilter();

			filter.mergeFilter(treeFilter, "and");
			//filter.mergeFilter(permissionFilter, "and");
			filter.mergeFilter(currentFilter, "and");
		} catch (Exception e) {
			e.printStackTrace();
			handUIException(e);
		}


		return view;
		
	}
	protected FilterInfo getOrgTreeQuery() {
		FilterInfo filter = new FilterInfo();
		FullOrgUnitInfo orgUnitInfo = getSelectedProjectOrgInfo();
		if (orgUnitInfo != null) {
			String orgFrsNum = orgUnitInfo.getLongNumber().substring(0, 1);
			String filterMark = "";
			FilterInfo projectOrgFilter = new FilterInfo();
			if ("F".equals(orgFrsNum)) {
				filterMark = "entrys.pmtProj.longNumber";
			}else{
				filterMark = "entrys.cooperation.longNumber";
			}
			projectOrgFilter.getFilterItems().add(new FilterItemInfo( filterMark, orgUnitInfo.getLongNumber() + "!%", CompareType.LIKE));
			projectOrgFilter.getFilterItems().add(new FilterItemInfo( filterMark, orgUnitInfo.getLongNumber(), CompareType.EQUALS));
			projectOrgFilter.setMaskString("#0 or #1");
			try {
				projectOrgFilter.mergeFilter(filter, "and");
			} catch (BOSException e) {
				e.printStackTrace();
			}
			return projectOrgFilter;
		}

		return filter;
	}
	protected FullOrgUnitInfo getSelectedProjectOrgInfo() {
		DefaultKingdeeTreeNode treeNode = (DefaultKingdeeTreeNode) this.treeMain
				.getLastSelectedPathComponent();

		if ((treeNode != null)
				&& (treeNode.getUserObject() instanceof FullOrgUnitInfo))
			return ((FullOrgUnitInfo) treeNode.getUserObject());
		if ((treeNode != null)
				&& (treeNode.getUserObject() instanceof OrgStructureInfo)) {
			return ((OrgStructureInfo) treeNode.getUserObject()).getUnit();
		}

		return null;
	}
	protected void treeMain_valueChanged(TreeSelectionEvent e) throws Exception {
		super.execQuery();
		refresh(null);
	}
	protected void prepareUIContext(UIContext uiContext, ActionEvent e) {
		super.prepareUIContext(uiContext, e);
		uiContext.put("projectOrgInfo", getSelectedProjectOrgInfo());
       }
       /*added by wangth on 20170711 end */
	
    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
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
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionView_actionPerformed
     */
    public void actionView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionView_actionPerformed(e);
        checkColor();
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkBill(new String[] { "20","30" }, "actionEdit");
    	//2016-11-24 zxh
    	//获取列表界面选取的集合
		List pkList = EcClientHelper.getSelectedIdValues(tblMain,getKeyFieldName());
		if (pkList.size() > 1) {
			//循环集合，取出分录集合
			Set etys = new HashSet();
	    	for (Iterator iter = pkList.iterator(); iter.hasNext();) {
				String id = (String) iter.next();
				WkPmtTrnInfo info = WkPmtTrnFactory.getRemoteInstance().getWkPmtTrnInfo(new ObjectUuidPK(id));
				WkPmtTrnEntryCollection antiEtyCol = info.getEntrys();
				for (int i = 0; i < antiEtyCol.size(); i++) {
					WkPmtTrnEntryInfo etyInfo = antiEtyCol.get(i);
					etys.add(etyInfo);
				}
			}
	      	//进行参数传递
	    	UIContext uiContext = new UIContext(this);
	        uiContext.put("etys", etys);
	       	IUIWindow ui = UIFactory.createUIFactory(UIFactoryName.NEWTAB).create("com.kingdee.eas.zjlw.certificates.client.WkPmtTrnECEditUI", uiContext, null, OprtState.ADDNEW);
	       	ui.show();
		}else{
			super.actionEdit_actionPerformed(e);
		}
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	checkBill(new String[] { "20","30" }, "actionRemove");
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
        checkColor();
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
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionQuery_actionPerformed
     */
    public void actionQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuery_actionPerformed(e);
        checkColor();
    }

    /**
     * output actionImportData_actionPerformed
     */
    public void actionImportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionImportData_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionExportData_actionPerformed
     */
    public void actionExportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportData_actionPerformed(e);
    }

    /**
     * output actionToExcel_actionPerformed
     */
    public void actionToExcel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToExcel_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionPublishReport_actionPerformed
     */
    public void actionPublishReport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPublishReport_actionPerformed(e);
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
     * output actionQueryScheme_actionPerformed
     */
    public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryScheme_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
    	setDAPTrans(true); 
        super.actionCreateTo_actionPerformed(e);
        setDAPTrans(false);
    }

    /**
     * output actionCopyTo_actionPerformed
     */
    public void actionCopyTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyTo_actionPerformed(e);
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
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
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
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionSendSmsMessage_actionPerformed
     */
    public void actionSendSmsMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendSmsMessage_actionPerformed(e);
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
     * output actoinViewSignature_actionPerformed
     */
    public void actoinViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actoinViewSignature_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output actionTDPrint_actionPerformed
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrint_actionPerformed(e);
    }

    /**
     * output actionTDPrintPreview_actionPerformed
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrintPreview_actionPerformed(e);
    }

   

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.WkPmtTrnFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo objectValue = new com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo();
		
        return objectValue;
    }
    protected String getEditUIModal() {
    	return UIFactoryName.NEWTAB;
    }
}