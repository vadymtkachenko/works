/**
 * Created by 112 on 19.11.2016.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String birthday;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return "ID: "+id+" Name: "+name+" Email: "+email+" Birthday: "+birthday;
    }
}
