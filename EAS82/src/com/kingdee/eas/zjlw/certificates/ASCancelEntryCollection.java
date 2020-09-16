package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ASCancelEntryCollection extends AbstractObjectCollection 
{
    public ASCancelEntryCollection()
    {
        super(ASCancelEntryInfo.class);
    }
    public boolean add(ASCancelEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ASCancelEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ASCancelEntryInfo item)
    {
        return removeObject(item);
    }
    public ASCancelEntryInfo get(int index)
    {
        return(ASCancelEntryInfo)getObject(index);
    }
    public ASCancelEntryInfo get(Object key)
    {
        return(ASCancelEntryInfo)getObject(key);
    }
    public void set(int index, ASCancelEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ASCancelEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ASCancelEntryInfo item)
    {
        return super.indexOf(item);
    }
}