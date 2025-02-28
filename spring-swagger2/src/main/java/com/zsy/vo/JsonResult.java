package com.zsy.vo;

public class JsonResult {
	// 状态
	private String status = null;
	// 结果
	private Object result = null;

	public JsonResult() {
	}

	public JsonResult(String status) {
		this.status = status;
	}

	public JsonResult(String status, Object result) {
		this.status = status;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
