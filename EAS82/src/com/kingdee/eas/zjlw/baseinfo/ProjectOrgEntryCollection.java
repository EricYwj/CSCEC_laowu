package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjectOrgEntryCollection extends AbstractObjectCollection 
{
    public ProjectOrgEntryCollection()
    {
        super(ProjectOrgEntryInfo.class);
    }
    public boolean add(ProjectOrgEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjectOrgEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjectOrgEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjectOrgEntryInfo get(int index)
    {
        return(ProjectOrgEntryInfo)getObject(index);
    }
    public ProjectOrgEntryInfo get(Object key)
    {
        return(ProjectOrgEntryInfo)getObject(key);
    }
    public void set(int index, ProjectOrgEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjectOrgEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjectOrgEntryInfo item)
    {
        return super.indexOf(item);
    }
}