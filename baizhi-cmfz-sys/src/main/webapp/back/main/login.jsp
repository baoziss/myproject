<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/11
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <style>
        body {
            background: cornsilk;
        }
        .u-form {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%)
        }
        .u-input {
            margin-top: 10px;
        }
        .u-input input {
            padding-left: 10px;
            margin-left: 20px;
            background: pink;
            border: 1px solid hotpink;
            border-radius: 4px;
        }
        .u-input input:hover {
            background: hotpink;
        }
        .u-btn {
            margin-top: 20px;
            text-align: center;
        }
        .u-btn input {
            width: 80px;
            height: 30px;
            line-height: 30px;
            background: #ee8523;
            color: #ffffff;
            text-align: center;
            border-radius: 4px;
            border: none;
            cursor: pointer;
        }
        .u-btn input:hover {
            background: #de8033;
        }
        h2 {
            text-align: center;
            color: #ee8523;
        }
        .u-ts {
            display: none;
            margin-left: 20px;
            color: red;
        }
        .u-input input:focus+.u-ts {
            display: block;
        }
    </style>
</head>

<body>
    <form  method="post" class="u-form" action="${pageContext.request.contextPath}/manager/login">
        <h2>XXX管理系统</h2>
        <div class="u-input" >
            用户名:<input name="username" placeholder="此项必填"/><span class="u-ts">*此项必填</span>
        </div>
        <div class="u-input">
            密&nbsp;&nbsp;&nbsp;码:<input name="pwd"/><span class="u-ts">*此项必填</span>
        </div>
        <div class="u-btn">
            <input type="submit" value="提交" />
            <input type="reset" value="重置" />
        </div>

        ${param.mess}
    </form>
</body>
</html>
