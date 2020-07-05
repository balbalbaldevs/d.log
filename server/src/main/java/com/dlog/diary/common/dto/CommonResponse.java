package com.dlog.diary.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CommonResponse {
	@ApiModelProperty(required = true, value = "결과 코드", example = "201")
	private int code;
	@ApiModelProperty(required = true, value = "결과 메세지", example = "등록되었습니다.")
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
