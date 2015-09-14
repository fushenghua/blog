package com.rtmap.core.util;

public class Main {
	private static final String[] layoutFiles = { "./src/s.xml",
			"./res/report.xml" };

	public static void main(String[] args) {
//		if (args != null) {
//			for (int i = 0; i < args.length; i++) {
//				System.out.println("");
//
//				System.out.println("---------" + args[i] + "----------");
//				System.out.println(ViewCodeUtil.getCode(args[i]));
//			}
//		}
//
//		for (int i = 0; i < layoutFiles.length; i++) {
//			System.out.println("");
//
//			System.out.println("//---------" + layoutFiles[i] + "----------");
//			System.out.println(ViewCodeUtil.getCode(layoutFiles[i]));
//		}
		String str="";
		System.out.println(ViewCodeUtil.getCode(str));
	}
}
