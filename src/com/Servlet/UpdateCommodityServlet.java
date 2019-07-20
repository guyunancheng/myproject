package com.Servlet;

import com.Dao.UserGoodsDao;
import com.Entidy.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "UpdateCommodityServlet",urlPatterns = "/updatecommodityServlet")
public class UpdateCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //传入数据调用Dao里面的方法查询
        int id =Integer.parseInt(req.getParameter("id")) ;
        Goods goods3=new Goods(id);
        UserGoodsDao ugd=new UserGoodsDao();
        List<Goods> findGoodsByid
                = ugd.findByGoods(goods3);
        if (findGoodsByid!=null&&findGoodsByid.size()>0){
            req.setAttribute("listid",findGoodsByid);
            req.getRequestDispatcher("UpdateCommodity.jsp").forward(req,resp);
        }else{
            PrintWriter out=resp.getWriter();
            out.print("商品已经空了滚吧");
        }



    }
}
