package com.rtmap.core.entity.bo;

import java.util.Date;
import java.util.UUID;

public class SysUserBo {
	
	private int id;
	/**
	 * 用户名
	 */
	private String userName = "";
	
	private String userPass = "";
	
	private String nickName = "";
	
	private String email = "";
	/**
	 * 上次登录时间
	 */
	private Date loginTime;
	/**
	 * 用户单点登录的会话唯一标识
	 */
	private String sessionId = UUID.randomUUID().toString().replace("-", "");
	/**
	 * 用户头像
	 */
	private String userIconUrl = "";
	/**
	 * 用户类型1.系统管理员2.教师
	 */
	private int userType = 2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserIconUrl() {
		return userIconUrl;
	}
	public void setUserIconUrl(String userIconUrl) {
		this.userIconUrl = userIconUrl;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "SysUserBo [id=" + id + ", userName=" + userName + ", userPass="
				+ userPass + ", nickName=" + nickName + ", email=" + email
				+ ", loginTime=" + loginTime + ", sessionId=" + sessionId
				+ ", userIconUrl=" + userIconUrl + ", userType=" + userType
				+ "]";
	}

}
