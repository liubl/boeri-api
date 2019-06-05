package com.lboeri.boeriapi.util;

import java.util.HashMap;
import java.util.Map;


public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Result() {
		put("code", 200);
		put("message", "success");
	}
	
	public static Result error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static Result error(String msg) {
		return error(500, msg);
	}
	
	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("message", msg);
		return r;
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("message", msg);
		return r;
	}
	
	public static Result ok(Object resultData) {
		Result r = new Result();
		r.put("data", resultData);
		return r;
	}
	
	public static Result ok() {
		return new Result();
	}

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
