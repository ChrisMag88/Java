package com.servlet;

import com.controller.LoanCalculator;
import com.model.LoanRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/calculateInterest")
public class InterestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = LogManager.getLogger(InterestServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        double amount = Double.parseDouble(request.getParameter("amount"));
        String timeInMonthsStr = request.getParameter("timeInMonths");
        
        int timeInMonths = Integer.parseInt(timeInMonthsStr);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setAmount(amount);
        loanRequest.setTimeInMonths(timeInMonths);

        LocalDateTime calculationTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String today = calculationTime.format(formatter);
        
        LoanCalculator calculator = new LoanCalculator();
        double interest = calculator.calculateInterest(loanRequest);
        double totalToPay = interest + amount;
        
        logger.info("Solicitud de cálculo de interés recibida. Cantidad: {}, Tiempo: {} meses, Fecha y Hora del cálculo: {}",
                amount, timeInMonths, today);

        request.setAttribute("interest", interest);
        request.setAttribute("totalToPay", totalToPay);
        request.setAttribute("today", today);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
