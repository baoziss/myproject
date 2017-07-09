<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        wenjsonn();
    });

    function detialwen(id) {
        $('#detialwen').dialog({
            title:'详情',
            width: 400,
            height: 300,
            closed: false,
            href: '${pageContext.request.contextPath}/back/wen/detial.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#detialwen").dialog('close');
                }
            }]
        });
    };

    function addWen() {
        $('#addwen').dialog({
            title: '添加专辑',
            width: 400,
            height: 400,
            closed: false,
            href: '${pageContext.request.contextPath}/back/wen/add.jsp',
        });
    }



    function updWen(id) {
        $('#updwen').dialog({
            title: '修改专辑',
            width: 400,
            height: 400,
            closed: false,
            href: '${pageContext.request.contextPath}/back/wen/update.jsp?id='+id,
            buttons:[{
                text:'确认修改',
                iconCls:'icon-edit',
                handler:function(){
                    $("#wenupdateform").submit();
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#updwen").dialog('close');
                }
            }]
        });
    };

    function delWen(id) {
        $.messager.confirm('确认对话框', '确认删除？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/special/remove",{id:id},function (data) {
                    if(data.status=='1'){
                        wenjsonn();
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
    function zhangjie(id) {
        if(!$("#tt").tabs('exists',"章节")){
            $("#tt").tabs('add',{
                title:"章节",
                fit:true,
                href:"${pageContext.request.contextPath}/back/zhangjie/index.jsp?id="+id,
                closable:true
            });
        }else {
            $("#tt").tabs('close',"章节");
            window.setTimeout(function () {
                $("#tt").tabs('add',{
                    title:"章节",
                    fit:true,
                    href:"${pageContext.request.contextPath}/back/zhangjie/index.jsp?id="+id,
                    closable:true
                });
            },100);
        }
    }


    function wenjsonn() {
        $.post("${pageContext.request.contextPath}/special/findAll",function (data) {
            var str="";
            $.each(data,function (index,special) {
                str+="<div style='float:left;margin-right:20px;margin-top:20px'><a href='#' onclick=\"detialwen(\'"+special.id+"\')\"> <img style='padding-left:13px' width='140px' height='200px' " +
                        " src='${pageContext.request.contextPath}"+special.image+"'></a></br><div style='padding-left:13px;width:140px;height:15px'>"+special.title+"</div></br>" +
                        "<a href='#' class='updWen' onclick=\"updWen(\'"+special.id+"\')\" >修改</a>" +
                        "<a href='#' class='delWen' onclick=\"delWen(\'"+special.id+"\')\" >删除</a>" +
                        "<a href='#' class='delWen' onclick=\"zhangjie(\'"+special.id+"\')\" >章节</a></br></div>" ;
            });

            $("#wenmain").html(str);

            $(".delWen").linkbutton({
                iconCls: 'icon-remove'
            });
            $(".updWen").linkbutton({
                iconCls: 'icon-edit'
            });
        },"JSON");
    };
</script>

<div style="text-align: center;margin-bottom: 20px">
    <a href="#" class="easyui-linkbutton" onclick="addWen()" data-options="iconCls:'icon-add'">添加吉祥妙音</a>
</div>

<div id="wenmain" ></div>
<div id="addwen"></div>

<div id="updwen"></div>
<div id="detialwen"></div>


