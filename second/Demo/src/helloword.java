import java.util.Scanner;

public class helloword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node1 head=new Node1();
        Node1 p=head;
        while (!sc.hasNext("0")){
            String s=sc.next();
            Node1 q=new Node1();
            q.s=s;
            p.next=q;
            p=q;
        }
        /*p=head.next;
        while(p!=null){
            System.out.println(p.s);
            p=p.next;
        }*/
        Node1 t=head;
        p=t;
        while(p.next!=null&&p.next.next!=null){
            p=p.next;
            t.next=p.next;
            t=t.next;
            p.next=t.next;
            t.next=p;
            t=p;
        }
        p=head.next;
        while(p!=null){
            System.out.println(p.s);
            p=p.next;
        }
    }
}
class Node1{
    String s;
    Node1 next;
}