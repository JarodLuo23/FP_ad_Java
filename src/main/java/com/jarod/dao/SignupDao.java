package com.jarod.dao;

import com.jarod.bean.User;

import java.sql.*;

public class SignupDao {
    public boolean registerData(User user) throws ClassNotFoundException, SQLException {
        String insert_user_SQL="insert into jdbcdb"+"(first_name,last_name,username,password,tel,email,country) values(?,?,?,?,?,?,?);";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod112211");
        PreparedStatement preparedStatement=null;
        int result=0;
        try {
            preparedStatement = connection.prepareStatement(insert_user_SQL);
            connection.setAutoCommit(false);
            preparedStatement.setString(1,user.getFirst_name());
            preparedStatement.setString(2,user.getLast_name());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getTelephone());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setString(7,user.getCountry());
            System.out.println(preparedStatement);
            result =preparedStatement.executeUpdate();
            connection.commit();
            if (result==0) {
                System.out.println("username has exist");
                return false;
            }
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
        return true;
    }
    public boolean checkun(String un) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod112211");
        PreparedStatement st=connection.prepareStatement("select * from jdbcdb where username = "+un+";");
        ResultSet rs =st.executeQuery();
        if (rs.next()){
            return true;
        }else {
            return false;
        }
    }

}
