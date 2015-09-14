package com.rtmap.core.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rtmap.core.dao.BlogArticleDao;
import com.rtmap.core.dao.GeneralDao;
import com.rtmap.core.entity.PageBean;
import com.rtmap.core.entity.QueryCondition;
import com.rtmap.core.entity.bo.BlogArticleBo;
import com.rtmap.core.entity.vo.BlogArticleVo;

@Repository
public class BlogArticleDaoImpl implements BlogArticleDao {
	
	private static Logger logger = LoggerFactory.getLogger(BlogArticleDaoImpl.class);
	
	@Autowired
	private GeneralDao generalDao;

	@Override
	public PageBean<BlogArticleVo> getArticleList(QueryCondition queryCondition) throws Exception {
		return generalDao.getPageBeans(
				BlogArticleVo.class, 
				" SELECT article.*, category.categoryName FROM blog_article article LEFT JOIN `category` category ON article.`category` = category.`id` WHERE article.showFlag = ? ORDER BY article.ID DESC ", 
				Integer.parseInt(queryCondition.getPageNo()), 
				Integer.parseInt(queryCondition.getPageSize()), 
				new Object[]{1});
	}
	
	@Override
	public PageBean<BlogArticleVo> getSysArticleList(QueryCondition queryCondition) throws Exception {
		return generalDao.getPageBeans(
				BlogArticleVo.class, 
				" select * from blog_article ORDER BY ID DESC ", 
				Integer.parseInt(queryCondition.getPageNo()), 
				Integer.parseInt(queryCondition.getPageSize()),  
				new Object[]{});
	}

	@Override
	public PageBean<BlogArticleVo> getTagArticleList(
			QueryCondition queryCondition, String tag) throws Exception {
		return generalDao.getPageBeans(
				BlogArticleVo.class, 
				" SELECT article.*, category.categoryName FROM blog_article article LEFT JOIN `category` category ON article.`category` = category.`id` "
						+ " WHERE article.showFlag = ? and article.tag like ? ORDER BY article.userReadCount DESC ",
				Integer.parseInt(queryCondition.getPageNo()), 
				Integer.parseInt(queryCondition.getPageSize()), 
				new Object[]{1, "%"+ tag +"%"});
	}
	
	@Override
	public PageBean<BlogArticleVo> getArticleList(int category, QueryCondition queryCondition)
			throws Exception {
		logger.info("getArticleList");
		return generalDao.getPageBeans(
				BlogArticleVo.class, 
				" SELECT article.*, category.categoryName FROM blog_article article LEFT JOIN `category` category ON article.`category` = category.`id` "
				+ " WHERE article.showFlag = ? and article.category = ? ORDER BY article.ID DESC ",
				Integer.parseInt(queryCondition.getPageNo()), 
				Integer.parseInt(queryCondition.getPageSize()), 
				new Object[]{1, category});
	}

	@Override
	public boolean addArticle(BlogArticleBo article) throws Exception {
		return generalDao.saveEntity(article);
	}

	@Override
	public boolean updateArticle(BlogArticleBo article, String...updateFields) throws Exception {
		return generalDao.updateEntity(article, updateFields);
	}

	@Override
	public boolean delArticle(int articleId) throws Exception {
		BlogArticleBo bo = new BlogArticleBo();
		bo.setId(articleId);
		return generalDao.delEntity(bo);
	}

	@Override
	public BlogArticleVo getArticleById(int articleId) throws Exception {
		return generalDao.getEntity(
				BlogArticleVo.class, 
				" SELECT article.*, category.categoryName FROM blog_article article LEFT JOIN `category` category ON article.`category` = category.`id` WHERE article.id = ?", 
				new Object[]{articleId});
	}
}
