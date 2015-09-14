package com.rtmap.core.entity.vo;

import com.rtmap.core.entity.bo.AlipayEventUser;

public class AlipayEventUserVo extends AlipayEventUser {
	/**
	 * 所有捐款金额
	 */
	private String totalMoney;

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		return "AlipayEventUserVo [totalMoney=" + totalMoney + "]";
	}

}
