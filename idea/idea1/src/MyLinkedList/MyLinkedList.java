package MyLinkedList;

import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String>list=new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.addFirst("头头");
        list.addLast("尾尾");
        list.push("链表头");//在链表头添加
        System.out.println(list);
        String s= list.pop();//弹出链表头
        System.out.println(s);
        System.out.println(list.getFirst());//获取链表头
        String s1 = list.removeLast();
        System.out.println(s1);
    }
}
