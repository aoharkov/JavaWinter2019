package task5.p4.model;

class Node<T> {
    private T key;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private boolean isRed;

    Node(T key, Node<T> parent, Node<T> nil, boolean isRed) {
        this.key = key;
        this.parent = parent;
        this.left = nil;
        this.right = nil;
        this.isRed = isRed;
    }

    Node() {
    }

    T getKey() {
        return key;
    }

    void setKey(T key) {
        this.key = key;
    }

    Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }

    boolean isRed() {
        return isRed;
    }

    void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }
}
