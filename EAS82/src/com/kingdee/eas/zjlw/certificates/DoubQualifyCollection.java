package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoubQualifyCollection extends AbstractObjectCollection 
{
    public DoubQualifyCollection()
    {
        super(DoubQualifyInfo.class);
    }
    public boolean add(DoubQualifyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoubQualifyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoubQualifyInfo item)
    {
        return removeObject(item);
    }
    public DoubQualifyInfo get(int index)
    {
        return(DoubQualifyInfo)getObject(index);
    }
    public DoubQualifyInfo get(Object key)
    {
        return(DoubQualifyInfo)getObject(key);
    }
    public void set(int index, DoubQualifyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoubQualifyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoubQualifyInfo item)
    {
        return super.indexOf(item);
    }
}