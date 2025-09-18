class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // N : len(people)
        // Time Complexity: O(N logN + N)
        // Space Complexity: O(1)
        // int n = people.length;
        // Arrays.sort(people);
        // int boatCount = 0;
        // int l = 0;
        // int r = n - 1;
        // while (l <= r){
        //     boatCount++;
        //     int totalWeight = people[l] + people[r];
        //     if (totalWeight > limit){
        //         r--;
        //     } else{
        //         l++;
        //         r--;
        //     }
        // }
        // return boatCount;



        // N : len(people), M : limit
        // Time Complexity: O(2N + M)
        // Space Complexity: O(M)
        int n = people.length;
        int maxPeople = 0;
        for (int p: people){
            maxPeople = Math.max(maxPeople, p);
        }

        int[] peopleCount = new int[maxPeople + 1];
        for (int p: people){
            peopleCount[p]++;
        }

        int boatCount = 0;
        int l = 0;
        int r = maxPeople;
        while (l <= r){
            while (l <= r && peopleCount[l] == 0) l++;
            while (l <= r && peopleCount[r] == 0) r--;
            if (l > r) break;

            int totalWeight = r + l;
            if (totalWeight > limit){
                boatCount += peopleCount[r];
                peopleCount[r] = 0;
            } else{
                boatCount++;
                if (peopleCount[l] != 0) peopleCount[l]--;
                if (peopleCount[r] != 0) peopleCount[r]--;
            }
        }
        return boatCount;
    }
}