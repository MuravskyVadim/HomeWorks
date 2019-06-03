package builder;

public class CarApplication {
    public static void main(String[] args) {
        Car car1 = new Car.Builder()
                .buildWithCarType("sedan")
                .buildWithModel("BMW")
                .buildWithEngineType("diesel")
                .buildWithWeight(1600)
                .buildWithHorsePower(315)
                .buildWithTorque(450).build();
        System.out.println(car1.toString());

        Car car2 = new Car.Builder()
                .buildWithModel("Mercedes")
                .buildWithEngineType("diesel")
                .buildWithWeight(1750)
                .buildWithHorsePower(365)
                .buildWithTorque(550).build();
        System.out.println(car2.toString());
    }
}
