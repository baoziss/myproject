
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $('#speechdg').datagrid({
            url:'${pageContext.request.contextPath}/speech/findAll',
            columns:[[
                {field:'id',title:'ID',width:100},
                {field:'author',title:'作者',width:100,},
                {field:'title',title:'标题',width:100,},
                {field:'publishTime',title:'时间',width:100,},
                {field:'status',title:'状态',width:100},
                {field:'a',title:'操作',width:300,
                    formatter: function(value,row,index){
                        var str="<a href='#' onClick=\"selspeech('"+row.url+"')\" class='selspeech'>查看详情</a>&nbsp;&nbsp;"+
                                "<a href='#' onClick=\"updspeech('"+row.id+"')\" class='updspeech'>修改状态</a>"
                        return str;
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".selspeech").linkbutton({
                    iconCls: 'icon-edit',
                }),

                $(".updspeech").linkbutton({
                    iconCls: 'icon-edit',
                })

             },
        });
    });
    function selspeech(url) {
        $('#speechdd').dialog({
            title: '详情',
            width: 500,
            height:500,
            closed: false,
            cache: false,
            href: '${pageContext.request.contextPath}'+url,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#speechdd").dialog('close');
                }
            }]
        });
    };
    function updspeech(id) {
        $('#speechdd').dialog({
            title: '修改状态',
            width: 300,
            height:300,
            closed: false,
            href: '${pageContext.request.contextPath}/back/speech/update.jsp?id='+id,
            buttons:[{
                text:'确定',
                iconCls:'icon-cancel',
                handler:function(){
                    $.messager.confirm('确认对话框', '确定修改？', function(r){
                        if (r){
                            $("#speechff").submit();
                            $("#speechdd").dialog('close');
                        }
                    });
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#speechdd").dialog('close');
                }
            }]
        });
    };
</script>


<table id="speechdg"></table>
<div id="speechdd"></div>