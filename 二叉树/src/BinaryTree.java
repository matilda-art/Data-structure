import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @program: 二叉树
 * @description
 * @author: matilda
 * @create: 2020-05-16 11:09
 **/
class Node{
    public int val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}

public class BinaryTree {
    //创建二叉树
    /*public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;

        return A;
    }*/

    //创建二叉树
    int i = 0;
    public Node buildTree(String str){
        Node root = null;
        if (str.charAt(i) != '#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }

    // 前序遍历
    void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 前序遍历（非递归实现）
    void preOrderTraversalNor(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val + " ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    // 中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
    }

    // 中序遍历（非递归实现）
    void inOrderTraversalNor(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val+" ");
            cur = top.right;
        }
        System.out.println();
    }

    // 后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val + " ");
    }

    // 后序遍历（非递归实现）
    void postOrderTraversalNor(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;

        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev){
                System.out.println(cur.val+" ");
                stack.pop();
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        System.out.println();
    }

    // 遍历思路-求结点个数   (前序遍历)
    static int size = 0;

    void getSize1(Node root) {
        if (root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        //左树的结点＋右树的结点+本身
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;

    void getLeafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        } else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 获取二叉树的最大深度
    int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        //三目运算符
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找(前序遍历
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val) {
        if (root == null) {
            return null;
        }
        //1、判断根节点是否是查找的数字val
        if (root.val == val) {
            return root;
        }
        //2、左边
        //  递归--》左边全部递归完成后-》返回值是否是空
        Node left = find(root.left, val);
        if (left != null) {
            return left;
        }
        //3、右边
        Node right = find(root.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }


    // 层序遍历
    void levelOrderTraversal(Node root){
        if (root == null)return;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            while (cur != null) {
                System.out.println(cur.val+" ");
                if (cur.left != null){
                    queue.offer(root.left);
                }
                if (cur.right != null){
                    queue.offer(root.right);
                }
            }
        }
        System.out.println();
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root){
        if (root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            Node cur2 = queue.peek();
            if (cur2 != null){
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }
}