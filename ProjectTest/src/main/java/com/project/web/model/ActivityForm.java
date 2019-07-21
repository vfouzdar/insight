package com.project.web.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.project.entity.Activity;
import com.project.entity.ActivityType;

public class ActivityForm {
	private long id;

	private long userId;
	
	private List<Activity> listAct = new LinkedList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public List<Activity> getListAct() {
		return listAct;
	}

	public void setListAct(List<Activity> listAct) {
		this.listAct = listAct;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Activity [id=" + id + ", createDate=" + "]";
	}

	public List<Activity> mapActivity(List<Activity> activityList){
		
		this.listAct = activityList;
		listAct.stream().sorted();
		return listAct;
	}
}
