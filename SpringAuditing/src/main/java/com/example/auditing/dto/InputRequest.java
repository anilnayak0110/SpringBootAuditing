package com.example.auditing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class InputRequest<T> {
	@JsonProperty(value="userId",required=true)
	private String loogedInUser;
	private String timeZone;
	private T employee;
	public String getLoogedInUser() {
		return loogedInUser;
	}
	public void setLoogedInUser(String loogedInUser) {
		this.loogedInUser = loogedInUser;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public T getEmployee() {
		return employee;
	}
	public void setEmployee(T employee) {
		this.employee = employee;
	}
	
	
	

}
