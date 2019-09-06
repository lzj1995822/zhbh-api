package com.jtzh.service;

import java.util.Date;
import java.util.Map;

public abstract interface PerformanceService
{
  public abstract Map getEventDataForCheck(Date paramDate1, Date paramDate2);
  
  public abstract Map getEventDataByNetGrid(Date paramDate1, Date paramDate2);
  
  public abstract Map getEventCountByStatus(Date paramDate1, Date paramDate2);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\PerformanceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */