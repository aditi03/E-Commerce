/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class searchcontroller {
    private static SessionFactory factory;
    @RequestMapping("/search")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        String s=request.getParameter("search");
        Query q=session.createQuery("from Product where name like :em");
        q.setParameter("em","%"+s+"%");
        List<Product> l=q.list(); 
        return new ModelAndView("viewlist", "list",l);
    }
}
