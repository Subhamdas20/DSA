package com.subham.singlelinkedlist;

public class SingleLinkedList {
    Node head;
    Node tail;
    private int size;

    public Node createSinglyLinkedlist(int nodeValue) {

        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
        return head;

    }

    public void insertNode(int nodevalue, int location) {
        Node node = new Node();
        node.value = nodevalue;
        if (head == null) {
            createSinglyLinkedlist(nodevalue);
        } else if (location == 0) {
            node.next = head;
            node.value = nodevalue;
            head = node;
            size++;
        } else if (location >= size) {
            node.next = null;

            tail.next = node;
            tail = node;
            size++;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
            size++;
        }


    }

    public void traverseSinglyLinkedList() {
        Node tempNode = head;

        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value + "->");
            tempNode = tempNode.next;
        }

    }

    public void searchNode(int nodeValue) {
        Node tempNode = head;
        int nodeFound = 0;
        System.out.println(size + " size");
        if (head == null) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node present at location " + i);
                    nodeFound++;
                }
                tempNode = tempNode.next;
            }
            if (nodeFound == 0) {
                System.out.println("Node not present");
            }
        }
    }
    public void deleteNode(int value){
        if(value==0){
            head=head.next;
        }
        else{
            Node tempNode=head;
            int index=0;
            while(index<value-1){
                tempNode=tempNode.next;
                index++;
            }
//            tempNode.next=tempNode.next.next;
            tempNode.next=tempNode.next.next;
        }

    }
    public void deleteSSL(){
        head=null;
        tail=null;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println(list.createSinglyLinkedlist(4).value);
        list.insertNode(5, 1);
        list.insertNode(6, 2);
        list.insertNode(8, 3);
        list.insertNode(9, 4);
        list.insertNode(10, 6);
//        System.out.println(list.head.value);
//        System.out.println(list.head.next.value);
        list.traverseSinglyLinkedList();
        list.deleteNode(2);
        list.deleteSSL();
        list.traverseSinglyLinkedList();
//        System.out.println(list.head.value);
//        list.traverseSinglyLinkedList();
//        list.searchNode(6);
    }

}
