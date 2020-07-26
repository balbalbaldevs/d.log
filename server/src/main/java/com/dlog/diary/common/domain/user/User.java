package com.dlog.diary.common.domain.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.dlog.diary.common.domain.CommonDate;
import com.dlog.diary.common.types.UserLoginType;
import com.dlog.diary.common.types.UserSexType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Alias("user")
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel
public class User extends CommonDate {
	
	@ApiModelProperty(value="사용자 ID")
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
	
}