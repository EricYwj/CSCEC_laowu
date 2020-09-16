package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiOutEcEntryCollection extends AbstractObjectCollection 
{
    public AntiOutEcEntryCollection()
    {
        super(AntiOutEcEntryInfo.class);
    }
    public boolean add(AntiOutEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiOutEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiOutEcEntryInfo item)
    {
        return removeObject(item);
    }
    public AntiOutEcEntryInfo get(int index)
    {
        return(AntiOutEcEntryInfo)getObject(index);
    }
    public AntiOutEcEntryInfo get(Object key)
    {
        return(AntiOutEcEntryInfo)getObject(key);
    }
    public void set(int index, AntiOutEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiOutEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiOutEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}