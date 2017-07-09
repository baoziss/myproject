<%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>持明法洲后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
            
        })
        function addtabs(title,href) {
            if(!$("#tt").tabs('exists',title)){
                $("#tt").tabs('add',{
                    title:title,
                    fit:true,
                    href:href,
                    closable:true
                });
            }else {
                $("#tt").tabs('select',title)
            }
        }

        function logout(){
            $("#logout").linkbutton({
                href:'${pageContext.request.contextPath}/manager/logout'
            })
        }
    </script>
</head>
    <body class="easyui-layout">
        <div data-options="region:'north',split:false" style="height:100px;">
            <div style="text-align: center;font-size: 50px;color:#4b72a4">
                持明法洲后台管理系统
            </div>

            <div style="text-align: right">
                <shiro:principal/>&nbsp;&nbsp;<a id="logout" href="javascript:;" class="easyui-linkbutton" onClick="logout()" data-options="plain:true">退出</a>
            </div>
        </div>
        <div data-options="region:'south',split:false" style="height:100px;"></div>
        <div data-options="region:'west',title:'菜单',split:false" style="width:200px;">
            <div id="aa" class="easyui-accordion" data-options="fit:true"  style="width:300px;height:200px;">
                <shiro:hasAnyRoles name="admin,super">
                <div title="用户管理" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <a id="b1" href="#" onclick="addtabs('用户基本信息管理','${pageContext.request.contextPath}/back/user/basic.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">用户基本信息管理</a>
                    <a id="b2" href="#" onclick="addtabs('用户功课管理','${pageContext.request.contextPath}/back/work/work.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">用户功课管理</a>
                </div>
                <div title="首页轮播图管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                    <a id="b3" href="#" onclick="addtabs('轮播图展示','${pageContext.request.contextPath}/back/home/index.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">轮播图展示</a>
                </div>
                <div title="吉祥妙音" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <a id="b4" href="#" onclick="addtabs('展示专辑','${pageContext.request.contextPath}/back/wen/index.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">展示专辑</a>
                </div>
                <div title="甘露妙宝" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <a id="b5" href="#" onclick="addtabs('上师言教','${pageContext.request.contextPath}/back/speech/index.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">上师言教</a>
                    <a id="b6" href="#" onclick="addtabs('显密法要')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">显密法要</a>
                </div>
                <div title="上师管理" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <a id="b7" href="#" onclick="addtabs('显示上师','${pageContext.request.contextPath}/back/guru/index.jsp')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">显示上师</a>
                </div>
                </shiro:hasAnyRoles>

                <shiro:hasRole name="super">
                <div title="系统管理" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <a id="b8" href="#" onclick="addtabs('系统日志')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">系统日志</a>
                    <a id="b9" href="#" onclick="addtabs('清楚缓存')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">清楚缓存</a>
                    <a id="b10" href="#" onclick="addtabs('定时清空备份')" class="easyui-linkbutton" style="width: 99%;border: 1px solid blue;margin-top: 10px" data-options="iconCls:'icon-search'">定时清空备份</a>
                </div>
                </shiro:hasRole>
            </div>
        </div>
        <div data-options="region:'center',title:'主页'" style="padding:5px;">
            <div id="tt" class="easyui-tabs" data-options="fit:true">
            </div>
        </div>
    </body>
</html>
