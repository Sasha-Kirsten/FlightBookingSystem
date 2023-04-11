public abstract class Person {

    //Declaring variables
    private String name;

    private int passportNumber;

    //Creating the constructor function for the object
    Person(String name, int passportNumber){

        this.name = name;

        this.passportNumber = passportNumber;
    }

    //Made Getters and Setters for each variable in the constructor function.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    // declare a public abstract method
    public abstract double calculatePersonWeight();

}
