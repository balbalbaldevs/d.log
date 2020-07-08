package com.dlog.diary.user.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dlog.diary.common.domain.user.Goal;
import com.dlog.diary.common.domain.user.User;
import com.dlog.diary.common.types.GoalStateType;
import com.dlog.diary.user.dto.UserResponse;
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
	public boolean saveUser(UserResponse userResponse) {
		// TODO : SNS로그인 추가 
		User user = getUser(userResponse);
		userMapper.insertUser(user);
		
		Goal goal = getGoal(user.getUserSequence(), userResponse);
		goalMapper.insertGoal(goal);
		return true;
	}
	
	public UserResponse getUser(String userId) {
		List<Goal> goals = goalMapper.selectGoalByUserId(userId);
		
		if(ObjectUtils.isEmpty(goals)) {
			return null; // TODO : 에러처리
		}
		
		Goal goal = goals.get(0);
		User user = userMapper.selectUser(userId);
		
		if(ObjectUtils.isEmpty(user)) {
			return null; // TODO : 에러처리
		}
		
		return getUserResponse(user, goal);
	}

	// TODO Transaction 처리에 따라서 분기처리 할지 호출만 할지 정해야함.
	public boolean editUser(UserResponse userResponse) {
		User user = getUser(userResponse);
		boolean isSuccess = userMapper.updateUser(user) > 0;
		
		if(isSuccess) {
			String userId = String.valueOf(userResponse.getUserSequence());
			List<Goal> goals = goalMapper.selectGoalByUserId(userId);
			
			if(ObjectUtils.isEmpty(goals)) {
				return false; // TODO : 에러처리
			}
			
			Goal goal = goals.get(0);
			setGoal(goal, userResponse.getTargetWeight());
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
	
	private UserResponse getUserResponse(User user, Goal goal) {
		UserResponse userResponse = new UserResponse();
		
		userResponse.setUserSequence(user.getUserSequence());
		userResponse.setSex(user.getSex());
		userResponse.setHeight(user.getHeight());
		userResponse.setWeight(user.getWeight());
		userResponse.setBirth(user.getBirth());
		userResponse.setNickname(user.getNickname());
		userResponse.setLoginType(user.getLoginType());
		userResponse.setRefreshToken(user.getRefreshToken());
		userResponse.setUniqueId(user.getUniqueId());

		userResponse.setTargetWeight(goal.getTargetWeight());
		
		return userResponse;	
	}
	
	private User getUser(UserResponse userResponse) {
		User user = new User();
		
		user.setUserSequence(userResponse.getUserSequence());
		user.setSex(userResponse.getSex());
		user.setHeight(userResponse.getHeight());
		user.setWeight(userResponse.getWeight());
		user.setBirth(userResponse.getBirth());
		user.setNickname(userResponse.getNickname());
		user.setLoginType(userResponse.getLoginType());
		user.setRefreshToken(userResponse.getRefreshToken());
		user.setUniqueId(userResponse.getUniqueId());
		
		Calendar cal = Calendar.getInstance();
		user.setRegisterDate(cal.getTime());
		user.setModifyDate(cal.getTime());

		return user;	
	}
	
	private Goal getGoal(int userId, UserResponse userResponse) {
		Goal goal = new Goal();
		
		goal.setUserSequence(userId);
		goal.setTitle("목표몸무게");
		goal.setTargetWeight(userResponse.getTargetWeight());
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