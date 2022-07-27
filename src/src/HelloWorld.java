import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(new CarModel("Audi", "A1", 270));
        carModels.add(new CarModel("Audi", "A2", 280));
        carModels.add(new CarModel("Audi", "A3", 290));
        carModels.add(new CarModel("Audi", "A5", 300));
        carModels.add(new CarModel("Audi", "A8", 310));
        carModels.add(new CarModel("Alfa Romeo", "AA", 300));
        carModels.add(new CarModel("Alfa Romeo", "BB", 310));
        carModels.add(new CarModel("Alfa Romeo", "CC", 300));
        carModels.add(new CarModel("Ferrari", "Roja", 450));
        carModels.add(new CarModel("Ford", "Mustang", 330));
        carModels = carModels.stream().sorted(Comparator.comparing(CarModel::getBrand)).collect(Collectors.toList());

        try {
            PrintWriter printWriter = new PrintWriter(new File("cars.txt"));
            carModels.forEach(printWriter::println);
            printWriter.close();
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
}

class CarModel {
    private String brand;
    private String name;
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public CarModel(String brand, String name, int maxSpeed) {
        this.brand = brand;
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "El model " + name + " de la marca " + brand + " tiene una velocidad máxima de " + maxSpeed;
    }
}
