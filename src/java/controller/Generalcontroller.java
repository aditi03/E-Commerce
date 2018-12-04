/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
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
public class Generalcontroller {
    private static SessionFactory factory;
    @RequestMapping("/viewlist")  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("login", "message", message);  
    }
    
    @RequestMapping("/share")  
    public ModelAndView helloWorld2(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";
        HttpSession s=request.getSession();
        
        String toemailid = request.getParameter("toemailid");
        String pid = (String) s.getAttribute("pid");
        String fromemailid = (String) s.getAttribute("uid");
        ShareId sid = new ShareId(toemailid,fromemailid,pid);
        

        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Query q1 = session.createQuery("from User where emailid='"+ toemailid +"'");
        Query q2 = session.createQuery("from User where emailid='"+ fromemailid + "'");
        Query q3 = session.createQuery("from Product where pid='"+ pid + "'");
        List<User> ul1 = q1.list();
        User u1= ul1.get(0);
        List<User> ul2 = q2.list();
        User u2= ul2.get(0);
        List<Product> pl=q3.list();
        Product p1= pl.get(0);
        
        
        Date d1 = new Date(); 
        Share sh = new Share(sid,p1,u1,u2,d1); 
        Transaction t = session.beginTransaction();
        
        //session.persist(sid);
        session.persist(sh);
        
        t.commit();
        session.close();
        String s11 = "single-product.htm";
                    
        return new ModelAndView("redirect:/"+s11);
        
    }
    
    @RequestMapping("/nf")  
    public ModelAndView helloWorld1(HttpServletRequest request,HttpServletResponse res)
    { 
        String message = "HELLO SPRING MVC HOW R U";
        HttpSession s= request.getSession();
        String uid;
        uid=(String)s.getAttribute("uid");
        String rpage;
        if(uid==null)
        {
            rpage="login";
             s.setAttribute("lpage","nf");
             return new ModelAndView("login", "message",message);
        }
        else
        {
                    factory=HibernateUtil.getSessionFactory();
                    Session session=factory.openSession();
                    Query q = session.createQuery("from Share where userByToEmailid = (from User where emailid='" + uid + "') order by sharedate desc");
                    List<Share> l1 = q.list();
                    return new ModelAndView("nf", "list" , l1); 
        }
         
    }
}
