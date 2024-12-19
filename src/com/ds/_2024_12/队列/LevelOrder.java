package com.ds._2024_12.队列;

import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍历，利用队列完成层序遍历。开始时将root放入，
 * 然后当队列不为空时，每次输出一个节点。并且判断这个节点的左右孩子是否可以放入
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        //将根节点放入
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;
        List<List<Integer>> bigList = new ArrayList();
        while (!queue.isEmpty()) {
            //队列不为空就输出一个元素
            int c2 = 0;//统计下层的节点数
            List smallList = new ArrayList();

            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n.val + "  ");
                smallList.add(n.val);
                //放入左右孩子
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }

                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;

                }
            }

            c1 = c2;
            bigList.add(smallList);
            System.out.println();
        }
        System.out.println(bigList);
    }
}
