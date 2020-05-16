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
    public Node buildTree(){
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
    }

    // 前序遍历
    void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val+" ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+" ");
    }

    // 遍历思路-求结点个数   (前序遍历)
    static int size = 0;
    void getSize1(Node root){
        if (root == null){
            return;
        }
        size++;
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root){
        if (root == null){
            return 0;
        }
        //左树的结点＋右树的结点+本身
        return getLeafSize2(root.left)+getLeafSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            leafSize++;
        }else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
            return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

}
