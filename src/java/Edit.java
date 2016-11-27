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
public class Edit extends HttpServlet 
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
    String result="";
    
    //PrintWriter out=res.getWriter();
 
  String uid=req.getParameter("eid");
System.out.println(uid);
  String nm="",time="",place="",id="",msg="";
  PrintWriter out=res.getWriter();
 try{  
     
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");  
                               
PreparedStatement ps=con.prepareStatement("select * from EVENT where eid=?");  
ps.setString(1,uid);
 ResultSet rs=ps.executeQuery();
   
    if(rs.next())
      {
          
         nm=rs.getString(1);
         time=rs.getString(2);
         place=rs.getString(3);
         id=rs.getString(4);
         msg=rs.getString(5);
        
         }
    
      }
 
    catch(Exception e){}
 result+="<!DOCTYPE html>\n" +
"<head>\n" +
"	<title>College Festival Event </title>\n" +
"	<meta name=\"keywords\" content=\"\" />\n" +
"	<meta name=\"description\" content=\"\" />\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<link href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,400,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/bootstrap-theme.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"</head>\n" +
"<body class=\"templatemo-bg-image-2\">\n" +
"	<div class=\"container\">\n" +
"		<div class=\"col-md-12\">			\n" +
"			<form class=\"form-horizontal templatemo-contact-form-1\" role=\"form\" action=\"Update\" method=\"post\">\n" +
"				<div class=\"form-group\">\n" +
"					<div class=\"col-md-12\">\n" +
"						<h1 class=\"margin-bottom-15\">Add College Event </h1>\n" +
"						\n" +
"					</div>\n" +
"				</div>				\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">		          	\n" +
"		            <label for=\"name\" class=\"control-label\">Event Name *</label>\n" +
"		            <div class=\"templatemo-input-icon-container\">\n" +
"		            	<i class=\"fa fa-user\"></i>\n" +
"		            	<input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"\" name=\"n1\" value="+nm+">\n" +
"		            </div>		            		            		            \n" +
"		          </div>              \n" +
"		        </div>\n" +
"                            \n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <label for=\"email\" class=\"control-label\">Event Time *</label>\n" +
"		            <div class=\"templatemo-input-icon-container\">\n" +
"		            	<i class=\"fa fa-envelope-o\"></i>\n" +
"		            	<input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"\" name=\"n2\" value="+time+" required>\n" +
"		            </div>\n" +
"		          </div>\n" +
"		        </div>\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <label for=\"website\" class=\"control-label\">Place *</label>\n" +
"		            <div class=\"templatemo-input-icon-container\">\n" +
"		            	<i class=\"fa fa-globe\"></i>\n" +
"                                <input type=\"text\" class=\"form-control\" id=\"website\" placeholder=\"\" name=\"n3\" value="+place+"  required>\n" +
"		            </div>\n" +
"		          </div>\n" +
"		        </div>\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <label for=\"subject\" class=\"control-label\">Event ID</label>\n" +
"		            <div class=\"templatemo-input-icon-container\">\n" +
"		            	<i class=\"fa fa-info-circle\"></i>\n" +
"		            	<input type=\"text\" class=\"form-control\" id=\"subject\" placeholder=\"\" name=\"n4\" value="+id+">\n" +
"		            </div>\n" +
"		          </div>\n" +
"		        </div>\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <label for=\"message\" class=\"control-label\">Description of  This Event</label>\n" +
"		            <div class=\"templatemo-input-icon-container\">\n" +
"		            	<i class=\"fa fa-pencil-square-o\"></i>\n" +
"		            	<textarea rows=\"8\" cols=\"50\" class=\"form-control\" id=\"message\" placeholder=\"\" name=\"n5\" value="+msg+">"+msg+"</textarea>\n" +
"		            </div>\n" +
"		          </div>\n" +
"		        </div>\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <div class=\"checkbox\">\n" +
"		                <label>\n" +
"		                  <input type=\"checkbox\"> Send a copy to my email.\n" +
"		                </label>\n" +
"		            </div>		            \n" +
"		          </div>\n" +
"		        </div>\n" +
"		        <div class=\"form-group\">\n" +
"		          <div class=\"col-md-12\">\n" +
"		            <input type=\"submit\" value=\"Update Event\" class=\"btn btn-success pull-right\">\n" +
"		          </div>\n" +
"		        </div>		    	\n" +
"		      </form>		      \n" +
"		</div>\n" +
"	</div>\n" +
"</body>\n" +
"</html>";
       
 out.println(result);
}
    
}
