package b链表.单向链表带哨兵;

import java.util.Iterator;
import java.util.function.Consumer;

//单向链表
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(666,null);  //头指针

    //迭代器遍历 - 2
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.Next;

            @Override
            public boolean hasNext() {  //询问是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() { //返回元素,并进行下一步操作
                int v = p.value;
                p = p.Next;
                return v;
            }
        };
    }


    //内部类,节点
    private static class Node {    //节点
        int value;  //值
        Node Next;  //下一个节点指针

        //初始化
        public Node(int value,Node next){
            this.value = value;
            this.Next = next;
        }
    }


    //循环遍历 - 1
    public void loop(Consumer<Integer> consumer){
        Node p = head.Next;
        while (p != null){
            consumer.accept(p.value);
            p = p.Next;
        }
    }

    //头插法
    public void addFirst(int value){
        addByIndex(0,value);
    }

    //尾插法
    public void addLast(int value){
        Node last = findLast();
        //创建新节点,指向空
        Node p = new Node(value,null);
        last.Next = p;
    }

    //找到最后一个节点
    private Node findLast(){
        Node p = new Node(1,head);
        //遍历链表,直到尾部
        while (p.Next != null){
            p = p.Next;
        }
        return p;
    }

    //根据索引查找节点
    private Node findNode(int index){
        int i = -1;
        for (Node p = head;p != null;p = p.Next,i++){
            if (i == index){
                return p;
            }
        }
        return null;
    }

    //根据索引获取值
    public int get(int index){
        Node p = findNode(index) ;
        if (p == null){
            throw  new IllegalArgumentException(
                    String.format("index [%d]",index + "无效"));
        }
        return p.value;
    }

    //链表任意位置加入节点
    public void addByIndex(int index,int value){
        if (index < 0){
            throw  new IllegalArgumentException(
                    String.format("index [%d]",index + "无效"));
        } else {
            Node p = findNode(index - 1);
            Node node = new Node(value,p.Next);
            p.Next = node;
        }
    }

    //删除头节点
    public void delFirst(){
        delByIndex(0);
    }

    //按索引删除节点
    public int delByIndex(int index){
        if (index < 0){
            throw  new IllegalArgumentException(
                    String.format("index [%d]",index + "无效"));
        }else {
            Node p = findNode(index - 1);
            Node delP = p.Next;
            p.Next = p.Next.Next;
            return delP.value;
        }
    }
}
