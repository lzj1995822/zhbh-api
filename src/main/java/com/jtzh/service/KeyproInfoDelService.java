package com.jtzh.service;

import com.jtzh.detail.pojo.KeyproInfDelDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KeyproInfoPagination;

public interface KeyproInfoDelService {
	public Object getKeyproInfoDelList(KeyproInfoPagination param);

	public Object getKeyproInfoDel(String type, String id);

	public Object removeKeyproInfoDel(String id);

	public Object addKeyproInfDel(KeyproInfDelDetail detail, LoginUserTest user);

	public Object modifyKeyproInfDel(KeyproInfDelDetail detail);

	public Object getKeyproInfoDelList2(KeyproInfoPagination param);
}
