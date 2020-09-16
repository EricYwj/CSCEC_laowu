package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjChkCountCollection extends AbstractObjectCollection 
{
    public ProjChkCountCollection()
    {
        super(ProjChkCountInfo.class);
    }
    public boolean add(ProjChkCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjChkCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjChkCountInfo item)
    {
        return removeObject(item);
    }
    public ProjChkCountInfo get(int index)
    {
        return(ProjChkCountInfo)getObject(index);
    }
    public ProjChkCountInfo get(Object key)
    {
        return(ProjChkCountInfo)getObject(key);
    }
    public void set(int index, ProjChkCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjChkCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjChkCountInfo item)
    {
        return super.indexOf(item);
    }
}