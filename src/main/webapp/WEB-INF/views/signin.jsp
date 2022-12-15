<%--
  Created by IntelliJ IDEA.
  User: ljw
  Date: 2021/6/8
  Time: 11:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.css">
    <link rel="stylesheet" href="../../static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="../../static/css/style1.css" >
    <script src="../../static/js/jquery-1.12.1.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    var error="<%=session.getAttribute("loginerror")%>";
        if(error==="error"){
            alert("The account do not exist!!");
        }
    function checkempty(){
        var un=document.getElementById("inputUsername").value;
        var pwd=document.getElementById("inputPassword").value;
        if (un==""){
            document.getElementById("un").innerText="The username is empty!!"
            return false;
        }else {
            document.getElementById("un").innerText=""
        }
        if (pwd==""){
            document.getElementById("pwd").innerText="The password is empty!!"
            return false;
        }else {
            document.getElementById("pwd").innerText=""
        }
        return true;
    }
</script>
<body background="../../static/images/backgrounds/1@2x.png">

<nav class="navbar navbar-default " style="background: none;border: none">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="../../static/images/backgrounds/logo@2x.png" style="max-width: 50%">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="signup_page" style="color: #353131;font-size: 16px">Sign up</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="margin-top: 150px">
    <div class="container ">
        <div class="row">
            <form class="form-horizontal col-lg-5 navbar-right " action="/signincontroller" onsubmit="return checkempty()" method="post" style="background-color:#f1f0f0d9">
                <div>
                    <h2>Sign in!</h2>
                    <br>
                </div>
                <div class="form-group">
                    <label for="inputUsername" class="col-sm-3 control-label">Username</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="inputUsername" name="username" placeholder="username">
                    </div>
                    <div id="un" style="padding-left: 210px;color: red"></div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="inputPassword"  name="pwd" placeholder="Password">
                    </div>
                    <div id="pwd" style="padding-left: 210px;color: red"></div>
                </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="cookies"> Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary" id="btn-primary" onclick="checklogin()">Sign in</button>
                    </div>
                </div>
                <br>
            </form>
        </div>
    </div>
</div>
</body>
</html>
