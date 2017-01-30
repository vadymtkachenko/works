import java.util.List;

/**
 * Created by 112 on 01.12.2016.
 */
public class RoleService {
    JDBCRoleDAO j2 = new JDBCRoleDAO();



    public  void tableView (Role role) {
        j2.getConnection();
        j2.create(role);
        List<Role> roles = j2.read();
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(roles.get(i));}

        j2.closeConnection();
    }
    public void withDelete ( Role role){
        j2.getConnection();
        j2.delete(role);
        List<Role> roles  = j2.read();
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(roles.get(i));}
        j2.closeConnection();
    }
    public void knowUsers(Role role){
        j2.getConnection();
        j2.countOfUsers(role);
        j2.closeConnection();
    }
}
