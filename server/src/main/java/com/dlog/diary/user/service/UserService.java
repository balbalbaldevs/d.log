package com.dlog.diary.user.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dlog.diary.common.domain.user.Goal;
import com.dlog.diary.common.domain.user.User;
import com.dlog.diary.common.types.GoalStateType;
import com.dlog.diary.common.types.UnitType;
import com.dlog.diary.user.dto.UserDto;
import com.dlog.diary.user.mapper.GoalMapper;
import com.dlog.diary.user.mapper.UserMapper;

@Service
public class UserService {
	
	private UserMapper userMapper;
	
	private GoalMapper goalMapper;

	public UserService(UserMapper userMapper, GoalMapper goalMapper) {
		this.userMapper = userMapper;
		this.goalMapper = goalMapper;
	}
	
	// TODO Transaction 
	public boolean saveUser(UserDto userDto) {
		// TODO : SNS로그인 추가 
		User user = getUser(userDto);
		userMapper.insertUser(user);
		
		Goal goal = getGoal(user.getUserSequence(), userDto);
		goalMapper.insertGoal(goal);
		return true;
	}
	
	public UserDto getUser(String userId) {
		List<Goal> goals = goalMapper.selectGoalByUserId(userId);
		
		if(ObjectUtils.isEmpty(goals)) {
			return null; // TODO : 에러처리
		}
		
		Goal goal = goals.get(0);
		User user = userMapper.selectUser(userId);
		
		if(ObjectUtils.isEmpty(user)) {
			return null; // TODO : 에러처리
		}
		
		return getUserDto(user, goal);
	}

	// TODO Transaction 처리에 따라서 분기처리 할지 호출만 할지 정해야함.
	public boolean editUser(UserDto userDto) {
		User user = getUser(userDto);
		boolean isSuccess = userMapper.updateUser(user) > 0;
		
		if(isSuccess) {
			String userId = String.valueOf(userDto.getUserSequence());
			List<Goal> goals = goalMapper.selectGoalByUserId(userId);
			
			if(ObjectUtils.isEmpty(goals)) {
				return false; // TODO : 에러처리
			}
			
			Goal goal = goals.get(0);
			setGoal(goal, userDto.getTargetWeight());
			isSuccess = goalMapper.updateGoal(goal) > 0;
		}
		
		return isSuccess;
	}

	// TODO Transaction 처리에 따라서 분기처리 할지 호출만 할지 정해야함.
	public boolean removeUser(String userId) {
		List<Goal> goals = goalMapper.selectGoalByUserId(userId);
		
		int result = goalMapper.deleteGoalByUserId(userId);
		boolean isSuccess = (result == goals.size());
		if (isSuccess) {
			isSuccess = userMapper.deleteUser(userId) > 0;
		}
		return isSuccess;
	}
	
	private UserDto getUserDto(User user, Goal goal) {
		UserDto userDto = new UserDto();
		
		userDto.setUserSequence(user.getUserSequence());
		userDto.setSex(user.getSex());
		userDto.setHeight(user.getHeight());
		userDto.setHeightUnit(UnitType.CM);
		userDto.setWeight(user.getWeight());
		userDto.setWeightUnit(UnitType.KG);
		userDto.setBirth(user.getBirth());
		userDto.setNickname(user.getNickname());
		userDto.setLoginType(user.getLoginType());
		userDto.setRefreshToken(user.getRefreshToken());
		userDto.setUniqueId(user.getUniqueId());

		userDto.setTargetWeight(goal.getTargetWeight());
		
		return userDto;	
	}
	
	private User getUser(UserDto userDto) {
		User user = new User();
		
		user.setUserSequence(userDto.getUserSequence());
		user.setSex(userDto.getSex());
		user.setHeight(userDto.getHeight());
		user.setWeight(userDto.getWeight());
		user.setBirth(userDto.getBirth());
		user.setNickname(userDto.getNickname());
		user.setLoginType(userDto.getLoginType());
		user.setRefreshToken(userDto.getRefreshToken());
		user.setUniqueId(userDto.getUniqueId());
		
		Calendar cal = Calendar.getInstance();
		user.setRegisterDate(cal.getTime());
		user.setModifyDate(cal.getTime());

		return user;	
	}
	
	private Goal getGoal(int userId, UserDto userDto) {
		Goal goal = new Goal();
		
		goal.setUserSequence(userId);
		goal.setTitle("목표몸무게");
		goal.setTargetWeight(userDto.getTargetWeight());
		goal.setState(GoalStateType.PAUSED);
		
		Calendar cal = Calendar.getInstance();
		goal.setStartDate(cal.getTime());
		goal.setEndDate(cal.getTime());
		
		goal.setRegisterDate(cal.getTime());
		goal.setModifyDate(cal.getTime());
		
		return goal;	
	}
	
	private void setGoal(Goal goal, int targetWeight) {
		goal.setTargetWeight(targetWeight);
		
		Calendar cal = Calendar.getInstance();
		goal.setModifyDate(cal.getTime());
	}
	
}