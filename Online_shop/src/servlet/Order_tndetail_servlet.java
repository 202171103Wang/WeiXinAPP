package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.*;
import online_db.*;
/**
 * Servlet implementation class Order_tndetail_servlet
 */
@WebServlet("/Order_tndetail_servlet")
public class Order_tndetail_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_tndetail_servlet() {
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
	    ArrayList<Order_info> orders=(ArrayList<Order_info>)session.getAttribute("orders_tn");
	    Order_info o=orders.get(i);
		String orderid=o.getOrder_id();
		Order_detail_db order_detaildb=new Order_detail_db();
		ArrayList<Order_detail_good> order_details=order_detaildb.select_all_Order_detail(orderid);
		order_detaildb.close();
		session.setAttribute("order_tndetails", order_details);
		session.setAttribute("tnorderid", orderid);
		response.sendRedirect("order_tndetail_message.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
