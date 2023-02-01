package Lab2_BST;

public class BinaryNode
{
    protected int element; // The data in the node
    protected BinaryNode left; // Left child
    protected BinaryNode right; // Right child
    protected String name;


    public BinaryNode(int element)
    {
        this.element = element;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(String name)
    {
        this.name = name;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(int element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

}