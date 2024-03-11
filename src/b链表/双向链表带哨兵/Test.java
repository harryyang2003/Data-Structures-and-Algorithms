package b链表.双向链表带哨兵;

import b链表.单向链表带哨兵.SinglyLinkedListSentinel;

public class Test {

    public static void main(String[] args) {
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);

        doublyLinkedListSentinel.forEach(value ->{
            System.out.println(value);
        });

        System.out.println("----------------------------------");

        doublyLinkedListSentinel.Insert(0,0);
        doublyLinkedListSentinel.Insert(4,4);
        doublyLinkedListSentinel.forEach(value ->{
            System.out.println(value);
        });

        System.out.println("----------------------------------");

        doublyLinkedListSentinel.remove(0);
        doublyLinkedListSentinel.remove(1);
        doublyLinkedListSentinel.forEach(value ->{
            System.out.println(value);
        });

        System.out.println("----------------------------------");

        doublyLinkedListSentinel.removeLast();
        doublyLinkedListSentinel.removeLast();
        doublyLinkedListSentinel.forEach(value ->{
            System.out.println(value);
        });

    }
}
