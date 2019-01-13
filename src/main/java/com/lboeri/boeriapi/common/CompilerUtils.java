package com.lboeri.boeriapi.common;

import jdk.nashorn.internal.runtime.ParserException;
import org.springframework.util.StringUtils;

import java.util.Stack;

public class CompilerUtils {

	public static int regionMatching(String script) {
		char characters[] = script == null ? null : script.toCharArray();
		if (characters != null) {
			Stack stack = new Stack();
			int i = 0;
			for (int len = characters.length; i < len; i++) {
				if (characters[i] == '(' || characters[i] == '[' || characters[i] == '{') {
					if (stack.isEmpty() || characters[((Integer) stack.peek()).intValue()] != '"'
							&& characters[((Integer) stack.peek()).intValue()] != '\'')
						stack.push(Integer.valueOf(i));
					continue;
				}
				if (characters[i] == ')') {
					if (stack.isEmpty())
						return i + 1;
					if (characters[((Integer) stack.peek()).intValue()] == '(') {
						stack.pop();
						continue;
					}
					if (characters[((Integer) stack.peek()).intValue()] != '"'
							&& characters[((Integer) stack.peek()).intValue()] != '\'')
						return i + 1;
					continue;
				}
				if (characters[i] == ']') {
					if (stack.isEmpty())
						return i + 1;
					if (characters[((Integer) stack.peek()).intValue()] == '[') {
						stack.pop();
						continue;
					}
					if (characters[((Integer) stack.peek()).intValue()] != '"'
							&& characters[((Integer) stack.peek()).intValue()] != '\'')
						return i + 1;
					continue;
				}
				if (characters[i] == '}') {
					if (stack.isEmpty())
						return i + 1;
					if (characters[((Integer) stack.peek()).intValue()] == '{') {
						stack.pop();
						continue;
					}
					if (characters[((Integer) stack.peek()).intValue()] != '"'
							&& characters[((Integer) stack.peek()).intValue()] != '\'')
						return i + 1;
					continue;
				}
				if (characters[i] == '"') {
					if (stack.isEmpty() || characters[((Integer) stack.peek()).intValue()] != '"'
							&& characters[((Integer) stack.peek()).intValue()] != '\'') {
						stack.push(Integer.valueOf(i));
						continue;
					}
					if (characters[((Integer) stack.peek()).intValue()] == '"')
						stack.pop();
					continue;
				}
				if (characters[i] != '\'')
					continue;
				if (stack.isEmpty() || characters[((Integer) stack.peek()).intValue()] != '"'
						&& characters[((Integer) stack.peek()).intValue()] != '\'') {
					stack.push(Integer.valueOf(i));
					continue;
				}
				if (characters[((Integer) stack.peek()).intValue()] == '\'')
					stack.pop();
			}

			if (!stack.isEmpty())
				return ((Integer) stack.peek()).intValue() + 1;
		}
		return 0;
	}

	public static String replaceBetween(String str, String open, String close, Replacement replacement)
			throws Exception {
		if (str == null || StringUtils.isEmpty(open) || StringUtils.isEmpty(close))
			return null;
		int strLen = str.length();
		if (strLen == 0)
			return str;
		int openLen = open.length();
		int closeLen = close.length();
		StringBuffer sb = new StringBuffer();
		int pos = 0;
		int index = 0;
		do {
			if (pos >= strLen - closeLen)
				break;
			int start = str.indexOf(open, pos);
			if (start < 0)
				break;
			start += openLen;
			int end = str.indexOf(close, start);
			if (end < 0)
				break;
			sb.append(str.substring(pos, start - openLen));
			String content = str.substring(start, end);
			sb.append(replacement.parse(++index, start - openLen, end, content));
			//sb.append(content);
			pos = end + closeLen;
		} while (true);
		sb.append(str.substring(pos));
		return sb.toString();
	}

	public static void main(String args[]) {
		String str = "%{bcde}%{fg}h\\\"%{i}'jk";
		try {
			String ss = replaceBetween(str, "%{", "}", new Replacement() {

				public String parse(int index, int start, int end, String snippet) {
					System.out.println((new StringBuilder()).append(start).append(":").append(end).toString());
					return (new StringBuilder()).append("\"+").append(snippet).append("+\"").toString();
				}

			});
			System.out.println(ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}