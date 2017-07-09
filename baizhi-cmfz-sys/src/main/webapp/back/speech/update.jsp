
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<form id="speechff">
    <input type="hidden" name="id" value="${param.id}">
    <input type="radio" name="status" checked="checked" value="可用"> 可用
    <input type="radio" name="status" value="不可用"> 不可用
</form>


<script>
    $(function () {
        $('#speechff').form({
            url:"${pageContext.request.contextPath}/speech/update",
            success:function(data){
                var $dd=$.parseJSON(data);
                if($dd.status==1){
                    $('#speechdg').datagrid('reload');
                    $.messager.show({
                        title:'成功',
                        msg:"修改成功",
                    });
                }else {
                    $.messager.show({
                        title:'失败',
                        msg:"修改失败",
                    });
                }
            }
        });
    })
</script>