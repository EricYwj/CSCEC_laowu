package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExLivepermitEntryCollection extends AbstractObjectCollection 
{
    public ExLivepermitEntryCollection()
    {
        super(ExLivepermitEntryInfo.class);
    }
    public boolean add(ExLivepermitEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExLivepermitEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExLivepermitEntryInfo item)
    {
        return removeObject(item);
    }
    public ExLivepermitEntryInfo get(int index)
    {
        return(ExLivepermitEntryInfo)getObject(index);
    }
    public ExLivepermitEntryInfo get(Object key)
    {
        return(ExLivepermitEntryInfo)getObject(key);
    }
    public void set(int index, ExLivepermitEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExLivepermitEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExLivepermitEntryInfo item)
    {
        return super.indexOf(item);
    }
}