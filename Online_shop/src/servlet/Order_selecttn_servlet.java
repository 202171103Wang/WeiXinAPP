package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Order_info;
import javabean.Person;
import online_db.Order_db;

/**
 * Servlet implementation class Order_selecttn_servlet
 */
@WebServlet("/Order_selecttn_servlet")
public class Order_selecttn_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_selecttn_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		Person p=(Person)session.getAttribute("person");
		String shopid=p.getPerson_id();
		Order_db orderdb=new Order_db();
		ArrayList<Order_info> orders=orderdb.select_todayn_Order(shopid);
		orderdb.close();
		session.setAttribute("orders_tn",orders);
		response.sendRedirect("order_todayn_message.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
