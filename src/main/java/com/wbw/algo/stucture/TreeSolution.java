package com.wbw.algo.stucture;

import org.junit.Test;

import java.util.*;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-12 18:55
 */
public class TreeSolution {

    public static void main(String[] args) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(null);
        System.out.println(serialize(null));
    }

    /**
     * Encodes a tree to a single string.
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node != null) {
                res.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            } else {
                res.append("null,");
            }
        }
        return res.deleteCharAt(res.length() - 1) + "]";
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if(data == null || "[]".equals(data)) {
            return null;
        }
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 0;
        TreeNode node;
        while (!q.isEmpty() && i < nodes.length - 2) {
            node = q.poll();
            String pl = nodes[i + 1];
            String pr = nodes[i + 2];
            i += 2;
            if (!"null".equals(pl)) {
                node.left = new TreeNode(Integer.parseInt(pl));
                q.offer(node.left);
            }
            if (!"null".equals(pr)) {
                node.right = new TreeNode(Integer.parseInt(pr));
                q.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 迭代前序遍历
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
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
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
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
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode flag = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right != null && node.right != flag) {
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
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        TreeNode node;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (node == null) {
                    break;
                }
                res.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;

    }

    /**
     * 求树的高度
     *
     * @param root 根节点
     * @return 层高
     */
    public int getLevel(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                node = q.poll();
                assert node != null;
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return 0;
    }

    public List<List<Integer>> pathSum(TreeNode root,int expectNumber) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, new ArrayList<>(), res, expectNumber);
        return res;
    }

    private void backtrack(TreeNode root, ArrayList<Integer> path, List<List<Integer>> res, int target) {
        if(root == null) {
            return;
        }
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == target) {
                res.add((ArrayList<Integer>) path.clone());
            }
        }
        backtrack(root.left, path, res, target - root.val);
        backtrack(root.right, path, res, target - root.val);
        path.remove(path.size() - 1);
    }
}
