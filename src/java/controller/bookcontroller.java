/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import model.*;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.count;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Aditi Dandekar
 */
@Controller

public class bookcontroller {
    
   
    
    private static SessionFactory factory;
    @RequestMapping(value="/bookcontroller")
   
    public ModelAndView helloWorld(HttpServletRequest request) throws IOException, ServletException { 
        String name=request.getParameter("name"); 
        String price=request.getParameter("price");
        float price_f=Float.valueOf(price);
        String discount=request.getParameter("discount");
        float discount_f=Float.valueOf(discount);
        
        String author=request.getParameter("author");
        String publication=request.getParameter("publication");
        String language=request.getParameter("language");
        String rank=request.getParameter("rank");
        int rank_i=Integer.valueOf(rank);
        String description=request.getParameter("description");
        String genre=request.getParameter("genre"); 
        String n_img=request.getParameter("n_img");
        int n_imgi=Integer.valueOf(n_img);
        //model.Book=new model.Book(name,)
        
        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();  
        Transaction t=session.beginTransaction();
       //Long count=(Long) session.createCriteria("entity.Book").setProjection(Projections.rowCount()).uniqueResult();
       Query qu=session.createQuery("select MAX(pid) from Book");
       String b2=(String)qu.list().get(0);
       String b1=b2.substring(1);
       int count=Integer.parseInt(b1);
       count++;
       String pid="B"+Integer.toString(count);
      
      Product p=new Product(pid,discount_f,price_f,name);
       session.persist(p);
       int cnt=0;
        Book b=new Book(p,name,price_f,cnt,author,publication,genre,language,rank_i,description);
        session.persist(b);
        t.commit();
        session.close();
        String message =Long.toString(count);
        
      /*  String fname=file.getOriginalFilename();
        ServletContext context = null;
        String relpath="/images";
        String abpath=context.getRealPath(relpath);
        
        if(!file.isEmpty())
        {
            try{
                byte[] bytes=file.getBytes();
                BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File(fname)));
                stream.write(bytes);
                stream.close();
            }
            catch(Exception e)
            {
                System.out.println("Failed");
            }
            File uploaded=new File(abpath,fname);
        }*/
/*        File uploads=new File("/images/books/"+pid);
        if(!uploads.exists())
        {
            uploads.mkdir();
        }*/
        //for(int i=0;i<n_imgi;i++)
        //{
        //Part part=request.getPart("n_img"+i);
        //    String fnm=request.getParameter("n_img"+i);
          //  File f=receivedFiles.get(fnm);
         /* InputStream is=null;
          if(part!=null)
          {
              long size=part.getSize();
              String content=part.getContentType();
              is=part.getInputStream();
              String nm=i+".jpg";
              File file=new File(uploads,nm);
              Files.copy(is,file.toPath());
              
          }*/
            
    //}
      //  }
        
       // File file=new File(uploads,)
       /*if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
                        }
                        catch(Exception e)
                        {
                            
                        }
       }*/
                        
        return new ModelAndView("addbooks", "message", message);
    }
}
