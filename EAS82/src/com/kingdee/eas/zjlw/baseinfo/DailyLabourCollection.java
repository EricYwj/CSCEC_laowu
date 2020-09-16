package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DailyLabourCollection extends AbstractObjectCollection 
{
    public DailyLabourCollection()
    {
        super(DailyLabourInfo.class);
    }
    public boolean add(DailyLabourInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DailyLabourCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DailyLabourInfo item)
    {
        return removeObject(item);
    }
    public DailyLabourInfo get(int index)
    {
        return(DailyLabourInfo)getObject(index);
    }
    public DailyLabourInfo get(Object key)
    {
        return(DailyLabourInfo)getObject(key);
    }
    public void set(int index, DailyLabourInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DailyLabourInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DailyLabourInfo item)
    {
        return super.indexOf(item);
    }
}