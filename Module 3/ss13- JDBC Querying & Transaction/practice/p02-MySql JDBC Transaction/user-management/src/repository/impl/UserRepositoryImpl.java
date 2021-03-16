package repository.impl;

import model.User;
import repository.IUserRepository;
import repository.dbconnection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    public static final String SELECT_ALL_USERS = "select * from users;";
    public static final String INSERT_USER = "insert into users (name, email, country) values (?, ?, ?);";
    public static final String SELECT_USER_BY_ID = "select * from users where id = ?;";
    public static final String UPDATE_USER = "update users set name = ?, email = ?, country = ? where id = ?;";
    public static final String DELETE_USER_BY_ID = "delete from users where id = ?;";
    public static final String SELECT_USER_BY_COUNTRY = "select * from users where country like concat ('%',?,'%');";

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
                resultSet = preparedStatement.executeQuery();

                User user;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    String country = resultSet.getString(4);
                    user = new User(id, name, email, country);
                    userList.add(user);
                }
                Collections.sort(userList);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return userList;
    }

    @Override
    public User findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    String country = resultSet.getString(4);
                    user = new User(id, name, email, country);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_USER);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(int id, User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_USER);
                preparedStatement.setInt(4, id);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<User> findByCountry(String txtSearch) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
                preparedStatement.setString(1, txtSearch);
                resultSet = preparedStatement.executeQuery();
                User user;

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    String country = resultSet.getString(4);
                    user = new User(id, name, email, country);
                    userList.add(user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void addUserTransaction(User user, int[] permission) {
        Connection connection = null;

        // for insert a new user
        PreparedStatement statement = null;

        // for assign permission to user
        PreparedStatement preparedStatement = null;

        // for getting user id
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();

            // set auto commit to false
            connection.setAutoCommit(false);

            // Insert user
            statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
//            statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            int rowAffected = statement.executeUpdate();

            // get user id
            resultSet = statement.getGeneratedKeys();
            int userId = 0;
            if (resultSet.next())
                userId = resultSet.getInt(1);

            // in case the insert operation successes, assign permission to user
            if (rowAffected == 1) {
                // assign permision to user
                String sqlPivot = "INSERT INTO userpermission(permissionid,userid) "
                        + "VALUES(?,?)";

                preparedStatement = connection.prepareStatement(sqlPivot);

                for (int permissionId : permission) {

                    preparedStatement.setInt(1, permissionId);

                    preparedStatement.setInt(2, userId);

                    preparedStatement.executeUpdate();

                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException ex) {
            // roll back the transaction
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
