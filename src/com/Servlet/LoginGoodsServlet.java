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

@WebServlet (name="goodsServlet",urlPatterns="/goodsServlet")

public class LoginGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username1 = req.getParameter("username1");
        String password1 = req.getParameter("password1");
        UserGoodsDao userGoodsDao=new UserGoodsDao();
        List<Object> list = userGoodsDao.approvePassword(username1,password1);
        if (list.size()>=1){
            List<Goods> byGoods = userGoodsDao.findByGoods(null);
            req.setAttribute("byGoods",byGoods);
            req.getRequestDispatcher("CommodityJstl.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('账号或密码错误');location.href='Login.jsp';</script>");

        }


    }
}
