import java.util.LinkedList;
import java.util.List;

/**
 * Created by 112 on 01.12.2016.
 */
public class UserService {
     JDBCUserDAO j1 = new JDBCUserDAO();
    public  void tableView (User user) {
        j1.getConnection();
        j1.create(user);
        List<User> users = j1.read();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));}

            j1.closeConnection();
    }
    public void withDelete ( User user){
        j1.getConnection();
        j1.delete(user);
        List<User> users = j1.read();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));}
        j1.closeConnection();
    }
    public void knowRoles(User user){
        j1.getConnection();
        j1.countOfRoles(user);
        j1.closeConnection();
    }
}
