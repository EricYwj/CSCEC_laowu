package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LaborBureauCollection extends AbstractObjectCollection 
{
    public LaborBureauCollection()
    {
        super(LaborBureauInfo.class);
    }
    public boolean add(LaborBureauInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LaborBureauCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LaborBureauInfo item)
    {
        return removeObject(item);
    }
    public LaborBureauInfo get(int index)
    {
        return(LaborBureauInfo)getObject(index);
    }
    public LaborBureauInfo get(Object key)
    {
        return(LaborBureauInfo)getObject(key);
    }
    public void set(int index, LaborBureauInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LaborBureauInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LaborBureauInfo item)
    {
        return super.indexOf(item);
    }
}