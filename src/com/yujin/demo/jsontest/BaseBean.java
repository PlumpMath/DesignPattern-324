package com.yujin.demo.jsontest;

public abstract class BaseBean<T> {
	private int code;
	private String msg;
	private T data;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccessful() {
		return code == 200 ? true : false;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "[" + "code:" + code + " msg: " + msg + " data: " + data + "]";
	}
}
