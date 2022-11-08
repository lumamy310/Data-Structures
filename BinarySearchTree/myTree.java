package BinarySearchTree;

import java.util.ArrayList;

public class myTree {

    private Node root;

    public myTree(){
        root = null;
    }

    //helper method for isValid
    public void inorderWalk(Node node, ArrayList<Integer> list){
        if(node == null)
            return;

        inorderWalk(node.getLeftChild(), list);
        list.add(node.getValue());
        inorderWalk(node.getRightChild(), list);
    }

    public void inorderWalk(Node node){
        if(node == null)
            return;

        inorderWalk(node.getLeftChild());
        System.out.print(node.getValue() + " ");
        inorderWalk(node.getRightChild());
    }

    public void preorderWalk(Node node){
        if(node == null)
            return;

        System.out.print(node.getValue() + " ");
        preorderWalk(node.getLeftChild());
        preorderWalk(node.getRightChild());
    }

    public void postorderWalk(Node node){
        if(node == null)
            return;

        postorderWalk(node.getLeftChild());
        postorderWalk(node.getRightChild());
        System.out.print(node.getValue() + " ");
    }

    public boolean isValid(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        inorderWalk(node, list);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <= list.get(i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        myTree tree1 = new myTree();
        myTree tree2 = new myTree();
        ArrayList<Integer> list = new ArrayList<>();

        //creating tree 1
        tree1.root = new Node(12, null, null);
        tree1.root.setLeftChild(new Node(8, null, new Node(10, null, null)));
        tree1.root.getLeftChild().setLeftChild(new Node(4, null, null));
        tree1.root.getLeftChild().getLeftChild().setLeftChild(new Node(1, null, null));
        tree1.root.setRightChild(new Node(14, null, null));
        tree1.root.getRightChild().setLeftChild(new Node(13, null, null));
        tree1.root.getRightChild().setRightChild(new Node(20 ,null, null));

        //creating tree 2
        tree2.root = new Node(12, null, null);
        tree2.root.setLeftChild(new Node(10, null, new Node(8, null, null)));
        tree2.root.getLeftChild().setLeftChild(new Node(4, null, null));
        tree2.root.getLeftChild().getLeftChild().setLeftChild(new Node(1, null, null));
        tree2.root.setRightChild(new Node(14, null, null));
        tree2.root.getRightChild().setLeftChild(new Node(13, null, null));
        tree2.root.getRightChild().setRightChild(new Node(20 ,null, null));

        //printing the trees
        System.out.println("Tree 1: ");
        System.out.println("root node = 12");
        System.out.print("Inorder Walk: ");
        tree1.inorderWalk(tree1.root);
        System.out.println();
        System.out.print("Preorder Walk: ");
        tree1.preorderWalk(tree1.root);
        System.out.println();
        System.out.print("Postorder Walk: ");
        tree1.postorderWalk(tree1.root);
        System.out.println();
        System.out.println();

        System.out.println("Tree 2: ");
        System.out.println("root node = 12");
        System.out.print("Inorder Walk: ");
        tree1.inorderWalk(tree2.root);
        System.out.println();
        System.out.print("Preorder Walk: ");
        tree1.preorderWalk(tree2.root);
        System.out.println();
        System.out.print("Postorder Walk: ");
        tree1.postorderWalk(tree2.root);
        System.out.println();
        System.out.println();

        //checking validity
        System.out.print("Checking validity: ");
        System.out.println();
        if(tree1.isValid(tree1.root))
            System.out.println("Tree 1 is Valid.");
        else
            System.out.println("Tree 1 is Invalid.");
        if(tree2.isValid(tree2.root))
            System.out.println("Tree 2 is Valid.");
        else
            System.out.println("Tree 2 is Invalid.");





    }



}
