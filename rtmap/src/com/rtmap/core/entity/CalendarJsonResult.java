package com.rtmap.core.entity;

public class CalendarJsonResult {
	
	private String start;
	
	private String end;
	
	private String error;
	
	private boolean issort = true;
	
	private Object events;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isIssort() {
		return issort;
	}

	public void setIssort(boolean issort) {
		this.issort = issort;
	}

	public Object getEvents() {
		return events;
	}

	public void setEvents(Object events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "CalendarJsonResult [start=" + start + ", end=" + end
				+ ", error=" + error + ", issort=" + issort + ", events="
				+ events + "]";
	}
	
}
