/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.Share;
import model.ShareId;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.*;

/**
 *
 * @author Viraj
 */
@Controller
public class resetpasswordcontroller {
    private static SessionFactory factory;
    @RequestMapping("/resetpassword")
    public ModelAndView helloWorld1() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("resetpassword", "message", message);  
    }
    @RequestMapping("/resetp")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U"; 
        factory=HibernateUtil.getSessionFactory();
        HttpSession s=request.getSession();
        
        
        String uid=(String)s.getAttribute("uid");
        String psw=request.getParameter("npsw");
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        Query q=session.createQuery("update User set password='" + psw + "' where emailid='" + uid + "'");
        //q.setParameter("em1", psw);
        //q.setParameter("em2", uid);
        
        int result=q.executeUpdate();
        t.commit();
        return new ModelAndView("redirect:/"+"home.htm");  
    }
    
     @RequestMapping("/forgotpwd")
    public ModelAndView helloorld1(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("forgotpwd", "message", message);  
    }
    
    @RequestMapping("/forgotpassword")
    public ModelAndView hellorld1(HttpServletRequest request,HttpServletResponse res) {  
        String msg = "HELLO SPRING MVC HOW R U"; 
        
        String uid=request.getParameter("email");
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Transaction t=session.beginTransaction();
        Query q=session.createQuery("update User set password='insiliconpwd17' where emailid='" + uid + "'");
        //q.setParameter("em1", psw);
        //q.setParameter("em2", uid);
        
        int result=q.executeUpdate();
        t.commit();
        
        
 /*               String to=uid;
        String from="aditi.a.dandekar@gmail.com";
        String host="localhost";
        Properties props=new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        //properties.setProperty("mail.smtp.host", host);
        javax.mail.Session m=javax.mail.Session.getInstance(props,new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication(from,"aditi1996");
             }
        });
        try{
            MimeMessage message=new MimeMessage(m);
            //message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("New Password");
            message.setText("Hello, Your new password is insiliconpwd17. Kindly login and reset your password");
            Transport.send(message);
            
        } catch (MessagingException ex) {
            msg=msg+ex;
            Logger.getLogger(resetpasswordcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }*/

                Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", true); // added this line
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.user", "aditi.a.dandekar");
    props.put("mail.smtp.password", "aditi1996");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", true);



    javax.mail.Session session1 = javax.mail.Session.getInstance(props,null);
    MimeMessage message = new MimeMessage(session1);

    System.out.println("Port: "+session1.getProperty("mail.smtp.port"));

    // Create the email addresses involved
    try {
        InternetAddress from = new InternetAddress("aditi.a.dandekar");
        message.setSubject("New Password");
        message.setFrom(from);
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(uid));

        // Create a multi-part to combine the parts
        Multipart multipart = new MimeMultipart("alternative");

        // Create your text message part
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Your password is 'insiliconpwd17'. Kindly login and reset passoword");

        // Add the text part to the multipart
        multipart.addBodyPart(messageBodyPart);

        // Create the html part
        messageBodyPart = new MimeBodyPart();
        String htmlMessage = "Your password is 'insiliconpwd17'. Kindly login and reset passoword.";
        messageBodyPart.setContent(htmlMessage, "text/html");


        // Add html part to multi part
        multipart.addBodyPart(messageBodyPart);

        // Associate multi-part with message
        message.setContent(multipart);

        // Send message
        Transport transport = session1.getTransport("smtp");
        transport.connect("smtp.gmail.com", "aditi.a.dandekar", "aditi1996");
        System.out.println("Transport: "+transport.toString());
        transport.sendMessage(message, message.getAllRecipients());


    } catch (AddressException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        
    }

    request.setAttribute("congo","true");
        
        
        return new ModelAndView("login", "message", msg); 
    }
}
