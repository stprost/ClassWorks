package BStree;


import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class BinarySearchTree {
    private static Node root;
    private static int sz = 0;


    public static Node find(int key) {
        Node tempNode = root;
        if (tempNode == null) return null;
        while (tempNode.getKey()!= key) {
            if (tempNode.getKey() < key) tempNode = tempNode.getRight();
            else tempNode = tempNode.getLeft();
            if (tempNode == null) return null;
        }
        return tempNode;
    }

    public static boolean contains(int key) {
        return find(key) != null;
    }

    public static void addNode(int key) {
        sz++;
        Node newNode = new Node(key);
        Node parentNode;
        if (root == null) {
            root = newNode;
        } else {
            Node tempNode = root;
            while (tempNode != newNode) {
                if (tempNode.getKey() == newNode.getKey()) break;
                parentNode = tempNode;
                if (key > tempNode.getKey()) {
                    tempNode = tempNode.getRight();
                    if (tempNode == null) {
                        parentNode.setRight(newNode);
                        newNode.setParent(parentNode);
                        tempNode = newNode;
                    }
                } else {
                    tempNode = tempNode.getLeft();
                    if (tempNode == null) {
                        parentNode.setLeft(newNode);
                        newNode.setParent(parentNode);
                        tempNode = newNode;
                    }
                }
            }
        }
    }


    public static void remove(int key) {
        Node delNode = find(key);
        if (delNode != null) {
            Node parentNode = delNode.getParent();
            Node leftChild = delNode.getLeft();
            Node rightChild = delNode.getRight();
            if (leftChild == null && rightChild == null) {
                if (key > parentNode.getKey()) {
                    parentNode.setRight(null);
                } else {
                    parentNode.setLeft(null);
                }
            } else if (leftChild == null) {
                if (key > parentNode.getKey()) {
                    parentNode.setRight(rightChild);
                } else {
                    parentNode.setLeft(rightChild);
                }
                rightChild.setParent(parentNode);
            } else if (rightChild == null) {
                if (key > parentNode.getKey()) {
                    parentNode.setRight(leftChild);
                } else {
                    parentNode.setLeft(leftChild);
                }
                leftChild.setParent(parentNode);
            } else {
                if (leftChild.getRight() == null) {
                    if (key > parentNode.getKey()) {
                        parentNode.setRight(leftChild);
                    } else {
                        parentNode.setLeft(leftChild);
                    }
                    leftChild.setRight(delNode.getRight());
                } else {
                    Node tempNode = leftChild.getRight();
                    Node tempParent = leftChild;
                    while (tempNode.getRight() != null) {
                        tempParent = tempNode;
                        tempNode = tempNode.getRight();
                    }
                    delNode.setKey(tempNode.getKey());
                    if (tempNode.getLeft() == null) tempParent.setRight(null);
                    else {
                        tempParent.setRight(tempNode.getLeft());
                        tempNode.getLeft().setParent(tempParent);
                    }
                }
            }
        }
    }
    private static String prnch(Node node){
        String str = "";
        str += node.getLeft().getKey();
        str += node.getRight().getKey();
        return str;
    }

    public static void prn() {
        Node tempNode = root;
        while (tempNode != null) {

        }
    }
}
