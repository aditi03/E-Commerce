/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author Helisha
 */
@Controller
public class updatemobtabcontroller {
    private static SessionFactory factory;
    @RequestMapping("/searchmobtab")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse response)
    {
        
        String s=request.getParameter("search");
        /*String sql = "SELECT * FROM Mobiletablet where pid like '%:search%' or name like '%:search%' or model like '%:search%' or processor like '%:search%' or color like '%:search%' or os like '%:search%' or company like '%:search%' or con_tech like '%:search%' or special_featurs like '%:search%' or description like '%:search%'; ";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        List results = query.list();
        */
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Mobiletablet where pid like '%" + s + "%' or name like '%" + s + "%' or screen_size like '%" + s + "%' or model like '%" + s + "%' or processor like '%" + s + "%' or color like '%" + s + "%' or os like '%" + s + "%' or company like '%" + s + "%' or con_tech like '%" + s + "%' or special_featurs like '%" + s + "%' or description like '%" + s + "%')");
        //q.setParameter("search",s);
       
        List<Mobiletablet> l=q.list();
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("updatelist", "list", l); 
    }
    @RequestMapping("/updateproduct")
    public ModelAndView helloWorld1(HttpServletRequest request,HttpServletResponse response)
    {
        String s = request.getParameter("pid");
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        Query q=session.createQuery("from Mobiletablet where pid = '" + s +" '");
        
        List<Mobiletablet> mb= q.list();
       
        
        return new ModelAndView("updateproduct", "list", mb); 
    }
    @RequestMapping("/removeproduct")
    public ModelAndView helloWorld2(HttpServletRequest request,HttpServletResponse res) 
    { 
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t = session.beginTransaction();
        String pid=request.getParameter("pid");
        Query qry = session.createQuery("delete from Product where pid='"+ pid + "'");
        Query qry1 = session.createQuery("delete from Mobiletablet where pid='"+ pid + "'");
        qry.executeUpdate();
        qry1.executeUpdate();
       
        t.commit();
        String message = "Successful Added";
        return new ModelAndView("adminhome", "message", message);
    }
    @RequestMapping("/verifupdateymobtab")
    public ModelAndView helloWorld5(HttpServletRequest request,HttpServletResponse res) 
    { 
    
        String pid=request.getParameter("pid");
        System.out.println(" pid : " + pid);
        //float dis=Float.parseFloat(request.getParameter("discount"));
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
        try{
        
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t = session.beginTransaction();
       //String sq1 = "update Mobiletablet set name='" + pnm + "', price=" + price + " , count=" + count + " , model='" + model + "', ram= " + ram + " ,rom= " + rom + " , screensize='" + s_size + "', frontCam= " + fc + " , rearCam= " + rc + " , battery= " + battery + " , processor='" + pro + "', color='" + color + "' , os='" + os + "', company='" + company + "', conTech='" + con_Tech + "', warranty='" + warranty + "', specialFeaturs='" + spf + "', weight=" + weight + " ,inbox='" + inbox + "' where pid = '" + pid + "'";
       String q1= "update Mobiletablet set name='" + pnm + "' , price= " + price + " where pid='" + pid + "'";
       //q1.setParameter();
       
       //String q2= "update Mobiletablet set count=" + count + " where pid='"+ pid + "'";
       String q3= "update Mobiletablet set model='" + model + "' where pid='"+ pid + "'";
       String q4= "update Mobiletablet set ram= " + ram + " , rom=" + rom + " where pid='"+ pid + "'";
       String q5= "update Mobiletablet set  frontCam= " + fc + " , rearCam= " + rc + " , battery= " + battery + " , processor='" + pro + "', color='" + color + "' where pid='"+ pid + "'";
       String q6= "update Mobiletablet set  warranty='" + warranty + "', specialFeaturs='" + spf + "', weight=" + weight + " ,inbox='" + inbox + "' where pid='"+ pid + "'";
       //String q7= "update Product set count=" + count + " where pid='"+ pid + "'";
       
       
       Query qr1 = session.createQuery(q1);
       //Query qr2 = session.createQuery(q2);
       Query qr3 = session.createQuery(q3);
       Query qr4 = session.createQuery(q4);
       Query qr5 = session.createQuery(q5);
       Query qr6 = session.createQuery(q6);
       
       
       Query qry = session.createQuery("update Product set name='" + pnm + "', price="+ price + " where pid='"+ pid + "'");
        //qry.setParameters()
        qry.executeUpdate();
        qr1.executeUpdate();
        //qr2.executeUpdate();
        qr3.executeUpdate();
        qr4.executeUpdate();
        qr5.executeUpdate();
        qr6.executeUpdate();
        
        //session.persist(p);
        //session.persist(mt);
        t.commit();
        
        //System.out.println("result  " + result + "   " + result1 + "  ." );
        session.close();
        }
        catch(HibernateException e)
        {}
        
    String message = "Successful Added";
        return new ModelAndView("adminhome", "message", message);
    }
}
