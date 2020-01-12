package task5.p4.model;

import java.util.List;

public class RBTree<E extends Comparable<E>> {
    private final Node<E> nil;
    private Node<E> root;
    private RBTreeTraverser<E> treeTraverser;

    {
        nil = new Node<>();
        nil.setParent(nil);
        nil.setRight(nil);
        nil.setLeft(nil);
        root = nil;
        treeTraverser = new RBTreeTraverser<>(nil);
    }

    public void generateFromArray(E[] array) {
        root = nil;
        for (E element : array) {
            add(element);
        }
    }

    public List<E> traverse(TraverseType type) {
        return treeTraverser.traverse(root, type);
    }

    public void add(E key) {
        Node<E> node = createNode(key);
        linkNodeToTree(node.getParent(), node);
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

    private void linkNodeToTree(Node<E> parent, Node<E> node) {
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
        while (node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                Node<E> uncle = node.getParent().getParent().getRight();
                if (uncle.isRed()) {
                    node.getParent().setIsRed(false);
                    uncle.setIsRed(false);
                    node.getParent().getParent().setIsRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().setIsRed(false);
                    node.getParent().getParent().setIsRed(true);
                    rightRotate(node.getParent().getParent());
                }
            } else {
                Node<E> uncle = node.getParent().getParent().getLeft();
                if (uncle.isRed()) {
                    node.getParent().setIsRed(false);
                    uncle.setIsRed(false);
                    node.getParent().getParent().setIsRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setIsRed(false);
                    node.getParent().getParent().setIsRed(true);
                    leftRotate(node.getParent().getParent());
                }
            }
        }
        root.setIsRed(false);
    }

    private void leftRotate(Node<E> node) {
        Node<E> son = node.getRight();
        leftRotateTransferChildren(node, son);
        leftRotateUpdateLinkFromGrandParent(node, son);
        son.setParent(node.getParent());
        node.setParent(son);
    }

    private void rightRotate(Node<E> node) {
        Node<E> son = node.getLeft();
        rightRotateTransferChildren(node, son);
        rightRotateUpdateLinkFromGrandParent(node, son);
        son.setParent(node.getParent());
        node.setParent(son);
    }

    private void leftRotateTransferChildren(Node<E> node, Node<E> son) {
        node.setRight(son.getLeft());
        if (son.getLeft() != nil) {
            son.getLeft().setParent(node);
        }
        son.setLeft(node);
    }

    private void rightRotateTransferChildren(Node<E> node, Node<E> son) {
        node.setLeft(son.getRight());
        if (son.getRight() != nil) {
            son.getRight().setParent(node);
        }
        son.setRight(node);
    }

    private void leftRotateUpdateLinkFromGrandParent(Node<E> node, Node<E> son) {
        Node<E> grandparent = node.getParent();
        if (grandparent == nil) {
            root = son;
        } else {
            if (grandparent.getLeft() == node) {
                grandparent.setLeft(son);
            } else {
                grandparent.setRight(son);
            }
        }
    }

    private void rightRotateUpdateLinkFromGrandParent(Node<E> node, Node<E> son) {
        Node<E> grandparent = node.getParent();
        if (grandparent == nil) {
            root = son;
        } else {
            if (grandparent.getRight() == node) {
                grandparent.setRight(son);
            } else {
                grandparent.setLeft(son);
            }
        }
    }
}
