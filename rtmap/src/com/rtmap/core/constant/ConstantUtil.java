package com.rtmap.core.constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstantUtil {
	
	public static String SERVER_IP = "115.28.87.95";
	
	public static String SERVER_URL = "http://" + SERVER_IP;   //新增文章，添加图片时需要回显图片
	/**
	 * 演示文件存储位置
	 */
	public static String DATA_REAL_PATH_DEMO_DEMOFILE = "/alidata/dataFile/demo/demoFile/";
	/**
	 * 文章图片存储位置
	 */
	public static String DATA_REAL_PATH_ARTICLE_IMG = "/alidata/dataFile/blog/article/img/";
	
	public static String DATA_REAL_PATH_USER_ICON = "/alidata/dataFile/user/img/";
	
	public static Set<String> fileTypeImg = new HashSet<String>();
	static{
		fileTypeImg.add("image/jpeg");
		fileTypeImg.add("image/png");
	}
	
	/**
	 * 图片文件的扩展名集合
	 */
	public static Set<String> imgExpandedName = new HashSet<String>();
	static{
		imgExpandedName.add(".jpg");
		imgExpandedName.add(".jpeg");
		imgExpandedName.add(".png");
		imgExpandedName.add(".gif");
		imgExpandedName.add(".bmp");
	}
	
	public static Map<Integer, Integer> favorPlusOrMinus = new HashMap<Integer, Integer>();
	static{
		favorPlusOrMinus.put(0, 1);
		favorPlusOrMinus.put(1, -1);
	}
	
	public static final String COOKIE_SPLIT = "##########";//COOKIE  Value的分割符
	public static final String SESSION_ID_NAME = "sessionid";
	public static final String USER_SESSION_ID_NAME = "uid";
	
	public static String ARTICLE_FOOTER_ADD = "";
}
