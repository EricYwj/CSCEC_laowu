package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjFERAssdCollection extends AbstractObjectCollection 
{
    public ProjFERAssdCollection()
    {
        super(ProjFERAssdInfo.class);
    }
    public boolean add(ProjFERAssdInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjFERAssdCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjFERAssdInfo item)
    {
        return removeObject(item);
    }
    public ProjFERAssdInfo get(int index)
    {
        return(ProjFERAssdInfo)getObject(index);
    }
    public ProjFERAssdInfo get(Object key)
    {
        return(ProjFERAssdInfo)getObject(key);
    }
    public void set(int index, ProjFERAssdInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjFERAssdInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjFERAssdInfo item)
    {
        return super.indexOf(item);
    }
}