/**
 * Created by 112 on 19.11.2016.
 */

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JDBCUserDAO implements UserDAO{

    private JdbcTemplate jdbcTemplate;

    public JDBCUserDAO (DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    Connection connection =null;

//    public Connection getConnection (){
//    try {
//        Class.forName("com.mysql.jdbc.Driver");
//        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/basefor","root","root");
//        }
//    catch (NullPointerException e) {
//
//        e.printStackTrace();
//
//    }
//     catch (ClassNotFoundException e) {
//
//        e.printStackTrace();
//
//    } catch (SQLException e) {
//
//        e.printStackTrace();
//
//    }
//        return connection;
//}
    public void create(User user) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO basefor.user (id ,name, email, birthday) VALUES (? , ?,?,?)");
//            preparedStatement.setInt(1,user.getId());
//
//            preparedStatement.setString(2,user.getName());
//            preparedStatement.setString(3,user.getEmail());
//            preparedStatement.setString(4,user.getBirthday());
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

             PreparedStatement createPreparedStatement (Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO basefor.user (id ,name, email, birthday) VALUES (? , ?,?,?)");
                ps.setString(2,user.getName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getBirthday());
            ps.executeUpdate();
            ps.close();
                return ps;
            }

    }
    public List<User> read() {
//        List<User> users = new LinkedList<User>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM basefor.user ");
//
//            User user = null;
//            while(resultSet.next()){
//                user = new User();
//                user.setId(Integer.parseInt(resultSet.getString("id")));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setBirthday(resultSet.getString("birthday"));
//
//                users.add(user);
//            }
////            for (int i = 0; i < users.size(); i++) {
////                System.out.println(users.get(i));
////            }
//            resultSet.close();
//            statement.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        catch (NullPointerException e) {
//            e.printStackTrace();
//            System.out.println("Check connection");
//        }
//        //System.out.println(users);
//        return users;
            return jdbcTemplate.query("SELECT * FROM basefor.user ", new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setBirthday(rs.getString("birthday"));
                    return user;
                }
            });
        }

    public void delete(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM basefor.user WHERE id=?");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE basefor.user SET name=?, email=?, birthday=? WHERE id=?");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getBirthday());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void countOfRoles(User user){
        try{
            System.out.println("All roles of "+user.getName());
            PreparedStatement stmt1 = connection.prepareStatement("SELECT distinct a.name\n" +
                    "FROM user\n" +
                    "JOIN user_has_role AS ba ON user.id\n" +
                    " = ba.User_id\n" +
                    "JOIN role AS a ON a.id = ba.Role_id\n" +
                    "WHERE ba.User_id =\n" +
                    " (select user.id from user where name = ? )");
            stmt1.setString(1,user.getName());
            ResultSet rs1 = stmt1.executeQuery();

            while (rs1.next()) {
                String b = rs1.getString("name");
                System.out.println(b+" ");
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    public void closeConnection(){
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (Exception e) {
//            //do nothing
//        }
//    }
}



