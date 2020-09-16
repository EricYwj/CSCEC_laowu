package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExilivepermitEntryCollection extends AbstractObjectCollection 
{
    public ExilivepermitEntryCollection()
    {
        super(ExilivepermitEntryInfo.class);
    }
    public boolean add(ExilivepermitEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExilivepermitEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExilivepermitEntryInfo item)
    {
        return removeObject(item);
    }
    public ExilivepermitEntryInfo get(int index)
    {
        return(ExilivepermitEntryInfo)getObject(index);
    }
    public ExilivepermitEntryInfo get(Object key)
    {
        return(ExilivepermitEntryInfo)getObject(key);
    }
    public void set(int index, ExilivepermitEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExilivepermitEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExilivepermitEntryInfo item)
    {
        return super.indexOf(item);
    }
}