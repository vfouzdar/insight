package com.project.entity;

public enum ActivityType {
	LOGIN("login"), REGISTER("register"), EDIT("edit"), LOGOUT("logout");

	private String activityType;

	public String getActivityType() {
		return activityType;
	}

	 ActivityType(String activityType) {
		this.activityType = activityType;
	}
}
