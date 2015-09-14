package com.rtmap.core.entity.bo;


public class HandoutBo {
	
	public int id;	
	/**
	 * 教室Id
	 */
	private int roomId;
	/**
	 * 讲义的html代码
	 */
	private String handout;

	private String localUrl;
	
	private String imgFileUrl;

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

	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	public String getImgFileUrl() {
		return imgFileUrl;
	}

	public void setImgFileUrl(String imgFileUrl) {
		this.imgFileUrl = imgFileUrl;
	}

	@Override
	public String toString() {
		return "HandoutBo [id=" + id + ", roomId=" + roomId + ", handout="
				+ handout + ", localUrl=" + localUrl + ", imgFileUrl="
				+ imgFileUrl + "]";
	}

	

	

}
