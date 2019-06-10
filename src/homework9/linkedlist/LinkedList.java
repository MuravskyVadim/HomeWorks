package homework9.linkedlist;

public class LinkedList<T> implements List<T> {
    private Node<T> node;
    private int size;
    private Node<T> prev;
    private Node<T> first;
    private Node<T> last;

    private class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T element;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            node = first = last = new Node(null, value, null);
        } else {
            prev = node;
            node = new Node(prev, value, null);
            prev.setNext(node);
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index > -1 && index <= size) {
            if (index == size) {
                add(value);
            } else {
                Node<T> necessaryNode = getNodeByIndex(index);
                node = new Node<>(necessaryNode.getPrev(), value, necessaryNode);
                necessaryNode.setPrev(node);
                getNodeByIndex(index - 1).setNext(node);
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
