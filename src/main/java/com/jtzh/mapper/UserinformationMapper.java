package com.jtzh.mapper;

import java.util.List;
import com.jtzh.entity.Userinfo;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.UserInfomationPagination;
import org.apache.ibatis.annotations.Select;

public interface UserinformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinformation record);

    int insertSelective(Userinformation record);

    Userinformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinformation record);

    int updateByPrimaryKey(Userinformation record);
    
    // 查询总数
 	int selectUserinfoTotal(@Param("page") UserInfomationPagination param);

    @Select("select count(1) from Userinformation where uiloginname=#{uiloginname} and uicode = #{uicode}")
    int login(@Param("uiloginname")String uiloginname, @Param("uicode")String uicode);

 	// 分页查询
 	List<Userinformation> selectUserinfo(@Param("page") UserInfomationPagination param);

    //登录查询
    Userinformation getLoginInfo(Userinformation user);
    
    //登录查询
    Userinformation getIdByName(Userinformation user);
    
    //只可以修改只可以修改昵称，用户头像，电话，照片
    int updateStrict(Userinformation record);
    
    //返回主键
    int insertUserReturnId(Userinformation record);  
    
    int getCountByLoginId(String uiloginname);
    
    int countPersonNumByDep(String depName);
    
    List <Userinformation> getSafeUser(String type);
    
    int [] getUserIdsByDep(String depName);
}