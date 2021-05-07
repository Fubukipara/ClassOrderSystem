package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderRoom")
public class order_room extends HttpServlet {//预定教室
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomnum=request.getParameter("room");
        String ordernum=request.getParameter("ordernum");
        String username=  request.getParameter("username");
        System.out.println("orderRoom"+username);
        System.out.println(roomnum);
        System.out.println(ordernum);
        int id=5;
        select s=new select();
        int re=s.order_room(username,Integer.valueOf(roomnum),Integer.valueOf(ordernum),Integer.valueOf(ordernum),id);
        if(re==1){
            String result=String.valueOf(re);
            request.setAttribute("result",result);
            response.sendRedirect("order.jsp?error=success");
            //request.getRequestDispatcher("order.jsp").forward(request,response);
        }


    }
}
