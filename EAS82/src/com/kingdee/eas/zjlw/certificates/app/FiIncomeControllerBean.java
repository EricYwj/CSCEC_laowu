package com.kingdee.eas.zjlw.certificates.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;

public class FiIncomeControllerBean extends AbstractFiIncomeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.FiIncomeControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FiIncomeInfo accInfo = (FiIncomeInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//    				
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }

		return super._save(ctx, accInfo);
	}

	// �ύ
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FiIncomeInfo accInfo = (FiIncomeInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._submit(ctx, accInfo);
	}

	// ���ͨ��
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		FiIncomeInfo info = (FiIncomeInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ���Ѵ������ͨ�������ݣ�������ˣ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		checkProfCount(ctx, info);// У��ָ�깤������
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writePersonHis(ctx, info, true);// ������Ա��ʷ��Ϣ����Աҵ��״̬����д��Ŀ��������
	}

	/**
	 * У��ָ�깤������
	 * 
	 * @param ctx
	 * @param info
	 */
	private void checkProfCount(Context ctx, FiIncomeInfo info) {
		FiIncomeEntryCollection etyCol = info.getEntrys();
		for (int i = 0; i < etyCol.size(); i++) {
			FiIncomeEntryInfo etyInfo = etyCol.get(i);
			// etyInfo
		}
	}

	// ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		FiIncomeInfo info = (FiIncomeInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ������˲�ͨ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writePersonHis(ctx, info, false);// ������Ա��ʷ��Ϣ����Ա״̬��������Ŀ��������
	}

	// ������Ա��ʷ��Ϣ����Աҵ��״̬����д��Ŀ��������
	private void writePersonHis(Context ctx, FiIncomeInfo info, boolean isAudit) throws EASBizException, BOSException {
		FiIncomeEntryCollection fiEntryCol = info.getEntrys();
		for (int i = 0; i < fiEntryCol.size(); i++) {
			FiIncomeEntryInfo fiEntryInfo = fiEntryCol.get(i);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("bsnisState");
			sic.add("hBsnisState");
			sic.add("permitProfession");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			// filter.getFilterItems().add(new FilterItemInfo("idNum",
			// fiEntryInfo.getIdNum()));
			// filter.getFilterItems().add(new FilterItemInfo("passportNo",
			// fiEntryInfo.getPassportNo()));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId", fiEntryInfo.getPersonID()));
			// filter.setMaskString("#0 or #1");
			view.setFilter(filter);
			view.setSelector(sic);
			PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			for (int j = 0; j < personCol.size(); j++) {
				PersonHistoryInfo newper = personCol.get(j);
				perBizStateEnum hState = newper.getHBsnisState();
				newper.setHBsnisState(newper.getBsnisState());
				newper.setBsnisState(isAudit ? perBizStateEnum.INDEXALLOT : perBizStateEnum.MESSINPUT);// ��Ա״̬
				newper.setPermitProfession(isAudit ? fiEntryInfo.getPmtProfC() : null);// ָ�깤��
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
			}
			// ��д��Ŀ��������
			writeProjectWork(ctx, fiEntryInfo.getPmtProfC().getId().toString(), isAudit);
			// ��д��Ա��ʷ��Ϣָ�깤��
			// EntityViewInfo view1 = new EntityViewInfo();
			// FilterInfo filter1 = new FilterInfo();
			// filter1.getFilterItems().add(new
			// FilterItemInfo("idNum",fiEntryInfo.getIdNum()));
			// filter1.getFilterItems().add(new FilterItemInfo("passportNo",
			// fiEntryInfo.getPassportNo()));
			// // filter.setMaskString("#0 or #1");
			// view1.setFilter(filter1);
			// PersonHistoryCollection personCol1 =
			// PersonHistoryFactory.getLocalInstance
			// (ctx).getPersonHistoryCollection(view);
			// PersonHistoryInfo hisInfo = new PersonHistoryInfo();
			// //�ж��Ƿ�Ϊ�����ļ�¼
			// if (personCol1.size() == 0) {
			// hisInfo.setNameCN(fiEntryInfo.getName());//��������
			// hisInfo.setSex(fiEntryInfo.getGenDers());//�Ա�
			// hisInfo.setNation(fiEntryInfo.getCountry());//����
			// hisInfo.setIdNum(fiEntryInfo.getIdNum());//���֤��
			// hisInfo.setRealProf(fiEntryInfo.getActprofF());//ʵ�ʹ���
			// hisInfo.setPermitProfession(fiEntryInfo.getPmtProfC());//ָ�깤��
			// hisInfo.setWorkOrg(fiEntryInfo.getTaskProj());//������Ŀ
			// hisInfo.setPermitOrg(fiEntryInfo.getPmtProj());//ָ����Ŀ
			// hisInfo.setCooperation(fiEntryInfo.getPartner());//������λ
			// hisInfo.setPassportNo(fiEntryInfo.getPassportNo());//���պ���
			// PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
			// }else{
			// for(int j=0;j<personCol1.size();j++){
			// hisInfo =personCol1.get(j);
			// if(isAudit){//���ͨ������д
			// hisInfo.setPermitProfession(fiEntryInfo.getPmtProfC());
			// }else{//����ˣ�����
			// hisInfo.setPermitProfession(null);
			// }
			// PersonHistoryFactory.getLocalInstance(ctx).updatePartial(hisInfo,
			// sic1);
			// }
			// }
		}
	}

	// ������Ŀ�����е�����������ʣ������
	private void writeProjectWork(Context ctx, String id, boolean isAudit) throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (isAudit) {
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			} else {
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount() - pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;

	}
}