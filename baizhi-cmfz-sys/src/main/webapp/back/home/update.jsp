<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/15
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center">
    <form method="post" id="updateHome">
        <input type="hidden" name="id" value="">
        描述：<input class="easyui-validatebox" data-options="required:true" name="des">
    </form>
</div>

<script>
   $(function () {
       $("#updateHome").form('load',"${pageContext.request.contextPath}/hphoto/findById?id=${param.id}");
       $("#updateHome").form({
           url:"${pageContext.request.contextPath}/hphoto/update",
           success:function(data){
               $("#homedd1").dialog('close');
               var $data=$.parseJSON(data);
               if($data.status=='1'){
                   jsonn();
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
           },
       });
   })
</script>