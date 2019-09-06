package com.jtzh.service;

import com.jtzh.entity.Cgchuli;
import com.jtzh.entity.Userinfo;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.CgchuliMapper;
import com.jtzh.mapper.UserinfoMapper;
import com.jtzh.mapper.UserinformationMapper;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SystemService {
    @Resource
    private UserinformationMapper mapper;

    /**
     * 获取用户
     *
     * @param id 用户主键ID
     * @return 用户或NULL
     */
    public Userinformation selectByPrimaryKey(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 登录接口
     *
     * @param userinformation 用户登录参数
     * @return 成功状态
     * @throws Exception 失败原因
     */
    public boolean login(Userinformation userinformation) throws Exception {
        if (mapper == null) throw new NullArgumentException("userinfoMapper");
        if (userinformation == null) throw new NullArgumentException("userinfo");
        if (StringUtils.isBlank(userinformation.getUiloginname())) throw new NullArgumentException("userinfo.uiloginname");
        if (StringUtils.isBlank(userinformation.getUicode())) throw new NullArgumentException("userinfo.uicode");
        if (mapper.login(userinformation.getUiloginname(), userinformation.getUicode()) == 1) return true;
        throw new Exception("非法的用户凭据");
    }
}
