/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Viraj
 */
@Controller
public class homecontroller {
    @RequestMapping("/home")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String message = "user";
        return new ModelAndView("home", "message", message);
    }
}