package servlet2;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javabean2.Shops;
import online_db2.ShopDB;

/**
 * Servlet implementation class Shopbyname_servlet
 */
@WebServlet("/Shopbyname_servlet")
public class Shopbyname_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopbyname_servlet() {
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
		String name=request.getParameter("name");
		ArrayList<Shops> shops=new ArrayList<Shops>();
		ShopDB s=new ShopDB();
		shops=s.selectshopsbyname(name);
		Gson gson = new Gson();
		String shoplist=gson.toJson(shops);
		Writer out = response.getWriter(); 
		out.write(shoplist);
        out.flush();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
