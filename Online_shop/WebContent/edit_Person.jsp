<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javabean.*,online_db.*,servlet.*"%>
   <% 
    Person p=(Person)session.getAttribute("person"); 
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
<script type="text/javascript">
if(theform.Person_pwd.value != theform.Person_pwd2.value) {
    alert("两次密码不一致，请重新输入！");
    theform.userpwd2.value=="";
    theform.userpwd2.focus();
    return false;
}
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">管理信息</a></li>
    <li><a href="#">账号修改</a></li>
    </ul>
    </div>
    <form name="form_3" action="Person_update_servlet" method="post" enctype="multipart/form-data" onSubmit="return check(this)">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">修改个人账号信息</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <ul class="forminfo">
    <li><label>头像<b>*</b></label><img src="images/<%=p.getPerson_img()%>" style="width:40px;height:40px;"/>
    <input type="file" name="Person_img"style="width:518px;"  value="修改"" class="dfinput"/></li>
    <li><label>姓名<b>*</b></label><input name="Person_name" type="text" class="dfinput" value="<%=p.getPerson_name()%>"  style="width:518px;"/></li>
    <li><label>账号<b>*</b></label><input name="Person_id" type="text" class="dfinput" value="<%=p.getPerson_id()%>"  style="width:518px;" readonly="readonly"/></li>
    <li><label>密码<b>*</b></label><input name="Person_pwd" type="password" class="dfinput" value="<%=p.getPerson_pwd() %>"  style="width:518px;"/></li>
    <li><label>密码确认<b>*</b></label><input name="Person_pwd2" type="password" class="dfinput" value="<%=p.getPerson_pwd() %>"  style="width:518px;"/></li>
    <li><label>联系方式<b>*</b></label><input name="Person_call" type="text" class="dfinput" value="<%=p.getPerson_call()%>"  style="width:518px;"/></li>
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