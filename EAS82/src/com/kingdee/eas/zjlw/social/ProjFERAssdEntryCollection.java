package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjFERAssdEntryCollection extends AbstractObjectCollection 
{
    public ProjFERAssdEntryCollection()
    {
        super(ProjFERAssdEntryInfo.class);
    }
    public boolean add(ProjFERAssdEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjFERAssdEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjFERAssdEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjFERAssdEntryInfo get(int index)
    {
        return(ProjFERAssdEntryInfo)getObject(index);
    }
    public ProjFERAssdEntryInfo get(Object key)
    {
        return(ProjFERAssdEntryInfo)getObject(key);
    }
    public void set(int index, ProjFERAssdEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjFERAssdEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjFERAssdEntryInfo item)
    {
        return super.indexOf(item);
    }
}