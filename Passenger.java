//import java.util.Objects;

public class Passenger extends Person {

    //Declaring variables
    private int holdBags;

    private String flightClass;

    //Creating the constructor function for the object
    Passenger(String Name, int PassportNumber,String flightClass, int holdBags) {
        super(Name, PassportNumber);
        this.holdBags = holdBags;
        this.flightClass = flightClass;
    }

    //Made Getters and Setters for each variable in the constructor function.
    public int getHoldBags() {
        return holdBags;
    }

    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }


    // declare method to calculate the weight
    public double calculatePersonWeight() {
        //if(getFlightClass().equals(flightClass, "first")){return 87.5 + getHoldBags() * 25;}
        //else{return 80 + getHoldBags()*25;}
        //if("first")){return 87.5 + getHoldBags() * 25;}

        if("first".equals(getFlightClass())){return 87.5 + getHoldBags() * 25;}
        else{return 80 + getHoldBags()*25;}
    }
}
