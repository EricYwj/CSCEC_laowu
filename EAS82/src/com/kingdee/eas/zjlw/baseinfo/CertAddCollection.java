package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CertAddCollection extends AbstractObjectCollection 
{
    public CertAddCollection()
    {
        super(CertAddInfo.class);
    }
    public boolean add(CertAddInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CertAddCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CertAddInfo item)
    {
        return removeObject(item);
    }
    public CertAddInfo get(int index)
    {
        return(CertAddInfo)getObject(index);
    }
    public CertAddInfo get(Object key)
    {
        return(CertAddInfo)getObject(key);
    }
    public void set(int index, CertAddInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CertAddInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CertAddInfo item)
    {
        return super.indexOf(item);
    }
}