package com.dlog.diary.user.dto;

import java.util.Date;

import com.dlog.diary.common.types.UserLoginType;
import com.dlog.diary.common.types.UserSexType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserDto {
	
	@ApiModelProperty(required=true, value="사용자 ID", example="0000")
	private Integer userSequence;
	
	@ApiModelProperty(required=true, value="성별", example="FEMALE")
	private UserSexType sex;
	
	@ApiModelProperty(value="키", example="160")
	private Integer height;
	
	@ApiModelProperty(value="몸무게", example="50")
	private Integer weight;
	
	@ApiModelProperty(value="생년월일", example="2020-07-01")
	private Date birth;
	
	@ApiModelProperty(value="닉네임", example="헬린이")
	private String nickname;
	
	@ApiModelProperty(required=true, value="로그인타입", example="KAKAOTALK")
	private UserLoginType loginType;
	
	@ApiModelProperty(required=true, value="토큰", example="?")
	private String refreshToken;
	
	@ApiModelProperty(required=true, value="식별값", example="?")
	private String uniqueId;
	
	@ApiModelProperty(value="목표 몸무게", example="45")
	private Integer targetWeight;
	
	@ApiModelProperty(value="프로필 사진", example="url")
	private String profileImage;

}