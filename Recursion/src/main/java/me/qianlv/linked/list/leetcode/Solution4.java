package me.qianlv.linked.list.leetcode;

/**
 * 通过递归删除指定值的节点
 * 这种方式,个人觉得是你用了函数的调用栈方式删除,非常巧妙,若是链表非常大的情况下,可能会发生StackOverflowError
 *
 * @author itinytree
 */
public class Solution4 {
    public ListNode removeElements(ListNode node, int val) {
        if (null == node) {
            return node;
        }

        ListNode res = removeElements(node.next, val);
        if (node.val == val) {
            return res;
        } else {
            node.next = res;
            return node;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode res = new Solution4().removeElements(listNode, 6);
        System.out.println(res);
    }
}
