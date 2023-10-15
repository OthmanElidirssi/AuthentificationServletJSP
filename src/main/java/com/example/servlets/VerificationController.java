package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/Verify")
public class VerificationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer code=Integer.parseInt(req.getParameter("code"));
        Integer otp= (Integer) req.getSession().getAttribute("otp");

        if(code.compareTo(otp)==0){
            resp.sendRedirect("UpdatePassword.jsp");
        }else{
            req.setAttribute("message","code invalide");
            req.getRequestDispatcher("EnterCode.jsp").forward(req,resp);
        }

    }
}
