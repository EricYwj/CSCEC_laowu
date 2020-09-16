package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DistrGovernmentCollection extends AbstractObjectCollection 
{
    public DistrGovernmentCollection()
    {
        super(DistrGovernmentInfo.class);
    }
    public boolean add(DistrGovernmentInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DistrGovernmentCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DistrGovernmentInfo item)
    {
        return removeObject(item);
    }
    public DistrGovernmentInfo get(int index)
    {
        return(DistrGovernmentInfo)getObject(index);
    }
    public DistrGovernmentInfo get(Object key)
    {
        return(DistrGovernmentInfo)getObject(key);
    }
    public void set(int index, DistrGovernmentInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DistrGovernmentInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DistrGovernmentInfo item)
    {
        return super.indexOf(item);
    }
}