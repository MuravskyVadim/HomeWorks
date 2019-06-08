package homework8.arraylist;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Is ArrayList Empty: " + arrayList.isEmpty());
        arrayList.add("one");
        arrayList.add("eighty eight");
        arrayList.add("nine");
        arrayList.add("seventeen");

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("eleven");
        stringArrayList.add("twenty two");
        stringArrayList.add("thirty three");

        arrayList.addAll(stringArrayList);

        arrayList.set("forty four", 2);

        System.out.println("Is ArrayList Empty: " + arrayList.isEmpty());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("==========");
        System.out.println(arrayList.remove("forty four"));
        System.out.println("==========");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("++++++++++++++++++++++++++");
        ArrayList<String> arrayList1 = new ArrayList<>();
        System.out.println(arrayList1.size());
        System.out.println(arrayList1.remove("one"));
    }
}
