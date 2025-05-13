package basics.generics;


import java.util.List;

public class WildcardsGeneric {
    public static void main(String[] args) {
        WildCardExample wildCardExample = new WildCardExample();
        wildCardExample.addVehicle(List.of("Car", "Bike"));
        wildCardExample.addVehicle(List.of(1, 2, 3));
    }

}

class WildCardExample {

    // The method accepts a list of any type of vehicle
    public void addVehicle(List<?> vehicles) {
        for (Object vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }


}