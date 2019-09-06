package com.jtzh.service;

import com.jtzh.entity.PioneerServiceResult;
import com.jtzh.entity.PioneerVolunteer;
import com.jtzh.entity.PioneerVolunteerServiceE;
import com.jtzh.model.VolunteerResultModel;
import com.jtzh.pojo.KeyParam;

import java.util.List;

public interface PioneerVolunteerService {
	
	public Object addZyz(PioneerVolunteer pioneerVolunteer);
	
	public Object getZyz(KeyParam keyParam);

	public Object getZyzBmInfo();
	public Object getZyzInfo(String id);
	public Object updateZyzZt(String id,String zt);
	public Object updateZyz(PioneerVolunteer pioneerVolunteer);
	
	public Object addZyzhd(PioneerVolunteerServiceE p);
	
	public Object getZyzhd(KeyParam keyParam);

    public Object getZyzHdByTime();
	public Object getZyzhdApp(KeyParam keyParam);
	public Object getZyzhdAppYjs(KeyParam keyParam);
	public Object updateZyzHd();
	
	public Object getZyzhdBm(String hdid,String zyzzh);

	public Object getZyzhdBmInfo(KeyParam keyParam);

	public Object addBmInfo(String hdid, String zyzzh);
	
	
	public Object addHdJg(PioneerServiceResult pioneerServiceResult);
	
	public Object getHdJg(String id);

	public Object removeZyzHd(String id);

	public Object updateZyzHd(PioneerVolunteerServiceE pioneerServiceResult);

	List<VolunteerResultModel> countByMonthAndType();

}
