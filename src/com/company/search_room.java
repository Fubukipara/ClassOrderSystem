package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/room")
public class search_room extends HttpServlet {//查询可预约教室
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num=request.getParameter("room");
        if(num==null){
            request.getRequestDispatcher("order.jsp").forward(request,response);
        }
        String username=request.getParameter("username");
        System.out.println("room:"+username);
        int roomnum=Integer.parseInt(num);
        select s=new select();
        List list=new ArrayList();
        list=s.select_room(roomnum);
        //System.out.println("查询后："+list);
        for(int k=0;k<10;k++){
            String tmp="list"+String.valueOf(k+1);
            if(list.get(k).toString().equals("0")){
                request.setAttribute(tmp,"可预约");
            }
            else {
                request.setAttribute(tmp,"不可预约");
            }
        }

        request.setAttribute("room",num);
        request.setAttribute("username", username);
        //request.getAttribute("username",username);
        request.getRequestDispatcher("order.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
