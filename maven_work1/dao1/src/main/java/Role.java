/**
 * Created by 112 on 26.11.2016.
 */
public class Role {
    private int id;
    private String name;
    private String active;
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
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }
    public String toString(){
        return "ID: "+id+" Name: "+name+" Active: "+active;
    }
}
