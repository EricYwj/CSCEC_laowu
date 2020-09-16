package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VisaHandleEntryCollection extends AbstractObjectCollection 
{
    public VisaHandleEntryCollection()
    {
        super(VisaHandleEntryInfo.class);
    }
    public boolean add(VisaHandleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VisaHandleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VisaHandleEntryInfo item)
    {
        return removeObject(item);
    }
    public VisaHandleEntryInfo get(int index)
    {
        return(VisaHandleEntryInfo)getObject(index);
    }
    public VisaHandleEntryInfo get(Object key)
    {
        return(VisaHandleEntryInfo)getObject(key);
    }
    public void set(int index, VisaHandleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VisaHandleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VisaHandleEntryInfo item)
    {
        return super.indexOf(item);
    }
}