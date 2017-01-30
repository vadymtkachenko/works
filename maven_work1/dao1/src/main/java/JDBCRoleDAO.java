import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 112 on 26.11.2016.
 */
public class JDBCRoleDAO implements RoleDAO {
    Connection connection =null;
    public Connection getConnection (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/basefor","root","root");
        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return connection;
    }
    public void create(Role role){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO basefor.role (id ,name, active) VALUES (?,?,?)");
            preparedStatement.setInt(1,role.getId());
            preparedStatement.setString(2,role.getName());
            preparedStatement.setString(3,role.getActive());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public List<Role> read() {
        List<Role> roles = new LinkedList<Role>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM basefor.role ");
            Role role = null;
            while(resultSet.next()){
                role = new Role();
                role.setId(Integer.parseInt(resultSet.getString("id")));
                role.setName(resultSet.getString("name"));
                role.setActive(resultSet.getString("active"));
                roles.add(role);
            }
//            for (int i = 0; i < roles.size(); i++) {
//                System.out.println(roles.get(i));
//            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(users);
        return roles;
    }
    public void delete(Role role) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM basefor.role WHERE id=?");
            preparedStatement.setInt(1,role.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void update(Role role) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE basefor.role SET name=?, active=? WHERE id=?");
            preparedStatement.setString(1,role.getName());
            preparedStatement.setString(2,role.getActive());
            preparedStatement.setInt(3,role.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void countOfUsers(Role role){
        try {
            System.out.println("Count of "+role.getName());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(distinct a.name) as Count\n" +
                    "FROM role\n" +
                    "JOIN user_has_role AS ba ON role.id\n" +
                    " = ba.Role_id\n" +
                    "JOIN user \n" +
                    "AS a ON a.id = ba.User_id\n" +
                    "WHERE ba.Role_id =\n" +
                    " (select role.id from role where name = ?)");
            preparedStatement.setString(1, role.getName());
            ResultSet rs3 = preparedStatement.executeQuery();
            while (rs3.next()) {
                String b = rs3.getString("Count");
                System.out.println(b + " ");
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

}
