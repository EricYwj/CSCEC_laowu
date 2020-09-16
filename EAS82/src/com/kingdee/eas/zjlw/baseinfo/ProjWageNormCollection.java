package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjWageNormCollection extends AbstractObjectCollection 
{
    public ProjWageNormCollection()
    {
        super(ProjWageNormInfo.class);
    }
    public boolean add(ProjWageNormInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjWageNormCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjWageNormInfo item)
    {
        return removeObject(item);
    }
    public ProjWageNormInfo get(int index)
    {
        return(ProjWageNormInfo)getObject(index);
    }
    public ProjWageNormInfo get(Object key)
    {
        return(ProjWageNormInfo)getObject(key);
    }
    public void set(int index, ProjWageNormInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjWageNormInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjWageNormInfo item)
    {
        return super.indexOf(item);
    }
}