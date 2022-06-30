package gof.behavioural.iterator;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<T> {
    @Data
    class BinaryTreeNode<T> {
        private T value;
        private BinaryTreeNode<T> left = null;
        private BinaryTreeNode<T> right = null;

        public BinaryTreeNode(T value) {
            this.value = value;
        }
    }
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T rootValue) {
        this.root = new BinaryTreeNode<>(rootValue);
    }

    public Iterator<BinaryTreeNode<T>> iterator(BinaryTreeTraversal.BinaryTreeTraversalMethod type) {
        return new Iterator<>() {
            private List<BinaryTreeNode<T>> order = order = new ArrayList<>();;
            private int index = 0;

            {
                type.traverse(root, order);
            }

            @Override
            public boolean hasNext() {
                return index < order.size();
            }

            @Override
            public BinaryTreeNode<T> next() {
                if (index == order.size()) {
                    return null;
                } else {
                    return order.get(++index);
                }
            }
        };
    }
}
