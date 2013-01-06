import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
public class UserLogin extends GenericServlet
{
	Connection con;
	Statement sment;
	int l;
	public void init(ServletConfig conf)throws ServletException
	{
		l=0;
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:login.mdb");
		sment=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 
			
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{

                                 
                                res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String s=req.getParameter("UserName");
                System.out.println("User Name: "+s);
		String ss=req.getParameter("password");
                 System.out.println("User Name: "+ss);
		
		try
		{
			ResultSet rs=sment.executeQuery("Select * from login");
		while(rs.next())
		{
			if(s.equals(rs.getString(1)) && ss.equals(rs.getString(2)))
                                                   l=1;
		}

		
		if(l==1)

		{

			RequestDispatcher rd = req
						.getRequestDispatcher("Home.html");
				rd.forward(req, res);

			
			/*pw.println("<html> <body  background='bg.jpg' text='#FF0000' align=center>");
			pw.println("<h2 align=center>ON-LINE JAVA COMPILER</h2>");
			pw.println("<img align=right border=0 src='line.gif'>");
			pw.println("<br><br><br>");
			pw.println("<table border=5 width=75%  align=right>");
			pw.println("<td><a href='createfile.html'><h4 align=center>CREATE A JAVA FILES</h4></a>");
			pw.println("<tr><td><a href='compile.html'><h4 align=center>COMPILE JAVA FILE<h4></a>");
                        pw.println("<tr><td><a href='run.html'><h4 align=center>Run Compiled java file<h4></a>");             
			
				
				
			pw.println("</table>");
			
			
			pw.println("</body>");
			pw.println("</html>");*/
		}
		else
		{
                    RequestDispatcher rd = req
						.getRequestDispatcher("FileAction.html");
				rd.forward(req, res);
//				pw.println("<html>");
//				pw.println("<body bgcolor=pink align=center>");
//				pw.println("<br><br>");
//				pw.println("<center><hr><h2><b>ERROR REPORT</b></h2>");
//				pw.println("<hr>");
//				pw.println("<center><h2><U><b>YOU ARE NOT MEMBER OF THIS WEB SITE</b></u></h2>");
//				//pw.println("<center><br><b>DO YOU WANT GO TO NEW USER ID</b>");
//				pw.println("<center><a href='userinfo.html'>Click Here to Register</img></a>"); 
//				pw.println("</html>");
		}
		pw.close();
		}catch(Exception e){System.out.println(e);}
		l=0;
	}
}


