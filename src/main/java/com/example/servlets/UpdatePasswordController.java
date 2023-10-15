package com.example.servlets;

import com.example.HibernateUtil;
import com.example.entities.Client;
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


@WebServlet(urlPatterns = "/updatePassword")
public class UpdatePasswordController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService=new ClientService(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password=req.getParameter("password");
        String passwordcnf=req.getParameter("passwordcnf");

        if(passwordcnf==null || password==null|| password.equals("")||passwordcnf.equals((""))) {
            req.setAttribute("message", "The passwords can't be empty");
            req.getRequestDispatcher("UpdatePassword.jsp").forward(req, resp);
        }

        if(passwordcnf.equals(password)){

            Client client=clientService.getBasedOnLogin((String)req.getSession().getAttribute("email"));
            try {
                System.out.println(client);
                String hashedPassword= PasswodUtility.MD5(password);
                client.setPassword(hashedPassword);
                clientService.update(client);
                req.getSession().invalidate();
                resp.sendRedirect("Auth.jsp");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            req.setAttribute("message", "The passwords don't match");
            req.getRequestDispatcher("UpdatePassword.jsp").forward(req, resp);
        }
    }


}
