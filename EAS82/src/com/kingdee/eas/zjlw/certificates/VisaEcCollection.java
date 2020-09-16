package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VisaEcCollection extends AbstractObjectCollection 
{
    public VisaEcCollection()
    {
        super(VisaEcInfo.class);
    }
    public boolean add(VisaEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VisaEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VisaEcInfo item)
    {
        return removeObject(item);
    }
    public VisaEcInfo get(int index)
    {
        return(VisaEcInfo)getObject(index);
    }
    public VisaEcInfo get(Object key)
    {
        return(VisaEcInfo)getObject(key);
    }
    public void set(int index, VisaEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VisaEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VisaEcInfo item)
    {
        return super.indexOf(item);
    }
}