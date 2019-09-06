package com.jtzh.responsevo;

import java.util.List;

import com.jtzh.entity.SecuritySource;

public class SecurityInfReceiveDetailVo {
	private SecurityInfReceiveVo securityInfReceiveVo;
	private List <SecuritySource> securityInfSource;
	public SecurityInfReceiveVo getSecurityInfReceiveVo() {
		return securityInfReceiveVo;
	}
	public void setSecurityInfReceiveVo(SecurityInfReceiveVo securityInfReceiveVo) {
		this.securityInfReceiveVo = securityInfReceiveVo;
	}
	public List<SecuritySource> getSecurityInfSource() {
		return securityInfSource;
	}
	public void setSecurityInfSource(List<SecuritySource> securityInfSource) {
		this.securityInfSource = securityInfSource;
	}
	
}
