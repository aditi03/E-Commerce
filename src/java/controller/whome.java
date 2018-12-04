/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

/**
 *
 * @author Aditi Dandekar
 */

@Controller
public class whome {
    private static SessionFactory factory;
    @RequestMapping("/whome")  
    public ModelAndView helloWo() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("whome", "message", message);  
    }
    
    @RequestMapping("/whomee")  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("electronics", "message", message);  
    }
    
    @RequestMapping("/whomees")  
    public ModelAndView ees(HttpServletRequest request,HttpServletResponse res) {  
        HttpSession s2=request.getSession();
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        String wid=(String)s2.getAttribute("uid");
        //WarehouseId whid=new WarehouseId();
        Query q=session.createQuery("from Warehouse where id.wid=:wid and id.pid like 'EM%' and stock<5");
        q.setParameter("wid", wid);
        List<Warehouse> l=q.list();
        return new ModelAndView("showstock", "list", l);
    }
    
        @RequestMapping("/whomec")  
    public ModelAndView helloWorl() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("clothing", "message", message);  
    }
        @RequestMapping("/whomeb")  
    public ModelAndView helloWor() {  
        String message = "HELLO SPRING MVC HOW R U";
        factory=model.HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Product where pid like 'B%'");
        List<Product> l=q.list();
        return new ModelAndView("mobile", "list", l);

    }
    @RequestMapping("/mobile")  
    public ModelAndView helloW() {  
        String message = "HELLO SPRING MVC HOW R U";
        factory=model.HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Product where pid like 'EM%'");
        List<Product> l=q.list();
        return new ModelAndView("mobile", "list", l);
          
    }
       @RequestMapping("/stock")  
    public ModelAndView hello(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";
        String pid=request.getParameter("pid");
        HttpSession s1=request.getSession();
        s1.setAttribute("pid",pid);
        return new ModelAndView("stock", "message", message);  
    }
    
    @RequestMapping("/addstock")  
    public ModelAndView hell(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";
        String stock=request.getParameter("stock");
        int s=Integer.valueOf(stock);
        //String pid=request.getParameter("pid");
        HttpSession s1=request.getSession();
        String wid=(String)s1.getAttribute("uid");
        String pid=(String)s1.getAttribute("pid");
        WarehouseId w=new WarehouseId(wid,pid);
        int stock_new=0;
        
        factory=model.HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        
        //try{
        Query q=session.createQuery("from User where emailid=:em"); 
            q.setParameter("em", wid);
            List<User> l=q.list();
            User u=l.get(0);
            
            Query q1=session.createQuery("from Product where pid=:p"); 
            q1.setParameter("p",pid);
            List<Product> l1=q1.list();
            Product p=l1.get(0);
            
            Query q2=session.createQuery("from Warehouse where pid=:p and wid=:w"); 
            q2.setParameter("p",pid);
            q2.setParameter("w",wid);
            List<Warehouse> l2=q2.list();
            
            
            if(l2.isEmpty())
            {
                //WarehouseId warehouseid=new WarehouseId(wid,pid);
            Warehouse wr=new Warehouse(w,p,u,s);
            Transaction t=session.beginTransaction();
            session.persist(wr);
            t.commit();
            session.close();
            }
            else
            {
            Warehouse wh=l2.get(0);
            int stock_old=wh.getStock();
            stock_new=stock_old+s;
            Query q3=session.createQuery("update Warehouse set stock=:st where id.pid=:em2 and id.wid=:em3");
            //Query q3=session.createQuery("update Warehouse set stock='"+stock_new+"' where id.pid='"+pid+"' and id.wid='"+wid+"'");
            q3.setParameter("em2",pid);
            q3.setParameter("em3",wid);
            q3.setParameter("st",stock_new);
            q3.executeUpdate();
            Transaction t1=session.beginTransaction();
            t1.commit();
            }
        //}
        //catch(Exception e)
        //{
            /*Query q1=session.createQuery("from Warehouse where pid=:p and wid=:w"); 
            q1.setParameter("p",pid);
            q1.setParameter("w",wid);
            List<Warehouse> l1=q1.list();
            Warehouse wh=l1.get(0);
            int stock_old=wh.getStock();

            int stock_new=stock_old+s;
            Query q=session.createQuery("update Warehouse set stock=:st where id.pid=:em2 and id.wid=:em3");
            q.setParameter("em2",pid);
            q.setParameter("em3",wid);
            q.setParameter("st",stock_new);
            q.executeUpdate();*/
        //}
        return new ModelAndView("home", "message", wid);  
    }
}
