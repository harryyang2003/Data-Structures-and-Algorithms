package a动态数组;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer>{
    private int size = 0;   //逻辑大小
    private int capacity = 8;   //容量-初始值为8
//    private int[] array = new int[capacity];   //普通数组-初始就占8空间
    private int[] array = {};   //改进:初始为空,不占空间,当添加元素时再添加空间

    //1.尾部添加
    public void addLast(int element){
//        array[size] = element;
//        size++;
        add(size,element);
    }

    //2.指定位置添加-指定索引
    public void add(int index,int element) {
        if (size == 0){
            array = new int[capacity];
        } else if (size == capacity) {
            checkCapacity();
        }
        //容量检查 - 当数组放满,扩容1.5倍 -> 抽取到新方法


        //index不能插过头了,也不能小于0
        if (index >= 0 && index < size) {
//        使用循环将后半部分数据往后移动
//        for (int i = size; i > index; i--) {
//            array[i] = array[i-1];
//        }

            //调用方法,将后半部分数组往后移
            //含义-从array数组的index开始拷贝,拷贝到array数组的index+1到size-index结束
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
        }
        //将尾插法并入
        array[size] = element;
        size++;
    }

    private void checkCapacity() {
            capacity += capacity >> 1;    //右移一位

            //将短数组复制到长数组中
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

    }

    //3.根据索引获取值
    public int get(int index){
        return array[index];
    }

    //4.1-遍历方法1
    public void forEach(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    //4.2-遍历方法2-函数式接口
    public void forEach_self(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);  //将获取到的值返回给consumer
        }
    }

    //4.3-遍历方法3-迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;  //从0开始遍历
            @Override
            public boolean hasNext() {  //询问有没有下一个元素
                return i < size;    //i<size说明还有下一个
            }

            @Override
            public Integer next() { //返回当前元素,并移动到下一个元素
                return array[i++];
            }
        };
    }


    //4.4-遍历方法4-Stream流遍历
    public IntStream stream(){
        //如果直接传array进去,那么array后面没有赋值的空间也一起传进去了
        //所以对array进行拷贝,将有数据的空间拷贝进去即可
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

    //5-删除方法-返回值是被删的值
    public int remove(int index){
        int i = array[index];
        //验证index
        if (index < size-1){
            System.arraycopy(array,index+1,array,index,size-index-1);
        }
        size--;
        return i;
    }



}
