package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.service.VilService;

@RestController
@RequestMapping("vil")
public class VilController {
	@Resource
	private VilService vilService;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		vilService.exportExcel(response);
		return null;
	}

	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public boolean addUser(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = vilService.batchImport(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@RequestMapping(value = "/importLddy", method = RequestMethod.POST)
	public boolean addLddy(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = vilService.batchImportLddy(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@RequestMapping(value = "/importDy", method = RequestMethod.POST)
	public boolean addDy(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = vilService.batchImportDy(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@RequestMapping(value = "/importQYGL", method = RequestMethod.POST)
	public boolean addQYGL(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = vilService.batchImportQYGL(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
