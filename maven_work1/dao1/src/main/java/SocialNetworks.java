
/**
 * Created by 112 on 27.11.2016.
 */
public class SocialNetworks {
    private int id;
    private String name;
    private int year;
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
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String toString(){
        return "ID: "+id+" Name: "+name+" Year: "+year;
    }
}

