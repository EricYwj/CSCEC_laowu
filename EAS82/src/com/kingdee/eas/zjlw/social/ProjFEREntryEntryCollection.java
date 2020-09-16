package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjFEREntryEntryCollection extends AbstractObjectCollection 
{
    public ProjFEREntryEntryCollection()
    {
        super(ProjFEREntryEntryInfo.class);
    }
    public boolean add(ProjFEREntryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjFEREntryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjFEREntryEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjFEREntryEntryInfo get(int index)
    {
        return(ProjFEREntryEntryInfo)getObject(index);
    }
    public ProjFEREntryEntryInfo get(Object key)
    {
        return(ProjFEREntryEntryInfo)getObject(key);
    }
    public void set(int index, ProjFEREntryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjFEREntryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjFEREntryEntryInfo item)
    {
        return super.indexOf(item);
    }
}