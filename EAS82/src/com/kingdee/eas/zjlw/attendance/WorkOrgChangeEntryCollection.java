package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkOrgChangeEntryCollection extends AbstractObjectCollection 
{
    public WorkOrgChangeEntryCollection()
    {
        super(WorkOrgChangeEntryInfo.class);
    }
    public boolean add(WorkOrgChangeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkOrgChangeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkOrgChangeEntryInfo item)
    {
        return removeObject(item);
    }
    public WorkOrgChangeEntryInfo get(int index)
    {
        return(WorkOrgChangeEntryInfo)getObject(index);
    }
    public WorkOrgChangeEntryInfo get(Object key)
    {
        return(WorkOrgChangeEntryInfo)getObject(key);
    }
    public void set(int index, WorkOrgChangeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkOrgChangeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkOrgChangeEntryInfo item)
    {
        return super.indexOf(item);
    }
}