package com.jtzh.service;

import com.jtzh.entity.GovmgtProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.ProblemPagination;

public interface ProblemService {
	public Object getProblemList(ProblemPagination param);

	public Object getProblem(String id);

	public Object removeProblem(String id);

	public Object addProblem(GovmgtProblem param, LoginUserTest user);

	public Object modifyProblem(GovmgtProblem param);
}
