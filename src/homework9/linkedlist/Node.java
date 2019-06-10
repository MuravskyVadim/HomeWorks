package homework9.linkedlist;

public class Node<T> {
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
