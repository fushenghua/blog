package com.rtmap.core.entity.bo;

import java.util.Date;

public class CalendarBo {
	
	private int id;
	/**
	 * 日程标题
	 */
	private String subjectName = "";
	/**
	 * 地点
	 */
	private String location = "";
	
	private int masterId;
	/**
	 * 说明
	 */
	private String description = "";
	/**
	 * 日程类型:1个人日程,2部门日程
	 */
	private int calendarType = 1;
	private Date startTime = new Date();
	private Date endTime = new Date();
	/**
	 * 是否全天日程
	 */
	private int isAllDayEvent = 0;
	/**
	 * 是否有附件
	 */
	private int hasAttachment = 0;
	
	/**
	 * 分类
	 */
	private String category = "";
	/**
	 * 实例类型:
	 * 0Single（一般日程）1Master（循环主日程）2Instance（循环实例日程）3Exception （错误）4MeetingRequest（会议安排）
	 */
	private int instanceType;
	/**
	 * 参与人
	 */
	private String attendees = "";
	/**
	 * 参与人姓名
	 */
	private String attendeeNames = "";
	/**
	 * 其他参与人
	 */
	private String otherAttendee = "";
	/**
	 * 更新人账号
	 */
	private String upAccount = "";
	/**
	 * 更新人姓名
	 */
	private String upName = "";
	/**
	 * 最后一次更新时间
	 */
	private Date upTime = new Date(); 
	/**
	 * 循环规则
	 */
	private String recurringRule = "";
	
	public CalendarBo(String subjectName, Date startTime, Date endTime,
			int isAllDayEvent, String upName) {
		super();
		this.subjectName = subjectName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isAllDayEvent = isAllDayEvent;
		this.upName = upName;
	}
	
	public CalendarBo(int id, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public CalendarBo() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCalendarType() {
		return calendarType;
	}
	public void setCalendarType(int calendarType) {
		this.calendarType = calendarType;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getIsAllDayEvent() {
		return isAllDayEvent;
	}
	public void setIsAllDayEvent(int isAllDayEvent) {
		this.isAllDayEvent = isAllDayEvent;
	}
	public int getHasAttachment() {
		return hasAttachment;
	}
	public void setHasAttachment(int hasAttachment) {
		this.hasAttachment = hasAttachment;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getInstanceType() {
		return instanceType;
	}
	public void setInstanceType(int instanceType) {
		this.instanceType = instanceType;
	}
	public String getAttendees() {
		return attendees;
	}
	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}
	public String getAttendeeNames() {
		return attendeeNames;
	}
	public void setAttendeeNames(String attendeeNames) {
		this.attendeeNames = attendeeNames;
	}
	public String getOtherAttendee() {
		return otherAttendee;
	}
	public void setOtherAttendee(String otherAttendee) {
		this.otherAttendee = otherAttendee;
	}
	public String getUpAccount() {
		return upAccount;
	}
	public void setUpAccount(String upAccount) {
		this.upAccount = upAccount;
	}
	public String getUpName() {
		return upName;
	}
	public void setUpName(String upName) {
		this.upName = upName;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	public String getRecurringRule() {
		return recurringRule;
	}
	public void setRecurringRule(String recurringRule) {
		this.recurringRule = recurringRule;
	}
	@Override
	public String toString() {
		return "CalendarBo [id=" + id + ", subjectName=" + subjectName
				+ ", location=" + location + ", masterId=" + masterId
				+ ", description=" + description + ", calendarType="
				+ calendarType + ", startTime=" + startTime + ", endTime="
				+ endTime + ", isAllDayEvent=" + isAllDayEvent
				+ ", hasAttachment=" + hasAttachment + ", category=" + category
				+ ", instanceType=" + instanceType + ", attendees=" + attendees
				+ ", attendeeNames=" + attendeeNames + ", otherAttendee="
				+ otherAttendee + ", upAccount=" + upAccount + ", upName="
				+ upName + ", upTime=" + upTime + ", recurringRule="
				+ recurringRule + "]";
	}
	

}
