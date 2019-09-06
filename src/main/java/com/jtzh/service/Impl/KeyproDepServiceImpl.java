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
import com.jtzh.entity.KeyproDep;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.KeyproDepMapper;
import com.jtzh.pojo.DepPagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.KeyproDepService;

@Service("keyproDepService")
public class KeyproDepServiceImpl implements KeyproDepService {
	@Resource
	private KeyproDepMapper depMapper;

	@Override
	public Object getDepList(DepPagination param) {
		List<KeyproDep> list = new ArrayList<KeyproDep>();
		PageResult res = new PageResult();
		int count = depMapper.selectTotal(param);
		if (count > 0) {
			list = depMapper.selectInfo(param);;
		}
		res.setOk(true);
		res.setRows(list);
		res.setTotal(count);
		return res;
	}

	@Override
	public Object getDep(String id) {
		KeyproDep user = depMapper.selectDep(id);
		ResultObject obj = new ResultObject();
		obj.setObj(user);
		return obj;
	}

	@Override
	public Object removeDep(String id) {
		depMapper.deleteDep(id);
		return new ResultObject();
	}

	@Override
	public Object insertDep(KeyproDep dep, LoginUserTest user) {
		dep.setDelflag(Constants.DELFLAG_FALSE);
		dep.setCreateTime(new Date());
		dep.setYhzh(Constants.YHZH_BAOHUA);
		dep.setCreateId(user.getLoginId());
		depMapper.insert(dep);
		return new ResultObject();
	}

	@Override
	public Object updateDep(KeyproDep dep) {
		dep.setDelflag(Constants.DELFLAG_FALSE);
		depMapper.updateByPrimaryKey(dep);
		return new ResultObject();
	}

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<KeyproDep> list = depMapper.getDepList();
		// excel标题
		String[] title = { "序号", "单位名称", "单位负责人", "联系方式", 
				"单位地址", "工作内容","联系人","联系人电话","经度","纬度" };
		// excel文件名
		String fileName = "部门表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "部门信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			KeyproDep dep = list.get(i);
			// content[i] = new String[title.length];
			content[i][0] = String.valueOf(i + 1);
			content[i][1] = dep.getDepName();
			content[i][2] = dep.getDepLeader();
			content[i][3] = dep.getPhoneNumber();
			content[i][4] = dep.getDepAddress();
			content[i][5] = dep.getWorkContent();
			content[i][6] = dep.getDepLinkman();
			content[i][7] = dep.getLinkmanPhone();
			content[i][8] = dep.getDepX();
			content[i][9] = dep.getDepY();
			/*
			 * SimpleDateFormat df = new
			 * SimpleDateFormat(Constants.DATEFORMATE_LONG); String date =
			 * df.format(dep.getCreateTime()); content[i][6] = date;
			 * content[i][7] = dep.getDelflag(); content[i][8] = dep.getYhzh();
			 * content[i][9] = dep.getCreateId();
			 */
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
	public boolean batchImport(String fileName, MultipartFile file, LoginUserTest user) throws Exception {
		boolean notNull = false;
		List<KeyproDep> depList = new ArrayList<KeyproDep>();
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
		KeyproDep dep;
		// 取出每行的记录
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			dep = new KeyproDep();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String depname = row.getCell(1).getStringCellValue();
			dep.setDepName(depname);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader = row.getCell(2).getStringCellValue();
			dep.setDepLeader(depLeader);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String phoneNumber = row.getCell(3).getStringCellValue();
			dep.setPhoneNumber(phoneNumber);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String depAddress = row.getCell(4).getStringCellValue();
			dep.setDepAddress(depAddress);
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			String workContent = row.getCell(5).getStringCellValue();
			dep.setWorkContent(workContent);
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String depLinkman = row.getCell(6).getStringCellValue();
			dep.setDepLinkman(depLinkman);
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String linkmanPhone = row.getCell(7).getStringCellValue();
			dep.setLinkmanPhone(linkmanPhone);
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String depX = row.getCell(8).getStringCellValue();
			dep.setDepX(depX);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String depY = row.getCell(9).getStringCellValue();
			dep.setDepY(depY);
			dep.setCreateTime(new Date());
			dep.setDelflag(Constants.DELFLAG_FALSE);
			dep.setYhzh(Constants.YHZH_BAOHUA);
			dep.setCreateId(user.getLoginId());
			depList.add(dep);
		}
		// 遍历list的每条记录并新增
		for (KeyproDep keyprodep : depList) {
			depMapper.insert(keyprodep);
		}
		return notNull;
	}

}
