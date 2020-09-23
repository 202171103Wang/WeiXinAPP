<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能查询</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息</div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.jsp" target="rightFrame">首页</a><i></i></li>
        <li><cite></cite><a href="Shop_select_servlet" target="rightFrame">商铺信息管理</a><i></i></li>
        <li><cite></cite><a href="person_message.jsp" target="rightFrame">个人信息管理</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>本店的菜品
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="Good_select_servlet" target="rightFrame">菜品信息</a><i></i></li>
        </ul>     
    </dd> 
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>订单</div>
    <ul class="menuson">
        <li><cite></cite><a href="Order_selecttn_servlet" target="rightFrame">未处理订单</a><i></i></li>
        <li><cite></cite><a href="Order_selectt_servlet" target="rightFrame">当日订单</a><i></i></li>
        <li><cite></cite><a href="Order_selecth_servlet" target="rightFrame">历史订单</a><i></i></li>
    </ul>    
    </dd>   
    
    </dl>
</body>
</html>