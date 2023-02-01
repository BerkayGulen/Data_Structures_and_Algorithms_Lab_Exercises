public class DoublyLinkedList {

    //Berkay Gülen 20170613017
    private Node sentinalHead;
    private Node sentinalTail;
    private int size;

    DoublyLinkedList() {
        this.sentinalHead = new Node(0, null, null);
        this.sentinalTail = new Node(0, sentinalHead, sentinalHead);
        sentinalHead.setNext(sentinalTail);
        sentinalHead.setPrevious(sentinalTail);
    }

    public void addToFront(Node newNode) {
        Node node = newNode;
        if (size == 0) { // empty list
            sentinalHead.setNext(newNode);
            sentinalTail.setPrevious(newNode);
            newNode.setNext(sentinalTail);
        } else { // not empty
            Node current = sentinalHead.getNext();
            newNode.setNext(current);
            newNode.setPrevious(sentinalHead);
            current.setPrevious(newNode);
            sentinalHead.setNext(newNode);
        }
        size++;
    }

    public void deleteAfterBefore() {
        if (size == 0) {
            System.out.println("there are no items in the list");
        } else if (size == 1) {
            System.out.println("There are no elements before or after of the last and first element");
        } else if (size == 2) {
            System.out.println("Since there are 2 elements in the list and next element of the first node  corresponds the last item and  previous element of the last node corresponds first item. The list become empty list");
            sentinalTail.setPrevious(sentinalHead);
            sentinalHead.setNext(sentinalTail);
            size-=2;
        } else {
            Node frontItemToBeDeleted = getData(1, false);
            Node rearItemToBeDeleted = getData(1, true);

            Node previous = frontItemToBeDeleted.getPrevious();
            Node next = frontItemToBeDeleted.getNext();
            previous.setNext(next);
            next.setPrevious(previous);
            frontItemToBeDeleted.setNext(null);
            frontItemToBeDeleted.setPrevious(null);

            previous = rearItemToBeDeleted.getPrevious();
            next = rearItemToBeDeleted.getNext();
            previous.setNext(next);
            next.setPrevious(previous);
            rearItemToBeDeleted.setPrevious(null);
            rearItemToBeDeleted.setNext(null);
            size -= 2;
        }
    }

    public Node getData(int position, boolean isBackwards) {
        Node current;
        if (position < 0 || position > size) {
            System.out.println("invalid position");
        }
        if (isBackwards == true) { // tail to list
            current = sentinalTail.getPrevious();
            for (int i = 0; i < position; i++) {
                current = current.getPrevious();
            }
            System.out.println(position + " position backwards: " + current.getData());
        } else {
            current = sentinalHead.getNext();
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            System.out.println(position + " position forward: " + current.getData());
        }
        return current;

    }

    public void printList() {
        Node current = sentinalHead.getNext();
        System.out.print("HEAD =>");
        while (current != sentinalTail) {
            System.out.print(current.getData() + " =>");
            current = current.getNext();
        }
        System.out.print("TAIL\n");
        System.out.println("Size: " + this.size);
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        Node node2 = new Node(2);
        Node node8 = new Node(8);
        Node node6 = new Node(6);
        Node node1 = new Node(1);
        Node node5 = new Node(5);


        list.addToFront(node5);
        list.addToFront(node1);
        list.addToFront(node6);
        list.addToFront(node8);
        list.addToFront(node2);

        list.printList();

        list.getData(3, true);
        list.getData(3, false);

        System.out.println("After delete operations");
        list.deleteAfterBefore();
        list.printList();
    }


}
