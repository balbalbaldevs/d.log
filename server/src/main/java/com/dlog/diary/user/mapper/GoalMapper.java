package com.dlog.diary.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dlog.diary.common.domain.user.Goal;

@Mapper
@Repository
public interface GoalMapper {
	
	List<Goal> selectGoalByUserId(String userId);
	
	int insertGoal(Goal goal);
	
	int updateGoal(Goal goal);
	
	int deleteGoalByUserId(String userId);
	
}