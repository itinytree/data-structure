package me.qianlv;

/**
 * @param <E>
 * @author itinytree
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
