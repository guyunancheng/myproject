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
            String interet="";
            StringBuffer sb=new StringBuffer();
            if(hoddys!=null && hoddys.length>0){
                for(int i=0;i<hoddys.length-1;i++){
                    sb.append(hoddys[i]+",");

                }
                interet = sb.toString();
            }else {
                interet="";
            }
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
        //查询商品
        public List<Goods> findByGoods(Goods goods){
        Connection con=null;
        PreparedStatement par=null;
        ResultSet rs=null;
        List<Goods> list=new ArrayList<>();
            try {
                con=this.getconnection();
                StringBuffer sb=new StringBuffer();
                sb.append("select * from goodsinfo where 1=1 ");
                List<Object> paramlist=new ArrayList<>();
                if(goods!=null){
                    if (goods.getGoodsinfo_name()!=null){
                        sb.append("and goodsinfo_name=?");
                        paramlist.add(goods.getGoodsinfo_name());
                    }if(goods.getGoodsinfo_pic()!=null){
                        sb.append("and goodsinfo_pic=?");
                        paramlist.add(goods.getGoodsinfo_pic());
                    }
                    if(goods.getGoodsinfo_price()!=null){
                        sb.append("goodsinfo_price=?");
                        paramlist.add(goods.getGoodsinfo_price());
                    }
                    if(goods.getGoodsinfo_descri()!=null){
                        sb.append("goodsinfo_descri=?");
                        paramlist.add(goods.getGoodsinfo_descri());
                    }if(goods.getGoodsinfo_stock()!=0){
                        sb.append("goodsinfo_stock=?");
                        paramlist.add(goods.getGoodsinfo_stock());
                    }if(goods.getId()!=0){
                        sb.append("and id=?");
                        paramlist.add(goods.getId());
                    }
                }

                par=con.prepareStatement(sb.toString());
                if(paramlist!=null && paramlist.size()>0){
                    for (int i=1;i<=paramlist.size();i++){
                        par.setObject(i,paramlist.get(i-1));
                    }
                }
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

        //验证密码；
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

        public int inertGoods(Goods goods){
//            private String goodsinfo_name;
//            private String goodsinfo_pic;
//            private String goodsinfo_price;
//            private String goodsinfo_descri;//描述
//            private int goodsinfo_stock;//库存
            String sql="insert into goodsinfo(goodsinfo_name,goodsinfo_pic,goodsinfo_price,goodsinfo_descri,goodsinfo_stock) value(?,?,?,?,?)";
                List<Object> paramtlist=new ArrayList<>();
                paramtlist.add(goods.getGoodsinfo_name());
                paramtlist.add(goods.getGoodsinfo_pic());
                paramtlist.add(goods.getGoodsinfo_price());
                paramtlist.add(goods.getGoodsinfo_descri());
                paramtlist.add(goods.getGoodsinfo_stock());
                return this.executeupdate(sql,paramtlist);
        }
        //修改商品所有
        public int UpdateGoods(Goods goods){
            String sql="update goodsinfo set goodsinfo_name=?,goodsinfo_price=?,goodsinfo_descri=?,goodsinfo_stock=? where id='"+goods.getId()+"'";
            List<Object> paramlist=new ArrayList<>();
            //paramlist.add(goods.getGoodsinfo_pic());
            paramlist.add(goods.getGoodsinfo_name());
            paramlist.add(goods.getGoodsinfo_price());
            paramlist.add(goods.getGoodsinfo_descri());
            paramlist.add(goods.getGoodsinfo_stock());
            //paramlist.add(goods.getId());

            return executeupdate(sql,paramlist);
        }
        //删除商品
        public int DeleteGoods(Goods goods){
        Connection conn=null;
        PreparedStatement par=null;
        ResultSet rs=null;
            try {
                conn=this.getconnection();
                String sql="delete from goodsinfo where goodsinfo_name=?";
                par=conn.prepareStatement(sql);
                par.setObject(1,goods.getGoodsinfo_name());
                int i = par.executeUpdate();
                return i;

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.CloseAll(conn,par,rs);
            }
            return 0;
        }


}
