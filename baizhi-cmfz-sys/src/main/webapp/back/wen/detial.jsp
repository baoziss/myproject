<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $("#wendetialform").form("load","${pageContext.request.contextPath}/special/findById?id=${param.id}");
    });
</script>

<div style="text-align: center">
    <form id="wendetialform" method="post" enctype="multipart/form-data">
        专辑名&nbsp;：<input class="easyui-textbox" name="title" data-options="readonly:true" /></br>
        章节数&nbsp;：<input class="easyui-textbox" name="size" data-options="readonly:true" /></br>
        添加时间：<input class="easyui-textbox" name="publishTime" data-options="readonly:true" /></br>
        作&nbsp;&nbsp;者：<input class="easyui-textbox" name="author" data-options="readonly:true" /></br>
        播&nbsp;&nbsp;音：<input class="easyui-textbox" name="announcer" data-options="readonly:true" /></br>
        评&nbsp;&nbsp;分：<input class="easyui-textbox" name="score" data-options="readonly:true" /></br>
        内容简介：<textarea name="content" readonly="readonly" style="width:200px;height:80px;"></textarea></br>
    </form>
</div>