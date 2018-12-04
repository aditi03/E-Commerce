/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.lang.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Helisha
 */
@Controller
public class laptopcontroller 
{
    
    private static SessionFactory factory;
    @RequestMapping("/verifylaptop")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) 
    { 
        String pid=request.getParameter("pid");
        float dis=Float.parseFloat(request.getParameter("discount"));
        String pnm=request.getParameter("pnm");
        String s_size=request.getParameter("screensize");
        int count=Integer.parseInt(request.getParameter("count"));
        String pro=request.getParameter("processor");
        String color =request.getParameter("color");
        String os =request.getParameter("os");
        String company=request.getParameter("company");
        String series=request.getParameter("series");
        String warranty=request.getParameter("warranty");
        String hd=request.getParameter("hd");
        String graphic_card=request.getParameter("graphic_card");
        String model=request.getParameter("model");
        String ports=request.getParameter("ports");
        String prospeed=request.getParameter("prospeed");
        String protype=request.getParameter("protype");
        
        int ram = Integer.parseInt(request.getParameter("ram"));
        int model_year = Integer.parseInt(request.getParameter("model_year"));
        int battery = Integer.parseInt(request.getParameter("battery"));
        int procount = Integer.parseInt(request.getParameter("procount"));
        
        float weight = Float.parseFloat(request.getParameter("weight"));
        float price = Float.parseFloat(request.getParameter("price"));
        //float fc = Float.parseFloat(request.getParameter("fc"));
        //float rc = Float.parseFloat(request.getParameter("rc"));
        
        try
        {
        Product p = new Product(pid,dis,price,pnm);
        Laptop lp;
         //public Laptop( product,name,price,count,company,series,screenSize,processor,ram,weight,hd,model,modelYear,graphicCard,battery,color,ports,prospeedprocount,protypewarranty,description)
        lp = new Laptop(p,pnm,price,count,company,series,os,s_size,pro,ram,weight,hd,model,model_year,graphic_card,battery,color,ports,prospeed,procount,protype,warranty,"----");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t=session.beginTransaction();
        session.persist(p);
        session.persist(lp);
        t.commit();
        session.close();
       
        
        }
        catch(NullPointerException e)
        {
            System.out.println("-------- "+ e);
        }
        String message = "Successful Added";
        return new ModelAndView("adminhome", "message", message);
    }
    
    
    
}
