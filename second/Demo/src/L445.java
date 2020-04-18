import java.util.List;
import java.util.Stack;

public class L445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode t = l1;
        ListNode ans = null;
        while (t != null) {
            s1.push(t.val);
            t = t.next;
        }
        t = l2;
        while (t != null) {
            s1.push(t.val);
            t = t.next;
        }

        int t1 = s1.pop();
        int t2 = s2.pop();
        int temp = t1 + t2;
        int jw = temp / 10;
        ans = new ListNode(temp % 10);
        while (!s1.empty() && !s2.empty()) {
            t1 = s1.pop();
            t2 = s2.pop();
            temp = t1 + t2 + jw;
            jw = temp / 10;
            ListNode listNode = new ListNode(temp % 10);
            listNode.next = ans;
            ans = listNode;
        }
        while (!s1.empty()) {
            t1 = s1.pop();
            temp = t1 + jw;
            jw = temp / 10;
            ListNode listNode = new ListNode(temp % 10);
            listNode.next = ans;
            ans = listNode;
        }
        while (!s2.empty()) {
            t2 = s2.pop();
            temp = t2 + jw;
            jw = temp / 10;
            ListNode listNode = new ListNode(temp % 10);
            listNode.next = ans;
            ans = listNode;
        }
        if (jw != 0) {
            ListNode listNode = new ListNode(jw);
            listNode.next = ans;
            ans = listNode;
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

