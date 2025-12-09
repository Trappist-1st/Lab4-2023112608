package codes;

import java.util.ArrayList;
import java.util.List;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
public class L_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //唉我遍历完了检查数组是不是回文不就行了唉
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        int left = 0, right = list.size()-1;
        while(left < right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        L_234 l234 = new L_234();
        ListNode head = l234.new ListNode(1);
        head.next = l234.new ListNode(2);
        head.next.next = l234.new ListNode(2);
        head.next.next.next = l234.new ListNode(1);
        System.out.println(l234.isPalindrome(head));
    }
}
