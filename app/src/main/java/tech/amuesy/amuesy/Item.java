package tech.amuesy.amuesy;

import java.util.List;

public class Item {
    private final String title, artist, period, childInfo, adultInfo, expertInfo;
    private final int floor, room, creationYear;

    public Item(List attributes){
        this.title = (String)attributes.get(0);
        this.artist = (String)attributes.get(1);
        this.period = (String)attributes.get(2);
        this.floor = (int)attributes.get(3);
        this.room = (int)attributes.get(4);
        this.childInfo = (String)attributes.get(8);
        this.adultInfo = (String)attributes.get(9);
        this.expertInfo = (String)attributes.get(10);
        this.creationYear = (int)attributes.get(11);
    }

    public String presentItem(String visitorType){
        //get details:
        String text = "Title: " + this.title + "\nArtist: " + this.artist + "\nYear of creation: " +
                this.creationYear + "\nPeriod: " + this.period + "\n\n";
        // get tailored info:
        switch (visitorType) {
            case "Child":
                text += this.childInfo;
                break;
            case "Easy":
                text += this.childInfo;
                break;
            case "Teen":
                text += this.childInfo;
                break;
            case "Intermediate":
                text += this.childInfo;
                break;
            case "Adult":
                text += this.adultInfo;
                break;
            default:
                text += this.expertInfo;
        }
        return text;
    }

    public String getLocation(){
        return "Floor: " + this.floor + "Hall no.: " + this.room;
    }


}
