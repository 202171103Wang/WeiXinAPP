package servlet2;
import javabean2.*;
import java.util.*;
import online_db2.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.Writer;

/**
 * Servlet implementation class menuservlet
 */
@WebServlet("/menuservlet")
public class menuservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuservlet() {
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
		String shopid=request.getParameter("shopid");
		String kind=request.getParameter("kind");
		ArrayList<Goods> g=new ArrayList<Goods>();
		GoodDB goodb=new GoodDB();
		g=goodb.menuselect(shopid,kind);
		Gson gson = new Gson();
		String goodlist=gson.toJson(g);
		Writer out = response.getWriter(); 
		out.write(goodlist);
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
