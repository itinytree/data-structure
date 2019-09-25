package me.qianlv.set;

import me.qianlv.util.FileOperation;

import java.util.ArrayList;

/**
 * @author xiaoshu
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("A Table of Two Cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
                System.out.println("Total different words: " + set.getSize());
            }
        }
    }
}
