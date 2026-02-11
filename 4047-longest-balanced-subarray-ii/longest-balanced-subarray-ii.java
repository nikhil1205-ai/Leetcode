import java.util.*;

class Solution {

    // even -> +1 , odd -> -1
    private int parity(int x) {
        return (x & 1) == 0 ? 1 : -1;
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;

        // prefix sum where each number contributes only once
        int[] prefix = new int[n];

        // store all positions of each number (1-based)
        Map<Integer, Queue<Integer>> positions = new HashMap<>();

        prefix[0] = parity(nums[0]);
        positions.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            Queue<Integer> q = positions.computeIfAbsent(nums[i], k -> new LinkedList<>());
            if (q.isEmpty()) {
                prefix[i] += parity(nums[i]);
            }
            q.add(i + 1);
        }

        SegmentTree seg = new SegmentTree(prefix);
        int ans = 0;

        for (int left = 0; left < n; left++) {
            int right = seg.findLastZero(left + ans + 1);
            if (right != -1) {
                ans = Math.max(ans, right - left);
            }

            Queue<Integer> q = positions.get(nums[left]);
            q.poll();

            int next = q.isEmpty() ? n + 1 : q.peek();
            seg.addRange(left + 1, next - 1, -parity(nums[left]));
        }

        return ans;
    }
}

class SegmentTree {
    private int n;
    private int[] min, max, lazy;

    SegmentTree(int[] arr) {
        n = arr.length;
        min = new int[4 * n];
        max = new int[4 * n];
        lazy = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] a, int idx, int l, int r) {
        if (l == r) {
            min[idx] = max[idx] = a[l];
            return;
        }
        int m = (l + r) / 2;
        build(a, idx * 2, l, m);
        build(a, idx * 2 + 1, m + 1, r);
        pull(idx);
    }

    private void pull(int idx) {
        min[idx] = Math.min(min[idx * 2], min[idx * 2 + 1]);
        max[idx] = Math.max(max[idx * 2], max[idx * 2 + 1]);
    }

    private void apply(int idx, int val) {
        min[idx] += val;
        max[idx] += val;
        lazy[idx] += val;
    }

    private void push(int idx) {
        if (lazy[idx] != 0) {
            apply(idx * 2, lazy[idx]);
            apply(idx * 2 + 1, lazy[idx]);
            lazy[idx] = 0;
        }
    }

    void addRange(int l, int r, int val) {
        update(1, 0, n - 1, l - 1, r - 1, val);
    }

    private void update(int idx, int l, int r, int ql, int qr, int val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(idx, val);
            return;
        }
        push(idx);
        int m = (l + r) / 2;
        update(idx * 2, l, m, ql, qr, val);
        update(idx * 2 + 1, m + 1, r, ql, qr, val);
        pull(idx);
    }

    int findLastZero(int start) {
        return query(1, 0, n - 1, start - 1);
    }

    private int query(int idx, int l, int r, int ql) {
        if (r < ql || min[idx] > 0 || max[idx] < 0) return -1;
        if (l == r) return l + 1;

        push(idx);
        int m = (l + r) / 2;

        int res = query(idx * 2 + 1, m + 1, r, ql);
        if (res != -1) return res;

        return query(idx * 2, l, m, ql);
    }
}