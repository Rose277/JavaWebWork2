package com.xxxx.controller;

import com.xxxx.entity.SMenu;
import com.xxxx.service.UserService;
import com.alibaba.fastjson.JSON;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置相应数据的编码格式
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //拿到前台ajax请求的数据
        String index=req.getParameter("id");
        //调用Service方法进行数据库操作
        UserService userService=new UserService();
        List<SMenu> list=userService.loadMenu(Integer.valueOf(index));
        //数据转码返回给前台
        String data=JSON.toJSONString(list);
        PrintWriter writer=resp.getWriter();
        writer.write(data);
        writer.flush();
        writer.close();
    }
}
