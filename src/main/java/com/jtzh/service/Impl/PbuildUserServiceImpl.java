package com.jtzh.service.Impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.ExcelUtil;
import com.jtzh.common.util.SetResponseHeaderUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkUser;
import com.jtzh.mapper.PworkUserMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.UserPagination;
import com.jtzh.service.PbuildUserService;

@Service("pbuildUserService")
public class PbuildUserServiceImpl implements PbuildUserService {
	@Resource
	private PworkUserMapper pworkUserMapper;

	@Override
	public Object getPbuserList(UserPagination param) {
		// 查询总数
		int total = pworkUserMapper.selectTotal(param);
		List<PworkUser> list = new ArrayList<PworkUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = pworkUserMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getPbuser(String id) {
		PworkUser user = pworkUserMapper.selectUser(id);
		ResultObject obj = new ResultObject();
		obj.setObj(user);
		return obj;
	}

	@Override
	public Object removePbuser(String id) {
		pworkUserMapper.deleteUser(id);
		return new ResultObject();
	}

	@Override
	public Object insertUser(PworkUser user, LoginUserTest loginUser) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		user.setCreateTime(new Date());
		user.setPassword(Constants.DEFAULT_USER_PASSWORD);
		user.setYhzh(Constants.YHZH_BAOHUA);
		user.setCreateId(loginUser.getLoginId());
		pworkUserMapper.insert(user);
		return new ResultObject();
	}

	@Override
	public Object updatePbuser(PworkUser user) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		pworkUserMapper.updateByPrimaryKey(user);
		return new ResultObject();
	}

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<PworkUser> list = pworkUserMapper.getUserList();
		// excel标题
		String[] title = { "序号", "部门名称", "姓名", "性别", "年龄", "职务", "身份", "备注",
				"身份证号码","民族","居住地址","经度","纬度"};
		// excel文件名
		String fileName = "用户表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "用户信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			PworkUser user = list.get(i);
			// content[i] = new String[title.length];
			content[i][0] = String.valueOf(i + 1);
			content[i][1] = user.getDepName();
			// if (CommonUtil.verifyString(user.getUserName()))
			content[i][2] = user.getUserName();
			// if (CommonUtil.verifyString(user.getUserSex()))
			content[i][3] = user.getUserSex();
			// if (CommonUtil.verifyString(user.getUserAge()))
			content[i][4] = user.getUserAge();
			content[i][5] = user.getUserIndustry();
			content[i][6] = user.getUserPosition();
			content[i][7] = user.getRemark();
			content[i][8] = user.getUserIdentity();
			content[i][9] = user.getUserNation();
			content[i][10] = user.getUserAddress();
			content[i][11] = user.getUserX();
			content[i][12] = user.getUserY();
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

	@Override
	public boolean batchImport(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<PworkUser> pworkUserList = new ArrayList<PworkUser>();
		// 判断是xls(03)或者xlsx(07)
		if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
		}
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		// is流用于接受excel文件流
		InputStream is = file.getInputStream();
		Workbook wb = null;
		// 根据03或者07版本去创建对应的workbook
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		}
		/*
		 * else { wb = new XSSFWorkbook(is); }
		 */
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}
		PworkUser pworkUser;
		// 取出每行的记录
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			pworkUser = new PworkUser();
			pworkUser.getUserName();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String depName = row.getCell(1).getStringCellValue();
			pworkUser.setDepName(depName);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String userName = row.getCell(2).getStringCellValue();
			pworkUser.setUserName(userName);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String userSex = row.getCell(3).getStringCellValue();
			pworkUser.setUserSex(userSex);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String userAge = row.getCell(4).getStringCellValue();
			pworkUser.setUserAge(userAge);
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			String job = row.getCell(5).getStringCellValue();
			pworkUser.setUserPosition(job);
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String industry = row.getCell(6).getStringCellValue();
			pworkUser.setUserIndustry(industry);
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String remark = row.getCell(7).getStringCellValue();
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String userIdentity = row.getCell(8).getStringCellValue();
			pworkUser.setUserIdentity(userIdentity);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String userNation = row.getCell(9).getStringCellValue();
			pworkUser.setUserNation(userNation);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String userAddress = row.getCell(10).getStringCellValue();
			pworkUser.setUserAddress(userAddress);
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			String userX = row.getCell(11).getStringCellValue();
			pworkUser.setUserX(userX);
			row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
			String userY = row.getCell(12).getStringCellValue();
			pworkUser.setUserY(userY);
			pworkUser.setRemark(remark);
			pworkUser.setDelflag("A");
			pworkUser.setPassword(Constants.DEFAULT_USER_PASSWORD);
			pworkUser.setCreateTime(new Date());
			pworkUserList.add(pworkUser);
		}
		// 遍历list的每条记录并新增
		for (PworkUser user : pworkUserList) {
			pworkUserMapper.insert(user);
		}
		return notNull;
	}
}
