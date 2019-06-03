package car;

import java.io.Serializable;

public class Engine implements Serializable {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "car.Engine{" +
                "type='" + type + '\'' +
                '}';
    }
}
