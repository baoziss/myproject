<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/16
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $("#addzhangjiefrom${param.id}").form({
            url:"${pageContext.request.contextPath}/section/save",
            onSubmit: function(){
                $("#addzhangjie${param.id}").dialog('close');
            },
            success:function (data) {
                var $dd=$.parseJSON(data);
                if($dd.status=='1'){
                    $('#zhangjiedg').datagrid('reload');
                    $.messager.show({
                        title:'成功',
                        msg:"添加成功",
                    });
                }else {
                    $.messager.show({
                        title:'失败',
                        msg:"添加失败",
                    });
                }
            }
        })
    });
    function subaddzhangjie() {
        $('#addzhangjiefrom${param.id}').submit();
    }
</script>
<div style="text-align: center">
    <form id="addzhangjiefrom${param.id}" enctype="multipart/form-data" method="post">
        <input type="hidden"  name="special.id" value="${param.id}">
        章&nbsp;&nbsp;节：<input class="easyui-filebox" name="aa" data-options="required:true" style="width:220px"></br>
        章节名&nbsp;：<input class="easyui-validatebox" name="name" data-options="required:true" /></br>
    </form>
    <a href="#" onclick="subaddzhangjie()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>
</div>