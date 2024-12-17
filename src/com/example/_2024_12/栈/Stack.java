package com.example._2024_12.栈;

public interface Stack<E> {
    boolean push(E value);
    E pop();
    E peek();
    boolean isEmpty();
    boolean isFull();

}
