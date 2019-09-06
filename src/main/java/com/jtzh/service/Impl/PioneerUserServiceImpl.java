package com.jtzh.service.Impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.ExcelUtil;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.common.util.SetResponseHeaderUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerUser;
import com.jtzh.mapper.PioneerUserMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.PioneerUserPagination;
import com.jtzh.service.PioneerUserService;

@Service("pioneerUserService")
public class PioneerUserServiceImpl implements PioneerUserService {
	@Resource
	private PioneerUserMapper pioneeruserMapper;

	@Override
	public Object getPioneerUserList(PioneerUserPagination param) {
		// 查询总数
		int total = pioneeruserMapper.selectTotal(param);
		List<PioneerUser> list = new ArrayList<PioneerUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = pioneeruserMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getPioneerUser(String id) {
		PioneerUser user = pioneeruserMapper.selectUser(id);
		ResultObject obj = new ResultObject();
		obj.setObj(user);
		return obj;
	}

	@Override
	public Object removePioneerUser(String id) {
		pioneeruserMapper.deleteUser(id);
		return new ResultObject();
	}

	@Override
	public Object insertPioneerUser(PioneerUser user, LoginUserTest loginUser) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		user.setCreateTime(new Date());
		user.setUserNumber("XFU" + NumberUtil.getNumber());
		user.setYhzh(Constants.YHZH_BAOHUA);
		user.setCreateId(loginUser.getLoginId());
		user.setCreateTime(new Date());
		pioneeruserMapper.insert(user);
		return new ResultObject();
	}

	@Override
	public Object updatePioneerUser(PioneerUser user) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		pioneeruserMapper.updateByPrimaryKey(user);
		return new ResultObject();
	}

	@Override
	public Object countNumber() {
		ResultObject obj = new ResultObject();
		obj.setObj(pioneeruserMapper.countNumber());
		return obj;
	}

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<PioneerUser> list = pioneeruserMapper.getUserList();
		// excel标题
		String[] title = { "序号", "姓名", "身份证号码", "性别", "民族", "出生日期", "学历", "人员类别", "所在党组织", "入党时间", "转正时间", "工作岗位",
				"家庭住址", "联系电话", "固定电话" };
		// excel文件名
		String fileName = "党员信息表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "党员信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			PioneerUser user = list.get(i);
			// content[i] = new String[title.length];
			content[i][0] = String.valueOf(i + 1);
			content[i][1] = user.getUserName();
			content[i][2] = user.getIdentityNumber();
			content[i][3] = user.getUserSex();
			content[i][4] = user.getUserNation();
			if (null != user.getBirthDate()) {
				SimpleDateFormat df = new SimpleDateFormat(Constants.DATEFORMATE_SIMPLE);
				String date = df.format(user.getBirthDate());
				content[i][5] = date;
			}
			content[i][6] = user.getAcademicQualification();
			content[i][7] = user.getUserClass();
			content[i][8] = user.getPartyOrg();
			if (null != user.getJoinPartyTime()) {
				SimpleDateFormat df = new SimpleDateFormat(Constants.DATEFORMATE_SIMPLE);
				String date = df.format(user.getJoinPartyTime());
				content[i][9] = date;
			}
			if (null != user.getFullMemberTime()) {
				SimpleDateFormat df = new SimpleDateFormat(Constants.DATEFORMATE_SIMPLE);
				String date = df.format(user.getFullMemberTime());
				content[i][10] = date;
			}
			content[i][11] = user.getUserJob();
			content[i][12] = user.getUserAddress();
			content[i][13] = user.getPhoneNumber();
			content[i][14] = user.getFixedTelephone();
		}
		// 创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		// 响应到客户端
		try {
			SetResponseHeaderUtil.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultObject();
	}

}
