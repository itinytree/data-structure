package me.qianlv;

/**
 * 二叉堆 最大堆
 * <p>
 * 二叉堆是一种完全二叉树
 *
 * @param <E>
 * @author xiaoshu
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    /**
     * 返回堆中元素的个数
     *
     * @return
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * 判断堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }

        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * 查看堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public void siftDown(int index) {
        while (leftChild(index) < getSize()) {
            int max = leftChild(index);
            //找出左右子节点中最大的节点
            if (max + 1 < getSize() && data.get(max).compareTo(data.get(max + 1)) < 0) {
                max++;
            }

            if (data.get(max).compareTo(data.get(index)) >= 0) {
                break;
            }

            data.swap(index, max);
            index = max;
        }
    }


}
