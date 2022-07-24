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
    public void traverseDLL(){
        if(head!=null){
            DoublyNode tempNode = head;
            for(int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tempNode=tempNode.next;
            }
            System.out.println();
        }
        else System.out.println("DLL does not exit");
    }
    public void reverseTraverse(){
        if(head!=null){
            DoublyNode tempNode = tail;
            for (int i = 0; i<size;i++){
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tempNode=tempNode.prev;
            }
            System.out.println();
        }
        else System.out.println("DLL not present");
    }
    public boolean searchDll(int value){
        DoublyNode tempNode = head;
        if(head!=null){
            for(int i=0;i<size;i++){
                if(tempNode.value==value){
                    System.out.println("Node present");
                    return true;
                }
                else tempNode=tempNode.next;
            }
        }

            System.out.println("Node not found");
            return false;

    }
    public void deleteDLL(int location){
        if(head==null){
            System.out.println("List is empty");
        }
        else if(location==0){
            if(size==1) {
                head = null;
                tail = null;
                size--;
            }
            else{
                head=head.next;
                head.prev=null;
                size--;
            }
        }
        else if(location>=size){
            DoublyNode tempNode=tail.prev;
            if(size==1) {
                head = null;
                tail = null;
                size--;
            }
            else {
                tempNode.next=null;
                tempNode=tail;
                size--;
            }
        }else{
            DoublyNode tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode=tempNode.next;
            }
            tempNode.next=tempNode.next.next;
            tempNode.next.prev=tempNode;
            size--;
        }
    }

    public void deleteEntireDLL(){
        DoublyNode tempNode=head;
        for(int i = 0;i<size;i++){
            tempNode.prev=null;
            tempNode=tempNode.next;
        }
        head=null;
        tail=null;
        System.out.println("Dll has been deleted");
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.createDLL(5);
        list.insertDLL(1, 1);
        list.insertDLL(5, 2);
        list.insertDLL(8, 3);
        list.insertDLL(4, 5);
        System.out.println(list.head.next.next.next.value);
        System.out.println(list.tail.value);
        list.traverseDLL();
//        list.reverseTraverse();
        list.searchDll(10);

        list.deleteDLL(3);
        list.traverseDLL();

    }
}
