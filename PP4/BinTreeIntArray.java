import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {


        int i = 0;

        while (i < _tree.length) {

            if (_tree[i] == null) {
                _tree[i] = value;
                break;
            }

            if (value < _tree[i]) {
                i = 2 * i + 1;
            } else {
                i = 2 * i + 2;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        Stack<Integer> stack = new Stack<>();

        if (_tree[0] != null) {
            stack.push(0);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            System.out.print(_tree[idx] + " ");

            int right = 2 * idx + 2;
            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }

            int left = 2 * idx + 1;
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        if (_tree[0] != null) {
            s1.push(0);
        }

        while (!s1.isEmpty()) {
            int idx = s1.pop();
            s2.push(idx);

            int left = 2 * idx + 1;
            if (left < _tree.length && _tree[left] != null) {
                s1.push(left);
            }

            int right = 2 * idx + 2;
            if (right < _tree.length && _tree[right] != null) {
                s1.push(right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(_tree[s2.pop()] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
