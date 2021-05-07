package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class select {//数据库操作类
    public String select_teacher_name(String userName) {//查找教师名字
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "SELECT Tname FROM teachers Where TID = '" + userName + "'";

            r = stmt.executeQuery(sqlTest);      //执行sql语句并返回结果集
            if(r.next()){
               // System.out.println("Tname:"+r.getString("Tname"));
                return r.getString("Tname");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return "";
    }
    public String select_student_name(String userName){//查找学生姓名
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "SELECT Sname FROM students Where StuID = '" + userName + "'";

            r = stmt.executeQuery(sqlTest);      //执行sql语句并返回结果集
            if(r.next()){
                //System.out.println("Sname:"+r.getString("Sname"));
                return r.getString("Sname");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return "";
    }
    public int delete_teacher(String userName){//注销教师账号
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "DELETE FROM teachers Where TID = '" + userName + "'";

            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
    public int delete_student(String userName){//注销学生账号
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "DELETE FROM students Where StuID = '" + userName + "'";

            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
    public int delete_admin(String userName){
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "DELETE FROM adms Where AID = '" + userName + "'";

            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
    public  int change_teacher_pass(String userName,String pass){//修改教师密码
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();
            //String N="宋媛焱";
            String sqlTest = "update teachers set Tpassword='"+pass+"' Where TID = '" + userName + "'";
            //String sqlTest="update teachers set Tname='"+N+"'where TID='"+userName+"'";
            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
    public int change_student_pass(String userName,String pass){//修改学生密码
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "update students set Spassword='"+pass+"' Where StuID = '" + userName + "'";

            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
    public int change_admin_pass(String userName,String pass){
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();
            //String N="宋媛焱";
            String sqlTest = "update adms set Apassword='"+pass+"' Where AID = '" + userName + "'";
            //String sqlTest="update teachers set Tname='"+N+"'where TID='"+userName+"'";
            stmt.executeUpdate(sqlTest);      //执行sql语句
            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }

    public List select_room(int num){
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        List list=new ArrayList();
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "select course1,course2,course3,course4,course5,course6,course7,course8,course9,course10 from rooms where roomID="+num;

            r=stmt.executeQuery(sqlTest);      //执行sql语句

            while (r.next()){
                list.add(r.getString("course1"));
                list.add(r.getString("course2"));
                list.add(r.getString("course3"));
                list.add(r.getString("course4"));
                list.add(r.getString("course5"));
                list.add(r.getString("course6"));
                list.add(r.getString("course7"));
                list.add(r.getString("course8"));
                list.add(r.getString("course9"));
                list.add(r.getString("course10"));
                System.out.println(list);
            }
            stmt.close();
            return list;

        } catch (Exception e) {
            System.out.print(e);
        }
        return list;
    }
    public int order_room(String username,int num,int start,int end,int id){
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        List list=new ArrayList();
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Declare the JDBC objects.


            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "insert into orders values ('"+username+"',"+id+",'"+username+"',"+start+","+end+","+num+")";
            stmt.executeUpdate(sqlTest);      //执行sql语句
            for(int k=start;k<=end;k++){
                String tmp="course"+String.valueOf(k);
                String SQ="update rooms set "+tmp+"=1 where roomID="+num;
                stmt.executeUpdate(SQ);
            }

            stmt.close();
            return 1;

        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
   //public static void main(String args[]){
     //   order_room(101,1,3);
     //  change_teacher_pass("20181001094","");
    //}

}
