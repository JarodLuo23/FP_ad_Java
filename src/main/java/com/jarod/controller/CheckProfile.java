package com.jarod.controller;

import com.jarod.bean.User;
import com.jarod.dao.SigninDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@Controller
public class CheckProfile {
    @RequestMapping("checkprofile")
    public String checkprofile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        SigninDao dao = new SigninDao();
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();
        if (session.getAttribute("data") == null) {
            if (cookies.length != 1) {
                System.out.println(cookies.length);
                for (Cookie c : cookies) {
                    System.out.println(c.getName() + ": " + c.getValue());
                }
                String un = null, upw = null;
                for (Cookie c : cookies) {
                    if (("uncookie").equals(c.getName())) {
                        un = c.getValue();
                    }
                    if (("upwdcookie").equals(c.getName())) {
                        upw = c.getValue();
                    }
                    User user = new User(un, upw);
                    System.out.println("1212");
                    System.out.println("1" + un + "2" + upw);
                    System.out.println(c.getName() + " " + c.getValue() + c.getName() + " " + c.getValue());
                    try {
                        session.setAttribute("data", dao.showprofile(user));

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                return "profile";
            } else {
                request.setAttribute("profileerror","error");
                System.out.println("111");
                return "index";
            }
        } else {
            return "profile";
        }
    }
}

