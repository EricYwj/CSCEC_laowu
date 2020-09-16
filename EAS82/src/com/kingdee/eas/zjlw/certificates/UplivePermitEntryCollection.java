package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class UplivePermitEntryCollection extends AbstractObjectCollection 
{
    public UplivePermitEntryCollection()
    {
        super(UplivePermitEntryInfo.class);
    }
    public boolean add(UplivePermitEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(UplivePermitEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(UplivePermitEntryInfo item)
    {
        return removeObject(item);
    }
    public UplivePermitEntryInfo get(int index)
    {
        return(UplivePermitEntryInfo)getObject(index);
    }
    public UplivePermitEntryInfo get(Object key)
    {
        return(UplivePermitEntryInfo)getObject(key);
    }
    public void set(int index, UplivePermitEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(UplivePermitEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(UplivePermitEntryInfo item)
    {
        return super.indexOf(item);
    }
}