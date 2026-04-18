/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 1->2->3->null
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }
}
/*
三个指针分别干什么

这是最关键的。

cur

当前正在处理的节点

你可以把它理解成：

“我现在手里抓着哪个节点，就准备改哪个节点的箭头”

prev

已经反转好的那一部分链表的头

你可以理解成：

“已经处理完的那一串反向链表，现在最前面是谁”

一开始还没反转任何节点，所以：

prev = null

这非常合理，因为反转后第一个节点应该指向 null

next

临时保存 cur 原来的下一个节点

因为一旦你写：

cur.next = prev;

原来往后的箭头就断了。
所以必须先把后面的节点存起来：

ListNode next = cur.next;
*/