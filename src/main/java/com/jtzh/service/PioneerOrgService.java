package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerOrg;
import com.jtzh.pojo.PioneerOrgPagination;

public interface PioneerOrgService {
	public Object getPioneerOrgList(PioneerOrgPagination param);

	public Object getPioneerOrg(String id);

	public Object removePioneerOrg(String id);

	public Object insertPioneerOrg(PioneerOrg org, LoginUserTest user);

	public Object updatePioneerOrg(PioneerOrg org);

	public Object getPioneerOrgTree();
	
	public Long getCountList();
	
	public Object getCountOrgList();
}
