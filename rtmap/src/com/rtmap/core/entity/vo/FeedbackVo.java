package com.rtmap.core.entity.vo;

import java.io.Serializable;
import java.util.Date;

public class FeedbackVo implements Serializable {

	private static final long serialVersionUID = -8001259628446543471L;
	
	private int id;
	/**
	 * 反馈内容
	 */
	private String content = "";
	/**
	 * 用户id
	 */
	private int createId;
	/**
	 * 反馈时间
	 */
	private Date createTime = new Date();
	/**
	 * 用户单点登录的会话唯一标识
	 */
	private String sessionId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCreateId() {
		return createId;
	}
	public void setCreateId(int createId) {
		this.createId = createId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", content=" + content + ", createId="
				+ createId + ", createTime=" + createTime + ", sessionId="
				+ sessionId + "]";
	}
}
