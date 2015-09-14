package com.rtmap.core.action.blog;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rtmap.core.entity.PageBean;
import com.rtmap.core.entity.QueryCondition;
import com.rtmap.core.entity.vo.BlogArticleVo;
import com.rtmap.core.service.BlogArticleService;
import com.rtmap.core.util.StringUtil;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	private static Logger logger = Logger.getLogger(TagController.class);
	
	@Autowired
	private BlogArticleService blogArticleService;
	
	/**
	 * 根据分类获取文章列表
	 * @user fushenghua
	 * 2015年6月11日
	 */
	 @RequestMapping(value="/{tag}")  
    public String getArticleListByTag(HttpServletRequest request, @PathVariable String tag, QueryCondition queryCondition) throws Exception{  
//    	tag = new String(tag.getBytes("ISO-8859-1"), "UTF-8");   
//		tomcat 下如果配置 server.xml配置了URIEncoding="UTF-8"，则无需执行上一步转码
//		 <Connector port="8080" protocol="HTTP/1.1"
//         connectionTimeout="20000"
//         redirectPort="8443" URIEncoding="UTF-8" />  
		 
    	logger.info("tag: " + tag );
    	PageBean<BlogArticleVo> articleBean = null;
		try{
			articleBean = blogArticleService.getTagArticleList(queryCondition, tag);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("articleList", articleBean != null ? articleBean.getDatas() : null);
		request.setAttribute("pageInfo", articleBean);
		if(StringUtil.isNotBlank(tag)){
			request.setAttribute("tagCode", 1);
		}
		request.setAttribute("tagName", "阿里云");
		logger.info("get article list size:" + articleBean.getDatas().size());
        return "blog/blog";  
    } 

}
