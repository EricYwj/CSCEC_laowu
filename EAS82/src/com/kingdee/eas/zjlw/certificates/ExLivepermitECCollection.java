package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExLivepermitECCollection extends AbstractObjectCollection 
{
    public ExLivepermitECCollection()
    {
        super(ExLivepermitECInfo.class);
    }
    public boolean add(ExLivepermitECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExLivepermitECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExLivepermitECInfo item)
    {
        return removeObject(item);
    }
    public ExLivepermitECInfo get(int index)
    {
        return(ExLivepermitECInfo)getObject(index);
    }
    public ExLivepermitECInfo get(Object key)
    {
        return(ExLivepermitECInfo)getObject(key);
    }
    public void set(int index, ExLivepermitECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExLivepermitECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExLivepermitECInfo item)
    {
        return super.indexOf(item);
    }
}