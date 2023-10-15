package com.example.servlets;

import com.example.HibernateUtil;
import com.example.services.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService=new ClientService(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email").trim();
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        if(email!=null && !email.equals("") && clientService.getBasedOnLogin(email)!=null) {
            // sending otp
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props,  new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("elidrissiothman355@gmail.com", "irlloypzyprxpkza");
                }
            });
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Hello");
                message.setText("your code is: " + otpvalue);
                // send message
                Transport.send(message);
                System.out.println("message sent successfully");
            }

            catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            dispatcher = request.getRequestDispatcher("EnterCode.jsp");
            request.setAttribute("message","The code is sent to your email");
            //request.setAttribute("connection", con);
            mySession.setAttribute("otp",otpvalue);
            mySession.setAttribute("email",email);
            dispatcher.forward(request, response);
            //request.setAttribute("status", "success");
        }else {
            dispatcher=request.getRequestDispatcher("Mpob.jsp");
            request.setAttribute("message","Invalid email");
            dispatcher.forward(request, response);


        }

    }

}