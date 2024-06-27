import java.util.*;
import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {

   public Iterator<E> iterator() {
        return new SortedListIterator();
    }

    private class SortedListIterator implements Iterator<E> {
        private Node<E> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    public void insert(E data) {
        head = insertRecursive(head, data);
    }

    private Node<E> insertRecursive(Node<E> current, E data) {
        if (current == null || data.compareTo(current.data) < 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = current;
            return newNode;
        }
        current.next = insertRecursive(current.next, data);
        return current;
    }

    public void remove(E data) {
        head = removeRecursive(head, data);
    }

    private Node<E> removeRecursive(Node<E> current, E data) {
        if (current == null) {
            return null;
        }
        if (data.equals(current.data)) {
            return current.next;
        }
        current.next = removeRecursive(current.next, data);
        return current;
    }

    public E retrieve(int index) {
        return retrieveRecursive(head, index);
    }

    private E retrieveRecursive(Node<E> current, int index) {
        if (current == null || index < 0) {
            return null;
        }
        if (index == 0) {
            return current.data;
        }
        return retrieveRecursive(current.next, index - 1);
    }

    public boolean search(E data) {
        return searchRecursive(head, data);
    }

    private boolean searchRecursive(Node<E> current, E data) {
        if (current == null) {
            return false;
        }
        if (data.equals(current.data)) {
            return true;
        }
        return searchRecursive(current.next, data);
    }
}