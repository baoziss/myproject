<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/13
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

    <form id="userff">
        <input type="hidden" name="id" value="${param.id}">
        <input type="radio" name="status" checked="checked" value="可用"> 可用
        <input type="radio" name="status" value="不可用"> 不可用
    </form>


<script>
    $(function () {
        $('#userff').form({
            url:"${pageContext.request.contextPath}/user/update",
            success:function(data){
                var $dd=$.parseJSON(data);
                if($dd.status=='1'){
                    $('#userdg').datagrid('reload');
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