<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*,java.util.*"%>
    <%
       ArrayList<Order_info> orders=(ArrayList<Order_info>)session.getAttribute("orders_tn");
       Person_db pdb=new Person_db();
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
    <li><a href="#">未完成订单信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
        
    </div>
    
    <%if (orders.size()==0) {%>
    <div>暂无订单</div>
    <%}else{ %>
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">订单编号</th>
    <th>取货码</th>
    <th>取件人</th>
    <th>电话号码</th>
    <th>商品数量</th>
    <th>总计金额</th>
    <th>生成订单时间</th>
    <th>订单状态</th>
    <th>处理</th>
    </tr>
    </thead>
    
    <tbody>
    
    <% for (int i=0;i<orders.size();i++){ %>
    <tr>
    <td><%=orders.get(i).getOrder_id() %></td>
    <td ><%=orders.get(i).getOrder_num() %></td>
    <td><%=pdb.SelectById(orders.get(i).getOrder_personid()).getPerson_name()%>
    <td><%=pdb.SelectById(orders.get(i).getOrder_personid()).getPerson_call()%>
    <td><a href="#"><%=orders.get(i).getGood_num()%></a></td>
    <td><%=orders.get(i).getOrder_sum() %></td>
    <td><%=orders.get(i).getOrder_time() %></td>
    <%   if(orders.get(i).getOrder_state()==1){ %>
    <td>已完成</td>
    <%}else{ %>
    <td>未完成</td>
    <%} %>
    <td><img src="images/t04.png" /><a href ="Order_tndetail_servlet?i=<%=i%>">详情</a></td>
    </tr>
    <%} %>
    </tbody>
    
    </table>
    <%} %>

    <div class="pagin">
    	<div class="message">共<i class="blue"><%=orders.size() %></i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
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
        <%pdb.close(); %>
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
