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
 * @author Viraj
 */
@Controller
public class LoginController {
    @RequestMapping("/login")  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("login", "message", message);  
    }
    @RequestMapping("/registration")  
    public ModelAndView register() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("registration", "message", message);  
    }
    //@RequestMapping("/cart")  
    //public ModelAndView cart() {  
      //  String message = "HELLO SPRING MVC HOW R U";  
        //return new ModelAndView("cart", "message", message);  
    //}
    
    
}
