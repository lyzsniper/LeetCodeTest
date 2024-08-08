package com.lyz.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyunze.lyz
 * @version SubtreeOfAnotherTree_572.java, v 0.1 2024年08月08日 09:21 liuyunze.lyz
 */
public class SubtreeOfAnotherTree_572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution1 {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return dfs(root, subRoot);
        }

        private boolean dfs(TreeNode r, TreeNode s) {
            if (r == null) {
                return false;
            }

            return check(r, s) || dfs(r.left, s) || dfs(r.right, s);
        }
        private boolean check(TreeNode r, TreeNode s) {
            if (r == null && s == null) {
                return true;
            }
            if (r == null || s == null || r.val != s.val) {
                return false;
            }
            return check(r.left, s.left) && check(r.right, s.right);
        }
    }



    class Solution2 {
        List<Integer> sOrder = new ArrayList<Integer>();
        List<Integer> tOrder = new ArrayList<Integer>();
        int maxElement, lNull, rNull;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            maxElement = Integer.MIN_VALUE;
            getMaxElement(s);
            getMaxElement(t);
            lNull = maxElement + 1;
            rNull = maxElement + 2;

            getDfsOrder(s, sOrder);
            getDfsOrder(t, tOrder);

            return kmp();
        }

        public void getMaxElement(TreeNode t) {
            if (t == null) {
                return;
            }
            maxElement = Math.max(maxElement, t.val);
            getMaxElement(t.left);
            getMaxElement(t.right);
        }

        public void getDfsOrder(TreeNode t, List<Integer> tar) {
            if (t == null) {
                return;
            }
            tar.add(t.val);
            if (t.left != null) {
                getDfsOrder(t.left, tar);
            } else {
                tar.add(lNull);
            }
            if (t.right != null) {
                getDfsOrder(t.right, tar);
            } else {
                tar.add(rNull);
            }
        }

        public boolean kmp() {
            int sLen = sOrder.size(), tLen = tOrder.size();
            int[] fail = new int[tOrder.size()];
            Arrays.fill(fail, -1);
            for (int i = 1, j = -1; i < tLen; ++i) {
                while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                fail[i] = j;
            }
            for (int i = 0, j = -1; i < sLen; ++i) {
                while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                if (j == tLen - 1) {
                    return true;
                }
            }
            return false;
        }
    }

}
