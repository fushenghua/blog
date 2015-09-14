package com.rtmap.core.entity.vo;

import java.util.Date;

public class CalendarQueryVo {
	
	private int calendarId;
	
	private String timezone = "8";

	/**
	 * 三种类型
	 * day,week,month
	 */
	private String viewtype = "week";
	
	private Date showdate = new Date();
	
	private String CalendarStartTime;
	
	private String CalendarEndTime;
	
	private String CalendarTitle = "";
	
	private int IsAllDayEvent;

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getViewtype() {
		return viewtype;
	}

	public void setViewtype(String viewtype) {
		this.viewtype = viewtype;
	}

	public Date getShowdate() {
		return showdate;
	}

	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}

	public String getCalendarStartTime() {
		return CalendarStartTime;
	}

	public void setCalendarStartTime(String calendarStartTime) {
		CalendarStartTime = calendarStartTime;
	}

	public String getCalendarEndTime() {
		return CalendarEndTime;
	}

	public void setCalendarEndTime(String calendarEndTime) {
		CalendarEndTime = calendarEndTime;
	}

	public String getCalendarTitle() {
		return CalendarTitle;
	}

	public void setCalendarTitle(String calendarTitle) {
		CalendarTitle = calendarTitle;
	}

	public int getIsAllDayEvent() {
		return IsAllDayEvent;
	}

	public void setIsAllDayEvent(int isAllDayEvent) {
		IsAllDayEvent = isAllDayEvent;
	}
	
	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	@Override
	public String toString() {
		return "CalendarQueryVo [calendarId=" + calendarId + ", timezone="
				+ timezone + ", viewtype=" + viewtype + ", showdate="
				+ showdate + ", CalendarStartTime=" + CalendarStartTime
				+ ", CalendarEndTime=" + CalendarEndTime + ", CalendarTitle="
				+ CalendarTitle + ", IsAllDayEvent=" + IsAllDayEvent + "]";
	}
	
}
