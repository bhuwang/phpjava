package com.lftechnology.phpjava.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.lftechnology.phpjava.assignment.entity.User;
import com.lftechnology.phpjava.assignment.library.DBConnection;
import com.mysql.jdbc.Statement;

public class UserDaoImpl implements DataAccessInterface<User> {

    protected Connection conn = DBConnection.getConnection();
    protected PreparedStatement stmt = null;
    
    @Override
    public List<User> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO user (username, password, is_terminated) VALUES ( ?, ? , 0);";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public int update(User user) throws SQLException {
        String sql = "UPDATE user set"
                + "is_terminate = 1,"
                + "where user_id =?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        return stmt.executeUpdate();
    }

    @Override
    public int delete(User user) throws SQLException {
        String sql = "delete from user where employee_id =?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        return stmt.executeUpdate();
    }
    
    public int findValidUser(User user) throws SQLException {

        String sql = "SELECT * FROM user WHERE is_terminated = 0 AND username = ? and password = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) { 
            int idUser = rs.getInt("iduser"); 
            return idUser;
           }
        return 0;        
    }

}
