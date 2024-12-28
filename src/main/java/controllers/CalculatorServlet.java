package controllers;

import models.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns ={""})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameters sent in request
        String principalAmount = request.getParameter("principleamount");
        String interestPercentage = request.getParameter("interest");
        String years = request.getParameter("years");
        String compoundingPeriod = request.getParameter("compoundingperiod");
        String error;

        if(principalAmount==null|| principalAmount.isEmpty() ||interestPercentage==null|| interestPercentage.isEmpty() ||years==null||years.isEmpty()||compoundingPeriod==null || compoundingPeriod.isEmpty()){
            error="Please fill all the fields";
            request.setAttribute("error",error);
            System.out.println("Error ");
        }else{
            System.out.printf("Result: %s %s %s %s",principalAmount,interestPercentage,years,compoundingPeriod);
            double result = Utils.calculateCompoundInterest(Double.parseDouble(principalAmount),Double.parseDouble(interestPercentage),Integer.parseInt(years),Integer.parseInt(compoundingPeriod));
            request.setAttribute("principleamount",principalAmount);
            request.setAttribute("interest",interestPercentage);
            request.setAttribute("years",years);
            request.setAttribute("compoundingperiod",compoundingPeriod);
            request.setAttribute("result",result);

        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}