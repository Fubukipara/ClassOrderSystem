package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sservlet")

public class JServlet extends HttpServlet {                //学生登录接口类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");          //获得用户名和密码
        String pwd = request.getParameter("password");
        //查询用户姓名
        select s=new select();
        String name=s.select_student_name(username);
        System.out.print("查询到的姓名"+name);
        //传递用户姓名和类型数据到personal.jsp
        this.getServletContext().setAttribute("name",name);
        this.getServletContext().setAttribute("type","student");
        login Login = new login();

        int a = Login.loginjudge(username,pwd);

        if (a == 0) {
//验证成功，转向登录成功后的界面（这里暂时用注册界面代替）
            request.getRequestDispatcher("StuPersonal.jsp").forward(request, response);
            //response.sendRedirect("personal.jsp"+username+"&name="+name);
        } else if(a==1) {
//验证失败，转向登录界面，并传递一个参数，表示用户名错误
            response.sendRedirect("index.jsp?error=username");
        }else if(a==2){
            //密码错误
            response.sendRedirect("index.jsp?error=pwd");
        }

        }

    }
