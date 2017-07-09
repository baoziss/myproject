<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/13
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>
<head>
    <title>aa</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>--%>
    <script>
        $(function () {
            $.post("${pageContext.request.contextPath}/user/findById",{
                id:'${param.id}'
            },function (data) {
                $('#id').html(data.id);
                $('#phone').html(data.phone);
                $('#pwd').html(data.pwd);
                $('#status').html(data.status);
                $('#fname').html(data.fname);
                $('#name').html(data.name);
                $('#sex').html(data.sex);
                $('#salt').html(data.salt);
                $('#sign').html(data.sign);
                $('#address').html(data.address.address.name+data.address.name);
                $('#guru').html(data.guru.name);
            })
        })
    </script>
<%--</head>
<body>--%>
<div style="text-align: center;">
    <table id="tt" cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">
                id:
            </td>
            <td valign="middle" id="id" align="left">
            </td>
        </tr>
        <tr>
            <td valign="middle"  align="right">
                name:
            </td>
            <td valign="middle" id="name"  align="left">
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                phone:
            </td>
            <td valign="middle" id="phone" align="left">
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                pwd:
            </td>
            <td valign="middle" id="pwd" align="left">

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                status:
            </td>
            <td valign="middle" id="status" align="left">

            </td>
        </tr><tr>
            <td valign="middle" align="right">
                fname:
            </td>
            <td valign="middle" id="fname" align="left">

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                sex:
            </td>
            <td valign="middle" id="sex" align="left">

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                salt:
            </td>
            <td valign="middle" id="salt" align="left">

            </td>
        </tr>

        <tr>
        <td valign="middle" align="right">
            sign:
        </td>
        <td valign="middle" id="sign" align="left">

        </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                address:
            </td>
            <td valign="middle" id="address" align="left">

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                guru:
            </td>
            <td valign="middle" id="guru" align="left">

            </td>
        </tr>
    </table>
</div>
<%--
</body>
</html>
--%>
