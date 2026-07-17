// 70. Climbing stairs
// class Solution {   // Recursion  O(2^n) O(n)

//     public int climbStairs(int n) {

//         return solve(n);
//     }

//     int solve(int n){

//         if(n<=1)
//             return 1;
//         return solve(n-1)+solve(n-2);
//     }
// }


// Memoization    O(n) O(n)
// class Solution {

//     public int climbStairs(int n) {

//         int dp[] = new int[n+1];

//         Arrays.fill(dp,-1);

//         return solve(n,dp);
//     }

//     int solve(int n,int dp[]){

//         if(n<=1)
//             return 1;

//         if(dp[n]!=-1)
//             return dp[n];

//         int oneStep = solve(n-1,dp);

//         int twoStep = solve(n-2,dp);

//         dp[n]=oneStep+twoStep;

//         return dp[n];
//     }
// }

// Tabulation  O(n) O(n)
// class Solution {

//     public int climbStairs(int n) {

//         if(n<=1)
//             return 1;

//         int dp[]=new int[n+1];

//         dp[0]=1;
//         dp[1]=1;

//         for(int i=2;i<=n;i++){

//             dp[i]=dp[i-1]+dp[i-2];
//         }

//         return dp[n];
//     }
// }

// Space Optimization  O(n) O(1)
class Solution {

    public int climbStairs(int n) {

        if(n<=1)
            return 1;

        int prev2=1;
        int prev1=1;

        for(int i=2;i<=n;i++){

            int curr=prev1+prev2;

            prev2=prev1;

            prev1=curr;
        }

        return prev1;
    }
}

