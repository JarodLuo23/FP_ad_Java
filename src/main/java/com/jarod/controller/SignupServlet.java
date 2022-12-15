//package com.jarod.controller;
//
//import com.jarod.bean.User;
//import com.jarod.dao.SignupDao;
//import org.springframework.stereotype.Controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//
//
//@Controller
//public class SignupServlet extends javax.servlet.http.HttpServlet {
//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String firstname=request.getParameter("firstname");
//        String lastname=request.getParameter("lastname");
//        String username=request.getParameter("username");
//        String password=request.getParameter("pwd");
//        String tel=request.getParameter("tel");
//        String email=request.getParameter("email");
//        String country=request.getParameter("country");
//        User user=new User(firstname,lastname,username,password,tel,email,country);
////        User checkuser=new User(username);
//        SignupDao dao=new SignupDao();
////        request.setAttribute("checkun",checkuser);
//        PrintWriter pw= response.getWriter();
//        boolean checkun=false;
//        boolean checksignup=false;
//        try {
//            checksignup= dao.registerData(user);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        if (checksignup==false){
//            pw.print("<script type='text/javascript'>window.alert('The username has exist!!');window.location.href='signup.jsp';</script>");
////                request.getRequestDispatcher("signup.jsp").forward(request,response);
//        }else {
//            response.sendRedirect("signin.jsp");
//        }
////        if (checkun==true){
////            System.out.println("The username has exist!!");
////            pw.println("asfasd");
////            pw.print("<script type='text/javascript'>alert('The username has exist!!');window.location.href='signup.jsp';</script>");
////            response.sendRedirect("signup.jsp");
////        }else{
////            if (checksignup!=false){
////                response.sendRedirect("signin.jsp");
////            }
////        }
//    }
//
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
//}
