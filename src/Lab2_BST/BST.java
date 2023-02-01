package Lab2_BST;

//Berkay Gülen 20170613017
public class BST {
    /**
     * Fields
     **/
    private BinaryNode root;

    /**
     * Constructors
     **/
    public BST() {
        setRoot(null);
    }

    /**
     * Getters and Setters
     **/
    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    // Inserts an element recursively
    public void insert(int x) {
        root = insertRecursively(root, x);
    }

    // Recursive helper method for insert(int)
    private BinaryNode insertRecursively(BinaryNode root, int x) {
        // if the root is null, create a new node an return it
        if (root == null) {
            return new BinaryNode(x);
        }

        // if given key is less than the root node,
        // recur for left subtree
        if (x < root.element) {
            root.left = insertRecursively(root.left, x);
        }

        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insertRecursively(root.right, x);
        }

        return root;
    }

    // TODO: Remove an element and re-organize BST recursively
    public void remove(int x) {
        root = delete(root, x);
    }
//Removing node is tricky. We have 3 possible scenarios. 1: element is a leaf. 2: element has 1 child. 3: element have two children
    //my delete method takes 2 parameter. when this method first call, it takes root as a subtree and value to be deleted.
    // after that methods checks the given subtree is null or not. if it is not, compare the given value with subtrees element value.
    // basically, it recursively finds the element to be deleted. However, the return value is BinaryNode.
    // Key thing is, since the recursive return values changes the nodes, if the node is not the deleted node, it returns itself so that the tree won't change.
    private BinaryNode delete(BinaryNode subTreeNode, int value) {
        if (subTreeNode == null) {
            return subTreeNode;
        } else if (value < subTreeNode.element) {
            subTreeNode.left = delete(subTreeNode.left, value);
        } else if (value > subTreeNode.element) {
            subTreeNode.right = delete(subTreeNode.right, value);
        } else {
            //leaf or 1 child situation.
            if (subTreeNode.left == null) {
                return subTreeNode.right;
            } else if (subTreeNode.right == null) {
                return subTreeNode.left;
            } else {
                // two children situation.
                subTreeNode.element = findMin(subTreeNode.right);
                subTreeNode.right = (delete(subTreeNode.right, subTreeNode.element));
            }
        }
        return subTreeNode;

    }

    // TODO: Find the minimum element in the BST
    //There is a parameter in this method because I use it in the remove method too. When removing nodes with two children,
    //Best way is finding the smallest value of the right child of the removed element and swap values with removed element.
    //After that we can use delete method on the swapped element because now it is a leaf element and easy to delete.
    public int findMin(BinaryNode node) {
        // Returns minimum number which is in the BST

        if (root != null) {
            if (node.left == null) {
                return node.element;
            } else {
                return findMin(node.left);
            }
        }
        return 0;

    }
    // TODO: Find the maximum element in the BST

    public int findMax(BinaryNode node) {
        // Returns maximum number which is in the BST
        if (root != null) {
            if (node.right == null) {
                return node.element;
            } else {
                return findMax(node.right);
            }
        }
        return 0;
    }

    // TODO: Traverse the BST inorder and print it
    public void printTreeInorder(BinaryNode root) {
        System.out.print(root.name + ", ");

        if (root.left != null) {
            printTreeInorder(root.left);
        }

        if (root.right != null) {
            printTreeInorder(root.right);
        }

    }
    public void print(int k1,int k2,BinaryNode root){
        if (root !=null){
            if (k1 <=root.element){
                print(k1,k2,root.left);
            }
            if (root.element >= k1 && root.element <=k2){
                System.out.println(root.element+", ");
            }
            if (root.element <= k2){
                print(k1,k2,root.right);
            }
        }

    }
}