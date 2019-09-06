package com.jtzh.mapper;

import com.jtzh.vo.app.EventDealingVideoVO;
import com.jtzh.entity.TEFile;

import java.util.List;

public abstract interface TEFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TEFile paramTEFile);
  
  public abstract TEFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<TEFile> selectAll();
  
  public abstract int updateByPrimaryKey(TEFile paramTEFile);
  
  public abstract TEFile selectByDisputeEventID(Long paramLong);
  
  public abstract TEFile selectByServedRecordID(Long paramLong);
  
  public abstract TEFile selectByTrafficAccidentID(Long paramLong);
  
  public abstract TEFile selectBySSEventID(Long paramLong);
  
  public abstract TEFile selectBySPEventID(Long paramLong);
  
  public abstract TEFile selectByNetGridEventID(Long paramLong);
  
  public abstract List<TEFile> selectSPEventDealingFileBySPEventID(Long paramLong);
  
  public abstract List<TEFile> selectSSEventDealingFileBySSEventID(Long paramLong);
  
  public abstract List<TEFile> selectNetGridEventDealingFileByEventID(Long paramLong);
  
  public abstract List<TEFile> selectTrafficAccidentDealingFileByEventID(Long paramLong);
  
  public abstract List<TEFile> selectDisputeEventDealingFileByEventID(Long paramLong);
  
  public abstract List<EventDealingVideoVO> selectSPEventDealingFileForAPP(Long paramLong);
  
  public abstract List<EventDealingVideoVO> selectSSEventDealingFileForAPP(Long paramLong);
  
  public abstract List<EventDealingVideoVO> selectTrafficAccidentDealingFileForAPP(Long paramLong);
  
  public abstract List<EventDealingVideoVO> selectDisputeEventDealingFileForAPP(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TEFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */