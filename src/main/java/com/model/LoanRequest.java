package com.model;

public class LoanRequest {
	private double amount;
	private int timeInMonths;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTimeInMonths() {
		return timeInMonths;
	}
	public void setTimeInMonths(int timeInMonths) {
		this.timeInMonths = timeInMonths;
	}
}
