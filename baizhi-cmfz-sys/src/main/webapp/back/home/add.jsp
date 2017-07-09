<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/14
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
    <script>
        $(function () {
            $('#homeff1').form({
                url:"${pageContext.request.contextPath}/hphoto/save",
                success:function(data){
                    jsonn();
                    var $data=$.parseJSON(data);
                    if($data.status='1'){
                        $('#homedd').dialog('close');
                        $.messager.show({
                            title:'失败',
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
        function add1() {
            $('#homeff1').submit();
        }
    </script>

<div style="text-align: center">
    <form id="homeff1" method="post" enctype="multipart/form-data">
        选择图片：<input class="easyui-filebox" name="aa" data-options="required:true" style="width:220px"></br>
        描&nbsp;&nbsp;述：<input class="easyui-validatebox" name="des" data-options="required:true" /></br>
        类&nbsp;&nbsp;型：<input name="type" type="radio" value="1"> 展示 <input name="type" type="radio" value="0"> 不展示
    </form>
    <a  href="#" onclick="add1()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>
</div>

