package com.wbw.algo.prac;

import java.util.ArrayList;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 20:32
 */
public class Solution {
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
