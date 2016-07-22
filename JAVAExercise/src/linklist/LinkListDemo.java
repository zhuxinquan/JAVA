package linklist;

/**
 * Created by zhuxinquan on 16-7-22.
 */
public class LinkListDemo {
    public static void main(String[] args) {
        NodeManger nm = new NodeManger();
        nm.addNode("1");
        nm.addNode("2");
        nm.addNode("3");
        nm.addNode("4");
        nm.addNode("5");
        nm.printNode();
        nm.delNode("3");
        System.out.println();
        nm.printNode();
    }
}

class NodeManger{

    private Node root;

    //定义一个结点内部类
    class Node{
        private String name;
        private Node next;

        public Node(String name){
            this.name = name;
        }
        public void add(String name){
            if(this.next == null){
                this.next = new Node(name);
            }else {
                this.next.add(name);
            }
        }
        public void del(String name){
            if(this.next != null){
                if(this.next.name.equals(name)){
                    this.next = this.next.next;
                }else {
                    root.next.del(name);
                }
            }
        }
        public void print(){
            if(this.next != null){
                System.out.print("->" + this.next.name);
                this.next.print();
            }
        }
    }

    public void addNode(String name){
        if(root == null){
            root = new Node(name);
        }else {
            root.add(name);
        }
    }

    public void delNode(String name){
        if(root != null){
            if(root.name.equals(name)){
                root = root.next;
            }else {
                root.del(name);
            }
        }
    }

    public void printNode(){
        if(root != null){
            System.out.print(root.name);
            root.print();
        }
    }
}
