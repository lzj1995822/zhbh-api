package com.jtzh.service.Impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;
import com.jtzh.common.util.ExcelUtil;
import com.jtzh.entity.NonPublicEconomyOrg;
import com.jtzh.entity.PioneerLddy;
import com.jtzh.entity.PioneerUser;
import com.jtzh.entity.PworkUser;
import com.jtzh.entity.Vil;
import com.jtzh.mapper.NonPublicEconomyOrgMapper;
import com.jtzh.mapper.PioneerLddyMapper;
import com.jtzh.mapper.PioneerUserMapper;
import com.jtzh.mapper.VilMapper;
import com.jtzh.service.VilService;

@Service("vilService")
public class VilServiceImpl implements VilService {
	@Resource
	private VilMapper vilMapper;
	@Resource
	private PioneerLddyMapper pioneerLddyMapper;
	@Resource
	private PioneerUserMapper pioneeruserMapper;
	@Resource
	private NonPublicEconomyOrgMapper nonPublicEconomyOrgMapper;

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<Vil> list = vilMapper.getVilList();
		// excel标题
		String[] title = { "省", "市", "县/区", "乡/街道", "村/社区", "网格", "街/路/巷", "路号/门牌号", "楼栋类型", "是否地上" };
		// excel文件名
		String fileName = "用户表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "用户信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			Vil user = list.get(i);
			content[i][0] = user.getVilProvince();
			content[i][1] = user.getVilCity();
			content[i][2] = user.getVilArea();
			content[i][3] = user.getVilRoad();
			content[i][4] = user.getVilCommunity();
			content[i][5] = user.getVilGreed();
			content[i][6] = user.getVilRoad();
			content[i][7] = user.getVilDoorNumber();
			content[i][8] = user.getVilFloor();
			content[i][9] = user.getVilGround();
		}
		// 创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		// 响应到客户端
		try {
			this.setResponseHeader(response, fileName);
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
		List<Vil> pworkUserList = new ArrayList<Vil>();
		// 判断是xls(03)或者xlsx(07)
		boolean isExcel2003 = true;
		/*
		 * if (!fileName.matches("^.+\\.(?i)(xls)$") &&
		 * !fileName.matches("^.+\\.(?i)(xlsx)$")) { }
		 */
		/*
		 * if (fileName.matches("^.+\\.(?i)(xlsx)$")) { isExcel2003 = false; }
		 */
		if (fileName.matches("^.+\\.(?i)(xls)$")) {// 2003
			isExcel2003 = true;
		}
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {// 2007
			isExcel2003 = false;
		}
		// is流用于接受excel文件流
		InputStream is = file.getInputStream();
		Workbook wb = null;
		// 根据03或者07版本去创建对应的workbook
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		}

		else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}
		Vil pworkUser;
		// 取出每行的记录
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			pworkUser = new Vil();
			String pro = "江苏省";
			String city = "镇江市";
			String com = "句容市";
			String street = "开发区管委会";
			pworkUser.setVilProvince(pro);
			pworkUser.setVilCity(city);
			pworkUser.setVilCommunity(com);
			pworkUser.setVilStreet(street);
			pworkUser.setVilFloor("住宅");
			pworkUser.setVilGround("是");
			// pworkUser.get
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String c1 = row.getCell(1).getStringCellValue();
			char[] cc;
			cc = c1.toCharArray();
			c1 = c1.trim();
			String c11 = "";
			if (c1 != null && !"".equals(c1)) {
				for (int i = 0; i < c1.length(); i++) {
					if (c1.charAt(i) >= 48 && c1.charAt(i) <= 57) {
						c11 += c1.charAt(i);
					}
				}
			}
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String c3 = row.getCell(3).getStringCellValue();
			pworkUser.setVilRoad(c3);
			char[] bb;
			bb = c3.toCharArray();
			c3 = c3.trim();
			String c33 = "";
			if (c1 != null && !"".equals(c1)) {
				for (int i = 0; i < c1.length(); i++) {
					if (c1.charAt(i) >= 48 && c1.charAt(i) <= 57) {
						c33 += c33.charAt(i);
					}
				}
			}
			pworkUser.setVilGreed("" + c11);
			String hao;
			for (char a : cc) {
				if ("号".equals(a)) {
					c33 += "号";
				}
				if ("牌".equals(a)) {
					c33 += "牌";
				}
			}
			pworkUser.setVilGround("是");
			pworkUser.setDelflag("A");
			// pworkUser.setPassword(Constants.DEFAULT_USER_PASSWORD);
			pworkUserList.add(pworkUser);
		}
		// 遍历list的每条记录并新增
		for (Vil user : pworkUserList) {
			vilMapper.insert(user);
		}
		return notNull;
	}

	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean batchImportLddy(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<PioneerLddy> pioneerLddys = new ArrayList<PioneerLddy>();
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xls)$")) {
			isExcel2003 = true;
		}
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		// 根据03或者07版本去创建对应的workbook
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}
		PioneerLddy pioneerLddy;
		System.out.println(sheet.getLastRowNum());
		// Row row1 = sheet.getRow(0);
		// Row row2 = sheet.getRow(1);
		// 取出每行的记录
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			pioneerLddy = new PioneerLddy();
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String name = row.getCell(0).getStringCellValue();
			pioneerLddy.setXm(name);
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String livingHouse = row.getCell(1).getStringCellValue();
			pioneerLddy.setJzxq(livingHouse);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String phone = row.getCell(2).getStringCellValue();
			pioneerLddy.setLxdh(phone);
			pioneerLddy.setCreateTime(new Date());
			pioneerLddy.setDelflag(Constants.DELFLAG_FALSE);
			pioneerLddys.add(pioneerLddy);
		}
		// 遍历list的每条记录并新增
		for (PioneerLddy record : pioneerLddys) {
			pioneerLddyMapper.insert(record);
		}
		return notNull;
	}

	@Override
	public boolean batchImportDy(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<PioneerUser> pioneerUsers = new ArrayList<PioneerUser>();
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xls)$")) {
			isExcel2003 = true;
		}
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		// 根据03或者07版本去创建对应的workbook
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}
		PioneerUser pioneerUser;
		System.out.println(sheet.getLastRowNum());
		// 取出每行的记录
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			pioneerUser = new PioneerUser();
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String name = row.getCell(0).getStringCellValue();
			pioneerUser.setUserName(name);
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String identity = row.getCell(1).getStringCellValue();
			pioneerUser.setIdentityNumber(identity);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String sex = row.getCell(2).getStringCellValue();
			pioneerUser.setUserSex(sex);
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String userNation = row.getCell(3).getStringCellValue();
			pioneerUser.setUserNation(userNation);
			// System.out.println(row.getCell(4).getDateCellValue()+"123-----");
			// if (HSSFDateUtil.isCellDateFormatted(row.getCell(4))) {
			// Date birthDate = row.getCell(4).getDateCellValue();
			// pioneerUser.setBirthDate(birthDate);
			// }
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String birthDateString = row.getCell(4).getStringCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = sdf.parse(birthDateString);
			pioneerUser.setBirthDate(birthDate);
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			String academicQualification = row.getCell(5).getStringCellValue();
			pioneerUser.setAcademicQualification(academicQualification);
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String userClass = row.getCell(6).getStringCellValue();
			pioneerUser.setUserClass(userClass);
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String partyOrg = row.getCell(7).getStringCellValue();
			pioneerUser.setPartyOrg(partyOrg);
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String joinPartyTimeString = row.getCell(8).getStringCellValue();
			Date joinPartyTime = sdf.parse(joinPartyTimeString);
			pioneerUser.setBirthDate(birthDate);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String fullMemberTimeString = row.getCell(9).getStringCellValue();
			Date fullMemberTime = sdf.parse(fullMemberTimeString);
			pioneerUser.setFullMemberTime(fullMemberTime);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String userJob = row.getCell(10).getStringCellValue();
			pioneerUser.setUserJob(userJob);
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			String userAddress = row.getCell(11).getStringCellValue();
			pioneerUser.setUserAddress(userAddress);
			row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
			String phoneNumber = row.getCell(12).getStringCellValue();
			pioneerUser.setPhoneNumber(phoneNumber);
			row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
			String fixedTelephone = row.getCell(13).getStringCellValue();
			pioneerUser.setFixedTelephone(fixedTelephone);
			pioneerUser.setCreateTime(new Date());
			pioneerUser.setDelflag(Constants.DELFLAG_FALSE);
			pioneerUser.setYhzh(Constants.YHZH_BAOHUA);
			pioneerUsers.add(pioneerUser);
		}
		// 遍历list的每条记录并新增
		for (PioneerUser user : pioneerUsers) {
			pioneeruserMapper.insert(user);
		}
		return notNull;
	}

	@Override
	public boolean batchImportQYGL(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<NonPublicEconomyOrg> orgs = new ArrayList<NonPublicEconomyOrg>();
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xls)$")) {
			isExcel2003 = true;
		}
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		// 根据03或者07版本去创建对应的workbook
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}
		NonPublicEconomyOrg org;
		System.out.println(sheet.getLastRowNum());
		// 取出每行的记录
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			org = new NonPublicEconomyOrg();
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String unitCode = row.getCell(0).getStringCellValue();
			org.setEnterpriseUSCcode(unitCode);
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseName = row.getCell(1).getStringCellValue();
			org.setEnterpriseName(enterpriseName);
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseTypeValue = row.getCell(2).getStringCellValue();
			org.setEnterpriseTypeValue(enterpriseTypeValue);
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseAddress = row.getCell(4).getStringCellValue();
			org.setEnterpriseAddress(enterpriseAddress);
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			String peopleAndPhone = row.getCell(5).getStringCellValue();
			String enterprisePhone = CommonUtil.getNumberFromStr(peopleAndPhone);
			//String enterpriseContact = CommonUtil.getStrFromStr(peopleAndPhone);
			org.setEnterpriseContact(enterprisePhone);
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseMemberNumber = row.getCell(6).getStringCellValue();
			org.setEnterpriseMemberNumber(Integer.valueOf(enterpriseMemberNumber));
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseLeaderCertTypeValue = row.getCell(7).getStringCellValue();
			org.setEnterpriseLeaderCertTypeValue(enterpriseLeaderCertTypeValue);
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseLeaderCertID = row.getCell(8).getStringCellValue();
			org.setEnterpriseLeaderCertID(enterpriseLeaderCertID);
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseLeaderName = row.getCell(9).getStringCellValue();
			org.setEnterpriseLeaderName(enterpriseLeaderName);
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			String enterpriseLeaderContact = row.getCell(10).getStringCellValue();
			org.setEnterpriseLeaderContact(enterpriseLeaderContact);
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			String securityLeaderName = row.getCell(11).getStringCellValue();
			org.setSecurityLeaderName(securityLeaderName);
			row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
			String securityLeaderContact = row.getCell(12).getStringCellValue();
			org.setSecurityLeaderContact(securityLeaderContact);
			row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
			String isDangeriousEnterprise = row.getCell(13).getStringCellValue();
			org.setIsDangeriousEnterprise(Integer.valueOf(isDangeriousEnterprise));
			row.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
			String hiddenDangerTypeValue = row.getCell(14).getStringCellValue();
			org.setHiddenDangerTypeValue(hiddenDangerTypeValue);
			row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
			String attentionTypeValue = row.getCell(16).getStringCellValue();
			org.setAttentionTypeValue(attentionTypeValue);
			row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
			String isCanConstructCPC = row.getCell(17).getStringCellValue();
			if(CommonUtil.verifyString(isCanConstructCPC))
			org.setIsCanConstructCPC(isCanConstructCPC.equals(Constants.HAS_UNION_YES)?1:0);
			row.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
			String numberofCPCMember = row.getCell(18).getStringCellValue();
			org.setNumberofCPCMember(Integer.valueOf(numberofCPCMember));
			row.getCell(19).setCellType(Cell.CELL_TYPE_STRING);
			String hasLabourUnion = row.getCell(19).getStringCellValue();
			if(CommonUtil.verifyString(hasLabourUnion))
			org.setNumberofCPCMember(hasLabourUnion.equals(Constants.HAS_UNION_YES)?1:0);
			row.getCell(20).setCellType(Cell.CELL_TYPE_STRING);
			String numberofLUMember = row.getCell(20).getStringCellValue();
			if(CommonUtil.verifyString(numberofLUMember))
			org.setNumberofLUMember(Integer.valueOf(numberofLUMember));
			row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
			String numberofLCYLMember = row.getCell(21).getStringCellValue();
			if(CommonUtil.verifyString(numberofLCYLMember))
			org.setNumberofLCYLMember(Integer.valueOf(numberofLUMember));
			row.getCell(22).setCellType(Cell.CELL_TYPE_STRING);
			String hasWomenFederation = row.getCell(22).getStringCellValue();
			if(CommonUtil.verifyString(hasWomenFederation))
			org.setHasWomenFederation(hasWomenFederation.equals(Constants.HAS_UNION_YES)?1:0);
			row.getCell(23).setCellType(Cell.CELL_TYPE_STRING);
			String numberofWomen = row.getCell(23).getStringCellValue();
			if(CommonUtil.verifyString(numberofWomen))
			org.setNumberofWomen(Integer.valueOf(numberofWomen));
			row.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
			String longitude = row.getCell(24).getStringCellValue();
			if(CommonUtil.verifyString(longitude))
			org.setLongitude(Double.valueOf(longitude));
			row.getCell(25).setCellType(Cell.CELL_TYPE_STRING);
			String Latitude = row.getCell(25).getStringCellValue();
			if(CommonUtil.verifyString(Latitude))
			org.setLongitude(Double.valueOf(Latitude));
			row.getCell(26).setCellType(Cell.CELL_TYPE_STRING);
			String netGridID = row.getCell(26).getStringCellValue();
			if(CommonUtil.verifyString(netGridID))
			org.setNetGridID(Long.valueOf(netGridID));
			row.getCell(27).setCellType(Cell.CELL_TYPE_STRING);
			String isLogisticsEnterprise = row.getCell(27).getStringCellValue();
			if(CommonUtil.verifyString(isLogisticsEnterprise))
			org.setIsLogisticsEnterprise(Integer.valueOf(isLogisticsEnterprise));
			row.getCell(28).setCellType(Cell.CELL_TYPE_STRING);
			String isKeyEnterprise = row.getCell(28).getStringCellValue();
			if(CommonUtil.verifyString(isKeyEnterprise))
			org.setIsKeyEnterprise(Integer.valueOf(isKeyEnterprise));
			row.getCell(29).setCellType(Cell.CELL_TYPE_STRING);
			String businessScope = row.getCell(29).getStringCellValue();
			org.setBusinessScope(businessScope);
			orgs.add(org);
		}
		for (NonPublicEconomyOrg param : orgs) {
			nonPublicEconomyOrgMapper.insert(param);
		}
		return notNull;
	}

}
