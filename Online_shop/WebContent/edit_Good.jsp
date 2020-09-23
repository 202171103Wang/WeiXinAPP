<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*,java.util.*"%>
    <% 
      Good g=(Good)session.getAttribute("edit_good");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">本店的菜品</a></li>
    <li><a href="good_message.jsp">菜品信息</a></li>
    <li><a href="#">修改信息</a></li>
    </ul>
    </div>
    <form name="form_3" action="Good_update2_servlet" method="post" enctype="multipart/form-data">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">修改菜品</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您试用修改菜品功能！</div>
    
    <ul class="forminfo">
    <li><label>菜品编号</label><input name="Good_id" type="text" class="dfinput" value="<%=g.getGood_id()%>"  style="width:518px;" readonly="readonly"/></li>
    <li><label>菜品名称<b>*</b></label><input name="Good_name" type="text" class="dfinput" value="<%=g.getGood_name()%>"  style="width:518px;"/></li>
   
    <li><label>菜品分类<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1" name="Good_kind">
    <option value=""><%=g.getGood_kind()%></option>
    <option value="早餐">早餐</option>
    <option value="午餐">午餐</option>
    <option value="晚餐">晚餐</option>
    </select>
    </div>
    
    </li>
    
    <li><label>菜品数量<b>*</b></label>
    
    <div class="vocation">
    <select class="select1" name="Good_num">
    <option value=""><%=g.getGood_num() %></option>
    <option value="100">100</option>
    <option value="200">200</option>
    <option value="300">300</option>
    <option value="400">400</option>
    </select>
    </div>
    
    
    
    </li>
    <li><label>菜品价格<b>*</b></label>
    <input name="Good_price" type="text" class="dfinput" value="<%=g.getGood_price() %>"  style="width:518px;"/></li>
    <li><label>菜品图片<b>*</b></label>
    <img src="images/<%=g.getGood_img()%>" style="width:40px;height:40px;"/>
    <input type="file" name="Good_img"style="width:518px;"  value="修改"" class="dfinput"/></li>
    <li><label>商品附加信息<b>*</b></label>
    

    <textarea id="content7" name="Good_mess" style="width:700px;height:250px;visibility:hidden;"><%=g.getGood_mess() %></textarea>
    
    </li>
    <li>
    <input type="submit" value="修改"  class="btn"/>
    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="reset" value="取消"  class="btn"/>
    </li>
    </ul>
    
    </div>       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script> 
    </div>
    </form>

</body>
</html>