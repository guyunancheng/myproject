package com.Dao;

import com.Entidy.Goods;
import com.Entidy.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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


            String[] hoddys=use.getHobbys();
            StringBuffer sb=new StringBuffer();
            if(hoddys.length>0){
                for(int i=0;i<hoddys.length-1;i++){
                    sb.append(hoddys[i]+",");

                }
            }
            if (sb.length()>=2){
                sb.deleteCharAt(sb.length()-1);
            }

            String interet = sb.toString();
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
        @Test
        public List<Goods> findByGoods(Goods goods){
        Connection con=null;
        PreparedStatement par=null;
        ResultSet rs=null;
        List<Goods> list=new ArrayList<>();
            try {
                con=this.getconnection();
                StringBuffer sb=new StringBuffer();
                sb.append("select * from goodsinfo");
                List<Object> paramlist=new ArrayList<>();
                par=con.prepareStatement(sb.toString());
                rs=par.executeQuery();
                while (rs.next()){
                    Goods goods1=new Goods();
                    goods1.setId(rs.getInt("id"));
                    goods1.setGoodsinfo_name(rs.getString("goodsinfo_name"));
                    goods1.setGoodsinfo_pic(rs.getString("goodsinfo_pic"));
                    goods1.setGoodsinfo_price(rs.getString("goodsinfo_price"));
                    goods1.setGoodsinfo_descri(rs.getString("goodsinfo_descri"));
                    goods1.setGoodsinfo_stock(rs.getInt("goodsinfo_stock"));
                    list.add(goods1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.CloseAll(con,par,rs);
            }
            return list;
        }
        public List<Object> approvePassword(String username,String password){
        Connection con=null;
        PreparedStatement par=null;
        ResultSet rs=null;
        con=this.getconnection();
        List<Object> list=new ArrayList<>();
            try {
                String sql="select * from user where username=? and password=?";
                par=con.prepareStatement(sql);
                par.setObject(1,username);
                par.setObject(2,password);
                rs=par.executeQuery();
                while (rs.next()){
                    User user=new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    list.add(user);
                    }


            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.CloseAll(con,par,rs);
            }
            return list;
        }

}
