package com.Servlet;

import com.Dao.UserGoodsDao;
import com.Entidy.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name ="userServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username2");
        String password = req.getParameter("password2");
        String sex = req.getParameter("sex");
        String[] hobbys = req.getParameterValues("hobbys");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        UserGoodsDao userGoodsDao=new UserGoodsDao();
        List<Object> list = userGoodsDao.approvePassword(username, password);
        if (list.size()>=1){
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('用户名已被占用请重新填写用户名');location.href='Register.jsp';</script>");
        }else {
            User use=new User(username,password,sex,hobbys,phone,email,addrs);
            int row=userGoodsDao.insertUser(use);
            if(row>0){
//           PrintWriter writer=resp.getWriter();
                PrintWriter out = resp.getWriter();
                out.println("<script type='text/javascript'>alert('注册成功');location.href='Login.jsp';</script>");
            }
        }



    }

}
