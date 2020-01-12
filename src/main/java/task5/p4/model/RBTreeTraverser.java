package task5.p4.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RBTreeTraverser<E> {
    private Node<E> nil;

    public RBTreeTraverser(Node<E> nil) {
        this.nil = nil;
    }

    public List<E> traverse(Node<E> root, TraverseType type) {
        List<E> viewed = new LinkedList<>();
        if (root != nil) {
            switch (type) {
                case INORDER:
                    return traverseFromNodeInOrder(root, viewed);
                case PREORDER:
                    return traverseFromNodePreOrder(root, viewed);
                case POSTORDER:
                    return traverseFromNodePostOrder(root, viewed);
                case BYLEVEL:
                    return traverseByLevels(root, viewed);
            }
        }
        return viewed;
    }

    private List<E> traverseFromNodeInOrder(Node<E> node, List<E> viewed) {
        if (node.getLeft() != nil) {
            viewed = traverseFromNodeInOrder(node.getLeft(), viewed);
        }
        viewed.add(node.getKey());
        if (node.getRight() != nil) {
            viewed = traverseFromNodeInOrder(node.getRight(), viewed);
        }
        return viewed;
    }

    private List<E> traverseFromNodePreOrder(Node<E> node, List<E> viewed) {
        viewed.add(node.getKey());
        if (node.getLeft() != nil) {
            viewed = traverseFromNodeInOrder(node.getLeft(), viewed);
        }
        if (node.getRight() != nil) {
            viewed = traverseFromNodeInOrder(node.getRight(), viewed);
        }
        return viewed;
    }

    private List<E> traverseFromNodePostOrder(Node<E> node, List<E> viewed) {
        if (node.getLeft() != nil) {
            viewed = traverseFromNodeInOrder(node.getLeft(), viewed);
        }
        if (node.getRight() != nil) {
            viewed = traverseFromNodeInOrder(node.getRight(), viewed);
        }
        viewed.add(node.getKey());
        return viewed;
    }

    private List<E> traverseByLevels(Node<E> root, List<E> viewed) {
        Queue<Node<E>> queue = new LinkedList<>();
        if (root != nil) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> node = queue.poll();
                viewed.add(node.getKey());
                if (node.getLeft() != nil) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != nil) {
                    queue.add(node.getRight());
                }
            }
        }
        return viewed;
    }
}
