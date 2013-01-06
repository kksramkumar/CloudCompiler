import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class NewUser extends GenericServlet
{
	Statement s;
	Connection con=null;
	String name,pass;
	ResultSet rs;
	int same;
	public void init(ServletConfig cfg)throws ServletException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compiler","root","root");
			s=con.createStatement();
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		same=0;
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		System.out.println("HAI");
		name=req.getParameter("user");
		pass=req.getParameter("pass");
		String fname=req.getParameter("user");
		String email=req.getParameter("email");
		String add=req.getParameter("loc");
		try
		{
			rs=s.executeQuery("select name from login");
			while(rs.next())
			{
				if(name.equalsIgnoreCase(rs.getString("name")))
				same=1;	
			}
			if(same==1)
			{
//				pw.println("<html>");
//				pw.println("<body bgcolor=pink align=center>");
//				pw.println("<br><br>");
//				pw.println("<center><hr><h2><b>ERROR REPORT</b></h2>");
//				pw.println("<hr>");
//				pw.println("<h3><U><i>THIS USER INFORMATION ALL READY EXIT</i></u></h3>");
//				pw.println("<center><br><b>DO YOU WANT GO TO NEW USER ID</b>");
//				pw.println("<center><a href='userinfo.html'>CLICK HERE</img></a>"); 
//				pw.println("</html>");
//					
            pw.println("<html>");
            pw.println("<title>Already exist</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<table width=340 border=1 align=center bgcolor=#993366>");
            pw.println(" <tr height=75><td align=center><h3>ERROR REPORT</h3></td></tr>");
            pw.println("<tr><td><h4><center>THIS USER IS ALREADY EXIST<center></h4>");		
            pw.println("<center><br><b>If u want to create new user</b>");		
            pw.println("<center><a href='userinfo.html'>CLICK HERE</a></td>"); 	
            pw.println(" </tr>");
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
			}  
			else
			{
			s.executeUpdate("insert into login values('"+name+"','"+pass+"')");
			s.executeUpdate("insert into newuser values('"+name+"','"+pass+"','"+email+"','"+add+"')");
//			pw.println("<html> <body  background='bg.jpg' text='#FF0000' align=center>");
//			pw.println("<h2 align=right> U ARE USER INFO IS SUCCESFULLY CREATED</h2>");
//			pw.println("<img align=right  border=0 src='line.gif'>");
//			pw.println("<br><br><br>");
//			pw.println("<table border=5 width=75%  align=right>");
//			pw.println("<td><a href='createfile.html'><h4 align=center>CREATE A JAVA FILES</h4></a>");
//			pw.println("<tr><td><a href='compile.html'><h4 align=center>COMPILE JAVA FILE<h4></a>");
//				
//			pw.println("</table>");
//			
//			pw.println("</body>");
//			pw.println("</html>");
                       RequestDispatcher rd = req
						.getRequestDispatcher("OnlineJavaCompiler.html");
				rd.forward(req, res);

			}
		}
		catch(Exception ex)
		{
			pw.println("<html>"+ex+"</html>");
		}
		
		pw.close();	
	}
}