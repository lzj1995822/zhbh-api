package com.jtzh.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
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
import com.jtzh.entity.Cguser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CguserMapper;
import com.jtzh.pojo.CguserParam;
import com.jtzh.pojo.PageResult;
import org.springframework.web.multipart.MultipartFile;

@Service("cguserService")
public class CguserServiceImpl implements CguserService{
	@Resource
	private CguserMapper cguserMapper;
	
	// 查询
	@Override
	public Object getCguserList(CguserParam param) {
		// 查询总数
		int total = cguserMapper.selectCguTotal(param);
		List<Cguser> list = new ArrayList<Cguser>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = cguserMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
			
	// 查询详情
	@Override
	public Cguser getCguserInfo(String id) {
		// 根据id去查询通知公告信息
		Cguser cguser = cguserMapper.getCguserInfo(id);
		return cguser;
	}
			
	// 新建
	@Override
	public Object addCguser(Cguser cguser, LoginUserTest user) {
		cguser.setPassword("123456");
		cguser.setYhzh(Constants.YHZH_BAOHUA);
		cguser.setCreateId(user.getLoginId());
		cguser.setCreateTime(new Date());
		cguser.setDelflag("A");
		cguserMapper.addCguser(cguser);
		return new ResultObject();
	}
			
	// 删除
	@Override
	public Object deleteCguser(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		cguserMapper.deleteCguser(id);
		return new ResultObject();
	}
		
	// 修改
	@Override
	public Object updateCguser(Cguser param) {
		cguserMapper.updateCguser(param);
		return new ResultObject();
	}
	public boolean batchImport(String fileName, MultipartFile file) throws Exception {


		boolean notNull = false;
		List<Cguser> cguserList = new ArrayList<Cguser>();
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
		Cguser cguser;
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null){
				continue;
			}

			cguser = new Cguser();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String name = row.getCell(1).getStringCellValue();
			cguser.setName(name);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String idcard = row.getCell(2).getStringCellValue();
			cguser.setIdcard(idcard);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String sex = row.getCell(3).getStringCellValue();
			cguser.setSex(sex);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String nation = row.getCell(4).getStringCellValue();
			cguser.setNation(nation);
			Date borndate;
			if(row.getCell(5).getCellType() !=0){
				System.out.println("日期格式不对");
			}else{
				borndate = row.getCell(5).getDateCellValue();
			}

			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String address = row.getCell(6).getStringCellValue();
			cguser.setAddress(address);
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String phone = row.getCell(7).getStringCellValue();
			cguser.setPhone(phone);
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String job = row.getCell(8).getStringCellValue();
			cguser.setJob(job);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String department = row.getCell(9).getStringCellValue();
			cguser.setDepartment(department);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String position = row.getCell(10).getStringCellValue();
			cguser.setPosition(position);

			cguserList.add(cguser);

			for (Cguser cguser1 : cguserList) {

				String idcard1=cguser1.getIdcard();
				Cguser cut=cguserMapper.findbyidcard(idcard1);
				if(cut==null){
					cguser1.setDelflag("A");
					cguserMapper.addCguser(cguser1);
				}
			}
		}
		return notNull;
	}
	public List<Cguser> find(){
		return cguserMapper.find();
	}
}
