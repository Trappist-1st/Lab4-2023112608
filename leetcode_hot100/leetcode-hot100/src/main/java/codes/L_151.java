package codes;
//给你一个链表的头节点 head ，判断链表中是否有环。
//
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
// 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

//如果链表中存在环 ，则返回 true 。 否则，返回 false 。

//解题思路：使用快慢指针
//1.创建快慢指针slow和fast，初始时都指向头节点
//2.慢指针每次移动一步，快指针每次移动两步
//3.如果快指针到达链表末尾，说明没有环
//4.如果快指针追上慢指针，说明有环
public class L_151 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //还是这样写直观
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;  // 快指针也从head开始

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;  // 相遇说明有环
            }
        }
        return false;  // 快指针到达末尾说明无环
    }
    public static void main(String[] args){
        //测试用例1
        L_151 l151 = new L_151();
        ListNode head = l151.new ListNode(1);
        head.next = l151.new ListNode(2);
        head.next.next = l151.new ListNode(3);
        head.next.next.next = head.next;
        System.out.println(l151.hasCycle(head));
    }
}
