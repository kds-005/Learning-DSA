import java.util.*;
import java.lang.Math;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // N : len(arr), K : val of k
        // Time Complexity: O(N)
        // Space Complxity: O(2K)
        // int n = arr.length;
        // ArrayDeque<Integer> q = new ArrayDeque<>();
        // List<Integer> result = new ArrayList<>();
        // int currSum = 0;
        // int minDiff = Integer.MAX_VALUE;
        // for (int i=0; i<n; i++){
        //     q.offer(arr[i]);
        //     currSum += Math.abs(arr[i] - x);
        //     if (q.size() > k) currSum -= Math.abs(q.poll() - x);
        //     if (q.size() == k && currSum < minDiff){
        //         minDiff = currSum;
        //         result = new ArrayList<>(q);
        //     }
        // }
        // return result;


        // N : len(arr), K : val of k
        // Time Complexity: O(Log N + K)
        // Space Complexity: O(K)
        // int n = arr.length;
        // int l = 0;
        // int r = n - 1;
        // while (l < r){
        //     int mid = (r + l) / 2;
        //     if (arr[mid] < x) l = mid + 1;
        //     else r = mid;
        // }
        // int mid = (l - 1 >= 0 && Math.abs(x - arr[l - 1]) <= Math.abs(x - arr[l])) ? l - 1 : l;
        // l = r = mid;
        // while ((r - l + 1) < k){
        //     int lSum = Integer.MAX_VALUE;
        //     int rSum = Integer.MAX_VALUE;
            
        //     if (l - 1 >= 0) lSum = Math.abs(x - arr[l - 1]);
        //     if (r + 1 < n) rSum = Math.abs(x - arr[r + 1]);
        //     if (lSum <= rSum) l--; 
        //     else r++;
        // }
        // return Arrays.stream(Arrays.copyOfRange(arr, l, r + 1)).boxed().toList();



        // N : len(arr), K : val of k
        // Time Complexity: O(Log (N - K) + K)
        // Space Complexity: O(K)
        int n = arr.length;
        int l = 0;
        int r = n - k;
        while (l < r){
            int mid = (r + l) / 2;
            if (x - arr[mid] > arr[mid + k] - x) l = mid + 1;
            else r = mid;
        }
        return Arrays.stream(Arrays.copyOfRange(arr, l, l + k)).boxed().toList();
    }
}