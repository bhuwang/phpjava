package com.lftechnology.phpjava.ems.dao;

import com.lftechnology.phpjava.ems.entities.User;
import com.lftechnology.phpjava.ems.utlis.DbFactory;
import com.lftechnology.phpjava.ems.utlis.PasswordHashGenerator;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * UserDaoImpl
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public class UserDaoImpl implements DaoSignature<User> {
    protected Connection conn = DbFactory.getConnection();
    protected PreparedStatement stmt = null;

    /**
     * @param length
     * @return
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static String preparePlaceHolders(int length) {
        return String.join(",", Collections.nCopies(length, "?"));
    }

    /**
     * @param preparedStatement
     * @param values
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public static void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }

    /**
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    /**
     * @param user
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public int insert(User user) throws SQLException {
        int lastInsertedId = 0;
        String sql = "INSERT INTO user (username, password, is_terminated) VALUES ( ?, ? , 0);";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            lastInsertedId = rs.getInt(1);
        }
        return lastInsertedId;
    }

    /**
     * @param user
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public int update(User user) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE user SET ");
        boolean update = false;
        String value = "";
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            update = true;
            value = user.getUsername();
            sql.append(" username = ?");
        } else if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            update = true;
            value = user.getPassword();
            sql.append(" password = ?");
        }
        if (update) {
            sql.append(" where id = ?");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, value);
            stmt.setInt(2, user.getId());
            return stmt.executeUpdate();
        }
        return 0;
    }

    /**
     * @param user
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    @Override
    public int delete(User user) throws SQLException {
        return 0;
    }

    /**
     * @param userIds
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public int delete(Set<Integer> userIds) throws SQLException {
        String sql = "DELETE FROM user WHERE id IN(%s)";
        String sqlNew = String.format(sql, this.preparePlaceHolders(userIds.size()));
        stmt = conn.prepareStatement(sqlNew);
        this.setValues(stmt, userIds.toArray());
        return stmt.executeUpdate();
    }

    /**
     * @param userIds
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public int terminateUsers(Set<Integer> userIds) throws SQLException {
        String sql = "UPDATE user SET is_terminated = 1 WHERE id IN(%s)";
        String sqlNew = String.format(sql, this.preparePlaceHolders(userIds.size()));
        stmt = conn.prepareStatement(sqlNew);
        this.setValues(stmt, userIds.toArray());
        return stmt.executeUpdate();
    }

    /**
     * Find the employee by role
     *
     * @param
     * @return User
     * @throws Exception
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    public User findByUsernamePassword(User user) throws Exception {

        String sql = "SELECT * FROM user WHERE is_terminated = 0 AND username = ?";
        String[] bindValues = {user.getUsername()};

        User result = findBy(sql, bindValues);
        if (result.getPassword() == null) {
            result = new User();
        } else if (!PasswordHashGenerator.check(user.getPassword(), result.getPassword())) {
            result = new User();
        }
        return result;
    }


    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param sql
     * @param bindValues
     * @return
     * @throws SQLException
     */
    private User findBy(String sql, String[] bindValues) throws SQLException {
        User user = new User();
        stmt = conn.prepareStatement(sql);
        int counter = 1;
        for (String bindvalue : bindValues) {
            stmt.setString(counter, bindvalue);
            counter++;
        }
        ResultSet resultSet = stmt.executeQuery();
        user = setUserData(resultSet);

        return user;
    }

    /**
     * set user data from the resultset
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param resultSet
     * @return User
     * @throws SQLException
     */
    private User setUserData(ResultSet resultSet) throws SQLException {
        User user = new User();
        if (resultSet.next()) {
            user.setUsername(resultSet.getString("username"))
                    .setPassword(resultSet.getString("password"))
                    .setTerminated(resultSet.getBoolean("is_terminated"))
                    .setId(resultSet.getInt("id"));
        }
        return user;
    }

}
