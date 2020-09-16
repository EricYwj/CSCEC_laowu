package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VisaHandleCollection extends AbstractObjectCollection 
{
    public VisaHandleCollection()
    {
        super(VisaHandleInfo.class);
    }
    public boolean add(VisaHandleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VisaHandleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VisaHandleInfo item)
    {
        return removeObject(item);
    }
    public VisaHandleInfo get(int index)
    {
        return(VisaHandleInfo)getObject(index);
    }
    public VisaHandleInfo get(Object key)
    {
        return(VisaHandleInfo)getObject(key);
    }
    public void set(int index, VisaHandleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VisaHandleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VisaHandleInfo item)
    {
        return super.indexOf(item);
    }
}