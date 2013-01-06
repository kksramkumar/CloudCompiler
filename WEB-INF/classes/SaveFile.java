import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SaveFile extends GenericServlet
{
	FileOutputStream fos;
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		String s=req.getParameter("textarea");
		String ff=req.getParameter("filename");
		String dir=req.getRemoteHost();
		File kk=new File("c:/"+dir);
		boolean bb=kk.mkdir();
		PrintWriter pw=res.getWriter();
		fos=new FileOutputStream(kk+"/"+ff);
		int end=s.length();
		int start=0;
		while(start<end)
		{
			fos.write(s.charAt(start));
			start++;	
		}
		fos.close();
		
//                RequestDispatcher rd = req
//						.getRequestDispatcher("SavedSuccessfully.html");
//				rd.forward(req, res);
//		pw.println("<html>");
//		pw.println("<html>");
//		pw.println("<body bgcolor=pink align=center>");
//		pw.println("<br><br>");
//		pw.println("<center><hr><h2><b>FILE ACTION REPORT</b></h2>");
//		pw.println("<hr>");
//		pw.println("<hr size=5 width=50% align=center><br><br>");
//		pw.println("<center>"+ff+": FILE IS SUCESSFULLY STORED");
//		pw.println("<hr size=5 width=100% align=center>");
//		pw.println("<a href='compile.html'>");
//		pw.println("<center>ARE YOU GO TO  COMPILER SECTION</a>");				
//		pw.println("</body>");
//		pw.println("</html>");
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
		pw.close();
	}
}