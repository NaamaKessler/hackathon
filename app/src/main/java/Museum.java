

public class Museum {
    private String openingHours;
    private String about;
    private String  phone;
    private String address;

    Museum(){
        this.openingHours="Sun, Mon, Wed, Thur 10am-5 pm\nTues4-9 pm\nFri and Holidays Eves 10am-2pm";
        this.about="";
        this.phone ="02-6708811";
        this.address = "Rupin Blvd. 11, Jerusalem.";
    }

    public void PresentMuseum(){
        String text = "Opening Hours:\n" + this.openingHours +"\nTel: " + this.phone + "\n" + this.address;
    }

    //blabla
}
