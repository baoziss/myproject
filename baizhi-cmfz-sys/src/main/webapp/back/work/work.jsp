<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2017/6/13
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
    <script>
        $(function () {
            $('#workdg').datagrid({
                url:'${pageContext.request.contextPath}/work/findAll',
                columns:[[
                    {field:'id',title:'ID',width:100},
                    {field:'name',title:'功课',width:100,},
                    {field:'type',title:'类型',width:100},
                    {field:'a',title:'操作',width:300,
                        formatter: function(value,row,index){
                            var str="<a href='#' onClick=\"delWork('"+row.id+"')\" class='delWork'>删除</a>&nbsp;&nbsp;"+
                                    "<a href='#' onClick=\"updWork('"+row.id+"')\" class='updWork'>修改</a>"
                            return str;
                        }
                    },
                ]],
                onLoadSuccess:function () {
                    $(".delWork").linkbutton({
                        iconCls: 'icon-remove',
                    }),
                    $(".updWork").linkbutton({
                        iconCls: 'icon-edit',
                    })
                },
                toolbar:'#worktb',
            });
        });
        function updWork(id) {
            $('#workdd').dialog({
                title: '修改功课名',
                width: 300,
                height:300,
                closed: false,
                href: '${pageContext.request.contextPath}/back/work/update.jsp?id='+id,
                buttons:[{
                    text:'确定',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $.messager.confirm('确认对话框', '确定修改？', function(r){
                            if (r){
                                $("#workff").submit();
                                $("#workdd").dialog('close');
                            };

                        });

                    }
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#workdd").dialog('close');
                    }
                }]
            });
        };
        function delWork(id) {
            $.messager.confirm('确认', '确定删除？', function(r){
                if (r){
                    $.post("${pageContext.request.contextPath}/work/remove",{
                        id:id
                    },function (data) {
                        if(data.status=='1'){
                            $('#workdg').datagrid('reload');
                            $.messager.show({
                                title:'成功',
                                msg:'删除成功。',
                            });
                        }else {
                            $.messager.show({
                                title:'失败',
                                msg:data.message,
                            });
                        }
                    },"JSON");
                };
            });
        };
        function addtitle() {
            $('#workdd').dialog({
                title: '添加功课',
                width: 333,
                height:200,
                closed: false,
                href: '${pageContext.request.contextPath}/back/work/add.jsp',
                buttons:[{
                    text:'确定',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#workff").submit();
                        $("#workdd").dialog('close');
                    }
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#workdd").dialog('close');
                    }
                }]
            });
        }
    </script>

    <table id="workdg"></table>
    <div id="workdd"></div>
<div id="worktb">
    <a href="#" onclick="addtitle()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>
