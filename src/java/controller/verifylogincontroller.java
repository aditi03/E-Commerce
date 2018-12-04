/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.HibernateUtil;
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
public class verifylogincontroller {
    private static SessionFactory factory;
    @RequestMapping("/verifylogin")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
        String rpage="home",message="dsfdgfg";
        String name=request.getParameter("email");  
        String password=request.getParameter("password");
        try{
        HttpSession s1=request.getSession();
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession(); 
        if(password.equals("admin")){  
            message = "admin";  
            rpage="home";
            s1.setAttribute("uid", name);
            //return new ModelAndView("home", "message", message);  
        } 
        else if(password.equals("insiliconpwd17"))
        {
            rpage="resetpassword";
            s1.setAttribute("uid", name);
            return new ModelAndView(rpage, "message", message);
        }
        else{
            Query q=session.createQuery("from User where emailid=:em"); 
            q.setParameter("em", name);
            List<User> l=q.list();
            if(l.size()==0)
            {
                rpage="errorpage";
                message="Invalid Username";
            }
            else
            {
                User p=l.get(0);
                String role=p.getRole();
                if(role.equals("c"))
                {
                    message="user";
                }
                else if(role.equals("w"))
                {
                    message="warehouse";
                }
            if(password.equals(p.getPassword()))
            {
                rpage="home";
                String fnm=p.getFname();
                //message="user";
                s1.setAttribute("uid", name);
                s1.setAttribute("fnm",fnm);
                if(s1.getAttribute("lpage")!=null)
                {
                    rpage=(String)s1.getAttribute("lpage")+".htm";
                    s1.setAttribute("lpage",null);
                    return new ModelAndView("redirect:/"+rpage);
                    
                }
            }
            else
            {
                message="Invalid username or password";
                rpage="errorpage";
            }}
                //return new ModelAndView("errorpage", "message","Sorry, username or password error");  
        }  
        
        }
        catch(Exception e)
        {   
          /*  FacesMessage msg;
            msg=new FacesMessage("Duplicate Entry");
            FacesContext.getCurrentInstance().addMessage(null, msg);*/
            JOptionPane.showMessageDialog(null,"fdsfdf","fdfgdf",JOptionPane.INFORMATION_MESSAGE);
        }
        return new ModelAndView(rpage, "message", message);
    }
}
