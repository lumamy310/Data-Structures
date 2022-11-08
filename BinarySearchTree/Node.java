package BinarySearchTree;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(){
    }

    public Node(int value, Node leftChild, Node rightChild){
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getValue(){
        return value;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
