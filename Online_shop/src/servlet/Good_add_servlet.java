package servlet;
import javabean.*;
import online_db.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.*;
/**
 * Servlet implementation class Good_add_servlet
 */
@WebServlet("/Good_add_servlet")
public class Good_add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    final public void init(ServletConfig config)throws ServletException{
    	this.config=config;
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Good_add_servlet() {
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
		String Good_name=upload.getRequest().getParameter("Good_name");
		String Good_price=upload.getRequest().getParameter("Good_price");
		String Good_num=upload.getRequest().getParameter("Good_num");
		String Good_kind=upload.getRequest().getParameter("Good_kind");
		String Good_mess=upload.getRequest().getParameter("Good_mess");
	    File file=upload.getFiles().getFile(0);
	    HttpSession session=request.getSession();
	    Person p=(Person)session.getAttribute("person");
	    String Good_shopid=p.getPerson_id();
	    int num;
	    if(Good_num==null||Good_num.trim().equals(""))
	    	   num=0;
	    else
		   num=Integer.parseInt(Good_num);
	    float price;
	    if(Good_price==null||Good_price.trim().equals(""))
		   price=0;
	    else
		   price=Float.parseFloat(Good_price);
	    Good g=new Good();
	    g.setGood_img(file.getFileName());
	    g.setGood_name(Good_name);
	    g.setGood_kind(Good_kind);
	    g.setGood_num(num);
	    g.setGood_price(price);
	    g.setGood_mess(Good_mess);
	    g.setGood_shopid(Good_shopid);
	    Good_db goodb=new Good_db();
	    int result=goodb.addGood(g);
	    goodb.close();
	    if(result>0)
		{
			response.sendRedirect("index.jsp");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('√‹¬Î¥ÌŒÛ£°');history.go(-1);</script>");
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
