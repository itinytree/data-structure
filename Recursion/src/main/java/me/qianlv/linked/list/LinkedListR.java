package me.qianlv.linked.list;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 使用递归的方式创建链表
 *
 * @author itinytree
 */
public class LinkedListR<E> {

    @AllArgsConstructor
    @Data
    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this(data, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        head = add(head, index, e);
        size++;
    }

    /**
     * 使用递归添加元素
     * 在以node为头节点的链表的index位置插入元素e,递归算法
     *
     * @param node
     * @param index
     * @param e
     * @return
     */
    private Node add(Node node, int index, E e) {
        if (0 == index) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表第index(0-based)个位置元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return get(head, index);
    }

    /**
     * 以node为头节点的链表中，找到第index个元素，递归算法
     *
     * @param node
     * @param index
     * @return
     */
    private E get(Node node, int index) {
        if (index == 0) {
            return node.data;
        }
        return get(node.next, index - 1);
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }

        set(head, index, e);
    }

    /**
     * 修改以node为头节点的链表中,第index(0-based)位置的元素为e,递归算法
     *
     * @param node
     * @param index
     * @param e
     */
    private void set(Node node, int index, E e) {
        if (0 == index) {
            node.data = e;
            return;
        }

        set(node.next, index - 1, e);
    }

    /**
     * 查找链表中时候有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(head, e);
    }

    /**
     * 在以node为头节点的链表中,查找时候存在元素e,递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }
        if (node.data == e) {
            return true;
        }

        return contains(node.next, e);
    }

    /**
     * 从链表中删除index(0-based)位置的元素,返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    /**
     * 从以node为头节点的链表中,删除第index位置的元素,递归算法
     * 返回值包含两个元素,删除后的链表头节点和删除的值
     *
     * @param node
     * @param index
     * @return
     */
    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.data);
        }

        Pair<Node, E> res = remove(node.next, index - 1);
        //将前节点与后节点建立关系
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    /**
     * 从以node为头节点的链表中,删除元素e,递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private Node removeElement(Node node, E e) {
        if (null == node) {
            return node;
        }
        if (node.data.equals(e)) {
            size--;
            return node.next;
        }

        node.next = removeElement(node.next, e);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListR<Integer> list = new LinkedListR<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }

        while (!list.isEmpty()) {
            System.out.println("removed " + list.removeLast());
        }
    }
}
