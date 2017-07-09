
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/guru/findDetialById",{
            id:'${param.id}'
        },function (data) {
            $('#id').html(data.id);
            $('#name').html(data.name);
            $('#username').html(data.username);
            $('#status').html(data.status);
            var u="";
            $.each(data.users,function (index, user) {
                u+=(user.name+"  ");
            });
            $('#users').html(u);
            var p="";
            $.each(data.points,function (index, points) {
                p+=(points.name+"  ");
            });
            $('#points').html(p);
            var s="";
            $.each(data.speeches,function (index, speeche) {
                s+=(speeche.name+"  ");
            });
            $('#speeches').html(s);
        })
    })
</script>

    <div style="text-align: center;">
        <table id="tt" style="text-align: center" cellpadding="0" cellspacing="0" border="0"
               class="form_table">
            <tr>
                <td valign="middle" align="right">
                    id:
                </td>
                <td valign="middle" id="id" align="left">
                </td>
            </tr>
            <tr>
                <td valign="middle"  align="right">
                    姓名:
                </td>
                <td valign="middle" id="name"  align="left">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    账号:
                </td>
                <td valign="middle" id="username" align="left">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    状态:
                </td>
                <td valign="middle" id="status" align="left">

                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    弟子:
                </td>
                <td valign="middle" id="users" align="left">

                </td>
            </tr><tr>
            <td valign="middle" align="right">
                显密法要:
            </td>
            <td valign="middle" id="points" align="left">

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                上师言教:
            </td>
            <td valign="middle" id="speeches" align="left">

            </td>
        </tr>
        </table>
    </div>