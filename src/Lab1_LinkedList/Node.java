
public class Node {
    //Berkay Gülen 20170613017
    private int data;
    private Node next;
    private Node previous;

    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node previous,Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }


}
