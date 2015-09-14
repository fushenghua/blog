package com.rtmap.core.entity.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rtmap.core.entity.bo.BlogArticleBo;
import com.rtmap.core.util.StringUtil;

public class BlogArticleVo extends BlogArticleBo {
	
	private String localUrl;
	/**
	 * 文章图片
	 */
	private MultipartFile imgFile;
	/**
	 * 文章所属分类名称
	 */
	private String categoryName;
	
	public String getLocalUrl() {
		return localUrl;
	}
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<String> getTagList(){
		if(StringUtil.isEmpty(this.getTag())){
			List<String> tagList = new ArrayList<String>();
			tagList.add("杂谈");
			return tagList;
		}
		String[] tagArray = this.getTag().split(",");
		return Arrays.asList(tagArray);
	}

}
