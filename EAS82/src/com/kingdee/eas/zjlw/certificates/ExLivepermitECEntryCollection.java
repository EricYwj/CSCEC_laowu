package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExLivepermitECEntryCollection extends AbstractObjectCollection 
{
    public ExLivepermitECEntryCollection()
    {
        super(ExLivepermitECEntryInfo.class);
    }
    public boolean add(ExLivepermitECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExLivepermitECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExLivepermitECEntryInfo item)
    {
        return removeObject(item);
    }
    public ExLivepermitECEntryInfo get(int index)
    {
        return(ExLivepermitECEntryInfo)getObject(index);
    }
    public ExLivepermitECEntryInfo get(Object key)
    {
        return(ExLivepermitECEntryInfo)getObject(key);
    }
    public void set(int index, ExLivepermitECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExLivepermitECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExLivepermitECEntryInfo item)
    {
        return super.indexOf(item);
    }
}