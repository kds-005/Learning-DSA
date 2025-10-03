import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // N : len(nums), K: val of k
        // Time Complexity: O(N * K)
        // Space Complexity: O(N) -> only the Output Array
        // int n = nums.length;
        // ArrayList<Integer> maxValue = new ArrayList<>();
        // for (int i=0; i<n-k+1; i++){
        //     int maxWindow = Integer.MIN_VALUE;
        //     for (int j=i; j<i+k; j++){
        //         maxWindow = Math.max(maxWindow, nums[j]);
        //     }
        //     maxValue.add(maxWindow);
        // }
        // return maxValue.stream().mapToInt(i->i).toArray();
        

        // N : len(nums), K: val of k
        // Time Complexity: O(N logN)
        // Space Complexity: O(N)
        // int n = nums.length;
        // ArrayList<Integer> maxValue = new ArrayList<>();
        // PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
        //     (a, b) -> Integer.compare(b.get(0), a.get(0))
        // );
        // for (int i=0; i<n; i++){
        //     maxHeap.offer(Arrays.asList(nums[i], i));
        //     if (i + 1 >= k){
        //         while (maxHeap.size() > 0 && maxHeap.peek().get(1) <= i - k) maxHeap.poll();
        //         maxValue.add(maxHeap.peek().get(0));
        //     }
        // }
        // return maxValue.stream().mapToInt(i->i).toArray();


        // N : len(nums), K: val of k
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = nums.length;
        ArrayList<Integer> maxValue = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        while (r < n){
            while (queue.size() > 0 && nums[queue.getLast()] < nums[r]) queue.pollLast();
            queue.offer(r);
            
            l = queue.getFirst();
            if ((r - l + 1) > k){
                queue.poll();
                l = queue.getFirst();
            }
            if (r + 1 >= k) maxValue.add(nums[queue.getFirst()]);
            r++;
        }
        return maxValue.stream().mapToInt(i->i).toArray();
    }
}