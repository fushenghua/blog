package com.rtmap.core.entity;

import java.io.Serializable;

/**
 * 前台与后台交互的查询条件
 * @author fushenghua
 * 2014年6月4日
 */
public class QueryCondition implements Serializable {

	private static final long serialVersionUID = -1355774941233169879L;
	
	/**
	 * 前台传来的页数
	 */
	private String pageNo = "1";
	/**
	 * 每页显示多少条
	 */
	private String pageSize = "10";
	/**
	 * 用户的sessionId
	 */
	private String sessionId = "";
	
	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	

	@Override
	public String toString() {
		return "QueryCondition [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", sessionId=" + sessionId + "]";
	}
	
}
