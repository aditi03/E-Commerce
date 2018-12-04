/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.jboss.weld.context.RequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.NestedServletException;

/**
 *
 * @author Viraj
 */
    @Controller
public class myaccountcontroller {
     private static SessionFactory factory;
    @RequestMapping("/myaccount")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
        HttpSession s=request.getSession();
        String rpage=null;
        String uid=(String)s.getAttribute("uid");
        if(uid==null)
        {
            rpage="login";
            s.setAttribute("lpage","myaccount");
        }
        else
        {
            factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();
            Query q=session.createQuery("from User where emailid=:em"); 
            q.setParameter("em", uid);
            List<User> l=q.list();
            User u=l.get(0);
            return new ModelAndView("myaccount","list",u);
        }
        return new ModelAndView(rpage, "list", "ccxzc");
    }
}
