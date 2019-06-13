package homework10.hashmap;

public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Ivanov");
        hashMap.put(2, "Petrov");
        hashMap.put(3, "Sidorov");
        hashMap.put(null, "Vostrikov");
        hashMap.put(5, "Mironov");
        hashMap.put(6, "Samofalov");
        hashMap.put(null, "Efimov");
        hashMap.put(8, "Volkov");
        hashMap.put(9, "Sidorov");
        hashMap.put(9, "Andreev");
        hashMap.put(10, "Klivcov");
        hashMap.put(11, "Antonov");
        hashMap.put(12, "Koval");
        hashMap.put(13, "Tihonov");
        System.out.println(hashMap.size());

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(6));
        System.out.println(hashMap.get(8));
        System.out.println(hashMap.get(9));
        System.out.println(hashMap.get(10));
        System.out.println(hashMap.get(11));
        System.out.println(hashMap.get(12));
        System.out.println(hashMap.get(13));
    }
}
