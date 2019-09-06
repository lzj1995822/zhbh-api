package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.*;

import com.jtzh.entity.Cguser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CguserParam;
import com.jtzh.service.CguserService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "城管人员管理")
@RestController
@RequestMapping("Cguser")
public class CguserController {
	@Resource
	private CguserService cguserService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取人员列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCguserList", method = RequestMethod.POST)
	public Object getCguserList(@RequestBody CguserParam param) {
		
		return cguserService.getCguserList(param);
	}

	/**
	 * 获取人员详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCguserInfo/{id}", method = RequestMethod.GET)
	public Object getCguserInfo(@PathVariable("id") String id) {
		return cguserService.getCguserInfo(id);
	}

	/**
	 * 新增人员信息api
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/addCguser", method = RequestMethod.POST)
	public Object addCguser(@RequestBody Cguser cguser,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return cguserService.addCguser(cguser, user);
	}
	
	/**
	 * 删除人员信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCguser/{id}", method = RequestMethod.GET)
	public Object deleteCguser(@PathVariable("id") String id) {
		return cguserService.deleteCguser(id);
	}
	
	/**
	 * 修改人员信息api
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateCguser", method = RequestMethod.POST)
	public Object updateCguser(@RequestBody Cguser param) {
		return cguserService.updateCguser(param);
	}
	@RequestMapping("/importcguser")
	public boolean addUser(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = cguserService.batchImport(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  a;
	}
	public HSSFWorkbook exportAllHis() {
		String[] cellname={"id","name","idcard","sex","nation","borndate","address","phone","job","department","position"};
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet(new Date().getTime()+"report");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;
		HSSFCellStyle stycle = hwb.createCellStyle();
		stycle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		for (int i = 0; i < cellname.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(cellname[i]);
			cell.setCellStyle(stycle);
			sheet.setColumnWidth((short) i, cellname[i].getBytes().length * 250);
		}
		List<Cguser> list = cguserService.find();
		SimpleDateFormat smp=new SimpleDateFormat("yyyy-MM-dd");
		if (list != null) {
			for (int j = 0; j < list.size(); j++) {
				row = sheet.createRow(j + 1);
				row.createCell(0).setCellValue(j+1+"");
				Cguser obj=list.get(j);
				if(obj.getId()!=null){
					row.createCell(0).setCellValue(obj.getId()+"");
				}
				if(obj.getName()!=null){
					row.createCell(1).setCellValue(obj.getName()+"");
				}
				if(obj.getIdcard()!=null){
					row.createCell(2).setCellValue(obj.getIdcard()+"");
				}
				if(obj.getSex()!=null){
					row.createCell(3).setCellValue(obj.getSex()+"");
				}
				if(obj.getNation()!=null){
					row.createCell(4).setCellValue(obj.getNation()+"");
				}
				if(obj.getBorndate()!=null){
					row.createCell(5).setCellValue(obj.getBorndate()+"");
				}
				if(obj.getAddress()!=null){
					row.createCell(6).setCellValue(obj.getAddress()+"");
				}
				if(obj.getPhone()!=null){
					row.createCell(7).setCellValue(obj.getPhone()+"");
				}
				if(obj.getJob()!=null){
					row.createCell(8).setCellValue(obj.getJob()+"");
				}
				if(obj.getDepartment()!=null){
					row.createCell(9).setCellValue(obj.getDepartment()+"");
				}
				if(obj.getPosition()!=null){
					row.createCell(10).setCellValue(obj.getPosition()+"");
				}
			}
		}
		return hwb;
	}
	@RequestMapping("/exportcguser")
	public String exportAll(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		OutputStream out=null;
		String exportFileName = "城管人员";
		try {
			HSSFWorkbook hwb = exportAllHis();
			//response.setContentType("application/x-msdownload");
			response.setContentType("application/vnd.ms-excel");
			//根据浏览器类型处理文件名称
			String agent = request.getHeader("USER-AGENT").toLowerCase();
			if (agent.indexOf("firefox") > -1){//若是火狐
				exportFileName = new String(exportFileName.getBytes("UTF-8"), "ISO8859-1");
			} else {//其他浏览器
				exportFileName = java.net.URLEncoder.encode(exportFileName, "UTF-8");
			}
			response.setHeader("Content-Disposition", "attachment;filename="
					+ exportFileName + ".xls");
			out = response.getOutputStream();
			hwb.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
