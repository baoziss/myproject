<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/13
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $('#workff').form('load','${pageContext.request.contextPath}/work/findById?id=${param.id}');
        $('#workff').form({
            url:"${pageContext.request.contextPath}/work/update",
            success:function(data){
                var $dd=$.parseJSON(data);
                if($dd.status=='1'){
                    $('#workdg').datagrid('reload');
                    $.messager.show({
                        title:'成功',
                        msg:$dd.message,
                    });
                }else {
                    $.messager.show({
                        title:'失败',
                        msg:$dd.message,
                    });
                }
            }
        });
    })
</script>

<div style="text-align: center;">
    <form id="workff">
        <input type="hidden" name="id" value="${param.id}">
        功课名：<input  name="name" value="">
    </form>
</div>



