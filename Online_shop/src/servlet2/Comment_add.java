package servlet2;
import online_db2.*;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javabean2.*;
/**
 * Servlet implementation class Comment_add
 */
@WebServlet("/Comment_add")
public class Comment_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "Get,Post");
		String personid=request.getParameter("personid");
		String shopid=request.getParameter("shopid");
		String message=request.getParameter("message");
		Comment c=new Comment();
		c.setCpersonid(personid);
		c.setCshopid(shopid);
		c.setCmessage(message);
		CommDB cdb=new CommDB();
	    int result =cdb.addinfo(c);
	    if(result>0)
		{
		  Writer out = response.getWriter(); 
		  out.write("评价成功！");
          out.flush(); 
		}
		else {
			Writer out = response.getWriter(); 
			  out.write("评价失败!");
	          out.flush(); 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
