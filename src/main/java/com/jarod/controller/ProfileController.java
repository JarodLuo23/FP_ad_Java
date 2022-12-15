package com.jarod.controller;

import com.jarod.bean.User;
import com.jarod.dao.SigninDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class ProfileController{
    @RequestMapping("profile")
    public String profiledisplay(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User editdata=new User(firstname,lastname,username,password,telephone,email,country);
        User editpwd=new User(username,password);
        HttpSession session=request.getSession();
        SigninDao dao=new SigninDao();
        PrintWriter out= response.getWriter();
        boolean checkedit=false;
        boolean check=false;
        try {
            checkedit=editprofile(editdata);
            if (checkedit==false){
                out.println("error");
                request.setAttribute("profile","error");
                check=false;
            }else {
                session.setAttribute("data",dao.showprofile(editpwd));
//                response.sendRedirect("index.jsp");
                check=true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (check=true){
        return "index";
        }else
        return "profile";
    }

    public boolean editprofile(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","@Jarod123");
//        PreparedStatement ps=connection.prepareStatement("update jdbcdb set first_name ='"+user.getFirst_name()+"',last_name='"+user.getLast_name()+
//                                            "',password='"+user.getPassword()+"',tel='"+user.getTelephone()+"',email='"+user.getEmail()+"',country='"+user.getCountry()+"' where" +
//                " username='"+user.getUsername()+"';");
        PreparedStatement ps=connection.prepareStatement("update jdbcdb set first_name =?,last_name=?,password=?,tel=?,email=?,country=? where username=?;");
        connection.setAutoCommit(false);
        int result=0;
        ps.setString(1,user.getFirst_name());
        ps.setString(2,user.getLast_name());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getTelephone());
        ps.setString(5,user.getEmail());
        ps.setString(6,user.getCountry());
        ps.setString(7,user.getUsername());
        System.out.println(ps);
        result=ps.executeUpdate();
        connection.commit();
        if (result==0){
            return false;
        }
        return true;

    }

}