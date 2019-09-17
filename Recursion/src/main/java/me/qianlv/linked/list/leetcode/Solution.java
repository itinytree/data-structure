package me.qianlv.linked.list.leetcode;

import java.util.Objects;

/**
 * @author itinytree
 * Leetcode 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //1. 若是head头节点等于要删除的值,则一直删除
        while (!Objects.isNull(head) && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        //2. 若是head头节点为空,则直接返回
        if (Objects.isNull(head)) {
            return null;
        }

        //3. 单链表中其他节点
        ListNode pre = head;
        while (null != pre.next) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
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

        ListNode res = new Solution().removeElements(listNode, 6);
        System.out.println(res);
    }
}
