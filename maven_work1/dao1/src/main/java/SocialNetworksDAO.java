import java.util.List;

/**
 * Created by 112 on 27.11.2016.
 */
public interface SocialNetworksDAO {
     void create(SocialNetworks networks);
     List<SocialNetworks> read();
    void update(SocialNetworks networks);
     void delete(SocialNetworks networks);
     void countOfUsers(SocialNetworks networks);
}
