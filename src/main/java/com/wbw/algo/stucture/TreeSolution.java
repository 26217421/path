package com.wbw.algo.stucture;

import java.util.*;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-12 18:55
 */
public class TreeSolution<T> {
    /**
     * 迭代前序遍历
     * @param root 根节点
     * @return 遍历列表
     */
    public List<T> preorderTraversal(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }
        return res;
    }

    /**
     * 迭代中序遍历
     * @param root 根节点
     * @return 遍历列表
     */
    public List<T> inOrderTraversal(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                res.add(stack.peek().val);
                node = stack.pop().right;
            }
        }
        return res;
    }

    /**
     * 迭代后序遍历
     * @param root 根节点
     * @return 遍历列表
     */
    public List<T> postOrderTraversal(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> node = root;
        TreeNode<T> flag = null;
        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right != null && node.right != flag) {
                    node = node.right;
                } else {
                    stack.pop();
                    res.add(node.val);
                    flag = node;
                    node = null;
                }
            }
        }
        return res;
    }

    /**
     * 层次遍历
     * @param root 根节点
     * @return 遍历列表
     */
    public List<T> levelOrder (TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        TreeNode<T> node;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.peek();
                Optional.ofNullable(node).ifPresent(n -> {
                    res.add(n.val);
                    q.poll();
                    if(n.left!=null) {
                        q.offer(n.left);
                    }
                    if(n.right!=null) {
                        q.offer(n.right);
                    }
                });

            }
        }
        return res;

    }

    /**
     * 求树的高度
     * @param root 根节点
     * @return 层高
     */
    public int getLevel (TreeNode<T> root) {
        // write code here
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        TreeNode<T> node;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                node = q.peek();
                q.poll();
                assert node != null;
                if(node.left==null&&node.right==null) {
                    return depth;
                }
                if(node.left!=null) {
                    q.offer(node.left);
                }
                if(node.right!=null) {
                    q.offer(node.right);
                }
            }
        }
        return 0;

    }
}
