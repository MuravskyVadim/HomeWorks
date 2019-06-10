package homework9.linkedlist;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("The LinkedList is Empty? " + linkedList.isEmpty());
        linkedList.add(999);
        linkedList.add(777);
        linkedList.add(444);
        linkedList.add(555);
        linkedList.add(888);
        linkedList.add(100);
        linkedList.add(120);
        linkedList.add(130);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        System.out.println("============");
        System.out.println("The LinkedList is Empty? " + linkedList.isEmpty());

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);

        linkedList.addAll(linkedList1);

        linkedList.add(111, 2);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
