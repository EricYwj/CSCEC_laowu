package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuSplitEntryCollection extends AbstractObjectCollection 
{
    public SecuSplitEntryCollection()
    {
        super(SecuSplitEntryInfo.class);
    }
    public boolean add(SecuSplitEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuSplitEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuSplitEntryInfo item)
    {
        return removeObject(item);
    }
    public SecuSplitEntryInfo get(int index)
    {
        return(SecuSplitEntryInfo)getObject(index);
    }
    public SecuSplitEntryInfo get(Object key)
    {
        return(SecuSplitEntryInfo)getObject(key);
    }
    public void set(int index, SecuSplitEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuSplitEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuSplitEntryInfo item)
    {
        return super.indexOf(item);
    }
}