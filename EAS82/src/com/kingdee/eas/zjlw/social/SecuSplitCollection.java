package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuSplitCollection extends AbstractObjectCollection 
{
    public SecuSplitCollection()
    {
        super(SecuSplitInfo.class);
    }
    public boolean add(SecuSplitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuSplitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuSplitInfo item)
    {
        return removeObject(item);
    }
    public SecuSplitInfo get(int index)
    {
        return(SecuSplitInfo)getObject(index);
    }
    public SecuSplitInfo get(Object key)
    {
        return(SecuSplitInfo)getObject(key);
    }
    public void set(int index, SecuSplitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuSplitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuSplitInfo item)
    {
        return super.indexOf(item);
    }
}