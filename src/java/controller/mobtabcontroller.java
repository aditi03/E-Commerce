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
public class mobtabcontroller 
{
    
    private static SessionFactory factory;
    @RequestMapping("/verifymobtab")
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
        String con_Tech=request.getParameter("con_tech");
        String warranty=request.getParameter("warranty");
        String spf=request.getParameter("spf");
        String inbox=request.getParameter("inbox");
        String model=request.getParameter("model");
        
        int ram = Integer.parseInt(request.getParameter("ram"));
        int rom = Integer.parseInt(request.getParameter("rom"));
        int battery = Integer.parseInt(request.getParameter("battery"));
        
        float weight = Float.parseFloat(request.getParameter("weight"));
        float price = Float.parseFloat(request.getParameter("price"));
        float fc = Float.parseFloat(request.getParameter("fc"));
        float rc = Float.parseFloat(request.getParameter("rc"));
        
        try
        {
        Product p = new Product(pid,dis,price,pnm);
        //public Product(String pid, float discount, float price, int stock)
        // Mobiletablet(, Integer rom, String screenSize, Float frontCam, Float rearCam, Integer battery, String processor, String color, String os, String company, String conTech, String warranty, String specialFeaturs, Float weight, String inbox, String description
 //Mobiletablet(Product product, String name, float price, int count, String model, Integer ram, Integer rom, String screenSize, Float frontCam, Float rearCam, Integer battery, String processor, String color, String os, String company, String conTech, String warranty, String specialFeaturs, Float weight, String inbox, String description)   
        Mobiletablet mt;
        mt = new Mobiletablet(p,pnm,price,count,model,ram,rom,s_size,fc,rc,battery,pro,color,os,company,con_Tech,warranty,spf,weight,inbox,"----");
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t=session.beginTransaction();
        session.persist(p);
        session.persist(mt);
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
