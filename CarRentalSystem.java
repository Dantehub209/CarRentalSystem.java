
import java.util.*;

class Car {
    int id;
    String model;
    boolean isRented;

    Car(int id, String model) {
        this.id = id;
        this.model = model;
        this.isRented = false;
    }

    @Override
    public String toString() {
        return id + ": " + model + (isRented ? " (Rented)" : " (Available)");
    }
}

public class CarRentalSystem {
    static List<Car> carList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adding some sample cars
        carList.add(new Car(1, "Toyota Corolla"));
        carList.add(new Car(2, "Honda Civic"));
        carList.add(new Car(3, "Ford Focus"));

        int choice;

        do {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewAvailableCars();
                case 2 -> rentCar();
                case 3 -> returnCar();
                case 4 -> System.out.println("Thank you for using Car Rental System.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void viewAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car car : carList) {
            if (!car.isRented) {
                System.out.println(car);
            }
        }
    }

    static void rentCar() {
        System.out.print("Enter Car ID to rent: ");
        int id = scanner.nextInt();
        for (Car car : carList) {
            if (car.id == id) {
                if (!car.isRented) {
                    car.isRented = true;
                    System.out.println("You have rented: " + car.model);
                } else {
                    System.out.println("Car is already rented.");
                }
                return;
            }
        }
        System.out.println("Car not found.");
    }

    static void returnCar() {
        System.out.print("Enter Car ID to return: ");
        int id = scanner.nextInt();
        for (Car car : carList) {
            if (car.id == id) {
                if (car.isRented) {
                    car.isRented = false;
                    System.out.println("You have returned: " + car.model);
                } else {
                    System.out.println("Car was not rented.");
                }
                return;
            }
        }
        System.out.println("Car not found.");
    }
}
