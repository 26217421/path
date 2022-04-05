package com.wbw.prac;

import java.util.*;


/**
 * @author wbw
 */
public class Solution {
    /**
     *
     * @param root TreeNode类 
     * @return int整型
     */
    public int run (TreeNode root) {
        // write code here
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode node;
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