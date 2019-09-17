package me.qianlv.linked.list.leetcode;

/**
 * @author itinytree
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 链表节点的构造函数
     * 使用arr为参数,创建一个链表,当前的ListNode为链表头节点
     */
    public ListNode(int[] arr) {
        if (null == arr || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (null != cur) {
            s.append(cur.val + "->");
            cur = cur.next;
        }

        s.append("NULL");
        return s.toString();
    }
}
