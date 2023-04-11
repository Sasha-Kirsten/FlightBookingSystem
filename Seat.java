public class Seat {

    //Declaring variables
    private int row;

    private int seat;

    private String flyingClass;

    private Passenger allocatedTo;

    //Creating the constructor function for the object
    Seat(int row, int seat, String flyingClass){
        this.row = row;

        this.seat = seat;

        this.flyingClass = flyingClass;
    }

    //Made Getters and Setters for the variable not in the constructor function.

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFlyingClass() {
        return flyingClass;
    }

    public void setFlyingClass(String flyingClass) {
        this.flyingClass = flyingClass;
    }

    public Passenger getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(Passenger allocatedTo) {
        this.allocatedTo = allocatedTo;
    }
}
