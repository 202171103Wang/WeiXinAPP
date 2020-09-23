<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加菜品</title>
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
    <li><a href="#">增加菜品</a></li>
    </ul>
    </div>
    <form name="form_2" action="Good_add_servlet" method="post" enctype="multipart/form-data">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">增加菜品</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您试用增加菜品功能！</div>
    
    <ul class="forminfo">
    <li><label>菜品名称<b>*</b></label><input name="Good_name" type="text" class="dfinput" value="请填写新增加的菜品名称"  style="width:518px;"/></li>
   
    <li><label>菜品分类<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1" name="Good_kind">
    <option>早餐</option>
    <option>午餐</option>
    <option>晚餐</option>
    </select>
    </div>
    
    </li>
    
    <li><label>菜品数量<b>*</b></label>
    
    <div class="vocation">
    <select class="select1" name="Good_num">
    <option>100</option>
    <option>200</option>
    <option>300</option>
    <option>400</option>
    </select>
    </div>
    
    
    
    </li>
    <li><label>菜品价格<b>*</b></label>
    <input name="Good_price" type="text" class="dfinput" value="请填写新增加菜品价格"  style="width:518px;"/></li>
    <li><label>菜品图片<b>*</b></label>
    <input type="file" name="Good_img"  style="width:518px;" class="dfinput"/></li>
    <li><label>商品附加信息<b>*</b></label>
    

    <textarea id="content7" name="Good_mess" style="width:700px;height:250px;visibility:hidden;"></textarea>
    
    </li>
    <li>
    <input type="submit" value="添加"  class="btn"/>
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
