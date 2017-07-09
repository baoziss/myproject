<%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    <script>
        $(function () {
            $('#userdg').datagrid({
                url:'${pageContext.request.contextPath}/user/findAll',
                rowStyler: function(index,row){
                    return 'height:100px;';
                },
                columns:[[
                    {field:'image',title:'头像',width:100,
                        formatter: function(value,row,index){
                            var str="<img width='80px' height='80px' src='${pageContext.request.contextPath}"+row.image+"'>";
                            return str;
                        }
                    },
                    {field:'id',title:'ID',width:100},
                    {field:'phone',title:'账号',width:100},
                    {field:'name',title:'姓名',width:100,},
                    {field:'fname',title:'法名',width:100},
                    {field:'sex',title:'姓别',width:100},
                    {field:'status',title:'状态',width:100},

                    {field:'a',title:'操作',width:300,
                        formatter: function(value,row,index){
                            var str="<a href='#' onClick=\"selUser('"+row.id+"')\" class='selUser'>查看详情</a>&nbsp;&nbsp;"
                                    <shiro:hasPermission name="user:update">+
                                    "<a href='#' onClick=\"updUser('"+row.id+"')\" class='updUser'>修改状态</a>"
                                    </shiro:hasPermission>
                            return str;
                        }
                    },
                ]],
                onLoadSuccess:function () {
                    $(".selUser").linkbutton({
                        iconCls: 'icon-edit',
                    }),
                    $(".updUser").linkbutton({
                        iconCls: 'icon-edit',
                    })
                }
            });
        });
        function selUser(id) {
            $('#userdd').dialog({
                title: '用户详情',
                width: 600,
                height:500,
                closed: false,
                cache: false,
                href: '${pageContext.request.contextPath}/back/user/selectById.jsp?id='+id,
                buttons:[{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#userdd").dialog('close');
                    }
                }]
            });
        };
        function updUser(id) {
            $('#userdd').dialog({
                title: '修改用户状态',
                width: 300,
                height:300,
                closed: false,
                href: '${pageContext.request.contextPath}/back/user/update.jsp?id='+id,
                buttons:[{
                    text:'确定',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $.messager.confirm('确认对话框', '确定修改？', function(r){
                            if (r){
                                $("#userff").submit();
                                $("#userdd").dialog('close');
                            }
                        });
                    }
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#userdd").dialog('close');
                    }
                }]
            });
        };
    </script>


    <table id="userdg"></table>
    <div id="userdd"></div>
