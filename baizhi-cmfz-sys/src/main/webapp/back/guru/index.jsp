
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $('#gurudg').datagrid({
            url:'${pageContext.request.contextPath}/guru/findAll',
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
                {field:'name',title:'姓名',width:100,},
                {field:'status',title:'状态',width:100},
                {field:'a',title:'操作',width:300,
                    formatter: function(value,row,index){
                        var str="<a href='#' onClick=\"selGuru('"+row.id+"')\" class='selGuru'>查看详情</a>&nbsp;&nbsp;"+
                                "<a href='#' onClick=\"updGuru('"+row.id+"')\" class='updGuru'>修改状态</a>"
                        return str;
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".selGuru").linkbutton({
                    iconCls: 'icon-edit',
                }),
                $(".updGuru").linkbutton({
                    iconCls: 'icon-edit',
                })
            },
        });
    });
    function selGuru(id) {
        $('#gurudd').dialog({
            title: '用户详情',
            width: 600,
            height:500,
            closed: false,
            cache: false,
            href: '${pageContext.request.contextPath}/back/guru/detial.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#gurudd").dialog('close');
                }
            }]
        });
    };
    function updGuru(id) {
        $('#gurudd').dialog({
            title: '修改用户状态',
            width: 300,
            height:300,
            closed: false,
            href: '${pageContext.request.contextPath}/back/guru/update.jsp?id='+id,
            buttons:[{
                text:'确定',
                iconCls:'icon-cancel',
                handler:function(){
                    $.messager.confirm('确认对话框', '确定修改？', function(r){
                        if (r){
                            $("#guruff").submit();
                            $("#gurudd").dialog('close');
                        }
                    });
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#gurudd").dialog('close');
                }
            }]
        });
    };
</script>


<table id="gurudg"></table>
<div id="gurudd"></div>