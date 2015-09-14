package com.rtmap.core.entity.bo;

import java.util.Date;

/**
 * 支付宝捐款活动，用户订单表
 * @author fushenghua
 * 2015年5月15日
 */
public class AlipayEventUser {
	
	private int id;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户真名
	 */
	private String userName;
	
	private String userPhoneOrEmail;
	
	/**
	 * 支付宝订单号(账务流水号)
	 */
	private String aliOrder;
	/**
	 * 支付宝订单号(业务流水号)
	 */
	private String aliOrderBussies;
	/**
	 * 捐赠金额
	 */
	private String eventMoney;
	/**
	 * 审核状态：0.待审核1.审核失败2.审核通过
	 */
	private int checkStatus;
	
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneOrEmail() {
		return userPhoneOrEmail;
	}

	public void setUserPhoneOrEmail(String userPhoneOrEmail) {
		this.userPhoneOrEmail = userPhoneOrEmail;
	}

	public String getAliOrder() {
		return aliOrder;
	}

	public void setAliOrder(String aliOrder) {
		this.aliOrder = aliOrder;
	}

	public String getAliOrderBussies() {
		return aliOrderBussies;
	}

	public void setAliOrderBussies(String aliOrderBussies) {
		this.aliOrderBussies = aliOrderBussies;
	}

	public String getEventMoney() {
		return eventMoney;
	}

	public void setEventMoney(String eventMoney) {
		this.eventMoney = eventMoney;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AlipayEventUser [id=" + id + ", nickName=" + nickName
				+ ", userName=" + userName + ", userPhoneOrEmail="
				+ userPhoneOrEmail + ", aliOrder=" + aliOrder
				+ ", aliOrderBussies=" + aliOrderBussies + ", eventMoney="
				+ eventMoney + ", checkStatus=" + checkStatus + ", createTime="
				+ createTime + "]";
	}
	
}
