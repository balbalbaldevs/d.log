package com.dlog.diary.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dlog.diary.common.domain.user.User;

@Mapper
@Repository
public interface UserMapper {
	
	User selectUser(String userId);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(String userId);
	
}