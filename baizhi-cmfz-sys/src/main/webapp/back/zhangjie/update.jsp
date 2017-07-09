<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/16
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $("#updzhangjiefrom").form('load','${pageContext.request.contextPath}/section/findById?id=${param.id}');
        $("#updzhangjiefrom").form({
            url:"${pageContext.request.contextPath}/section/update",
            onSubmit: function(){
                $("#updzhangjie${param.dd}").dialog('close');
            },
            success:function (data) {
                var $dd=$.parseJSON(data);
                if($dd.status=='1'){
                    $('#zhangjiedg').datagrid('reload');
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
        })
    });
    function subupdzhangjie() {
        $('#updzhangjiefrom').submit();
    }
</script>
<div style="text-align: center">
    <form id="updzhangjiefrom" enctype="multipart/form-data" method="post">
        <input type="hidden"  name="id" value="${param.id}">
        章节名&nbsp;：<input class="easyui-validatebox" name="name" data-options="required:true" /></br>
    </form>
    <a href="#" onclick="subupdzhangjie()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">确认修改</a>
</div>
