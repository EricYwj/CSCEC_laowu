package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgattenceResultCollection extends AbstractObjectCollection 
{
    public AlgattenceResultCollection()
    {
        super(AlgattenceResultInfo.class);
    }
    public boolean add(AlgattenceResultInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgattenceResultCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgattenceResultInfo item)
    {
        return removeObject(item);
    }
    public AlgattenceResultInfo get(int index)
    {
        return(AlgattenceResultInfo)getObject(index);
    }
    public AlgattenceResultInfo get(Object key)
    {
        return(AlgattenceResultInfo)getObject(key);
    }
    public void set(int index, AlgattenceResultInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgattenceResultInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgattenceResultInfo item)
    {
        return super.indexOf(item);
    }
}