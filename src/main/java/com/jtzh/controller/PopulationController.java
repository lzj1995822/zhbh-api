/*    */ package com.jtzh.controller;

import java.util.HashMap;
import java.util.Map;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;

import com.jtzh.common.ExtResponse;
import com.jtzh.service.PopulationService;
/*    */ import com.jtzh.util.ResponseUtil;

/*    */
/*    */
/*    */ @Controller
/*    */ @RequestMapping({ "/api/population" })
/*    */ public class PopulationController
/*    */ {
	/*    */ @Autowired
	/*    */ private PopulationService populationService;

	/*    */
	/*    */ @RequestMapping({ "/getServedHistogramCount" })
	/*    */ @ResponseBody
	/*    */ public ExtResponse getServedHistogramCount(String type)
	/*    */ {
		/* 23 */ return ResponseUtil.success(this.populationService.getServedHistogramCount(type));
		/*    */ }

	@RequestMapping({ "/getServedHistogramScreenCount" })
	@ResponseBody
	public int[] getServedHistogramScreenCount() {
		Map map = new HashMap<Integer,String>();
		map.put(0, "01");
		map.put(1, "02");
		map.put(2, "03");
		int counts[] = new int[3];
		for(int count:counts){
			Integer index = 0;
			counts[index] = this.populationService.getServedHistogramScreenCount((String)(map.get(index)));;
			index++;
		}
		return counts;
	}

	}
