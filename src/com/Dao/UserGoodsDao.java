package com.Dao;

import com.Entidy.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGoodsDao {
    private final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/test3?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private final String username="root";
    private final String password="123456";
@Test
    public Connection getconnection(){
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void CloseAll(Connection con, PreparedStatement par, ResultSet rs){
        try {
            if (rs!=null){
                rs.close();
            }
            if (par!=null){
                par.close() ;
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    private int id;
//    private String username;
//    private String password;
//    private char sex;
//    private String hobbys;
//    private String phone;
//    private String email;
//    private String addrs;
    @Test
        public int insertUser(User use){
         String sql="insert into user(username,password,sex,hobbys,phone,email,addrs) value(?,?,?,?,?,?,?)";
            List<Object> paramlist=new ArrayList<>();
            paramlist.add(use.getUsername());
            paramlist.add(use.getPassword());
            paramlist.add(use.getSex());
        String interet = use.getHobbys().toString().toString();
        paramlist.add(interet);



            paramlist.add(use.getPhone());
            paramlist.add(use.getPhone());
            paramlist.add(use.getAddrs());
        return this.executeupdate(sql,paramlist);
    }
    public int executeupdate(String sql,List<Object> paramList){

            Connection conn = null;
            PreparedStatement pra = null;
            ResultSet rs = null;

            try {
                // 1、获得连接对象
                conn = this.getconnection();

                // 2、创建语句集
                pra = conn.prepareStatement(sql);
                // 设置占位符的值
                if(paramList!=null && paramList.size()>0){
                    for(int i=0;i<paramList.size();i++){
                        pra.setObject(i+1, paramList.get(i));
                    }
                }
                // 执行sql并获得受影响的行数
                int rows = pra.executeUpdate();
                return rows;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.CloseAll(conn, pra, rs);
            }
            return 0;
        }

}
