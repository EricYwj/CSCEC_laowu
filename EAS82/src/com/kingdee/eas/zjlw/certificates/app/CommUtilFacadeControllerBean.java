package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import javax.sql.RowSet;

import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationEntryCollection;
import com.kingdee.bos.metadata.bot.BOTRelationEntryFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.IBOTRelation;
import com.kingdee.bos.metadata.bot.IBOTRelationEntry;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
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

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CommUtilFacadeControllerBean extends AbstractCommUtilFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.CommUtilFacadeControllerBean");
    
    
    //根据单据分录ID查询BOTP关系
    protected boolean _ifHaveDestBills(Context ctx, String entryID)
    		throws BOSException, EASBizException {
    	boolean reval = false;
        String sql = "select fid from T_BOT_RelationEntry where FSrcEntryID='"+entryID+"'";
        RowSet rowSet = DbUtil.executeQuery(ctx, sql);
        try {
			while(rowSet.next()){
				reval = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return reval;
    }
}