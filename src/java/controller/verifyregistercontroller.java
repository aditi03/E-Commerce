/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Viraj
 */
@Controller
public class verifyregistercontroller {
    private static SessionFactory factory;
    @RequestMapping("/verifyregistration")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) { 
        String fn=request.getParameter("fn");
        String ln=request.getParameter("ln");
        String pn=request.getParameter("pn");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User u=new User(email,password,fn,ln,pn,"c");
        try{
            factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();  
            Transaction t=session.beginTransaction();
            session.persist(u);
            t.commit();
            session.close();
        }
        catch(ConstraintViolationException e)
        {
            
        }
        String message = "user";
        return new ModelAndView("home", "message", message);
    }
}
