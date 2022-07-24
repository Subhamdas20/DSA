package com.subham.doubleinkedlist;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size = 0;

    public DoublyNode createDLL(int value) {
        head = new DoublyNode();
        DoublyNode node = new DoublyNode();
        node.value = value;
        node.prev = null;
        node.next = null;
        head = node;
        tail = node;
        size++;
        return head;
    }

    public void insertDLL(int value, int location) {
        DoublyNode node = new DoublyNode();
        node.value = value;
        if (head == null) {
            createDLL(value);
        } else if (location == 0) {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next = node;
            node.next.prev = node;
        }
        size++;

    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.createDLL(5);

        list.insertDLL(1, 1);
        list.insertDLL(5, 2);
        list.insertDLL(4, 5);
        System.out.println(list.head.next.next.next.value);
        System.out.println(list.tail.value);
    }
}
