package b链表.单向链表;

import java.lang.module.FindException;
import java.util.Iterator;
import java.util.function.Consumer;

//单向链表
public class SinglyLinkedList implements Iterable<Integer>{
    private Node head;  //头指针

    //迭代器遍历 - 2
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

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
        Node p = head;
        while (p != null){
            consumer.accept(p.value);
            p = p.Next;
        }
    }

    //头插法
    public void addFirst(int value){
        //创建一个新节点,让head节点指向新节点,而新节点的下一个则指向head的下一个
        head = new Node(value,head);
    }

    //尾插法
    public void addLast(int value){
        Node last = findLast();
        if (last == null){
            addFirst(value);
            return;
        }
        //创建新节点,指向空
        Node p = new Node(value,null);
        last.Next = p;
    }

    //找到最后一个节点
    private Node findLast(){
        //如果链表为空,查询下一个节点时,可能会报空指针异常
        if (head == null){
            return null;
        }

        Node p = new Node(1,head);
        //遍历链表,直到尾部
        while (p.Next != null){
            p = p.Next;
        }
        return p;
    }

    //根据索引查找节点
    private Node findNode(int index){
        int i = 0;
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
        } else if (index == 0) {
            addFirst(value);
        }else {
            Node p = findNode(index - 1);
            Node node = new Node(value,p.Next);
            p.Next = node;
        }
    }

    //删除头节点
    public int delFirst(){
        if (head == null){
            throw  new IllegalArgumentException(
                    String.format("链表为空,无法删除"));
        }
        Node delP = head;
        Node p = head.Next;
        head = p;
        return delP.value;
    }

    //按索引删除节点
    public int delByIndex(int index){
        if (index < 0){
            throw  new IllegalArgumentException(
                    String.format("index [%d]",index + "无效"));
        } else if (index == 0) {
            return delFirst();
        }else {
            Node p = findNode(index - 1);
            Node delP = p.Next;
            p.Next = p.Next.Next;
            return delP.value;
        }
    }
}
