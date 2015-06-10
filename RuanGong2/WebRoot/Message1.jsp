<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN"><head>
    <meta charset="gb2312">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Narrow Jumbotron Template for Bootstrap</title>

    <link href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- js files -->
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

  </head>
<body>
<div class="container-fluid">
<br>
<%String UserId = request.getParameter("UserId"); %>
 <input type="hidden" value = <%=UserId %> name = "UserId"/>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">咕噜咕噜</a>
    </div>
 <%UserId =(String)request.getAttribute("UserId"); %>
    <% String addr1 = "virAction0?module=0&UserId="+UserId;%>  
    <% String addr2 = "virAction0?module=1&UserId="+UserId;%>
    <% String addr3 = "virAction0?module=2&UserId="+UserId;%>
    <% String addr4 = "virAction0?module=3&UserId="+UserId;%>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">主页<span class="sr-only">(current)</span></a></li>
        <li class = "dropdown"><a href=<%=addr1 %>>我的餐盘</a></li>
        <li class="active">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的咕噜 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href=<%=addr2 %>>个人资料</a></li>
            <li><a href=<%=addr4 %>>订餐记录</a></li>
            <li><a href="#">待评美食</a></li>
            <li class="divider"></li>
            <li><a href=<%=addr3 %>>消息中心</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="黄焖鸡米饭">
        </div>
        <button type="submit" class="btn btn-default">咕噜一下</button>
  <%String UserName =(String)request.getAttribute("UserName"); %>
      </form>
       <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:void(0)">欢迎回来！<%=UserName%></a></li>
        <li><a href="http://3zelcp3ehbjyy42:8080/RuanGong/" onclick = "logout()">注销&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<br>
<br>
<form action = "Action4">
<%UserId = request.getParameter("UserId"); %>
 <input type="hidden" value = <%=UserId %> name = "UserId"/>
<div class="row">
<div class="col-lg-2"></div>
<div class="col-lg-8">

<h1>消息中心&nbsp;&nbsp;
<small>
<button type="button" class="btn btn-success">刷新消息</button>
</small>
</h1>
<%String[][] Orders =(String[][])request.getAttribute("Orders");%>
<%int count = Orders.length; %>
<hr>


<%String state = "未处理"; %>
<%for(int i = 0;i<count;i++){ %>
<%if(Orders[i][1].equals("1")){state = "已处理";} %>
<div class="panel panel-success">
<div class="panel-heading"><span class="label label-warning"><FONT COLOR:red>订单<%=i%>&nbsp;&nbsp;(<%=state%>)</FONT></span></div>
<div class="panel-body">
菜名：<%=Orders[i][2]%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格：<span class="label label-default">￥<%=Orders[i][3]%></span>
<hr>
用户：<%=Orders[i][4]%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
电话:<%=Orders[i][5]%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
地址:<%=Orders[i][6]%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<div class="panel-footer">
<table>
<tr><td>
<label for="exampleInputName2">预计到达时间：</label>
</td><td>
<input type="text" class="form-control" size = 10 id="exampleInputName2" placeholder="18:00" name = <%=Orders[i][0]%>>
&nbsp;&nbsp;
</td>
<td>
<div class="form-group">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-danger" name = "submit" value = <%=Orders[i][0]%>>去准备</button>
</div>
</td>
</tr></table>
</div>
</div>


<%} %>

</div>
<div class="col-lg-2"></div>
</div>
</div>
</form>
</body>
</html>

