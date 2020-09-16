package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkVisaEntryCollection extends AbstractObjectCollection 
{
    public WorkVisaEntryCollection()
    {
        super(WorkVisaEntryInfo.class);
    }
    public boolean add(WorkVisaEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkVisaEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkVisaEntryInfo item)
    {
        return removeObject(item);
    }
    public WorkVisaEntryInfo get(int index)
    {
        return(WorkVisaEntryInfo)getObject(index);
    }
    public WorkVisaEntryInfo get(Object key)
    {
        return(WorkVisaEntryInfo)getObject(key);
    }
    public void set(int index, WorkVisaEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkVisaEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkVisaEntryInfo item)
    {
        return super.indexOf(item);
    }
}