package me.qianlv.linked.list.leetcode;

import java.util.Objects;

/**
 * 使用递归删除链表中的指定值元素
 * 对Solution4的简化
 *
 * @author itinytree
 */
public class Solution5 {
    public ListNode removeElements(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return head;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode res = new Solution5().removeElements(listNode, 6);
        System.out.println(res);
    }
}
