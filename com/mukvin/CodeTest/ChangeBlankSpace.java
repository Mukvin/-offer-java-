package com.mukvin.CodeTest;

public class ChangeBlankSpace {

	public static String replaceSpace(StringBuffer str) {
		for (int k = 0; k < str.length(); k++) {
			char index = str.charAt(k);
			if (index == ' ') {
				str.replace(k, k + 1, "%20");
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		// StringBuilder str = new StringBuilder("We are happy.");
		StringBuffer str = new StringBuffer("We are happy.");
		//String str = "We are happy.";
		System.out.println(replaceSpace(str));// We%20are%20happy.
	}

}
