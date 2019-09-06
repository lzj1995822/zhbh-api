package com.jtzh.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.Hwuser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.HwuserMapper;
import com.jtzh.pojo.HwuserParam;
import com.jtzh.pojo.PageResult;
import org.springframework.web.multipart.MultipartFile;

@Service("hwuserService")
public class HwuserServiceImpl implements HwuserService {
	@Resource
	private HwuserMapper hwuserMapper;
	
	// 查询
		@Override
		public Object getHwuserList(HwuserParam param) {
			// 查询总数
			int total = hwuserMapper.selectHwuTotal(param);
			List<Hwuser> list = new ArrayList<Hwuser>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = hwuserMapper.selectInfo(param);
			}
			res.setRows(list);
			return res;
		}
				
		// 查询详情
		@Override
		public Hwuser getHwuserInfo(String id) {
			// 根据id去查询通知公告信息
			Hwuser hwuser = hwuserMapper.getHwuserInfo(id);
			return hwuser;
		}
				
		// 新建
		@Override
		public Object addHwuser(Hwuser hwuser, LoginUserTest user) {
			hwuser.setPassword("123456");
			hwuser.setYhzh(Constants.YHZH_BAOHUA);
			hwuser.setCreateId(user.getLoginId());
			hwuser.setCreateTime(new Date());
			hwuser.setDelflag("A");
			hwuserMapper.addHwuser(hwuser);
			return new ResultObject();
		}
				
		// 删除
		@Override
		public Object deleteHwuser(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			hwuserMapper.deleteHwuser(id);
			return new ResultObject();
		}
			
		// 修改
		@Override
		public Object updateHwuser(Hwuser param) {
			hwuserMapper.updateHwuser(param);
			return new ResultObject();
		}
	public boolean batchImport(String fileName, MultipartFile file) throws Exception {


		boolean notNull = false;
		List<Hwuser> hwuserList = new ArrayList<Hwuser>();
		if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {

		}
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if(sheet!=null){
			notNull = true;
		}
		Hwuser hwuser;
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null){
				continue;
			}

			hwuser = new Hwuser();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String name = row.getCell(1).getStringCellValue();
			hwuser.setName(name);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String idcard = row.getCell(2).getStringCellValue();
			hwuser.setIdcard(idcard);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String sex = row.getCell(3).getStringCellValue();
			hwuser.setSex(sex);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String nation = row.getCell(4).getStringCellValue();
			hwuser.setNation(nation);
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			String borndate = row.getCell(5).getStringCellValue();
			hwuser.setBorndate(borndate);
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String phone = row.getCell(6).getStringCellValue();
			hwuser.setPhone(phone);
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String address = row.getCell(7).getStringCellValue();
			hwuser.setAddress(address);

			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String dizhi = row.getCell(8).getStringCellValue();
			hwuser.setDizhi(dizhi);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String department = row.getCell(9).getStringCellValue();
			hwuser.setDepartment(department);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String position = row.getCell(10).getStringCellValue();
			hwuser.setPosition(position);

			hwuserList.add(hwuser);

			for (Hwuser cguser1 : hwuserList) {

				String idcard1=cguser1.getIdcard();
				Hwuser cut=hwuserMapper.findbyidcard(idcard1);
				if(cut==null){
					cguser1.setDelflag("A");
					hwuserMapper.addHwuser(cguser1);
				}
			}
		}
		return notNull;
	}
	public List<Hwuser> find(){
			return hwuserMapper.find();
	}

}
