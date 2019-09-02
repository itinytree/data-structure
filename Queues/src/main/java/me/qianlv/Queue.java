package me.qianlv;

/**
 * @param <E>
 * @author itinytree
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
