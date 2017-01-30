/**
 * Created by 112 on 01.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        UserService userService = new UserService();
        user.setName("Lena");
        user.setEmail("yrte@mail.ru");
        user.setId(7);
        user.setBirthday("15.10.1995");
        System.out.println("Create");
        userService.tableView(user);
        user.setId(7);
        System.out.println("Delete");
        userService.withDelete(user);
        user.setName("Vadim");
        System.out.println("Roles");
        userService.knowRoles(user);
        System.out.println("NEXT");
        Role role =new Role();
        RoleService roleService = new RoleService();
        role.setId(4);
        role.setName("Gr2");
        role.setActive("1");
        System.out.println("Create");
        roleService.tableView(role);
        role.setId(4);
        System.out.println("Delete");
        roleService.withDelete(role);
        role.setName("Admin");
        roleService.knowUsers(role);
        System.out.println("Networks");
        SocialNetworks networks =new SocialNetworks();
        NetworksService networksService = new NetworksService();
        networks.setId(5);
        networksService.del(networks);
        networks.setId(5);
        networks.setName("Gr3");
        networks.setYear(2000);
        System.out.println("Create");
        networksService.tableView(networks);
        networks.setId(5);
        networks.setName("Gr67");
        networks.setYear(2000);
        System.out.println("Update");
        networksService.withUpdate(networks);
        networks.setName("Facebook");
        networksService.countOfAccounts(networks);



    }
}
