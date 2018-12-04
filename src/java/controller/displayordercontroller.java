/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
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
public class displayordercontroller {
    private static SessionFactory factory;
    @RequestMapping("/displayorder")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        List<Orderitem> l=new ArrayList<Orderitem>();
        String rpage="displayorder";
        HttpSession s=request.getSession();
        String uid=(String)s.getAttribute("uid");
        if(uid==null)
        {
            rpage="login";
            s.setAttribute("lpage","displayorder");
        }
        else{
            Query q=session.createQuery("from User where emailid=:em");
            q.setParameter("em",uid);
            List<User> l1=q.list();
            User u=l1.get(0);
            q=session.createQuery("from Order where user=:em");
            q.setParameter("em",u);
            List<Order> l2=q.list();
            for(Order o:l2)
            {
                q=session.createQuery("from Orderitem where order=:em");
                q.setParameter("em",o);
                List<Orderitem> l3=q.list();
                for(Orderitem oi:l3)
                {
                    l.add(oi);
                }
            }
        }
        return new ModelAndView(rpage, "list",l);
    }
}
