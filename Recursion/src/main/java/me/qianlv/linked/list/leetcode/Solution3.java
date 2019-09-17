package me.qianlv.linked.list.leetcode;

/**
 * 使用虚拟头节点
 * <p>
 * 在处理链表的问题,使用虚拟头节点是一种常用的方法
 *
 * @author itinytree
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (null != pre.next) {
            if (val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode res = new Solution3().removeElements(listNode, 6);
        System.out.println(res);
    }
}
