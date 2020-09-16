package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExilivepermitECEntryCollection extends AbstractObjectCollection 
{
    public ExilivepermitECEntryCollection()
    {
        super(ExilivepermitECEntryInfo.class);
    }
    public boolean add(ExilivepermitECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExilivepermitECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExilivepermitECEntryInfo item)
    {
        return removeObject(item);
    }
    public ExilivepermitECEntryInfo get(int index)
    {
        return(ExilivepermitECEntryInfo)getObject(index);
    }
    public ExilivepermitECEntryInfo get(Object key)
    {
        return(ExilivepermitECEntryInfo)getObject(key);
    }
    public void set(int index, ExilivepermitECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExilivepermitECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExilivepermitECEntryInfo item)
    {
        return super.indexOf(item);
    }
}