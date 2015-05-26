package com.ccs.zhang.servlet;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.omg.CORBA.UnknownUserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhang on 2015/5/26.
 */
public class FormFilterLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = (String)request.getParameter("shiroLoginFailure");
        if (UnknownUserException.class.getName().equals(error)){
            request.setAttribute("error","用户名/密码错误");
        }else if (IncorrectCredentialsException.class.getName().equals(error)){
            request.setAttribute("error","用户名/密码错误");
        }else if (error != null){
            request.setAttribute("error","未知错误");
        }
        request.getRequestDispatcher("/WEB-INF/jsp/formfilterlogin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
