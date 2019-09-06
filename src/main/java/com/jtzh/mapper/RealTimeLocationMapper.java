package com.jtzh.mapper;

import com.jtzh.entity.RealTimeLocation;
import com.jtzh.vo.gis.RealTimeLocationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface RealTimeLocationMapper
{
    public abstract int deleteByPrimaryKey(Long paramLong);

    public abstract int insert(RealTimeLocation paramRealTimeLocation);

    public abstract int addRealTimeLocation(RealTimeLocation paramRealTimeLocation);

    public abstract RealTimeLocation selectByPrimaryKey(@Param("UserID") Long UserID);

    public abstract List<RealTimeLocation> selectAll();

    public abstract List<RealTimeLocationVO> getRealTimeLocation(@Param("netGridID") Long paramLong);

    public abstract int updateByPrimaryKey(RealTimeLocation paramRealTimeLocation);
}
