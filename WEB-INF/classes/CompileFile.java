import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.lang.String.*;
public class CompileFile extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String s=req.getParameter("file");
                System.out.println("File name:- "+s);
               // s="Master.java";
		String dir=req.getRemoteHost();
		System.out.println("File dir:- "+dir);
		InputStream is;
		int c;
		int i=0;
		 StringExtract se=new StringExtract(s);
	                  if(se.extract())
		  {
			FileInputStream fs=new FileInputStream("c:/"+dir+"/"+s);
			Runtime r=Runtime.getRuntime();
			System.out.println("c:/"+dir+"/"+s);
			Process p=r.exec("javac "+"c:/"+dir+"/"+s);
			is=p.getErrorStream();
			c=is.read();
			if( c!=-1)
			{
				pw.println("<html>");
                                pw.println("<head>");
                                pw.println("<title>Successfully Compiled</title>");
                                pw.println("</head>");
                                pw.println("<body>");
				//pw.println("<body align =center background='vv.jpg'>");
				pw.println("<br><br>");
                                pw.println("<table width=340 border=1 align=center bgcolor=#993366>");
                                pw.println("<tr>");
                                pw.println("<td width=272 height=57 align=center valign=middle >ERROR REPORT");
                                pw.println("</td></tr>");
				//pw.println("<marquee><h2><b> ERROR REPORT</marquee>");
                                pw.println("<tr><td>");
                                
				pw.println("<form method='post' action='SaveAgain'>");
				pw.println("<pre>");
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
				pw.println("</pre>");
				pw.println("<br><textarea align=center name='text'rows='20' cols='45'>");
				while(fs.available()>0)
				{
					pw.print((char)fs.read());	
				}
				pw.println("</textarea><br></td></tr>");
                                pw.println("<tr border=4 align=center>");
//				pw.println("<table border=4 align=center>");
				pw.println("<td>File Path ");
				pw.println("<input type=text name='filename' value="+s+">");
				pw.println("<input type='submit' name='saveAgain' value='Update'></td></tr>");
				pw.println("</form></table></body></html>");
			
			}
			else
			{
//				pw.println("<html><body  background='vv.gif'>");
//				pw.println("<h3 align=center>SUCCESSFULLY COMPILED</h3>");
//				pw.println("<hr size=5 width=50% align=center><br><br><br>");
//				pw.println(s+":code is NO ERROR");
//				pw.println("<hr size=5 width=100% align=center>");
//				pw.println("<a href='createfile.html'>");
//				pw.println("<center>Create Another JavaFile</a>");
                            pw.println("<html>");
                            pw.println("<head>");
                            pw.println("<title>Successfully Compiled</title>");
                            pw.println("</head>");
                            pw.println("<body>");
                            pw.println("<table width=282 border=1 align=center bgcolor=#993366>");
                            pw.println("<tr>");
                            pw.println("<td width=272 height=57 align=center valign=middle>SUCCESSFULLY COMPILED");
                            pw.println("</td></tr>");
                            pw.println("<tr>");
                            pw.println("<td align=center><br /><br />"+s+" contains no Error ");
                            pw.println("<a href=RunJavaFile.html><br /><br />Click Here</a> to Run JavaFile</td>");
                            pw.println("</tr>");
                            pw.println("</table>");
                            pw.println("</body>");
                            pw.println("</html>");
			}
			
		}
		else
		{
                    RequestDispatcher rd = req
						.getRequestDispatcher("NotJavaFile.html");
				rd.forward(req, res);
//			pw.println("<html>");	
//            pw.println("<body background='vv.gif'>");
//			pw.println("<h3 align=center> ERROR REPORT</h3>");
//			pw.println("<hr size=5 width=50% align=center><br><br><br>");
//			pw.println("<h4>FILE IS NOT JAVA FILE SO AGAIN SELECT FILE</h4>");
//			pw.println("<hr size=5 width=100% align=center><br>");
//			pw.println("<a href='compile.html'>GO TO SELECT JAVA FILE</a>");
//                      
   
		}	 //pw.println("</body></html>");		
			pw.close();
		
	}
}