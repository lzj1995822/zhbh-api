/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.vo.dispute.DisputeEventCountVO;
import com.jtzh.mapper.SkynetPatrolEventMapper;

/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class PerformanceSeriveImpl implements com.jtzh.service.PerformanceService
/*     */ {
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SocietySecurityEventMapper societySecurityEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventMapper disputeEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentMapper trafficAccidentMapper;
/*     */   @Autowired
/*     */   private SkynetPatrolEventMapper skynetPatrolEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridEventMapper netGridEventMapper;
/*     */   
/*     */   public Map getEventDataForCheck(Date start, Date end)
/*     */   {
/*  27 */     Map map = new java.util.HashMap();
/*     */     
/*  29 */     List<DisputeEventCountVO> list = this.disputeEventMapper.getDisputeEventCount(start, end);
/*     */     
/*  31 */     List<DisputeEventCountVO> ssList = this.societySecurityEventMapper.getSSEventCountForCheck(start, end);
/*     */     
/*  33 */     List<DisputeEventCountVO> spList = this.skynetPatrolEventMapper.getSPEventCountForCheck(start, end);
/*     */     
/*  35 */     List<DisputeEventCountVO> trafficList = this.trafficAccidentMapper.getTrafficEventCountForCheck(start, end);
/*     */     
/*  37 */     List<DisputeEventCountVO> netGridEventList = this.netGridEventMapper.getNetGridEventCountForCheck(start, end);
/*  38 */     List dispute = new ArrayList();
/*  39 */     List societySecurity = new ArrayList();
/*  40 */     List traffic = new ArrayList();
/*  41 */     List skynet = new ArrayList();
/*  42 */     List netGrid = new ArrayList();
/*  43 */     int len = list.size();
/*  44 */     int ssLen = ssList.size();
/*  45 */     int spLen = spList.size();
/*  46 */     int trafficLen = trafficList.size();
/*  47 */     int netGridLen = netGridEventList.size();
/*     */     
/*     */ 
/*  50 */     String[] names = new String[len];
/*  51 */     int[] solved = new int[len];
/*  52 */     int[] unsolved = new int[len];
/*  53 */     for (int i = 0; i < len; i++) {
/*  54 */       names[i] = ((DisputeEventCountVO)list.get(i)).getName();
/*  55 */       solved[i] = ((DisputeEventCountVO)list.get(i)).getSolved();
/*  56 */       unsolved[i] = ((DisputeEventCountVO)list.get(i)).getUnsolved();
/*     */     }
/*  58 */     dispute.add(names);
/*  59 */     dispute.add(solved);
/*  60 */     dispute.add(unsolved);
/*  61 */     map.put("dispute", dispute);
/*     */     
/*     */ 
/*  64 */     names = new String[ssLen];
/*  65 */     solved = new int[ssLen];
/*  66 */     unsolved = new int[ssLen];
/*  67 */     for (int i = 0; i < ssLen; i++) {
/*  68 */       names[i] = ((DisputeEventCountVO)ssList.get(i)).getName();
/*  69 */       solved[i] = ((DisputeEventCountVO)ssList.get(i)).getSolved();
/*  70 */       unsolved[i] = ((DisputeEventCountVO)ssList.get(i)).getUnsolved();
/*     */     }
/*  72 */     societySecurity.add(names);
/*  73 */     societySecurity.add(solved);
/*  74 */     societySecurity.add(unsolved);
/*  75 */     map.put("societySecurity", societySecurity);
/*     */     
/*     */ 
/*     */ 
/*  79 */     names = new String[spLen];
/*  80 */     solved = new int[spLen];
/*  81 */     unsolved = new int[spLen];
/*  82 */     for (int i = 0; i < spLen; i++) {
/*  83 */       names[i] = ((DisputeEventCountVO)spList.get(i)).getName();
/*  84 */       solved[i] = ((DisputeEventCountVO)spList.get(i)).getSolved();
/*  85 */       unsolved[i] = ((DisputeEventCountVO)spList.get(i)).getUnsolved();
/*     */     }
/*  87 */     skynet.add(names);
/*  88 */     skynet.add(solved);
/*  89 */     skynet.add(unsolved);
/*  90 */     map.put("skynet", skynet);
/*     */     
/*     */ 
/*     */ 
/*  94 */     names = new String[trafficLen];
/*  95 */     solved = new int[trafficLen];
/*  96 */     unsolved = new int[trafficLen];
/*  97 */     for (int i = 0; i < trafficLen; i++) {
/*  98 */       names[i] = ((DisputeEventCountVO)trafficList.get(i)).getName();
/*  99 */       solved[i] = ((DisputeEventCountVO)trafficList.get(i)).getSolved();
/* 100 */       unsolved[i] = ((DisputeEventCountVO)trafficList.get(i)).getUnsolved();
/*     */     }
/* 102 */     traffic.add(names);
/* 103 */     traffic.add(solved);
/* 104 */     traffic.add(unsolved);
/* 105 */     map.put("traffic", traffic);
/*     */     
/*     */ 
/*     */ 
/* 109 */     names = new String[netGridLen];
/* 110 */     solved = new int[netGridLen];
/* 111 */     unsolved = new int[netGridLen];
/* 112 */     for (int i = 0; i < netGridLen; i++) {
/* 113 */       names[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getName();
/* 114 */       solved[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getSolved();
/* 115 */       unsolved[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getUnsolved();
/*     */     }
/* 117 */     netGrid.add(names);
/* 118 */     netGrid.add(solved);
/* 119 */     netGrid.add(unsolved);
/* 120 */     map.put("netGrid", netGrid);
/*     */     
/* 122 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getEventDataByNetGrid(Date start, Date end)
/*     */   {
/* 128 */     Map map = new java.util.HashMap();
/* 129 */     List<DisputeEventCountVO> list = this.disputeEventMapper.getDisputeEventCount(start, end);
/* 130 */     List<DisputeEventCountVO> ssList = this.societySecurityEventMapper.getSSEventCountForCheck(start, end);
/* 131 */     List<DisputeEventCountVO> spList = this.skynetPatrolEventMapper.getSPEventCountForCheck(start, end);
/* 132 */     List<DisputeEventCountVO> trafficList = this.trafficAccidentMapper.getTrafficEventCountForCheck(start, end);
/* 133 */     List<DisputeEventCountVO> netGridEventList = this.netGridEventMapper.getNetGridEventCountForCheck(start, end);
/* 134 */     List dispute = new ArrayList();
/* 135 */     List societySecurity = new ArrayList();
/* 136 */     List traffic = new ArrayList();
/* 137 */     List skynet = new ArrayList();
/* 138 */     List netGrid = new ArrayList();
/* 139 */     int len = list.size();
/* 140 */     int ssLen = ssList.size();
/* 141 */     int spLen = spList.size();
/* 142 */     int trafficLen = trafficList.size();
/* 143 */     int netGridLen = netGridEventList.size();
/*     */     
/*     */ 
/* 146 */     String[] names = new String[len];
/* 147 */     int[] solved = new int[len];
/* 148 */     int[] unsolved = new int[len];
/* 149 */     int[] num = new int[len];
/* 150 */     for (int i = 0; i < len; i++) {
/* 151 */       names[i] = ((DisputeEventCountVO)list.get(i)).getName();
/* 152 */       solved[i] = ((DisputeEventCountVO)list.get(i)).getSolved();
/* 153 */       unsolved[i] = ((DisputeEventCountVO)list.get(i)).getUnsolved();
/* 154 */       solved[i] += unsolved[i];
/*     */     }
/* 156 */     dispute.add(names);
/* 157 */     dispute.add(solved);
/* 158 */     map.put("dispute", dispute);
/*     */     
/*     */ 
/* 161 */     names = new String[ssLen];
/* 162 */     solved = new int[ssLen];
/* 163 */     unsolved = new int[ssLen];
/* 164 */     num = new int[ssLen];
/* 165 */     for (int i = 0; i < ssLen; i++) {
/* 166 */       names[i] = ((DisputeEventCountVO)ssList.get(i)).getName();
/* 167 */       solved[i] = ((DisputeEventCountVO)ssList.get(i)).getSolved();
/* 168 */       unsolved[i] = ((DisputeEventCountVO)ssList.get(i)).getUnsolved();
/* 169 */       solved[i] += unsolved[i];
/*     */     }
/* 171 */     societySecurity.add(names);
/* 172 */     societySecurity.add(solved);
/* 173 */     map.put("societySecurity", societySecurity);
/*     */     
/*     */ 
/*     */ 
/* 177 */     names = new String[spLen];
/* 178 */     solved = new int[spLen];
/* 179 */     unsolved = new int[spLen];
/* 180 */     num = new int[spLen];
/* 181 */     for (int i = 0; i < spLen; i++) {
/* 182 */       names[i] = ((DisputeEventCountVO)spList.get(i)).getName();
/* 183 */       solved[i] = ((DisputeEventCountVO)spList.get(i)).getSolved();
/* 184 */       unsolved[i] = ((DisputeEventCountVO)spList.get(i)).getUnsolved();
/* 185 */       solved[i] += unsolved[i];
/*     */     }
/* 187 */     skynet.add(names);
/* 188 */     skynet.add(solved);
/* 189 */     map.put("skynet", skynet);
/*     */     
/*     */ 
/*     */ 
/* 193 */     names = new String[trafficLen];
/* 194 */     solved = new int[trafficLen];
/* 195 */     unsolved = new int[trafficLen];
/* 196 */     num = new int[trafficLen];
/* 197 */     for (int i = 0; i < trafficLen; i++) {
/* 198 */       names[i] = ((DisputeEventCountVO)trafficList.get(i)).getName();
/* 199 */       solved[i] = ((DisputeEventCountVO)trafficList.get(i)).getSolved();
/* 200 */       unsolved[i] = ((DisputeEventCountVO)trafficList.get(i)).getUnsolved();
/* 201 */       solved[i] += unsolved[i];
/*     */     }
/* 203 */     traffic.add(names);
/* 204 */     traffic.add(solved);
/* 205 */     map.put("traffic", traffic);
/*     */     
/*     */ 
/* 208 */     names = new String[netGridLen];
/* 209 */     solved = new int[netGridLen];
/* 210 */     unsolved = new int[netGridLen];
/* 211 */     num = new int[netGridLen];
/* 212 */     for (int i = 0; i < netGridLen; i++) {
/* 213 */       names[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getName();
/* 214 */       solved[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getSolved();
/* 215 */       unsolved[i] = ((DisputeEventCountVO)netGridEventList.get(i)).getUnsolved();
/* 216 */       solved[i] += unsolved[i];
/*     */     }
/* 218 */     netGrid.add(names);
/* 219 */     netGrid.add(solved);
/* 220 */     map.put("netGrid", netGrid);
/*     */     
/* 222 */     return map;
/*     */   }
/*     */   
/*     */   public Map getEventCountByStatus(Date start, Date end)
/*     */   {
/* 227 */     Map dispute = this.disputeEventMapper.getDisputeEventByStatus(start, end);
/* 228 */     Map ssevent = this.societySecurityEventMapper.getSSEventByStatus(start, end);
/* 229 */     Map spevent = this.skynetPatrolEventMapper.getSPEventByStatus(start, end);
/* 230 */     Map traffic = this.trafficAccidentMapper.getTrafficEventByStatus(start, end);
/* 231 */     Map netGrid = this.netGridEventMapper.getNetGridEventByStatus(start, end);
/* 232 */     String[] name = { "社会治安", "矛盾纠纷", "交通事故", "天网巡防", "问题上报" };
/* 233 */     int[] solved = { Integer.valueOf(ssevent.get("solved").toString()).intValue(), Integer.valueOf(dispute.get("solved").toString()).intValue(), Integer.valueOf(traffic.get("solved").toString()).intValue(), Integer.valueOf(spevent.get("solved").toString()).intValue(), Integer.valueOf(netGrid.get("solved").toString()).intValue() };
/* 234 */     int[] unsolved = { Integer.valueOf(ssevent.get("unsolved").toString()).intValue(), Integer.valueOf(dispute.get("unsolved").toString()).intValue(), Integer.valueOf(traffic.get("unsolved").toString()).intValue(), Integer.valueOf(spevent.get("unsolved").toString()).intValue(), Integer.valueOf(netGrid.get("unsolved").toString()).intValue() };
/* 235 */     Map map = new java.util.HashMap();
/* 236 */     map.put("name", name);
/* 237 */     map.put("solved", solved);
/* 238 */     map.put("unsolved", unsolved);
/* 239 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\PerformanceSeriveImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */