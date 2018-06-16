package leetcode.success.tree;

public class RBTree<T extends Comparable<T>> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBTNode<T> mRoot;

    private void setBlack(RBTNode<T> node) {
        if (node != null)
            node.color = BLACK;
    }

    private void setRed(RBTNode<T> node) {
        if (node != null)
            node.color = RED;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean isRed(RBTNode<T> node) {
        return ((node != null) && (node.color == RED));
    }

    private boolean isBlack(RBTNode<T> node) {
        return ((node != null) && (node.color == BLACK));
    }

    private void preOrder(RBTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(this.mRoot);
    }

    private void inOrder(RBTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(this.mRoot);
    }

    private void postOrder(RBTNode<T> tree) {
        if (tree != null) {

            preOrder(tree.left);
            preOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(this.mRoot);
    }

    private RBTNode<T> search(RBTNode<T> x, T key) {
        if (x == null) {
            return x;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public RBTNode<T> search(T key) {
        return search(this.mRoot, key);
    }

    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(this.mRoot, key);
    }

    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while (tree.left != null) {
            tree = tree.left;
        }

        return tree;
    }

    public T minimum() {
        RBTNode<T> p = minimum(this.mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;

    }

    public T maximum() {
        RBTNode<T> p = maximum(this.mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    public RBTNode<T> successor(RBTNode<T> x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public RBTNode<T> predcessor(RBTNode<T> x) {
        if (x.left != null) {
            return maximum(x.left);
        }
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /*
     * left rotate
     * px px
     * / /
     * x y
     * / \ --left rotate / \ #
     * lx y x ry
     * / \ / \
     * ly ry lx ly
     */
    private void leftRotate(RBTNode<T> x) {
        RBTNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    /*
     * right rotate
     * py py
     * / /
     * y x
     * / \ --right -. / \ #
     * x ry lx y
     * / \ / \ #
     * lx rx rx ry
     */
    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }

        x.right = y;
        y.parent = x;
    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);
            if (parent == gparent.left) {
                RBTNode<T> uncle = gparent.right;
//				if ((uncle != null) && isRed(uncle)) {
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                RBTNode<T> uncle = gparent.left;
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(this.mRoot);
    }

    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.mRoot = node;
        }

        node.color = RED;

        insertFixUp(node);
    }

    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;

        while (((node == null) || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left == null) || isBlack(other.left) && (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(parent);
                } else {
                    if (other.right == null || isBlack(other.right)) {
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {
                other = parent.left;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if ((other.left == null || isBlack(other.left)) && (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(parent);
                } else {
                    if (other.left == null || isBlack(other.left)) {
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }

        if (node != null) {
            setBlack(node);
        }
    }

    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;

        boolean color;

        if (node.left != null && node.right != null) {
            RBTNode<T> replace = node;
            replace = replace.right;
            while (replace.left != null) {
                replace = replace.left;
            }

            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.mRoot = replace;
            }

            child = replace.right;
            parent = parentOf(replace);
            color = colorOf(replace);
            if (parent == node) {
                parent = replace;
            } else {
                if (child != null) {
                    setParent(child, parent);
                }
                parent.left = child;

                replace.right = node.right;
                setParent(node.right, replace);
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK) {
                removeFixUp(child, parent);
            }
            node = null;
            return;


        }

        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        color = node.color;
        if (child != null) {
            child.parent = parent;
        }
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            this.mRoot = child;
        }

        if (color == BLACK) {
            removeFixUp(child, parent);
        }
        node = null;
    }

    public void remove(T key) {
        RBTNode<T> node;

        if ((node = search(mRoot, key)) != null) {
            remove(node);
        }
    }

    private void destory(RBTNode<T> tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            destory(tree.left);
        }
        if (tree.right != null) {
            destory(tree.right);
        }
        tree = null;
    }

    public void clear() {
        destory(mRoot);
        mRoot = null;
    }

    private void print(RBTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {
                System.out.printf("%2d(B) is root\n", tree.key);
            } else {
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree) ? "R" : "B", key, direction == 1 ? "right" : "left");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }


}

class RBTNode<T extends Comparable<T>> {
    boolean color;
    T key;
    RBTNode<T> left;
    RBTNode<T> right;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public RBTNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBTNode<T> left) {
        this.left = left;
    }

    public RBTNode<T> getRight() {
        return right;
    }

    public void setRight(RBTNode<T> right) {
        this.right = right;
    }

    public RBTNode<T> getParent() {
        return parent;
    }

    public void setParent(RBTNode<T> parent) {
        this.parent = parent;
    }

    RBTNode<T> parent;

    public RBTNode(T key, boolean color, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
