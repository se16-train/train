<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>主页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script language="javascript" type="text/javascript" src="js/javascript.js"></script>
</head>
<script language="javascript" type="text/javascript" src="js/zimu.js"></script>
<script language="javascript">
	function  check(){
		var f = document.form1;
		if(f.qidian.value == f.zhongdian.value){
			alert("起点和终点不能相同！");
			return false;
		}
		else return true;
	}
</script>


<body onLoad="glowtext()"onResize="fix()"onScroll="fix()" >
	<div id="wrap">
	<div id="header">
		<div  align="center" id="glowdiv" style="position:absolute; visibility:visible; width:649px; text-align:center; top:6px; font-family:隶书; font-size:30pt; color:000000; height: 60px; right:150px;">  
</div>
	</div>
	<div class="clear"></div>
      <div id="top">
	  	<div class="clear"></div>
			<ul id="nav2" >
				<li><a href="main.jsp">主页</a></li>
				<li><a href="ModifyServlet?param=0">修改个人信息</a></li>
				<li><a href="ViewServlet?param=0">查看个人信息</a></li>
				<li><a href="passwordmodify.jsp">修改密码</a></li>
				<li><a href="AddServlet">添加火车票信息</a></li>
			</ul>
	  </div>
	  <div class="clear"></div>
	  
      <div id="content">	  
        <div id="sub"><!-- 右浮动-->
        
        </div>
		   <div id="sub2">
				<hr>
				<p align="center"><font size="6" color="blue">
				欢迎您<%=session.getAttribute("userName")%>进入本系统
				</font></p>
				<hr>
		   		<p align="center">查询火车票信息</p>
		   		<form name="form1" method="post" action="QueryServlet" onSubmit="return check()">
					<table width="280"cellpadding="1" cellspacing="1" border="1" align="center">
						<tr>
							<td width="100" height="12" align="center">车次</td>
							<td>
								<div align="center">
									<select name="checi">
										<option value="K234">K234</option>
										<option value="T261">T261</option>
										<option value="K104">K104</option>
										<option value="1024">1024</option>
										<option value="1023">1023</option>
										<option value="T934">T934</option>
										<option value="K310">K310</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">起点</td>
							<td>
								<div align="center">
									<select name="qidian">
										<option value="武昌">武昌</option>
										<option value="汉口">汉口</option>
										<option value="广州">广州</option>
										<option value="上海">上海</option>
										<option value="郑州">郑州</option>
										<option value="北京">北京</option>
										<option value="成都">成都</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">终点</td>
							<td>
								<div align="center">
									<select name="zhongdian">
										<option value="武昌">武昌</option>
										<option value="汉口">汉口</option>
										<option value="广州">广州</option>
										<option value="上海">上海</option>
										<option value="郑州">郑州</option>
										<option value="北京">北京</option>
										<option value="成都">成都</option>
									</select>
								</div>
							</td>
						</tr>						
					</table>
					<p align="center">
						  		<input name="chaxun" type="submit" id="chaxun" value="查询">
					</p>
				</form>
<!-- 				<img src="images/001.jpg" />  -->
        </div>		  
        
	  </div>
	  
	</div>
</body>
</html>
