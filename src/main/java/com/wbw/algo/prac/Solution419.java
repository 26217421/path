package com.wbw.algo.prac;

import com.wbw.algo.stucture.TreeNode;

/**
 * @author wbw
 * @date 2022-4-19 22:39
 */
public class Solution419 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        if (max <= root.val) {
            max = root.val;
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        } else {
            return dfs(root.left, max) + dfs(root.right, max);
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        TreeNode ans = new TreeNode(-1);
        ans.left = root;
        dfs1(ans);
        return ans.left;
    }

    private int dfs1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = dfs1(root.left);
        int r = dfs1(root.right);
        if(l == 0) root.left = null;
        if(r == 0) root.right = null;
        return l + r + root.val;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode ans = new TreeNode(-1);
        ans.left = root;
        dfs2(root, ans, true, target);
        return ans.left;
    }

    private void dfs2(TreeNode node, TreeNode parent, boolean isLeft, int target) {
        if(node == null) {
            return;
        }
        dfs2(node.left, node, true, target);
        dfs2(node.right, node, false, target);
        if(node.val == target &&
                node.left == null &&
                node.right ==null) {
            if(isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs3(0, preorder.length -1, preorder);
    }

    private TreeNode dfs3(int start, int end, int[] preorder) {
        if(start > end) {
            return null;
        }
        if(start == end) {
            return new TreeNode(preorder[start]);
        }
        TreeNode root = new TreeNode(preorder[start]);
        int mid = -1;
        for(int i = start + 1; i <= end; i++) {
            if(preorder[i] > preorder[start]) {
                mid = i;
                break;
            }
        }
        if(mid == -1) {
            root.left = dfs3(start + 1, end, preorder);
        } else {
            root.left = dfs3(start + 1, mid -1, preorder);
            root.right = dfs3(mid, end, preorder);
        }
        return root;
    }
}
