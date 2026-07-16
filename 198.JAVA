// 198. House Robber 1

// // Recursion 
// class Solution {

//     public int rob(int[] nums) {
//         return solve(0, nums);
//     }

//     int solve(int i, int nums[]) {
//         // Base case
//         if (i >= nums.length)
//             return 0;

//         // Pick curr
//         int pick = nums[i] + solve(i + 2, nums);

//         // Skip curr
//         int notPick = solve(i + 1, nums);

//         return Math.max(pick, notPick);
//     }
// }



 // Memoization (Top-down DP)  // O(N)  O(N)
//  import java.util.Arrays;

// class Solution {

//     public int rob(int[] nums) {

//         int dp[] = new int[nums.length];

//         Arrays.fill(dp, -1);

//         return solve(0, nums, dp);
//     }

//     int solve(int i, int nums[], int dp[]) {

//         if (i >= nums.length)
//             return 0;

//         if (dp[i] != -1)
//             return dp[i];

//         int pick = nums[i] + solve(i + 2, nums, dp);

//         int notPick = solve(i + 1, nums, dp);

//         dp[i] = Math.max(pick, notPick);

//         return dp[i];
//     }
// }


// Tabulation (Bottom-up DP)  // O(N)  O(N)
// class Solution {

//     public int rob(int[] nums) {

//         int n = nums.length;

//         int dp[] = new int[n + 2];

//         for (int i = n - 1; i >= 0; i--) {

//             int pick = nums[i] + dp[i + 2];

//             int notPick = dp[i + 1];

//             dp[i] = Math.max(pick, notPick);
//         }

//         return dp[0];
//     }
// }


// Space Optimization  // O(N)  O(1)
class Solution {

    public int rob(int[] nums) {

        int next1 = 0; // dp[i+1]
        int next2 = 0; // dp[i+2]

        for (int i = nums.length - 1; i >= 0; i--) {

            int curr = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}



