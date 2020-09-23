<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*,java.util.*"%>
    <%
       ArrayList<Good> goods=(ArrayList<Good>)session.getAttribute("goods");
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
    <li><a href="#">本店的菜品</a></li>
    <li><a href="#">菜品信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><a href="good_add.jsp"><span><img src="images/t01.png"/></span>添加</a></li>
        </ul>    
    </div>
    
    
    <table class="imgtable">
    <%if (goods.size()==0) {%>
    <div>暂无商品</div>
    <%}else{ %>
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th></th>
    <th>标题及介绍</th>
    <th>种类</th>
    <th>数量</th>
    <th>价格</th>
    <th>处理</th>
    </tr>
    </thead>
    
    <tbody>
    <% for (int i=0;i<goods.size();i++){ %>
    <tr>
    <td><img src="images/t02.png" /><a href ="Good_update1_servlet?i=<%=i%>">修改</a></td>
    <td ><img src="<%=goods.get(i).getGood_img()%>" style="width:40px;height:40px;"/></td>
    <td><a href="#"><%=goods.get(i).getGood_name() %></a><p><%=goods.get(i).getGood_mess() %></p></td>
    <td>菜品分类<p><%=goods.get(i).getGood_kind() %></p></td>
    <td><%=goods.get(i).getGood_num()%></td>
    <td><%=goods.get(i).getGood_price() %></td>
    <td><img src="images/t03.png" /><a href ="Good_delete_servlet?i=<%=i%>">删除</a></td>
    </tr>
    <%} %>
    </tbody>
    
    </table>
    
<%} %>
    <div class="pagin">
    	<div class="message">共<i class="blue"><%=goods.size() %></i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
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
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
