<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/15
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $('#zhangjiedg').datagrid({
            url:'${pageContext.request.contextPath}/section/findByspecialId?id=${param.id}',
            columns:[[
                {field:'id',title:'ID',width:100},
                {field:'name',title:'章节名',width:100},
                {field:'size',title:'大小',width:100,},
                {field:'s',title:'操作',width:200,
                    formatter: function(value,row,index){
                        var str="<a href='#' onClick=\"delzhangjie('"+row.id+"')\" class='delzhangjie'>删除</a>&nbsp;&nbsp;"+
                                "<a href='#' onClick=\"updzhangjie('"+row.id+"')\" class='updzhangjie'>修改</a>"
                        return str;
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".delzhangjie").linkbutton({
                    iconCls: 'icon-remove',
                }),
                $(".updzhangjie").linkbutton({
                    iconCls: 'icon-edit',
                })
            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#addzhangjie${param.id}').dialog({
                        title: '添加章节',
                        width: 400,
                        height: 400,
                        closed: false,
                        href: '${pageContext.request.contextPath}/back/zhangjie/add.jsp?id=${param.id}',
                    });
                },
                text:"添加",
            }]
        });
    });

    function delzhangjie(id) {
        $.messager.confirm('确认对话框', '确认删除？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/section/remove",{id:id},function (data){
                    if(data.status=='1'){
                        $('#zhangjiedg').datagrid('reload');
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
    function updzhangjie(id) {
        $('#updzhangjie${param.id}').dialog({
            title: '修改',
            width: 400,
            height: 200,
            closed: false,
            href: '${pageContext.request.contextPath}/back/zhangjie/update.jsp?id='+id+'&dd=${param.id}',
        });
    }
</script>

<table id="zhangjiedg"></table>
<div id="addzhangjie${param.id}"></div>
<div id="updzhangjie${param.id}"></div>