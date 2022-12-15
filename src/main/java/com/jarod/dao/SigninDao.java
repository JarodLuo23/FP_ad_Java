package com.jarod.dao;


import com.jarod.bean.User;

import java.sql.*;

public class SigninDao {
    public boolean checkuser(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod112211");
        PreparedStatement statement= connection.prepareStatement("select * from jdbcdb where username = '"+ user.getUsername()+"'and password = '"+ user.getPassword()+"';");
        ResultSet rs=statement.executeQuery();
        if (rs.next()){
            return true;
        }
        else {
            return false;
        }
    }
    public User showprofile(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod112211");
        PreparedStatement ps=connection.prepareStatement("select * from jdbcdb where username = '"+ user.getUsername()+"'and password = '"+ user.getPassword()+"';");
        ResultSet rs= ps.executeQuery();
        if (rs.next()){
            String fn=rs.getString("first_name");
            String ln=rs.getString("last_name");
            String un=rs.getString("username");
            String pwd=rs.getString("password");
            String tel=rs.getString("tel");
            String email=rs.getString("email");
            String country=rs.getString("country");
            User edituser=new User(fn,ln,un,pwd,tel,email,country);
            return edituser;
        }else {
            System.out.println("edit error");
            return null;
        }
    }



}
