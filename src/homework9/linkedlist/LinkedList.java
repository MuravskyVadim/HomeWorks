package homework9.linkedlist;

public class LinkedList<T> implements List<T> {
    private Node<T> node;
    private int size;
    private Node<T> prev;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            node = first = last = new Node(null, value, null);
        } else if (size == 1) {
            prev = node;
            node = new Node(prev, value, null);
            first.setNext(node);
            last = node;
        } else {
            prev = node;
            node = new Node(prev, value, null);
            prev.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index > -1 && index <= size) {
            if (index == size) {
                this.add(value);
            } else {
                Node<T> necessaryNode = getNodeByIndex(index);
                prev = necessaryNode.getPrev();
                node = new Node<>(prev, value, necessaryNode);
                necessaryNode.setPrev(node);
                Node<T> prevNode = getNodeByIndex(index - 1);
                prevNode.setNext(node);
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index > -1 && index < size) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getElement();

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void set(T value, int index) {
        if (index > -1 && index < size) {
            getNodeByIndex(index).setElement(value);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < (size >> 1)) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        } else {
            Node<T> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }
            return node;
        }
    }
}
