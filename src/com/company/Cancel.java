package com.company;

import java.sql.*;

public class Cancel {
    public int cancelbyusername(String username) throws ClassNotFoundException {
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        int res = 0;
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;

            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();


            String sqlTest = "SELECT COUNT(*) FROM orders Where userID = '"+username+"'";   //首先判断order是否已存在

            r = stmt.executeQuery(sqlTest);

            while (r.next()) {

                //若用户名不存在，则返回无
                if(Integer.parseInt(r.getString(1) )== 0){

                    return res;
                }
            }

            String SQL = "DELETE FROM orders Where userID = '"+username+"'";

            stmt.execute(SQL);

            String SQL_3 = "SELECT roomID FROM orders Where userID = '"+username+"'";

            r = stmt.executeQuery(SQL_3);

            String roomid = r.getString(1);

            String SQL_4 = "SELECT Stime FROM orders Where userID = '"+username+"'";

            r = stmt.executeQuery(SQL_4);

            String stime = r.getString(1);

            String SQL_5 = "SELECT Etime FROM orders Where userID = '"+username+"'";

            r = stmt.executeQuery(SQL_5);

            String etime = r.getString(1);

            String SQL_2="";

            for(int i=Integer.parseInt(stime);i<=Integer.parseInt(etime);i++){

            SQL_2 = "UPDATE rooms SET course"+String.valueOf(i)+"=0 Where roomID = '"+roomid+"'";

            stmt.execute(SQL_2);

            r = stmt.executeQuery(sqlTest);

            }

            while (r.next()) {


                if(Integer.parseInt(r.getString(1) )== 1){

                    return 1;
                }else{
                    return 1;
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 1;
    }
}
