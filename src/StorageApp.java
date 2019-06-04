public class StorageApp {
    public static void main(String[] args) {
        Storage<Integer, String> storageIntStr = new Storage<>();

        storageIntStr.put(72, "Donald");
        storageIntStr.put(32, "Jack");
        storageIntStr.put(12, "Mike");
        storageIntStr.put(65, "Nick");
        storageIntStr.put(65, "Tom");

        System.out.println(storageIntStr.get(12));
        System.out.println(storageIntStr.get(32));
        System.out.println(storageIntStr.get(72));
        System.out.println(storageIntStr.get(65));
        System.out.println(storageIntStr.get(65));
        System.out.println("----------------------");

        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        System.out.println("box1 = " + box1);
        System.out.println("box2 = " + box2);
        System.out.println("box3 = " + box3);

        Storage<String, Box> storageStrBox = new Storage<>();

        storageStrBox.put("one", box1);
        storageStrBox.put("two", box2);
        storageStrBox.put("three", box3);

        System.out.println("----------------------");
        System.out.println("getBox1 = " + storageStrBox.get("one"));
        System.out.println("getBox2 = " + storageStrBox.get("two"));
        System.out.println("getBox3 = " + storageStrBox.get("three"));
    }
}
