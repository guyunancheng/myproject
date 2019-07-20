package com.Servlet;

import com.Dao.UserGoodsDao;
import com.Entidy.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "updateCommodityServlet02",urlPatterns = "/updateCommodityServlet02")
public class UpdateCommodityServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        /**AddCommodityServlet addCommodityServlet=new AddCommodityServlet();
        Goods goods1=null;
        try {
//            goods = this.uploadFile02(req,resp);
             goods1 = addCommodityServlet.uploadFile(req, resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }*/
        int id= Integer.parseInt(req.getParameter("id2"));
        String goodsinfo_name2 = req.getParameter("goodsinfo_name2");
        String goodsinfo_price2 = req.getParameter("goodsinfo_price2");
        String goodsinfo_descri2 = req.getParameter("goodsinfo_descri2");
        String goodsinfo_stock2 = req.getParameter("goodsinfo_stock2");
        int goodsinfo_stock3 = Integer.parseInt(goodsinfo_stock2);

        Goods goods1=new Goods(goodsinfo_name2,goodsinfo_price2,goodsinfo_descri2,goodsinfo_stock3,id);

        UserGoodsDao userGoodsDao=new UserGoodsDao();

        int i = userGoodsDao.UpdateGoods(goods1);
        if (i>0){
            PrintWriter out=resp.getWriter();
            out.print("<script type='text/javascript'>alert('修改成功');</script>");

            List<Goods> byGoods = userGoodsDao.findByGoods(null);
            req.setAttribute("byGoods",byGoods);
            req.getRequestDispatcher("CommodityJstl.jsp").forward(req,resp);
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
        }


        }
    /**public Goods uploadFile02(HttpServletRequest req, HttpServletResponse resp) throws FileUploadException, IOException {
        Goods goods=new Goods();
        //1.判断当前表单是否为上传表单；
        boolean ismultipart = ServletFileUpload.isMultipartContent(req);
        if (ismultipart){
            //表示是上传表单控件；
            //2.如果是
            //2.1就创建servletFileupload对象；
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            //2.2获得表单里所有控件对象；
            List<FileItem> fileItemslist = upload.parseRequest(req);
            //2.3遍历
            if(fileItemslist!=null&&fileItemslist.size()>0){
                for(FileItem fileItem:fileItemslist){
                    //2.4判断控件对象是普通控件对象还是上传表单控件对象；
                    if(fileItem.isFormField()){
                        //2.4.1获取文件名；
                        String fileName=fileItem.getName();
                        //2.4.2将文件上传到服务器指定的的目录
                        //获得WeB工程在Tomcat下的绝对路径；
                        String parentPath = req.getServletContext().getRealPath("/upload02");
                        //判断目录是否存在，如果不存在就创建；
                        File parentFile=new File(parentPath);
                        //parentFile.exists():判断如果是真就存在目录；
                        //parentFile.mkdirs();用于创建文件
     /普通表单控件：文本框，密码框等的表单控件；
     if("goodsinfo_name2".equals(fileItem.getFieldName())){
     goods.setGoodsinfo_name(fileItem.getString("utf-8"));
     }else if("goodsinfo_price2".equals(fileItem.getFieldName())){
     goods.setGoodsinfo_price(fileItem.getString("utf-8"));
     }else if("goodsinfo_descri2".equals(fileItem.getFieldName())){
     goods.setGoodsinfo_descri(fileItem.getString("utf-8"));
     }else if("goodsinfo_stock2".equals(fileItem.getFieldName())){
     goods.setGoodsinfo_stock(Integer.parseInt( fileItem.getString()));
     }
     }else{
     //上传表单控件：<input type="file">
     /if (!parentFile.exists())parentFile.mkdirs();
                        //如果不报错，就将这个文件名设置到对象属性中;
                        //获得上传文件对象；
                        File newFile=new File(parentFile,fileName);
                        //写文件需要两个流：
                        //获得输入流和输出流；
                        //输入流用于读文件；
                        InputStream is = fileItem.getInputStream();
                        //输出流用于写文件；
                        OutputStream os=new FileOutputStream(newFile);
                        //写文件操作：
                        IOUtils.copy(is,os);
                        //关闭流；由内往外关
                        is.close();
                        os.close();
                        //设置上传的文件的文件名保存在对象的属性中；
                        goods.setGoodsinfo_pic(fileName);



                    }
                }
            }

        }else {
            //普通表单控件
        }

        return goods;
    }*/
}
