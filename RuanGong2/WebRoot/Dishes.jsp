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
<style>
* {
 margin:0;
 padding:0
}
html, body {
 height: 100%;
 width: 100%;
 font-size:12px
}
.white_content {
 display: none;
 position: absolute;
 top: 35%;
 left: 30%;
 width: 40%;
 padding: 2px 10px;
 border: 12px solid #D6E9F1;
 background-color: white;
 z-index:1002;
 overflow: auto;
}
.black_overlay {
 display: none;
 position: absolute;
 top: 5%;
 left: 5%;
 width: 100%;
 height: 100%;
 background-color:#f5f5f5;
 z-index:1001;
 -moz-opacity: 0.8;
 opacity:.80;
 filter: alpha(opacity=80);
}
.close {
 float:right;
 clear:both;
 width:100%;
 text-align:right;
 margin:0 0 6px 0
}
.close a {
 color:#333;
 text-decoration:none;
 font-size:14px;
 font-weight:700
}
.con {
 text-indent:1.5pc;
 line-height:21px
}
</style>

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

     <%String MesNum = (String)request.getAttribute("MesNum");%>
     
       <%String UserId =(String)request.getAttribute("UserId"); %>
    <% String addr1 = "virAction0?module=0&UserId="+UserId;%>  
    <% String addr2 = "virAction0?module=1&UserId="+UserId;%>
    <% String addr3 = "virAction0?module=2&UserId="+UserId;%>
    <% String addr4 = "virAction0?module=3&UserId="+UserId;%>
    <%String MesNum2 = (String)request.getAttribute("MesNum2");%>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">主页<span class="sr-only">(current)</span></a></li>
        <li class = "dropdown"><a href=<%=addr1%>>我的餐盘<span class="badge"><%=MesNum%> </span></a></li>
        <li class="active">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的咕噜 <span class="badge"><%=MesNum2%> </span><span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href=<%=addr2%>>个人资料</a></li>
            <li><a href=<%=addr4%>>订餐记录</a></li>
            <li><a href="#">待评美食</a></li>
            <li class="divider"></li>
            <li><a href=<%=addr3%>>消息中心<span class="badge"><%=MesNum2%> </span></a></li>
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
 <%String no =(String)request.getAttribute("no"); %>
 <%String ResName = (String)request.getAttribute("ResName");%>
 <%String []Names = (String[])request.getAttribute("Names");%>
<%String []Prices = (String[])request.getAttribute("Prices"); %>
<%String Res = "pictures/g"+no+".jpg"; %>
<%String []pAddr = new String[Names.length]; %>
<%for(int i = 1;i<=Names.length;i++){ %>
<%pAddr[i-1] = "pictures/h"+no+"/n"+i+".jpg";%>
<%} %>
<%String []Comments = (String [])request.getAttribute("Comments");%>

<!-- Modal -->
<div class="modal fade" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[0]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[1]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[2]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[3]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[4]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <%=Comments[5]%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<div class="jumbotron">
 <h2><%=ResName%></h2>
  <p>提供鸡汁汤包、盖浇饭、牛肉面等网上订餐</p>
  <p><a class="btn btn-success btn-lg" href="#" role="button">
<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
赞一下
</a></p>
</div>
<style>
.jumbotron{
	background:url(<%=Res%>)no-repeat 100% 100%;
}
</style>

<br>
<form action = "Action3">
<input type="hidden" value="<%=request.getAttribute("UserId")%>" name = "UserId"/>
<div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[0]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[0]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[0]%></span></h3>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p>
          
         <button type="submit" value = "1" name = "submit" id = "s1" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
          <button type="button" value = b"1" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal0">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[1]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[1]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[1]%></span></h3>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p>
         
         <button type="submit" value = "2" name = "submit" id = "s2" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
   <button type="button" value = b"2" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal1">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button></p>
  
         </p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[2]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[2]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[2]%></span></h3>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p>
         <button type="submit" value = "3" name = "submit" id = "s3" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
          <button type="button" value = b"3" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal2">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button> 
         </p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->



      <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[3]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[3]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[3]%></span></h3>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p>
         <button type="submit" value = "4" name = "submit" id = "s4" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
          <button type="button" value = b"4" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal3">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button>
         </p>
         
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[4]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[4]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[4]%></span></h3>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p>
         <button type="submit" value = "5" name = "submit" id = "s5" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
          <button type="button" value = b"5" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal4">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button>
         </p>
         </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src=<%=pAddr[5]%> alt="Generic placeholder image" width="300" height="200">
          <h3><%=Names[5]%>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-default">￥<%=Prices[5]%></span></h3>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p>
         <button type="submit" value = "6" name = "submit" id = "s6" class="btn btn-primary">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          加入餐盘</button>
          <button type="button" value = b"6" name = "submit" id = "s1" class="btn btn-warning" data-toggle="modal" data-target="#myModal5">
          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
查看评论 </button>
         </p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->    
 
<br>
<hr>
<!-- FOOTER -->
      <footer>
        <p class="pull-right"><a class="btn btn-success" href="#" role="button"><span class="glyphicon glyphicon-open" aria-hidden="true"></span>&nbsp;回到顶部</a></p>

        <p>最终解释权归 南京大学 计算机科学与技术系 咕噜软件小组所有<a href="#"></a> <a href="#"></a></p>
      </footer>

</div>
</form>
</body>
</html>