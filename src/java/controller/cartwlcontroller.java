/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import com.sun.xml.internal.ws.client.RequestContext;
//import com.sun.xml.ws.client.RequestContext;
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
public class cartwlcontroller {
    private static SessionFactory factory;
    @RequestMapping("/cartwlcontroller")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";
        HttpSession s=request.getSession();
        String uid;
        uid=(String)s.getAttribute("uid");
        String type=request.getParameter("type");
        if(type!=null)
        {
            s.setAttribute("type",type);
        }
        String pid=(String)s.getAttribute("pid");
        String rpage="home",s1=null;
        List<List<Product>> p=new ArrayList<List<Product>>();
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        request.setAttribute("err","noerror");
        try{
        if(uid==null)
        {
            rpage="login";
            s.setAttribute("lpage","cartwlcontroller");
        }
        else
        {
                
                type=(String)s.getAttribute("type");
                if(type!=null){
                    String t1="c";
                    if(type.equals("cart"))
                    {
                        rpage="cart";
                        t1="c";
                        Query q1=session.createQuery("from Warehouse where pid=:em3");
                         q1.setParameter("em3",pid);
                         List<Warehouse> l1=q1.list();
                         int cnt=l1.size();
                         boolean flag=false;
                         for(int i=0;i<cnt;i++)
                         {
                             Warehouse w=l1.get(i);
                             int stock=w.getStock();
                             if(stock>0)
                             {
                                 flag=true;
                                 break;
                             }
                             
                         }
                         if(flag==false)
                         {
                               String page="single-product.htm"; 
                               return new ModelAndView("redirect:/"+page);
                         }
                    }
                    else
                    {   
                        rpage="wishlist";
                        t1="w";
                    }
                    //factory=HibernateUtil.getSessionFactory();
                    //Session session=factory.openSession();  
                    Transaction t=session.beginTransaction();
                    //try{
                    CartId ci=new CartId(uid,pid);
                    Cart c=new Cart(ci,t1);
                    session.persist(c);
                    t.commit();
                    //session.close();
                    //}
                    //catch(Exception e)
                    //{}
                    Query q=session.createQuery("from Cart where id.emailid=:em1 and type=:em2");
                    q.setParameter("em1",uid);
                    q.setParameter("em2",t1);
                    List<Cart> l=q.list();
                    int count=l.size();
                    if(t1.equals("c"))
                    {
                        s.setAttribute("count", count);
                    }
                    for(int i=0;i<l.size();i++)
                    {
                        Cart ca=l.get(i);
                        CartId ci1=ca.getId();
                        s1=ci1.getPid();
                        Query q1=session.createQuery("from Product where pid in (:em1)");
                        q1.setParameter("em1",s1);
                        List<Product> l3=q1.list();
                        p.add(l3);
                    }
                }
        }   
        }
        catch(java.lang.IndexOutOfBoundsException e)
        {
            //request.setAttribute("outofstock","y");
            return new ModelAndView("errorpage","message","Out Of Stock");
        }
        catch(Exception e)
        {
            String page=null;
            if(type.equals("cart"))
            {
            page="cart"; 
            }
            else
            {
            page="wishlist";    
            }
            //request.setAttribute("err","error");
            s.setAttribute("err","error");
            return new ModelAndView("redirect:/"+page+".htm");
            //return new ModelAndView(page,"err","error");
            /*FacesMessage msg;
            msg=new FacesMessage(FacesMessage.SEVERITY_INFO,"Error","Duplicate Entry");
            RequestContext.getCurrentInstance().showMessageInDialog(msg);*/
            //JOptionPane.showMessageDialog(null,"fdsfdf","fdfgdf",JOptionPane.INFORMATION_MESSAGE);
        }
         
        return new ModelAndView(rpage, "list", p);
    }
}

