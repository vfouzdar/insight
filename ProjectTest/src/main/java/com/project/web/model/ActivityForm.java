package com.project.web.model;

import java.util.Date;

import com.project.entity.Activity;
import com.project.entity.ActivityType;

public class ActivityForm {
	private long id;

	private Date createDate;

	private ActivityType activityType;

	private long userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", createDate=" + createDate + "]";
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void mapActivity(Activity activity){
		setActivityType(activity.getActivityType());
		setCreateDate(activity.getCreateDate());
		setId(activity.getId());
		setUserId(activity.getUserId());
	}
}
