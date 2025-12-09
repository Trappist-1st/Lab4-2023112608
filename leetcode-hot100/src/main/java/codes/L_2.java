package codes;
//两数相加
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//解题思路：
//1.创建一个虚拟头节点dummyHead，用于简化结果链表的操作。
//2.使用一个指针current指向当前处理的节点，初始时指向dummyHead。
//3.使用一个变量carry来存储进位，初始值为0。
//4.遍历两个链表l1和l2，直到两个链表都遍历完且没有进位为止。在每次迭代中，执行以下操作
public class L_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;//进位

        while(l1 != null || l2 != null || carry != 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;//返回了一个新链表的（实际的）头节点
    }
    public static void main(String[] args){
        //测试用例
        L_2 l_2 = new L_2();

        // 测试用例1: 342 + 465 = 807
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = l_2.addTwoNumbers(l1, l2);

        // 打印结果: 7 → 0 → 8
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // 输出: 7 0 8 (表示807)
    }
}
