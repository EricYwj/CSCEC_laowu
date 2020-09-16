package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class UplivePermitECCollection extends AbstractObjectCollection 
{
    public UplivePermitECCollection()
    {
        super(UplivePermitECInfo.class);
    }
    public boolean add(UplivePermitECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(UplivePermitECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(UplivePermitECInfo item)
    {
        return removeObject(item);
    }
    public UplivePermitECInfo get(int index)
    {
        return(UplivePermitECInfo)getObject(index);
    }
    public UplivePermitECInfo get(Object key)
    {
        return(UplivePermitECInfo)getObject(key);
    }
    public void set(int index, UplivePermitECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(UplivePermitECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(UplivePermitECInfo item)
    {
        return super.indexOf(item);
    }
}