import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Garage {

    private class Car {
        private int license;
        private int moveCount;

        Car(int license) {
            this.license = license;
            this.moveCount = 0;
        }

        int getLicense() {
            return license;
        }

        int getCount() {
            return moveCount;
        }

        void moved() {
            moveCount += 1;
        }
    }

    private ArrayList<Car> garage = new ArrayList<>();
    private ArrayList<Car> street = new ArrayList<>();
    private int garageCount = 0;
    private int streetCount = 0;

    private void processArrival(int lic) {
        System.out.println("Arrival: license=" + lic);
        int garageSize = 10;
        if (garageCount < garageSize) {
            garage.add(new Car(lic));
            garageCount += 1;
            System.out.println("...car excepted into the garage.");
        } else {
            System.out.println("...car rejected; no room in the garage.");
        }
    }

    private void showGarage() {
        System.out.print("garage=");
        for (int index = 0; index < garageCount; index += 1) {
            System.out.print(" " + garage.get(index).getLicense());
        }
        System.out.println();
    }

    private void processDeparture(int lic) {
        System.out.println("Departure: license=" + lic);
        showGarage();
        while (garageCount > 0 && garage.get(garageCount - 1).getLicense() != lic) {
            Car car = garage.remove(--garageCount);
            car.moved();
            street.add(car);
            streetCount += 1;
        }
        Car car = garage.remove(--garageCount);
        System.out.println("...removed the car; moveCount= " + car.getCount());
        while (streetCount > 0) {
            garage.add(street.remove(--streetCount));
            garageCount += 1;
        }
    }

    private void shutdown() {
        System.out.println("\nShutdown:");
        for(Car car : garage) { System.out.printf("Licence# %d,  Move Count: %d\n", car.license, car.moveCount); }

    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("garage.data"));

        while (input.hasNext()) {
            String action = input.next();
            int license = input.nextInt();
            char actionCode = action.charAt(0);
            switch (actionCode) {
                case'A':
                    processArrival(license);
                    break;
                case'D':
                    processDeparture(license);
                    break;
                case'Q':
                    shutdown();
                    break;
                default:
                    System.out.println("Bad actionCode of " + actionCode);
                    System.exit(9);
            }
        }
        System.out.println("garage.size()=" + garage.size() + " street.size()=" + street.size());
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Begin application.");
        Garage application = new Garage();
        application.run();
        System.out.println("End of application.");
    }
}
