package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjInsVcPayRegCollection extends AbstractObjectCollection 
{
    public ProjInsVcPayRegCollection()
    {
        super(ProjInsVcPayRegInfo.class);
    }
    public boolean add(ProjInsVcPayRegInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjInsVcPayRegCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjInsVcPayRegInfo item)
    {
        return removeObject(item);
    }
    public ProjInsVcPayRegInfo get(int index)
    {
        return(ProjInsVcPayRegInfo)getObject(index);
    }
    public ProjInsVcPayRegInfo get(Object key)
    {
        return(ProjInsVcPayRegInfo)getObject(key);
    }
    public void set(int index, ProjInsVcPayRegInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjInsVcPayRegInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjInsVcPayRegInfo item)
    {
        return super.indexOf(item);
    }
}