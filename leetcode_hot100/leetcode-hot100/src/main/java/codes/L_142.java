package codes;
//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
// 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//不允许修改 链表。
//数学原理：设链表头节点到入环节点的距离为a，入环节点到相遇点的距离为b，相遇点到入环节点的距离为c，环的周长为r。
//则有：2(a+b) = a+b+n*r => a = n*r - b = (n-1)r + (r - b) => a = (n-1)r + c
//即从头节点出发到入环节点的距离等
public class L_142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //二阶段：找到环的入口
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while(ptr1 != ptr2){
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        return null;
    }
    public static void main(String[] args){
        //测试用例

    }
}
