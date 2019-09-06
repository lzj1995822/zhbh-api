package com.jtzh.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.jtzh.detail.pojo.KeyProblemChuliDetail;
import com.jtzh.detail.pojo.KeyproProblemAppointmans;
import com.jtzh.detail.pojo.KeyproProblemDetail;
import com.jtzh.entity.KeyproProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KeyproProblemReq;
import com.jtzh.pojo.ProblemPagination;

public interface KeyproProblemService {
	public Object getProblemList(ProblemPagination param, LoginUserTest user);
	public Object selectProblemAndProName(ProblemPagination param, LoginUserTest user);
	public Object getProblemListApp(ProblemPagination param, LoginUserTest user);
	public Object getProblemListWeb(ProblemPagination param);

	public Object getProblemList1(ProblemPagination param, LoginUserTest user);

	public Object getProblem(String id);

	public Object getProblemChuli(String id);

	public Object removeProblem(String id);

	public Object addProblem(KeyproProblemDetail detail, LoginUserTest user);

	public Object modifyProblem(KeyproProblemDetail detail);

	public int desert(String id);

	public int recovery(String id);

	public int chuli(String id);

	public int finish(KeyproProblemReq param);
	
	public Object keyGetAllSolve(String shangbaoid);

	public int huitui(String id);

	public int yishenghe(String id);

	public int yilian(KeyproProblem param);

	public Object paifa(KeyproProblemAppointmans param);

	public Object shenghe(KeyproProblemReq param);

	public Object solve(KeyProblemChuliDetail param);

	public Object countProblemState();

	public int yuqi();

	public Object findAllByState(String state);

	public Object findByStateRelax(String id);

	public Object getKeyCoordinate();
	
	public Object getFivePeople(String proId);
	
	public Object countProblemAllCountryside();
	
	public Object countProblemStateAll();
	
	public Object countProblemByYear(String year);

	public Object countProblemType();
	
}
