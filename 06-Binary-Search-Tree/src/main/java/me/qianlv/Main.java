package me.qianlv;

import java.util.Random;

/**
 * @author itinytree
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 7, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /***
         *      5
         *   3     6
         * 2        8
         *         7
         */

        System.out.println(bst);

        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println();

        System.out.println("非递归-前序遍历");
        bst.preOrderNR();
        System.out.println();

        System.out.println("中序遍历");
        bst.inOrder();
        System.out.println();

        System.out.println("后序遍历");
        bst.postOrder();
        System.out.println();

        System.out.println("层序遍历");
        bst.levelOrder();
        System.out.println();

        removeTest();
    }

    public static void removeTest() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 10000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(n));
        }

        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < n; i++) {
            if (bst.contains(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.getSize());
            }
        }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.getSize());
    }

    /**
     * 打乱数组的顺序
     */

    private static void shuffle(Object[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }
}
