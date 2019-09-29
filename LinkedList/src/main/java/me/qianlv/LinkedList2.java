package me.qianlv;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 使用虚拟头节点
 *
 * @author itinytree
 */
public class LinkedList2<E> {

    @AllArgsConstructor
    @Data
    private class Node {
        private E data;
        private Node next;

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList2() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.data.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node del = prev.next;
            prev.next = del.next;
            del.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList2<Integer> list2 = new LinkedList2<>();
        for (int i = 0; i < 5; i++) {
            list2.addFirst(i);
            System.out.println(list2);
        }

        list2.add(2, 666);
        System.out.println(list2);

        list2.remove(2);
        System.out.println(list2);

        list2.removeFirst();
        System.out.println(list2);

        list2.removeLast();
        System.out.println(list2);
    }
}
