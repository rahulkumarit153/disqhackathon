/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAHUL
 */
public class AdmLogin extends HttpServlet
{
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
  String uid=req.getParameter("n1");
  String pwd=req.getParameter("n2");
  
  PrintWriter out=res.getWriter();
 try{  
     
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");  
                               
PreparedStatement ps=con.prepareStatement("select * from ADMLOGIN where id=?");  
ps.setString(1,uid);
   ResultSet rs=ps.executeQuery();
   
    if(rs.next())
      {
          
 String pass=rs.getString(2);
 if(pwd.equals(pass))
    {
     res.setStatus(res.SC_MOVED_TEMPORARILY);  
    res.setHeader("location", "admin.html");
    }
   // JOptionPane.showMessageDialog(null,"You are  registered now !");
}
 }catch(Exception e){} }
    

   
}
