package com.dlog.diary.user;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.common.dto.CommonResponse;
import com.dlog.diary.common.types.UnitType;
import com.dlog.diary.common.types.UserLoginType;
import com.dlog.diary.common.types.UserSexType;
import com.dlog.diary.user.dto.UserDto;
import com.dlog.diary.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("사용자 API")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users/{userId}")
	@ApiOperation(value = "사용자 조회", notes = "사용자 조회")
	public UserDto getUser(
			@ApiParam(name = "userId", value = "사용자 ID", required = true, example = "1") @PathVariable("userId") String userId) {
		// TODO transfer user to response
		// TODO logging response
		
		// TODO 값이 없을 경우 적절한 에러메시지 내려주기
		
		return userService.getUser(userId);
	}

	@PostMapping("/users")
	@ApiOperation(value = "사용자 생성", notes = "사용자 생성")
	public CommonResponse saveUser(@RequestBody UserDto userDto) {
		// TODO transfer userResonse to userRequest
		// TODO logging request
		boolean isSuccess = userService.saveUser(userDto);
		CommonResponse response = new CommonResponse();
		if (isSuccess) {
			response.ok(201, "등록 되었습니다.");
		} else {
			response.fail(500, "등록이 실패되었습니다.");
		}
		return response;
	}

	@PutMapping("/users/{userId}")
	@ApiOperation(value = "사용자 수정", notes = "사용자 수정")
	public CommonResponse eidtUser(@RequestBody UserDto userDto) {
		// TODO transfer userResonse to userRequest
		// TODO logging request
		boolean isSuccess = userService.editUser(userDto);
		CommonResponse response = new CommonResponse();
		if (isSuccess) {
			response.ok();
		} else {
			response.fail(500, "수정이 실패되었습니다.");
		}
		return response;
	}

	@DeleteMapping("/users/{userId}")
	@ApiOperation(value = "사용자 삭제", notes = "사용자 삭제")
	public CommonResponse removeUser(
			@ApiParam(name = "userId", value = "사용자 ID", required = true, example = "1") @PathVariable("userId") String userId) {

		boolean isSuccess = userService.removeUser(userId);
		CommonResponse response = new CommonResponse();
		if (isSuccess) {
			response.ok();
		} else {
			response.fail(500, "삭제가 실패되었습니다.");
		}
		return response;
	}
	
	@ModelAttribute
	public void setEnumTypes(Model model) {
		//다른 controller에서도 사용할수있게 ControllerAdvice 사용으로 고치기
	    model.addAttribute("UserSexTypes", UserSexType.values());
	    model.addAttribute("UserLoginTypes", UserLoginType.values());
	    model.addAttribute("UnitTypes", UnitType.values());
	}

}