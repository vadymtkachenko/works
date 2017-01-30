import java.util.List;

/**
 * Created by 112 on 26.11.2016.
 */
public interface RoleDAO  {

     void countOfUsers(Role role);
     void create(Role role);
    List<Role> read();
     void update(Role role);
     void delete(Role role);
}
