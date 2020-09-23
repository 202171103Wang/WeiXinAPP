<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
      <style type="text/css">
       @import url(css/control_login.css);
       </style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
 <body>
    <div class="top">
 	<div class="login_panel">
    	<form name="form_1" action="Login_servlet" method="post">
        	<div class="logo"></div>
            <div class="sysname-zh">线上食堂后台管理</div>
            <div class="sysname-en" style="">Online canteen management System</div>
            <table border="0" style="width:300px;">
            	<tr>
                	<td class="lable" style="white-space:nowrap; letter-spacing: 0.5em; vertical-align: middle">账号：</td>
                    <td colspan="2">
                    <input type="text" name="person_id" class="login" />
                   	 </td>
                </tr>
                <tr>
                    <td class="lable" style="white-space:nowrap; letter-spacing: 0.5em; vertical-align: middle">密码：</td>
                    <td colspan="2">
                    <input type="password"name="person_pwd" class="login"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align:center">
                        <input type="submit" value="登录" class="botton" />
                        <input type="reset" value="重置" class="botton"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </div>
</body>

</html>