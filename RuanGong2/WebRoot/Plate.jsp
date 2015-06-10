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
   <%String UserId =(String)request.getAttribute("UserId"); %>
    <% String addr1 = "virAction0?module=0&UserId="+UserId;%>  
    <% String addr2 = "virAction0?module=1&UserId="+UserId;%>
    <% String addr3 = "virAction0?module=2&UserId="+UserId;%>
    <% String addr4 = "virAction0?module=3&UserId="+UserId;%>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">主页<span class="sr-only">(current)</span></a><br></li>
        <li class = "active"><a href=<%=addr1 %>>我的餐盘</a><br></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的咕噜 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href=<%=addr2%>>个人资料</a><br></li>
            <li><a href=<%=addr4 %>>订餐记录</a><br></li>
            <li><a href="#">待评美食</a><br></li>
            <li class="divider">%<br></li>
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
<form action = "Action5">
<input type="hidden" value="<%=request.getAttribute("UserId")%>" name = "UserId"/>
<div class="row">
<div class="col-lg-2"></div>
<div class="col-lg-8">

<h1>我的餐盘&nbsp;&nbsp;
<small>
<%String ALL = (String)request.getAttribute("AllPills");%>
<span class="label label-default">￥<%=ALL%></span>
&nbsp;&nbsp;
<button type="submit" name = "submit" value = "changeInfo" class="btn btn-warning">修改信息</button>
</small>
</h1>
<hr>
<%String [][]orders = (String[][])request.getAttribute("Orders"); %>


<%int Num = orders.length; %>
<%for(int i = 0;i<Num;i++){ %>

<div class="panel panel-success">

<div class="panel-heading"><span class="label label-warning"><%=i%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><%=orders[i][1]%></div>
<div class="panel-body"><%=orders[i][2]%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <span class="label label-default">￥<%=orders[i][3]%></span>
<div align = "right">
<button type="submit" name = "submit" value = b<%=i%> class="btn btn-success" style="margin-left:50%;width:80px">结算</button>
<button type="submit" name = "submit" value = <%=i%> class="btn btn-default" style="width:80px">删除</button></div>
</div>
</div>

<%} %>
</div>
<div class="col-lg-2"></div>
</div>
</form>
</div>
</body>
</html>
