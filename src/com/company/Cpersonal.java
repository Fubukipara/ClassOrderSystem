package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/pservlet")

public class Cpersonal extends HttpServlet {//教师注销类
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String is_delete = request.getParameter("is_delete");
        System.out.println(is_delete);
        String username=request.getParameter("username");
        System.out.println("注销账号："+username);
        if(is_delete.equals("true")){

            //删除表内信息
            select r=new select();
            int re=r.delete_teacher(username);
            if(re==1){
                //返回登录界面
                response.sendRedirect("index.jsp");
            }
        }
        else if(is_delete.equals("false")){
            this.getServletContext().setAttribute("username",username);
            request.getRequestDispatcher("personal.jsp").forward(request, response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }


}
