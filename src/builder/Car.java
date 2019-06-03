package builder;

public class Car {
    private String carType;
    private String model;
    private String engineType;
    private double weight;
    private double horsePower;
    private double torque;

    private Car(String carType, String model, String engineType, double weight, double horsePower, double torque) {
        this.carType = carType;
        this.model = model;
        this.engineType = engineType;
        this.weight = weight;
        this.horsePower = horsePower;
        this.torque = torque;
    }

    public static class Builder {
        private Car newCar;

        public Builder() {
            this.newCar = new Car("sedan", "Opel", "petrol", 1350, 105, 120);
        }

        public Builder buildWithCarType(String carType) {
            newCar.carType = carType;
            return this;
        }

        public Builder buildWithModel(String model) {
            newCar.model = model;
            return this;
        }

        public Builder buildWithEngineType(String engineType) {
            newCar.engineType = engineType;
            return this;
        }

        public Builder buildWithWeight(double weight) {
            newCar.weight = weight;
            return this;
        }

        public Builder buildWithHorsePower(double horsePower) {
            newCar.horsePower = horsePower;
            return this;
        }

        public Builder buildWithTorque(double torque) {
            newCar.torque = torque;
            return this;
        }

        public Car build() {
            return newCar;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", weight=" + weight +
                ", horsePower=" + horsePower +
                ", torque=" + torque +
                '}';
    }
}
