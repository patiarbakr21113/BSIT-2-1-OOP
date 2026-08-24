public class Vehicle {

    // Fields shared by ALL vehicles.
    protected String brand;
    protected int year;

    // Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Behavior shared by all vehicles
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " (" + year + ")");
    }
}