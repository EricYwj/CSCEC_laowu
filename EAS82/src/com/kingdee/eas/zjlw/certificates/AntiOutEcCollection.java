package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiOutEcCollection extends AbstractObjectCollection 
{
    public AntiOutEcCollection()
    {
        super(AntiOutEcInfo.class);
    }
    public boolean add(AntiOutEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiOutEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiOutEcInfo item)
    {
        return removeObject(item);
    }
    public AntiOutEcInfo get(int index)
    {
        return(AntiOutEcInfo)getObject(index);
    }
    public AntiOutEcInfo get(Object key)
    {
        return(AntiOutEcInfo)getObject(key);
    }
    public void set(int index, AntiOutEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiOutEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiOutEcInfo item)
    {
        return super.indexOf(item);
    }
}