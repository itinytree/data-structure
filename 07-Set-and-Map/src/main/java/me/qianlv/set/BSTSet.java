package me.qianlv.set;

import me.qianlv.BST;
import me.qianlv.util.FileOperation;

import java.util.ArrayList;

/**
 * @author xiaoshu
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("A Table of Two Cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
    }
}
