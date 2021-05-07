<%--
  Created by IntelliJ IDEA.
  User: Tian Panpan
  Date: 2021/4/29
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的预约</title>
</head>
<body>
<div id="header" style="background-color:#483D8B;height: 40px;opacity:0.7">
    <h1 style="text-align: center;color:#F0F8FF">学校辅导室预约系统</h1>
</div>
<div id="menu"style="background-color: #483D8B;height: 640px;width: 100px;float: left;opacity:0.7">
    <br/>
    <a href="admins.jsp"style="color:#F0F8FF">
        <li>
            <h3>浏览预约</h3>
        </li>
    </a>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <a href="Apersonal.jsp"style="color:#F0F8FF">
        <li>
            <h3>个人中心</h3>
        </li>
    </a>
</div>
<div id="content" style="background-color:#F5F5F5;height: 640px;width: 100%;margin-left: 100px">

    <div class="banner_con">
        <div class="list_block_media_list"style="width: 100%">
            <div class="item_row"style="border-bottom: 1px solid #cccccc;margin-top: 20px;margin-left:50px;width: 100%">
                <div class="item_title_username"style="color: #4a4a4a;font-size: 150%">
                    <%=application.getAttribute("name")%>
                </div>
            </div>
        </div>
        <div class="item_text_usercount"style="color: #4a4a4a;margin-left:50px;font-size:150% ">
            <%=request.getParameter("username")%>
        </div>
    </div>

    <div class="list-block-touch-top">
        <script>
            function change() {
                document.getElementById('cha_pas').style.display = 'block';
            }
        </script>
        <div id="cha_pas">
            <div style="width:400px;height: 40px">
                <form action="schange"method="post">
                    请输入账号
                    <input name="username" type="text" placeholder="账号" />
                    <br>
                    请输入旧密码
                    <input name="Opassword" type="password" placeholder="旧密码" />
                    <br>
                    请输入新密码
                    <input name="Npassword" type="password" placeholder="新密码" />
                    <br>
                    <input type="submit"value="确定">
                </form>
            </div>
        </div>
        <li><a href="javascript:void(0)" class="item-list" onclick="change()">
            <div class="item-inner"><div class="item-text" >修改密码</div></div>

        </a></li>
        <li><a href="assist.jsp" class="item-list">
            <div class="item-inner"><div class="item-text" >使用帮助</div></div>

        </a></li>
        <li><a href="exit"class="item-list">
            <div class="item-inner"><div class="item-text" >退出</div></div>

        </a></li>
        <SCRIPT LANGUAGE="javascript">
            function openwin() {

                document.getElementById('zhuxiao').style.display = 'block';
            }
        </SCRIPT>
        <li>
            <a href="javascript:void(0)"onclick="openwin()"class="item-list">
                <div class="item-inner"><div class="item-text" >
                    注销
                </div></div>
            </a>
        </li>

        <div id="zhuxiao"style="display: none; ">
            <div style="width:400px;height: 40px">
                <form action="adelete" method="post">
                    <p>确定注销账号吗？</p>
                    <br>
                    <input type="radio" name="is_delete" value="true" checked>确认
                    <input type="radio" name="is_delete" value="false">取消
                    <br>
                    若确定注销请再次填写用户名和密码
                    <br>
                    若选择取消直接点击提交按钮
                    <br>
                    用户名
                    <input name="username" type="text" placeholder="用户名" />
                    <br>
                    密码
                    <input name="password" type="password" placeholder="密码" />
                    <br>
                    <input type="submit" value="提交">
                </form>
            </div>
        </div>

    </div>
    </form>
</div>

<div id="footer" style="background-color:#483D8B;clear:both;text-align:center;color:#F0F8FF;opacity:0.7">
    版权  404notfound.com</div>
</body>
</html>
