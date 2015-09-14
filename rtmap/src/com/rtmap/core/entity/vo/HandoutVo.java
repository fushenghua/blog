package com.rtmap.core.entity.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.rtmap.core.exception.ServiceException;
import com.rtmap.core.util.FileUtil;
import com.rtmap.core.util.StringUtil;

public class HandoutVo implements Serializable {
	
	private static final long serialVersionUID = 1483098567778891346L;

	private int id;
	
	/**
	 * 教室Id
	 */
	private int roomId;
	/**
	 * 讲义的html代码
	 */
	private String handout;
	/**
	 * 
	 */

	private String localUrl;
	/**
	 * 讲义图片
	 */
	private MultipartFile imgFile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getHandout() {
		return handout;
	}
	public void setHandout(String handout) {
		this.handout = handout;
	}
	
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
	public String getLocalUrl() {
		return localUrl;
	}
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}
	@Override
	public String toString() {
		return "HandoutVo [id=" + id + ", roomId=" + roomId + ", handout="
				+ handout + ", localUrl=" + localUrl + ", imgFile=" + imgFile
				+ "]";
	}
	
	/**
	 * 新增讲义时判断输入是否为空
	 */
	public void saveHandoutInput() throws ServiceException{
		if(StringUtil.isEmpty(this.getHandout())){
			throw new ServiceException("请输入讲义内容！");
		}
		
	}
	/**
	 * 新增讲义图片时判断图片格式是否正确
	 * @throws ServiceException
	 */
	public void saveHandoutImgInput() throws ServiceException{
		String fileName = this.getImgFile().getOriginalFilename();
		if(StringUtil.isNotBlank(fileName) &&  ! FileUtil.validateImgFileType(fileName)){
			throw new ServiceException("讲义图片格式不正确！");
		}
	}
	
	
	
	/**
	 * 修改讲义时判断输入是否为空
	 */
	public void updateHandoutInput() throws ServiceException{
		if(StringUtil.isEmpty(this.getHandout())){
			throw new ServiceException("请输入讲义内容！");
		}
	}
	
	
	

}
