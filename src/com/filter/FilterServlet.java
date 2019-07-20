package com.filter;

import com.Entidy.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FilterServlet implements Filter {
    private List<String> urlFilerlist=Arrays.asList(
            "/Register.jsp",
            "/goodsServlet",
            "/Register.jsp",
            "/userServlet",
            ".jpg",
            ".png"
    );
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req= (HttpServletRequest) servletRequest;
        //1.获得请求的uri
        //http:localhost:8080/Login.jsp;
        String uri = req.getRequestURI();
        //1）有哪些url需要放行的
        boolean flag=false; //如果flag为false就找不到要放行的url
        if(urlFilerlist!=null&&urlFilerlist.size()>0){
            for(String uriskr:urlFilerlist){
                if(uri.startsWith(uriskr)){
                    //判断uri是不是以uriskr开头
                    //如果是就放行
                    flag=true;
                    break;

                }
            }
        }
        if(flag){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //2)除了第一点需要放行的其他的url都需要登录验证过滤；
            //获得session中保存的User对象；
            HttpSession session=req.getSession();
            User LoginUser= (User) session.getAttribute("userinfo");
            if(LoginUser!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                req.setAttribute("msg","请先登录");
                req.getRequestDispatcher("Login.jsp").forward(servletRequest,servletResponse);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
