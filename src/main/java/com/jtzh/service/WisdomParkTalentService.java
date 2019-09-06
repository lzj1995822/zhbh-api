package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkTalent;
import com.jtzh.pojo.WisdomParkTalentPagination;

public interface WisdomParkTalentService {
	public Object getWisdomParkTalentList(WisdomParkTalentPagination param);

	public Object getWisdomParkTalent(String id);

	public Object removeWisdomParkTalent(String id);

	public Object insertWisdomParkTalent(WisdomParkTalent param, LoginUserTest user);

	public Object updateWisdomParkTalent(WisdomParkTalent param);
	
	public Object getWisdomParkTalentGis();
	
	public Object countWTHighestMajor();
	
	public Object countWTDecade();
}
