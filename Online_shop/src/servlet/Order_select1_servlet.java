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
 * Servlet implementation class Order_select1_servlet
 */
@WebServlet("/Order_select1_servlet")
public class Order_select1_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_select1_servlet() {
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
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		Order_db orderdb=new Order_db();
		ArrayList<Order_info> orders=new ArrayList<Order_info>();
		if(day==""&&month=="")
		{
			orders=orderdb.select2_Order(year, shopid);
		}
		else if(day==""&&month!=""&&year!="")
		{
			orders=orderdb.select3_Order(year, month, shopid);
		}
		else if(day!=""&&month!=""&&year!="") {
			orders=orderdb.select1_Order(year, month, day, shopid);
		}
		if(day==""&&month==""&&year==""){
			orders=orderdb.select_all_Order(shopid);
		}
		orderdb.close();
		session.setAttribute("orders",orders);
		response.sendRedirect("order_message.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
