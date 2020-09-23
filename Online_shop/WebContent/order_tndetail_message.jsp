<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*,java.util.*"%>
    <%
       ArrayList<Order_detail_good> order_details=(ArrayList<Order_detail_good>)session.getAttribute("order_tndetails");
       String Orderid=(String)session.getAttribute("tnorderid");
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">订单</a></li>
    <li><a href="Order_selecttn_servlet">未处理订单信息</a></li>
    <li><a href="#">订单详情</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
        <ul class="toolbar1">
        <li>订单编号为：<%=Orderid %></li>
        </ul>
        <ul class="toolbar1">
        <li><a href="Order_deal_servlet?orderid=<%=Orderid%>"><span><img src="images/t05.png" /></span>订单完成</a></li>
        </ul>
    </div>
    <%if (order_details.size()==0) {%>
    <div>暂无订单</div>
    <%}else{ %>
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th>名称及介绍</th>
    <th>种类</th>
    <th>所购买的数量</th>
    <th>价格</th>
    </tr>
    </thead>
    
    <tbody>
    
    <% for (int i=0;i<order_details.size();i++){ %>
    <tr>
    <td ><img src="<%=order_details.get(i).getGood_img()%>" style="width:40px;height:40px;"/></td>
    <td><a href="#"><%=order_details.get(i).getGood_name() %></a><p><%=order_details.get(i).getGood_mess() %></p></td>
    <td>菜品分类<p><%=order_details.get(i).getGood_kind() %></p></td>
    <td><%=order_details.get(i).getNum()%></td>
    <td><%=order_details.get(i).getGood_price() %></td>
    </tr>
    <%} %>
    </tbody>
    </table>
    <%} %>

    <div class="pagin">
    	<div class="message">共<i class="blue"><%=order_details.size() %></i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem current"><a href="javascript:;">1</a></li>
        <li class="paginItem"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
