package com.example.servlets;

import com.example.HibernateUtil;
import com.example.entities.Client;
import com.example.entities.User;
import com.example.services.ClientService;
import com.example.utility.PasswodUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = "/Authentication")
public class AuthController extends HttpServlet {

    ClientService clientService;

    @Override
    public void init() throws ServletException {
        clientService=new ClientService(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String passwrod=req.getParameter("password");
        Client client=clientService.getBasedOnLogin(email);
        if(client==null){
            resp.sendRedirect("Auth.jsp");
            return;

        }
        try {
            boolean isPasswordValid=validatePassword(client,passwrod);

            if(isPasswordValid){

                registerClientData(req,client);
                resp.sendRedirect("ClientWelcome.jsp");
            }
            else{
                resp.sendRedirect("Auth.jsp");
            }


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean validatePassword(Client o,String password) throws NoSuchAlgorithmException {
        return  o.getPassword().equals(PasswodUtility.MD5(password));
    }
    public void registerClientData(HttpServletRequest request,Client o){

        HttpSession session=request.getSession();

        session.setAttribute("client",o);

    }

}
