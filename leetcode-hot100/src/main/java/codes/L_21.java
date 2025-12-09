package codes;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//解题思路：递归
//1.如果list1为空，返回list2
//2.如果list2为空，返回list1
//3.如果list1的值小于list2的值，list1的next指向mergeTwoLists(list1.next, list2)
//4.否则，list2的next指向mergeTwoLists(list1, list2.next)
public class L_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {//太优雅了
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static void main(String[] args){
        //测试用例
        L_21 l21 = new L_21();
        ListNode list1 = l21.new ListNode(1, l21.new ListNode(2, l21.new ListNode(4)));
        ListNode list2 = l21.new ListNode(1, l21.new ListNode(3, l21.new ListNode(4)));
        ListNode list3 = l21.mergeTwoLists(list1, list2);
        while(list3 != null){
            System.out.println(list3.val);
            list3 = list3.next;
        }
    }
}
