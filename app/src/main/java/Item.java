
import java.util.List;

public class Item {
    private final String title, artist, period, childInfo, adultInfo, expertInfo;
    private final int floor, room, childGrade, adultGrade, expertGrade;


    public Item(List attributes){
        this.title = (String)attributes.get(0);
        this.artist = (String)attributes.get(1);
        this.period = (String)attributes.get(2);
        this.floor = (int)attributes.get(3);
        this.room = (int)attributes.get(4);
        this.childGrade = (int)attributes.get(5);
        this.adultGrade = (int)attributes.get(6);
        this.expertGrade = (int)attributes.get(7);;
        this.childInfo = (String)attributes.get(8);
        this.adultInfo = (String)attributes.get(4);
        this.expertInfo = (String)attributes.get(4);
    }

    public void presentItem(){

    }

    public void presentBackground(){

    }


    public int getYear(){
        return 0;
    }

    public String getArtistName(){
        return null;
    }

    public String ChildrenExp(){
        return null;
    }


    public String adultsExp(){
        return null;
    }

    public String experts() {
        return null;
    }


}
