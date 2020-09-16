package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ApEcCollection extends AbstractObjectCollection 
{
    public ApEcCollection()
    {
        super(ApEcInfo.class);
    }
    public boolean add(ApEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ApEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ApEcInfo item)
    {
        return removeObject(item);
    }
    public ApEcInfo get(int index)
    {
        return(ApEcInfo)getObject(index);
    }
    public ApEcInfo get(Object key)
    {
        return(ApEcInfo)getObject(key);
    }
    public void set(int index, ApEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ApEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ApEcInfo item)
    {
        return super.indexOf(item);
    }
}