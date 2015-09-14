package com.rtmap.core.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class ViewCodeUtil {
	static SAXParserFactory saxfac = SAXParserFactory.newInstance();

	static SaxHander mySax = new SaxHander();

	public static String getCode(String resFileName) {

		File f = new File(resFileName);
		if (!f.exists()) {
			return null;
		}
		try {
			saxfac.newSAXParser().parse(f, mySax);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		List<IdNamePair> res = mySax.getRes();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("//---------- 开始定义域--------------\n");

		sb1.append("//----------开始initView方法------------------\n");
		sb1.append("public void initView() { \n");

		for (IdNamePair idNamePair : res) {
			sb.append(" private " + idNamePair.getName() + "  "
					+ idNamePair.getId() + idNamePair.getName() + ";\n");

			sb1.append("    " + idNamePair.getId() + idNamePair.getName()
					+ " = (" + idNamePair.getName() + ")findViewById(R.id."
					+ idNamePair.getId() + ");\n");

		}
		sb1.append("}\n");
		// System.out.println(sb.toString());
		// System.out.println(sb1.toString());
		return sb.append(sb1.toString()).toString();
	}

	public static String getCodeByStr(String content) {
		String replaceXml = content.replace("utf-8", "UTF8");
		 replaceXml = content.replace("UTF-8", "UTF8");
		
		 if ( content.indexOf("?xml version=")<0) {
			replaceXml="<?xml version='1.0' encoding='UTF8'?>"+replaceXml;
		}
		ByteArrayInputStream in = new ByteArrayInputStream(replaceXml.getBytes());
		try {
			saxfac.newSAXParser().parse(in, mySax);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		List<IdNamePair> res = mySax.getRes();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("//----------开始 变量--------------\n");

		sb1.append("//----------initView方法------------------\n");
		sb1.append("public void initView() { \n");

		for (IdNamePair idNamePair : res) {
			sb.append(" private " + idNamePair.getName() + "  "
					+ idNamePair.getId() + idNamePair.getName() + ";\n");

			sb1.append("    " + idNamePair.getId() + idNamePair.getName()
					+ " = (" + idNamePair.getName() + ")findViewById(R.id."
					+ idNamePair.getId() + ");\n");

		}
		sb1.append("}\n");
		// System.out.println(sb.toString());
		// System.out.println(sb1.toString());
		return sb.append(sb1.toString()).toString();
	}

}
