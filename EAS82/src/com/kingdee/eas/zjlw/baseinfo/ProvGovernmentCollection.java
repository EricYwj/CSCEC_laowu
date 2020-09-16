package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProvGovernmentCollection extends AbstractObjectCollection 
{
    public ProvGovernmentCollection()
    {
        super(ProvGovernmentInfo.class);
    }
    public boolean add(ProvGovernmentInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProvGovernmentCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProvGovernmentInfo item)
    {
        return removeObject(item);
    }
    public ProvGovernmentInfo get(int index)
    {
        return(ProvGovernmentInfo)getObject(index);
    }
    public ProvGovernmentInfo get(Object key)
    {
        return(ProvGovernmentInfo)getObject(key);
    }
    public void set(int index, ProvGovernmentInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProvGovernmentInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProvGovernmentInfo item)
    {
        return super.indexOf(item);
    }
}