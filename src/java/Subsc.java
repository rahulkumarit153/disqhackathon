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
public class Subsc extends HttpServlet 
{
 @Override
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
  
  PrintWriter out=res.getWriter();
 try{  
     
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");  

    String result="<html>\n" +
"<head>\n" +
"<script src=\"job.js\" language=\"javascript\"></script>\n" +
"<style>\n" +
"#n1\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:0px;\n" +
"		background:#6D1635;\n" +
"		left:1px;\n" +
"		width:1364px;\n" +
"		height:100px;\n" +
"	}\n" +
"#jj\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:101px;\n" +
"		background:#030;\n" +
"		left:1px;\n" +
"		text-align:center;\n" +
"		color:#F09;\n" +
"		font-size:35px;\n" +
"		width:1364px;\n" +
"		height:46px;\n" +
"	}\n" +
"#n2\n" +
"	{\n" +
"		position:absolute;\n" +
"		left:5px;\n" +
"		top:150px;\n" +
"		width:1355px;\n" +
"		height:60px;\n" +
"		background:#CAF4F9;\n" +
"		text-align:center;\n" +
"		font-size:25px;\n" +
"		color:#62224A;\n" +
"	}\n" +
"#n3\n" +
"{\n" +
"	font-size:30px;\n" +
"	color:#003;\n" +
"	font-weight:bold;\n" +
"}\n" +
"#n4\n" +
"	{\n" +
"		position:fixed;\n" +
"		left:5px;\n" +
"		top:280px;\n" +
"		width:1355px;\n" +
"		height:30px;\n" +
"		background:#396;\n" +
"		font-size:25px;\n" +
"		color:#F3F\n" +
"	}\n" +
"#im3\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:0px;\n" +
"		height:45px;\n" +
"		left:20px;\n" +
"	}\n" +
"\n" +
"#im1\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:-10px;\n" +
"		height:120px;\n" +
"	}\n" +
"#im2\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:-10px;\n" +
"		height:110px;\n" +
"		left:200px;\n" +
"	}\n" +
"#in1\n" +
"	{\n" +
"		position:absolute;\n" +
"		left:1030px;\n" +
"		top:0px;\n" +
"		font-size:25px;\n" +
"		font-family:Cambria, \"Hoefler Text\", \"Liberation Serif\", Times, \"Times New Roman\", serif;\n" +
"		background:#6D1635;\n" +
"		width:300px;\n" +
"		border:none;\n" +
"		color:#F4A908;\n" +
"		font-weight:bold;\n" +
"	}\n" +
"#in2\n" +
"	{\n" +
"		position:absolute;\n" +
"		left:1060px;\n" +
"		top:40px;\n" +
"		font-size:45px;\n" +
"		background:#6D1635;\n" +
"		width:300px;\n" +
"		border:none;\n" +
"		color:#F4A908;\n" +
"		font-weight:bold;\n" +
"	}\n" +
"\n" +
"</style>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body onLoad=\"abc()\" bgcolor=\"#CAF4F9\">\n" +
"<form name=\"f1\" action=\"reg1.html\">\n" +
"<div id=\"n1\">\n" +
"<img id=\"im1\" src=\"l1.gif\">\n" +
"<img id=\"im2\" src=\"\">\n" +
"<input id=\"in1\" name=\"dat\">\n" +
"<input id=\"in2\" name=\"tm\">\n" +
"</div>\n" +
"<div id=\"jj\">All College Events\n" +
"<a href=\"User.html\"><img id=\"im3\" src=\"cs_leftImg.png\"></a></div>";                          
PreparedStatement ps=con.prepareStatement("select *  from Event");  


   ResultSet rs=ps.executeQuery();
   
    result+="<table id=n2 ><tr id=n3><td>NAME</td><td>TIME</td><td>PLACE</td><td>ID</td><td>DESCRIPTION</td></tr>";  
                                while(rs.next())
                                        

      {
 String nm=rs.getString("name");        
 String time=rs.getString("time");
 String place=rs.getString("place");
 String eid=rs.getString("eid");
 String msg=rs.getString("msg");
 result+="<tr id=n3><td>"+nm+"</td><td>"+time+"</td><td>"+place+"</td><td>"+eid+"</td><td>"+msg+"</td><td><button>Subscribe</button></td></tr>";
 
 
 
 
 
      }
    result+="</form></table></body></html>";
    out.println(result);
 }catch(Exception e){}
 
}
 
}

