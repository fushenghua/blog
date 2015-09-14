package com.rtmap.core.entity.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
/**
 * 修改用户头像的实体类
 * @author fushenghua
 * 2014年6月18日
 */
public class UserVo implements Serializable{
	
	private static final long serialVersionUID = -515936943350626810L;

	private int id;
	
	/**
	 * 上传的图片文件
	 */
	private MultipartFile userIconFile;
	
	private String sessionId = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MultipartFile getUserIconFile() {
		return userIconFile;
	}

	public void setUserIconFile(MultipartFile userIconFile) {
		this.userIconFile = userIconFile;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", userIconFile=" + userIconFile
				+ ", sessionId=" + sessionId + "]";
	}

}
