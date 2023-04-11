//Importing all the required libraries
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Flight {

    //Declaring two array lists, seats and crew.
    public ArrayList<Seat> seats = new ArrayList();

    public ArrayList<CrewMember> crew = new ArrayList();

    //Declaring variables
    private int flightNumber;

    private Aircraft craft;

    private String startLocation;

    private String endLocation;

    private double distance;

    // declare counters variables
    public int totalFirstClassPassengers;
    public int totalEconomicClassPassengers;
    public int totalNUmberUnallocatedSeats;
    public int totalNumberOfSeats;

    //Creating the constructor function for the object
    Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance) {

        this.flightNumber = flightNumber;

        this.craft = craft;

        this.startLocation = startLocation;

        this.endLocation = endLocation;

        this.distance = distance;

        // store the layout of the aircraft
        File newFile = getCraft().getLayoutFile();

        // declare and initialized the scanner
        Scanner in;

        // declare counters to fill the seats
        int numSeat = 0;
        int numRow = 0;
        try {
            in = new Scanner(newFile);

            // loop the file until we have data
            while (in.hasNextLine()) {
                // store entire line of the file in one string
                String p_str = in.nextLine();
                // declare array to store flyingClass
                String[] p_data2 = p_str.split(",");

                // loop and store seat in array list
                // but first add counter for row
                numRow++;
                for(int s=0;s<p_data2.length;s++){
                    // increase seat
                    numSeat++;
                    // create an object to store data
                    Seat oneSeat = new Seat(numRow, numSeat, p_data2[s]);
                    // finally, append the data to the array list
                    seats.add(oneSeat);
                }
            }
      } catch (FileNotFoundException e) {}
    }

    //Made the Getters and Setters for each variable in the constructor function.
    public int getFlightNumber() {return flightNumber;}

    public void setFlightNumber(int flightNumber) {this.flightNumber = flightNumber;}

    public String getStartLocation() {return startLocation;}

    public void setStartLocation(String startLocation) {this.startLocation = startLocation;}

    public String getEndLocation() {return endLocation;}

    public void setEndLocation(String endLocation) {this.endLocation = endLocation;}

    public double getDistance() {return distance;}

    public void setDistance(double distance) {this.distance = distance;}

    public Aircraft getCraft() {return craft;}

    public void setCraft(Aircraft craft) {this.craft = craft;}

    // declare the method to calculate the total weight of the aircraft
    public double calculateTakeOffWeight() {
//         // declare counters variables
//         double totalCrewWeight = 0;
//         double totalPeopleWeight = 0;
//         double totalPeopleBagsWeight = 0;
//         for(int x=0;x<seats.size();x++){
//             //totalPeopleWeight = seats.get(x). .calculatePersonWeight();
//             //totalPeopleBagsWeight += seats.get(x).getAllocatedTo().calculatePersonWeight();
//             totalPeopleBagsWeight += seats.get(x).getAllocatedTo().getHoldBags();

// //            if(seats.get(x).getFlyingClass() == "first"){
// //                totalPeopleWeight += 80;
// //            }else{
// //                totalPeopleWeight += 87.5;
// //            }
//         }
//         for(int y=0; y<crew.size();y++){
//             totalCrewWeight += crew.get(y).calculatePersonWeight();
//         }
//         if((getCraft().getCraftWeight() + totalPeopleWeight + totalCrewWeight)<getCraft().getMaximumTakeoffWeight()){
//             // return total final weight of the aircraft
//             return getCraft().getCraftWeight() + totalPeopleWeight + totalCrewWeight;
//         }
//         //Or return -1, meaning that the aircraft is not allowed to takeoff.
//         return -1;

        double totalCrewWeight = 0;
        double totalPeopleWeight = 0;
        double totalPeopleBagsWeight = 0;

        for (int x = 0; x < seats.size(); x++) {
            Passenger passenger = seats.get(x).getAllocatedTo();

            if (passenger != null) {
                totalPeopleWeight += passenger.calculatePersonWeight();
                totalPeopleBagsWeight += passenger.getHoldBags() * 25;
            }
        }

        for (int y = 0; y < crew.size(); y++) {
            totalCrewWeight += crew.get(y).calculatePersonWeight();
        }

        double totalWeight = getCraft().getCraftWeight() + totalPeopleWeight + totalCrewWeight;

        if (totalWeight < getCraft().getMaximumTakeoffWeight()) {
            return totalWeight;
        }

        return -1;
    }

    // declare the method book a seat
    public int bookSeat(Passenger Passenger) {

        boolean upGradeTheSeat = false;
        boolean downGradeTheSeat = false;

        totalNumberOfSeats = seats.size();

        if (Objects.equals(Passenger.getFlightClass(), "first")) {
            for (Seat seat : seats) {
                if (Objects.equals(seat.getFlyingClass(), "F")) {
                    //we found an available seat
                    if (seat.getAllocatedTo() == null) {//seat.getAllocatedTo() == 0
                        // reserve the seat for the passenger
                        seat.setAllocatedTo(Passenger);//seat.getSeat()
                        // update first class counter
                        totalFirstClassPassengers++;
                        // booking completed
                        return 1;
                    }
                }
            }
            downGradeTheSeat = true;
        }

        // check is economic class of the passenger
        if (Objects.equals(Passenger.getFlightClass(), "economy") || !downGradeTheSeat) {
            // loop seats for available seat and reserve seat for the passenger
            for (Seat seat : seats) {
                // check we have an economic class seat
                if (Objects.equals(seat.getFlyingClass(), "E")) {
                    // we found an available seat
                    if (seat.getAllocatedTo() == null) {//seat.getAllocatedTo() == 0
                        // reserve the seat for the passenger
                        seat.setAllocatedTo(Passenger);//seat.getSeat()
                        // update economic class counter
                        totalEconomicClassPassengers++;
                        // booking completed
                        return 1;
                    }
                }
            }
            upGradeTheSeat = true;
        }
        // check we have a seat downgraded
        if (downGradeTheSeat) {
            // loop seats for available seat and reserve seat for the passenger
            for (Seat seat : seats) {
                // check we have an economic class seat
                if (Objects.equals(seat.getFlyingClass(), "E")) {
                    // we found an available seat
                    if (seat.getAllocatedTo() == null) {//seat.getAllocatedTo() == 0
                        // reserve the seat for the passenger
                        seat.setAllocatedTo(Passenger);//seat.getSeat()
                        // update economic and first classes counters
                        totalEconomicClassPassengers++;
                        totalFirstClassPassengers--;
                        // passenger downgraded
                        return 3;
                    }
                }
            }
        }
        // check we have a seat upgraded
        if (upGradeTheSeat) {
            // loop seats for available seat and reserve seat for the passenger
            for (Seat seat : seats) {
                // check we have an economic class seat
                if (Objects.equals(seat.getFlyingClass(), "F")) {
                    // we found an available seat
                    if (seat.getAllocatedTo() == null) {//seat.getAllocatedTo() ==0
                        // reserve the seat for the passenger
                        seat.setAllocatedTo(Passenger);//seat.getSeat()
                        // update economic and first classes counters
                        totalEconomicClassPassengers--;
                        totalFirstClassPassengers++;
                        // passenger downgraded
                        return 2;
                    }
                }
            }
        }
        // plane full
        return -1;
    }






    // override the method toString
    public String toString(){
        return '\n' +
                "-------------" + '\n' +
                "* Flight #" + flightNumber + " *" + '\n' +
                "-------------" + '\n' +
                "• From: "+startLocation+"\n" +
                "• To: "+endLocation+"\n" +
                "• Distance: "+distance+"\n" +
                "• How many first class passengers are booked on: "+totalFirstClassPassengers+"\n" +
                "• How many economy passengers: "+totalEconomicClassPassengers+"\n" +///Calculate the total number of economic class passengers.
                "• How many seats are unallocated: "+ (totalNumberOfSeats - totalFirstClassPassengers - totalEconomicClassPassengers)+"\n" +///Calculate the total number of unallocated seats in the plane.
                "• The name of each crew member: " +crew.toString().replace("[","").replace("]","") + "\n" +
                "• Information about the aircraft: "+ "\n"+
                getCraft().toString();
    }

}
