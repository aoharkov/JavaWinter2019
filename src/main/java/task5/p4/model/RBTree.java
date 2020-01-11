package task5.p4.model;

public class RBTree<E extends Comparable<E>> {
    private final Node<E> nil;
    private Node<E> root;

    {
        nil = new Node<>();
        nil.setParent(nil);
        nil.setRight(nil);
        nil.setLeft(nil);
        root = nil;
    }

    public void add(E key) {
        Node<E> node = createNode(key);
        updateParent(node.getParent(), node);
        fixAfterAdd(node);
    }

    private Node<E> createNode(E key) {
        Node<E> parent = nil;
        Node<E> ancestor = root;
        while (ancestor != nil) {
            parent = ancestor;
            if (key.compareTo(ancestor.getKey()) < 0) {
                ancestor = ancestor.getLeft();
            } else {
                ancestor = ancestor.getRight();
            }
        }
        return new Node<>(key, parent, nil, true);
    }

    private void updateParent(Node<E> parent, Node<E> node) {
        if (parent == nil) {
            root = node;
            node.setIsRed(false);
        } else {
            if (node.getKey().compareTo(parent.getKey()) < 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private void fixAfterAdd(Node<E> node) {
        Node<E> parent = node.getParent();
        Node<E> grandParent = parent.getParent();
        while (node.getParent().isRed()) {
            if (parent == grandParent.getLeft()) {
                Node<E> uncle = grandParent.getRight();
                if (uncle.isRed()) {
                    changeColors(parent, grandParent);
                    uncle.setIsRed(false);
                    node = grandParent;
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    changeColors(parent, grandParent);
                    rightRotate(grandParent);
                }
            } else {
                Node<E> uncle = grandParent.getLeft();
                if (uncle.isRed()) {
                    changeColors(parent, grandParent);
                    uncle.setIsRed(false);
                    node = grandParent;
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    changeColors(parent, grandParent);
                    leftRotate(grandParent);
                }
            }
        }
        root.setIsRed(false);
    }

    private void changeColors(Node<E> parent, Node<E> grandParent) {
        parent.setIsRed(false);
        grandParent.setIsRed(true);
    }

    private void leftRotate(Node<E> node) {
        Node<E> son = node.getRight();
        leftRotateTransferChildren(node, son);
        leftRotateUpdateLinkFromParent(node, son);
        son.setParent(node.getParent());
        node.setParent(son);
    }

    private void rightRotate(Node<E> node) {
        Node<E> son = node.getLeft();
        rightRotateTransferChildren(node, son);
        rightRotateUpdateLinkFromParent(node, son);
        son.setParent(node.getParent());
        node.setParent(son);
    }

    private void leftRotateUpdateLinkFromParent(Node<E> node, Node<E> son) {
        if (node.getParent() == nil) {
            root = son;
        } else {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(son);
            } else {
                node.getParent().setRight(son);
            }
        }
    }

    private void leftRotateTransferChildren(Node<E> node, Node<E> son) {
        node.setRight(son.getLeft());
        if (son.getLeft() != nil) {
            son.getLeft().setParent(node);
        }
        son.setLeft(node);
    }

    private void rightRotateUpdateLinkFromParent(Node<E> node, Node<E> son) {
        if (node.getParent() == nil) {
            root = son;
        } else {
            if (node.getParent().getRight() == node) {
                node.getParent().setRight(son);
            } else {
                node.getParent().setLeft(son);
            }
        }
    }

    private void rightRotateTransferChildren(Node<E> node, Node<E> son) {
        node.setLeft(son.getRight());
        if (son.getRight() != nil) {
            son.getRight().setParent(node);
        }
        son.setRight(node);
    }



}
