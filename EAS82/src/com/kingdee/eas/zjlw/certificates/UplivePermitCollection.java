package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class UplivePermitCollection extends AbstractObjectCollection 
{
    public UplivePermitCollection()
    {
        super(UplivePermitInfo.class);
    }
    public boolean add(UplivePermitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(UplivePermitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(UplivePermitInfo item)
    {
        return removeObject(item);
    }
    public UplivePermitInfo get(int index)
    {
        return(UplivePermitInfo)getObject(index);
    }
    public UplivePermitInfo get(Object key)
    {
        return(UplivePermitInfo)getObject(key);
    }
    public void set(int index, UplivePermitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(UplivePermitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(UplivePermitInfo item)
    {
        return super.indexOf(item);
    }
}