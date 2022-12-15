<%@ page import="com.jarod.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: ljw
  Date: 2021/6/8
  Time: 10:59 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.css">
    <link rel="stylesheet" href="../../static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="../../static/css/style1.css" >
    <script src="../../static/js/jquery-1.12.1.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        // $("#btn-primary").click(function (){
        //    $.ajax({
        //        url: "/signup",
        //        type: "POST",
        //        dataType: 'json',
        //        data: {}
        //    })
        // });
        var error="<%=request.getAttribute("signuperror")%>"
        if (error=="error"){
            alert("The username has exist!!");
        }
        patt1=/^[a-zA-Z]*$/;
        patt2=/^[0-9]*$/;
        function checkenter(){
            const fn2 = document.data.firstname.value;
            var fn=document.getElementById("inputFirstname").value;
            var ln=document.getElementById("inputLastname").value;
            var un=document.getElementById("inputUsername").value;
            var pwd=document.getElementById("inputPassword").value;
            var tel=document.getElementById("inputtel").value;
            var email=document.getElementById("inputemail").value;
            var country=document.getElementById("inputcountry").value;
            var num=0;
            if (!patt1.test(fn)||fn=="") {
                document.getElementById("fn").innerText = "First name is empty or firstname contain number!"
                return false;
            }
            else {
                num++;
                document.getElementById("fn").innerText = ""
            }
            if (!patt1.test(ln)||ln==""){
                    document.getElementById("ln").innerText="Last name is empty or lastname contain number!"
                    return false;
            }else {
                num++;
                document.getElementById("ln").innerText = ""
            }
            if (un==""){
                document.getElementById("un").innerText="user name is empty!"
                return false;
            }
            else {
                num++;
                document.getElementById("un").innerText = ""
            }
            if (pwd==""){
                document.getElementById("pwd").innerText="pwd is empty!"
                return false;
                }
            else {
                num++;
                document.getElementById("pwd").innerText = ""
            }
            if (!patt2.test(tel)||tel==""){
                document.getElementById("tel").innerText="telephone is empty or make sure is number!"
                return false;
            }
            else {
                num++;
                document.getElementById("tel").innerText = ""
            }
            if (email==""){
                document.getElementById("email").innerText="email is empty!"
                return false;
            }
            else {
                num++;
                document.getElementById("email").innerText = ""
            }
            if (country==""){
                document.getElementById("country").innerText="country is empty!"
                return false;
            }
            else {
                num++;
                document.getElementById("country").innerText = ""
            }
            if (num==8)
            return true;
        }
    </script>
<%--<%User user= (User) request.getAttribute("checkun");--%>
<%--if (user.getUsername()!=null){--%>
<%--out.print("<script type='text/javascript'>alert('The username has exist');</script>");--%>
<%--}--%>
<%--%>--%>
<body background="../../static/images/backgrounds/1@2x.png">

<%--<nav class="navbar navbar-no-bg" role="navigation" >--%>
<%--    <div class="container">--%>
<%--        <div class="navbar-header">--%>
<%--            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">--%>
<%--                <span class="sr-only">Toggle navigation</span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--            </button>--%>
<%--&lt;%&ndash;            <a class="navbar-brand" href="index.html">Bootstrap Registration Form Template</a>&ndash;%&gt;--%>
<%--        </div>--%>
<%--        <!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--        <div class="row">--%>
<%--        <div class="collapse navbar-collapse" id="top-navbar-1">--%>
<%--            <div class=" col-1">--%>
<%--            <img src="img/backgrounds/logo@2x.png"  >--%>
<%--&lt;%&ndash;                style="max-width: 90%"&ndash;%&gt;--%>
<%--            </div>--%>
<%--            <div class="col-3" >--%>
<%--&lt;%&ndash;                    <a href="#" style="text-align: center">&ndash;%&gt;--%>
<%--                    <span class="glyphicon glyphicon-heart" aria-hidden="true" ></span>--%>
<%--&lt;%&ndash;                        style="top: 20px ;font-size: 20px;color: #d40000"&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </a>&ndash;%&gt;--%>

<%--            </div>--%>
<%--        </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
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
                <li><a href="signin" style="color: #353131;font-size: 16px">Sign in</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="margin-top: 150px">
<div class="container ">
    <div class="row">
<form class="form-horizontal col-lg-5 navbar-right " action="/signupcontroller" onsubmit="return checkenter()" name="data" method="post" style="background-color:#f1f0f0d9">
    <div>
        <h2>Sign Up!</h2>
        <br>
    </div>
    <div class="form-group">
        <label for="inputFirstname" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="inputFirstname" name="firstname" placeholder="FisrtName">
        </div>
        <div id="fn" style="padding-left: 110px;color: red"></div>
    </div>

    <div class="form-group">
        <label for="inputLastname" class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="inputLastname" name="lastname" placeholder="LastName">
        </div>
        <div id="ln" style="padding-left: 110px;color: red"></div>
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
        <label for="inputtel" class="col-sm-3 control-label">Tel</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="inputtel"  name="tel" placeholder="Telephone">
        </div>
        <div id="tel" style="padding-left: 110px;color: red"></div>
    </div>
    <div class="form-group">
    <label for="inputemail" class="col-sm-3 control-label">Email</label>
    <div class="col-sm-9">
        <input type="email" class="form-control" id="inputemail"  name="email" placeholder="email">
    </div>
        <div id="email" style="padding-left: 210px;color: red"></div>
</div>
    <div class="form-group">
        <label for="inputcountry" class="col-sm-3 control-label">Country</label>
        <div class="col-sm-9">
            <select class="form-control" id="inputcountry" name="country" >
                <option selected></option>
                <option>China</option>
                <option>USA</option>
                <option>Japan</option>
                <option>Australia</option>
                <option>England</option>
            </select>
        </div>
        <div id="country" style="padding-left: 210px;color: red"></div>
    </div>
<%--    <div class="form-group">--%>
<%--        <div class="col-sm-offset-2 col-sm-10">--%>
<%--            <div class="checkbox">--%>
<%--                <label>--%>
<%--                    <input type="checkbox"> Remember me--%>
<%--                </label>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <br>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary" id="btn-primary">Sign up</button>
        </div>
    </div>
    <br>
</form>
    </div>
</div>
</div>

</body>
</html>
