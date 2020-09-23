package servlet2;
import online_db2.*;
import javabean2.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javabean2.Goods;

/**
 * Servlet implementation class Order_addservlet
 */
@WebServlet("/Order_addservlet")
public class Order_addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_addservlet() {
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
		String Order_personid=request.getParameter("personid");
		String Order_shopid=request.getParameter("shopid");
		String carts=request.getParameter("array");
		 Gson gson = new Gson();
	      //把json序列化为List对象
	      List<Goods> o = gson.fromJson(carts, new TypeToken<List<Goods>>() {
	      }.getType());
		
		Order_infoDB idb=new Order_infoDB();
	    int Order_id=idb.maxid()+1;
	    int Order_num=idb.maxnum()+1;//当日取货码    
	    int Order_good_num=o.size();
	    Float Order_sum=Float.parseFloat(request.getParameter("sum"));
	    String wait_time="20";
		//插入到info表
	    Order_info in=new Order_info();
		in.setOrder_id(Order_id);
		in.setOrder_num(Order_num);
		in.setOrder_personid(Order_personid);
		in.setOrder_good_num(Order_good_num);
		in.setOrder_sum(Order_sum);
		in.setOrder_wait_time(wait_time);
		in.setOrder_shopid(Order_shopid);
	    int x=	idb.addinfo(in);
	    idb.close();
			    
	    //插入到detail表
	   int y=0;
	   Order_detailDB ddb=new Order_detailDB();
	   for(int i=0;i<o.size();i++)
	   {
		   Order_detail d=new Order_detail();
		   d.setOrder_id(Order_id);
		   d.setGood_id(o.get(i).getGoodid());
		   d.setNum(o.get(i).getBuynum());
		   y+=ddb.adddetail(d);
	   }
	   ddb.close();
       int s=x+y;
       if(s==Order_good_num+1)
       {
    	   Writer out = response.getWriter(); 
   		   out.write("提交订单成功！");
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
