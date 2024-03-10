package b链表.单向链表;

import b链表.单向链表.SinglyLinkedList;

public class Test {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

//        singlyLinkedList.loop(i -> {
//            System.out.println(i);
//        });

//        for (Integer i : singlyLinkedList){
//            System.out.println(i);
//        }

//        singlyLinkedList.addLast(6);
//
//        for (Integer i : singlyLinkedList){
//            System.out.println(i);
//        }
//
//        //获取索引
//        System.out.println(singlyLinkedList.get(1));

//        //在索引0,1,3处添加元素->9 : 9 9 4 9 3 2 1
//        singlyLinkedList.addByIndex(0,9);
//        singlyLinkedList.addByIndex(1,9);
//        singlyLinkedList.addByIndex(3,9);
//
//
//
//        for (Integer i : singlyLinkedList){
//            System.out.println(i);
//        }
//
//        System.out.println(singlyLinkedList.delFirst());
//

        System.out.println(singlyLinkedList.delByIndex(1));

        for (Integer i : singlyLinkedList){
            System.out.println(i);
        }

    }
}
