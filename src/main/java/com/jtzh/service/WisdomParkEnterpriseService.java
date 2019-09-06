package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkEnterprise;
import com.jtzh.pojo.WisdomParkEnterprisePagination;

public interface WisdomParkEnterpriseService {
	public Object getWisdomParkEnterpriseList(WisdomParkEnterprisePagination param);

	public Object getWisdomParkEnterpriseInfo(String id);

	public Object removeWisdomParkEnterprise(String id);

	public Object addWisdomParkEnterprise(WisdomParkEnterprise param, LoginUserTest user);

	public Object modifyWisdomParkEnterprise(WisdomParkEnterprise param);
	
	public Object getWisdomParkEnterpriseGis();
	
	public Object countWEIndustryBelong();
	
	public Object countWEParkBelong();
	
}
