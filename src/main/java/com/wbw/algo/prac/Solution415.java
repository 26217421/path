package com.wbw.algo.prac;

import com.wbw.algo.stucture.TreeNode;

import java.util.ArrayList;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 20:32
 */
public class Solution415 {
    public int maxNum = Integer.MIN_VALUE;
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs1(root);
        return ans;
    }

    public int dfs1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs1(root.left);
        int right = dfs1(root.right);
        ans += Math.abs(left - right);
        return right + left +root.val;
    }

    public int sumNumbers(TreeNode root) {
        return dfs2(root, 0);
    }
    public int dfs2(TreeNode root, int ans) {
        if(root == null) {
            return 0;
        }
        ans = ans*10 + root.val;
        if(root.left == null && root.right == null) {
            return ans;
        } else {
            return dfs2(root.left, ans) + dfs2(root.right, ans);
        }

    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs3(root, 0);
    }

    public int dfs3(TreeNode root, int ans) {
        if(root == null) {
            return 0;
        }
        ans = ans*2 + root.val;
        if(root.left == null && root.right == null) {
            return ans;
        } else {
            return dfs3(root.left, ans) + dfs3(root.right, ans);
        }
    }


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxNum;
    }

    private int dfs(TreeNode root) {
        if(root != null) {
            int l = Math.max(0, dfs(root.left));
            int r= Math.max(0, dfs(root.right));
            maxNum = Math.max(maxNum, l + r + root.val);
            return root.val + Math.max(l,r);
        }
        return 0;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, sum);
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        return ret;
    }

    private int rootSum(TreeNode root, int sum) {
        int ret = 0;
        if(root != null) {
            if(root.val == sum) {
                ret++;
            }
            ret += rootSum(root.left, sum - root.val);
            ret += rootSum(root.right, sum - root.val);
        }
        return ret;
    }


    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(root, new ArrayList<>(), res, expectNumber);
        return res;
    }

    private void backtrack(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, int target) {
        if(root == null) {
            return;
        }
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == target) {
                res.add((ArrayList<Integer>) path.clone());
            }
            return;
        }
        backtrack(root.left, path, res, target - root.val);
        backtrack(root.right, path, res, target - root.val);
        path.remove(path.size() - 1);
    }

}
