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
 * Servlet implementation class Shop_update_servlet
 */
@WebServlet("/Shop_update_servlet")
public class Shop_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	final public void init(ServletConfig config)throws ServletException{
    	this.config=config;
    }     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shop_update_servlet() {
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
		String shop_id=upload.getRequest().getParameter("Shop_id");
		String shop_name=upload.getRequest().getParameter("Shop_name");
		String shop_state=upload.getRequest().getParameter("Shop_state");
		int state=0;
		if(shop_state.equals("正常营业"))
		{
			state=1;
		}
		File file=upload.getFiles().getFile(0);
	    Shop s=new Shop();
	    s.setShop_id(shop_id);
	    s.setShop_img(file.getFileName());
	    s.setShop_name(shop_name);
	    s.setShop_state(state);
	    Shop_db shopdb=new Shop_db();
	    int result=shopdb.updateShop(s);
	    shopdb.close();
	    if(result>0)
		{
	    	response.sendRedirect("index.jsp");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('修改失败！');history.go(-1);</script>");
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
