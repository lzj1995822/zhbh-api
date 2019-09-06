package com.jtzh.service.Impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkBuild;
import com.jtzh.mapper.PworkBuildMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.PworkPagination;
import com.jtzh.service.PworkService;

@Service("pworkService")
public class PworkServiceImpl implements PworkService {
	@Resource
	private PworkBuildMapper workMapper;

	@Override
	public Object getPworkList(PworkPagination param) {
		// 查询总数
		int total = workMapper.selectTotal(param);
		List<PworkBuild> list = new ArrayList<PworkBuild>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = workMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getPwork(String type, String id) {
		PworkBuild work = workMapper.selectPwork(type, id);
		ResultObject obj = new ResultObject();
		obj.setObj(work);
		return obj;
	}

	@Override
	public Object removePwork(String id) {
		workMapper.deletePwork(id);
		return new ResultObject();
	}

	@Override
	public Object addPwork(PworkBuild work, LoginUserTest user) {
		work.setCreateTime(new Date());
		work.setDelflag(Constants.DELFLAG_FALSE);
		work.setPworkNumber("PW" + NumberUtil.getNumber());
		work.setYhzh(Constants.YHZH_BAOHUA);
		work.setCreateId(user.getLoginId());
		workMapper.insertPwork(work);
		return new ResultObject();
	}

	@Override
	public Object modifyPwork(PworkBuild work) {
		work.setDelflag(Constants.DELFLAG_FALSE);
		workMapper.updateByPrimaryKey(work);
		return new ResultObject();
	}

	@Override
	public void downloadPwork(HttpServletResponse res, PworkBuild work) {
		String originPath = work.getEnclosure();
		File originFile = new File(originPath);
		String fileName = work.getPworkTitle();
		res.reset();
		res.setContentType("application/octet-stream");
		// 设置文件名
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName); //
		byte[] buffer = new byte[1024];
		FileInputStream fis = null; // 文件输入流
		BufferedInputStream bis = null;
		OutputStream os = null; // 输出流
		try {
			os = res.getOutputStream();
			fis = new FileInputStream(originFile);
			bis = new BufferedInputStream(fis);
			int data;
			while ((data = bis.read(buffer)) != -1) {
				os.write(buffer, 0, data);
			}
			os.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
