package com.rtmap.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.core.constant.ConstantUtil;
import com.rtmap.core.entity.vo.UploadDemoVo;
import com.rtmap.core.service.UploadDemoService;
import com.rtmap.core.service.UploadFileService;

@Service
public class UploadDemoServiceImpl implements UploadDemoService {
	
	@Autowired
	private UploadFileService uploadFileService;

	@Override
	public boolean uploadForm(UploadDemoVo demo) throws Exception {
		demo.validateFile();
		uploadFileService.uploadFile(
				ConstantUtil.DATA_REAL_PATH_DEMO_DEMOFILE, demo.getImgFile(), demo.getImgFile().getOriginalFilename());
		return true;
	}

}
