package com.jtzh.service;


import com.jtzh.entity.PioneerDues;
import com.jtzh.entity.PioneerJf;
import com.jtzh.entity.PioneerLddy;
import com.jtzh.entity.PioneerSjxm;
import com.jtzh.entity.PioneerSjxmHb;
import com.jtzh.pojo.KeyParam;


public interface PioneerJfService {
	
	public Object getDyjf(PioneerJf jf);
	
	public Object addDyjf(PioneerJf jf);
	
	public Object addLddy(PioneerLddy lddy);
	public Object updateLddy(PioneerLddy lddy);
	public Object getLddy(KeyParam param);
	public Object getLddys();
	
	public Object addSjxm(PioneerSjxm sjxm);
	
	public Object getSjxm(KeyParam param);

	public Object getAllSjxm(KeyParam param);
	public Object updateSjxmZt(String id ,String zt);
	
	public Object addJdhb(PioneerSjxmHb hb);
	
	public Object getJdhb(String id);
	
	public Object updateSjxm(PioneerSjxm sjxm);
	
	public Object addDf(PioneerDues dues);
	public Object removeDf(String id);
	public Object updateDf(PioneerDues dues);
	public Object getDfs(KeyParam keyParam);
	
	public Object removeLddy(String id);

	public Object removeSjxm(String id);

	public Object modifySjxm(PioneerSjxm sjxm);

}
