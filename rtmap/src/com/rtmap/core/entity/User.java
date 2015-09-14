package com.rtmap.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.rtmap.core.util.DateUtil;
import com.rtmap.core.util.MD5Util;

/**
 * 用户信息
 * @author fushenghua
 * @date 2014-5-27 15:06:15
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -2782302921570402227L;

	private int id;
	
	/*
	 * 用户名
	 */
	private String userName = "";
	
	/*
	 * 用户密码，md5加密
	 */
	private String userPass = "";
	
	/*
	 * 用户头像,图片的url
	 */
	private String avatar = "";
	
	/*
	 * 用户昵称
	 */
	private String nickName = "";
	
	/*
	 * 用户邮箱
	 */
	private String userEmail = "";
	
	/*
	 * 性别：1.男2.女0.未知
	 */
	private int sex = 1;
	
	/*
	 * 地址
	 */
	private String address = "";
	
	/*
	 * 联系电话
	 */
	private String phone = "";
	
	/*
	 * 用户类型：1.学生2.教师
	 */
	private int userType = 1;
	
	/*
	 * 1.新浪微博token 
	 * 2.QQ账号token
	 */
	private int tokenType = 1;
	
	/*
	 * 新浪微博的token
	 */
	private String sinaToken = "";
	/*
	 * QQ的token
	 */
	private String qqToken = "";
	
	private Date loginTime = new Date();
	
	/*
	 * 用户单点登录的会话唯一标识
	 */
	private String sessionId = UUID.randomUUID().toString().replace("-", "");
	
	/*
	 * 注册时间
	 */
	private Date createTime = new Date();
	
	/**
	 * UuID(新浪微博的用户ID)
	 */
	private String sinaUuId;
	/**
	 * UuID(QQ的用户ID)
	 */
	private String qqUuId;
	
	/*
	 * 个人签名
	 */
	private String userSign = "";

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}



	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public int getTokenType() {
		return tokenType;
	}

	public void setTokenType(int tokenType) {
		this.tokenType = tokenType;
	}

	public String getSinaToken() {
		return sinaToken;
	}

	public void setSinaToken(String sinaToken) {
		this.sinaToken = sinaToken;
	}

	public String getQqToken() {
		return qqToken;
	}

	public void setQqToken(String qqToken) {
		this.qqToken = qqToken;
	}

	public String getSinaUuId() {
		return sinaUuId;
	}

	public void setSinaUuId(String sinaUuId) {
		this.sinaUuId = sinaUuId;
	}

	public String getQqUuId() {
		return qqUuId;
	}

	public void setQqUuId(String qqUuId) {
		this.qqUuId = qqUuId;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPass="
				+ userPass + ", avatar=" + avatar + ", nickName=" + nickName
				+ ", userEmail=" + userEmail + ", sex=" + sex + ", address="
				+ address + ", phone=" + phone + ", userType=" + userType
				+ ", tokenType=" + tokenType + ", sinaToken=" + sinaToken
				+ ", qqToken=" + qqToken + ", loginTime=" + loginTime
				+ ", sessionId=" + sessionId + ", createTime=" + createTime
				+ ", sinaUuId=" + sinaUuId + ", qqUuId=" + qqUuId
				+ ", userSign=" + userSign + "]";
	}
	
	public void setMd5Pass(){
		this.setUserPass(MD5Util.GetMD5Code(this.getUserPass()));
	}
	
	public void updateSession(){
		this.setSessionId(UUID.randomUUID().toString().replace("-", ""));
	}
	
	/**
	 * 用户登录是否已过期
	 * true：已过期    false：未过期
	 * @user fushenghua
	 * 2014年6月9日
	 */
	public boolean userLoginStatus(){
		return new Date().after(DateUtil.addDate(this.loginTime, 10));
	}

}
