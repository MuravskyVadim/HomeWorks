package homework9.linkedlist;

public class LinkedList<T> implements List<T> {
    private Node<T> node = null;
    private int size;
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
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
        node = new Node(node, value, null);

        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
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
                node = last;
                size++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public void addAll(List<T> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
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

    @Override
    public T remove(int index) {
        if (index < size - 1 && index > 0) {
            Node<T> currentNode = getNodeByIndex(index);
            Node<T> prevNode = currentNode.getPrev();
            Node<T> nextNode = currentNode.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            currentNode.setPrev(null);
            currentNode.setNext(null);
            size--;
            return currentNode.getElement();
        } else if (index == 0) {
            Node<T> currentNode = getNodeByIndex(index);
            Node<T> nextNode = currentNode.getNext();

            nextNode.setPrev(null);
            first = nextNode;

            size--;
            return currentNode.getElement();
        } else if (index == size - 1) {
            Node<T> currentNode = getNodeByIndex(index);
            Node<T> prevNode = currentNode.getPrev();

            prevNode.setNext(null);
            last = prevNode;

            size--;
            return currentNode.getElement();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T remove(T t) {
        if (t != null) {
            for (int i = 0; i < size; i++) {
                if (t.equals(getNodeByIndex(i).getElement())) {
                    remove(i);
                    return t;
                }
            }
        }
        return null;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index > -1 && index < size) {
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
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
