package com.example.servlets;

import com.example.HibernateUtil;
import com.example.entities.Client;
import com.example.services.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/Register")
public class RegisterController extends HttpServlet {

    ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService=new ClientService(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom=req.getParameter("nom");
        String prenom=req.getParameter("prenom");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String date=req.getParameter("date");

        Client client=new Client(email,password,nom,prenom,parseDate(date));
        try {
            clientService.create(client);
            resp.sendRedirect("Auth.jsp");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try {
            d = dateFormat.parse(date);
            System.out.println("Parsed Date: " + date);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return d;
    }

}
