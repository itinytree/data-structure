package me.qianlv;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 链表
 *
 * @author itinytree
 */
public class LinkedList<E> {

    @Data
    @AllArgsConstructor
    private class Node {
        private E data;
        private Node next;

        private Node(E data) {
            this(data, null);
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node newNode = new Node(e);
//        newNode.next = head;
//        head = newNode;

        head = new Node(e, head);
        size++;
    }


    /**
     * 在链表的 index（0-size)位置添加新的元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = new Node(e, pre.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }
}
