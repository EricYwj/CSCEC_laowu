package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiCheckedCollection extends AbstractObjectCollection 
{
    public ForiCheckedCollection()
    {
        super(ForiCheckedInfo.class);
    }
    public boolean add(ForiCheckedInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiCheckedCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiCheckedInfo item)
    {
        return removeObject(item);
    }
    public ForiCheckedInfo get(int index)
    {
        return(ForiCheckedInfo)getObject(index);
    }
    public ForiCheckedInfo get(Object key)
    {
        return(ForiCheckedInfo)getObject(key);
    }
    public void set(int index, ForiCheckedInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiCheckedInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiCheckedInfo item)
    {
        return super.indexOf(item);
    }
}