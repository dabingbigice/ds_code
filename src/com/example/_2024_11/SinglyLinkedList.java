package com.example._2024_11;

import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import java.util.function.Consumer;

//不带 头节点
public class SinglyLinkedList {
    Node head;


    private static class Node {
        int value;
        Node nextNode;

        public Node() {
        }

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    /**
     * 添加头节点
     *
     * @param value
     */
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    /***
     *
     * 遍历链表
     */
    public void loop(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.nextNode;
        }
    }

    public void loop1(Consumer<Integer> consumer) {
        for (Node i = head; i != null; i = i.nextNode) {
            consumer.accept(i.value);
        }
    }

    public static void loop2(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        node = node.nextNode;
        loop2(node);
    }

    private Node getLastNode() {
        if (head == null) return null;

        Node p = head;
        while (p.nextNode != null) {
            //不等于Null才能返回。
            p = p.nextNode;
            //等于null了应该返回当前节点
        }
        return p;
    }

    public void addLastNode(int value) {
        Node lastNode = getLastNode();
        if (lastNode == null) {
            addFirst(value);
            return;
        }
        Node node = new Node(value, null);
        lastNode.nextNode = node;
    }

    /**
     * 查找指定索引的值
     *
     * @param index
     * @return
     */
    public Node findNodeByIndex(int index) {

        Node p = head;
        int i = 0;
        while (p != null) {
            if (index == i) {
                System.out.println("index:" + index + ",i=" + i);
                return p;
            }
            i++;
            p = p.nextNode;
        }
        return null;
    }

    public int get(int index) throws Exception {
        Node nodeByIndex = findNodeByIndex(index);
        if (nodeByIndex == null) {
            throw new Exception("未找到索引");
        }
        return nodeByIndex.value;
    }

    public void insert(int index, int value) throws Exception {
        //index=0相当于头点插入
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNodeByIndex(index - 1);
        if (prev == null) {
            throw new Exception(String.format("未找到指定索引[%d]", index));
        }
        //插入,将当前节点挂在新的节点上，然后把新的节点挂在前一个节点下
        prev.nextNode = new Node(value, prev.nextNode);
    }

    public void removeFirst() throws Exception {
        if (head == null) {
            throw new Exception("head为空");
        }
        head = head.nextNode;
    }

    public void remove(int index) throws Exception {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNodeByIndex(index - 1);
        if (prev == null) {
            //防止kong null
            throw new Exception("指定索引不存在");
        }
        //当前索引为null时不进行赋值，直接跳出。若当前查找索引不为null则进行删除
        if (prev.nextNode != null) {
            prev.nextNode = prev.nextNode.nextNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList bean = new SinglyLinkedList();
        bean.addFirst(1);
        bean.addFirst(2);
        bean.addFirst(3);
        bean.addFirst(4);
        bean.loop(value -> {
            System.out.println(value);
        });
        bean.loop1(value -> {
            System.out.println(value);
        });
        System.out.println("--------------");
        bean.addLastNode(12);
        bean.loop(value -> {
            System.out.println(value);
        });

    }

    @Test
    public void test() {
        SinglyLinkedList bean = new SinglyLinkedList();
        bean.addLastNode(1);
        bean.addLastNode(2);
        bean.addLastNode(3);
        bean.addLastNode(4);
        try {
            int i = bean.get(3);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void insertTest() {

        SinglyLinkedList bean = new SinglyLinkedList();
        bean.addLastNode(1);
        bean.addLastNode(2);
        bean.addLastNode(3);
        bean.addLastNode(4);

        bean.loop2(bean.head);
    }

    @Test
    public void removeTest() {

        SinglyLinkedList bean = new SinglyLinkedList();
        bean.addLastNode(1);
        bean.addLastNode(2);
        bean.addLastNode(3);
        bean.addLastNode(4);
        try {
            bean.remove(0);
            bean.remove(2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        bean.loop(value -> {
            System.out.println(value);
        });
    }
}

/**
 * 总结：
 * 链表按指定索引查/删除找时需要注意索引的边界，尤其是0和last_index;
 */