import javax.servlet.*;
import java.io.*;


public class RunFile extends GenericServlet
{
     public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
     {
	
                res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
        pw.println("<body>");
      pw.println("  <table width=286 height=256 border=1 align=center bgcolor=#993366>");
      pw.println(" <tr>");
      pw.println(" <td width=208 height=20 align=center><h1> Output<h1> </td>");
      pw.println(" </tr>");
      pw.println(" <tr>");
      pw.println("<td height=220 valign=top align=left bgcolor=#000000 style=color:#FFFFFF><h3>");
    
	
   
	String line;
	String s=req.getParameter("file");
        String dir = req.getRemoteHost();
	//s= s.substring(0,s.length()-6);
	//String dir = "c:/"+s1+"/"+s;
	//System.out.println(s2);
			InputStream is;
			int c;
			//FileInputStream fs=new FileInputStream("c:/"+dir+"/"+s);
			Runtime r=Runtime.getRuntime();
			System.out.println("c:/"+dir+"/"+s);
			//Process temp = r.exec("javac "+"c:/"+dir+"/"+s+".java");
			s= s.substring(0,s.length()-6);
			
			Process p=r.exec("java -cp "+"c:/"+dir+"/ "+s);
			//Process p=r.exec("java -cp"+"C:\127.0.0.1\Abc");
 				BufferedReader bri = new BufferedReader
    				    (new InputStreamReader(p.getInputStream()));
  				    
 			     while ((line = bri.readLine()) != null) {
    						   pw.print(line);
     							 }
     							 bri.close();
			is=p.getErrorStream();
			c=is.read();
			if( c!=-1)
			{
				
				
				while(c!=-1)
				{
					c=is.read();
					
					if((char)c=='^')
                                                            {
						pw.println("<br>");
						c=is.read();
					}
					pw.print((char)c);

				}
                                 pw.println(" </td>");
                               pw.println(" </tr>");
 
                                pw.println("  </table>");
                                pw.println(" </body>");
                                 pw.println("</html>");
			}



	/*////////////////////////////////////////
	InputStream is;
            // OutputStream os;
                int c;
	try{
	Runtime r=Runtime.getRuntime();
	//Process p=r.exec("javac "+ s);
                Process p1=r.exec("java "+ s2);  
                                              
	//is=p.getErrorStream();
                  is=p1.getInputStream(); 
	//System.out.println(is.available());
                                                                                                 
	c=is.read();
	
	
                       while(c!=-1)
	       {
		System.out.print((char)c);
                                // pw.print((char)c);
                                 c=is.read();
	       }
	
			
                                
                                  
                                       
	}catch(Exception e){e.print}*/	
	}
}