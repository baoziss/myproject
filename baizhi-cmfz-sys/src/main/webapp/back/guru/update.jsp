
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<form id="guruff">
    <input type="hidden" name="id" value="${param.id}">
    <input type="radio" name="status" checked="checked" value="可用"> 可用
    <input type="radio" name="status" value="不可用"> 不可用
</form>


<script>
    $(function () {
        $('#guruff').form({
            url:"${pageContext.request.contextPath}/guru/update",
            success:function(data){
                var $dd=$.parseJSON(data);
                if($dd.status=='1'){
                    $('#gurudg').datagrid('reload');
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