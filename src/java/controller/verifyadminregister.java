/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aditi Dandekar
 */
@Controller
public class verifyadminregister {
    private static SessionFactory factory;
    @RequestMapping("/verifyadminregister")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) { 
        String fn=request.getParameter("fn");
        String ln=request.getParameter("ln");
        String pn=request.getParameter("pn");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        String pin=request.getParameter("pincode");
        Set s1=null,s2=null,s3=null,s4=null;
       // int pincode=Integer.valueOf(pin);
        User u=new User(email,password,fn,ln,pn,address,city,state,pin,"w",s1,s2,s3,s4);
        factory=model.HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t=session.beginTransaction();
        session.persist(u);
        t.commit();
        session.close();
        String message = "Successful Registration";
        return new ModelAndView("adminhome", "message", message);
    }
}
