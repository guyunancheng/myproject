package com.Servlet;

import com.Dao.UserGoodsDao;
import com.Entidy.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommodityDetails",urlPatterns = "/commodityDetails")
public class CommodityDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String goodsinfo_name4= req.getParameter("goodsinfo_name");
        Goods goods4=new Goods(goodsinfo_name4);
        UserGoodsDao userGoodsDao4=new UserGoodsDao();
        List<Goods> byGoods4 = userGoodsDao4.findByGoods(goods4);
        req.setAttribute("byGoods4",byGoods4);
        req.getRequestDispatcher("CommodityDetails.jsp").forward(req,resp);
        }
}
