package BTree;

import java.util.Arrays;

public class Node {

    public static int T = 2;
    private int numKeys = (2*T)-1;
    private int numChildren = 2*T;
    //store keys and children in arrays
    private String[] keys = new String[numKeys];
    private Node[] children = new Node[numChildren];
    private boolean isLeaf;

    //ignore diskread() and diskwrite() in psuedocode
    public Node(){
        Arrays.fill(keys, null);
        Arrays.fill(children, null);
    }

    public boolean getLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int numKeys) {
        this.numChildren = numKeys + 1;
        this.numKeys = numKeys;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public String[] getKeys() {
        return keys;
    }

    public String getKey(int i) {
        return keys[i];
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public void setKey(int i, String key) {
        keys[i] = key;
    }

    public Node[] getChildren() {
        return children;
    }

    public Node getChild(int i) {
        return children[i];
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setChild(int i, Node child) {
        this.children[i] = child;
    }

    public static int getT() {
        return T;
    }
}
