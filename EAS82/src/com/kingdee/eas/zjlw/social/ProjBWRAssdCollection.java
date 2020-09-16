package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjBWRAssdCollection extends AbstractObjectCollection 
{
    public ProjBWRAssdCollection()
    {
        super(ProjBWRAssdInfo.class);
    }
    public boolean add(ProjBWRAssdInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjBWRAssdCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjBWRAssdInfo item)
    {
        return removeObject(item);
    }
    public ProjBWRAssdInfo get(int index)
    {
        return(ProjBWRAssdInfo)getObject(index);
    }
    public ProjBWRAssdInfo get(Object key)
    {
        return(ProjBWRAssdInfo)getObject(key);
    }
    public void set(int index, ProjBWRAssdInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjBWRAssdInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjBWRAssdInfo item)
    {
        return super.indexOf(item);
    }
}