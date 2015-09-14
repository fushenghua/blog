package com.rtmap.core.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rtmap.core.constant.ConstantUtil;
import com.rtmap.core.dao.BlogArticleDao;
import com.rtmap.core.entity.PageBean;
import com.rtmap.core.entity.QueryCondition;
import com.rtmap.core.entity.bo.BlogArticleBo;
import com.rtmap.core.entity.vo.BlogArticleVo;
import com.rtmap.core.service.BlogArticleService;
import com.rtmap.core.service.UploadFileService;
import com.rtmap.core.util.DateUtil;
import com.rtmap.core.util.MD5Util;

@Service
public class BlogArticleServiceImpl implements BlogArticleService {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogArticleServiceImpl.class);
	
	@Autowired
	private BlogArticleDao blogArticleDao;
	@Autowired
	private UploadFileService uploadFileService;

	@Override
	public PageBean<BlogArticleVo> getArticleList(QueryCondition queryCondition) throws Exception {
		queryCondition.setPageSize("15");
		return blogArticleDao.getArticleList(queryCondition);
	}

	@Override
	public PageBean<BlogArticleVo> getSysArticleList(
			QueryCondition queryCondition) throws Exception {
		queryCondition.setPageSize("15");
		return blogArticleDao.getSysArticleList(queryCondition);
	}
	
	@Override
	public boolean siteMapFile(QueryCondition queryCondition) throws Exception {
		List<BlogArticleVo> articleList = blogArticleDao.getArticleList(queryCondition).getDatas();
		StringBuilder sb = new StringBuilder();
		for(BlogArticleVo article : articleList){
			sb.append("http://www.baidu/article/"+ article.getId() +".html");
			sb.append("\r\n");
		}
//		File file = new File("F:"+File.separator+"test"+File.separator+"siteMap.txt"); 
		File file = new File("/alidata/dataFile/sitemap.txt"); 
        FileUtils.writeStringToFile(file, sb.substring(0, sb.length()-2));
        return true;
	}

	@Override
	public PageBean<BlogArticleVo> getTagArticleList(
			QueryCondition queryCondition, String tag) throws Exception {
		return blogArticleDao.getTagArticleList(queryCondition, tag);
	}

	@Override
	public PageBean<BlogArticleVo> getArticleList(int category, QueryCondition queryCondition)
			throws Exception {
		return blogArticleDao.getArticleList(category, queryCondition);
	}

	@Override
	public boolean addArticle(BlogArticleBo article) throws Exception {
		article.saveVlidate();
		if(article.getContent().indexOf("<div") <= 0){
			if(article.getContent().indexOf("<p>", 200) > 0){
				article.setContentDesc(article.getContent().substring(0, article.getContent().indexOf("<p>", 200)));
			}else{
				article.setContentDesc(article.getContent());
			}
		}else{
			article.setContentDesc(article.getContent());
		}
		article.setContent(article.getContent().replace("<pre>", "<pre class=\"brush: java;\">") + ConstantUtil.ARTICLE_FOOTER_ADD);
		return blogArticleDao.addArticle(article);
	}

	@Override
	public boolean updateArticle(BlogArticleBo article) throws Exception {
		article.saveVlidate();
		if(article.getContent().indexOf("<div") <= 0){
			if(article.getContent().indexOf("<p>", 200) > 0){
				article.setContentDesc(article.getContent().substring(0, article.getContent().indexOf("<p>", 200)));
			}else{
				article.setContentDesc(article.getContent());
			}
		}else{
			article.setContentDesc(article.getContent());
		}
//		article.setContent(article.getContent() + ConstantUtil.ARTICLE_FOOTER_ADD);
		article.setContent(article.getContent().replace("<pre>", "<pre class=\"brush: java;\">"));
		return blogArticleDao.updateArticle(article, new String[]{"title","content","contentDesc","category","showFlag","tag","keyWords","description"});
	}

	@Override
	public boolean delArticle(int articleId) throws Exception {
		return blogArticleDao.delArticle(articleId);
	}

	@Override
	public BlogArticleVo getArticleById(int articleId) throws Exception {
		BlogArticleVo article = blogArticleDao.getArticleById(articleId);
		if(article != null){
			article.setUserReadCount(article.getUserReadCount() + 1);
			BlogArticleBo articleBo = new BlogArticleBo();
			BeanUtils.copyProperties(article, articleBo);
			blogArticleDao.updateArticle(articleBo, "userReadCount");
		}
		return article;
	}

	@Override
	public String saveArticleImg(BlogArticleVo blogArticleVo)
			throws Exception {
		String realPath = ConstantUtil.DATA_REAL_PATH_ARTICLE_IMG;
		String path = ConstantUtil.SERVER_URL + "/articleDirectory/";   //www.baidu/articleDirectory/supernatural.jpg
		MultipartFile multipartFile = blogArticleVo.getImgFile();
		String fileName = MD5Util.GetMD5Code("" + DateUtil.getTimeInMillis(new Date()))+
				multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		logger.info("upload handout imgfile url:" + realPath);
		uploadFileService.uploadFile(realPath, multipartFile , fileName);
		return path + fileName;
	}

}
