package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jtzh.entity.Menuconfiguration;
import com.jtzh.entity.Use;
import com.jtzh.entity.Userinformation;

public interface UseMapper {
	
	@Select("	select m.MCCaption as 'key',\r\n" + 
			"		case when p.id>0 then '1' \r\n" + 
			"		else '0' end val\r\n" + 
			"		from MenuConfiguration m left join PermissionConfiguration p on m.id=p.PCMenuNumber and p.PCUserNumber=#{user.id} \r\n")
	List<Use>  getlist(@Param("user")Userinformation user);
}
