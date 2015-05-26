package com.ccs.zhang.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


import java.io.IOException;

/**
 * Created by zhang on 2015/5/26.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String error = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
            error = "用户名/密码错误";
        }catch (IncorrectCredentialsException e){
            error = "用户名/密码错误";
        }catch (AuthenticationException e){
            error = "其他错误";
        }
        if (error != null){
            request.setAttribute("error",error);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    }
}
