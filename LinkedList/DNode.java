package LinkedList;

public class DNode {

    private int data;
    private DNode next;
    private DNode prev;

    public DNode(int data, DNode next, DNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DNode(){
    }

    public int getData() {
        return data;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

}
