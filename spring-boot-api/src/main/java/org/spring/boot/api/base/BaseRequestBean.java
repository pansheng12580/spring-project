package org.spring.boot.api.base;

import java.io.Serializable;

public class BaseRequestBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String code;
	public String msg;
	
	public BaseRequestBean(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "BaseRequestBean [code=" + code + ", msg=" + msg + "]";
	}

}
