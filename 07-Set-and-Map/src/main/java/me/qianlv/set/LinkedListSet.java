package me.qianlv.set;

import me.qianlv.LinkedList2;
import me.qianlv.util.FileOperation;

import java.util.ArrayList;

/**
 * @author xiaoshu
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList2<E> list;

    public LinkedListSet() {
        this.list = new LinkedList2<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("A Table of Two Cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words: " + words.size());
            LinkedListSet<String> set = new LinkedListSet<>();
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
    }
}
