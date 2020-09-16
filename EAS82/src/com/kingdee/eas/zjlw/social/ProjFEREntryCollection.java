package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjFEREntryCollection extends AbstractObjectCollection 
{
    public ProjFEREntryCollection()
    {
        super(ProjFEREntryInfo.class);
    }
    public boolean add(ProjFEREntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjFEREntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjFEREntryInfo item)
    {
        return removeObject(item);
    }
    public ProjFEREntryInfo get(int index)
    {
        return(ProjFEREntryInfo)getObject(index);
    }
    public ProjFEREntryInfo get(Object key)
    {
        return(ProjFEREntryInfo)getObject(key);
    }
    public void set(int index, ProjFEREntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjFEREntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjFEREntryInfo item)
    {
        return super.indexOf(item);
    }
}