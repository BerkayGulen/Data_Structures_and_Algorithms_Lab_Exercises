package Lab2_BST;//Berkay Gülen 20170613017

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();

        bst.setRoot(new BinaryNode(3));
        BinaryNode root = bst.getRoot();
        root.left = new BinaryNode(2);
        root.left.left = new BinaryNode(1);
        root.right = new BinaryNode(5);
        root.right.left = new BinaryNode(4);
        root.right.right = new BinaryNode(7);

        bst.print(2, 5, root);


//        bst.setRoot(new BinaryNode("A"));
//        BinaryNode root = bst.getRoot();
//
//        root.left = new BinaryNode("B");
//        root.left.left = new BinaryNode("D");
//        root.left.left.left = new BinaryNode("G");
//        root.left.left.right = new BinaryNode("H");
//        root.left.right = new BinaryNode("E");
//        root.left.right.left = new BinaryNode("I");
//        root.left.right.right = new BinaryNode("J");
//        root.left.right.right.left = new BinaryNode("L");
//        root.left.right.right.right = new BinaryNode("M");
//        root.right = new BinaryNode("C");
//        root.right.right = new BinaryNode("F");
//        root.right.right.right = new BinaryNode("K");
//        bst.printTreeInorder(root);
//        // TODO: Construct the BST by using given 'insert(value)' method
//
//        BST bst = new BST();
//        bst.insert(7);
//        bst.insert(8);
//        bst.insert(3);
//        bst.insert(1);
//        bst.insert(4);
//        bst.insert(5);
//        bst.insert(6);
//
//
//        // TODO: Use 'remove(value)' method to remove any number of elements of your choosing
//        System.out.println("Before Removal");
//        bst.printTreeInorder(bst.getRoot());
//        System.out.println();
//
//        bst.remove(3);
//
//
//        // TODO: Use 'findMin()' method to find and print the minimum element in your BST
//        System.out.println("\n"+"Min: "+bst.findMin(bst.getRoot()));
//
//
//        // TODO: Use 'findMax()' method to find and print the maximum element in your BST
//        System.out.println("Max: "+bst.findMax(bst.getRoot()));
//
//
//        // TODO: Use 'printTreeInorder()' method to print your BST
//        System.out.println("\n"+"After Removal");
//        bst.printTreeInorder(bst.getRoot());
//
//

    }

}