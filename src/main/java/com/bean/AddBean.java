package com.bean;

import jakarta.validation.constraints.NotNull;

public class AddBean {

	@NotNull(message = "Please input number 1")
	private Integer n1;
	
	@NotNull(message = "Please input number 2")
	private Integer n2;

	private String choice;

	public Integer getN1() {
		return n1;
	}

	public void setN1(Integer n1) {
		this.n1 = n1;
	}

	public Integer getN2() {
		return n2;
	}

	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

}
