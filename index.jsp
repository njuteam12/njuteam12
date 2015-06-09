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
<script>
function show(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='block';
 fade.style.display='block';
 }
function hide(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='none';
 fade.style.display='none';
}
</script>
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
      <a class="navbar-brand" href="#">鍜曞櫆鍜曞櫆</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">涓婚〉<span class="sr-only">(current)</span></a></li>
        <li><a href="#">鎴戠殑椁愮洏</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">鎴戠殑鍜曞櫆 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">涓汉璧勬枡</a></li>
            <li><a href="#">璁㈤璁板綍</a></li>
            <li><a href="#">寰呰瘎缇庨</a></li>
            <li class="divider"></li>
            <li><a href="#">鍙嬫儏閾炬帴</a></li>
          </ul>
        </li>
      </ul>
        <form class="navbar-form navbar-left" role="search" action = "Action0">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="榛勭剸楦＄背楗?>
       </div>
        <button type="submit" class="btn btn-default">鍜曞櫆涓€涓?/button>
        </form>
        
      <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:void(0)" onclick="show('light')">鐧诲綍</a></li>
        <li><a href="javascript:void(0)" onclick="show('light2')">娉ㄥ唽&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
      </ul>
  <form action = "Action0">
      <div id="light" class="white_content">
      <div class="close"><a href="javascript:void(0)" onclick="hide('light')"> close</a></div>
      <div class="col-md-8"></div>
    <div class="col-md-10">
   

        <form class="form-signin" name = "myForm">
        <h3 class="form-signin-heading">Please sign in</h3>
         <br>
        <table>
        <tr>
        <td> <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;UserName&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td><input size = 40 id="inputUsername" name = "userName" class="form-control" placeholder="User name" required="" autofocus=""></td>
        </tr>
       <tr><td>&nbsp;</td></tr>
         <tr><td>
       <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;Password&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
        <td><input type="password" size = 50 id="inputPassword" name = "pwd" class="form-control" placeholder="Password"/>
<td>
        </tr></table>
        <div id = "nameDiv" style="display:inline;"></div><br/>
        <br>
        &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-lg btn-primary btn-block" name = "submit" value = "SignIn" type="submit" style = "margin-left:35px" onclick = "checkName()">Sign in</button>
        <br><br>
        </form>
 </div>
   <div class="col-md-8"></div>
</div>
</div>
<div id="light2" class="white_content">
      <div class="close"><a href="javascript:void(0)" onclick="hide('light2')"> close</a></div>
      <div class="col-md-10"></div>
    <div class="col-md-10">
   

        <form class="form-signin">
        <h3 class="form-signin-heading">Please sign up</h3>
         <br>
        <table style = "margin-left:40px">
        <tr>
        <td> <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;UserName&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td><input type="username" size = 40 id="Username" name = "InputName" class="form-control" placeholder="User name" required="" autofocus="" onblur = "checkUserName()"/></td>
        </tr>
       <tr><td>&nbsp;</td></tr>
         <tr><td>
       <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;Password&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
        <td><input type="password" size = 50 id="Password" class="form-control" placeholder="Password"required="">
        <td>
        </tr>
       <tr><td>&nbsp;</td></tr>
        <tr>
        <td> <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td><input type="phone" class="form-control" size="54%" id="Phone" placeholder="Phone number" required=""></td>
        </tr>
       <tr><td>&nbsp;</td></tr>
         <tr><td>
       <label for="inputUsername">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
        <td> <input type="address" class="form-control" size="54%" id="Address" placeholder="Address" required="">
        <td>
        </tr>
      </table>
        <div id = "nameDiv" style="display:inline;"></div>
        <br>
        &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-lg btn-primary btn-block" type="submit" style = "margin-left:35px">Sign Up</button>
        <br><br>
        </form>
 </div>
   <div class="col-md-10"></div>
      </div>
</div>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<br>
<br>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="pictures/new4.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>鍜曞櫆鍜曞櫆鍦ㄧ嚎璁㈤</h1>
              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">鍔犲叆鎴戜滑鍚?/a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="pictures/new5.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>鍜曞櫆鍜曞櫆鍦ㄧ嚎璁㈤</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">鍔犲叆鎴戜滑鍚?/a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="pictures/new6.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>鍜曞櫆鍜曞櫆鍦ㄧ嚎璁㈤</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">鍔犲叆鎴戜滑鍚?/a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
<br>
<br>
<div class="panel panel-primary">
    <div class="panel-heading">
    </div>
    <div class="panel-body">

<div class="row">
  <div class="col-md-2"><h4>椁愬巺鍒嗙被:</h4></div>
  <div class="col-md-1">
  <button type="button" class="btn btn-success">涓紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-info">闊╁紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-warning">鏃ュ紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-danger">瑗垮紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-success">鍙板紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-info">娓紡</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-warning">姘存灉</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-danger">鐢滅偣</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-success">楗枡</button>
  </div>
  <div class="col-md-1">
  </div>
</div>
<hr>

<div class="row">
  <div class="col-md-2"><h4>鎺掑簭鏂瑰紡:</h4></div>
  <div class="col-md-1">
  <button type="button" class="btn btn-success">閿€閲?/button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-info">璇勪环</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-warning">璧烽€佷环鏍?/button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-danger">閰嶉€侀€熷害</button>
  </div>
  <div class="col-md-1">
  <button type="button" class="btn btn-success">鏂板紑椁愬巺</button>
  </div>
  <div class="col-md-1">
  </div>
  <div class="col-md-1">
  </div>
  <div class="col-md-1">
  </div>
  <div class="col-md-1">
  </div>
  <div class="col-md-1">
  </div>
</div>

    </div>
</div>

<br>
<br>
<div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h1.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>姊撳楦℃眮姹ゅ寘</h2>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h2.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>涓€鍒€娴佸鍙?/h2>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h3.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>濡傛剰棣勯エ</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->



      <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h4.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>鑰佸寳浜嚜鍔╃儳鐑?/h2>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h5.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>瀹跺父灏忕倰</h2>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>        
         </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="pictures/h6.jpg" alt="Generic placeholder image" width="300" height="200">
          <h2>鍙ｆ复浜嗗ザ鑼跺潑</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                  <p><a class="btn btn-primary" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">
      <br>
      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">鍖椾含鐑ら腑 <span class="text-muted">It'll blow your mind.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>
        </div>
        <div class="col-md-5">
          <img class="img-rounded featurette-image img-responsive center-block" data-src="pictures/h7.jpg" alt="400x400" src="pictures/h7.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">鍝堟牴杈炬柉鍐版穱娣?<span class="text-muted">See for yourself.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>

        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="img-rounded featurette-image img-responsive center-block" data-src="pictures/h8.jpg" alt="400x400" src="pictures/h8.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">閮澶ч櫌 <span class="text-muted">Checkmate.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button" onclick="show('light')">
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          鍘荤湅鐪?/a></p>

        </div>
        <div class="col-md-5">
          <img class="img-rounded featurette-image img-responsive center-block" data-src="pictures/h9.jpg" alt="400x400" src="pictures/h9.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a class="btn btn-success" href="#" role="button"><span class="glyphicon glyphicon-open" aria-hidden="true"></span>&nbsp;鍥炲埌椤堕儴</a></p>

        <p>鏈€缁堣В閲婃潈褰?鍗椾含澶у 璁＄畻鏈虹瀛︿笌鎶€鏈郴 鍜曞櫆杞欢灏忕粍鎵€鏈?a href="#"></a> <a href="#"></a></p>
      </footer>

    </div>



</div>
</form>

</body>
<script type = "text/javascript">
 var xmlHttp;
 function createXMLHttpRequest(){
    if(window.ActiveXObject){
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else{
    xmlHttp = new XMLHttpRequest();
    }
 }
 function checkUserName()
 {
    var name = document.getElementById("Username").value;
   // var name = 1;
    if(name.length == 0)
    {
      alert("璇疯緭鍏ョ敤鎴峰悕");
    }
    else
    {
   //   alert("s");
      doAjax();
    }
 }
 function checkName()
 {
    var name = document.getElementById("inputUsername").value;
    var pwd = document.getElementById("inputPassword").value;
    if(name.length == 0)
     alert("璇疯緭鍏ョ敤鎴峰悕!");
    else
    {
     if(pwd.length == 0)
       alert("璇疯緭鍏ュ瘑鐮?);
     else
       {
         alert("鐧婚檰鎴愬姛");
         //document.myForm.submit(); 
        }
       
     }   
 }
 function doAjax()
 {
   var name = document.getElementById("Username").value;
//   alert(name);
   createXMLHttpRequest();
   xmlHttp.open("post","Ajax1?name="+name,true);
   xmlHttp.onreadystatechange = processResponse;
   xmlHttp.send(null);
 }
 function processResponse(){
  // alert("readyState = "+xmlHttp.readyState);
  // alert("status="+xmlHttp.status);
   
   if(xmlHttp.readyState == 4&&xmlHttp.status == 200)
   {
       var value = xmlHttp.responseText;
       var div = document.getElementById("nameDiv");
       if(value == 0)
        // div.innerHTML="<font color = 'red'>姝ょ敤鎴峰悕宸插瓨鍦?</font>";
        alert("姝ょ敤鎴峰悕宸插瓨鍦紒");
      // else
       //  div.innerHTML="<font color = 'blue'>姝ょ敤鎴峰悕鍙互浣跨敤!</font>";
   }
 }
 </script>
</html>
