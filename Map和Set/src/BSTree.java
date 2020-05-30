/**
 * @program: Map和Set
 * @description
 * 二叉搜索树
 最好情况下：二叉搜索树为完全二叉树，平均比较次数为log2(n)
 最坏情况下：二叉搜索树退化为单支树，平均比较次数为N/2
 * @author: matilda
 * @create: 2020-05-28 19:56
 **/

public class BSTree {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node root = null;

    //插入val的值
    public boolean insert(int val){
        Node node = new Node(val);
        if (root == null){
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;

        while (cur != null){
            if (cur.val == val){
                return false;
            }else if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        //cur为空，位置找到，进行插入
        //两种情况
        if (parent.val < val){
            parent.right = node;
        }else {
            parent.left = node;
        }
        return true;
    }

    //查找数据
    public Node search(int val){
        Node cur = root;
        while (cur != null){
            if(cur.val == val){
                return cur;
            }else if (cur.val < val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    //遍历二叉树(前序遍历)
    public void proOrder(Node root){
        if (root == null) return;
        System.out.println(root.val+" ");
        proOrder(root.left);
        proOrder(root.right);
    }

    //遍历二叉树（中序遍历）
    public void inOrder(Node root){
        if (root == null)return;
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }

    //删除
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if (cur.val == key){
                removeNode(parent,cur);
                return true;
            }else if (key < cur.val){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    public void removeNode(Node parent,Node cur){
        if (cur.left == null){
            if (cur == root){
                root = cur.right;
            }else if (cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            if (cur == root){
                root = cur.left;
            }else if (cur == parent.left){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            if (target == targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}
