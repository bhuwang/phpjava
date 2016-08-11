package com.lftechnology.phpjava.ems.dao;

import com.lftechnology.phpjava.ems.entities.Employee;
import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.enums.Role;
import com.lftechnology.phpjava.ems.utlis.DbFactory;
import com.lftechnology.phpjava.ems.utlis.PasswordHashGenerator;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * UserDaoImpl
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class UserDaoImpl implements DaoSignature<User> {
    protected Connection conn = DbFactory.getConnection();
    protected PreparedStatement stmt = null;


    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public int insert(User user) throws SQLException {
        int lastInsertedId = 0;
        String sql = "INSERT INTO user (username, password, is_terminated) VALUES ( ?, ? , 0);";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next())
        {
            lastInsertedId = rs.getInt(1);
        }
        return lastInsertedId;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        return false;
    }


    /**
     * Find the employee by role
     *
     * @param
     * @return User
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */

    public User findByUsernamePassword(User user) throws SQLException {

        String sql = "SELECT * FROM user WHERE is_terminated = 0 AND username = ?";
        String[] bindValues = {user.getUsername()};

        User result = findBy(sql, bindValues);
        try {
            if(result.getPassword() == null){
                result = new User();
            }
            else if (!PasswordHashGenerator.check(user.getPassword(), result.getPassword())) {
                result = new User();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @param sql
     * @param bindValues
     * @return User
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private User findBy(String sql, String[] bindValues) {
        User user = new User();
        try {
            stmt = conn.prepareStatement(sql);
            int counter = 1;
            for (String bindvalue : bindValues) {
                stmt.setString(counter, bindvalue);
                counter++;
            }
            ResultSet resultSet = stmt.executeQuery();
            user = setUserData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbFactory.closeConnection();
        }
        return user;
    }

    /**
     * set user data from the resultset
     *
     * @param resultSet
     * @return User
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    private User setUserData(ResultSet resultSet) {
        User user = new User();
        try {
            if (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setTerminated(resultSet.getBoolean("is_terminated"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
