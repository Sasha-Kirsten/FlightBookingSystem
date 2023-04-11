public class CrewMember extends Person{

    // declare the constructor function but using the data from the super class (Person)
    CrewMember(String Name, int PassportNumber) {
        super(Name, PassportNumber);
    }

    // declare method to calculate the weight
    public double calculatePersonWeight() {
        return 75;
    }

    public String toString(){
        return getName();
    }
}
