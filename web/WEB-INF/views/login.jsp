<%--
  Created by IntelliJ IDEA.
  User: 微风
  Date: 2017/8/27
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <base href="<%=basePath %>" />
    <style type="text/css">
        *{ padding: 0; margin: 0; font-family: "Microsoft Yahei",sans-serif; }
        .head{ width: 450px; height: 80px; margin: 0 auto; text-align: center; margin-top: 15px; padding: 10px 0 10px 0; }
        .logo{ width: 80px; height: 80px; float: left; margin-right: 5px; }
        .title{ width: 360px; height: 80px; float: left; }
        .title-big{ font-size: 30px; color: #282828; margin-top: 10px; }
        .title-small{ font-size: 18px; color: #8a8a8a; }
        .main{ width: 100%; height: 600px; margin-top: 15px; background: url("<%=basePath %>/statics/image/bg.png") no-repeat; background-size:100%; position: relative; }
        @media screen and (max-width: 1360px) {
            .main{ width: 100%; height: 600px; background: url("<%=basePath %>/statics/image/bg2.png") no-repeat; background-size:100%; position: relative; }
        }
        .main-title{ width: 500px; height: 130px; text-align: center; position: absolute; top: 0; bottom: 110px; left: 5%; margin: auto; }
        .main-title-big{ width: 500px; height: 100px; background: url("<%=basePath %>/statics/image/main_title_big.png") no-repeat;
        }
        .main-title-small{ width: 500px; height: 30px; line-height: 30px; color: #fff; font-size: 22px; letter-spacing: 15px; }
        .login-box{ width: 250px; height: 330px; background-color: rgba(0, 0, 0, 0.68); border-radius: 5px; position: absolute; top: 0; bottom: 0; right: 10%; margin: auto; padding: 18px 50px; }
        .box-title{ width: 250px; height: 50px; text-align: center; color: #fff; font-size: 22px; }
        .box-input{ width: 250px; height: 50px; color: #fff; font-size: 16px; margin-bottom: 18px; }
        .box-input-title{ width: 250px; height: 20px; color: #c3c3c3; font-size: 16px; float: left; margin-bottom: 5px; }
        .box-input-content{ width: 250px; height: 30px; border-radius: 3px; border: 1px; float: left; padding: 2px 5px; box-sizing: border-box; font-size: 15px; }
        .verify{ width: 70px; height: 30px; float: right; background-size: 100%; }
        .login-btn{ width: 250px; height: 40px; background-color: #00AAEE; margin-top: 30px; border-radius: 4px; text-align: center; line-height: 40px; font-size: 18px; color: #fff; letter-spacing: 4px; cursor: pointer; border: none; }
        .login-btn:hover{ background-color: #008ac4; }
        footer{ width: 100%; height: 100px; line-height: 30px; text-align: center; font-size: 15px; color: #555555; padding: 5px 0; }
    </style>
</head>
<body>

<!--首部-->
<div class="head">
    <img src="../../statics/image/logo.png" class="logo">
    <div class="title">
        <div class="title-big">智能管理系统</div><br>
        <div class="title-small">MANAGEMENT SYSTEM</div>
    </div>
</div>

<!--中部-->
<div class="main">
    <div class="main-title">
        <div class="main-title-big"></div>
        <div class="main-title-small">一站式解决方案</div>
    </div>
    <div class="login-box">
        <div class="box-title">登录到管理台</div>
        <form action="" method="post">
            <!--输入账号-->
            <div class="box-input">
                <div class="box-input-title">账号</div>
                <input class="box-input-content" type="text" name="username">
            </div>
            <!--输入密码-->
            <div class="box-input">
                <div class="box-input-title">密码</div>
                <input class="box-input-content" type="password" name="password">
            </div>
            <div>
                <input class="login-btn" type="submit" value="登 录">
                <div style="text-align: center; color:red;">
                    <br />
                    ${msg}
                </div>
            </div>
        </form>
    </div>
</div>

<!--尾部-->
<footer>
    <p>技术支持：<a href="https://weafung.github.io">Weafung</a></p>
</footer>

</body>
</html>