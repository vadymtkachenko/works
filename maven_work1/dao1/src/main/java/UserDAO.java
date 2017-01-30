import java.util.List;

/**
 * Created by 112 on 19.11.2016.
 */
public interface UserDAO {
     void create(User user);
     List<User> read();
     void update(User user);
     void delete(User user);
     void countOfRoles(User user);



}
