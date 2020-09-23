package servlet;
import javabean.*;
import online_db.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Good_delete_servlet
 */
@WebServlet("/Good_delete_servlet")
public class Good_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Good_delete_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String no=request.getParameter("i");
	    int i=Integer.parseInt(no);
	    ArrayList<Good> goods=(ArrayList<Good>)session.getAttribute("goods");
	    Good g=goods.get(i);
		String g_id=g.getGood_id();
		Good_db goodb=new Good_db();
		int result=goodb.delete(g_id);
		goodb.close();
		if(result>0)
		{
			response.sendRedirect("index.jsp");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('É¾³ýÊ§°Ü£¡');history.go(-1);</script>");
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
