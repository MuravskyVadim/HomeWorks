public class StorageApp {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new Storage<>();

        storage.put(72, "Donald");
        storage.put(32, "Jack");
        storage.put(12, "Mike");
        storage.put(65, "Nick");
        storage.put(66, "Tom");

        System.out.println(storage.get(12));
        System.out.println(storage.get(32));
        System.out.println(storage.get(72));
        System.out.println(storage.get(65));
        System.out.println(storage.get(66));
    }
}
