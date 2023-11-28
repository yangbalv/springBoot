package com.springboot.live_comm.coding.learning;


import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//
//        ListNode listNode = solution.mergeTwoLists(listNode1, listNode4);
//
//        while (null != listNode) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;

        int num = 0;

        while (!(null == l1 && null == l2 && num == 0)) {
            int count = num;
            if (l1 != null) {
                count += l1.val;
            }
            if (l2 != null) {
                count += l2.val;
            }

            p.val = count % 10;
            num = count / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (!(null == l1 && null == l2 && num == 0)) {
                ListNode util = new ListNode();
                p.next = util;
                p = util;
            }
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return head.next;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode node = null;
        while (p != null) {
            ListNode util = p.next;
            p.next = node;
            node = p;
            p = util;
        }
        return node;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int count = right - left + 1;
        for (int i = 0; i < left - 2; i++) {
            p = p.next;
        }
        ListNode start = p.next;
        ListNode node = null;
        while (start != null) {
            ListNode util = start.next;
            start.next = node;
            node = start;
            start = util;
        }
        return head;
    }

    public int maxDepth(TreeNode root) {

        return count(root, 1);
    }

    public int count(TreeNode root, int i) {
        if (root == null) {
            return i + 1;
        } else return Math.max(count(root.left, i + 1), count(root.right, i + 1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root, root);

    }

    public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.buildTree3(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int val = preorder[0];
        TreeNode head = new TreeNode(val);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                int left = i - 1;
                int right = i + 1;
                if (left >= 0) {
                    int[] pLefts = new int[left + 1];
                    int[] iLefts = new int[left + 1];
                    System.arraycopy(preorder, 1, pLefts, 0, left + 1);
                    System.arraycopy(inorder, 0, iLefts, 0, left + 1);
                    head.left = buildTree(pLefts, iLefts);
                }

                if (right < preorder.length) {
                    int[] pRights = new int[preorder.length - right];
                    int[] iRights = new int[preorder.length - right];
                    System.arraycopy(preorder, right, pRights, 0, pRights.length);
                    System.arraycopy(inorder, right, iRights, 0, pRights.length);
                    head.right = buildTree(pRights, iRights);
                }
                break;
            }

        }

        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    public TreeNode buildTreeUtil(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {

        int val = preorder[pL];
        TreeNode head = new TreeNode(val);

        for (int i = iL; i <= iR; i++) {
            if (inorder[i] == val) {
                int left = i - iL;
                int right = iR - i;
                if (left > 0) {
                    head.left = buildTreeUtil(preorder, pL + 1, pL + left, inorder, iL, iL + left - 1);
                }
                if (right > 0) {
                    head.right = buildTreeUtil(preorder, pR - right + 1, pR, inorder, iR - right + 1, iR);
                }
                break;
            }

        }

        return head;
    }

    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        return buildTree3Util(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree3Util(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR) {

        int val = postorder[pR];

        TreeNode head = new TreeNode(val);

        for (int i = iL; i <= iR; i++) {
            if (inorder[i] == val) {
                int left = i - iL;
                int right = iR - i;
                if (left > 0) {
                    head.left = buildTree3Util(inorder, iL, iL + left - 1, postorder, pL, pL + left - 1);
                }
                if (right > 0) {
                    head.right = buildTree3Util(inorder, iR - right + 1, iR, postorder, pR - right, pR - 1);
                }
                break;
            }

        }

        return head;
    }

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node pop = queue.poll();
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                if (size > 1) {
                    pop.next = queue.element();
                }
                size--;
            }
        }
        return root;
    }


    public void flatten(TreeNode root) {
        flattenUtil(root);

    }

    public TreeNode flattenUtil(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode treeNodeLeft = flattenUtil(left);
        TreeNode treeNodeRight = flattenUtil(right);
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return treeNodeRight;
        } else if (root.right == null) {
            root.left = null;
            root.right = left;
            return treeNodeLeft;
        } else {
            root.left = null;
            root.right = left;
            treeNodeLeft.right = right;
            return treeNodeRight;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }

//
//    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        Solution solution = new Solution();
//        System.out.println(solution.sumNumbers(treeNode1));
//    }

    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Queue<Integer> integerQueue = new ArrayDeque<>();

        treeNodeQueue.add(root);
        integerQueue.add(root.val);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode peek = treeNodeQueue.remove();
            int element = integerQueue.remove();
            if (peek.left == null && peek.right == null) {
                res += element;
            } else {
                if (peek.left != null) {
                    treeNodeQueue.add(peek.left);
                    integerQueue.add(element * 10 + peek.left.val);
                }
                if (peek.right != null) {
                    treeNodeQueue.add(peek.right);
                    integerQueue.add(element * 10 + peek.right.val);
                }
            }

        }
        return res;

    }


    public int sumNumbersDfs(TreeNode root) {
        return sumNumbersDfsUtil(root, 0);
    }

    public int sumNumbersDfsUtil(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int num = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return sumNumbersDfsUtil(root.left, num) + sumNumbersDfsUtil(root.right, num);
    }


//    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        Solution solution = new Solution();
//        System.out.println(solution.maxPathSum(treeNode1));
//    }

    int maxPathNum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return maxPathSumUtil(root);
    }

    public int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSumUtil(root.left), 0);
        int right = Math.max(maxPathSumUtil(root.right), 0);
        int res = root.val + left + right;
        maxPathNum = Math.max(maxPathNum, res);

        return root.val + Math.max(left, res);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
    Set<TreeNode> nodeSet = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            nodeSet.add(p);
            p = nodeMap.get(p);
        }

        while (q != null) {
            if (nodeSet.contains(q)) {
                return q;
            }
            q = nodeMap.get(q);
        }
        return q;

    }

    public void dfs(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                nodeMap.put(root.left, root);
                dfs(root.left);
            }
            if (root.right != null) {
                nodeMap.put(root.right, root);
                dfs(root.right);
            }
        }
    }

//    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.right = treeNode5;
//        treeNode3.right = treeNode4;
//        Solution solution = new Solution();
//        System.out.println(solution.rightSideView(treeNode1));
//    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);


        while (!stack.isEmpty()) {
            int i = stack.size();
            while (i > 0) {
                TreeNode pop = stack.remove();

                if (i == 1) {
                    res.add(pop.val);
                }
                if (pop.left != null) {
                    stack.add(pop.left);
                }
                if (pop.right != null) {
                    stack.add(pop.right);
                }
                i--;
            }

        }
        return res;

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int i = queue.size();
            int num = queue.size();
            double util = 0D;
            while (i > 0) {
                TreeNode pop = queue.remove();

                util += pop.val;
                if (i == 1) {
                    double v = util / num;
                    res.add(v);

                }
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                i--;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int i = queue.size();
                while (i > 0) {
                    TreeNode pop = queue.remove();
                    list.add(pop.val);
                    if (i == 1) {
                        res.add(list);
                    }
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                    i--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean turn = true;
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int i = queue.size();
                while (i > 0) {
                    TreeNode pop = queue.remove();
                    if (turn) {
                        list.add(pop.val);
                    } else {
                        list.add(0, pop.val);
                    }
                    if (i == 1) {
                        res.add(list);
                    }
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                    i--;
                }
                turn = !turn;
            }

        }
        return res;
    }

    int pre = -1;
    int minNum = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMinimumDifferenceUtil(root);
        return minNum;
    }


    public void getMinimumDifferenceUtil(TreeNode root) {
        if (root != null) {

            getMinimumDifferenceUtil(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                minNum = Math.min(minNum, root.val - pre);
                pre = root.val;
            }
            getMinimumDifferenceUtil(root.right);
        }
    }

    int kth = 0;
    int kthVal;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestUtil(root, k);
        return kthVal;
    }


    public void kthSmallestUtil(TreeNode root, int k) {
        if (root != null) {
            kthSmallestUtil(root.left, k);
            if (++kth == k) {
                kthVal = root.val;
            } else {

                kthSmallestUtil(root.right, k);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);

        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(treeNode1));
    }


    public boolean isValidBST2(TreeNode root) {
        boolean res = true;

        if (root.left != null) {
            res = res && root.val > root.left.val && isValidBST2(root.left);
        }
        if (root.right != null) {
            res = res && root.right.val > root.val && isValidBST2(root.right);
        }
        return res;
    }

    int isValidNum;
    boolean isValid = true;
    boolean isValidRes = true;

    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        if (root.left != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
        } else {
            if (isValid) {
                isValidNum = root.val;
            } else {
                res = root.val > isValidNum;
            }
        }
        if (root.right != null) {
            if (!isValidBST(root.right)) {
                return false;
            }
        }
        return res;
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    numIslandsUtil(grid, i, j);
                }

            }
        }
        return res;
    }

    public void numIslandsUtil(char[][] grid, int i, int j) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length) {
            if (grid[i][j] == '1') {
                grid[i][j] = '2';
                numIslandsUtil(grid, i + 1, j);
                numIslandsUtil(grid, i - 1, j);
                numIslandsUtil(grid, i, j + 1);
                numIslandsUtil(grid, i, j - 1);
            }

        }
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                solveUtil(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                solveUtil(board, i, board[0].length - 1);
            }
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (board[0][j] == 'O') {
                solveUtil(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                solveUtil(board, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solveUtil(char[][] board, int i, int j) {
        if (0 <= i && i < board.length && 0 <= j && j < board[0].length) {
            if (board[i][j] == 'O') {
                board[i][j] = 'A';
                solveUtil(board, i + 1, j);
                solveUtil(board, i - 1, j);
                solveUtil(board, i, j + 1);
                solveUtil(board, i, j - 1);
            }
        }
    }


    //    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//    示例 1：
//
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    示例 2：
//
//    输入：digits = ""
//    输出：[]
//    示例 3：
//
//    输入：digits = "2"
//    输出：["a","b","c"]
    char[][] numbers = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);

        }


    }
    SP231128364602	PGC0008	PGC0044	PGC0337	CL3600105660240BA	工业普圆 20# 2*3 (FB) (40/40) 包钢	CD0011		2*3	330	660.000	300	198000.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/48117120-ed8c-410b-aac4-69fb8bcc10c6.jpg	PGC0008	CK231118443197	FW0002		2	102	QY010760	3	30	40		30.00000	PC231128449561	WL120559		2	2023-11-28 11:54:30	1	DH·姓名	2023-11-28 11:54:30	1	DH·姓名	1	1	是	0	否	0	否	SPH231128312890	2	0	1	全部
    SP231127542945	PGC0003	PGC0019	PGC0279	CL1100201753120TY	电镀锌 SECC 1.0*2*5 (FC) (20/20) 通阳达	CD0001	PO231127423300-1	1.0*2*5	2.111	198.434	1001.01	198634.41834	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/d22b49af-b432-423f-8f29-f70bcbfd561e.jpg	PGC0003	CK231107454649	FW0002		94	102	QY0058106	1	1001.01	20	PO231127423300-1	1001.01000	PC231127467922	WL120540		1	2023-11-27 14:23:51	1	DH·8888	2023-11-27 14:23:51	1	DH·8888	1	0	否	0	否	0	否	SPH231128312865	2	0	1	全部
    SP231126389023	PGC0002	PGC0016	PGC0131	CL0800205281120CJ	冷轧板 SPCC-SR 3.0*8*8 (FC) (20/20) 长江钢铁	CD0002	PO231126557378-1-1	3.0*8*8	3	36.000	222	7992.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/abaae498-fc24-49be-acf9-525a48479475.jpg	PGC0002	CK231116456735	FW0002		12	102	QY1180016	1	20	20	PO231126557378-1	20.00000	PC231126368548	WL120529		1	2023-11-26 18:10:19	1	DH·8888	2023-11-26 18:10:19	1	DH·8888	1	0	否	0	否	0	否	SPH231126567805	2	0	1	全部
    SP231123394365	PGC0007	PGC0038	PGC0323	CL3000100372360CF	四级抗震螺纹钢 HRB500E 12 (FD) (60/60) 长发	CD0111	PO231121427365-21-11-2023 15:34:31	12	100	300.000	333	99900.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/ab051214-80fc-4b5d-abe4-46cc12b77419.jpg	PGC0007	CK230817560969	FW0002		3	102	QY1179981	0	565	60		565.00000	PC231123451044	WL120304		3	2023-11-23 11:04:45	1	DH·name	2023-11-23 11:04:45	1	DH·name	1	0	否	0	否	0	否	SPH231128312862	2	0	1	全部	03	02	03	0	02	1	1	0	123	国际标准
    SP231119446689	PGC0007	PGC0035	PGC0319	CL270010000800ZG	三级抗震螺纹钢 HRB400E 14*9   中天	CD0039	HG-YC20230725-2	14*9	1.83	376.980	3850	1451373.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/ab051214-80fc-4b5d-abe4-46cc12b77419.jpg	PGC0007	CK0001	FW0003,FW0002		206	102	12	0	3848	0		3848.00000	PC231119549182	WL109677		0	2023-11-19 21:12:52	1	DH·name	2023-11-19 21:12:52	1	DH·name	1	0	否	0	否	0	否	SPH231119568122	2	0	1	全部
    SP231119446604	PGC0007	PGC0036	PGC0321	CL2800105352120CJ	三级盘螺 HRB400 3 (FC) (20/20) 长江钢铁	CD0002	PO231119347736-1-1	3	4	84.000	300	25200.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/6f759762-43be-41ac-a03d-8ebf3cc81ceb.jpg	PGC0007	CK231116456735	FW0002		21	102	QY1179946	0	100	20	PO231119347736-1	100.00000	PC231119549154	WL120416		1	2023-11-19 09:24:37	1	DH·name	2023-11-19 09:24:37	1	DH·name	1	1	是	0	否	0	否	SPH231125360584	2	0	1	全部	02	02	02	0	01	1	1	1	123	技术标准
    SP231117300822	PGC0007	PGC0036	PGC0321	CL2800105352120CJ	三级盘螺 HRB400 3 (FC) (20/20) 长江钢铁	CD0002	PO231115480024-1-1	3	2	4.000	122	488.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/6f759762-43be-41ac-a03d-8ebf3cc81ceb.jpg	PGC0007	CK230817560969	FW0002		2	102	QY1179950	0	100	20	PO231115480024-1	100.00000	PC231117411148	WL120416		1	2023-11-17 10:03:01	1	DH·name	2023-11-17 10:03:01	1	DH·name	1	0	否	0	否	0	否	SPH231119548146	2	0	1	全部
    SP231029338619	PGC0005	PGC0567	PGC0600	CL4000101727120ME	等边角钢 Q235B 1.0*1*1 (FC) (20/20) 梅钢	CD0022	PO231029408066-1	1.0*1*1	10	840.000	10	8400.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20221114/1668409418671/5%E3%80%81%E5%9E%8B%E9%92%A2-%E8%A7%92%E9%92%A2.jpg	PGC0005	CK0236	FW0002		84	102	QY0058106	1	10	20	PO231029408066	10.00000	PC231029577119	WL120160		1	2023-10-29 21:32:37	1	DH·name	2023-10-29 21:32:37	1	DH·name	1	0	否	0	否	0	否	SPH231029578080	2	0	1	全部


}