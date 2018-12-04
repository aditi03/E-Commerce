/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import entity.Cart;
import model.*;
//import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Viraj
 */
@Controller
public class cartandwishlistcontroller {
   private static SessionFactory factory;
    @RequestMapping("/cart")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        String rpage="cart";
        List<List<Product>> p=new ArrayList<List<Product>>();
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        try{
        if(uid==null)
        {
            rpage="login";
            s.setAttribute("lpage","cart");
        }
        else{
        Query q=session.createQuery("from Cart where id.emailid=:em1 and type=:em2");
        q.setParameter("em1",uid);
        q.setParameter("em2","c");
        List<Cart> l=q.list();
        int count=l.size();
        s.setAttribute("count", count);              
        for(int i=0;i<l.size();i++)
        {
            Cart ca=l.get(i);
            CartId ci1=ca.getId();
            String s1=ci1.getPid();
            Query q1=session.createQuery("from Product where pid in (:em1)");
            q1.setParameter("em1",s1);
            List<Product> l3=q1.list();
            p.add(l3);
        }}
        }
        catch(Exception e)
        {
            
        }
        String err=(String)s.getAttribute("err");
        s.setAttribute("err","xcv");
        if(err!=null && err.equals("error"))
        {
            request.setAttribute("err","error");
        }
        return new ModelAndView(rpage, "list", p);
    }
    @RequestMapping("/wishlist")  
    public ModelAndView helloWorld5(HttpServletRequest request,HttpServletResponse res) {
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        String rpage="wishlist";
        List<List<Product>> p=new ArrayList<List<Product>>();
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        if(uid==null)
        {
            rpage="login";
            s.setAttribute("lpage","wishlist");
        }
        else{
        Query q=session.createQuery("from Cart where id.emailid=:em1 and type=:em2");
        q.setParameter("em1",uid);
        q.setParameter("em2","w");
        List<Cart> l=q.list();
        for(int i=0;i<l.size();i++)
        {
            Cart ca=l.get(i);
            CartId ci1=ca.getId();
            String s1=ci1.getPid();
            Query q1=session.createQuery("from Product where pid in (:em1)");
            q1.setParameter("em1",s1);
            List<Product> l3=q1.list();
            p.add(l3);
        }
        }
        String err=(String)request.getAttribute("err");
        if(err.equals("error"))
        {
            request.setAttribute("err","error");
        }
        return new ModelAndView(rpage, "list", p);
    }
    @RequestMapping("/movetowishlist")
    public ModelAndView helloWorld1(HttpServletRequest request,HttpServletResponse res) {
        String pid=request.getParameter("pid1");
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Query q=session.createQuery("update Cart set type=:em1 where id.pid=:em2 and id.emailid=:em3");
        q.setParameter("em1","w");
        q.setParameter("em2",pid);
        q.setParameter("em3",uid);
        q.executeUpdate();
        String rpage="cart.htm";
        return new ModelAndView("redirect:/"+rpage);
        //return new ModelAndView("cart", "message", "fdgfggf");
    }
    @RequestMapping("/removefromcart")
    public ModelAndView helloWorld2(HttpServletRequest request,HttpServletResponse res) {
        String pid=request.getParameter("pid1");
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Query q=session.createQuery("delete from Cart where id.pid=:em2 and id.emailid=:em3 and type=:em1");
        q.setParameter("em2",pid);
        q.setParameter("em3",uid);
        q.setParameter("em1","c");
        q.executeUpdate();
        String rpage="cart.htm";
        return new ModelAndView("redirect:/"+rpage);
        //return new ModelAndView("cart", "message", "fdgfggf");
    }
    @RequestMapping("/movetocart")
    public ModelAndView helloWorld3(HttpServletRequest request,HttpServletResponse res) {
        String pid=request.getParameter("pid1");
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Query q=session.createQuery("update Cart set type=:em1 where id.pid=:em2 and id.emailid=:em3");
        q.setParameter("em1","c");
        q.setParameter("em2",pid);
        q.setParameter("em3",uid);
        q.executeUpdate();
        String rpage="wishlist.htm";
        return new ModelAndView("redirect:/"+rpage);
        //return new ModelAndView("wishlist", "message", "fdgfggf");
    }
    @RequestMapping("/removefromwl")
    public ModelAndView helloWorld4(HttpServletRequest request,HttpServletResponse res) {
        String pid=request.getParameter("pid1");
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Query q=session.createQuery("delete from Cart where id.pid=:em2 and id.emailid=:em3 and type=:em1");
        q.setParameter("em2",pid);
        q.setParameter("em3",uid);
        q.setParameter("em1","w");
        q.executeUpdate();
        String rpage="wishlist.htm";
        return new ModelAndView("redirect:/"+rpage);
        //return new ModelAndView("wishlist", "message", "fdgfggf");
    }
} 

