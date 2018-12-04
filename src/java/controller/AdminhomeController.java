/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Helisha
 */
@Controller
public class AdminhomeController {
    @RequestMapping("/adminhome")  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("adminhome", "message", message);  
    }
    @RequestMapping("/adminregister")  
    public ModelAndView hello() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("adminregister", "message", message);  
    }
}
