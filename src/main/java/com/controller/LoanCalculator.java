package com.controller;

import com.model.LoanRequest;

public class LoanCalculator {
    public double calculateInterest(LoanRequest loanRequest) {
        double annual_interest = 0.15;
        double days = loanRequest.getTimeInMonths() * 30;
        double interest = loanRequest.getAmount() * annual_interest / 360 * days;
        return interest;
    }
}
