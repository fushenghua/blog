package com.rtmap.core.action.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.core.action.BaseController;
import com.rtmap.core.entity.JsonResult;
import com.rtmap.core.entity.PageBean;
import com.rtmap.core.entity.QueryCondition;
import com.rtmap.core.entity.bo.BlogArticleBo;
import com.rtmap.core.entity.vo.BlogArticleVo;
import com.rtmap.core.exception.ServiceException;
import com.rtmap.core.service.BlogArticleService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/system/article")
public class SysArticleController extends BaseController {
	
	private static Logger logger = Logger.getLogger(SysArticleController.class);
	
	@Autowired
	private BlogArticleService blogArticleService;
	
	/**
	 * 系统管理员  管理文章 
	 * @user jack
	 * 2014年8月7日
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getArticleList(HttpServletRequest request, QueryCondition queryCondition) throws Exception{
		PageBean<BlogArticleVo> blogArticlePageBean = null;
		try{
			blogArticlePageBean = blogArticleService.getSysArticleList(queryCondition);
		} catch (Exception e){
			e.printStackTrace();
		}
		request.setAttribute("articleList", blogArticlePageBean !=null ? blogArticlePageBean.getDatas() : null);
		request.setAttribute("pageInfo", blogArticlePageBean);
		request.setAttribute("queryCondition" , queryCondition);
		logger.info("get articleList size:" + blogArticlePageBean.getDatas().size());
		return "system/blogArticleList";
	}
	
	/**
	 * 新增文章
	 * @user fushenghua
	 * 2014年8月6日
	 */
	@RequestMapping(value = "addArticle", method = RequestMethod.POST)
	@ResponseBody
	public Object addArticle(HttpServletRequest request, BlogArticleBo article){
		logger.info("addArticle info:" + article.toString());
		boolean flag = false;
		String errorMessage = "Success！";
		try{
			flag = blogArticleService.addArticle(article);
		}catch (ServiceException serviceE){
			logger.error("addArticle failed!" , serviceE);
			errorMessage = serviceE.getMessage();
		}catch (Exception e){
			logger.error("addArticle failed!" , e);
			errorMessage = "failed！";
		}
		if(flag){
			return "<script  type='text/javascript' charset='utf-8'>window.parent.addArticle('" + errorMessage + "');</script>";
		}
		return "<script type='text/javascript' charset='utf-8'>window.parent.savCourseFailed('" + errorMessage + "');</script>";
	}
	
	/**
	 * 修改文章
	 * @user fushenghua
	 * 2014年8月6日
	 */
	@RequestMapping(value = "updateArticle", method = RequestMethod.POST)
	@ResponseBody
	public Object updateArticle(HttpServletRequest request, BlogArticleBo article){
		logger.info("updateArticle info:" + article.toString());
		boolean flag = false;
		String errorMessage = "update Success!";
		try{
			flag = blogArticleService.updateArticle(article);
		}catch (ServiceException serviceE){
			logger.error("updateArticle failed!" , serviceE);
			errorMessage = serviceE.getMessage();
		}catch (Exception e){
			logger.error("updateArticle failed!" , e);
			errorMessage = "update Success!";
		}
		if(flag){
			return "<script type='text/javascript' charset='utf-8'>window.parent.addArticle('" + errorMessage + "');</script>";
		}
		return "<script type='text/javascript' charset='utf-8'>window.parent.savCourseFailed('" + errorMessage + "');</script>";
	}
	
	/**
	 * 新增讲义图片
	 * @user fushenghua
	 * 2014年8月22日
	 */
	@RequestMapping(value = "uploadJson", method = RequestMethod.POST)
	@ResponseBody
	public String uploadJson(HttpServletRequest request , HttpServletResponse response, BlogArticleVo blogArticleVo){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			returnMap.put("error", 0);
			returnMap.put("url", blogArticleService.saveArticleImg(blogArticleVo));
		} catch (Exception e) {
			returnMap.put("error", 1);
			returnMap.put("message", "图片格式不正确");
			return new Gson().toJson(returnMap);
		}
		return new Gson().toJson(returnMap);
	}
	
	/**
	 * 修改文章弹出框获取文章内容
	 * @param request
	 * @param handoutBo
	 * @return
	 */
	@RequestMapping(value = "getArticleByArticleId", method = RequestMethod.POST)
	@ResponseBody
	public String getArticleByArticleId(HttpServletRequest request, @RequestBody BlogArticleVo blogArticleVo) throws Exception{
		JsonResult<BlogArticleVo> jsonResult = new JsonResult<BlogArticleVo>();
		BlogArticleBo blogArticleBo = blogArticleService.getArticleById(blogArticleVo.getId());
		jsonResult.setResultCode(0);
		jsonResult.setResultMessage("获取文章内容成功"); //"<span>test修改讲义</span>"
		jsonResult.setData(blogArticleBo);
		return new Gson().toJson(jsonResult);
	}
	
	@RequestMapping(value = "del", method = RequestMethod.POST)
	@ResponseBody
	public String del(HttpServletRequest request,@RequestBody BlogArticleVo blogArticleVo){
		logger.info("del info:" + blogArticleVo.toString());
		boolean flag = false;
		String errorMessage = "删除文章失败";
		JsonResult<BlogArticleVo> jsonResult = new JsonResult<BlogArticleVo>();
		try{
			flag = blogArticleService.delArticle(blogArticleVo.getId());
		}catch (ServiceException serviceE){
			logger.error("del article failed!", serviceE);
			errorMessage = serviceE.getMessage();
		}catch (Exception e) {
			logger.error("del article failed!", e);
		}
		jsonResult.setResultCode(flag ? 0 : 1);
		jsonResult.setResultMessage(flag ? "删除文章成功" : errorMessage);
		return new Gson().toJson(jsonResult);
	}

}
