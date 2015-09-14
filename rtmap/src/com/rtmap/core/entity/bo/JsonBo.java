package com.rtmap.core.entity.bo;

public class JsonBo {

	private String name;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String packageName;
	private String className;
	private boolean Annotation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isAnnotation() {
		return Annotation;
	}

	public void setAnnotation(boolean annotation) {
		Annotation = annotation;
	}

	public boolean isToString() {
		return toString;
	}

	public void setToString(boolean toString) {
		this.toString = toString;
	}

	private boolean toString;

}
