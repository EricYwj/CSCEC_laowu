package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkOrgChangeCollection extends AbstractObjectCollection 
{
    public WorkOrgChangeCollection()
    {
        super(WorkOrgChangeInfo.class);
    }
    public boolean add(WorkOrgChangeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkOrgChangeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkOrgChangeInfo item)
    {
        return removeObject(item);
    }
    public WorkOrgChangeInfo get(int index)
    {
        return(WorkOrgChangeInfo)getObject(index);
    }
    public WorkOrgChangeInfo get(Object key)
    {
        return(WorkOrgChangeInfo)getObject(key);
    }
    public void set(int index, WorkOrgChangeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkOrgChangeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkOrgChangeInfo item)
    {
        return super.indexOf(item);
    }
}