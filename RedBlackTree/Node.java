package RedBlackTree;

public class Node {

    private String color;
    private int key;
    private Node left;
    private Node right;
    private Node parent;

    public Node(){
    }

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = "RED";
    }

    public Node(int key, String color){
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
