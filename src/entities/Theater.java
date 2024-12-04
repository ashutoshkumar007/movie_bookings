package entities;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private long theatreId;
    private String name;
    private Address address;
    private List<Screen> screens;

    public Theater(long id, String tName, Address address){
        theatreId=id;
        name = tName;
        this.address=address;
        screens = new ArrayList<>();
    }

    public long getTheatreId() {
        return theatreId;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen){
        screens.add(screen);
        System.out.println("New screen "+screen.getScreenName() +" added to theater "+ getName());
    }

}
