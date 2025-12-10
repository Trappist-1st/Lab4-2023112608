package codes;
//相交链表
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//解题思路：双指针法
//创建两个指针，分别指向两个链表的头节点，然后同时向前移动指针。当一个指针到达链表末尾时，将其重定向到另一个链表的头节点。这样，当两个指针相遇时，就是相交节点；如果没有相交节点，最终会同时到达 null。
//时间复杂度：O(N+M)，其中 N 和 M 分别是两个链表的长度。空间复杂度：O(1)。
public class L_160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        // 两个指针同时遍历，当走到末尾时切换到另一个链表的头部
        while(pA != pB){
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;// 要么返回相交节点，要么返回null（不相交）
    }
    public static void main(String[] args){
        L_160 l160 = new L_160();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);
        headA.next.next = intersection;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode result = l160.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersected at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
