package com.jtzh.dto;

import java.util.List;

import com.jtzh.entity.SecurityInfReceive;
import com.jtzh.entity.SecuritySource;

public class SafeNoticeAndPicDto {
	private SecurityInfReceive securityInfReceive;
	private List <SecuritySource> securityInfSource;
	public SecurityInfReceive getSecurityInfReceive() {
		return securityInfReceive;
	}
	public void setSecurityInfReceive(SecurityInfReceive securityInfReceive) {
		this.securityInfReceive = securityInfReceive;
	}
	public List<SecuritySource> getSecurityInfSource() {
		return securityInfSource;
	}
	public void setSecurityInfSource(List<SecuritySource> securityInfSource) {
		this.securityInfSource = securityInfSource;
	}
	
}
