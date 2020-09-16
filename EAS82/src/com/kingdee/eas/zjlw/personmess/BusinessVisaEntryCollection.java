package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BusinessVisaEntryCollection extends AbstractObjectCollection 
{
    public BusinessVisaEntryCollection()
    {
        super(BusinessVisaEntryInfo.class);
    }
    public boolean add(BusinessVisaEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BusinessVisaEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BusinessVisaEntryInfo item)
    {
        return removeObject(item);
    }
    public BusinessVisaEntryInfo get(int index)
    {
        return(BusinessVisaEntryInfo)getObject(index);
    }
    public BusinessVisaEntryInfo get(Object key)
    {
        return(BusinessVisaEntryInfo)getObject(key);
    }
    public void set(int index, BusinessVisaEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BusinessVisaEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BusinessVisaEntryInfo item)
    {
        return super.indexOf(item);
    }
}