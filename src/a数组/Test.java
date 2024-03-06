package a数组;

public class Test {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.add(2,3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        System.out.println(dynamicArray.get(0)); //根据索引获取
        dynamicArray.forEach(); //遍历1
        dynamicArray.forEach_self((element)-> //遍历2
                System.out.println(element)
        );

        for (Integer element : dynamicArray){   //遍历3
            System.out.println(element);
        }

        System.out.println(dynamicArray.remove(1));

        dynamicArray.stream().forEach(element -> System.out.println(element));  //遍历4


        System.out.println(dynamicArray.get(6)); //根据索引获取




    }
}
