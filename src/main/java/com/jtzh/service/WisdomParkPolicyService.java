package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkPolicy;
import com.jtzh.pojo.WisdomParkPolicyPagination;

public interface WisdomParkPolicyService {
	public Object getWisdomParkPolicyList(WisdomParkPolicyPagination param);

	public Object getWisdomParkPolicy(String id);

	public Object removeWisdomParkPolicy(String id);

	public Object insertWisdomParkPolicy(WisdomParkPolicy param, LoginUserTest user);

	public Object updateWisdomParkPolicy(WisdomParkPolicy param);
}
