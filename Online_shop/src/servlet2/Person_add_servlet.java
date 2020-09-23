package servlet2;
import online_db2.*;
import javabean2.*;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Person_add_servlet
 */
@WebServlet("/Person_add_servlet")
public class Person_add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person_add_servlet() {
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
		String openid=request.getParameter("openid");
		String img=request.getParameter("img");
		String name=request.getParameter("name");
		Person p=new Person();
		p.setPerson_id(openid);
		p.setPerson_img(img);
		p.setPerson_name(name);
		p.setPerson_professor(0);
		p.setPerson_pwd(openid);
		PersonDB pdb=new PersonDB();
		if(!pdb.isLogin(openid, openid))
		{
			int result=pdb.addUser(p);
			if(result==1)
			{
			  Writer out = response.getWriter(); 
			  out.write("success×¢²á");
	          out.flush(); 
			}
			else {
				Writer out = response.getWriter(); 
				  out.write("×¢²áÊ§°Ü");
		          out.flush(); 
			}
		}
		else {
			 Writer out = response.getWriter(); 
			  out.write("ÒÑ´æÔÚ");
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
