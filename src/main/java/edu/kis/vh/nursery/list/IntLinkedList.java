package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static final int empty = -1;
    private Node last;
    // sa one uzywane poprzez gettery bezposrednio w publicznych metodach klasy

    public static int getEmpty() {
        return empty;
    }

    public void push(int i) {
        if (getLast() == null)
            setLast(new Node(i));
        else {
            getLast().setNext(new Node(i));
            getLast().getNext().setPrev(getLast());
            setLast(getLast().getNext());
        }
    }

    public boolean isEmpty() {
        return getLast() == null;
    }

    public boolean isFull() {

        return false;
    }

    public int top() {
        if (isEmpty())
            return getEmpty();
        return getLast().getValue();
    }

    public int pop() {
        if (isEmpty())
            return getEmpty();
        int ret = getLast().getValue();
        setLast(getLast().getPrev());
        return ret;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }



    private class Node {

        private int value;
        private Node prev;
        private  Node next;

        Node(int i) {
            setValue(i);
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }

        Node getPrev() {
            return prev;
        }

        void setPrev(Node prev) {
            this.prev = prev;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

}
