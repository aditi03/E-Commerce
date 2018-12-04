/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import model.*;
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
public class singleproductcontroller {
    private static SessionFactory factory;
    @RequestMapping("/single-product")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String message = "HELLO SPRING MVC HOW R U";  
        String pid=request.getParameter("pid");
        HttpSession s=request.getSession();
        if(pid!=null)
        {
            s.setAttribute("pid", pid);
        }
        else
        {
            pid = (String)s.getAttribute("pid");
        }
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Query q=null;
        if(pid.startsWith("EM"))
        {
          request.setAttribute("cat","Electronics");
          request.setAttribute("subcat","Mobile-Tablet");
          request.setAttribute("location","mobtab.htm");
          q=session.createQuery("from Mobiletablet where pid=:em"); 
          q.setParameter("em", pid);  
          List<Mobiletablet> l=q.list();
          Mobiletablet m=l.get(0);
          List<String[]> l1=new ArrayList<String[]>();
          String[] s3=new String[2];
          s3[0]="Model";
          s3[1]=m.getModel();
          l1.add(s3);
          String[] s4=new String[2];
          s4[0]="RAM";
          s4[1]=m.getRam().toString();
          l1.add(s4);
          String[] s5=new String[2];
          s5[0]="Hard Disk";
          s5[1]=m.getRom().toString();
          l1.add(s5);
          String[] s6=new String[2];
          s6[0]="Screen Size";
          s6[1]=m.getScreenSize();
          l1.add(s6);
          String[] s7=new String[2];
          s7[0]="Front Cam";
          s7[1]=m.getFrontCam().toString();
          l1.add(s7);
          String[] s8=new String[2];
          s8[0]="Rear Cam";
          s8[1]=m.getRearCam().toString();
          l1.add(s8);
          String[] s9=new String[2];
          s9[0]="Battery Life";
          s9[1]=m.getBattery().toString();
          l1.add(s9);
          String[] s10=new String[2];
          s10[0]="Processor";
          s10[1]=m.getProcessor();
          l1.add(s10);
          String[] s11=new String[2];
          s11[0]="Color";
          s11[1]=m.getColor();
          l1.add(s11);
          String[] s12=new String[2];
          s12[0]="OS";
          s12[1]=m.getOs();
          l1.add(s12);
          String[] s13=new String[2];
          s13[0]="Company";
          s13[1]=m.getCompany();
          l1.add(s13);
          String[] s14=new String[2];
          s14[0]="Connectivity";
          s14[1]=m.getConTech();
          l1.add(s14);
          String[] s15=new String[2];
          s15[0]="Warranty";
          s15[1]=m.getWarranty();
          l1.add(s15);
          String[] s16=new String[2];
          s16[0]="Special Features";
          s16[1]=m.getSpecialFeaturs();
          l1.add(s16);
          String[] s17=new String[2];
          s17[0]="Weight";
          s17[1]=m.getWeight().toString();
          l1.add(s17);
          String[] s18=new String[2];
          s18[0]="Box";
          s18[1]=m.getInbox();
          l1.add(s18);
          /*Class<?> clazz=m.getClass();
          for(Field field:clazz.getDeclaredFields())
          {
              s3[0]=field.getName();
             // s3[1]=field.get(s3)
             s3[1]="";
             l1.add(s3);
          }*/
          request.setAttribute("name", m.getProduct().getName());
          request.setAttribute("price", m.getProduct().getPrice());
          return new ModelAndView("singleproduct", "list",l1);
        }
        else if(pid.startsWith("B"))
        {
            request.setAttribute("location","booklist.htm");
           request.setAttribute("cat","Books");
          request.setAttribute("subcat","Books");  
          q=session.createQuery("from Book where pid=:em"); 
          q.setParameter("em", pid);  
          List<Book> l=q.list();
          Book b=l.get(0);
          List<String[]> l1=new ArrayList<String[]>();
          String[] s3=new String[2];
          s3[0]="Author";
          s3[1]=b.getAuthor();
          l1.add(s3);
          String[] s4=new String[2];
          s4[0]="Publication";
          s4[1]=b.getPublication();
          l1.add(s4);
          String[] s5=new String[2];
          s5[0]="Genre";
          s5[1]=b.getGenre();
          l1.add(s5);
          String[] s6=new String[2];
          s6[0]="Language";
          s6[1]=b.getLanguage();
          l1.add(s6);
          String[] s7=new String[2];
          s7[0]="Rank";
          s7[1]=b.getRank().toString();
          l1.add(s7);
          String[] s8=new String[2];
          s8[0]="Description";
          s8[1]=b.getDescription();
          l1.add(s8);
          request.setAttribute("name", b.getProduct().getName());
          request.setAttribute("price",b.getProduct().getPrice());
          return new ModelAndView("singleproduct", "list",l1); 
        }
        return new ModelAndView("home","f","f");
    }
    
}
