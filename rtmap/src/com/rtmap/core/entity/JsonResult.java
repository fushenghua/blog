package com.rtmap.core.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 返回前台的json数据
 * @author fushenghua
 * @date 2014-5-29 15:36:59
 */
public class JsonResult<T> implements Serializable{

	private static final long serialVersionUID = 4273005680206220420L;
	/**
	 * 返回结果码
	 * 0成功，非0失败
	 */
	private int resultCode = 0;
	/**
	 * 操作结果信息
	 */
	private String resultMessage = "获取数据成功";
	/**
	 * 分页信息
	 */
	private Object pageInfo;
	/**
	 * 返回的数据
	 */
	private Object data;
	
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageBean<T> pageBean) {
		Map<String, String> pageMap = new HashMap<String, String>();
		pageMap.put("pageNo", pageBean.getPageNo());   //页码
		pageMap.put("pageCount", String.valueOf(pageBean.getPageCount()));   //总页数
		pageMap.put("pageSize", String.valueOf(pageBean.getPageSize()));     //每页显示多少条
		pageMap.put("rowsCount", String.valueOf(pageBean.getRowsCount()));
		this.pageInfo = pageMap;
	}
	
	
}
