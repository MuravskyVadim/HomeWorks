package homework13;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class AnimalApp {

    public static void main(String[] args) throws IOException {
        Animal dog = new Animal("Dog");
        Animal cat = new Animal("Cat");
        Animal fish = new Animal("Fish");

        Animal[] animals = new Animal[]{dog, cat, fish};

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(b);
        objectOutputStream.writeInt(animals.length);

        for (Animal animal : animals) {
            objectOutputStream.writeObject(animal);
        }
        objectOutputStream.flush();
        objectOutputStream.close();

        byte[] animalBytes = b.toByteArray();

        Animal[] deserializeAnimals = deserializeAnimalArray(animalBytes);

        for (Animal a : deserializeAnimals) {
            System.out.println(a.getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            Animal[] animals = new Animal[ois.readInt()];
            for (int i = 0; i < animals.length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
