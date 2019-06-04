package car;

public class CarApp {
    public static void main(String[] args) {
        Car mercedes = new Car("Mercedes", "red", new Engine("petrol"));
        Car cloneMercedes = (Car) mercedes.deepClone();

        System.out.println(mercedes.toString());
        System.out.println(cloneMercedes.toString());

        mercedes.setColor("black");
        cloneMercedes.setEngine(new Engine("diesel"));

        System.out.println(mercedes.toString());
        System.out.println(cloneMercedes.toString());
    }
}
