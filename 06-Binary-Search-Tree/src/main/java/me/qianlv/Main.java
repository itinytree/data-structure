package me.qianlv;

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

        System.out.println(bst);

        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println();

        System.out.println("中序遍历");
        bst.inOrder();
        System.out.println();

        System.out.println("后序遍历");
        bst.postOrder();
        System.out.println();
    }
}
