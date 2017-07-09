<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

    <script>
        $(function () {
            jsonn();
        });
        function addHome() {
            $('#homedd').dialog({
                title: '添加轮播图',
                width: 400,
                height: 200,
                closed: false,
                href: '${pageContext.request.contextPath}/back/home/add.jsp',
            });
        };
        function updAll() {
            $('#homeff').form('submit', {
                url:"${pageContext.request.contextPath}/hphoto/updateAll",
                success:function(data){
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
        };

        function updHome1(id) {
            $('#homedd1').dialog({
                title: '修改描述',
                width: 400,
                height: 200,
                closed: false,
                href: '${pageContext.request.contextPath}/back/home/update.jsp?id='+id,
                buttons:[{
                    text:'确认修改',
                    iconCls:'icon-edit',
                    handler:function(){
                        $("#updateHome").submit();

                    }
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#homedd1").dialog('close');
                    }
                }]
            });
        };

        function delHome(id) {
            $.messager.confirm('确认对话框', '确认删除？', function(r){
                if (r){
                    $.post("${pageContext.request.contextPath}/hphoto/remove",{id:id},function (data) {
                        if(data.status=='1'){
                            jsonn();
                            $.messager.show({
                                title:'成功',
                                msg:'删除成功',
                            });
                        }else{
                            $.messager.show({
                                title:'失败',
                                msg:'删除失败',
                            });
                        };
                    },"JSON");
                };
            });
        };

        function jsonn() {
            $.post("${pageContext.request.contextPath}/hphoto/findAll",function (data) {
                var str="<form method='post' id='homeff'>";
                $.each(data,function (index,photo) {
                    str+="<div style='float:left;margin-right:20px'> <img width='140px' height='200px' " +
                            " src='${pageContext.request.contextPath}"+photo.url+"'></br><div style='width:140px;height:15px'>"+photo.des+"</div></br>" +
                            "<a href='#' class='updHome' onclick=\"updHome1(\'"+photo.id+"\')\" >更改描述</a>" +
                            "<a href='#' class='delHome' onclick=\"delHome(\'"+photo.id+"\')\" >删除</a></br>" ;
                    if(photo.type=='1'){
                        str+=" <input type='checkbox' checked='checked' name='list' value='"+photo.id+"'></br></div>";
                    }else {
                        str+=" <input type='checkbox' name='list' value='"+photo.id+"'></br></div>";
                    }
                });
                str+="</form>";
                $("#homemain").html(str);

                $(".delHome").linkbutton({
                    iconCls: 'icon-remove'
                });
                $(".updHome").linkbutton({
                    iconCls: 'icon-edit'
                });
            },"JSON");
        };
    </script>

    <div style="text-align: center;margin-bottom: 20px">
        <a href="#" class="easyui-linkbutton" onclick="addHome()" data-options="iconCls:'icon-add'">添加轮播图</a>
        <a href="#" class="easyui-linkbutton" onclick="updAll()" data-options="iconCls:'icon-edit'">确认修改轮播图展示</a>
    </div>
    <div id="homemain" >
    </div>
    <div id="homedd"></div>
    <div id="homedd1"></div>

