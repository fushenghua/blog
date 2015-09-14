package com.rtmap.core.service;

import java.util.List;

import com.rtmap.core.entity.vo.AlipayEventUserVo;

/**
 * coding活动
 * @author fushenghua
 * 2015年5月15日
 */
public interface CodingEventService {
	
	/**
	 * 获取付款用户list
	 * @user fushenghua
	 * 2015年5月15日
	 */
	public List<AlipayEventUserVo> getAlipayEventList() throws Exception;

}
