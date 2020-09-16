package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EmbassyRegEntryCollection extends AbstractObjectCollection 
{
    public EmbassyRegEntryCollection()
    {
        super(EmbassyRegEntryInfo.class);
    }
    public boolean add(EmbassyRegEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EmbassyRegEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EmbassyRegEntryInfo item)
    {
        return removeObject(item);
    }
    public EmbassyRegEntryInfo get(int index)
    {
        return(EmbassyRegEntryInfo)getObject(index);
    }
    public EmbassyRegEntryInfo get(Object key)
    {
        return(EmbassyRegEntryInfo)getObject(key);
    }
    public void set(int index, EmbassyRegEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EmbassyRegEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EmbassyRegEntryInfo item)
    {
        return super.indexOf(item);
    }
}