package BinaryTree;

/**
 * Created by zhuxinquan on 16-6-2.
 * 声明一个二叉树类
 */
public class BinaryTree {

    private Node root;
    public void add(int data){
        if(root == null){
            root = new Node(data);
        }else{
            root.addNode(data);
        }
    }

    public void print(){
        if(root != null){
            root.printNode();
        }
    }

    //内部节点类
    class Node{

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void addNode(int data){
            if(data >= this.data){
                if(this.right == null){
                    this.right = new Node(data);
                }else{
                    this.right.addNode(data);
                }
            }else if(this.data > data){
                if(this.left == null){
                    this.left = new Node(data);
                }else{
                    this.left.addNode(data);
                }
            }
        }

        public void printNode(){
            //中序遍历
//            if(this.left != null){
//                this.left.printNode();
//            }
//            System.out.println(this.data + " ");
//            if(this.right != null){
//                this.right.printNode();
//            }

            //后序遍历
            if(this.left != null){
                this.left.printNode();
            }
            if(this.right != null){
                this.right.printNode();
            }
            System.out.println(this.data);
        }
    }
}
