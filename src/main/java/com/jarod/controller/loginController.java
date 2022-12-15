package com.jarod.controller;

import com.jarod.bean.User;
import com.jarod.dao.SigninDao;
import com.jarod.dao.SignupDao;
import com.sun.applet2.AppletParameters;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//@WebServlet("/signin")
@Controller
public class loginController {
    @RequestMapping("signincontroller")
    public String signincontroller(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String un = request.getParameter("username");
        String upw = request.getParameter("pwd");
        String cookies = request.getParameter("cookies");
        HttpSession session = request.getSession();
        User user = new User(un, upw);
        SigninDao dao = new SigninDao();
        PrintWriter pw = response.getWriter();

        boolean check = false;
        boolean checksignin = false;
        try {
            checksignin = dao.checkuser(user);
            if (checksignin == false) {
//                response.sendRedirect("signin.jsp");
//                JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
                System.out.println("fff");
//                model.addAttribute("msg","false");
                session.setAttribute("loginerror","error");
                pw.print("<script type='text/javascript'>window.alert('The account do not exist!!');window.location.href='signin';</script>");
            } else {
                if (cookies != null) {
                    if (cookies.equals("on")) {
                        Cookie uc = new Cookie("uncookie", un);
                        Cookie upwc = new Cookie("upwdcookie", upw);
                        response.addCookie(uc);
                        response.addCookie(upwc);
                        uc.setMaxAge(60 * 60 * 24 * 7);
                        upwc.setMaxAge(60 * 60 * 24 * 7);
                        System.out.println("create cookies successful");
                    }
                }
                session.setAttribute("data", dao.showprofile(user));
                check = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (check == true) {
            return "index";
        } else
            return "signin";
    }

    @RequestMapping("signupcontroller")
    public String signupcontroller(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(firstname, lastname, username, password, tel, email, country);
        //        User checkuser=new User(username);
        SignupDao dao = new SignupDao();
        //        request.setAttribute("checkun",checkuser);
        PrintWriter pw = response.getWriter();
        boolean checkun = false;
        boolean checksignup = false;
        try {
            checksignup = dao.registerData(user);
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        if (checksignup == false) {
//            pw.print("<script type='text/javascript'>window.alert('The username has exist!!');window.location.href='signup.jsp';</script>");
//                request.getRequestDispatcher("signup.jsp").forward(request,response);
            request.setAttribute("signuperror","error");
            return "signup";
        } else {
            return "signin";
        }
//        if (checkun==true){
//            System.out.println("The username has exist!!");
//            pw.println("asfasd");
//            pw.print("<script type='text/javascript'>alert('The username has exist!!');window.location.href='signup.jsp';</script>");
//            response.sendRedirect("signup.jsp");
//        }else{
//            if (checksignup!=false){
//                response.sendRedirect("signin.jsp");
//            }
//        }

    }
}

