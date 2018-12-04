/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Viraj
 */
@Controller
public class checkoutcontroller {
    private static SessionFactory factory;
    @RequestMapping("/checkout")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {
    HttpSession s=request.getSession();
    int count= (Integer)s.getAttribute("count");
    int q[]=new int[count];
    //List<Integer> l=new ArrayList<Integer>();
    String pid[]=new String[count];
    s.setAttribute("count", count);
    for(int i=1;i<=count;i++)
    {
        String y=request.getParameter(String.valueOf(i));
        int x=Integer.valueOf(y);
        //int x=request.getParameter(String.valueOf(i));
        q[i-1]=x;
        //l.add(x);
        String p=request.getParameter("pid"+String.valueOf(i));
        pid[i-1]=p;
        //s.setAttribute(String.valueOf(i), x);
        //s.setAttribute("pid"+y, pid);
    }
    s.setAttribute("quantity",q);
    s.setAttribute("pid",pid);
    return new ModelAndView("checkout1", "message","wederfe");
    }
}
