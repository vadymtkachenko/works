import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 112 on 27.11.2016.
 */

public class JDBCNetworksDAO implements SocialNetworksDAO {
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
    public void create(SocialNetworks networks) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO basefor.social_networks (id ,name, startofwork) VALUES (?,?,?)");
            preparedStatement.setInt(1,networks.getId());
            preparedStatement.setString(2,networks.getName());
            preparedStatement.setInt(3,networks.getYear());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<SocialNetworks> read() {
        List<SocialNetworks> networks_list = new LinkedList<SocialNetworks>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM basefor.social_networks ");
            SocialNetworks networks = null;
            while(resultSet.next()){
                networks = new SocialNetworks();
                networks.setId(Integer.parseInt(resultSet.getString("id")));
                networks.setName(resultSet.getString("name"));
                networks.setYear(Integer.parseInt(resultSet.getString("startofwork")));
                networks_list.add(networks);
            }
//            for (int i = 0; i < networks_list.size(); i++) {
//                System.out.println(networks_list.get(i));
//            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(users);
        return networks_list;
    }


    public void update(SocialNetworks networks) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE basefor.social_networks SET name=?, startofwork=? WHERE id=?");
            preparedStatement.setString(1,networks.getName());
            preparedStatement.setInt(2,networks.getYear());
            preparedStatement.setInt(3,networks.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void delete(SocialNetworks networks) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM basefor.social_networks WHERE id=?");
            preparedStatement.setInt(1,networks.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void countOfUsers(SocialNetworks networks) {
        try {
            System.out.println("Count of "+networks.getName()+" users");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(distinct a.name) as Count\n" +
                    "FROM social_networks\n" +
                    "JOIN user_has_social_networks AS ba ON social_networks.id\n" +
                    " = ba.Social_networks_id\n" +
                    "JOIN user \n" +
                    "AS a ON a.id = ba.User_id\n" +
                    "WHERE ba.Social_networks_id =\n" +
                    " (select social_networks.id from social_networks where name = ?)");
            preparedStatement.setString(1, networks.getName());
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
