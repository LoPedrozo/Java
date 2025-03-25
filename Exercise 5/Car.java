public class Car {
    public static void println(String p){
        System.out.println(p);
    }

    private String brand ;
    private String model;
    private int year;
    private String plate;
    private  float actualspeed;

    public Car(String brand, String model, int year, String plate, float actualspeed){

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.actualspeed = actualspeed;

    }
    public void accelerate(float addspeed) {
        if (addspeed > 0) {
            actualspeed += addspeed;
            println("Acceleration done successfully. New speed: " + actualspeed + " Km/h");
        } else {
            println("Invalid acceleration value. Enter a positive number.");
        }
    }


    public void brake(float stop) {
        if (stop > 0 && stop < actualspeed) {
            actualspeed -= stop;
            println("Brake applied successfully. New speed: " + actualspeed + " Km/h");
        } else if (stop >= actualspeed) {
            actualspeed = 0;
            println("The Vehicle stopped completely.");
        } else {
            println("Invalid brake value. Enter a positive number.");
        }
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getPlate() {
        return plate;
    }

    public float getActualspeed() {
        return actualspeed;
    }

    public void displayInfo() {
        println("Brand: " + brand);
        println("Model: " + model);
        println("Year: " + year);
        println("Plate: " + plate);
        println("Actual Speed: " + actualspeed + "Km/h");
        println("----------------------");
    }

}
