package com.dlog.diary.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.common.dto.EnumTypeDto;
import com.dlog.diary.common.service.DlogService;

import io.swagger.annotations.Api;

@RestController
@Api("유틸 API")
public class DlogController {
	private DlogService dlogService;

	public DlogController(DlogService dlogService) {
		this.dlogService = dlogService;
	}
	
	@GetMapping("/dlog/init")
	public EnumTypeDto init() {
		return dlogService.getEnumTypeDto();
	}
}