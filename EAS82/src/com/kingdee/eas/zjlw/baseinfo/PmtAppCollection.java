package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PmtAppCollection extends AbstractObjectCollection 
{
    public PmtAppCollection()
    {
        super(PmtAppInfo.class);
    }
    public boolean add(PmtAppInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PmtAppCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PmtAppInfo item)
    {
        return removeObject(item);
    }
    public PmtAppInfo get(int index)
    {
        return(PmtAppInfo)getObject(index);
    }
    public PmtAppInfo get(Object key)
    {
        return(PmtAppInfo)getObject(key);
    }
    public void set(int index, PmtAppInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PmtAppInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PmtAppInfo item)
    {
        return super.indexOf(item);
    }
}