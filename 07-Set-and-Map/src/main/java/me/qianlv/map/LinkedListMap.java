package me.qianlv.map;

import me.qianlv.util.FileOperation;

import java.util.ArrayList;

/**
 * @author xiaoshu
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * 根据对应的key获取节点
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        //寻找删除节点的前一个节点
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return null != getNode(key);
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (null == node) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("A Table of Two Cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words: " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words:" + map.getSize());
            System.out.println("Release" + map.get("project"));
        }
    }
}
