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
@WebServlet(name = "DeleteGoodsServlet",urlPatterns = "/deleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String goodsinfo_name03 = req.getParameter("goodsinfo_name");

        if(goodsinfo_name03!=null&&goodsinfo_name03.trim()!=""){
            Goods goods3=new Goods(goodsinfo_name03);
            UserGoodsDao userGoodsDao3=new UserGoodsDao();
            int i = userGoodsDao3.DeleteGoods(goods3);
            PrintWriter out=resp.getWriter();
            if (i>0){
                out.print("<script type='text/javascript'>alert('删除成功');</script>");
                List<Goods> byGoods = userGoodsDao3.findByGoods(null);
                req.setAttribute("byGoods",byGoods);
                req.getRequestDispatcher("CommodityJstl.jsp").forward(req,resp);
            }else {
                out.print("<script type='text/javascript'>alert('删除失败');</script>");
            }
        }

    }
}
