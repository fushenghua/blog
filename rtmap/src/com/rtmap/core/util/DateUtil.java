package com.rtmap.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获取0点时间
	 * @param date
	 * @return
	 */
	public static Date getStartTime(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	/**
	 * 获取23:59:59时间
	 * @param date
	 * @return
	 */
	public static Date getEndTime(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	/**
	 * 格式 化日期，返回符合格式的字符串
	 * @param date
	 * @param formater   如:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	private static String getDateStrCompact(Date date, String formater) {
		if (date == null){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		String str = format.format(date);
		return str;
	}

	/**
	 * 格式 化日期，返回符合格式的字符串
	 * @param date
	 * @param formater   默认 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateToString(Date date,String formatStr) {
		if(formatStr==null || "".equals(formatStr.trim())){
			formatStr="yyyy-MM-dd HH:mm:ss";
		}
		return getDateStrCompact(date, formatStr);
	}
	
	/**
	 * 格式化日期字符串，返回符合格式的date
	 * @param dateStr
	 * @param formater   如:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	public static Date StringToDate(String dateStr, String formater){
		Date date = null;
		if(formater==null || "".equals(formater.trim())){
			formater = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		if(!StringUtil.isNotBlank(dateStr)){
			return date;
		}
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将时间增减 n 分钟
	 * @user fushenghua
	 * 2014年9月25日
	 */
	public static Date addMinute(Date date, int minutes){
		return addDate(date, minutes, Calendar.MINUTE);
	}
	
	/**
	 * 将时间增减 n 秒
	 * @user fushenghua
	 * 2014年9月25日
	 */
	public static Date addSecond(Date date, int second){
		return addDate(date, second, Calendar.SECOND);
	}
	
	/**
	 * 将日期增减 n 天
	 * @param date  参照日期,如果为null则取当前日期
	 * @param days  增减的天数 (为正数则增加，为负数则减少)
	 * @return Date
	 */
	public static Date addDate(Date date, int days) {
		return addDate(date, days, Calendar.DATE);
	}
	
	/**
	 * 取某一日期增减 n 值后的日期, n 由 dateField 决定是年、月、日 根据增加or减少的时间得到新的日期
	 * @param date 参照日期
	 * @param counts 增减的数值
	 * @param dateField
	 *            int 需操作的日期字段, 取值范围如下 Calendar.YEAY 年 Calendar.MONTH 月
	 *            Calendar.DATE 日 .... Calendar.SECOND 秒
	 * @return Date
	 */
	private static Date addDate(Date date, int counts, int dateField) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateField, counts);
		return calendar.getTime();
	}
	
	public static long getTimeInMillis(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}
	
	public static Date getDateFromMillis(long timeInMillis){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeInMillis);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前日期所在周的第一天
	 * @user fushenghua
	 * 2014年9月23日
	 */
	public static Date getWeekStart(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek > Calendar.MONDAY){  //该date大于周一
			return getStartTime(addDate(date, Calendar.MONDAY - dayOfWeek));
		}
		if(dayOfWeek < Calendar.MONDAY){  //该date是周日
			return getStartTime(addDate(date, -6));
		}
		return getStartTime(date);
	}
	
	/**
	 * 获取当前日期所在周的最后一天
	 * @user fushenghua
	 * 2014年9月23日
	 */
	public static Date getWeekEnd(Date date){
		return getEndTime(addDate(getWeekStart(date), 6));
	}
	
	/**
	 * 获取当前日期所在月份的第一天
	 * @user fushenghua
	 * 2014年9月23日
	 */
	public static Date getMonthStart(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if(dayOfMonth > 1){
			return getStartTime(addDate(date, 1 - dayOfMonth));
		}
		return date;
	}
	
	/**
	 * 获取当前日期所在月份的最后一天
	 * @user fushenghua
	 * 2014年9月23日
	 */
	public static Date getMonthEnd(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		return addDate(getEndTime(calendar.getTime()), -1);
	}
	
//	public static void main(String[] args){
//		System.out.println(getMonthEnd(addDate(new Date(), 3)));
//	}

}
