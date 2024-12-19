package com.ds._2024_12.队列_优先级队列_阻塞队列;

public interface Queue<E> {
    /**
     * 从队尾插入
     * @param value
     * @return
     */
    boolean offer(E value);
    /**
     * 从队头获取元素，并移除
     * @return
     */
    E poll();

    /**
     * 从队头获取元素，不移除
     * @return
     */
    E peek();


    boolean isEmpty();

    /**
     * 是否满
     * @return
     */
    boolean isFull();
}
