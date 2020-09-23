<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*"%>
   <% 
       Shop s=(Shop) session.getAttribute("shop");  
   %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商铺信息</title>
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
    <li><a href="#">管理信息</a></li>
    <li><a href="#">商铺信息管理</a></li>
    </ul>
    </div>
    <form name="form_2" action="Shop_update_servlet" method="post" enctype="multipart/form-data">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">修改商铺信息</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您试用修改商铺信息功能！</div>
    
    <ul class="forminfo">
    <li><label>商铺编号<b>*</b></label><input name="Shop_id" type="text" class="dfinput" value="<%=s.getShop_id()%>"  style="width:518px;" readonly="readonly"/></li>
    <li><label>商铺名称<b>*</b></label><input name="Shop_name" type="text" class="dfinput" value="<%=s.getShop_name() %>"  style="width:518px;"/></li>
    <li><label>商铺图片<b>*</b></label><img src="images/<%=s.getShop_img()%>" style="width:40px;height:40px;"/>
    <input type="file" name="Shop_img"  style="width:518px;" class="dfinput"/></li>
    <li><label>商铺营业状态<b>*</b></label>  
    <div class="vocation">
    <select class="select1" name="Shop_state">
    <% if(s.getShop_state()==1) {%>
          <option value="">正常营业</option>
          <% }else {%>
          <option value="">暂停营业</option>
          <% } %>    
    <option value="暂停营业">暂停营业</option>
    <option value="正常营业">正常营业</option>
    </select>
    </div>
    <div class="formtext">注意! 正常营业状态<b>早上 6：10-8：00    中午  10:00-13:40  晚上 17:00-20:20</b></div>
    <li><label>商铺地址<b>*</b></label><input name="Shop_place" type="text" class="dfinput" value="<%=s.getShop_place() %>"  style="width:518px;" readonly="readonly"/></li>
    <div class="formtext">注意!<b>东一，一楼，三号窗口：（E01-01-03)</b></div>
    <li>
    <input type="submit" value="修改"  class="btn"/>
    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="reset" value="取消"  class="btn"/>
    </li>
    <div class="formtext"><b>地址和编号不可修改！</b></div>
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