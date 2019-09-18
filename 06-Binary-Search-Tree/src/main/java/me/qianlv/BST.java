package me.qianlv;

import java.util.Objects;

/**
 * 二叉查找树的定义
 *
 * @param <E>
 * @author itinytree
 */
public class BST<E extends Comparable<E>> {
    /**
     * 定义二叉查找树的根节点
     */
    private Node root;
    /**
     * 定义二叉查找树的元素个数
     */
    private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 向二叉树中添加元素
     *
     * @param e
     */
    public void add(E e) {
        if (Objects.isNull(root)) {
            root = new Node(e);
            size++;
            return;
        }

        add(root, e);
    }

    public void addR(E e) {
        addR(root, e);
    }

    /**
     * 向二叉查找树中添加元素
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        }
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * 采用递归的方式向二叉查找树中添加元素
     * 返回插入新节点后的二叉搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node addR(Node node, E e) {
        if (null == node) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addR(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addR(node.right, e);
        }
        return node;
    }

    /**
     * 二叉查找树中是否包含指定值的元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以 node 为根的二叉查找树中搜索是否包含元素 e,递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历 根 左 右
     * <p>
     * 遍历以 node 为根的二叉查找树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (null == node) {
            res.append(generateDepthString(depth) + "\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
