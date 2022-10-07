class MyCalendarThree {
    
    private class SegmentTree {
        public Node root;
        public SegmentTree(int n) {
            root = new Node(0, n);
        }

        public void update(int L, int R, Node curr) {
            if (L <= curr.lo && R >= curr.hi) {
                curr.lazy += 1;
            }
            
            push(curr);
            
            if (L <= curr.lo && R >= curr.hi || L > curr.hi || R < curr.lo) {
                return;
            }

            update(L, R, curr.left);
            update(L, R, curr.right);

            curr.maxi = Math.max(curr.left.maxi, curr.right.maxi);
        }

        public int query(int L, int R, Node curr) {
            push(curr);

            if (L > curr.hi || R < curr.lo) {
                return 0;
            }

            if (L <= curr.lo && R >= curr.hi) {
                return curr.maxi;
            }

            return Math.max(query(L, R, curr.left), query(L, R, curr.right));
        }

        public void push(Node curr) {
            curr.maxi += curr.lazy;

            if (curr.lo != curr.hi) {
                int mid = (curr.lo + curr.hi) / 2;
                if (curr.left == null) {
                    curr.left = new Node(curr.lo, mid);
                }

                if (curr.right == null) {
                    curr.right = new Node(mid+1, curr.hi);
                }

                curr.left.lazy += curr.lazy;
                curr.right.lazy += curr.lazy;
            }

            curr.lazy = 0;
        }
    }

    private class Node {
        public Node left;
        public Node right;
        public int lo;
        public int hi;
        public int lazy;
        public int maxi;

        public Node(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }
    }
    
    private SegmentTree tree;
    private Node root;
    private int mini = 999999999;
    private int maxi = 0;

    public MyCalendarThree() {
        tree = new SegmentTree(1_000_000_000);
        root = tree.root;
    }
    
    public int book(int start, int end) {
        tree.update(start, end - 1, root);
        return root.maxi;
    }
}