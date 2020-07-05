package com.dlog.diary.common.dto;

import lombok.Data;

@Data
public class CommonResponse {
	private int code;
	private String message;

	public void fail(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public void ok() {
		this.code = 200;
		this.message = "Success.";
	}

	public void ok(String message) {
		this.code = 200;
		this.message = message;
	}

	public void ok(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
