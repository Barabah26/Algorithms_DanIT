package org.example.lesson4;
public class LinkList {
    private Node head;
    private int size;
    private static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(5);

        list.add(0, 34);
        list.remove(4);

        System.out.println(list);

    }

    public void addFirst(int value){
        Node newNode = new Node(value, head);
        head = newNode;
        size++;
    }

    public void addLast(int value){
        Node newNode = new Node(value, null);
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void add(int index, int value){
        if (size < index || index < 0){
            throw new IndexOutOfBoundsException("Index %d is absent ".formatted(index));
        }
        if (index == 0){
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index %d is absent ".formatted(index));
            }
            current = current.next;
        }

        current.next = new Node(value, current.next);
        size++;

        }

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder result = new StringBuilder("");
        while (temp != null){
            result.append(temp.value);
            if (temp.next != null){
                result.append("->");
            }
            temp = temp.next;
        }

        return String.valueOf(result);
    }

    public void remove(int index){
        if (size <= index || index < 0){
            throw new IndexOutOfBoundsException("Index %d is absent ".formatted(index));
        }
        if (index == 0){
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;

    }

    public int get(int index){
        if (size <= index || index < 0){
            throw new IndexOutOfBoundsException("Index %d is absent ".formatted(index));
        }
        int count = 0;
        Node current = head;


        for (; index != count; current = current.next, count++){
        }

        return current.value;

    }

}
