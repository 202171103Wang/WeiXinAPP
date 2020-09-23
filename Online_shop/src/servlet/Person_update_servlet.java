package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javabean.*;
import online_db.*;

/**
 * Servlet implementation class Person_update_servlet
 */
@WebServlet("/Person_update_servlet")
public class Person_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	final public void init(ServletConfig config)throws ServletException{
    	this.config=config;
    }      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person_update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload upload=new SmartUpload();
		upload.initialize(config,request,response);
		upload.setCharset("utf-8");
		upload.setAllowedFilesList("jpg,jpeg,bmp,png");
		try {
			upload.upload();
			upload.save("images");
		}catch(SmartUploadException e)
		{
			System.out.println(e.getMessage());
		}
		String person_id=upload.getRequest().getParameter("Person_id");
		String person_pwd=upload.getRequest().getParameter("Person_pwd");
		String person_name=upload.getRequest().getParameter("Person_name");
		String person_call=upload.getRequest().getParameter("Person_call");
	    int person_professor=1;
		File file=upload.getFiles().getFile(0);
	    
	    Person p=new Person();
	    p.setPerson_id(person_id);
	    p.setPerson_img(file.getFileName());
	    p.setPerson_name(person_name);
	    p.setPerson_call(person_call);
	    p.setPerson_professor(person_professor);
	    p.setPerson_pwd(person_pwd);
	    Person_db persondb=new Person_db();
	    int result=persondb.updatePerson(p);
	    persondb.close();
	    if(result>0)
		{
	    	response.sendRedirect("index.jsp");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('ÐÞ¸ÄÊ§°Ü£¡');history.go(-1);</script>");
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
