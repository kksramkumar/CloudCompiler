import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SaveAgain extends GenericServlet
{	FileOutputStream fos;
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		String s=req.getParameter("text");
		String ff=req.getParameter("filename");
		String d=req.getRemoteHost();
		fos=new FileOutputStream("c:/"+d+"/"+ff);
		int end=s.length();
		int start=0;
		while(start<end)
		{
			fos.write(s.charAt(start));
			start++;	
		}
		fos.close();
		PrintWriter pw=res.getWriter();
//		pw.println("<html>");
//		pw.println("<body>");
//                pw.println("<table align=center >");
//                
//		pw.println("<h3 align=center> FILE ACTION REPORT</h3>");
//		pw.println("<hr size=5 width=50% align=center><br><br>");
//		pw.println("<center>"+ff+":FILE IS SUCESSFULLY SAVED");
//		pw.println("<hr size=5 width=100% align=center>");
//		pw.println("<a href='compile.html'>");
//		pw.println("<center>ARE YOU GO TO  COMPILER SECTION</a>");				
//		pw.println("</body>");
//		pw.println("</html>");
//		pw.close();	
                
                pw.println("<html>");
                pw.println("<head>");
                pw.println("<title>sucessfully stored</title>");
                pw.println("</head>");
                pw.println("<body>");
                pw.println("<table width=250 border=1 align=center bgcolor=#993366>");
                pw.println(" <tr><td><h3><center>File Action Report</center></h3></td></tr> ");
                pw.println("<tr><td> <h4><br/><br/><center>"+ff+"File is succesfully saved");
                pw.println("</h4></center>");
                pw.println("<a href='CompileJavaFile.html'>");
                pw.println("<center> Click here to Compile</center></a></td>");
                pw.println("</tr>");
                pw.println("</table>");
                pw.println("</body>");
                pw.println("</html>");

	}
}