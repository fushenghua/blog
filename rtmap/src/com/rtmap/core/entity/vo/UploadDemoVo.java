package com.rtmap.core.entity.vo;

import org.springframework.web.multipart.MultipartFile;

import com.rtmap.core.constant.ConstantUtil;
import com.rtmap.core.exception.ServiceException;

public class UploadDemoVo {
	
	/**
	 * 文件
	 */
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "UploadDemoVo [imgFile=" + imgFile + "]";
	}
	
	public boolean validateFile() throws ServiceException{
		if(!ConstantUtil.fileTypeImg.contains(this.getImgFile().getContentType())){
			throw new ServiceException("文件类型只能是jpeg、png！");
		}
		if(this.getImgFile().getSize() > 1000 * 100){
			throw new ServiceException("文件最大不能超过100KB！");
		}
		return true;
	}

}
