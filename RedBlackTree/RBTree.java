package RedBlackTree;

public class RBTree {

    private Node root;
    private Node nil;

    public RBTree(){
        Node nil = new Node (0, "BLACK");
        this.nil = nil;
        this.root = this.nil;
    }

    private void rbInsert(RBTree T, Node z){
        Node x = T.root;
        Node y = T.nil;
        while(x != T.nil){
            y = x;
            if(z.getKey() < x.getKey())
                x = x.getLeft();
            else
                x = x.getRight();
        }
        z.setParent(y);
        if(y==T.nil)
            T.root = z;
        else if(z.getKey() < y.getKey())
            y.setLeft(z);
        else
            y.setRight(z);
        z.setLeft(T.nil);
        z.setRight(T.nil);
        z.setColor("RED");
        rbInsertFixUp(T, z);
    }

    private void rbInsertFixUp(RBTree T, Node z){
        while(z.getParent().getColor().equals("RED")){
            if(z.getParent() == z.getParent().getParent().getLeft()) {
                Node y = z.getParent().getParent().getRight();
                if(y.getColor().equals("RED")) {
                    z.getParent().setColor("BLACK");
                    y.setColor("BLACK");
                    z.getParent().getParent().setColor("RED");
                    z = z.getParent().getParent();
                }
                else {
                    if(z == z.getParent().getRight()){
                        z = z.getParent();
                        leftRotate(T, z);
                    }
                    z.getParent().setColor("BLACK");
                    z.getParent().getParent().setColor("RED");
                    rightRotate(T, z.getParent().getParent());
                }
            }
            else{
                Node y = z.getParent().getParent().getLeft();
                if(y.getColor().equals("RED")) {
                    z.getParent().setColor("BLACK");
                    y.setColor("BLACK");
                    z.getParent().getParent().setColor("RED");
                    z = z.getParent().getParent();
                }
                else{
                    if(z == z.getParent().getLeft()){
                        z = z.getParent();
                        rightRotate(T, z);
                    }
                    z.getParent().setColor("BLACK");
                    z.getParent().getParent().setColor("RED");
                    leftRotate(T, z.getParent().getParent());
                }
            }
        }
        T.root.setColor("BLACK");
    }

    private void leftRotate(RBTree T, Node x){
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft() != T.nil)
            y.getLeft().setParent(x);
        y.setParent(x.getParent());
        if(x.getParent() == T.nil)
            T.root = y;
        else if(x == x.getParent().getLeft())
            x.getParent().setLeft(y);
        else
            x.getParent().setRight(y);
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(RBTree T, Node x){
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if(y.getRight() != T.nil)
            y.getRight().setParent(x);
        y.setParent(x.getParent());
        if(x.getParent() == T.nil)
            T.root = y;
        else if(x == x.getParent().getRight())
            x.getParent().setRight(y);
        else
            x.getParent().setLeft(y);

    }

    private void rbTransplant(RBTree T, Node u, Node v){
        if(u.getParent() == T.nil)
            T.root = v;
        else if(u == u.getParent().getLeft())
            u.getParent().setLeft(v);
        else
            u.getParent().setRight(v);
        v.setParent(u.getParent());
    }

    private void rbDelete(RBTree T, Node z){
        Node y = z;
        Node x;
        String yOrigColor = y.getColor();
        if(z.getLeft() == T.nil) {
            x = z.getRight();
            rbTransplant(T, z, z.getRight());
        }
        else if(z.getRight() == T.nil) {
            x = z.getLeft();
            rbTransplant(T, z, z.getLeft());
        }
        else{
            y = treeMinimum(z.getRight());
            yOrigColor = y.getColor();
            x = y.getRight();
            if(y.getParent() == z)
                x.setParent(y);
            else{
                rbTransplant(T, y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            rbTransplant(T, z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }
        if(yOrigColor.equals("BLACK"))
            rbDeleteFixUp(T, x);
    }

    private void rbDeleteFixUp(RBTree T, Node x){
        while(x != T.root && x.getColor().equals("BLACK")){
            if(x == x.getParent().getLeft()){
                Node w = x.getParent().getRight();
                if(w.getColor().equals("RED")){
                    w.setColor("BLACK");
                    x.getParent().setColor("RED");
                    leftRotate(T, x.getParent());
                    w = x.getParent().getRight();
                }
                if(w.getLeft().getColor().equals("BLACK") && w.getRight().getColor().equals("BLACK")){
                    w.setColor("RED");
                    x = x.getParent();
                }
                else{
                    if (w.getRight().getColor().equals("BLACK")){
                        w.getLeft().setColor("BLACK");
                        w.setColor("RED");
                        rightRotate(T, w);
                        w = x.getParent().getRight();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor("BLACK");
                    w.getRight().setColor("BLACK");
                    leftRotate(T, x.getParent());
                    x = T.root;
                }
            }
            else{
                Node w = x.getParent().getLeft();
                if(w.getColor().equals("RED")){
                    w.setColor("BLACK");
                    x.getParent().setColor("RED");
                    rightRotate(T, x.getParent());
                    w = x.getParent().getLeft();
                }
                if(w.getRight().getColor().equals("BLACK") && w.getLeft().getColor().equals("BLACK")){
                    w.setColor("RED");
                    x = x.getParent();
                }
                else{
                    if (w.getLeft().getColor().equals("BLACK")){
                        w.getRight().setColor("BLACK");
                        w.setColor("RED");
                        leftRotate(T, w);
                        w = x.getParent().getLeft();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor("BLACK");
                    w.getLeft().setColor("BLACK");
                    rightRotate(T, x.getParent());
                    x = T.root;
                }
            }
        }
        x.setColor("BLACK");
    }

    public void inorderWalk(Node node){
        if(node == null)
            return;

        inorderWalk(node.getLeft());
        System.out.print("|" + node.getKey() + " " + node.getColor() + "|");
        inorderWalk(node.getRight());
    }

    public Node treeMinimum(Node x){
        while(x != nil) {
            x = x.getLeft();
        }
        return x;
    }

    public void print(Node node, int space){
        if(node == null)
            return;

        space += 10;
        print(node.getRight(), space);
        System.out.println();
        for(int i=10; i<space; i++)
            System.out.print(" ");
        System.out.print(node.getKey() + " " + node.getColor() + "\n");

        print(node.getLeft(), space);
    }

    public void printDriver(Node node){
        print(node, 0);
    }

    public static void main(String[] args){
        RBTree myTree = new RBTree();

        Node a = new Node(3);
        Node b = new Node(7);
        Node c = new Node(10);
        Node d = new Node(12);
        Node e = new Node(14);
        Node f = new Node(15);
        Node g = new Node(16);
        Node h = new Node(17);
        Node i = new Node(19);
        Node j = new Node(20);
        Node k = new Node(21);
        Node l = new Node(23);
        Node m = new Node(26);
        Node n = new Node(28);
        Node o = new Node(30);
        Node p = new Node(35);
        Node q = new Node(38);
        Node r = new Node(39);
        Node s = new Node(41);
        Node t = new Node(47);

        myTree.rbInsert(myTree, a);
        myTree.rbInsert(myTree, b);
        myTree.rbInsert(myTree, c);
        myTree.rbInsert(myTree, d);
        myTree.rbInsert(myTree, e);
        myTree.rbInsert(myTree, f);
        myTree.rbInsert(myTree, g);
        myTree.rbInsert(myTree, h);
        myTree.rbInsert(myTree, i);
        myTree.rbInsert(myTree, j);
        myTree.rbInsert(myTree, k);
        myTree.rbInsert(myTree, l);
        myTree.rbInsert(myTree, m);
        myTree.rbInsert(myTree, n);
        myTree.rbInsert(myTree, o);
        myTree.rbInsert(myTree, p);
        myTree.rbInsert(myTree, q);
        myTree.rbInsert(myTree, r);
        myTree.rbInsert(myTree, s);
        myTree.rbInsert(myTree, t);

        System.out.println("Initial Tree: ");
        myTree.printDriver(myTree.root);
        System.out.print("\n\n\n\n\n");

        System.out.println("Deleting 14...");
        myTree.rbDelete(myTree, e);
        myTree.printDriver(myTree.root);
    }
}
