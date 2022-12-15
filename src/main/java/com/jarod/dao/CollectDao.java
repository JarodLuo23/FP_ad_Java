package com.jarod.dao;

import com.jarod.bean.Movie;
import com.jarod.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CollectDao {

    public boolean CollectData(ArrayList<Movie> movie) throws ClassNotFoundException, SQLException {
        String insert_user_SQL="insert into movie_display"+"(id,moviename,moviedetail) values(?,?,?);";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod123");
        PreparedStatement preparedStatement=null;
        int result=0;
        try {
            for (int i=0;i<movie.size();i++) {
                preparedStatement = connection.prepareStatement(insert_user_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setString(1, movie.get(i).getId());
                preparedStatement.setString(2, movie.get(i).getMoviename());
                preparedStatement.setString(3, movie.get(i).getMoviedetail());
                System.out.println(preparedStatement);
                result = preparedStatement.executeUpdate();
                connection.commit();
                if (result == 0) {
                    System.out.println("movie can't be added");
                    return false;
                }
            }
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
        return true;
    }

    public boolean DeleteData(ArrayList<Movie> movie) throws ClassNotFoundException, SQLException {
        String insert_user_SQL="delete from movie_display where id=?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&allowPublicKeyRetrieval=true","root","@Jarod123");
        PreparedStatement preparedStatement=null;
        int result=0;
        try {
            for (int i=0;i<movie.size();i++) {
                preparedStatement = connection.prepareStatement(insert_user_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setString(1, movie.get(i).getId());
                System.out.println(preparedStatement);
                result = preparedStatement.executeUpdate();
                connection.commit();
                if (result == 0) {
                    System.out.println("movie can't be deleted");
                    return false;
                }
            }
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
        return true;
    }

}
