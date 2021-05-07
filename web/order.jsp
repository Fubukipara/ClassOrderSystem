<%@ page import="java.util.ArrayList" %>
<%@ page  %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/4/19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

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
  <a href="order.jsp"style="color:#F0F8FF">
    <li>
      <h3>资源预约</h3>
    </li>
  </a>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <a href="my.jsp"style="color:#F0F8FF">
    <li>
      <h3>我的预约</h3>
    </li>
  </a>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <a href="personal.jsp"style="color:#F0F8FF">
    <li>
      <h3>个人中心</h3>
    </li>
  </a>
</div>
<div id="content" style="background-color:#F5F5F5;height: 640px;width:100%;margin-left: 100px">

    <meta charset="UTF-8">
    <title>搜索框</title>



  <div class="combin" style="width:100%">
    <div class="option" style="width:20%">
      <link rel="stylesheet" href="select.css">
      <p>预约教室信息</p>
      <select id="floorr" name="floor" onchange="choose();">
        <option value=" " selected="selected">==按楼层筛选==</option>
        <option value="floor1">一楼</option>
        <option value="floor2">二楼</option>
        <option value="floor3">三楼</option>
        <option value="floor4">四楼</option>
      </select>
    </div>
    <div class="option" style="width:20%">
      <select id="roomm" name="room">
        <option value=" " selected="selected">==请选择房间号==</option>
      </select>
      <script type="text/javascript">
          function choose(){
              var value=document.getElementById("floorr").value;
              var content=document.getElementById("roomm");
              content.options.length=0;
              if(value=="floor1"){
                  content.add(new Option("101","101"))
                  content.add(new Option("102","102"))
                  content.add(new Option("103","103"))
                  content.add(new Option("104","104"))
                  content.add(new Option("105","105"))
              }else if(value=="floor2"){
                  content.add(new Option("201","201"))
                  content.add(new Option("202","202"))
                  content.add(new Option("203","203"))
                  content.add(new Option("204","204"))
                  content.add(new Option("205","205"))
              }else if(value=="floor3"){
                  content.add(new Option("301","301"))
                  content.add(new Option("302","302"))
                  content.add(new Option("303","303"))
                  content.add(new Option("304","304"))
                  content.add(new Option("305","305"))
              }else if(value=="floor4"){
                  content.add(new Option("401","401"))
                  content.add(new Option("402","402"))
                  content.add(new Option("403","403"))
                  content.add(new Option("404","404"))
                  content.add(new Option("405","405"))
              }else if(value==" "){
                  content.add(new Option("==请选择房间号==","==请选择房间号=="))
              }
          }
      </script>
      <script type="text/javascript">
          var roomnumber = $("#roomm option:checked").text();  // 获取select 显示值
          var v1 = document.getElementsByTagName("select")[0].value;
          var v2 = document.getElementsByTagName("select")[1].value;
      </script>
    </div>
    <div class="search">
      <link rel="stylesheet" href="search.css">
      <form action="room"method="post">
        <input type="text" placeholder="请输入房间号" name="room"  />
        <input type="text" style="display: none" name="username" value="<%=request.getParameter("username")%>">
        <button><i>搜索</i></button>
      </form>
    </div>
    <div class="timetable" style="width:80%;float:left;position: relative;left:700px;bottom:250px">
      <form action="orderRoom"method="post">
      <div class="roomtitle">

        <h1>
          <%=request.getAttribute("room")%>
        </h1>
      </div>

        <input type="text" style="display:none"name="username" value="<%=request.getAttribute("username")%>">
        <input type="text" style="display:none"name="room" value="<%=request.getAttribute("room")%>">
        <input id="r1"type="radio" name="ordernum" value="1" >第一节课<%=request.getAttribute("list1")%>
        <input id="r2"type="radio" name="ordernum" value="2" >第二节课<%=request.getAttribute("list2")%>
        <br>
        <input id="r3"type="radio" name="ordernum" value="3" >第三节课<%=request.getAttribute("list3")%>
        <input id="r4"type="radio" name="ordernum" value="4" >第四节课<%=request.getAttribute("list4")%>
        <br>
        <input id="r5"type="radio" name="ordernum" value="5" >第五节课<%=request.getAttribute("list5")%>
        <input id="r6"type="radio" name="ordernum" value="6" >第六节课<%=request.getAttribute("list6")%>
        <br>
        <input id="r7"type="radio" name="ordernum" value="7" >第七节课<%=request.getAttribute("list7")%>
        <input id="r8"type="radio" name="ordernum" value="8" >第八节课<%=request.getAttribute("list8")%>
        <br>
        <input id="r9"type="radio" name="ordernum" value="9" >第九节课<%=request.getAttribute("list9")%>
        <input id="r10"type="radio" name="ordernum" value="10" >第十节课<%=request.getAttribute("list10")%>
        <br>
      <input type="submit" value="预约" style="width:100px;height:40px;border:2px;background-color: #483d8b;color:#FFFFFF;margin-top:10px;">
      </form>


      <script>
          //取出传回来的参数error并与yes比较
          var errori ='<%=request.getParameter("error")%>';
          if(errori=='success'){
              alert("预定成功");
          }
          else if(errori=="not") {alert("预定失败")}
      </script>



    </div>
  </div>
</div>

<div id="footer" style="background-color:#483D8B;clear:both;text-align:center;color:#F0F8FF;opacity:0.7">
  版权  404notfound.com</div>
</body>
</html>
