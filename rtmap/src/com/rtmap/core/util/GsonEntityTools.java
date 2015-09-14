package com.rtmap.core.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GsonEntityTools  {
	


	/** 包名 */
	private String packageName;

	/** 默认java名 */
	private String javaName="JSONEntity";
	/** 类型名 */
	private String className="JSONEntity";

	/** 生成的文件的路径名 */
	private String filepath;

	/** 是否实现序列化 */
	private boolean isSerializable =true;

	

	private String json;

	/** 用于拼接字符串 */
	private StringBuffer sb;
	
	public boolean isAnnotation=false;
	private boolean isToString = false;

	public String commit() throws Exception {

		return main();

	}

	public GsonEntityTools() {
		super();
//		this.setJavaName("Data")
//		.setPackageName("test")
////	.setToString(true)
//		.setSerializable(true);
	}

	public GsonEntityTools(String json) {
		super();
		this.json = json;
	}

	private String main() throws IOException, JSONException,
			IllegalAccessException, InstantiationException {
		// if (sb != null) {
		// return sb.toString();
		// }

		sb = new StringBuffer();
		className = javaName;
		if (packageName != null)
			sb.append("package " + packageName + ";");
		sb.append("\n");
		sb.append("import java.lang.reflect.Field;");
		sb.append("\n");
		sb.append("import java.io.Serializable;");
		sb.append("\n");
		sb.append("import java.util.List;");
		sb.append("\n");
		JSONObject obj = new JSONObject(json);
		root(obj);// 递归json
		System.out.println(sb);

		if (filepath != null) {
			FileOutputStream out = new FileOutputStream(filepath + javaName
					+ ".java");
			PrintWriter writer = new PrintWriter(out);

			writer.write(sb.toString());
			writer.flush();
			writer.close();
		}
		return sb.toString();

	}

	public GsonEntityTools setAnnotation(boolean isAnnotation) {
		this.isAnnotation = isAnnotation;
		return this;
	}

	/** 递归json 如果该节点是JSONObject则生成类 */
	public void root(JSONObject obj) throws JSONException {
		if (isAnnotation) {
			sb.append("@Table(name =\""+initcap(className)+"\")");
			sb.append("\n");
		}
		sb.append("public class " + initcap(className) + " "
				+ (isSerializable ? "implements Serializable " : "") + " {");
		
		sb.append("\n");
		List<String> list = getSort(obj);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object value = obj.get(key);
			if (value instanceof JSONObject) {
				/** 如果子字段是一个JSONObject递归生成类 */
				className = key;
				sb.append("\n");
				sb.append("public  " + initcap(className) + " " + className
						+ ";");
				sb.append("\n");

				root((JSONObject) value);
			} else if (value instanceof JSONArray) {
				/** 生成List 和JSONArray 中的类 */
				array(key, (JSONArray) value);
			} else {

				field(key, value);
				/** 遍历字段 */

			}

		}
		if (isToString) {
			writeToString();
		}
	

		sb.append("\n");
		sb.append("}");
	}

	/**
	 * 排序字段
	 * */
	public List<String> getSort(JSONObject obj) throws JSONException {
		List<String> list_field = new ArrayList<String>();
		List<String> list_class = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		Iterator<String> it = obj.keys();
		while (it.hasNext()) {
			String key = it.next();
			Object value = obj.get(key);
			if (value instanceof JSONObject) {
				list_class.add(key);
			} else if (value instanceof JSONArray) {
				list_class.add(key);
			} else {
				list_field.add(key);
			}
		}
		list_field.addAll(list_class);
		return list_field;
	}

	public void field(String key, Object value) {

		sb.append("\n");
		if (isAnnotation) {
			sb.append("@Column(column =\"" + key + "\")");
			sb.append("\n");
		}
		sb.append("public ");
		if (value instanceof Integer) {
			sb.append("int");
		} else if (value==JSONObject.NULL) {
			sb.append("String");
		} else {
			sb.append(value.getClass().getSimpleName());
		}
		sb.append(" ");
		sb.append(key);
		sb.append("  ;");
		;

	}

	public void array(String key, JSONArray value) throws JSONException {

		sb.append("public ");
		sb.append("List<" + initcap(key) + ">");
		sb.append(" ");
		sb.append(key);
		sb.append(";");
		// sb.append("= new ArrayList();");
		sb.append("\n");
		if (value.length() >= 1) {
			Object obj = value.get(0);

			if (obj instanceof JSONObject) {
				className = key;
				root((JSONObject) obj);
			} else if (obj instanceof JSONArray) {
				// className = key;
				// array(className,(JSONArray)obj);
			}
		} else {
			className = key;
			sb.append("public class " + initcap(className) + " {");
			sb.append("\n");
			sb.append("\n");
			if (this.isToString) {
				writeToString();
			}
			sb.append("}");
		}
		sb.append("\n");
	}

	private void writeToString() {
		// TODO Auto-generated method stub
		if (this.isToString) {
			sb.append("\n@Override" + "\n");
			sb.append("public String toString() {" + "\n");
			String str = "String s = \"\";Field[] arr = this.getClass().getFields();for (Field f : getClass().getFields()) {try {s += f.getName() + \"=\" + f.get(this) + \"\\n,\";} catch (Exception e) {}}return getClass().getSimpleName() + \"[\" + (arr.length==0?s:s.substring(0, s.length() - 1)) + \"]\";";
			sb.append(str);
			sb.append("\n");
			sb.append("}");
		}
	}

	/**
	 * 把输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		if(str==null)return "null";
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public GsonEntityTools setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	public GsonEntityTools setJavaName(String javaName) {
		this.javaName = javaName;
		return this;
	}

	public GsonEntityTools setFilepath(String filepath) {
		this.filepath = filepath;
		return this;
	}

	public GsonEntityTools setToString(boolean isToString) {
		this.isToString = isToString;
		return this;
	}

	public GsonEntityTools setSerializable(boolean isSerializable) {
		this.isSerializable = isSerializable;
		return this;
	}


	public void setClassName(String className) {
		this.className = className;
	}

}