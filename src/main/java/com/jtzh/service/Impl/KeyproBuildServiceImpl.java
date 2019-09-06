package com.jtzh.service.Impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.jtzh.common.util.CommonUtil;
import com.jtzh.common.util.ExcelUtil;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.common.util.SetResponseHeaderUtil;
import com.jtzh.detail.pojo.KeyproBuildDetail;
import com.jtzh.entity.KeyproInformation;
import com.jtzh.entity.KeyproPro;
import com.jtzh.entity.KeyproSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoleUser;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.KeyproInformationMapper;
import com.jtzh.mapper.KeyproProMapper;
import com.jtzh.mapper.KeyproSourceMapper;
import com.jtzh.mapper.RoleUserMapper;
import com.jtzh.mapper.UserinformationMapper;
import com.jtzh.pojo.KbuildPagination;
import com.jtzh.pojo.KeyproBuildVo;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.KeyproBuildService;

@Service("buildService")
public class KeyproBuildServiceImpl implements KeyproBuildService {
	@Resource
	private KeyproProMapper proMapper;
	@Resource
	private KeyproSourceMapper sourceMapper;
	@Resource
	private KeyproInformationMapper informationMapper;
	@Resource
	private UserinformationMapper userinformationMapper;
	@Resource
	private RoleUserMapper roleUserMapper;

	@Override
	public Object getKeyproBuildList(KbuildPagination param) {
		List<KeyproPro> list = new ArrayList<KeyproPro>();
		PageResult res = new PageResult();
		int total = proMapper.selectTotal(param);
		if (total > 0) {
			list = proMapper.selectInfo(param);
		}
		res.setOk(true);
		res.setRows(list);
		res.setTotal(total);
		return res;
	}

	@Override
	public Object getKeyproBuildInfo(String id) {
		// Constants.ATTACHSOURCE_WORK即"01"代表重点工程中项目资源在source表中对应的attachsource
		KeyproBuildDetail detail = new KeyproBuildDetail();
		KeyproPro pro = proMapper.selectPro(id);
		detail.setPro(pro);
		detail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_WORK, id));
		// 放入info
		List<KeyproInformation> inf = informationMapper.selectFive(id);
		if (inf != null & inf.size() > 0) {
			detail.setDesignInfo(inf.get(0));
			detail.setSurveyInfo(inf.get(1));
			detail.setBuildInfo(inf.get(2));
			detail.setConstructionInfo(inf.get(3));
			detail.setSupervisorInfo(inf.get(4));
		}

		// detail.setDesignInfo(informationMapper.selectInfo(id));
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	@Override
	public Object removePro(String id) {
		// 删除项目---a).删除项目表记录; b)删除项目对应的资源表记录;c)删除项目表关联的五方信息
		proMapper.deletePro(id);
		List<KeyproSource> list = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_WORK, id);
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<KeyproInformation> inf = informationMapper.selectFive(id);
		if (inf != null & inf.size() > 0) {
			for (KeyproInformation info : inf) {
				informationMapper.deleteInfo(info.getId());
			}
		}

		return new ResultObject();
	}

	@Override
	public Object addPro(KeyproBuildDetail detail, LoginUserTest user) {
		// 1.add项目资源
		KeyproPro pro = detail.getPro();
		// pro.setProNumber("KP" + NumberUtil.getNumber());
		pro.setCreateTime(new Date());
		pro.setDelflag(Constants.DELFLAG_FALSE);
		pro.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		pro.setCreateId(user.getLoginId());
		pro.setYhzh(Constants.YHZH_BAOHUA);
		proMapper.insertPro(pro);
		// 2.add图片资源
		List<KeyproSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
				source.setSourceId(pro.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		// 3.判断是否有五方信息 "0"表示存在，“1”表示没有
		if (Constants.String_DEL_FLG.equals(pro.getHasFiveInformation())) {
			// 设计、勘察、建设、施工、监理
			KeyproInformation designInfo = detail.getDesignInfo();
			KeyproInformation surveyInfo = detail.getSurveyInfo();
			KeyproInformation buildInfo = detail.getBuildInfo();
			KeyproInformation constructionInfo = detail.getConstructionInfo();
			KeyproInformation supervisorInfo = detail.getSupervisorInfo();
			if (null != designInfo) {
				this.addFiveInfo(designInfo, pro, Constants.DESIGN_INFO);
				if (CommonUtil.verifyString(designInfo.getInformationPhoneNumber()))
					this.addFiveUser(designInfo);
			}
			if (null != surveyInfo) {
				this.addFiveInfo(surveyInfo, pro, Constants.SURVEY_INFO);
				if (CommonUtil.verifyString(surveyInfo.getInformationPhoneNumber()))
					this.addFiveUser(surveyInfo);
			}
			if (null != buildInfo) {
				this.addFiveInfo(buildInfo, pro, Constants.BUILD_INFO);
				if (CommonUtil.verifyString(buildInfo.getInformationPhoneNumber()))
					this.addFiveUser(buildInfo);
			}
			if (null != constructionInfo) {
				this.addFiveInfo(constructionInfo, pro, Constants.CONSTRUCTION_INFO);
				if (CommonUtil.verifyString(constructionInfo.getInformationPhoneNumber()))
					this.addFiveUser(constructionInfo);
			}
			if (null != supervisorInfo) {
				this.addFiveInfo(supervisorInfo, pro, Constants.SUPERVISOR_INFO);
				if (CommonUtil.verifyString(supervisorInfo.getInformationPhoneNumber()))
					this.addFiveUser(supervisorInfo);
			}
		}
		return new ResultObject();
	}

	public void addFiveInfo(KeyproInformation info, KeyproPro pro, String infoType) {
		info.setSourceId(pro.getId());
		info.setInformationType(infoType);
		info.setYhzh(Constants.YHZH_BAOHUA);
		info.setDelflag(Constants.DELFLAG_FALSE);
		informationMapper.insertInfo(info);
	}

	@Override
	public Object modifyPro(KeyproBuildDetail detail) {
		KeyproPro pro = detail.getPro();
		pro.setDelflag(Constants.DELFLAG_FALSE);
		pro.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		proMapper.updateByPrimaryKey(pro);
		List<KeyproSource> list = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_WORK, pro.getId());
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<KeyproSource> sourcelist = detail.getSource();
		if (sourcelist != null && sourcelist.size() > 0) {
			for (KeyproSource source : sourcelist) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
				source.setSourceId(pro.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		// 3.判断是否有五方信息 "0"表示存在，“1”表示没有
		if (Constants.String_DEL_FLG.equals(pro.getHasFiveInformation())) {
			// 先删除
			List<KeyproInformation> inf = informationMapper.selectFive(pro.getId());
			if (inf != null & inf.size() > 0) {
				for (KeyproInformation info : inf) {
					informationMapper.deleteInfo(info.getId());
				}
			}
			// 再新建
			// 设计、勘察、建设、施工、监理
			KeyproInformation designInfo = detail.getDesignInfo();
			KeyproInformation surveyInfo = detail.getSurveyInfo();
			KeyproInformation buildInfo = detail.getBuildInfo();
			KeyproInformation constructionInfo = detail.getConstructionInfo();
			KeyproInformation supervisorInfo = detail.getSupervisorInfo();
			if (null != designInfo) {
				designInfo.setSourceId(pro.getId());
				designInfo.setInformationType(Constants.DESIGN_INFO);
				designInfo.setYhzh(Constants.YHZH_BAOHUA);
				designInfo.setDelflag(Constants.DELFLAG_FALSE);
				informationMapper.insertInfo(designInfo);
				if (CommonUtil.verifyString(designInfo.getInformationPhoneNumber()))
					this.addFiveUser(designInfo);
			}
			if (null != surveyInfo) {
				surveyInfo.setSourceId(pro.getId());
				surveyInfo.setInformationType(Constants.SURVEY_INFO);
				surveyInfo.setYhzh(Constants.YHZH_BAOHUA);
				surveyInfo.setDelflag(Constants.DELFLAG_FALSE);
				informationMapper.insertInfo(surveyInfo);
				if (CommonUtil.verifyString(surveyInfo.getInformationPhoneNumber()))
					this.addFiveUser(surveyInfo);
			}
			if (null != buildInfo) {
				buildInfo.setSourceId(pro.getId());
				buildInfo.setInformationType(Constants.BUILD_INFO);
				buildInfo.setYhzh(Constants.YHZH_BAOHUA);
				buildInfo.setDelflag(Constants.DELFLAG_FALSE);
				informationMapper.insertInfo(buildInfo);
				if (CommonUtil.verifyString(buildInfo.getInformationPhoneNumber()))
					this.addFiveUser(buildInfo);
			}
			if (null != constructionInfo) {
				constructionInfo.setSourceId(pro.getId());
				constructionInfo.setInformationType(Constants.CONSTRUCTION_INFO);
				constructionInfo.setYhzh(Constants.YHZH_BAOHUA);
				constructionInfo.setDelflag(Constants.DELFLAG_FALSE);
				informationMapper.insertInfo(constructionInfo);
				if (CommonUtil.verifyString(constructionInfo.getInformationPhoneNumber()))
					this.addFiveUser(constructionInfo);
			}
			if (null != supervisorInfo) {
				supervisorInfo.setSourceId(pro.getId());
				supervisorInfo.setInformationType(Constants.SUPERVISOR_INFO);
				supervisorInfo.setYhzh(Constants.YHZH_BAOHUA);
				supervisorInfo.setDelflag(Constants.DELFLAG_FALSE);
				informationMapper.insertInfo(supervisorInfo);
				if (CommonUtil.verifyString(supervisorInfo.getInformationPhoneNumber()))
					this.addFiveUser(supervisorInfo);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<KeyproPro> list = proMapper.getProList();
		// excel标题
		String[] title = { "序号", "项目名称", "建设地点", "建设规模", "总投资", "开工日期", "竣工日期", "工期", "五方信息", "经度", "纬度", "设计方单位名称",
				"设计现场负责人", "设计联系方式", "勘察方单位名称", "勘察现场负责人", "勘察联系方式", "建设方单位名称", "建设现场负责人", "建设联系方式", "施工方单位名称",
				"施工现场负责人", "施工联系方式", "监理方单位名称", "监理现场负责人", "监理联系方式" };
		// excel文件名
		String fileName = "项目表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "项目信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			KeyproPro pro = list.get(i);
			// content[i] = new String[title.length];
			content[i][0] = String.valueOf(i + 1);
			content[i][1] = pro.getKeyproProName();
			content[i][2] = pro.getKeyproBuildSpace();
			content[i][3] = pro.getKeyproBuildScale();
			if (null != pro.getKeyproProInvestment()) {
				content[i][4] = pro.getKeyproProInvestment().toString();
			}
			SimpleDateFormat df = new SimpleDateFormat(Constants.DATEFORMATE_SIMPLE);
			if (null != pro.getCreateTime()) {
				String date1 = df.format(pro.getCreateTime());
				content[i][5] = date1;
			}
			if (null != pro.getKeyproProFinishTime()) {
				String date2 = df.format(pro.getKeyproProFinishTime());
				content[i][6] = date2;
			}
			content[i][7] = pro.getKeyproProOverdueTime();
			content[i][8] = pro.getHasFiveInformation();
			content[i][9] = pro.getKeyproProX();
			content[i][10] = pro.getKeyproProY();
			// content[i][11] = pro.getYhzh();
			// content[i][12] = pro.getCreateId();
			// content[i][13] = pro.getDelflag();
			// 下面开始五方信息
			List<KeyproInformation> inf = informationMapper.selectFive(pro.getId());
			if (inf != null & inf.size() > 0) {
				// 五方信息：设计、勘察、建设、施工、监理
				content[i][11] = inf.get(0).getInformationCompanyName();
				content[i][12] = inf.get(0).getInformationSiteLeader();
				content[i][13] = inf.get(0).getInformationPhoneNumber();
				content[i][14] = inf.get(1).getInformationCompanyName();
				content[i][15] = inf.get(1).getInformationSiteLeader();
				content[i][16] = inf.get(1).getInformationPhoneNumber();
				content[i][17] = inf.get(2).getInformationCompanyName();
				content[i][18] = inf.get(2).getInformationSiteLeader();
				content[i][19] = inf.get(2).getInformationPhoneNumber();
				content[i][20] = inf.get(3).getInformationCompanyName();
				content[i][21] = inf.get(3).getInformationSiteLeader();
				content[i][22] = inf.get(3).getInformationPhoneNumber();
				content[i][23] = inf.get(4).getInformationCompanyName();
				content[i][24] = inf.get(4).getInformationSiteLeader();
				content[i][25] = inf.get(4).getInformationPhoneNumber();
			}
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
		List<KeyproPro> proList = new ArrayList<KeyproPro>();
		List<KeyproInformation> inf1 = new ArrayList<KeyproInformation>();
		List<KeyproInformation> inf2 = new ArrayList<KeyproInformation>();
		List<KeyproInformation> inf3 = new ArrayList<KeyproInformation>();
		List<KeyproInformation> inf4 = new ArrayList<KeyproInformation>();
		List<KeyproInformation> inf5 = new ArrayList<KeyproInformation>();
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
		KeyproPro pro;
		KeyproInformation proInf1;
		KeyproInformation proInf2;
		KeyproInformation proInf3;
		KeyproInformation proInf4;
		KeyproInformation proInf5;
		// 取出每行的记录
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			pro = new KeyproPro();
			proInf1 = new KeyproInformation();
			proInf2 = new KeyproInformation();
			proInf3 = new KeyproInformation();
			proInf4 = new KeyproInformation();
			proInf5 = new KeyproInformation();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String proname = row.getCell(1).getStringCellValue();
			pro.setKeyproProName(proname);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String space = row.getCell(2).getStringCellValue();
			pro.setKeyproBuildSpace(space);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String scale = row.getCell(3).getStringCellValue();
			pro.setKeyproBuildScale(scale);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String keyproProInvestment = row.getCell(4).getStringCellValue();
			if (CommonUtil.verifyString(keyproProInvestment)) {
				pro.setKeyproProInvestment(Double.valueOf(keyproProInvestment));
			}
			String createTime = ExcelUtil.importByExcelForDate(row.getCell(5));
			// row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			// String createTime = row.getCell(5).getStringCellValue();
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATEFORMATE_SIMPLE);
			if (CommonUtil.verifyString(createTime)) {
				Date date = null;
				try {
					date = format.parse(createTime); // Thu Jan 18 00:00:00 CST
														// 2007
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pro.setCreateTime(date);
			}
			String endTime = ExcelUtil.importByExcelForDate(row.getCell(6));
			// row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			// String endTime = row.getCell(6).getStringCellValue();
			if (CommonUtil.verifyString(endTime)) {
				Date date2 = null;
				try {
					date2 = format.parse(endTime); // Thu Jan 18 00:00:00 CST
													// 2007
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pro.setKeyproProFinishTime(date2);
			}
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String dueTime = row.getCell(7).getStringCellValue();
			pro.setKeyproProOverdueTime(dueTime);
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String hasFive = row.getCell(8).getStringCellValue();
			pro.setHasFiveInformation(hasFive);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String x = row.getCell(9).getStringCellValue();
			pro.setKeyproProX(x);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String y = row.getCell(10).getStringCellValue();
			pro.setKeyproProY(y);
			pro.setYhzh(Constants.YHZH_BAOHUA);
			pro.setCreateId(user.getLoginId());
			pro.setDelflag(Constants.DELFLAG_FALSE);
			proList.add(pro);
			// 五方信息
			// 1)
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			String depName1 = row.getCell(11).getStringCellValue();
			proInf1.setInformationCompanyName(depName1);
			row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader1 = row.getCell(12).getStringCellValue();
			proInf1.setInformationSiteLeader(depLeader1);
			row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
			String infNumber1 = row.getCell(13).getStringCellValue();
			proInf1.setInformationPhoneNumber(infNumber1);
			inf1.add(proInf1);
			// 2)
			row.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
			String depName2 = row.getCell(14).getStringCellValue();
			proInf2.setInformationCompanyName(depName2);
			row.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader2 = row.getCell(15).getStringCellValue();
			proInf2.setInformationSiteLeader(depLeader2);
			row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
			String infNumber2 = row.getCell(16).getStringCellValue();
			proInf2.setInformationPhoneNumber(infNumber2);
			inf2.add(proInf2);
			// 3)
			row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
			String depName3 = row.getCell(17).getStringCellValue();
			proInf3.setInformationCompanyName(depName3);
			row.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader3 = row.getCell(18).getStringCellValue();
			proInf3.setInformationSiteLeader(depLeader3);
			row.getCell(19).setCellType(Cell.CELL_TYPE_STRING);
			String infNumber3 = row.getCell(19).getStringCellValue();
			proInf3.setInformationPhoneNumber(infNumber3);
			inf3.add(proInf3);
			// 4)
			row.getCell(20).setCellType(Cell.CELL_TYPE_STRING);
			String depName4 = row.getCell(20).getStringCellValue();
			proInf4.setInformationCompanyName(depName4);
			row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader4 = row.getCell(21).getStringCellValue();
			proInf4.setInformationSiteLeader(depLeader4);
			row.getCell(22).setCellType(Cell.CELL_TYPE_STRING);
			String infNumber4 = row.getCell(22).getStringCellValue();
			proInf4.setInformationPhoneNumber(infNumber4);
			inf4.add(proInf4);
			// 5)
			row.getCell(23).setCellType(Cell.CELL_TYPE_STRING);
			String depName5 = row.getCell(23).getStringCellValue();
			proInf5.setInformationCompanyName(depName5);
			row.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
			String depLeader5 = row.getCell(24).getStringCellValue();
			proInf5.setInformationSiteLeader(depLeader5);
			row.getCell(25).setCellType(Cell.CELL_TYPE_STRING);
			String infNumber5 = row.getCell(25).getStringCellValue();
			proInf5.setInformationPhoneNumber(infNumber5);
			inf5.add(proInf5);
		}
		for (int i = 0; i < proList.size(); i++) {
			KeyproPro keypro = proList.get(i);
			KeyproInformation keyInf1 = inf1.get(i);
			KeyproInformation keyInf2 = inf2.get(i);
			KeyproInformation keyInf3 = inf3.get(i);
			KeyproInformation keyInf4 = inf4.get(i);
			KeyproInformation keyInf5 = inf5.get(i);
			proMapper.insertPro(keypro);
			keyInf1.setSourceId(keypro.getId());
			keyInf1.setInformationType(Constants.DESIGN_INFO);
			keyInf1.setYhzh(Constants.YHZH_BAOHUA);
			keyInf1.setDelflag(Constants.DELFLAG_FALSE);
			keyInf2.setSourceId(keypro.getId());
			keyInf2.setInformationType(Constants.SURVEY_INFO);
			keyInf2.setYhzh(Constants.YHZH_BAOHUA);
			keyInf2.setDelflag(Constants.DELFLAG_FALSE);
			keyInf3.setSourceId(keypro.getId());
			keyInf3.setInformationType(Constants.BUILD_INFO);
			keyInf3.setYhzh(Constants.YHZH_BAOHUA);
			keyInf3.setDelflag(Constants.DELFLAG_FALSE);
			keyInf4.setSourceId(keypro.getId());
			keyInf4.setInformationType(Constants.CONSTRUCTION_INFO);
			keyInf4.setYhzh(Constants.YHZH_BAOHUA);
			keyInf4.setDelflag(Constants.DELFLAG_FALSE);
			keyInf5.setSourceId(keypro.getId());
			keyInf5.setInformationType(Constants.SUPERVISOR_INFO);
			keyInf5.setYhzh(Constants.YHZH_BAOHUA);
			keyInf5.setDelflag(Constants.DELFLAG_FALSE);
			informationMapper.insertInfo(keyInf1);
			informationMapper.insertInfo(keyInf2);
			informationMapper.insertInfo(keyInf3);
			informationMapper.insertInfo(keyInf4);
			informationMapper.insertInfo(keyInf5);
		}
		return notNull;
	}

	@Override
	public Object getKeyProjectCoordinate() {
		List<KeyproPro> keyCoordinateRes = proMapper.getKeyProjectCoordinate();
		// 遍历工程信息加入五方信息及对应的图片资源
		List<KeyproBuildDetail> details = new ArrayList<>();
		for (KeyproPro pro : keyCoordinateRes) {
			KeyproBuildDetail detail = new KeyproBuildDetail();
			detail.setPro(pro);
			detail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_WORK, pro.getId()));
			// 放入info
			List<KeyproInformation> inf = informationMapper.selectFive(pro.getId());
			if (inf != null & inf.size() > 0) {
				detail.setDesignInfo(inf.get(0));
				detail.setSurveyInfo(inf.get(1));
				detail.setBuildInfo(inf.get(2));
				detail.setConstructionInfo(inf.get(3));
				detail.setSupervisorInfo(inf.get(4));
			}
			details.add(detail);
		}
		ResultObject res = new ResultObject();
		res.setObj(details);
		return res;
	}

	public void addFiveUser(KeyproInformation info) {
		Userinformation fiveUser = new Userinformation();
		RoleUser fiveRole = new RoleUser();
		fiveUser.setUiloginname(info.getInformationPhoneNumber());
		fiveUser.setUicode(info.getInformationPhoneNumber().length() == 11
				? NumberUtil.getPwdByPhone(info.getInformationPhoneNumber()) : Constants.DEFAULT_USER_PASSWORD);
		fiveUser.setCreateon(new Date());
		fiveUser.setUirealname(info.getInformationSiteLeader());
		fiveUser.setUisubordinatedepartment("重点工程");
		int num = userinformationMapper.getCountByLoginId(fiveUser.getUiloginname());
		if (num < 1) {
			userinformationMapper.insertUserReturnId(fiveUser);
			fiveRole.setPcrole(Constants.KEY_PRO_ROLE);
			fiveRole.setPcuser(fiveUser.getId());
			roleUserMapper.insertSelective(fiveRole);
		}
	}

	@Override
	public Object getProNameAndId() {
		List<KeyproBuildVo> keyproBuildVo = proMapper.getProNameAndId();
		ResultObject res = new ResultObject();
		res.setObj(keyproBuildVo);
		return res;
	}

	@Override
	public Object countProAllCountryside() {
		ResultObject res = new ResultObject();
		res.setObj(proMapper.countProAllCountryside());
		return res;
	}

}
