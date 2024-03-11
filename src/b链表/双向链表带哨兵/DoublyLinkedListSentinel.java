package b链表.双向链表带哨兵;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node{
        Node prev;  //上一个节点的指针
        int value;
        Node next;  //下一个指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  //头部的哨兵
    private Node tail;  //尾部的哨兵

    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,888,null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p != tail ; p=p.next,i++) {
            if (i == index){
                return p;
            }
        }
        return null;
    }

    public void Insert(int index,int value){
        Node prev = findNode(index - 1);
        if (prev == null){
            illegalIndex(index);
        }
        Node next = prev.next;
        Node p = new Node(prev,value,next);
        prev.next = p;
        next.prev = p;
    }

    public void remove(int index){
        Node p = findNode(index);
        if (p==null)    illegalIndex(index);
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }

    public void removeLast(){
        if (tail.prev == head){
            throw  new IllegalArgumentException(
                    String.format("链表为空"));
        }
        Node p = tail.prev.prev;
        p.next = tail;
        tail.prev = p;
    }

    public void addLast(int value){
        Node p1 = tail.prev;
        Node add = new Node(tail.prev,value,tail);
        p1.next = add;
        tail.prev = add;
    }

    private static void illegalIndex(int index) {
        throw  new IllegalArgumentException(
                String.format("index [%d]", index + "无效"));
    }


}
