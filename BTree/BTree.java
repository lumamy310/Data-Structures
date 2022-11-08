package BTree;

import java.util.ArrayList;

public class BTree {

    private Node root;

    //ignore diskread() and diskwrite() in psuedocode
    //x.n is number of keys in x
    //x.ci is a child at index i
    //x.keyi is the key in x at index i
    public BTree(){
        Node x = allocateNode();
        x.setLeaf(true);
        x.setNumKeys(0);
        root = x;
    }

    private static Node allocateNode(){
        Node node = new Node();
        return node;
    }

    private void bTreeSplitChild(Node x, int i){
        Node z = allocateNode();
        Node y = x.getChild(i);
        z.setLeaf(y.getLeaf());
        z.setNumKeys(Node.getT() - 1);
        for(int j=0; j<Node.getT()-1; j++){
            z.setKey(j, y.getKey(j + Node.getT()));
        }
        if(!y.getLeaf()){
            for(int j=0; j<Node.getT(); j++){
                z.setChild(j, y.getChild(j+Node.getT()));
            }
        }
        y.setNumKeys(Node.getT() - 1);
        for(int j=x.getNumKeys(); j>=i+1; j-- ){
            x.setChild(j+1, x.getChild(j));
        }
        x.setChild(i+1, z);
        for(int j=x.getNumKeys()-1; j>=i; j--){
            x.setKey(j+1, x.getKey(j));
        }
        x.setKey(i, y.getKey(Node.getT() - 1));
        x.setNumKeys(x.getNumKeys() + 1);
    }

    private void insert(BTree T, String key){
        Node r = T.root;
        if(r.getNumKeys() == 2*Node.getT()-1){
            Node s = allocateNode();
            T.root = s;
            s.setLeaf(false);
            s.setNumKeys(0);
            s.setChild(0, r);
            bTreeSplitChild(s, 0);
            insertNonfull(s, key);
        }
        else
            insertNonfull(r, key);
    }

    public void insertNonfull(Node x, String k){
        int i = x.getNumKeys()-1;
        if(x.getLeaf()){
            while(i >= 0 && k.compareTo(x.getKey(i)) < 0){
                x.setKey(i+1, x.getKey(i));
                i--;
            }
            x.setKey(i+1, k);
            x.setNumKeys(x.getNumKeys()+1);
        }
        else{
            i = x.getNumKeys()-1;
            while(i>=0 && k.compareTo(x.getKey(i)) < 0){
                i--;
            }
            i = i+1;
            if(x.getChild(i).getNumKeys() == 2*Node.getT()-1) {
                bTreeSplitChild(x, i);
                if (k.compareTo(x.getKey(i)) > 0) {
                    i = i + 1;
                }
            }
            insertNonfull(x.getChild(i), k);
        }
    }

    private void print(Node x, int level){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<x.getNumKeys(); i++){
            if(x.getKey(i) != null){
                list.add(x.getKey(i));
            }
        }
        for(int j=0; j<=level; j++){
            System.out.print("-");
        }
        System.out.print(list.toString() + " ");
        System.out.println();
        level += 1;
        for(int a=0; a<x.getNumChildren(); a++){
            if(x.getChild(a) != null) {
                print(x.getChild(a), level);
            }
        }
    }



    public static void main(String[] args){
        BTree myTree = new BTree();
        System.out.println("- denotes the level.\n");
        myTree.insert(myTree, "N");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "X");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "P");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "Y");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "Z");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "A");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "C");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "D");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "O");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "T");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "V");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "K");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "R");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "L");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "I");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "U");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "Q");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "G");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "M");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "B");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "H");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "E");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "J");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "S");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "F");
        myTree.print(myTree.root, 0);
        System.out.println();
        myTree.insert(myTree, "W");
        myTree.print(myTree.root, 0);
    }
}
