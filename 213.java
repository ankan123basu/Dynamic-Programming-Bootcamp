// HOUSE ROBBER II

// class Solution {     // O(2^N)  O(N)  // Recursion

//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1)
//             return nums[0];

//         return Math.max(
//                 solve(nums, 0, n - 2),
//                 solve(nums, 1, n - 1)
//         );
//     }

//     int solve(int nums[], int i, int end) {

//         if (i > end)
//             return 0;

//         int pick = nums[i] + solve(nums, i + 2, end);

//         int notPick = solve(nums, i + 1, end);

//         return Math.max(pick, notPick);
//     }
// }


// class Solution {   // O(N)  O(N)  // Memoization

//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1)
//             return nums[0];

//         int dp1[] = new int[n];
//         int dp2[] = new int[n];

//         Arrays.fill(dp1, -1);
//         Arrays.fill(dp2, -1);

//         int case1 = solve(nums, 0, n - 2, dp1);

//         int case2 = solve(nums, 1, n - 1, dp2);

//         return Math.max(case1, case2);
//     }

//     int solve(int nums[], int i, int end, int dp[]) {

//         if (i > end)
//             return 0;

//         if (dp[i] != -1)
//             return dp[i];

//         int pick = nums[i] + solve(nums, i + 2, end, dp);

//         int notPick = solve(nums, i + 1, end, dp);

//         dp[i] = Math.max(pick, notPick);

//         return dp[i];
//     }
// }

// class Solution { 

//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1)
//             return nums[0];

//         return Math.max(
//                 tab(nums, 0, n - 2),
//                 tab(nums, 1, n - 1)
//         );
//     }

//     int tab(int nums[], int start, int end) {

//         int dp[] = new int[nums.length + 2];

//         for (int i = end; i >= start; i--) {

//             int pick = nums[i] + dp[i + 2];

//             int notPick = dp[i + 1];

//             dp[i] = Math.max(pick, notPick);
//         }

//         return dp[start];
//     }
// }

// Space Optimization  // O(N)  O(1)
class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1)
        );
    }

    int robLinear(int nums[], int start, int end) {

        int next1 = 0; // dp[i+1]
        int next2 = 0; // dp[i+2]

        for (int i = end; i >= start; i--) {

            int curr = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}