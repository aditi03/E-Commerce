/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.mail.activation.*;

/**
 *
 * @author Viraj
 */
@Controller
public class placeordercontroller {
    private static SessionFactory factory;
    @RequestMapping("/placeorder")
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) throws AddressException {
    HttpSession s=request.getSession();
    int c=0;
    factory=HibernateUtil.getSessionFactory();
    Session session=factory.openSession();
    Transaction t=session.beginTransaction();
    String uid=(String)s.getAttribute("uid");
    int count=(Integer)s.getAttribute("count");
    int q[]=(int[])s.getAttribute("quantity");
    String pid[]=(String[])s.getAttribute("pid");
    String fnm=request.getParameter("billing_first_name");
    String lnm=request.getParameter("billing_last_name");
    String addr=request.getParameter("address");
    String city=request.getParameter("billing_city");
    String state=request.getParameter("billing_state");
    //String postcode=request.getParameter("billing_postcode");
    String postcode=request.getParameter("postcode"); 
    String phone=request.getParameter("billing_phone");
    //String postcode="390007";
    ArrayList<String> pwid=new ArrayList<String>();
   int in=0;
   try{
    for(String p : pid)
    {
    Query q3=null;
    q3=session.createQuery("from Warehouse where pid=:em and stock>:cnt");
    q3.setParameter("em",p);
    q3.setParameter("cnt",q[in]);
    
    List<Warehouse> l=q3.list();
    int len=l.size();
    if(len>0)
    {
        //Warehouse w=l.get(0);
        //WarehouseId wa=w.getId();
        //String min=wa.getWid();
        long min1=9999999;
        String min="";
        int min_st=0;
        for(int i=0;i<len;i++)
        {
            Warehouse wid=l.get(i);
            WarehouseId wid1=wid.getId();
            String wareid=wid1.getWid();
            int st_old=wid.getStock();
            Query q4=null;
            q4=session.createQuery("from User where role=:w and emailid=:wid1");
            q4.setParameter("wid1",wareid);
            q4.setParameter("w","w");
            List<User> l1=q4.list();
            User u=l1.get(0);
            String pin=u.getPincode();
            //int p1=Integer.valueOf(pin);
           //int p2=Integer.valueOf(postcode);
            int p1=Integer.parseInt(pin);
            int p2=Integer.parseInt(postcode);
            int diff=p1-p2;
            if(diff<0)
            {
                diff=-1*diff;
            }
            if(diff<min1)
            {
                min_st=st_old;
                min1=diff;
                min=wareid;
                //strcpy(min,wareid);
            }
       }
        pwid.add(min);
        int st_new=min_st-q[in];
        Query q5=session.createQuery("update Warehouse set stock=:st where id.wid=:min and id.pid=:pid");
        q5.setParameter("min",min);
        q5.setParameter("pid",p);
        q5.setParameter("st",st_new);
        q5.executeUpdate();
        in++;
        
    }
    }
    //Long x3=(Long) session.createCriteria("model.Order").setProjection(Projections.rowCount()).uniqueResult();
    //int c=x3.intValue();
    //c++;
    Query q10=session.createQuery("from Order");
    List<Order> l1=q10.list();
    int len=l1.size();
    Order o1=l1.get(len-1);
    c=o1.getOrderid();
    c++;
    int x=0;
    float amount=0;
    Query q1=null;
     Query q2=null;
    for(int i=0;i<count;i++)
    {
        x+=q[i];
        q1=session.createQuery("from Product where pid=:em");
        q1.setParameter("em",pid[i]);
        List<Product> p=q1.list();
        amount+=q[i]*(p.get(0).getPrice());
        
        q2=session.createQuery("from Product where pid=:em");
    }
    q1=session.createQuery("from User where emailid=:em"); 
    q1.setParameter("em", uid);
    List<User> l=q1.list();
    User u=l.get(0);
    Order o=new Order(c,u,amount,x);
    session.persist(o);
    t.commit();
    for(int i=0;i<count;i++)
    {
        OrderitemId oi=new OrderitemId(c,pid[i]);
        q1=session.createQuery("from Product where pid=:em");
        q1.setParameter("em",pid[i]);
        List<Product> p=q1.list();
        Product p1=p.get(0);
        float pr1=p1.getPrice();
        Orderitem ot=new Orderitem(oi,o,p1,q[i],pr1,null,pwid.get(i));
        session.persist(ot);
        Transaction t1=session.beginTransaction();
        t1.commit();
        q1=session.createQuery("delete from Cart where id.pid=:em2 and id.emailid=:em3 and type=:em1");
        q1.setParameter("em2",pid[i]);
        q1.setParameter("em3",uid);
        q1.setParameter("em1","c");
        q1.executeUpdate();
        String pid2=pid[i];
        if(pid2.startsWith("EM"))
        {
            q1=session.createQuery("from Mobiletablet where pid=:em");
            q1.setParameter("em",pid2);
            List<Mobiletablet> lp=q1.list();
            int c4=lp.get(0).getCount();
            c4+=q[i];
            
            
//            q1=session.createQuery("update Mobiletablet set count=:em1 where pid=:em2");
  //          q1.setParameter("em2",pid2);
    //        q1.setParameter("em1",c4);
      //      q1.executeUpdate();
       }}}
        catch(java.lang.IndexOutOfBoundsException e)
        {
            //request.setAttribute("outofstock","y");
            return new ModelAndView("errorpage","message","Out Of Stock");
        }
        /*String to=uid;
        String from="aditi.a.dandekar@gmail.com";
        String host="localhost";
        Properties props=new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        //properties.setProperty("mail.smtp.host", host);
        javax.mail.Session m=javax.mail.Session.getInstance(props,new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication(from,"aditi1996");
             }
        });
        try{
            MimeMessage message=new MimeMessage(m);
            //message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Order "+c);
            message.setText("Hello, Your order of "+count+" items has been placed. For further details visit insilico.com");
            Transport.send(message);
            
        } catch (MessagingException ex) {
            Logger.getLogger(placeordercontroller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
         Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", true); // added this line
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.user", "aditi.a.dandekar");
    props.put("mail.smtp.password", "aditi1996");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", true);



    javax.mail.Session session1 = javax.mail.Session.getInstance(props,null);
    MimeMessage message = new MimeMessage(session1);

    System.out.println("Port: "+session1.getProperty("mail.smtp.port"));

    // Create the email addresses involved
    try {
        InternetAddress from = new InternetAddress("aditi.a.dandekar");
        message.setSubject("Order "+c);
        message.setFrom(from);
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(uid));

        // Create a multi-part to combine the parts
        Multipart multipart = new MimeMultipart("alternative");

        // Create your text message part
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Hello, Your order of "+count+" items has been placed. For further details visit insilico.com");

        // Add the text part to the multipart
        multipart.addBodyPart(messageBodyPart);

        // Create the html part
        messageBodyPart = new MimeBodyPart();
        String htmlMessage = "Hello, Your order of "+count+" items has been placed. For further details visit insilico.com";
        messageBodyPart.setContent(htmlMessage, "text/html");


        // Add html part to multi part
        multipart.addBodyPart(messageBodyPart);

        // Associate multi-part with message
        message.setContent(multipart);

        // Send message
        Transport transport = session1.getTransport("smtp");
        transport.connect("smtp.gmail.com", "aditi.a.dandekar", "aditi1996");
        System.out.println("Transport: "+transport.toString());
        transport.sendMessage(message, message.getAllRecipients());


    } catch (AddressException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        
    }
    
    request.setAttribute("congo","true");
    return new ModelAndView("placeorder","d","fvdfd");
    }
}
