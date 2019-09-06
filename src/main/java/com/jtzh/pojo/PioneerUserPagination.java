package com.jtzh.pojo;

public class PioneerUserPagination extends BasePagination {
	private String userName;
	private String userSex;
	private String partyOrg;

	private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPartyOrg() {
		return partyOrg;
	}

	public void setPartyOrg(String partyOrg) {
		this.partyOrg = partyOrg;
	}

}
