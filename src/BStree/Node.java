package BStree;

class Node {
    private int key;
    private Node right;
    private Node left;
    private Node parent;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
