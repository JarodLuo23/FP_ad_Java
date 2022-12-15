<%@ page import="com.jarod.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: ljw
  Date: 2021/6/9
  Time: 11:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.css">
    <link rel="stylesheet" href="../../static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="../../static/css/style1.css" >
    <script src="../../static/js/jquery-1.12.1.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
<%--    <script type="text/javascript">--%>
<%--        <%User user= (User) session.getAttribute("editdata");%>--%>
<%--        $("#a").val("<%=user.getCountry()%>")--%>
<%--    </script>--%>
    <script type="text/javascript">
        var error="<%=request.getAttribute("profile")%>"
        if (error=="error"){
            alert("error");
        }
        function cancel(){
            window.location.href="index";
        }
    </script>
</head>
<%--<%  User user= (User) session.getAttribute("editdata");--%>
<%--    out.println("First name :"+ user.getFirst_name());%><br>--%>
<%--<%out.println("Last name :" +user.getLast_name());%><br>--%>
<%--<%out.println("User name :"+user.getUsername());%><br>--%>
<%--<%out.println("Password :"+user.getPassword());%><br>--%>
<%--<%out.println("Telephone :"+user.getTelephone());%><br>--%>
<%--<%String firstname=user.getFirst_name();%>--%>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--      <a class="navbar-brand" href="#" >Movie</a>--%>
        </div>

        <div class="row">

            <div id="navbar" class="navbar-collapse collapse" >
                <div class="col-lg-2">
                    <img src="../../static/images/logo.png" class="img-responsive" alt="Responsive image" style="max-width: 30%">
                </div>
                <ul class="nav navbar-nav col-lg-6 col-lg-push-1" >
                    <li><a href="index.html">Home</a></li>
                    <li><a href="single-video.html">Video Post</a></li>
                    <li><a href="single-page.html">Movie</a></li>
                    <li><a href="single-page-with-img.html">TV Show</a></li>
                    <%--    <li><a href="login.html">Login</a></li>--%>
                </ul>
                <ul class="nav navbar-nav col-lg-4 col-lg-push-2 ">
                    <li><a href="signup.jsp">Login</a></li>
                    <li><a class="glyphicon glyphicon-user" aria-hidden="true"></a></li>
                    <li><a href="signin.jsp">Log out</a></li>
                </ul>
            </div><!--/.navbar-collapse -->

        </div>
    </div>
</nav>


<div class="profile">
<div class="container">

    <div class="span3 avatar-box" style="width:220px;float: left">
        <div class="personal-image">
            <img src="../../static/images/personal-info.png" class="avatar img-circle" id="chosepic"/>
            <p>Upload a different photo...</p>

            <input type="file" />
        </div>
    </div>

   <div class="span7 personal-info" style="float: left">
      <div class="alert alert-info">
        <i class="icon-lightbulb"></i>
        This page shows the user profiles and if you edit anything<br> remember click
        <strong>Save Changes</strong> button.
    </div>
    <h5 class="personal-title">Personal info</h5>

    <form action="/profile" method="post">
    <div class="field-box">
        <label>First name:</label>
        <input class="span5 inline-input" type="text" name="firstname" value="${sessionScope.data.first_name}" />
    </div>
    <div class="field-box">
        <label>Last name:</label>
        <input class="span5 inline-input" type="text" name="lastname" value="${sessionScope.data.last_name}" />
    </div>
    <div class="field-box">
        <label>Username:</label>
        <input class="span5 inline-input" id="un" type="text" name="username" placeholder="${sessionScope.data.username}" readonly value="${sessionScope.data.username}" />
    </div>
    <div class="field-box">
        <label>Password:</label>
        <input class="span5 inline-input" type="password" name="password" value="${sessionScope.data.password}" />
    </div>
       <div class="field-box">
           <label>Telephone</label>
           <input class="span5 inline-input" type="text" name="telephone" value="${sessionScope.data.telephone}" />
       </div>
       <div class="field-box">
           <label>Email:</label>
           <input class="span5 inline-input" type="text" name="email" value="${sessionScope.data.email}" />
       </div>
    <div class="field-box">
        <label>Country:</label>
        <div class="ui-select" id="box">
            <select id="${sessionScope.data.country}" name="country" value="asd" >
                <option ${sessionScope.data.country eq 'China'?"selected":""}  value="China" />China
                <option ${sessionScope.data.country eq 'USA'?"selected":""} value="USA" />USA
                <option ${sessionScope.data.country eq 'Japan'?"selected":""} value="Japan" />Japan
                <option ${sessionScope.data.country eq 'Australia'?"selected":""} value="Australia" />Australia
                <option ${sessionScope.data.country eq 'England'?"selected":""} value="England" />England
            </select>
        </div>
    </div>
    <div class="span6 field-box actions">
<%--        <input type="button" class="btn-glow primary" value="Save Changes" />--%>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Save Changes</button>
    <button type="button" class="btn btn-default btn-lg btn-block" onclick="cancel()" >Cancel</button>
<%--        <input type="reset" value="Cancel" class="reset" />--%>
    </div>
    </form>
</div>
</div>
</div>


</body>

</html>