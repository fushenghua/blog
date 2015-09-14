package com.rtmap.core.action.blog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.core.action.BaseController;
import com.rtmap.core.entity.JsonResult;
import com.rtmap.core.entity.QueryCondition;
import com.rtmap.core.entity.bo.BlogArticleBo;
import com.rtmap.core.entity.vo.BlogArticleVo;
import com.rtmap.core.service.BlogArticleService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	
	private static Logger logger = Logger.getLogger(ArticleController.class);
	
	@Autowired
	private BlogArticleService blogArticleService;
	
	/**
	 * 根据网址获取文章的html页面
	 * 比如如下的URL：/123.html，则输出：
		namePart: 123, expandedPart: html. 
	 * @user fushenghua
	 * 2014年8月14日
	 */
    @RequestMapping(value="/{namePart:[\\d]+}.{expandedPart:html}")  
    public String getArticleModel(HttpServletRequest request, @PathVariable int namePart, @PathVariable String expandedPart, QueryCondition queryCondition) throws Exception{  
    	logger.info("namePart: " + namePart + ", expandedPart: " + expandedPart);
    	BlogArticleVo article = blogArticleService.getArticleById(namePart);
    	if(article == null || article.getId() <= 0){
    		return "about/404"; 
    	}
    	request.setAttribute("article", article);
    	//获取相关文章
    	request.setAttribute("categoryArticleList", blogArticleService.getArticleList(article.getCategory(), queryCondition).getDatas());
    	//记得补充获取友情链接数据（放到缓存中）
        return "blog/article";  
    }  
    
    /**
     * 获取用户推荐的文章列表
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "getHotArticleList", method = RequestMethod.POST)
	@ResponseBody
    public String getHotArticleList(QueryCondition queryCondition){
    	List<BlogArticleVo> articleList = null;
    	JsonResult<BlogArticleBo> jsonResult = new JsonResult<BlogArticleBo>();
    	try {
    		articleList = blogArticleService.getArticleList(queryCondition).getDatas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(articleList == null || articleList.size() <= 0){
			jsonResult.setResultCode(1);
			jsonResult.setResultMessage("获取用户推荐的文章列表失败");
		}
		jsonResult.setData(articleList);
		return new Gson().toJson(jsonResult);
    }
	
//	@RequestMapping(value = "getArticleById/{id}")
//	@ResponseBody
//	public Object getArticleById(HttpServletRequest request, @PathVariable String id){
//		try {
//			return blogArticleService.getArticleById(Integer.parseInt(id));
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
