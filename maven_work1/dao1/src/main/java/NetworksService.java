import java.util.List;

/**
 * Created by 112 on 01.12.2016.
 */
public class NetworksService {
    JDBCNetworksDAO j3 = new JDBCNetworksDAO();

    public  void tableView (SocialNetworks networks) {
        j3.getConnection();
        j3.create(networks);
        List<SocialNetworks> networkses = j3.read();
        for (int i = 0; i < networkses.size(); i++) {
            System.out.println(networkses.get(i));}

        j3.closeConnection();
    }

    public void withUpdate ( SocialNetworks networks){
        j3.getConnection();
        j3.update(networks);
        List<SocialNetworks> networkses  = j3.read();
        for (int i = 0; i < networkses.size(); i++) {
            System.out.println(networkses.get(i));}
        j3.closeConnection();
    }

    public void countOfAccounts (SocialNetworks networks){
        j3.getConnection();

        j3.countOfUsers(networks);
        j3.closeConnection();

    }
    public void del ( SocialNetworks networks){
        j3.getConnection();
        j3.delete(networks);
        j3.closeConnection();
    }

}
