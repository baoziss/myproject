<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/15
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $("#wenupdateform").form("load","${pageContext.request.contextPath}/special/findById?id=${param.id}")
        $('#wenupdateform').form({
            url:"${pageContext.request.contextPath}/special/update",
            success:function(data){
                wenjsonn();
                var $data=$.parseJSON(data);
                if($data.status='1'){
                    $('#updwen').dialog('close');
                    $.messager.show({
                        title:'成功',
                        msg:$data.message,
                    });
                }else {
                    $.messager.show({
                        title:'失败',
                        msg:$data.message,
                    });
                };
            }
        });
    });

</script>

<div style="text-align: center">
    <form id="wenupdateform" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        封面图片：<input class="easyui-filebox" name="aa" data-options="required:true" style="width:220px"></br>
        专辑名&nbsp;：<input class="easyui-validatebox" name="title" data-options="required:true" /></br>
        章节数&nbsp;：<input class="easyui-validatebox" name="size" data-options="required:true" /></br>
        作&nbsp;&nbsp;者：<input class="easyui-validatebox" name="author" data-options="required:true" /></br>
        播&nbsp;&nbsp;音：<input class="easyui-validatebox" name="announcer" data-options="required:true" /></br>
        评&nbsp;&nbsp;分：<input class="easyui-validatebox" name="score" data-options="required:true" /></br>
        内容简介：<textarea name="content" style="width:200px;height:80px;">这里写内容</textarea></br>
    </form>
</div>