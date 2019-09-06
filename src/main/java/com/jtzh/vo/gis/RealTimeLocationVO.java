package com.jtzh.vo.gis;

import com.jtzh.entity.RealTimeLocation;

public class RealTimeLocationVO
        extends RealTimeLocation
{
    private String memberName;
    private Long netGridID;

    public String getMemberName()
    {
        return this.memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }

    public Long getNetGridID()
    {
        return this.netGridID;
    }

    public void setNetGridID(Long netGridID)
    {
        this.netGridID = netGridID;
    }
}