/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.util.List;
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
public class electronics {
    private static SessionFactory factory;
    @RequestMapping("/mobtab.htm")
    public ModelAndView helloWorld(){
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Product where pid like 'EM%'");
        List<Product> l=q.list();
        return new ModelAndView("viewlist", "list", l);
    }
    
    @RequestMapping("/booklist.htm")
    public ModelAndView hellWorld(){
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Product where pid like 'B%'");
        List<Product> l=q.list();
        return new ModelAndView("viewlist", "list", l);
    }
    
}
