package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class UplivePermitECEntryCollection extends AbstractObjectCollection 
{
    public UplivePermitECEntryCollection()
    {
        super(UplivePermitECEntryInfo.class);
    }
    public boolean add(UplivePermitECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(UplivePermitECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(UplivePermitECEntryInfo item)
    {
        return removeObject(item);
    }
    public UplivePermitECEntryInfo get(int index)
    {
        return(UplivePermitECEntryInfo)getObject(index);
    }
    public UplivePermitECEntryInfo get(Object key)
    {
        return(UplivePermitECEntryInfo)getObject(key);
    }
    public void set(int index, UplivePermitECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(UplivePermitECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(UplivePermitECEntryInfo item)
    {
        return super.indexOf(item);
    }
}