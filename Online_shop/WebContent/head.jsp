<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*"%>
    <% 
    
    String name=(String)session.getAttribute("name");
    String n=(String)session.getAttribute("n");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    </div>
        
    <ul class="nav">
    <li><a href="person_message.jsp" target="rightFrame"><img src="images/icon01.png" title="个人信息" /><h2>个人信息</h2></a></li>
    <li><a href="Shop_select_servlet" target="rightFrame"><img src="images/icon02.png" title="店铺信息" /><h2>店铺信息</h2></a></li>
    <li><a href="Good_select_servlet" target="rightFrame"><img src="images/icon03.png" title="菜单信息" /><h2>菜单信息</h2></a></li>
    <li><a href="Order_selecttn_servlet" target="rightFrame"><img src="images/icon04.png" title="订单处理" /><h2>订单处理</h2></a></li>
    <li><a href="Order_selecth_servlet" target="rightFrame"><img src="images/icon05.png" title="历史订单" /><h2>历史订单</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="Login.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><%=name %></span>
    <i>消息</i>
    <b><%=n %></b>
    </div>    
    
    </div>
</body>
</html>