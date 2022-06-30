package gof.behavioural.iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.BiConsumer;

@Getter
public abstract class BinaryTreeTraversal<T> {
    @AllArgsConstructor
    class BinaryTreeTraversalMethod {
        private BiConsumer<BinaryTree<T>.BinaryTreeNode<T>, List<BinaryTree<T>.BinaryTreeNode<T>>> func;
        public void traverse(BinaryTree<T>.BinaryTreeNode<T> node, List<BinaryTree<T>.BinaryTreeNode<T>> out) {
            func.accept(node, out);
        }
    }

    private final BinaryTreeTraversalMethod inOrder = new BinaryTreeTraversalMethod(BinaryTreeTraversal::inOrderTraversal);
    private final BinaryTreeTraversalMethod preOrder = new BinaryTreeTraversalMethod(BinaryTreeTraversal::preOrderTraversal);;
    private final BinaryTreeTraversalMethod postOrder = new BinaryTreeTraversalMethod(BinaryTreeTraversal::postOrderTraversal);;
    private static <T> void inOrderTraversal(BinaryTree<T>.BinaryTreeNode<T> node, List<BinaryTree<T>.BinaryTreeNode<T>> out) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), out);
        }
        out.add(node);
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), out);
        }
    }

    private static <T> void preOrderTraversal(BinaryTree<T>.BinaryTreeNode<T> node, List<BinaryTree<T>.BinaryTreeNode<T>> out) {
        out.add(node);
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), out);
        }
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), out);
        }
    }

    private static <T> void postOrderTraversal(BinaryTree<T>.BinaryTreeNode<T> node, List<BinaryTree<T>.BinaryTreeNode<T>> out) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), out);
        }
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), out);
        }
        out.add(node);
    }
}
