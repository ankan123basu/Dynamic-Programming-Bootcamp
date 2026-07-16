// 740. Delete and Earn

// Recursion 
// class Solution {  // O(2^n) O(n)

//     public int deleteAndEarn(int[] nums) {

//         int max = 0;

//         for (int x : nums)
//             max = Math.max(max, x);

//         int points[] = new int[max + 1];

//         for (int x : nums)
//             points[x] += x;

//         return solve(0, points);
//     }

//     int solve(int i, int points[]) {

//         if (i >= points.length)
//             return 0;

//         int pick = points[i] + solve(i + 2, points);

//         int notPick = solve(i + 1, points);

//         return Math.max(pick, notPick);
//     }
// }



// class Solution {  // Recursion + Memoization O(n) O(n)

//     public int deleteAndEarn(int[] nums) {

//         int max = 0;

//         for (int x : nums)
//             max = Math.max(max, x);

//         int points[] = new int[max + 1];

//         for (int x : nums)
//             points[x] += x;

//         int dp[] = new int[max + 1];

//         Arrays.fill(dp, -1);

//         return solve(0, points, dp);
//     }

//     int solve(int i, int points[], int dp[]) {

//         if (i >= points.length)
//             return 0;

//         if (dp[i] != -1)
//             return dp[i];

//         int pick = points[i] + solve(i + 2, points, dp);

//         int notPick = solve(i + 1, points, dp);

//         dp[i] = Math.max(pick, notPick);

//         return dp[i];
//     }
// }


// Tabulation O(n) O(n)
// class Solution {

//     public int deleteAndEarn(int[] nums) {

//         int max = 0;

//         for (int x : nums)
//             max = Math.max(max, x);

//         int points[] = new int[max + 1];

//         for (int x : nums)
//             points[x] += x;

//         int dp[] = new int[max + 3];

//         for (int i = max; i >= 0; i--) {

//             int pick = points[i] + dp[i + 2];

//             int notPick = dp[i + 1];

//             dp[i] = Math.max(pick, notPick);
//         }

//         return dp[0];
//     }
// }


// Space Optimization O(n) O(1)
class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int x : nums)
            max = Math.max(max, x);

        int points[] = new int[max + 1];

        for (int x : nums)
            points[x] += x;

        int next1 = 0;  // dp[i+1]
        int next2 = 0; // dp[i+2]

        for (int i = max; i >= 0; i--) {

            int curr = Math.max(points[i] + next2, next1);

            next2 = next1;

            next1 = curr;
        }

        return next1;
    }
}