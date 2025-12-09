package codes;
//反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//解题思路：使用三个指针prev，curr，nextTemp
//1.初始化prev为null，curr为head
//2.遍历链表，直到curr为null
//  1）保存curr的下一个节点到nextTemp
//  2）将curr的next指针指向prev，实现反转
//  3）将prev前移到curr
//  4）将curr前移到nextTemp
//3.返回prev作为新的头节点
public class L_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextTemp = curr.next; //保存下一个节点
            curr.next = prev;  //反转指针
            prev = curr; //前移prev
            curr =nextTemp; //前移curr
        }

        return prev;
    }
    public static void main(String[] args){

    }
}
