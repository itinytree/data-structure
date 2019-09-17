package me.qianlv.linked.list.leetcode;

/**
 * @author itinytree
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }

        if (null == head) {
            return null;
        }

        ListNode pre = head;
        while (null != pre.next) {
            if (val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode res = new Solution2().removeElements(listNode, 6);
        System.out.println(res);
    }
}
