/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Assignment

// 111. Minimum Depth of Binary Tree
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null & root.right == null) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            res = Math.min(res, minDepth(root.left));
        }
        if (root.right != null) {
            res = Math.min(res, minDepth(root.right));
        }
        return res + 1;

    }
}

// 222. Count Complete Tree Nodes
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int res = 0;
        res++;
        if (root.left != null) {
            res += countNodes(root.left);
        }
        if (root.right != null) {
            res += countNodes(root.right);
        }
        return res;
    }
}

// Given the root of a binary tree, collect a tree's nodes as if you were doing
// this:
// Collect all the leaf nodes.
// Remove all the leaf nodes.
// Repeat until the tree is empty.

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public int dfs(TreeNode u) {
        if (u == null) {
            return -1;
        }
        int leftLevel = dfs(u.left);
        int rightLevel = dfs(u.right);
        int currentLevel = Math.max(leftLevel, rightLevel)
                + 1;
        while (ans.size() <= currentLevel) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(currentLevel).add(u.val);
        return currentLevel;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
}

// 515. Find Largest Value in Each Tree Row
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = que.poll();
                maxValue = Math.max(curNode.val, maxValue);

                if (curNode.left != null) {
                    que.offer(curNode.left);
                }
                if (curNode.right != null) {
                    que.offer(curNode.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}

// 872. Leaf-Similar Trees
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
        return list;
    }
}

// 1302. Deepest Leaves Sum
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = que.poll();
                sum += curNode.val;

                if (curNode.left != null) {
                    que.offer(curNode.left);
                }
                if (curNode.right != null) {
                    que.offer(curNode.right);
                }
            }
        }
        return sum;
    }
}