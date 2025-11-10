/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // N : len(mountainArr)
        // Time Complexity : O(N)
        // Space Complexity: O(1)
        // int n = mountainArr.length();
        // for (int i = 0; i < n; i++) {
        //     if (target == mountainArr.get(i)) return i;
        // }
        // return -1;


        // N : len(mountainArr)
        // Time Complexity : O(logN)
        // Space Complexity: O(1)
        int n = mountainArr.length();
        int l = 1;
        int r = n - 2;
        int peakPos = -1;
        while (l <= r) {
            int mid = (r + l) / 2;

            int left = mountainArr.get(mid - 1);
            int middle = mountainArr.get(mid);
            int right = mountainArr.get(mid + 1);

            if (left < middle && middle < right) l = mid + 1;
            else if (left > middle && middle > right) r = mid - 1;
            else if (left < middle && middle > right) {
                peakPos = mid;
                break;
            }
        }

        l = 0;
        r = peakPos - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target < mountainArr.get(mid)) r = mid - 1;
            else if (target > mountainArr.get(mid)) l = mid + 1;
            else return mid;
        }

        l = peakPos;
        r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target < mountainArr.get(mid)) l = mid + 1;
            else if (target > mountainArr.get(mid)) r = mid - 1;
            else return mid;
        }
        return -1;
    }
}