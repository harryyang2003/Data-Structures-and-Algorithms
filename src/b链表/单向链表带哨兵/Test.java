package b链表.单向链表带哨兵;

import b链表.单向链表带哨兵.SinglyLinkedListSentinel;

public class Test {

    public static void main(String[] args) {
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addLast(1);
        singlyLinkedListSentinel.addLast(2);
        singlyLinkedListSentinel.addLast(3);
        singlyLinkedListSentinel.addLast(4);

        singlyLinkedListSentinel.addLast(0);


        singlyLinkedListSentinel.addFirst(9);
        singlyLinkedListSentinel.addFirst(8);

        for (Integer i : singlyLinkedListSentinel){
            System.out.println(i);
        }



    }
}
