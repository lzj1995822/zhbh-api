package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.SafeManagementUser;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.SafeUserPagination;

public interface SafeManagementUserService {
	public BaseResponse<List<SafeManagementUser>> getSafeManagementUserList(SafeUserPagination param);
	
	public BaseResponse<SafeManagementUser> getSafeManagementUser(Integer id);
	
	public BaseResponse<String> removeSafeManagementUser(Integer id);
	
	public BaseResponse<String> addSafeManagementUser(SafeManagementUser param, LoginUserTest user);
	
	public BaseResponse<String> modifySafeManagementUser(SafeManagementUser param);
}
