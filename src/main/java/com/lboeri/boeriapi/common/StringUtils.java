// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
package com.lboeri.boeriapi.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.Assert;

import java.util.*;

public class StringUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final int INDEX_NOT_FOUND = -1;

	public static String ucase(String str) {
		if (str == null)
			return null;
		else
			return str.toUpperCase();
	}

	public static String lcase(String str) {
		if (str == null)
			return null;
		else
			return str.toLowerCase();
	}

	public static String trim(String str) {
		return str != null ? str.trim() : null;
	}

	public static String ltrim(String str) {
		if (str == null)
			return null;
		int i;
		for (i = 0; i < str.length() && Character.isWhitespace(str.charAt(i)); i++);
		return str.substring(i);
	}

	public static String rtrim(String str) {
		if (str == null)
			return null;
		int i;
		for (i = str.length() - 1; i > -1 && Character.isWhitespace(str.charAt(i)); i--);
		return str.substring(0, i + 1);
	}

	public static String substring(String str, int beginIndex, int length) {
		if (str == null)
			return null;
		if (beginIndex >= str.length())
			return "";
		if (beginIndex + length < str.length())
			return str.substring(beginIndex, beginIndex + length);
		else
			return str.substring(beginIndex);
	}

	public static String left(String str, int length) {
		if (str == null)
			return null;
		if (length < 0)
			return "";
		if (length < str.length())
			return str.substring(0, length);
		else
			return str;
	}

	public static String right(String str, int length) {
		if (str == null)
			return null;
		if (length < 0)
			return "";
		if (length < str.length())
			return str.substring(str.length() - length);
		else
			return str;
	}

//	public static transient String concat(String strs[]) {
//		StringBuffer sb = new StringBuffer();
//		if (strs != null) {
//			int i = 0;
//			for (int len = strs.length; i < len; i++)
//				sb.append(strs[i]);
//
//		}
//		return sb.toString();
//	}

	public static String lpad(String str, int length, String padstr) {
		if (str == null || length < 0)
			return str;
		int len = length - str.length();
		if (len > 0) {
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < len; i++)
				sb.insert(0, padstr);

			return sb.toString();
		}
		if (len == 0)
			return str;
		else
			return str.substring(0, length);
	}

	public static String lpad(String str, int length) {
		return lpad(str, length, " ");
	}

	public static String rpad(String str, int length, String padstr) {
		if (str == null || length < 0)
			return str;
		int len = length - str.length();
		if (len > 0) {
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < len; i++)
				sb.append(padstr);

			return sb.toString();
		}
		if (len == 0)
			return str;
		else
			return str.substring(0, length);
	}

	public static String rpad(String str, int length) {
		return rpad(str, length, " ");
	}

	public static int indexOf(String str, String substring) {
		if (str == null || substring == null)
			return -1;
		else
			return str.indexOf(substring);
	}

	public static boolean contains(String str, String substring) {
		return indexOf(str, substring) != -1;
	}

	public static boolean containsIgnoreCase(String str, String substring) {
		str = ucase(str);
		substring = ucase(substring);
		return contains(str, substring);
	}

	public static boolean startsWith(String str, String prefix) {
		if (str == null || prefix == null)
			return false;
		else
			return str.startsWith(prefix);
	}

	public static boolean endsWith(String str, String suffix) {
		if (str == null || suffix == null)
			return false;
		else
			return str.endsWith(suffix);
	}

	public static String substringAfter(String str, String substring) {
		if (str == null || str.length() == 0 || substring == null || substring.length() == 0)
			return str;
		int index = str.indexOf(substring);
		if (index == -1)
			return null;
		else
			return str.substring(index + substring.length());
	}

	public static String substringBefore(String str, String substring) {
		if (str == null || str.length() == 0 || substring == null || substring.length() == 0)
			return str;
		int index = str.indexOf(substring);
		if (index == -1)
			return null;
		else
			return str.substring(0, index);
	}

	public static String replace(String str, String substring, String replacement) {
		return str.replace(substring, replacement);
	}

	public static String[] split(String str, String regex) {
		return str.split(regex);
	}

	public static String uuid() {
		String uuidString = UUID.randomUUID().toString();
		return (new StringBuilder()).append(uuidString.substring(0, 8)).append(uuidString.substring(9, 13))
				.append(uuidString.substring(14, 18)).append(uuidString.substring(19, 23))
				.append(uuidString.substring(24)).toString();
	}

	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isNotEmpty(CharSequence cs) {
		return !isEmpty(cs);
	}

	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(cs.charAt(i)))
				return false;

		return true;
	}

	public static boolean isNotBlank(CharSequence cs) {
		return !isBlank(cs);
	}

//	public static transient boolean equals(String str, String equalsStrs[]) {
//		Assert.notNull(equalsStrs, "equalsStrs must not be null");
//		if (equalsStrs.length > 0) {
//			String arr$[] = equalsStrs;
//			int len$ = arr$.length;
//			for (int i$ = 0; i$ < len$; i$++) {
//				String equalsStr = arr$[i$];
//				if (equalsStr.equals(str))
//					return true;
//			}
//
//		}
//		return false;
//	}

	public static String strip(String str, String stripChars) {
		return StringUtils.strip(str, stripChars);
	}

	public static String stripStart(String str, String stripChars) {
		return StringUtils.stripStart(str, stripChars);
	}

	public static String stripEnd(String str, String stripChars) {
		return StringUtils.stripEnd(str, stripChars);
	}

	public static int indexOf(String str, String searchStr, String afterStr) {
		if (str == null || searchStr == null)
			return -1;
		if (afterStr == null || afterStr.length() == 0 || str.indexOf(afterStr) == -1)
			return str.indexOf(searchStr);
		if (str.indexOf(afterStr) > str.indexOf(searchStr))
			return str.indexOf(searchStr);
		else
			return -1;
	}

	public static int lastIndexOf(String str, String searchStr, String afterStr) {
		if (str == null || searchStr == null)
			return -1;
		if (afterStr == null || afterStr.length() == 0 || str.lastIndexOf(afterStr) == -1)
			return str.lastIndexOf(searchStr);
		if (str.lastIndexOf(afterStr) < str.lastIndexOf(searchStr))
			return str.lastIndexOf(searchStr);
		else
			return -1;
	}

	public static String substringBeforeLast(String str, String separator) {
		return StringUtils.substringBeforeLast(str, separator);
	}

	public static String substringAfterLast(String str, String separator) {
		return StringUtils.substringAfterLast(str, separator);
	}

	public static String substringBetween(String str, String tag) {
		return StringUtils.substringBetween(str, tag);
	}

	public static String substringBetween(String str, String open, String close) {
		return StringUtils.substringBetween(str, open, close);
	}

	public static String[] substringsBetween(String str, String open, String close) {
		return StringUtils.substringsBetween(str, open, close);
	}

	public static String replaceBetween(String str, String open, String close, String replacement) {
		if (str == null || isEmpty(open) || isEmpty(close))
			return null;
		int strLen = str.length();
		if (strLen == 0)
			return str;
		int openLen = open.length();
		int closeLen = close.length();
		StringBuffer sb = new StringBuffer();
		int pos;
		int end;
		for (pos = 0; pos < strLen - closeLen; pos = end + closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0)
				break;
			start += openLen;
			end = str.indexOf(close, start);
			if (end < 0)
				break;
			sb.append(str.substring(pos, start - openLen));
			String content = str.substring(start, end);
			if (isNotBlank(content))
				sb.append(replacement);
		}

		sb.append(str.substring(pos));
		return sb.toString();
	}

	public static String replaceBetween(String str, String open, String close, Map replacement) {
		if (str == null || isEmpty(open) || isEmpty(close))
			return null;
		int strLen = str.length();
		if (strLen == 0)
			return str;
		Assert.notNull(replacement, "replacement must not be null");
		//EasyScriptContext scriptContext = escript.getScriptContext(replacement);
		int openLen = open.length();
		int closeLen = close.length();
		StringBuffer sb = new StringBuffer();
		int pos;
		int end;
		for (pos = 0; pos < strLen - closeLen; pos = end + closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0)
				break;
			start += openLen;
			end = str.indexOf(close, start);
			if (end < 0)
				break;
			sb.append(str.substring(pos, start - openLen));
			String exception = str.substring(start, end);
//			if (isNotBlank(exception))
//				sb.append(escript.evaluateScript(exception, scriptContext));
		}

		sb.append(str.substring(pos));
		return sb.toString();
	}

	public static String replaceAndsubstringsBetween(String str, String open, String close, String replacement,
			List substrings) {
		if (str == null || isEmpty(open) || isEmpty(close))
			return null;
		int strLen = str.length();
		if (strLen == 0)
			return str;
		Assert.notNull(substrings, "substrings must not be null");
		substrings.clear();
		int openLen = open.length();
		int closeLen = close.length();
		StringBuffer sb = new StringBuffer();
		int pos;
		int end;
		for (pos = 0; pos < strLen - closeLen; pos = end + closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0)
				break;
			start += openLen;
			end = str.indexOf(close, start);
			if (end < 0)
				break;
			sb.append(str.substring(pos, start - openLen));
			String content = str.substring(start, end);
			if (isNotBlank(content)) {
				sb.append(replacement);
				substrings.add(content);
			}
		}

		sb.append(str.substring(pos));
		return sb.toString();
	}

	public static Map str2map(String input, String marker, String delimiter) {
		if (input == null || input.length() == 0)
			input = null;
		Map map = new HashMap();
		String keyValues[] = input.trim().split(delimiter);
		String arr$[] = keyValues;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			String keyValue = arr$[i$];
			map.put(keyValue.substring(0, keyValue.indexOf(marker)).trim(),
					keyValue.substring(keyValue.indexOf(marker) + 1).trim());
		}

		return map;
	}

	public static boolean hasLength(CharSequence str) {
		return str != null && str.length() > 0;
	}

	public static boolean hasLength(String str) {
		return hasLength(((CharSequence) (str)));
	}

	public static boolean hasText(CharSequence str) {
		if (!hasLength(str))
			return false;
		int strLen = str.length();
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return true;

		return false;
	}

	public static boolean hasText(String str) {
		return hasText(((CharSequence) (str)));
	}

	public static void main(String args[]) {
		List list = new ArrayList();
		String a = "${name} www ${pwd} ee ${age} 11}";
		Map map = new HashMap();
		map.put("name", "zfd");
		map.put("pwd", "123pwd");
		map.put("age", Integer.valueOf(25));
		String strs = replaceBetween(a, "${", "}", map);
		System.out.println(strs);
		String sqlsta = "select user_no,area_no,city_no from user info where area_no=#area# %[and city_no=#age#}and acct_date=#pwd#}";
		//EasyScript escript = new EasyScript();
		//EasyScriptContext context = escript.getScriptContext(map);
		List conditionalExpressions = new ArrayList();
		String sql = replaceAndsubstringsBetween(sqlsta, "#", "#", "$sqlConditionalExpression", conditionalExpressions);
		String str;
		for (Iterator i$ = conditionalExpressions.iterator(); i$.hasNext(); System.out.println(str))
			str = (String) i$.next();

		System.out.println(sql);
	}

}