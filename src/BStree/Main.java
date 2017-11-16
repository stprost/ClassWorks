package BStree;

public class Main {
    public static void main(String [] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(5);
        bst.addNode(3);
        bst.addNode(7);
        bst.addNode(15);
        bst.addNode(12);
        bst.addNode(18);
        bst.prn();
        System.out.println();
        bst.remove(10);
        bst.prn();
    }
}
